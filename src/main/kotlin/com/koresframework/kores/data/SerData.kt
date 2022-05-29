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
package com.koresframework.kores.data

import com.koresframework.kores.serialization.KeySerializer
import com.koresframework.kores.serialization.KoresDataSerializer
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.util.*
import java.util.concurrent.ConcurrentHashMap

@Serializable(with = KoresDataSerializer::class)
class KoresData(dataMap: Map<SerKey, SerData> = emptyMap()) {
    private val dataMap = ConcurrentHashMap(dataMap)

    val dataMapView = Collections.unmodifiableMap(this.dataMap)

    fun <T: Any> offer(key: Key<T>, value: T) {
        this.dataMap[SerKey(key.name)] = SerData(value)
    }

    fun <T: Any> query(key: Key<T>): T? =
        this.dataMap[SerKey(key.name)]?.let { it.value as T }

    fun from(other: KoresData) {
        this.dataMap.putAll(other.dataMap)
    }
}

@Serializable
data class Key<T: Any>(val name: String)

@Serializable(with = KeySerializer::class)
data class SerKey(val name: String)

@Serializable
data class SerData(@Contextual val value: Any)