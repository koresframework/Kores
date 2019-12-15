/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2019 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
package com.github.jonathanxd.kores.common

import com.github.jonathanxd.kores.Instruction
import com.github.jonathanxd.kores.annotation.Spec
import com.github.jonathanxd.kores.base.InvokeType
import com.github.jonathanxd.kores.base.MethodInvocation
import com.github.jonathanxd.kores.base.TypeSpec
import com.github.jonathanxd.kores.base.Typed
import com.github.jonathanxd.kores.type.KoresType
import com.github.jonathanxd.kores.type.koresType
import java.lang.reflect.Type

@Spec
data class MethodSpec(val methodName: String, val typeSpec: TypeSpec) :
    Typed, Comparable<MethodSpec> {
    override val type: Type
        get() = this.typeSpec.type

    override fun builder(): Builder = Builder(this)

    /**
     * Human readable method specification string.
     */
    fun toMethodString() =
        "$methodName${typeSpec.toTypeString()}"

    /**
     * Invokes this method in [target].
     */
    operator fun invoke(invokeType: InvokeType, type: Type, target: Instruction) =
        this.invoke(invokeType, type, target, emptyList())

    /**
     * Invokes this method in [target] with [arguments].
     */
    operator fun invoke(
        invokeType: InvokeType,
        type: Type,
        target: Instruction,
        arguments: List<Instruction>
    ): MethodInvocation = MethodInvocation(invokeType, target, this.toMethodTypeSpec(type), arguments)

    /**
     * This method will not compare the method localization.
     */
    override operator fun compareTo(other: MethodSpec): Int {
        return if (this.methodName == other.methodName && this.typeSpec == other.typeSpec) 0 else 1
    }

    /**
     * Converts this [MethodSpec] to [MethodTypeSpec]
     */
    fun toMethodTypeSpec(type: Type) =
            MethodTypeSpec(type, this)

    class Builder() : Typed.Builder<MethodSpec, Builder> {
        lateinit var methodName: String
        lateinit var typeSpec: TypeSpec

        constructor(defaults: MethodSpec) : this() {
            this.methodName = defaults.methodName
            this.typeSpec = defaults.typeSpec
        }

        override fun type(value: Type): Builder {
            this.typeSpec = this.typeSpec.copy(returnType = value)
            return this
        }

        fun withMethodName(value: String): Builder {
            this.methodName = value
            return this
        }

        fun withTypeSpec(value: TypeSpec): Builder {
            this.typeSpec = value
            return this
        }

        override fun build(): MethodSpec = MethodSpec(this.methodName, this.typeSpec)

    }
}