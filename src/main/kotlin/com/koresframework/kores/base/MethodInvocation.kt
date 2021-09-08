/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2021 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
package com.koresframework.kores.base

import com.koresframework.kores.Instruction
import com.koresframework.kores.builder.self
import com.koresframework.kores.common.MethodTypeSpec
import com.koresframework.kores.data.KoresData
import kotlinx.serialization.Serializable
import java.lang.reflect.Type

/**
 * Invokes a method.
 *
 * @property target Target of the invocation (Access to static context for static methods), for instance constructors,
 * you must to pass a [New] instance, for super constructor or this constructors you must to pass either an [Alias] or an
 * [Access] to `this` context.
 */
@Serializable
data class MethodInvocation(
    val invokeType: InvokeType,
    override val target: Instruction,
    val spec: MethodTypeSpec,
    override val arguments: List<Instruction>
) : Accessor, ArgumentsHolder, TypedInstruction {

    override val data: KoresData = KoresData()
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
        ArgumentsHolder.Builder<MethodInvocation, Builder>,
        Typed.Builder<MethodInvocation, Builder> {

        override var data: KoresData = KoresData()
        lateinit var invokeType: InvokeType
        override lateinit var target: Instruction
        lateinit var spec: MethodTypeSpec
        override var arguments: List<Instruction> = emptyList()

        override var localization: Type
            get() = this.spec.localization
            set(value) {}

        override var type: Type
            get() = this.spec.typeSpec.returnType
            set(value) {}

        constructor(defaults: MethodInvocation) : this() {
            this.invokeType = defaults.invokeType
            this.target = defaults.target
            this.spec = defaults.spec
            this.arguments = defaults.arguments

            this.fromData(defaults.data)
        }

        override fun array(value: Boolean): Builder = self()
        override fun localization(value: Type): Builder = self()

        override fun target(value: Instruction): Builder {
            this.target = value
            return this
        }

        /**
         * See [MethodInvocation.invokeType]
         */
        fun invokeType(value: InvokeType): Builder {
            this.invokeType = value
            return this
        }

        /**
         * See [MethodInvocation.spec]
         */
        fun spec(value: MethodTypeSpec): Builder {
            this.spec = value
            return this
        }

        override fun arguments(value: List<Instruction>): Builder {
            this.arguments = value
            return this
        }

        override fun type(value: Type): Builder {
            this.spec = this.spec.builder().type(value).build()
            return this
        }

        override fun buildBasic(): MethodInvocation =
            MethodInvocation(this.invokeType, this.target, this.spec, this.arguments)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: MethodInvocation): Builder = Builder(defaults)
        }

    }
}

/**
 * Returns true if a [MethodInvocation] is a invocation of super constructor
 */
val MethodInvocation.isSuperConstructorInvocation
    get() = this.spec.methodName == "<init>" && this.target == Alias.SUPER
