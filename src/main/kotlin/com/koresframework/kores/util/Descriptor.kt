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
@file:JvmName("Descriptor")

package com.koresframework.kores.util

import com.github.jonathanxd.iutils.description.Description
import com.github.jonathanxd.iutils.description.DescriptionUtil
import com.koresframework.kores.base.TypeSpec
import com.koresframework.kores.generic.GenericSignature
import com.koresframework.kores.type.GenericType
import com.koresframework.kores.type.KoresType
import com.koresframework.kores.type.koresType
import java.lang.reflect.Type

/**
 * Resolves the inner name based on [qualifiedName] and [outer] type.
 *
 * @param isTypeName True to return type name, false to return qualified name.
 */
private fun resolveInnerName(qualifiedName: String, outer: Type?, isTypeName: Boolean): String {
    outer?.koresType?.let { outerType ->
        val packageName = outerType.packageName

        // Prevent duplication of the name
        if (!packageName.isEmpty() && !qualifiedName.startsWith(packageName)) {
            return if (isTypeName) {
                getTypeNameStr(qualifiedName, outerType)
            } else {
                getQualifiedNameStr(qualifiedName, outerType)
            }
        }
    }

    return qualifiedName

}

/**
 * Resolves the type name based on [qualifiedName] and [outer] type.
 */
fun resolveTypeName(qualifiedName: String, outer: Type?): String {
    return resolveInnerName(qualifiedName, outer, true)
}

/**
 * Resolves the qualified name based on [qualifiedName] and [outer] type.
 */
fun resolveQualifiedName(qualifiedName: String, outer: Type?): String {
    return resolveInnerName(qualifiedName, outer, false)
}

/**
 * Create qualified name from [qualified] and [outer] name.
 */
private fun getQualifiedNameStr(qualified: String, outer: Type): String {
    return outer.koresType.canonicalName + "." + qualified
}

/**
 * Create type name from [qualified] and [outer] name.
 */
private fun getTypeNameStr(qualified: String, outer: Type): String {
    return outer.koresType.type + "$" + qualified
}

val Type.typeDesc get() = this.getTypeDesc()

/**
 * Convert `this` [name][typeStr] to type description.
 *
 * All calls to [KoresType.javaSpecName] are delegated to this function.
 *
 * @param typeStr String to transform in type description (should be `this` name).
 */
fun Type.getTypeDesc(typeStr: String = this.koresType.type): String {

    val name: String

    val codeType = this.koresType

    when {
        codeType.isArray -> name = codeType.arrayBaseComponent.javaSpecName
        codeType.isPrimitive -> {
            return when (typeStr) {
                "byte" -> "B"
                "short" -> "S"
                "int" -> "I"
                "char" -> "C"
                "double" -> "D"
                "float" -> "F"
                "long" -> "J"
                "boolean" -> "Z"
                "void" -> "V"
                else -> typeStr.replace(".", "/") // Should I throw an exception or only replace?
            }
        }
        else -> return "L" + typeStr.replace('.', '/') + ";"
    }

    val sb = StringBuilder()

    val arrayDimension = codeType.arrayDimension

    for (x in 0 until arrayDimension)
        sb.append('[')

    return sb.toString() + name
}

/**
 * Convert iterable of types to string description
 */
val Iterable<Type>.typeDesc get() = this.joinToString(separator = "") { it.typeDesc }

/**
 * Converts `this` type to type descriptor.
 *
 * A type descriptor is formatted as:
 *
 * - `TYPE_JAVA_SPEC` (specified by [KoresType.javaSpecName]) when receiver [Type] is not a [GenericType]
 * - `TYPE_NAME` when receiver is a [GenericType], does not have bounds and is a wildcard (and not a type).
 * - `(T)(TYPE_NAME);` when receiver is a [GenericType], does not have bounds and is neither a wildcard nor a type.
 * - `TYPE_NAME;` when receiver is a [GenericType], and is a type.
 * - `TYPE_NAME<BOUNDS>;` when receiver is a [GenericType], have bounds and the receiver is not a wildcard.
 *
 * Note: `()` is only used to make the format more readable and will not be generated in descriptors.
 */
val Type.descriptor: String
    get() {
        val codeType = this.koresType

        if (codeType is GenericType) {

            val name = codeType.name

            val bounds = codeType.bounds

            if (bounds.isEmpty()) {
                return if (!codeType.isType) {
                    if (codeType.isWildcard) {
                        name
                    } else {
                        "T$name;"
                    }
                } else {
                    name + ";"
                }
            } else {
                return if (!codeType.isWildcard)
                    name + "<${bounds(codeType.isWildcard, bounds)}>;"
                else
                    bounds(codeType.isWildcard, bounds)
            }

        } else {
            return codeType.javaSpecName
        }
    }

