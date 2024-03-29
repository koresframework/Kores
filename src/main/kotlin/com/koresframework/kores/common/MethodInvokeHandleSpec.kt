/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2022 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
package com.koresframework.kores.common

import com.koresframework.kores.Instruction
import com.koresframework.kores.annotation.Spec
import com.koresframework.kores.base.*
import com.koresframework.kores.data.KoresData
import kotlinx.serialization.Serializable
import java.lang.reflect.Type

/**
 * Specify a method invocation in [InvokeDynamicBase.bootstrapArgs]. This is a richer version of [MethodInvokeSpec]
 * only used in [`invokedynamic`][InvokeDynamicBase].
 */
@Spec
@Serializable
data class MethodInvokeHandleSpec(val invokeType: DynamicInvokeType, val methodTypeSpec: MethodTypeSpec) : Typed,
    Comparable<MethodInvokeHandleSpec> {

    override val data: KoresData = KoresData()

    override val type: Type
        get() = this.methodTypeSpec.type

    /**
     * Human-readable method invocation string.
     */
    fun toInvocationString() =
        "${invokeType.name.lowercase()} ${this.methodTypeSpec.toMethodString()}"

    /**
     * Invokes this method in [target].
     */
    operator fun invoke(target: Instruction) = this.invoke(target, emptyList())

    /**
     * Invokes this method in [target] with [arguments].
     */
    operator fun invoke(
        target: Instruction,
        arguments: List<Instruction>
    ): MethodInvocation = MethodInvocation(this.invokeType.toInvokeType(), target, this.methodTypeSpec, arguments)

    override fun builder(): Builder = Builder(this)

    override fun compareTo(other: MethodInvokeHandleSpec): Int {
        return this.methodTypeSpec.compareTo(other.methodTypeSpec)
    }

    class Builder() : Typed.Builder<MethodInvokeHandleSpec, Builder> {

        override var data: KoresData = KoresData()
        lateinit var invokeType: DynamicInvokeType
        lateinit var methodTypeSpec: MethodTypeSpec

        override var type: Type
            get() = this.methodTypeSpec.type
            set(value) { this.methodTypeSpec = this.methodTypeSpec.copy(type = value) }

        constructor(defaults: MethodInvokeHandleSpec) : this() {
            this.invokeType = defaults.invokeType
            this.methodTypeSpec = defaults.methodTypeSpec

            this.from(defaults)
        }

        override fun type(value: Type): Builder {
            this.methodTypeSpec =
                    methodTypeSpec.copy(typeSpec = methodTypeSpec.typeSpec.copy(returnType = value))
            return this
        }

        fun withInvokeType(value: InvokeType): Builder {
            this.invokeType = value.toDynamicInvokeType()
            return this
        }

        fun invokeType(value: InvokeType): Builder {
            this.invokeType = value.toDynamicInvokeType()
            return this
        }

        fun withInvokeType(value: DynamicInvokeType): Builder {
            this.invokeType = value
            return this
        }

        fun invokeType(value: DynamicInvokeType): Builder {
            this.invokeType = value
            return this
        }

        fun withMethodTypeSpec(value: MethodTypeSpec): Builder {
            this.methodTypeSpec = value
            return this
        }

        fun methodTypeSpec(value: MethodTypeSpec): Builder {
            this.methodTypeSpec = value
            return this
        }

        override fun buildBasic(): MethodInvokeHandleSpec =
            MethodInvokeHandleSpec(this.invokeType, this.methodTypeSpec)
    }
}