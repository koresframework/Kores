/*
 *      CodeAPI-DSL - Defines Kotlin DSL to create CodeAPI parts. <https://github.com/JonathanxD/CodeAPI>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2018 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
package com.github.jonathanxd.codeapi.dsl

abstract class DslColl<E> {
    abstract val collection: MutableCollection<E>

    operator fun Iterable<E>.unaryPlus() {
        collection.addAll(this)
    }

    operator fun E.unaryPlus() {
        collection += this
    }

    operator fun E.unaryMinus() {
        collection -= this
    }

    operator fun minusAssign(e: E) {
        collection -= e
    }

    operator fun minusAssign(e: Iterable<E>) {
        collection -= e
    }

    operator fun minusAssign(e: Array<out E>) {
        collection -= e
    }

    operator fun plusAssign(e: E) {
        collection += e
    }

    operator fun plusAssign(e: Iterable<E>) {
        collection += e
    }

    operator fun plusAssign(e: Array<out E>) {
        collection += e
    }

}

open class DslMap<K, V>(private val origin: MutableMap<K, V> = mutableMapOf()) {
    val map: Map<K, V> get() = origin

    infix fun K.to(v: V) {
        origin[this] = v
    }

    operator fun set(key: K, value: V) {
        this.origin[key] = value
    }

    operator fun Iterable<Pair<K, V>>.unaryPlus() {
        origin.putAll(this)
    }

    operator fun Pair<K, V>.unaryPlus() {
        origin[this.first] = this.second
    }

    operator fun K.unaryMinus() {
        origin.remove(this)
    }

    operator fun Pair<K, V>.unaryMinus() {
        origin.remove(this.first, this.second)
    }

    operator fun minusAssign(e: Pair<K, V>) {
        origin.remove(e.first, e.second)
    }

    operator fun minusAssign(e: Iterable<Pair<K, V>>) {
        e.forEach { (k, v) -> origin.remove(k, v) }
    }

    operator fun minusAssign(e: Array<out Pair<K, V>>) {
        e.forEach { (k, v) -> origin.remove(k, v) }
    }

    operator fun plusAssign(e: Pair<K, V>) {
        origin[e.first] = e.second
    }

    operator fun plusAssign(e: Iterable<Pair<K, V>>) {
        origin.putAll(e)
    }

    operator fun plusAssign(e: Array<out Pair<K, V>>) {
        origin.putAll(e)
    }
}

open class DslList<E>(private val origin: MutableList<E> = mutableListOf()) :
    DslColl<E>() {
    override val collection: MutableList<E>
        get() = origin
}

class DslSet<E>(private val _origin: MutableSet<E> = mutableSetOf()) :
    DslColl<E>() {
    override val collection: MutableSet<E>
        get() = _origin

}