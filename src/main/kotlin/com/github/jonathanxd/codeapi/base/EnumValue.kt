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

import java.lang.reflect.Type

/**
 * Enum value.
 *
 * This class **must not** be used to access enum entries, to access
 * enum entries uses static field access.
 *
 * @property enumType Type of enum
 * @property enumEntry Entry of enum.
 * @property ordinal Ordinal value of enum. (If -1 is provided, CodeAPI will
 * try to statically resolve the ordinal value).
 */
data class EnumValue(val enumType: Type,
                     val enumEntry: String,
                     val ordinal: Int) : Named, Typed {

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
        var ordinal: Int = -1

        constructor(defaults: EnumValue) : this() {
            this.enumType = defaults.enumType
            this.enumEntry = defaults.enumEntry
            this.ordinal = defaults.ordinal
        }

        override fun withName(value: String): Builder = this.withEnumEntry(value)
        override fun withType(value: Type): Builder = this.withEnumType(value)

        /**
         * See [EnumValue.enumType]
         */
        fun withEnumType(value: Type): Builder {
            this.enumType = value
            return this
        }

        /**
         * See [EnumValue.enumEntry]
         */
        fun withEnumEntry(value: String): Builder {
            this.enumEntry = value
            return this
        }

        /**
         * See [EnumValue.ordinal]
         */
        fun withOrdinal(value: Int): Builder {
            this.ordinal = value
            return this
        }

        override fun build(): EnumValue = EnumValue(this.enumType, this.enumEntry, this.ordinal)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: EnumValue): Builder = Builder(defaults)
        }

    }

}
