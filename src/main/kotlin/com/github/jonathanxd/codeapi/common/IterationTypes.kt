/*
 *      CodeAPI - Framework to generate Java code and Bytecode code. <https://github.com/JonathanxD/CodeAPI>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2017 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/ & https://github.com/TheRealBuggy/) <jonathan.scripter@programmer.net>
 *      Copyright (c) contributors
 *
 *
 *      Permission is hereby granted, free of charge, to any person obtaining a copy
 *      of this software and associated documentation files (the "Software"), to deal
 *      in the Software without restriction, including without limitation the rights
 *      to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *      copies of the Software, and to permit persons to whom the Software is
 *      furnished to do so, subject to the following conditions:
 *
 *      The above copyright notice and this permission notice shall be included in
 *      all copies or substantial portions of the Software.
 *
 *      THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *      IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *      FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *      AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *      LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *      OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *      THE SOFTWARE.
 */
package com.github.jonathanxd.codeapi.common

import com.github.jonathanxd.codeapi.CodeAPI
import com.github.jonathanxd.codeapi.CodeSource
import com.github.jonathanxd.codeapi.MutableCodeSource
import com.github.jonathanxd.codeapi.Types
import com.github.jonathanxd.codeapi.base.ForEachStatement
import com.github.jonathanxd.codeapi.base.impl.*
import com.github.jonathanxd.codeapi.gen.PartProcessor
import com.github.jonathanxd.codeapi.literal.Literals
import com.github.jonathanxd.codeapi.operator.Operators
import com.github.jonathanxd.codeapi.sugar.SugarEnvironment
import com.github.jonathanxd.codeapi.util.CodePartUtil
import com.github.jonathanxd.codeapi.util.HiddenVariable

/**
 * Common [IterationTypes][IterationType]
 */
// TODO: Remove this and create an enum because we need better handling in the processors
object IterationTypes {

    /**
     * Iterate a array
     */
    @JvmField
    val ARRAY: IterationType = ArrayIterationType

    /**
     * Iterate a Iterable element.
     */
    @JvmField
    val ITERABLE_ELEMENT: IterationType = IterableIterationType

    object ArrayIterationType : IterationType {
        override fun createGenerator(sugarEnvironment: SugarEnvironment): IterationType.Generator = Generator(sugarEnvironment)

        class Generator(val sugarEnvironment: SugarEnvironment) : IterationType.Generator {

            override fun generate(t: ForEachStatement, processor: PartProcessor): CodeSource {
                val fieldName = sugarEnvironment.getVariableName("\$array_index")
                val indexFieldDecl = HiddenVariable(Types.INT, fieldName, Literals.INT(0))
                val accessIndex = VariableAccessImpl(
                        name = indexFieldDecl.name,
                        variableType = indexFieldDecl.type
                )

                val condition = IfExprImpl(
                        expr1 = accessIndex,
                        operation = Operators.LESS_THAN,
                        expr2 = ArrayLengthImpl(arrayType = CodePartUtil.getType(t.iterableElement), target = t.iterableElement)
                )

                val update = CodeAPI.operateAndAssign(
                        indexFieldDecl,
                        Operators.ADD,
                        Literals.INT(1)
                )

                /*
                Old way
                val update = VariableOperateImpl(
                        target = Defaults.ACCESS_LOCAL,
                        localization = null,
                        name = indexFieldDecl.name,
                        variableType = indexFieldDecl.type,
                        operation = Operators.INCREMENT,
                        value = null
                )*/

                val body = MutableCodeSource()

                val field = t.variable

                body.add(VariableDeclarationImpl(
                        name = field.name,
                        variableType = field.variableType,
                        value = ArrayLoadImpl(
                                arrayType = CodePartUtil.getType(t.iterableElement),
                                target = t.iterableElement,
                                index = accessIndex,
                                valueType = field.variableType
                        )
                ))

                body.addAll(t.body)

                return CodeSource.fromPart(ForStatementImpl(
                        forInit = indexFieldDecl,
                        forExpression = listOf(condition),
                        forUpdate = update,
                        body = body
                ))
            }
        }

    }


    object IterableIterationType : IterationType {

        override fun createGenerator(sugarEnvironment: SugarEnvironment): IterationType.Generator = Generator(sugarEnvironment)

        class Generator(val sugarEnvironment: SugarEnvironment) : IterationType.Generator {

            override fun generate(t: ForEachStatement, processor: PartProcessor): CodeSource {
                val fieldName = sugarEnvironment.getVariableName("\$iterable_iterator")

                // Iterable.iterator()Ljava/util/Iterator;
                val iterator = CodeAPI.invokeInterface(Iterable::class.java, t.iterableElement,
                        "iterator",
                        CodeAPI.typeSpec(Iterator::class.java),
                        emptyList())

                val iterFieldDecl = HiddenVariable(Types.ITERATOR, fieldName, iterator)

                val accessIter = VariableAccessImpl(
                        name = iterFieldDecl.name,
                        variableType = iterFieldDecl.type
                )

                // Iterator.hasNext()Z
                val hasNext = MethodInvocationImpl(
                        localization = Types.ITERATOR,
                        invokeType = InvokeType.INVOKE_INTERFACE,
                        target = accessIter,
                        invokeDynamic = null,
                        arguments = emptyList(),
                        spec = MethodSpecificationImpl(
                                methodName = "hasNext",
                                description = TypeSpec(Types.BOOLEAN),
                                methodType = MethodType.METHOD
                        )
                )

                val condition = IfExprImpl(
                        expr1 = hasNext,
                        operation = Operators.EQUAL_TO,
                        expr2 = Literals.TRUE
                )

                val body = MutableCodeSource()

                val field = t.variable

                // Iterator.next()Ljava/lang/Object;
                val next = MethodInvocationImpl(
                        localization = Types.ITERATOR,
                        invokeType = InvokeType.INVOKE_INTERFACE,
                        target = accessIter,
                        arguments = emptyList(),
                        invokeDynamic = null,
                        spec = MethodSpecificationImpl(
                                methodName = "next",
                                description = TypeSpec(Types.OBJECT),
                                methodType = MethodType.METHOD
                        )
                )

                // #Type Field_Name = (#Type) Iterator.next()Ljava/lang/Object;
                val eachField = VariableDeclarationImpl(
                        name = field.name,
                        variableType = field.variableType,
                        value = CastImpl(
                                originalType = Types.OBJECT,
                                castedPart = next,
                                targetType = field.variableType
                        )
                )


                body.add(eachField)

                body.addAll(t.body)

                return CodeSource.fromPart(ForStatementImpl(
                        forInit = iterFieldDecl,
                        forExpression = listOf(condition),
                        forUpdate = null,
                        body = body
                ))
            }
        }

    }
}