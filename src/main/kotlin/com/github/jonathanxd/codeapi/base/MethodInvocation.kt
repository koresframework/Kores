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

import com.github.jonathanxd.codeapi.CodeInstruction
import com.github.jonathanxd.codeapi.CodePart
import com.github.jonathanxd.codeapi.common.MethodTypeSpec
import com.github.jonathanxd.codeapi.util.Alias
import com.github.jonathanxd.codeapi.util.self
import java.lang.reflect.Type

/**
 * Invokes a method.
 *
 * @property target Target of the invocation (Access to static context for static methods), for instance constructors,
 * you must to pass a [New] instance, for super constructor or this constructors you must to pass either an [Alias] or an
 * [Access] to `this` context.
 */
data class MethodInvocation(val invokeType: InvokeType,
                            override val target: CodePart,
                            val spec: MethodTypeSpec,
                            override val arguments: List<CodePart>) : Accessor, ArgumentHolder, Typed, CodeInstruction {

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
     * Method return type
     */
    override val type: Type
        get() = this.spec.typeSpec.returnType


    override fun builder(): Builder = Builder(this)

    class Builder() : Accessor.Builder<MethodInvocation, Builder>,
            ArgumentHolder.Builder<MethodInvocation, Builder>,
            Typed.Builder<MethodInvocation, Builder> {

        lateinit var invokeType: InvokeType
        lateinit var target: CodePart
        lateinit var spec: MethodTypeSpec
        var arguments: List<CodePart> = emptyList()

        constructor(defaults: MethodInvocation) : this() {
            this.invokeType = defaults.invokeType
            this.target = defaults.target
            this.spec = defaults.spec
            this.arguments = defaults.arguments
        }

        override fun withArray(value: Boolean): Builder = self()
        override fun withLocalization(value: Type): Builder = self()

        override fun withTarget(value: CodePart): Builder {
            this.target = value
            return this
        }

        /**
         * See [MethodInvocation.invokeType]
         */
        fun withInvokeType(value: InvokeType): Builder {
            this.invokeType = value
            return this
        }

        /**
         * See [MethodInvocation.spec]
         */
        fun withSpec(value: MethodTypeSpec): Builder {
            this.spec = value
            return this
        }

        override fun withArguments(value: List<CodePart>): Builder {
            this.arguments = value
            return this
        }

        override fun withType(value: Type): Builder {
            this.spec = this.spec.builder().withType(value).build()
            return this
        }

        override fun build(): MethodInvocation = MethodInvocation(this.invokeType, this.target, this.spec, this.arguments)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: MethodInvocation): Builder = Builder(defaults)
        }

    }

}