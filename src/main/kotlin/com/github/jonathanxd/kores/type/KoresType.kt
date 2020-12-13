/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2020 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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

import com.github.jonathanxd.kores.KoresPart
import com.github.jonathanxd.kores.Types
import com.github.jonathanxd.kores.util.eq
import com.github.jonathanxd.kores.util.hash
import com.github.jonathanxd.kores.util.identityEq
import com.github.jonathanxd.kores.util.typeDesc
import com.github.jonathanxd.iutils.kt.leftOrRight
import com.github.jonathanxd.iutils.kt.rightOrFail
import com.github.jonathanxd.iutils.recursion.Element
import com.github.jonathanxd.iutils.recursion.ElementUtil
import com.github.jonathanxd.iutils.recursion.Elements
import com.github.jonathanxd.iutils.type.TypeParameterProvider
import java.lang.reflect.Type

/**
 * A type representation, like:
 *
 * - Java Classes (reflection and apt types).
 *
 * - Kores Type Declarations.
 *
 * - Plain class name.
 *
 * - ALIAS type: [com.github.jonathanxd.kores.util.Alias.THIS], [com.github.jonathanxd.kores.util.Alias.SUPER], [com.github.jonathanxd.kores.util.Alias.INTERFACE]
 *
 * Make sure to handle [THIS][com.github.jonathanxd.kores.util.Alias.THIS],
 * [SUPER][com.github.jonathanxd.kores.util.Alias.SUPER] and [INTERFACE(n)][com.github.jonathanxd.kores.util.Alias.INTERFACE] types.
 *
 * The implementation of this interface must implement [hashCode] and [equals] reflecting equality to
 * [eq] and hashing algorithm to [hash]. This does not means that you need to delegate the call, you still
 * free to check whatever you need, but comparison between two [CodeTypes][KoresType] and hash calculation
 * of [KoresType] should be made through these methods.
 */
interface KoresType : KoresPart, Comparable<KoresType>, Type {

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
     * True if this [KoresType] is a primitive type.
     */
    val isPrimitive: Boolean
        get() = false

    /**
     * True if this [KoresType] is a interface type.
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
     * True if this [KoresType] is an array type.
     */
    val isArray: Boolean
        get() = this.arrayDimension > 0

    /**
     * Wrapper type.
     */
    val wrapperType: KoresType?
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
    val primitiveType: KoresType?
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
    val arrayBaseComponent: KoresType
        get() = if (this.isArray) throw IllegalStateException("arrayBaseComponent not implemented") else this

    /**
     * Array component.
     *
     * Example, if is a `String[]`, returns [String], if is `Integer[][][]`
     * returns `Integer[][]`.
     */
    val arrayComponent: KoresType
        get() = if (this.isArray) throw IllegalStateException("arrayComponent not implemented") else this

    /**
     * Unique string identification, this property may be used for equality comparison, normal types,
     * array types and generic types have different identifications, if a generic type represent a single
     * [KoresType] without any bound, then the identification will be the same as the single [KoresType].
     */
    val identification: String
        get() = this.javaSpecName

    /**
     * Default resolver.
     *
     * This resolver always returns `this` instance for [KoresTypeResolver.resolve] method.
     */
    val defaultResolver: KoresTypeResolver<*>
        get() = KoresTypeResolver.DefaultResolver

    /**
     * Creates a new binded default resolver instance.
     */
    val bindedDefaultResolver: BindedTypeResolver<*>
        get() = BindedTypeResolver(this, this.defaultResolver)

    /**
     * Gets the super type of `this` [Type] using default resolver.
     */
    val superType: Type?
        get() = this.defaultResolver.getSuperclass(this).rightOrNull()

    /**
     * Gets the super interfaces of `this` [Type] using default resolver.
     */
    val interfaces: List<Type>
        get() = this.defaultResolver.getInterfaces(this).rightOrFail

    /**
     * Returns true if `this` type is assignable from [type] (using default resolver of [type]).
     */
    fun isAssignableFrom(type: Type): Boolean =
        this.defaultResolver.isAssignableFrom(this, type).rightOrFail

    /**
     * Returns true if `this` type is assignable from [type] (using resolver provided by [resolverProvider]).
     */
    fun isAssignableFrom(type: Type, resolverProvider: (Type) -> KoresTypeResolver<*>): Boolean =
        this.defaultResolver.isAssignableFrom(this, type, resolverProvider).rightOrFail

    /**
     * Returns `Either` that holds either failure exception or whether `this type` is assignable
     * from [type].
     */
    fun safeIsAssignableFrom(type: Type) =
        this.defaultResolver.isAssignableFrom(this, type)

    /**
     * Returns `Either` that holds either failure exception or whether `this type` is assignable
     * from [type].
     */
    fun safeIsAssignableFrom(type: Type, resolverProvider: (Type) -> KoresTypeResolver<*>) =
        this.defaultResolver.isAssignableFrom(this, type, resolverProvider)

    /**
     * Convert this [KoresType] to a [ArrayKoresType].
     *
     * @param dimensions Dimension of the array.
     * @return [ArrayKoresType] with specified dimension.
     */
    fun toArray(dimensions: Int): KoresType {
        if (this is ArrayKoresType) {
            return ArrayKoresType(this.component, this.arrayDimension + dimensions)
        }

        return ArrayKoresType(this, dimensions)
    }

