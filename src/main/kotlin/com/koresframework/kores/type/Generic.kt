/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2022 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
package com.koresframework.kores.type

import com.koresframework.kores.Types
import com.koresframework.kores.type.GenericType.Bound
import com.koresframework.kores.util.toStr
import com.github.jonathanxd.iutils.array.ArrayUtils
import com.koresframework.kores.data.KoresData
import java.lang.reflect.Type
import java.util.*


/**
 * A generic type.
 *
 * Examples:
 *
 * A generic type T that extends String:
 *
 * `Generic.type("T").extends$(String.class);`
 *
 * A generic type T that extends V:
 *
 * `Generic.type("T").extends$("V");`
 *
 * A List of Type T:
 *
 * `Generic.type(List.class).of("T")`
 *
 * **Attention: All calls of the methods of [Generic] class creates a copy of the `bound` array (except the first call), if you mind performance use the [GenericTypeBuilder]**
 */
class Generic private constructor(name: String?, codeType: KoresType?, bounds: Array<Bound>) :
    GenericType {

    override val data: KoresData = KoresData()

    /**
     * Name of the generic type.
     */
    override val name: String

    /**
     * Defined type.
     */
    private val definedKoresType: KoresType?

    /**
     * Type.
     */
    override val resolvedType: KoresType

    /**
     * Generic bounds.
     */
    override val bounds: Array<Bound>

    /**
     * Is a type.
     */
    private val isType_: Boolean = codeType != null

    /**
     * Create a generic type from a name (ex: T, E, R).
     *
     * @param name Name.
     */
    private constructor(name: String) : this(name, null, emptyArray())

    /**
     * Create a generic type from a type.
     *
     * @param type Type.
     */
    private constructor(type: KoresType) : this(null, type, emptyArray())

    init {
        if (name != null) {
            this.name = name
        } else {
            if (codeType == null) {
                throw NullPointerException("codeType is null and name is null")
            }

            this.name = codeType.javaSpecName.let { it.substring(0, it.length - 1) }
        }

        if (codeType != null) {
            this.resolvedType = codeType
            this.definedKoresType = codeType
        } else {
            if (bounds.isEmpty()) {
                this.definedKoresType = null
                this.resolvedType = Types.OBJECT
            } else {
                this.resolvedType = bounds[0].type
                this.definedKoresType = this.resolvedType
            }
        }

        this.bounds = bounds
    }

    /**
     * Add a bound.
     *
     * @param bound Bound.
     * @return New instance of generic type.
     */
    fun of(bound: GenericType.Bound): Generic {
        return Generic(
            this.name,
            this.definedKoresType,
            ArrayUtils.addToArray<Bound>(this.bounds, bound)
        )
    }

    /**
     * Add all [bounds].
     *
     * @param bounds Bounds.
     * @return New instance of generic type.
     */
    fun of(vararg bounds: GenericType.Bound): Generic {
        return Generic(
            this.name,
            this.definedKoresType,
            ArrayUtils.addAllToArray<Bound>(this.bounds, bounds)
        )
    }

    /**
     * Add a name bound.
     *
     * @param s Name.
     * @return New instance of generic type.
     */
    fun of(s: String): Generic {
        return Generic(
            this.name,
            this.definedKoresType,
            ArrayUtils.addToArray<Bound>(this.bounds, GenericType.GenericBound(Generic(s)))
        )
    }

    /**
     * Add name bounds.
     *
     * @param ss Names.
     * @return New instance of generic type.
     */
    @Suppress("UNCHECKED_CAST")
    fun of(vararg ss: String): Generic {
        val bounds = ss.map { s -> GenericType.GenericBound(Generic(s)) }.toTypedArray()

        return Generic(
            this.name,
            this.definedKoresType,
            ArrayUtils.addAllToArray(this.bounds, bounds as Array<Bound>)
        )
    }

    /**
     * Add a type bound.
     *
     * @param type Type.
     * @return New instance of generic type.
     */
    fun of(type: Type): Generic {
        return Generic(
            this.name, this.definedKoresType,
            ArrayUtils.addToArray<Bound>(this.bounds, GenericType.GenericBound(type.koresType))
        )
    }

    /**
     * Add type bounds.
     *
     * @param types Types.
     * @return New instance of generic type.
     */
    fun of(vararg types: Type): Generic {
        val bounds = types.map { GenericType.GenericBound(it.koresType) }.toTypedArray()

        return Generic(
            this.name,
            this.definedKoresType,
            ArrayUtils.addAllToArray(this.bounds, bounds)
        )
    }

    /**
     * Generic type that extends type variable `s`.
     *
     * @param s Type name.
     * @return New instance of generic type.
     */
    fun `extends$`(s: String): Generic {
        return Generic(
            this.name,
            this.definedKoresType,
            ArrayUtils.addToArray(this.bounds, GenericType.Extends(Generic(s)))
        )
    }

    /**
     * Generic type that extends type variables `ss`.
     *
     * @param ss Types names.
     * @return New instance of generic type.
     */
    @Suppress("UNCHECKED_CAST")
    fun `extends$`(vararg ss: String): Generic {
        val bounds = ss.map { s -> GenericType.Extends(Generic(s)) }.toTypedArray()

        return Generic(
            this.name,
            this.definedKoresType,
            ArrayUtils.addAllToArray(this.bounds, bounds as Array<Bound>)
        )
    }

    /**
     * Generic type that extends type `type`.
     *
     * @param type Type.
     * @return New instance of generic type.
     */
    fun `extends$`(type: Type): Generic {
        return Generic(
            this.name, this.definedKoresType,
            ArrayUtils.addToArray<Bound>(this.bounds, GenericType.Extends(type.koresType))
        )
    }


    /**
     * Generic type that extends types `types`.
     *
     * @param types Types.
     * @return New instance of generic type.
     */
    fun `extends$`(vararg types: Type): Generic {
        val bounds = types.map { GenericType.Extends(it.koresType) }.toTypedArray()

        return Generic(
            this.name,
            this.definedKoresType,
            ArrayUtils.addAllToArray<Bound>(this.bounds, bounds)
        )
    }

    /**
     * Generic type that have a super type variable `s`.
     *
     * @param s Type variable.
     * @return New instance of generic type.
     */
    fun `super$`(s: String): Generic {
        return Generic(
            this.name,
            this.definedKoresType,
            ArrayUtils.addToArray<Bound>(this.bounds, GenericType.Super(Generic(s)))
        )
    }

    /**
     * Generic type that have a super type variables `ss`.
     *
     * @param ss Type variables.
     * @return New instance of generic type.
     */
    @Suppress("UNCHECKED_CAST")
    fun `super$`(vararg ss: String): Generic {
        val bounds = ss.map { s -> GenericType.Super(Generic(s)) }.toTypedArray()

        return Generic(
            this.name,
            this.definedKoresType,
            ArrayUtils.addAllToArray<Bound>(this.bounds, bounds)
        )
    }

    /**
     * Generic type that have a super type `type`.
     *
     * @param type Type.
     * @return New instance of generic type.
     */
    fun `super$`(type: Type): Generic {
        return Generic(
            this.name,
            this.definedKoresType,
            ArrayUtils.addToArray(this.bounds, GenericType.Super(type.koresType))
        )
    }

    /**
     * Generic type that have a super types `types`.
     *
     * @param types Types.
     * @return New instance of generic type.
     */
    @Suppress("UNCHECKED_CAST")
    fun `super$`(vararg types: Type): Generic {
        val bounds = types.map { GenericType.Super(it.koresType) }.toTypedArray()

        return Generic(
            this.name,
            this.definedKoresType,
            ArrayUtils.addAllToArray(this.bounds, bounds)
        )
    }

    override val isType: Boolean
        get() = !this.isWildcard && this.isType_

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
        get() = isType && this.resolvedType.isPrimitive

    override val isInterface: Boolean
        get() = isType && this.resolvedType.isInterface

    override val isVirtual: Boolean
        get() = !isType || this.resolvedType.isVirtual

    override fun compareTo(other: KoresType): Int {
        return if (isType)
            this.resolvedType.compareTo(other)
        else if (other is GenericType && !other.isType)
            if (this.bounds.isEmpty() && other.bounds.isEmpty())
                this.name.compareTo(other.name)
            else
                if (this.bounds.size == other.bounds.size
                        && this.name.compareTo(other.name) == 0
                        && Arrays.equals(this.bounds, other.bounds)
                )
                    0
                else -1
        else -1
    }

    override val isArray: Boolean
        get() = isType && this.resolvedType.isArray

    override fun toArray(dimensions: Int): GenericType {
        return Generic(this.name, this.resolvedType.toArray(dimensions), this.bounds)
    }

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

    override fun equals(other: Any?): Boolean = this.eq(other)
    override fun hashCode(): Int = this.hash()
    override fun toString(): String = this.toStr()

    companion object {


        /**
         * Create a generic type from a name (ex: T, E, R).
         *
         * @param s Name.
         * @return Generic of name.
         */
        @JvmStatic
        fun type(s: String): Generic {
            return Generic(s, null, emptyArray())
        }

        /**
         * Create a generic type from a type.
         *
         * @param type Type.
         * @return Generic of type.
         */
        @JvmStatic
        fun type(type: Type): Generic = if (type is Generic) type else Generic(null, type.koresType, emptyArray())

        /**
         * Create a generic wildcard (? in Java Language, * in JVM).
         *
         * @return Generic wildcard.
         */
        @JvmStatic
        fun wildcard(): Generic {
            return Generic("*", null, emptyArray())
        }
    }
}