/**
 * Converts `this` type to type descriptor.
 *
 * A type descriptor is formatted as:
 *
 * - `TYPE_JAVA_SPEC` (specified by [KoresType.javaSpecName]) when receiver [Type] is not a [GenericType]
 * - `TYPE_NAME` when receiver is a [GenericType], does not have bounds and is a wildcard (and not a type).
 * - `(T)(TYPE_NAME);` when receiver is a [GenericType], does not have bounds and is neither a wildcard nor a type.
 * - `TYPE_NAME;` when receiver is a [GenericType], and is a type.
 * - `TYPE_NAME<BOUNDS>;` when receiver is a [GenericType], have bounds and the receiver is not a wildcard.
 *
 * Note: `()` is only used to make the format more readable and will not be generated in descriptors.
 *
 * This variant of function discards bounds of known generic types.
 */
fun Type.descriptorDiscardKnown(sig: List<GenericSignature>): String {
    val codeType = this.koresType

    if (codeType is GenericType) {

        val name = codeType.name

        val bounds = codeType.bounds

        val isKnown = sig.any { it.types.any { it.name == name && it.isType == codeType.isType && it.isWildcard == codeType.isWildcard } }

        if (bounds.isEmpty()) {
            return if (!codeType.isType) {
                if (codeType.isWildcard) {
                    name
                } else {
                    "T$name;"
                }
            } else {
                name + ";"
            }
        } else {
            return if (isKnown) "T$name;"
            else if (!codeType.isWildcard)
                name + "<${boundsDiscardKnown(codeType.isWildcard, bounds, sig)}>;"
            else
                boundsDiscardKnown(codeType.isWildcard, bounds, sig)
        }

    } else {
        return codeType.javaSpecName
    }
}

/**
 * Converts `this` type to type descriptor.
 *
 * A type descriptor is formatted as:
 *
 * - `TYPE_JAVA_SPEC` (specified by [KoresType.javaSpecName]) when receiver [Type] is not a [GenericType]
 * - `TYPE_NAME` when receiver is a [GenericType], does not have bounds and is a wildcard (and not a type).
 * - `(T)(TYPE_NAME);` when receiver is a [GenericType], does not have bounds and is neither a wildcard nor a type.
 * - `TYPE_NAME;` when receiver is a [GenericType], and is a type.
 * - `TYPE_NAME<BOUNDS>;` when receiver is a [GenericType], have bounds and the receiver is not a wildcard.
 *
 * Note: `()` is only used to make the format more readable and will not be generated in descriptors.
 *
 * This variant of function discards bounds of generic types. This is used to generate generic signatures for methods
 * in class file.
 */
val Type.descriptorForSignatures: String get() {
    val codeType = this.koresType

    if (codeType is GenericType) {

        val name = codeType.name

        val bounds = codeType.bounds

        if (bounds.isEmpty()) {
            return if (!codeType.isType) {
                if (codeType.isWildcard) {
                    name
                } else {
                    "T$name;"
                }
            } else {
                name + ";"
            }
        } else {
            return if (!codeType.isType && !codeType.isWildcard) "T$name;"
            else if (!codeType.isWildcard)
                name + "<${boundsDiscardForSignature(codeType.isWildcard, bounds)}>;"
            else
                boundsDiscardForSignature(codeType.isWildcard, bounds)
        }

    } else {
        return codeType.javaSpecName
    }
}


/**
 * Converts `this` type to simple type descriptor, which does not include extended version of bounds
 * in their description, used for signature of implementations and super class in type declarations.
 *
 * A type descriptor is formatted as:
 *
 * - `TYPE_JAVA_SPEC` (specified by [KoresType.javaSpecName]) when receiver [Type] is not a [GenericType]
 * - `TYPE_NAME` when receiver is a [GenericType], does not have bounds and is a wildcard (and not a type).
 * - `(T)(TYPE_NAME);` when receiver is a [GenericType], does not have bounds and is neither a wildcard nor a type.
 * - `TYPE_NAME;` when receiver is a [GenericType], and is a type.
 * - `TYPE_NAME<BOUNDS>;` when receiver is a [GenericType], have bounds and the receiver is not a wildcard.
 *
 * Note: `()` is only used to make the format more readable and will not be generated in descriptors.
 */