    /**
     * Returns true if this [KoresType] is equals to other [KoresType].
     *
     * @param other Type to test against.
     * @return True if this [KoresType] is equals to other [KoresType].
     */
    fun `is`(other: KoresType?): Boolean = this.identityEq(other)

    /**
     * Returns true if this [KoresType] identification is equals to other [Type] according to [is].
     *
     * @param other Type to test against.
     * @return True if this [KoresType] identification is equals to other [Type]  according to [is].
     */
    fun isIdEq(other: Type): Boolean = this.`is`(other.koresType)

    /**
     * Returns true if identification of [concreteType] of this [KoresType] is equals to
     * [concreteType] of other [Type] according to [is].
     *
     * @param other Type to test against.
     * @return True if identification of [concreteType] of this [KoresType] is equals to
     * [concreteType] of other [Type] according to [is].
     */
    fun isConcreteIdEq(other: Type): Boolean = this.concreteType.`is`(other.koresType.concreteType)

    /**
     * Compare two identifications
     */
    override fun compareTo(other: KoresType): Int =
        this.identification.compareTo(other.identification)

    override fun hashCode(): Int
    override fun equals(other: Any?): Boolean

    override fun getTypeName(): String =
        this.toString()

}

/**
 * Gets common super type of [typeA] and [typeB].
 *
 * This function returns a super class that both [typeA] and [typeB] extends from.
 *
 * If either [typeA] or [typeB] is primitive and are not equal, this function returns `null`.
 */
fun getCommonSuperType(typeA: Type, typeB: Type): Type? =
    getCommonSuperTypeOrInterface(typeA, typeB)?.let {
        if (it.isInterface) Types.OBJECT else it
    }

/**
 * Gets common super type of [typeA] and [typeB].
 *
 * This function returns a class or an interface that both [typeA] and [typeB] extends from,
 * first the function tries to get a common *super class*, and then a common *interface*.
 *
 * If [typeA], [typeB] or both are primitive but not equal, `null` is returned.
 */
fun getCommonSuperTypeOrInterface(typeA: Type, typeB: Type): Type? {
    if (typeA.isPrimitive || typeB.isPrimitive) {
        return if (typeA.`is`(typeB)) {
            typeA
        } else {
            null
        }
    }

    val aCodeType = typeA.koresType
    val bCodeType = typeB.koresType
    val isAssignableFrom: Type.(type: KoresType) -> Boolean =
        { this.safeIsAssignableFrom(it).let { it.isRight && it.right } }

    if (aCodeType.isAssignableFrom(bCodeType)) {
        return typeA
    } else if (bCodeType.isAssignableFrom(aCodeType)) {
        return typeB
    }

    val getSuperType: Type.() -> Type? =
        { this.bindedDefaultResolver.getSuperclass().mapLeft { null }.leftOrRight }

    var currentSuper = aCodeType.getSuperType()

    while (currentSuper != null && !currentSuper.`is`(Types.OBJECT)) {
        if (currentSuper.isAssignableFrom(bCodeType))
            return currentSuper

        currentSuper = currentSuper.getSuperType()
    }

    val getItfs: Type.() -> List<Type> =
        { this.bindedDefaultResolver.getInterfaces().mapLeft { emptyList<Type>() }.leftOrRight }

    val itfs = Elements<Type>()
    itfs.insertFromPair(ElementUtil.fromIterable(getItfs(aCodeType)))

    while (true) {
        val next = itfs.nextElement() ?: break
        val nextValue = next.value

        if (nextValue.isAssignableFrom(bCodeType)) {
            return nextValue
        }

        itfs.insertFromPair(ElementUtil.fromIterable(getItfs(nextValue)))
    }

    return Types.OBJECT
}

/**
 * Returns a list with all names of type variables found in generic receiver type and sub types.
 */
fun Type.variables(): List<String> {
    val used = mutableListOf<String>()
    val types = Elements<Type>()
    types.insert(Element(this))

    var type: Type? = types.nextElement()?.value

    while (type != null) {
        when (type) {
            is GenericType -> {
                if (!type.isType && !type.isWildcard) {
                    used += type.name
                }

                val gen = (type.resolvedType as? GenericType)?.let(::listOf).orEmpty()

                val both = gen + type.bounds.map { it.type }

                if (both.isNotEmpty())
                    types.insertFromPair(ElementUtil.fromIterable(both))
            }

        }

        type = types.nextElement()?.value
    }

    return used
}


/**
 * Returns a [Type] of [T]. (Same [koresTypeOf] but with shorter name and [Type] return type)
 */
inline fun <reified T> typeOf(): Type = koresTypeOf<T>()

/**
 * Returns a [KoresType] of [T]. (Same as [T]`::class.java.codeType`)
 */
inline fun <reified T> koresTypeOf(): KoresType = T::class.java.koresType

/**
 * Returns a [GenericType] of generic [T]. This means that `genericTypeOf<List<String>>()`
 * returns a [GenericType] of `List<String>` (same representation as
 * `Generic.type(List::class.java).of(String::class.java)` returns).
 */
inline fun <reified T> genericTypeOf(): GenericType =
    object : TypeParameterProvider<T>() {}.type.koresType.asGeneric
