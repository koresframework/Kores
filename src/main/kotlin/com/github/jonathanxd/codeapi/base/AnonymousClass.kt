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
package com.github.jonathanxd.codeapi.base

import com.github.jonathanxd.codeapi.CodeAPI
import com.github.jonathanxd.buildergenerator.Defaults
import com.github.jonathanxd.buildergenerator.annotation.DefaultImpl
import com.github.jonathanxd.buildergenerator.annotation.MethodRef
import com.github.jonathanxd.codeapi.CodePart
import com.github.jonathanxd.codeapi.CodeSource
import com.github.jonathanxd.codeapi.annotation.Concrete
import com.github.jonathanxd.codeapi.builder.invoke
import com.github.jonathanxd.codeapi.common.CodeModifier
import com.github.jonathanxd.codeapi.common.TypeSpec
import com.github.jonathanxd.codeapi.generic.GenericSignature
import com.github.jonathanxd.codeapi.type.CodeType
import com.github.jonathanxd.codeapi.util.self
import java.lang.reflect.Type

@Concrete
interface AnonymousClass : TypeDeclaration, SuperClassHolder, ArgumentHolder {

    override val array: Boolean
        get() = false

    override val modifiers: Set<CodeModifier>
        get() = setOf(CodeModifier.PACKAGE_PRIVATE)

    override val types: List<Type>
        get() = this.constructorSpec.parameterTypes

    override val genericSignature: GenericSignature
        get() = GenericSignature.empty()

    /**
     * Specification of constructor to invoke.
     */
    val constructorSpec: TypeSpec

    /**
     * Arguments to pass to [constructor][constructorSpec].
     */
    override val arguments: List<CodePart>

    /**
     * Constructor body of anonymous class
     */
    val constructorBody: CodeSource

    override fun builder(): Builder<AnonymousClass, *> = CodeAPI.getBuilderProvider()(this)

    interface Builder<out T : AnonymousClass, S : Builder<T, S>> :
            TypeDeclaration.Builder<T, S>,
            SuperClassHolder.Builder<T, S>,
            ArgumentHolder.Builder<T, S> {

        @DefaultImpl(MethodRef(value = Defaults::class, name = "self"))
        override fun withOuterClass(value: CodeType?): S = self()
        override fun withModifiers(value: Set<CodeModifier>): S = self()
        override fun withModifiers(vararg values: CodeModifier): S = self()
        override fun withArray(value: Boolean): S = self()
        override fun withOuterClass(value: Type?): S = self()
        override fun withGenericSignature(value: GenericSignature): S = self()

        /**
         * See [T.constructorSpec]
         */
        fun withConstructorSpec(value: TypeSpec): S

        /**
         * See [T.constructorBody]
         */
        fun withConstructorBody(value: CodeSource): S

    }

}