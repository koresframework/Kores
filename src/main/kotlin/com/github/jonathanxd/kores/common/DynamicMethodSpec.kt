/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2020 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
import com.github.jonathanxd.kores.base.*
import com.github.jonathanxd.kores.type
import java.lang.reflect.Type

/**
 * @property name Name of dynamic method
 * @property typeSpec Signature of dynamic method.
 * @property arguments Arguments to pass to dynamic method. (may include the receiver).
 */
@Spec
data class DynamicMethodSpec(
    override val name: String,
    val typeSpec: TypeSpec,
    override val arguments: List<Instruction>
) : Typed, Named, ArgumentsHolder {

    override val type: Type
        get() = this.typeSpec.returnType

    override val array: Boolean
        get() = false

    override val types: List<Type>
        get() = this.arguments.map { it.type }

    /**
     * Creates a dynamic invocation of this dynamic method spec. The dynamic invocation
     * uses [bootstrap] to bind the invocation.
     */
    operator fun invoke(bootstrap: MethodInvokeSpec) =
        this.invoke(bootstrap, emptyList())

    /**
     * Creates a dynamic invocation of this dynamic method spec. The dynamic invocation
     * uses [bootstrap] (with [bootstrapArgs]) to bind the invocation.
     */
    operator fun invoke(bootstrap: MethodInvokeSpec, bootstrapArgs: List<Any>): InvokeDynamic =
        InvokeDynamic(bootstrap, this, bootstrapArgs)

    /**
     * Human readable method string.
     */
    fun toMethodString() =
        "$name ${typeSpec.toTypeString()}"

    override fun builder(): Builder = Builder(this)


    class Builder() : Typed.Builder<DynamicMethodSpec, Builder>,
        Named.Builder<DynamicMethodSpec, Builder>,
        ArgumentsHolder.Builder<DynamicMethodSpec, Builder> {

        lateinit var name: String
        lateinit var typeSpec: TypeSpec
        var arguments: List<Instruction> = emptyList()

        constructor(defaults: DynamicMethodSpec) : this() {
            this.name = defaults.name
            this.typeSpec = defaults.typeSpec
            this.arguments = defaults.arguments
        }

        override fun type(value: Type): Builder {
            this.typeSpec = this.typeSpec.copy(returnType = value)
            return this
        }

        override fun name(value: String): Builder {
            this.name = value
            return this
        }

        override fun arguments(value: List<Instruction>): Builder {
            this.arguments = value
            return this
        }

        override fun array(value: Boolean): Builder {
            return this
        }

        /**
         * See [DynamicMethodSpec.typeSpec]
         */
        fun typeSpec(value: TypeSpec): Builder {
            this.typeSpec = value
            return this
        }

        override fun build(): DynamicMethodSpec =
            DynamicMethodSpec(this.name, this.typeSpec, this.arguments)
    }
}