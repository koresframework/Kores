/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2019 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
package com.github.jonathanxd.kores.util

import com.github.jonathanxd.iutils.type.TypeInfo
import com.github.jonathanxd.kores.type.Generic
import com.github.jonathanxd.kores.type.GenericType
import com.github.jonathanxd.kores.type.koresType

/**
 * Convert type info to [Generic].
 */
fun <T> TypeInfo<T>.toGeneric(): GenericType {
    val aClass = this.typeClass
    val related = this.typeParameters

    var generic = Generic.type(aClass.koresType)

    if (related.isNotEmpty()) {
        generic = generic.of(*related.map { it.toGeneric() }.toTypedArray())
    }

    return generic
}

fun GenericType.toTypeInfo(): TypeInfo<*> =
    TypeInfo.builderOf<Any?>(this.type)
        .also { bd ->
            this.bounds.forEach {
                if (it.type is GenericType) {
                    bd.of((it.type as GenericType).toTypeInfo())
                } else {
                    bd.of(it.type.type)
                }
            }
        }
        .build()
