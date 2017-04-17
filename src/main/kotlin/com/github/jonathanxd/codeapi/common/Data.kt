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
package com.github.jonathanxd.codeapi.common

import com.github.jonathanxd.iutils.`object`.Node
import com.github.jonathanxd.iutils.function.collector.BiCollectors
import com.github.jonathanxd.iutils.function.stream.BiStreams
import com.github.jonathanxd.iutils.function.stream.MapStream
import com.github.jonathanxd.iutils.map.ListHashMap
import java.util.*

class Data @JvmOverloads constructor(val parent: Data? = null) : Cloneable {

    private val map = ListHashMap<String, Any>()

    fun registerData(key: String, obj: Any) {
        this.map.putToList(key, obj)
    }

    fun unregisterData(key: String, obj: Any) {
        this.map.removeFromList(key, obj)
    }

    fun unregisterAllData(key: String) {
        this.map.remove(key)
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> getAllAsList(key: String): List<T> {
        return (this.map[key] as List<T>?)?.let { ArrayList(it) }.orEmpty()
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> getOptional(key: String): Optional<T> {
        return Optional.ofNullable(this.map[key]?.lastOrNull()) as Optional<T>
    }

    @Suppress("UNCHECKED_CAST")
    fun <T : Any> getOrCreate(key: String, defaultValue: Lazy<T>): T {
        val opt = this.getOptional<T>(key)

        if (opt.isPresent)
            return opt.get()
        else {
            val value = defaultValue.value
            this.registerData(key, value)
            return value
        }
    }


    @Suppress("UNCHECKED_CAST")
    fun <T : Any> getOrCreate(key: String, defaultValue: T): T {

        val opt = this.getOptional<T>(key)

        if (opt.isPresent)
            return opt.get()
        else {
            this.registerData(key, defaultValue)
            return defaultValue
        }

    }

    @Suppress("UNCHECKED_CAST")
    @JvmOverloads
    fun <T> getRequired(key: String, message: String = "Cannot find required key: $key"): T {
        return this.map[key]?.lastOrNull() as? T ?: throw IllegalStateException(message)
    }

    fun newChild(): Data = Data(this)

    override public fun clone(): Data {
        val clone = Data(this.parent)

        val clonedMap = BiStreams.mapStream(this.map).map { t, u -> Node(t, ArrayList(u)) }.collect(BiCollectors.toHashMap<String, List<Any>>())

        clone.map.putAll(clonedMap)

        return clone
    }

    override fun toString(): String {
        return "Data[${this.map}]"
    }
}