val Type.simpleBoundDescriptor: String
    get() {
        val codeType = this.koresType

        if (codeType is GenericType) {

            val name = codeType.name

            val bounds = codeType.bounds

            if (bounds.isEmpty()) {
                return if (!codeType.isType) {
                    if (codeType.isWildcard) {
                        name
                    } else {
                        "T$name;"
                    }
                } else {
                    name + ";"
                }
            } else {
                return if (!codeType.isWildcard)
                    name + "<${simpleBounds(codeType.isWildcard, bounds)}>;"
                else
                    simpleBounds(codeType.isWildcard, bounds)
            }

        } else {
            return codeType.javaSpecName
        }
    }

/**
 * Converts `this` type to simple type descriptor without bounds, this is used in descriptors which generic types
 * does not require a bound to be present (normally, when describing that a method receives a type T,
 * without providing that T extends class X).
 *
 * This property is used in a particular case where you describe a USE of a type in the code, not
 * the declaration itself, this means that you are describing a type of a variable, parameter or field, and
 * not the declaration of the bounds of the generic type, such as in methods descriptors.
 *
 * A particular example is:
 *
 * ```kotlin
 * class Test<A> { // Use descriptor with bounds.
 *     fun hello(obj: A) { // Use descriptor with discarded bounds.
 *     }
 * }
 * ```
 *
 * This must be made because a normal descriptor includes the type which the GenericType is bound to,
 * for example, when you declare a [GenericType] `T extends List<E>`, you are describing a signature,
 * the signature means that you are declaring a type variable `T` which extends a `List<E>`, but when you use this [GenericType] in
 * a field or parameter, you is explicit saying that you want to use the declared type `T`, but if you
 * reuse the [GenericType] that you used to specify a signature, and extract descriptor with [Type.descriptor], it will generate a `T<List<E>>`,
 * because `T` is a type bound to `List<E>`, this is an unwanted behavior, so, instead, you must use [Type.descriptorDiscardBound],
 * which will discard bounds in descriptor, providing the correctly declaration of use of type variable `T`, which is simply `T` (or TT;).
 *
 *
 * A type descriptor is formatted as:
 *
 * - `TYPE_JAVA_SPEC` (specified by [KoresType.javaSpecName]) when receiver [Type] is not a [GenericType]
 * - `TYPE_NAME` when receiver is a [GenericType], does not have bounds and is a wildcard (and not a type).
 * - `(T)(TYPE_NAME);` when receiver is a [GenericType], does not have bounds and is neither a wildcard nor a type.
 * - `TYPE_NAME;` when receiver is a [GenericType], and is a type.
 * - `TYPE_NAME<BOUNDS>;` when receiver is a [GenericType], have bounds and the receiver is not a wildcard.
 *
 * Note: `()` is only used to make the format more readable and will not be generated in descriptors.
 */
val Type.descriptorDiscardBound: String
    get() {
        val codeType = this.koresType

        return if (codeType is GenericType && !codeType.isType && codeType.bounds.isNotEmpty()) {
            val name = codeType.name

            if (codeType.isWildcard) "$name;"
            else "T$name;"
        } else if (codeType is GenericType && !codeType.isType) {
            val name = codeType.name

            if (codeType.isWildcard) "$name;"
            else "T$name;"
        } else {
            codeType.javaSpecName
        }
    }

/**
 * Creates type description from
 */
fun parametersTypeAndReturnToDesc(parameterTypes: Collection<Type>, returnType: Type): String {
    return "(${parameterTypes.typeDesc})${returnType.typeDesc}"
}

/**
 * Resolve types of [description] using [resolver] and convert to [TypeSpec]
 */
fun toTypeSpec(description: Description, resolver: TypeResolver): TypeSpec {
    val returnType = description.type
    val parameterTypes = description.parameterTypes

    return TypeSpec(
        resolver.resolveUnknown(returnType),
        parameterTypes.map { resolver.resolveUnknown(it) })

}

/**
 * Resolve types of [desc] using [resolver] and convert to [TypeSpec]
 */
fun toTypeSpec(desc: String, resolver: TypeResolver): TypeSpec {
    val parameterTypes = DescriptionUtil.getParameterTypes(desc)

    val returnType = DescriptionUtil.getType(desc)

    return TypeSpec(
        resolver.resolveUnknown(returnType),
        parameterTypes.map { resolver.resolveUnknown(it) })
}