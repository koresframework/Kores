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
package com.github.jonathanxd.kores.type

import com.github.jonathanxd.kores.util.descriptor
import com.github.jonathanxd.kores.util.eq
import java.lang.reflect.Type
import java.util.*

/**
 * Generic type.
 *
 * Default implementations of [equals], [hashCode] and [toString] is provided by [com.github.jonathanxd.kores.util] functions.
 */
interface GenericType : KoresType, WrapperKoresType {

    override val wrapped: KoresType
        get() = this.resolvedType

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
    val resolvedType: KoresType

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
            return if (this.isType && this.bounds.isEmpty())
                this.javaSpecName
            else
                this.descriptor
        }

    // KoresType Overrides
    override val type: String
        get() = this.resolvedType.type

    override val canonicalName: String
        get() = this.resolvedType.canonicalName

    override val packageName: String
        get() = this.resolvedType.packageName

    override val simpleName: String
        get() = this.resolvedType.simpleName

    override val javaSpecName: String
        get() = this.resolvedType.javaSpecName

    override val isPrimitive: Boolean
        get() = this.isType && this.resolvedType.isPrimitive

    override val isInterface: Boolean
        get() = this.isType && this.resolvedType.isInterface

    override val isVirtual: Boolean
        get() = !this.isType || this.resolvedType.isVirtual

    override val isArray: Boolean
        get() = isType && this.resolvedType.isArray

    override val arrayBaseComponent: KoresType
        get() = this.resolvedType.arrayBaseComponent

    override val arrayComponent: KoresType
        get() = this.resolvedType.arrayComponent

    override val arrayDimension: Int
        get() = this.resolvedType.arrayDimension

    /**
     * Only determine the Wrapper type if:
     *
     * `isKoresType && bounds.isEmpty`
     *
     * Because `int<T>` is invalid.
     */
    override val wrapperType: KoresType?
        get() {
            if (isType && bounds.isEmpty())
                return this.resolvedType.wrapperType

            return null
        }

    /**
     * Only determine the Primitive type if:
     *
     * `isKoresType && bounds.isEmpty`
     *
     * Because
     *
     * `Integer<T>` is invalid and `List<T>` has no primitive types because List is not a wrapper type.
     *
     */
    override val primitiveType: KoresType?
        get() {
            if (isType && bounds.isEmpty())
                return this.resolvedType.primitiveType

            return null
        }


    override fun toArray(dimensions: Int): GenericType

    override fun `is`(other: KoresType?): Boolean = this == other
    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String
    override fun compareTo(other: KoresType): Int = if (this.eq(other)) 0 else -1

    override fun builder(): Builder<GenericType, *> = GenericTypeBuilder(this)

    interface Builder<out T : GenericType, S : Builder<T, S>> :
        com.github.jonathanxd.kores.builder.Builder<T, S> {

        /**
         * See [T.name].
         *
         * Defines a type variable.
         *
         * This method will overwrite the defined type and wildcard mark.
         */
        fun name(value: String): Builder<T, S>

        /**
         * See [T.isWildcard]
         *
         * Defines as a wildcard type, this method is the same as calling `withName("*")`.
         *
         * **Note: `withName("?")` is invalid because Kores denotes wildcards with `*` instead of `?`**
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
        fun type(value: Type): Builder<T, S>

        /**
         * See [T.bounds]
         */
        fun bounds(value: Array<Bound>): Builder<T, S>

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
        fun addExtendsBound(value: Type): Builder<T, S>

        /**
         * Adds a super bound.
         *
         * **Note: This method is used to denote the bound of a generic type.**
         */
        fun addSuperBound(value: Type): Builder<T, S>

        /**
         * Adds a `of` bound. Example: A `List of String`.
         *
         * **Note: This method is used to denote a bound of a concrete type, not of a type variable.**
         */
        fun addOfBound(value: Type): Builder<T, S>

        /**
         * Adds a extends bound.
         *
         * **Note: This method is used to denote the bound to a type variable.**
         */
        fun addExtendsBound(value: String): Builder<T, S> =
            this.addExtendsBound(Generic.type(value))

        /**
         * Adds a super bound.
         *
         * **Note: This method is used to denote the bound to a type variable.**
         */
        fun addSuperBound(value: String): Builder<T, S> =
            this.addSuperBound(Generic.type(value))

        /**
         * Adds a `of` bound. Example: A `List of E`.
         *
         * **Note: This method is used to denote a bound to a type variable.**
         */
        fun addOfBound(value: String): Builder<T, S> =
            this.addOfBound(Generic.type(value))

    }

    /**
     * Generic type bounds.
     */
    abstract class Bound(val type: KoresType) {

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
    abstract class WildcardBound(type: KoresType) : Bound(type)

    /**
     * Bound to type.
     */
    class GenericBound(type: KoresType) : Bound(type) {
        override val sign: String = ""
    }

    /**
     * Bound to extends.
     */
    class Extends(type: KoresType) : WildcardBound(type) {
        override val sign: String = "+"
    }

    /**
     * Bound to super type.
     */
    class Super(type: KoresType) : WildcardBound(type) {
        override val sign: String = "-"
    }

}