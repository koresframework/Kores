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
package com.koresframework.kores.type

import com.koresframework.kores.serialization.TypeSerializer
import kotlinx.serialization.Serializable

/**
 * A [ArrayKoresType] of a [loadedType].
 *
 * @param T Type of the Class.
 */
@Serializable(with = TypeSerializer::class)
internal class LoadedArrayKoresType<T>(
    override val loadedType: Class<T>,
    component: LoadedKoresType<*>,
    dimensions: Int
) : ArrayKoresType(component, dimensions), LoadedKoresType<T> {

    override val isVirtual: Boolean
        get() = false

    override val isArray: Boolean
        get() = super<ArrayKoresType>.isArray

    override val type: String
        get() = super<ArrayKoresType>.type

    override val isInterface: Boolean
        get() = super<ArrayKoresType>.isInterface

    override val isPrimitive: Boolean
        get() = super<ArrayKoresType>.isPrimitive

    override val canonicalName: String
        get() = super<ArrayKoresType>.canonicalName

    override fun equals(other: Any?): Boolean = this.eq(other)

    override fun hashCode(): Int = this.hash()

    override val defaultResolver: KoresTypeResolver<Class<*>>
        get() = KoresTypeResolver.Java(
            this.loadedType.classLoader ?: ClassLoader.getSystemClassLoader()
        )

}
