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

import com.github.jonathanxd.codeapi.CodePart
import com.github.jonathanxd.codeapi.util.CodeTypeUtil

/**
 * A type representation, like:
 *
 * - Java Classes.
 *
 * - CodeAPI Type Declarations.
 *
 * - Plain class name.
 *
 * - ALIAS type: [com.github.jonathanxd.codeapi.util.Alias.THIS], [com.github.jonathanxd.codeapi.util.Alias.SUPER], [com.github.jonathanxd.codeapi.util.Alias.INTERFACE]
 *
 * Make sure to handle [THIS][com.github.jonathanxd.codeapi.util.Alias.THIS],
 * [SUPER][com.github.jonathanxd.codeapi.util.Alias.SUPER] and [INTERFACE(n)][com.github.jonathanxd.codeapi.util.Alias.INTERFACE] types.
 *
 * The implementation MUST implement [hashCode] and [equals].
 */
interface CodeType : CodePart, Comparable<CodeType> {

    /**
     * Type name, examples:
     *
     * [String] = `java.lang.String`.
     * [Int] = `int`.
     * `path.to.A.B` = `path.to.A$B`.
     * `path.to.A.B[][]` = `path.to.A$B[][]`.
     */
    val type: String

    /**
     * Canonical name
     *
     * Qualified name:
     *
     * [String] = `java.lang.String`.
     * [Int] = `int`.
     * `path.to.A.B` = `path.to.A.B`.
     * `path.to.A.B[][]` = `path.to.A.B[][]`.
     */
    val canonicalName: String

    /**
     * Package name
     */
    val packageName: String
        get() {
            val type = type

            if (!type.contains("."))
                return ""

            return type.substring(0, type.lastIndexOf('.'))
        }

    /**
     * Simple name.
     */
    val simpleName: String
        get() {
            val type = type

            if (isPrimitive)
                return type

            return type.substring(type.lastIndexOf('.') + 1)
        }

    /**
     * JVM Spec class name.
     *
     * [String] = `Ljava/lang/String;`
     * [Int] = `I`
     * `path.to.A.B[]` = `[Lpath/to/A$B;`
     */
    val javaSpecName: String
        get() = if(this.isArray) CodeTypeUtil.codeTypeToArray(this, this.arrayDimension) else "L" + this.type.replace('.', '/') + ";"

    /**
     * True if this [CodeType] is a primitive type.
     */
    val isPrimitive: Boolean
        get() = false

    /**
     * True if this [CodeType] is a interface type.
     */
    val isInterface: Boolean
        get() = false

    /**
     * True if is a `Virtual Type` (Virtual Types = Types that were not loaded by JVM)
     */
    val isVirtual: Boolean
        get() = true

    /**
     * Array dimension, 0 if this type is not an array.
     */
    val arrayDimension: Int
        get() = 0

    /**
     * True if this [CodeType] is an array type.
     */
    val isArray: Boolean
        get() = this.arrayDimension > 0

    /**
     * Wrapper type.
     */
    val wrapperType: CodeType?
        get() = null

    /**
     * Primitive type.
     */
    val primitiveType: CodeType?
        get() = null

    /**
     * Array base component.
     *
     * Example, if is a `String[]`, returns [String], if is `Integer[][][]`
     * returns [Integer], the Java equivalent method returns: `Integer[][]`.
     */
    val arrayBaseComponent: CodeType
        get() = if(this.isArray) throw IllegalStateException("arrayBaseComponent not implemented") else this

    /**
     * Array component.
     *
     * Example, if is a `String[]`, returns [String], if is `Integer[][][]`
     * returns `Integer[][]`.
     */
    val arrayComponent: CodeType
        get() = if(this.isArray) throw IllegalStateException("arrayComponent not implemented") else this

    /**
     * Convert this [CodeType] to a [CodeTypeArray].
     *
     * @param dimensions Dimension of the array.
     * @return [CodeTypeArray] with specified dimension.
     */
    open fun toArray(dimensions: Int): CodeType {
        if (this is CodeTypeArray) {
            return CodeTypeArray(this.component, this.arrayDimension + dimensions)
        }

        return CodeTypeArray(this, dimensions)
    }

    /**
     * Returns true if this [CodeType] is equals to another [CodeType].
     *
     * @param another Another [CodeType].
     * @return True if this [CodeType] is equals to another [CodeType].
     */
    fun `is`(another: CodeType?): Boolean {
        return another != null && this.compareTo(another) == 0
    }

    override fun compareTo(other: CodeType): Int {
        return this.javaSpecName.compareTo(other.javaSpecName)
    }

    override fun hashCode(): Int
    override fun equals(other: Any?): Boolean

    companion object {
        /**
         * Default hash algorithm.
         *
         * @param codeType Receiver.
         * @return Hash code.
         */
        fun hash(codeType: CodeType?): Int {
            return codeType?.javaSpecName?.hashCode() ?: 0
        }

        /**
         * Default equals method.
         *
         * @param codeType Receiver.
         * @param obj      Object to test.
         * @return True if this [CodeType] is equals to another [CodeType].
         */
        fun eq(codeType: CodeType?, obj: Any?): Boolean {
            return if (codeType == null) obj == null else obj is CodeType && codeType.`is`(obj)
        }
    }
}