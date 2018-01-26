/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2018 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
package com.github.jonathanxd.kores.base

import com.github.jonathanxd.kores.Instruction
import java.lang.reflect.Type

/**
 * Enum value.
 *
 * @property enumType Type of enum
 * @property enumEntry Entry of enum.
 */
data class EnumValue(
    val enumType: Type,
    val enumEntry: String
) : Named, Typed, Instruction {

    override val name: String
        get() = this.enumEntry

    override val type: Type
        get() = this.enumType

    override fun builder(): Builder = Builder(this)

    class Builder() :
        Named.Builder<EnumValue, Builder>,
        Typed.Builder<EnumValue, Builder> {

        lateinit var enumType: Type
        lateinit var enumEntry: String

        constructor(defaults: EnumValue) : this() {
            this.enumType = defaults.enumType
            this.enumEntry = defaults.enumEntry
        }

        override fun name(value: String): Builder = this.enumEntry(value)
        override fun type(value: Type): Builder = this.enumType(value)

        /**
         * See [EnumValue.enumType]
         */
        fun enumType(value: Type): Builder {
            this.enumType = value
            return this
        }

        /**
         * See [EnumValue.enumEntry]
         */
        fun enumEntry(value: String): Builder {
            this.enumEntry = value
            return this
        }

        /**
         * Base this EnumValue on an [Enum].
         */
        fun base(enum: Enum<*>): Builder = this.enumType(enum::class.java).enumEntry(enum.name)

        override fun build(): EnumValue = EnumValue(this.enumType, this.enumEntry)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: EnumValue): Builder = Builder(defaults)
        }

    }

}
