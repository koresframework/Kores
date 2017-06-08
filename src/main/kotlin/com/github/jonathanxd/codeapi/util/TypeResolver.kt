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
package com.github.jonathanxd.codeapi.util

import com.github.jonathanxd.codeapi.Types
import com.github.jonathanxd.codeapi.type.CodeType
import java.lang.reflect.Type

/**
 * Resolves a class name which may vary to a [Type] and cache the resolved type.
 */
@FunctionalInterface
interface TypeResolver {

    /**
     * Resolves type with [name] to a [Type]. If [isInterface] is `true`, and resolved
     * type is cached as non-interface, then the type should be replaced with one that is marked as interface.
     */
    fun resolve(name: String, isInterface: Boolean): Type

}

/**
 * Resolve type as unknown, same as [resolveClass]
 */
fun TypeResolver.resolveUnknown(name: String): Type {
    return this.resolve(name, false)
}

/**
 * Resolve type as interface.
 */
fun TypeResolver.resolveInterface(name: String): Type {
    return this.resolve(name, true)
}

/**
 * Resolve type as class.
 */
fun TypeResolver.resolveClass(name: String): Type {
    return this.resolve(name, false)
}

/**
 * Simple type resolver
 */
class SimpleResolver(private val wrapped: TypeResolver, private val resolveLoadedClasses: Boolean) : TypeResolver {

    override fun resolve(name: String, isInterface: Boolean): Type {
        @Suppress("NAME_SHADOWING")
        var name = name
        if (name == Types.BYTE.javaSpecName) {
            return Types.BYTE
        } else if (name == Types.SHORT.javaSpecName) {
            return Types.SHORT
        } else if (name == Types.INT.javaSpecName) {
            return Types.INT
        } else if (name == Types.FLOAT.javaSpecName) {
            return Types.FLOAT
        } else if (name == Types.DOUBLE.javaSpecName) {
            return Types.DOUBLE
        } else if (name == Types.LONG.javaSpecName) {
            return Types.LONG
        } else if (name == Types.CHAR.javaSpecName) {
            return Types.CHAR
        } else if (name == Types.STRING.javaSpecName) {
            return Types.STRING
        } else if (name == Types.BOOLEAN.javaSpecName) {
            return Types.BOOLEAN
        } else if (name == Types.VOID.javaSpecName) {
            return Types.VOID
        }

        name = name.replace('/', '.')

        if (name.startsWith("L") && name.endsWith(";")) {
            name = name.substring(1, name.length - 1)
        }

        if (this.resolveLoadedClasses) {
            try {
                val aClass = Class.forName(name)

                if (aClass != null)
                    return aClass.codeType
            } catch (ignored: Throwable) {
            }

        }

        return this.wrapped.resolve(name, isInterface)
    }
}
