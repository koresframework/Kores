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
package com.koresframework.kores.common

import com.koresframework.kores.Instruction
import com.koresframework.kores.annotation.Spec
import com.koresframework.kores.base.InvokeType
import com.koresframework.kores.base.MethodInvocation
import com.koresframework.kores.base.Typed
import com.koresframework.kores.data.KoresData
import kotlinx.serialization.Serializable
import java.lang.reflect.Type

@Spec
@Serializable
data class MethodInvokeSpec(val invokeType: InvokeType, val methodTypeSpec: MethodTypeSpec) : Typed,
    Comparable<MethodInvokeSpec> {

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
    ): MethodInvocation = MethodInvocation(this.invokeType, target, this.methodTypeSpec, arguments)

    override fun builder(): Builder = Builder(this)

    override fun compareTo(other: MethodInvokeSpec): Int {
        return this.methodTypeSpec.compareTo(other.methodTypeSpec)
    }

    class Builder() : Typed.Builder<MethodInvokeSpec, Builder> {

        override var data: KoresData = KoresData()
        lateinit var invokeType: InvokeType
        lateinit var methodTypeSpec: MethodTypeSpec

        override var type: Type
            get() = this.methodTypeSpec.type
            set(value) { this.methodTypeSpec = this.methodTypeSpec.copy(type = value) }

        constructor(defaults: MethodInvokeSpec) : this() {
            this.invokeType = defaults.invokeType
            this.methodTypeSpec = defaults.methodTypeSpec

            this.fromData(defaults.data)
        }

        override fun type(value: Type): Builder {
            this.methodTypeSpec =
                    methodTypeSpec.copy(typeSpec = methodTypeSpec.typeSpec.copy(returnType = value))
            return this
        }

        fun withInvokeType(value: InvokeType): Builder {
            this.invokeType = value
            return this
        }

        fun withMethodTypeSpec(value: MethodTypeSpec): Builder {
            this.methodTypeSpec = value
            return this
        }

        override fun buildBasic(): MethodInvokeSpec =
            MethodInvokeSpec(this.invokeType, this.methodTypeSpec)
    }
}