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
import java.lang.reflect.Type

/**
 * Invocation of a method
 */
@Concrete
interface MethodInvocation : Accessor, ArgumentHolder, Typed {

    override val types: List<Type>
        get() = this.spec.description.parameterTypes

    override val array: Boolean
        get() = false

    /**
     * Method localization
     */
    override val localization: Type

    /**
     * Method arguments
     */
    override val arguments: List<CodePart>

    /**
     * Method return type
     */
    override val type: Type
        get() = this.spec.description.returnType

    /**
     * Specification of the method
     */
    val spec: MethodSpecification

    /**
     * Type of method invocation
     */
    val invokeType: InvokeType

    /**
     * Dynamic invocation
     */
    val invokeDynamic: InvokeDynamic?

    override fun builder(): Builder<MethodInvocation, *> = CodeAPI.getBuilderProvider()(this)

    interface Builder<out T : MethodInvocation, S : Builder<T, S>> :
            Accessor.Builder<T, S>,
            ArgumentHolder.Builder<T, S>,
            Typed.Builder<T, S> {

        @Suppress("UNCHECKED_CAST")
        override fun withArray(value: Boolean): S = this as S

        @Suppress("UNCHECKED_CAST")
        override fun withType(value: Type): S = this as S

        /**
         * See [T.spec]
         */
        fun withSpec(value: MethodSpecification): S

        /**
         * See [T.invokeType]
         */
        fun withInvokeType(value: InvokeType): S

        /**
         * See [T.invokeDynamic]
         */
        fun withInvokeDynamic(value: InvokeDynamic?): S

        companion object {
            fun builder(): Builder<MethodInvocation, *> = CodeAPI.getBuilderProvider().invoke()
            fun builder(defaults: MethodInvocation): Builder<MethodInvocation, *> = CodeAPI.getBuilderProvider().invoke(defaults)
        }

    }

}