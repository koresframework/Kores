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

import com.github.jonathanxd.codeapi.annotation.GenerateTo
import com.github.jonathanxd.codeapi.Types
import com.github.jonathanxd.codeapi.type.CodeType
import com.github.jonathanxd.codeapi.type.GenericType
import com.github.jonathanxd.codeapi.type.GenericType.Bound
import com.github.jonathanxd.codeapi.util.GenericTypeUtil
import com.github.jonathanxd.iutils.array.ArrayUtils

import java.util.Arrays
import java.util.Objects


/**
 * A generic type.
 *
 * Examples:
 *
 * A generic type T that extends String:
 *
 * `Generic.type("T").extends$(PredefinedTypes.STRING);`
 *
 * A generic type T that extends V:
 *
 * `Generic.type("T").extends$("V");`
 *
 * A List of Type T:
 *
 * `Generic.type(CodeAPI.getJavaType(List.class)).of("T")`
 *
 */
@GenerateTo(GenericType::class)
class Generic private constructor(name: String?, codeType: CodeType?, bounds: Array<Bound<CodeType>>) : GenericType {

    /**
     * Name of the generic type.
     */
    override val name: String

    /**
     * Defined type.
     */
    private val definedCodeType: CodeType?

    /**
     * Type.
     */
    override val codeType: CodeType

    /**
     * Generic bounds.
     */
    override val bounds: Array<Bound<CodeType>>

    /**
     * Is a type.
     */
    private val isType_: Boolean

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
    private constructor(type: CodeType) : this(null, type, emptyArray())

    init {
        this.isType_ = codeType != null

        if (name != null) {
            this.name = name
        } else {
            if (codeType == null) {
                throw NullPointerException("codeType is null and name is null")
            }

            var specName = codeType.javaSpecName

            specName = specName.substring(0, specName.length - 1)

            this.name = specName
        }

        if (codeType != null) {
            this.codeType = codeType
            this.definedCodeType = codeType
        } else {
            if (bounds.isEmpty()) {
                this.definedCodeType = null
                this.codeType = Types.OBJECT
            } else {
                this.codeType = bounds[0].type
                this.definedCodeType = this.codeType
            }
        }

        this.bounds = bounds
    }

    /**
     * Add a name bound.

     * @param s Name.
     * *
     * @return New instance of generic type.
     */
    fun of(s: String): Generic {
        return Generic(this.name, this.definedCodeType, ArrayUtils.addToArray<Bound<CodeType>>(this.bounds, GenericType.GenericBound<CodeType>(Generic(s))))
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

        return Generic(this.name, this.definedCodeType, ArrayUtils.addAllToArray(this.bounds, bounds as Array<Bound<CodeType>>))
    }

    /**
     * Add a type bound.
     *
     * @param type Type.
     * @return New instance of generic type.
     */
    fun of(type: CodeType): Generic {
        return Generic(this.name, this.definedCodeType, ArrayUtils.addToArray<Bound<CodeType>>(this.bounds, GenericType.GenericBound(type)))
    }

    /**
     * Add type bounds.
     *
     * @param types Types.
     * @return New instance of generic type.
     */
    fun of(vararg types: CodeType): Generic {
        val bounds = types.map { GenericType.GenericBound(it) }.toTypedArray()

        return Generic(this.name, this.definedCodeType, ArrayUtils.addAllToArray(this.bounds, bounds))
    }

    /**
     * Generic type that extends type variable `s`.
     *
     * @param s Type name.
     * @return New instance of generic type.
     */
    fun `extends$`(s: String): Generic {
        return Generic(this.name, this.definedCodeType, ArrayUtils.addToArray(this.bounds, GenericType.Extends<CodeType>(Generic(s))))
    }

    @Suppress("UNCHECKED_CAST")
    /**
     * Generic type that extends type variables `ss`.
     *
     * @param ss Types names.
     * @return New instance of generic type.
     */
    fun `extends$`(vararg ss: String): Generic {
        val bounds = ss.map { s -> GenericType.Extends(Generic(s)) }.toTypedArray()

        return Generic(this.name, this.definedCodeType, ArrayUtils.addAllToArray(this.bounds, bounds as Array<Bound<CodeType>>))
    }

