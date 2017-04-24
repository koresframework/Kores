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
import com.github.jonathanxd.codeapi.CodePart
import com.github.jonathanxd.codeapi.annotation.Concrete
import com.github.jonathanxd.codeapi.builder.invoke
import com.github.jonathanxd.codeapi.common.InvokeDynamic
import com.github.jonathanxd.codeapi.common.InvokeType
import com.github.jonathanxd.codeapi.common.MethodTypeSpec
import com.github.jonathanxd.codeapi.util.self
import java.lang.reflect.Type

/**
 * Invokes a method.
 */
data class MethodInvocation(override val invokeType: InvokeType,
                            override val target: CodePart,
                            override val spec: MethodTypeSpec,
                            override val arguments: List<CodePart>) : MethodInvocationBase

/**
 * Invokes a method.
 */
@Concrete
interface MethodInvocationBase : Accessor, ArgumentHolder, Typed {

    override val types: List<Type>
        get() = this.spec.typeSpec.parameterTypes

    override val array: Boolean
        get() = false

    /**
     * Method localization
     */
    override val localization: Type
        get() = this.spec.localization

    /**
     * Method arguments
     */
    override val arguments: List<CodePart>

    /**
     * Method return type
     */
    override val type: Type
        get() = this.spec.typeSpec.returnType

    /**
     * Specification of the method
     */
    val spec: MethodTypeSpec

    /**
     * Type of method invocation
     */
    val invokeType: InvokeType

    override fun builder(): Builder<MethodInvocationBase, *> = CodeAPI.getBuilderProvider()(this)

    interface Builder<out T : MethodInvocationBase, S : Builder<T, S>> :
            Accessor.Builder<T, S>,
            ArgumentHolder.Builder<T, S>,
            Typed.Builder<T, S> {

        override fun withArray(value: Boolean): S = self()

        @Suppress("UNCHECKED_CAST")
        override fun withType(value: Type): S {
            val spec = this.spec ?: throw IllegalStateException("No method description defined")

            return this.withSpec(spec.builder().withTypeSpec(spec.typeSpec.copy(returnType = value)).build())
        }

        override fun withLocalization(value: Type): S = self()

        /**
         * See [T.spec]
         */
        fun withSpec(value: MethodTypeSpec): S

        /**
         * See [T.invokeType]
         */
        fun withInvokeType(value: InvokeType): S

        /**
         * See [T.spec]
         */
        val spec: MethodTypeSpec?

        companion object {
            fun builder(): Builder<MethodInvocationBase, *> = CodeAPI.getBuilderProvider().invoke()
            fun builder(defaults: MethodInvocationBase): Builder<MethodInvocationBase, *> = CodeAPI.getBuilderProvider().invoke(defaults)
        }

    }

}