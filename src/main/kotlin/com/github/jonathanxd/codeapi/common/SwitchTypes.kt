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

import com.github.jonathanxd.codeapi.base.Case
import com.github.jonathanxd.codeapi.base.SwitchStatement
import com.github.jonathanxd.codeapi.base.Typed
import com.github.jonathanxd.codeapi.base.impl.CastImpl
import com.github.jonathanxd.codeapi.base.impl.MethodInvocationImpl
import com.github.jonathanxd.codeapi.base.impl.MethodSpecificationImpl
import com.github.jonathanxd.codeapi.builder.CaseBuilder
import com.github.jonathanxd.codeapi.builder.SwitchStatementBuilder
import com.github.jonathanxd.codeapi.gen.PartProcessor
import com.github.jonathanxd.codeapi.Types
import com.github.jonathanxd.codeapi.literal.Literals
import com.github.jonathanxd.codeapi.type.CodeType
import com.github.jonathanxd.codeapi.util.EnumTypeUtil

object SwitchTypes {

    @JvmField
    val NUMERIC = object : SwitchType {
        override val isUnique: Boolean = true

        override fun createGenerator(): SwitchType.SwitchGenerator = NumericSwitchGenerator
    }

    @JvmField
    val OBJECT = object : SwitchType {
        override fun createGenerator(): SwitchType.SwitchGenerator = ObjectSwitchGenerator
    }

    @JvmField
    val STRING = OBJECT

    @JvmField
    val ENUM = object : SwitchType {
        override fun createGenerator(): SwitchType.SwitchGenerator = EnumSwitchGenerator

    }

    private object NumericSwitchGenerator : SwitchType.SwitchGenerator() {

        private fun autoUnboxing(part: Typed, type: CodeType): Typed {
            if (!type.isPrimitive) {
                return CastImpl(type, Types.INT, part)
            }

            return part
        }

        private fun isAcceptable(type: CodeType?): Boolean {
            return type != null && (type.`is`(Types.CHAR)
                    || type.`is`(Types.BYTE)
                    || type.`is`(Types.SHORT)
                    || type.`is`(Types.INT)
                    || !type.isPrimitive && isAcceptable(type.primitiveType))
        }

        override fun generate(t: SwitchStatement, processor: PartProcessor): SwitchStatement {
            val part = t.value
            val type = t.value.type!!

            if (isAcceptable(type)) {
                return SwitchStatementBuilder(t).withValue(autoUnboxing(part, type)).build()
            }


            throw IllegalArgumentException("Cannot switch part '${t.value}' of type: '$type'. The part is not numeric.")
        }
    }

    private object ObjectSwitchGenerator : SwitchType.SwitchGenerator() {

        override fun translateSwitch(aSwitch: SwitchStatement): SwitchStatement {
            return this.translate(aSwitch)
        }

        override fun translateCase(aCase: Case, aSwitch: SwitchStatement): Case {

            if (aCase.isDefault)
                return aCase

            if (aCase.type!!.`is`(Types.INT))
                return aCase

            return CaseBuilder(aCase).withValue(Literals.INT(EnumTypeUtil.resolve(aCase.value, aSwitch))).build()
        }


        private fun translate(aSwitch: SwitchStatement): SwitchStatement {
            return SwitchStatementBuilder(aSwitch).withValue(
                    MethodInvocationImpl(
                            localization = Types.OBJECT,
                            invokeType = InvokeType.INVOKE_VIRTUAL,
                            target = aSwitch.value,
                            invokeDynamic = null,
                            arguments = emptyList(),
                            spec = MethodSpecificationImpl(
                                    methodName = "hashCode",
                                    description = TypeSpec(Types.INT),
                                    methodType = MethodType.METHOD
                            )

                    )
            ).build()
        }
    }

    private object EnumSwitchGenerator : SwitchType.SwitchGenerator() {

        override fun translateSwitch(aSwitch: SwitchStatement): SwitchStatement {
            return this.translate(aSwitch)
        }

        override fun translateCase(aCase: Case, aSwitch: SwitchStatement): Case {
            if (aCase.isDefault)
                return aCase

            return CaseBuilder(aCase).withValue(Literals.INT(EnumTypeUtil.resolve(aCase.value!!, aSwitch))).build()
        }

        private fun translate(aSwitch: SwitchStatement): SwitchStatement {
            return SwitchStatementBuilder(aSwitch)
                    .withValue(
                            MethodInvocationImpl(
                                    localization = Types.ENUM,
                                    invokeType = InvokeType.INVOKE_VIRTUAL,
                                    target = aSwitch.value,
                                    invokeDynamic = null,
                                    arguments = emptyList(),
                                    spec = MethodSpecificationImpl(
                                            methodName = "ordinal",
                                            description = TypeSpec(Types.INT),
                                            methodType = MethodType.METHOD
                                    )

                            )

                    )
                    .build()
        }

    }
}