    /**
     * Generic type that extends type `type`.

     * @param type Type.
     * *
     * @return New instance of generic type.
     */
    fun `extends$`(type: CodeType): Generic {
        return Generic(this.name, this.definedCodeType, ArrayUtils.addToArray<Bound<CodeType>>(this.bounds, GenericType.Extends(type)))
    }


    /**
     * Generic type that extends types `types`.
     *
     * @param types Types.
     * @return New instance of generic type.
     */
    fun `extends$`(vararg types: CodeType): Generic {
        val bounds = types.map { GenericType.Extends(it) }.toTypedArray()

        return Generic(this.name, this.definedCodeType, ArrayUtils.addAllToArray<Bound<CodeType>>(this.bounds, bounds))
    }

    /**
     * Generic type that have a super type variable `s`.
     *
     * @param s Type variable.
     * @return New instance of generic type.
     */
    fun `super$`(s: String): Generic {
        return Generic(this.name, this.definedCodeType, ArrayUtils.addToArray<Bound<CodeType>>(this.bounds, GenericType.Super<CodeType>(Generic(s))))
    }

    /**
     * Generic type that have a super type variables `ss`.
     *
     * @param ss Type variables.
     * @return New instance of generic type.
     */
    @Suppress("UNCHECKED_CAST")
    fun `super$`(vararg ss: String): Generic {
        val bounds = ss.map { s -> GenericType.Super(Generic(s)) }.toTypedArray() as Array<Bound<CodeType>>

        return Generic(this.name, this.definedCodeType, ArrayUtils.addAllToArray<Bound<CodeType>>(this.bounds, bounds))
    }

    /**
     * Generic type that have a super type `type`.
     *
     * @param type Type.
     * @return New instance of generic type.
     */
    fun `super$`(type: CodeType): Generic {
        return Generic(this.name, this.definedCodeType, ArrayUtils.addToArray(this.bounds, GenericType.Super(type)))
    }

    /**
     * Generic type that have a super types `types`.
     *
     * @param types Types.
     * @return New instance of generic type.
     */
    @Suppress("UNCHECKED_CAST")
    fun `super$`(vararg types: CodeType): Generic {
        val bounds = types.map { GenericType.Super(it) }.toTypedArray() as Array<Bound<CodeType>>

        return Generic(this.name, this.definedCodeType, ArrayUtils.addAllToArray(this.bounds, bounds))
    }

    override val isType: Boolean
        get() = !this.isWildcard && this.isType_

    override val type: String
        get() = if (true) this.codeType.type else this.name

    override val canonicalName: String
        get() = if (isType) this.codeType.canonicalName else this.name

    override val packageName: String
        get() = if (isType) this.codeType.packageName else ""

    override val simpleName: String
        get() = if (isType) this.codeType.simpleName else this.name

    override val javaSpecName: String
        get() = if (isType) this.codeType.javaSpecName else name

    override val isPrimitive: Boolean
        get() = isType && this.codeType.isPrimitive

    override val isInterface: Boolean
        get() = isType && this.codeType.isInterface

    override val isVirtual: Boolean
        get() = !isType || this.codeType.isVirtual

    override fun compareTo(other: CodeType): Int {
        return if (isType) this.codeType.compareTo(other) else -1
    }

    override val isArray: Boolean
        get() = isType && this.codeType.isArray

    override fun toArray(dimensions: Int): GenericType {
        return Generic(this.name, this.codeType.toArray(dimensions), this.bounds)
    }

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

    override fun equals(other: Any?): Boolean {

        if (other is GenericType) {

            if (this.isWildcard == other.isWildcard
                    && this.isType == other.isType
                    && this.name == other.name
                    && Arrays.deepEquals(this.bounds, other.bounds)) {
                return true
            }

        }

        return super.equals(other)
    }


    override fun hashCode(): Int {

        if (this.isType && this.bounds.isEmpty())
            return CodeType.hash(this)

        var result = Objects.hash(this.name, this.isType, this.isWildcard)

        result = 31 * result + Arrays.deepHashCode(this.bounds)

        return result
    }

    override fun toString(): String {
        return GenericTypeUtil.toSourceString(this)
    }

    override val isExpression: Boolean
        get() = false

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
        fun type(type: CodeType): Generic {
            return Generic(null, type, emptyArray())
        }

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
