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
package com.koresframework.kores.util

import com.github.jonathanxd.iutils.exception.TypeResolutionException
import com.github.jonathanxd.iutils.type.TypeUtil
import java.lang.Boolean
import kotlin.String
import kotlin.Throws

/**
 * Gets the [Class] instance from `str`.
 *
 * @param str Name of the class.
 * @return [Class] instance.
 * @throws ClassNotFoundException If class with name `str` cannot be found.
 */
@Throws(ClassNotFoundException::class)
fun classForName(str: String, loader: ClassLoader? = null): Class<*> =
    when (str) {
        "byte" -> java.lang.Byte.TYPE
        "short" -> java.lang.Short.TYPE
        "char" -> Character.TYPE
        "int" -> Integer.TYPE
        "float" -> java.lang.Float.TYPE
        "double" -> java.lang.Double.TYPE
        "long" -> java.lang.Long.TYPE
        "boolean" -> Boolean.TYPE
        "void" -> Void.TYPE
        else -> loader?.loadClass(str) ?: Class.forName(str)
    }

fun fixName(classLiteral: String): String =
    if (classLiteral.endsWith("[]")) {
        val stringBuilder = StringBuilder()

        stringBuilder.append("L")
        for (c in classLiteral.toCharArray()) {
            if (c != '[' && c != ']') stringBuilder.append(c)
            if (c == '[') stringBuilder.insert(0, '[')
        }
        stringBuilder.append(";")

        stringBuilder.toString()
    } else {
        classLiteral
    }

/**
 * Tries to resolve [Class] from `classLiteral`.
 *
 * @param classLiteral Class literal.
 * @param <V>          Class type.
 * @return [Class] resolved from `classLiteral`.
 * @throws TypeResolutionException if class cannot be found.
 */
@Suppress("UNCHECKED_CAST")
@Throws(TypeResolutionException::class)
fun <V> resolveClass(classLiteral: String, classLoader: ClassLoader? = null): Class<V> {
    val fixed = fixName(classLiteral)
    return try {
        classForName(classLiteral, classLoader) as Class<V>
    } catch (e: ClassNotFoundException) {
        throw TypeResolutionException("Failed to resolve class literal: '$classLiteral' fixed: '$fixed'!", e)
    }
}

/**
 * Returns whether this [String] is a primitive type name, such as:
 *
 * - `byte`
 * - `short`
 * - `char`
 * - `int`
 * - `float`
 * - `double`
 * - `long`
 * - `boolean`
 * - `void`
 */
fun String.isPrimitiveName() =
    when(this) {
        "byte", "short", "char", "int", "float", "double", "long", "boolean", "void" -> true
        else -> false
    }