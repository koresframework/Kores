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

import com.github.jonathanxd.iutils.`object`.Pair
import com.github.jonathanxd.iutils.`object`.TypedKey
import com.github.jonathanxd.iutils.data.TypedData
import com.github.jonathanxd.iutils.type.AbstractTypeInfo
import com.github.jonathanxd.iutils.type.TypeInfo
import java.util.Optional

/**
 * Associates [key] to [value] in receiver [TypedData]
 */
operator fun <T> TypedData.set(key: TypedKey<T>, value: T): Pair<*, TypeInfo<*>>? {
    return this.set(key.key, value, key.type)
}

/**
 * Gets value associated to [key] in receiver [TypedData].
 */
operator fun <T> TypedData.get(key: TypedKey<T>): T? {
    return this.getOrNull(key.key, key.type)
}

/**
 * Gets value associated to [key] in receiver [TypedData] boxing in an [Optional].
 */
fun <T> TypedData.getOptional(key: TypedKey<T>): Optional<T> {
    return Optional.ofNullable(this[key])
}

/**
 * Returns if [TypedData] contains a value associated to [key].
 */
fun <T> TypedData.containsKey(key: TypedKey<T>): Boolean {
    return this.contains(key.key, key.type)
}

/**
 * Returns if [TypedData] contains a value associated to [key] regardless the [TypeInfo].
 */
fun <T> TypedData.containsAnyKey(key: TypedKey<T>): Boolean {
    return this.contains(key.key)
}

// TypedKeyUtils

/**
 * Creates a [TypeInfo] of type [T].
 */
inline fun <reified T> typedKeyOf(key: Any): TypedKey<T> =
        TypedKey<T>(key, object : AbstractTypeInfo<T>(){})

/**
 * Adds [value] to list associated to this key
 */
fun <T> TypedKey<MutableList<T>>.add(data: TypedData, value: T) {
    this.getOrSet(data, mutableListOf()).add(value)
}

/**
 * Requires [data] to have any value associated to this key.
 */
fun <T> TypedKey<T>.require(data: TypedData): T = this.getOrNull(data)
        ?: throw IllegalStateException("Data of key TypedKey[key=${this.key}, type=${this.type}] is required. Current data map: ${data.typedDataMap}.")

/**
 * This value only lives in the [context], when the call of [context] finishes the key value is removed.
 *
 * Does not works with threads.
 */
inline fun <T> TypedKey<T>.inContext(data: TypedData, value: T, context: () -> Unit) {
    this.set(data, value)
    context()
    this.remove(data)
}