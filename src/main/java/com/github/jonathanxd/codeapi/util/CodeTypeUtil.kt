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

import com.github.jonathanxd.codeapi.type.CodeType
import com.github.jonathanxd.codeapi.type.GenericType

private fun resolveQualified(qualifiedName: String, outer: CodeType?, isInternal: Boolean): String {
    if (outer != null) {
        val packageName = outer.packageName

        // Prevent duplication of the name
        if (!packageName.isEmpty() && !qualifiedName.startsWith(packageName)) {
            if (isInternal) {
                return getInternalNameStr(qualifiedName, outer)
            } else {
                return getRealNameStr(qualifiedName, outer)
            }
        }
    }

    return qualifiedName

}

fun resolveInternalQualified(qualifiedName: String, outer: CodeType?): String {
    return resolveQualified(qualifiedName, outer, true)
}

fun resolveRealQualified(qualifiedName: String, outer: CodeType?): String {
    return resolveQualified(qualifiedName, outer, false)
}

private fun getRealNameStr(qualified: String, outer: CodeType): String {
    return outer.canonicalName + "." + qualified
}

private fun getInternalNameStr(qualified: String, outer: CodeType): String {
    return outer.type + "$" + qualified
}

fun codeTypeToFullAsm(type: CodeType): String {
    return if (type.isPrimitive)
        primitiveCodeTypeToAsm(type)
    else
        type.javaSpecName//"L" + type.getType().replace('.', '/') + ";";
}

fun primitiveCodeTypeToAsm(type: CodeType): String {
    return type.javaSpecName
}

@JvmOverloads
fun codeTypeToTypeDesc(codeType: CodeType, type: String = codeType.type): String {

    val name: String

    if (codeType.isArray) {
        name = codeType.arrayBaseComponent.javaSpecName
    } else if (codeType.isPrimitive) {
        return type.replace(".", "/")
    } else {
        return "L" + type.replace('.', '/') + ";"
    }

    val sb = StringBuilder()

    val arrayDimension = codeType.arrayDimension

    for (x in 0..arrayDimension - 1)
        sb.append('[')

    return sb.toString() + name
}

fun toName(codeType: CodeType): String {
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
        return fixResult(codeTypeToFullAsm(codeType))
    }
}

