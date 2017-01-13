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

import com.github.jonathanxd.codeapi.builder.EnumValueBuilder
import com.github.jonathanxd.codeapi.type.CodeType

/**
 * Enum value
 */
interface EnumValue : Named, Typed {

    override val name: String
        get() = this.enumEntry

    override val type: CodeType
        get() = this.enumType

    /**
     * The enum type.
     */
    val enumType: CodeType

    /**
     * The enum entry.
     */
    val enumEntry: String

    /**
     * Enum ordinal value.
     */
    val ordinal: Int

    override fun builder(): Builder<EnumValue, *> = EnumValueBuilder(this)

    interface Builder<out T : EnumValue, S : Builder<T, S>> :
            Named.Builder<T, S>,
            Typed.Builder<T, S> {

        override fun withName(value: String): S = this.withEnumEntry(value)
        override fun withType(value: CodeType): S = this.withEnumType(value)

        /**
         * See [T.enumType]
         */
        fun withEnumType(value: CodeType): S

        /**
         * See [T.enumEntry]
         */
        fun withEnumEntry(value: String): S

        /**
         * See [T.ordinal]
         */
        fun withOrdinal(value: Int): S
    }
}