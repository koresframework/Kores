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
import com.koresframework.kores.common.Stack
import com.koresframework.kores.literal.Literals
import com.koresframework.kores.serialization.TypeSerializer
import com.koresframework.kores.type
import com.koresframework.kores.type.isArray
import com.koresframework.kores.type.koresType
import kotlinx.serialization.Serializable
import java.lang.reflect.Type

/**
 * Constructs an array of type [arrayType] with dimensions [dimensions]. Example:
 *
 * `new ArrayConstructor(String[].class, listOf(Literals.INT(5)), emptyList()) = new String[5]`
 * `new ArrayConstructor(String[].class, listOf(Literals.INT(5), Literals.INT(9)), emptyList()) = new String[5][9]`
 * ```
 * new ArrayConstructor(
 *     String[].class,
 *     listOf(Literals.INT(3)),
 *     listOf(Literals.STRING("A"), Literals.STRING("B"), Literals.STRING("C"))
 * ) = new String[] {"A", "B", "C"}
 * ```
 */
@Serializable
data class ArrayConstructor(
    @Serializable(with = TypeSerializer::class) val arrayType: Type,
    val dimensions: List<Instruction>,
    override val arguments: List<Instruction>
) : ArgumentsHolder, TypedInstruction {

    init {
        check(arrayType.isArray) { "arrayType is not an array type!" }
        check(dimensions.isNotEmpty()) { "dimensions cannot be empty" }
    }

    override val type: Type
        get() = this.arrayType

    override val array: Boolean
        get() = true

    override val types: List<Type>
        get() = ArrayList<Type>(this.arguments.size).apply {
            (0..arguments.size).forEach {
                add(arrayType.koresType.arrayComponent)
            }
        }

    /**
     * Array values
     */
    val arrayValues: List<ArrayStore>
        get() {
            val arguments = this.arguments
            val arrayStores = mutableListOf<ArrayStore>()

            for (i in arguments.indices) {
                val argument = arguments[i]

                arrayStores.add(
                    ArrayStore.Builder.builder()
                        .arrayType(this@ArrayConstructor.arrayType) //this@ArrayConstructor.arrayType.toArray(this@ArrayConstructor.dimensions.size)
                        .target(Stack)
                        .index(Literals.INT(i))
                        .valueType(argument.type)
                        .valueToStore(argument)
                        .build()
                )
            }

            return arrayStores
        }

    override fun builder(): Builder = Builder(this)

    class Builder() :
        ArgumentsHolder.Builder<ArrayConstructor, Builder>,
        Typed.Builder<ArrayConstructor, Builder> {

        lateinit var arrayType: Type
        var dimensions: List<Instruction> = emptyList()
        var arguments: List<Instruction> = emptyList()

        constructor(defaults: ArrayConstructor) : this() {
            this.arrayType = defaults.arrayType
            this.dimensions = defaults.dimensions
            this.arguments = defaults.arguments
        }

        override fun type(value: Type): Builder = this.arrayType(value)

        @Suppress("UNCHECKED_CAST")
        override fun array(value: Boolean): Builder = self()

        /**
         * See [ArrayConstructor.arrayType]
         */
        fun arrayType(value: Type): Builder {
            this.arrayType = value
            return this
        }

        /**
         * See [ArrayConstructor.dimensions]
         */
        fun dimensions(value: List<Instruction>): Builder {
            this.dimensions = value
            return this
        }

        /**
         * See [ArrayConstructor.dimensions]
         */
        fun dimensions(vararg values: Instruction): Builder = dimensions(values.toList())

        override fun arguments(value: List<Instruction>): Builder {
            this.arguments = value
            return this
        }

        override fun build(): ArrayConstructor =
            ArrayConstructor(this.arrayType, this.dimensions, this.arguments)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: ArrayConstructor): Builder = Builder(defaults)
        }

    }

}
