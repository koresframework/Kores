/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2021 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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

import com.github.jonathanxd.iutils.type.Primitive

/**
 * A [KoresType] backing to a loaded [Class] ([loadedType]).
 *
 * @param T Type of the Class.
 */
interface LoadedKoresType<T> : KoresType {

    /**
     * Loaded class.
     */
    val loadedType: Class<T>

    override val isArray: Boolean
        get() = loadedType.isArray

    override val isVirtual: Boolean
        get() = false

    override val type: String
        get() = this.loadedType.typeName.let {
            when (it) {
                "B" -> "byte"
                "S" -> "short"
                "I" -> "int"
                "C" -> "char"
                "D" -> "double"
                "F" -> "float"
                "J" -> "long"
                "Z" -> "boolean"
                "V" -> "void"
                else -> it
            }
        }

    override val canonicalName: String
        get() = this.loadedType.canonicalName

    override val isInterface: Boolean
        get() = loadedType.isInterface

    override val isPrimitive: Boolean
        get() = loadedType.isPrimitive

    override val wrapperType: KoresType?
        get() {
            val box = Primitive.box(loadedType)

            if (box != null) {
                return box.koresType
            }

            return null
        }

    override val primitiveType: KoresType?
        get() {
            val unbox = Primitive.unbox(loadedType)

            if (unbox != null) {
                return unbox.koresType
            }

            return null
        }

    override val defaultResolver: KoresTypeResolver<Class<*>>
        get() = KoresTypeResolver.Java(
            this.loadedType.classLoader ?: ClassLoader.getSystemClassLoader()
        )

    fun toLoadedArray(array: Class<T>, dimensions: Int): LoadedKoresType<T> {
        return LoadedArrayKoresType(array, this, dimensions)
    }
}
