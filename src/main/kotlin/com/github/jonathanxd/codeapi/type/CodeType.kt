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
import com.github.jonathanxd.codeapi.Types
import com.github.jonathanxd.codeapi.util.typeDesc
import java.lang.reflect.Type

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
interface CodeType : CodePart, Comparable<CodeType>, Type {

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
            if (isPrimitive)
                return canonicalName

            return canonicalName.substring(canonicalName.lastIndexOf('.') + 1)
        }

    /**
     * JVM Spec class name.
     *
     * [String] = `Ljava/lang/String;`
     * [Int] = `I`
     * `path.to.A.B[]` = `[Lpath/to/A$B;`
     */
    val javaSpecName: String
        get() = this.typeDesc

    /**
     * Binary name of the class.
     *
     * [String] = `java.lang.String`
     * [Int] = `int`
     * `String[]` = `[Ljava.lang.String;`
     *
     */
    val binaryName: String
        get() = if (!this.isArray) this.type else {
            val sb = StringBuilder()

            val arrayDimension = this.arrayDimension

            for (x in 0..arrayDimension - 1)
                sb.append('[')

            sb.toString() + "L${this.arrayBaseComponent.type};"
        }

    /**
     * Internal class name.
     *
     * [String] = `java/lang/String`
     * `String[]` = `[Ljava/lang/String;`
     *
     * Obs: Should not be used for primitive types.
     */
    val internalName: String
        get() = this.binaryName.replace('.', '/')

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
        get() = when (this.type) {
            "byte" -> Types.BYTE_WRAPPER
            "short" -> Types.SHORT_WRAPPER
            "int" -> Types.INTEGER_WRAPPER
            "char" -> Types.CHARACTER_WRAPPER
            "double" -> Types.DOUBLE_WRAPPER
            "float" -> Types.FLOAT_WRAPPER
            "long" -> Types.LONG_WRAPPER
            "boolean" -> Types.BOOLEAN_WRAPPER
            "void" -> Types.VOID
            else -> null
        }

    /**
     * Primitive type.
     */
    val primitiveType: CodeType?
        get() = when (this.type) {
            "java.lang.Byte" -> Types.BYTE
            "java.lang.Short" -> Types.SHORT
            "java.lang.Integer" -> Types.INT
            "java.lang.Character" -> Types.CHAR
            "java.lang.Double" -> Types.DOUBLE
            "java.lang.Float" -> Types.FLOAT
            "java.lang.Long" -> Types.LONG
            "java.lang.Boolean" -> Types.BOOLEAN
            "java.lang.Void" -> Types.VOID
            else -> null
        }

    /**
     * Array base component.
     *
     * Example, if is a `String[]`, returns [String], if is `Integer[][][]`
     * returns [Integer], the Java equivalent method returns: `Integer[][]`.
     */
    val arrayBaseComponent: CodeType
        get() = if (this.isArray) throw IllegalStateException("arrayBaseComponent not implemented") else this

    /**
     * Array component.
     *
     * Example, if is a `String[]`, returns [String], if is `Integer[][][]`
     * returns `Integer[][]`.
     */
    val arrayComponent: CodeType
        get() = if (this.isArray) throw IllegalStateException("arrayComponent not implemented") else this

    /**
     * Unique string identification, this property may be used for equality comparison, normal types,
     * array types and generic types have different identifications, if a generic type represent a single
     * [CodeType] without any bound, then the identification will be the same as the single [CodeType].
     */
    val identification: String
        get() = this.javaSpecName

    /**
     * Default resolver.
     *
     * This resolver always returns `this` instance for [CodeTypeResolver.resolve] method.
     */
    val defaultResolver: CodeTypeResolver<*>
        get() = CodeTypeResolver.DefaultResolver

    /**
     * Gets the super type of `this` [Type] using default resolver.
     */
    val superType: Type?
        get() = this.defaultResolver.getSuperclass(this)

    /**
     * Gets the super interfaces of `this` [Type] using default resolver.
     */
    val interfaces: List<Type>
        get() = this.defaultResolver.getInterfaces(this)

    /**
     * Returns true if `this` type is assignable from [type] (using default resolver of [type]).
     */
    fun isAssignableFrom(type: Type): Boolean =
        this.defaultResolver.isAssignableFrom(this, type)

    /**
     * Returns true if `this` type is assignable from [type] (using resolver provided by [resolverProvider]).
     */
    fun isAssignableFrom(type: Type, resolverProvider: (Type) -> CodeTypeResolver<*>): Boolean =
        this.defaultResolver.isAssignableFrom(this, type, resolverProvider)


    /**
     * Convert this [CodeType] to a [CodeTypeArray].
     *
     * @param dimensions Dimension of the array.
     * @return [CodeTypeArray] with specified dimension.
     */
    fun toArray(dimensions: Int): CodeType {
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
        return this.identification.compareTo(other.identification)
    }

    override fun hashCode(): Int
    override fun equals(other: Any?): Boolean

    override fun getTypeName(): String =
            this.toString()

}
