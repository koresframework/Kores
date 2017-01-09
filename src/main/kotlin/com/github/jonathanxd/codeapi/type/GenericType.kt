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
package com.github.jonathanxd.codeapi.type

import com.github.jonathanxd.codeapi.type.CodeType

import java.util.Objects

/**
 * Generic type.
 */
interface GenericType : CodeType {

    /**
     * Name of the generic type.
     *
     * @return Name of the generic type.
     */
    val name: String

    /**
     * Bounds of the generic type.
     *
     * @return Bounds of the generic type.
     */
    val bounds: Array<Bound<CodeType>>

    /**
     * Gets the resolved code type.

     * @return Resolved code type.
     */
    val codeType: CodeType

    /**
     * Returns true if this is a Type generic type, false if is a Type Variable generic type.

     * @return True if this is a Type generic type, false if is a Type Variable generic type.
     */
    val isType: Boolean

    /**
     * Returns true if this is a wildcard generic type.

     * @return True if this is a wildcard generic type.
     */
    val isWildcard: Boolean
        get() = this.name == "*"

    override fun toArray(dimensions: Int): GenericType

    /**
     * Generic type bounds.
     *
     * @param T   Type of bound.
     */
    abstract class Bound<out T : CodeType>(val type: T) {

        /**
         * Symbol of this bound.
         *
         * @return Symbol of this bound.
         */
        abstract val sign: String

        override fun equals(other: Any?): Boolean {
            if (other is Bound<*>) {

                if (this.sign == other.sign && this.type == other.type) {
                    return true
                }
            }

            return super.equals(other)
        }

        override fun hashCode(): Int {
            return Objects.hash(type, this.sign)
        }
    }

    /**
     * Bound to wildcard.
     *
     * @param <T> Type of CodeType
     */
    abstract class WildcardBound<out T : CodeType>(type: T) : Bound<T>(type)

    /**
     * Bound to type.
     *
     * @param T  Type of CodeType
     */
    class GenericBound<out T : CodeType>(type: T) : Bound<T>(type) {
        override val sign: String = ""
    }

    /**
     * Bound to extends.
     *
     * @param T  Type of CodeType
     */
    class Extends<out T : CodeType>(type: T) : WildcardBound<T>(type) {
        override val sign: String = "+"
    }

    /**
     * Bound to super type.
     *
     * @param <T> Type of CodeType
     */
    class Super<out T : CodeType>(type: T) : WildcardBound<T>(type) {
        override val sign: String = "-"
    }

}