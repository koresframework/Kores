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
@file:JvmName("CodeTypeUtil")

package com.github.jonathanxd.codeapi.util

import com.github.jonathanxd.codeapi.type.GenericType
import java.lang.reflect.Type

/**
 * Resolves the inner name based on [qualifiedName] and [outer] type.
 *
 * @param isTypeName True to return type name, false to return qualified name.
 */
private fun resolveInnerName(qualifiedName: String, outer: Type?, isTypeName: Boolean): String {
    if (outer != null) {
        outer.codeType.let { outer ->
            val packageName = outer.packageName

            // Prevent duplication of the name
            if (!packageName.isEmpty() && !qualifiedName.startsWith(packageName)) {
                if (isTypeName) {
                    return getTypeNameStr(qualifiedName, outer)
                } else {
                    return getQualifiedNameStr(qualifiedName, outer)
                }
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
    return outer.codeType.canonicalName + "." + qualified
}

/**
 * Create type name from [qualified] and [outer] name.
 */
private fun getTypeNameStr(qualified: String, outer: Type): String {
    return outer.codeType.type + "$" + qualified
}

/**
 * Convert [type] name to JVM spec name.
 */
fun codeTypeToJvmName(type: Type): String {
    return type.codeType.let { type ->
        if (type.isPrimitive)
            primitiveCodeTypeToJvmName(type)
        else
            type.javaSpecName
    }
}

/**
 * Convert primitive [type] name to JVM spec name.
 */
fun primitiveCodeTypeToJvmName(type: Type): String {
    return type.codeType.javaSpecName
}

/**
 * Convert [type] [name][typeStr] to type description.
 *
 * @param typeStr String to transform in type description (sould be [type] name).
 */
@JvmOverloads
fun codeTypeToTypeDesc(type: Type, typeStr: String = type.codeType.type): String {

    val name: String

    val codeType = type.codeType

    if (codeType.isArray) {
        name = codeType.arrayBaseComponent.javaSpecName
    } else if (codeType.isPrimitive) {
        return typeStr.replace(".", "/")
    } else {
        return "L" + typeStr.replace('.', '/') + ";"
    }

    val sb = StringBuilder()

    val arrayDimension = codeType.arrayDimension

    for (x in 0..arrayDimension - 1)
        sb.append('[')

    return sb.toString() + name
}

/**
 * Convert iterable of types to string description
 */
fun codeTypesToTypeDesc(type: Iterable<Type>): String = type.joinToString(separator = "") { codeTypeToTypeDesc(it) }

/**
 * Converts [type] to type descriptor.
 */
fun toDescriptor(type: Type): String {
    val codeType = type.codeType

    if (codeType is GenericType) {

        val name = codeType.name

        val bounds = codeType.bounds

        if (bounds.isEmpty()) {
            if (!codeType.isType) {
                if (codeType.isWildcard) {
                    return fixResult(name)
                } else {
                    return fixResult("T$name;")
                }
            } else {
                return name + ";"
            }
        } else {
            return fixResult(if (!codeType.isWildcard)
                name + "<" + bounds(codeType.isWildcard, bounds) + ">;"
            else
                bounds(codeType.isWildcard, bounds) + ";")
        }

    } else {
        return fixResult(codeTypeToJvmName(codeType))
    }
}

/**
 * Creates type description from
 */
fun parametersTypeAndReturnToDesc(parameterTypes: Collection<Type>, returnType: Type): String {
    return "(${codeTypesToTypeDesc(parameterTypes)})${codeTypeToTypeDesc(returnType)}"
}