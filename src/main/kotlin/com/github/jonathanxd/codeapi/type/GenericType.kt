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

import com.github.jonathanxd.codeapi.util.descriptor
import com.github.jonathanxd.codeapi.util.eq
import java.util.*

/**
 * Generic type.
 *
 * Default implementations of [equals], [hashCode] and [toString] is provided by [com.github.jonathanxd.codeapi.util] functions.
 */
interface GenericType : CodeType {

    /**
     * Name of the generic type.
     */
    val name: String

    /**
     * Bounds of the generic type.
     */
    val bounds: Array<Bound>

    /**
     * Resolved code type.
     */
    val codeType: CodeType

    /**
     * True if this is a Type generic type, false if is a Type Variable generic type.
     */
    val isType: Boolean

    /**
     * True if this is a wildcard generic type.
     */
    val isWildcard: Boolean
        get() = this.name == "*"

    override val identification: String
        get() {
            if (this.isType && this.bounds.isEmpty())
                return this.javaSpecName
            else
                return this.descriptor
        }

    // CodeType Overrides
    override val type: String
        get() = this.codeType.type

    override val canonicalName: String
        get() = this.codeType.canonicalName

    override val packageName: String
        get() = this.codeType.packageName

    override val simpleName: String
        get() = this.codeType.simpleName

    override val javaSpecName: String
        get() = this.codeType.javaSpecName

    override val isPrimitive: Boolean
        get() = this.isType && this.codeType.isPrimitive

    override val isInterface: Boolean
        get() = this.isType && this.codeType.isInterface

    override val isVirtual: Boolean
        get() = !this.isType || this.codeType.isVirtual

    override val isArray: Boolean
        get() = isType && this.codeType.isArray

    /**
     * Only determine the Wrapper type if:
     *
     * `isCodeType && bounds.isEmpty`
     *
     * Because `int<T>` is invalid.
     */
    override val wrapperType: CodeType?
        get() {
            if (isType && bounds.isEmpty())
                return this.codeType.wrapperType

            return null
        }

    /**
     * Only determine the Primitive type if:
     *
     * `isCodeType && bounds.isEmpty`
     *
     * Because
     *
     * `Integer<T>` is invalid and `List<T>` has no primitive types because List is not a wrapper type.
     *
     */
    override val primitiveType: CodeType?
        get() {
            if (isType && bounds.isEmpty())
                return this.codeType.primitiveType

            return null
        }


    override fun toArray(dimensions: Int): GenericType

    override fun `is`(another: CodeType?): Boolean = this == another
    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String
    override fun compareTo(other: CodeType): Int = if (this.eq(other)) 0 else -1

    override fun builder(): Builder<GenericType, *> = GenericTypeBuilder(this)

    interface Builder<out T : GenericType, S : Builder<T, S>> : com.github.jonathanxd.codeapi.builder.Builder<T, S> {

        /**
         * See [T.name].
         *
         * Defines a type variable.
         *
         * This method will overwrite the defined type and wildcard mark.
         */
        fun withName(value: String): Builder<T, S>

        /**
         * See [T.isWildcard]
         *
         * Defines as a wildcard type, this method is the same as calling `withName("*")`.
         *
         * **Note: `withName("?")` is invalid because CodeAPI denotes wildcards with `*` instead of `?`**
         *
         * This method will overwrite defined type and name.
         */
        fun wildcard(): Builder<T, S>

        /**
         * See [T.codeType]
         *
         * Defines a type.
         *
         * This method will overwrite the defined name and wildcard mark.
         */
        fun withType(value: CodeType): Builder<T, S>

        /**
         * See [T.bounds]
         */
        fun withBounds(value: Array<Bound>): Builder<T, S>

        /**
         * Adds all bounds of [bounds] array.
         */
        fun addBounds(bounds: Array<Bound>): Builder<T, S>

        /**
         * Adds all bounds of [bounds] collection.
         */
        fun addBounds(bounds: Collection<Bound>): Builder<T, S>

        /**
         * Adds a bound.
         */
        fun addBound(bound: Bound): Builder<T, S>

        /**
         * Adds a extends bound.
         *
         * **Note: This method is used to denote the bound of a generic type.**
         */
        fun addExtendsBound(value: CodeType): Builder<T, S>

        /**
         * Adds a super bound.
         *
         * **Note: This method is used to denote the bound of a generic type.**
         */
        fun addSuperBound(value: CodeType): Builder<T, S>

        /**
         * Adds a `of` bound. Example: A `List of String`.
         *
         * **Note: This method is used to denote a bound of a concrete type, not of a type variable.**
         */
        fun addOfBound(value: CodeType): Builder<T, S>
    }

    /**
     * Generic type bounds.
     */
    abstract class Bound(val type: CodeType) {

        /**
         * Symbol of this bound.
         *
         * @return Symbol of this bound.
         */
        abstract val sign: String

        override fun equals(other: Any?): Boolean {
            if (other is Bound) {

                if (this.sign == other.sign && this.type.`is`(other.type)) {
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
     */
    abstract class WildcardBound(type: CodeType) : Bound(type)

    /**
     * Bound to type.
     */
    class GenericBound(type: CodeType) : Bound(type) {
        override val sign: String = ""
    }

    /**
     * Bound to extends.
     */
    class Extends(type: CodeType) : WildcardBound(type) {
        override val sign: String = "+"
    }

    /**
     * Bound to super type.
     */
    class Super(type: CodeType) : WildcardBound(type) {
        override val sign: String = "-"
    }

}