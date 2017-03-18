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
package com.github.jonathanxd.codeapi.gen.value

import java.util.*

/**
 * Parent information.
 */
class Parent<T>(val current: T, val target: Any, val parent: Parent<T>?) {

    /**
     * Consume this and parents
     *
     * @param consumer Consume this and parents
     */
    fun forEach(consumer: (Parent<T>) -> Unit) {
        var parent: Parent<T>? = this

        do {
            parent?.let { consumer(it) }
            parent = parent?.parent
        } while (parent != null)
    }

    /**
     * Find an element assignable to type `valueType`.
     *
     * @param valueType Type.
     * @return Found Parent, empty otherwise.
     */
    fun find(valueType: Class<*>): Optional<Parent<T>> {
        return find({ t -> valueType.isAssignableFrom(t.target::class.java) })
    }

    /**
     * Find an element of type `valueType`.
     *
     * @param valueType Type.
     * @return Found Parent, empty otherwise.
     */
    fun findEqual(valueType: Class<*>): Optional<Parent<T>> {
        return find { t -> valueType == t.target::class.java }
    }

    /**
     * Find an element
     *
     * @param predicate Predicate to test elements value ([.getCurrent])
     * @return Element or [Optional.empty] if element is not found
     */
    fun find(predicate: (Parent<T>) -> Boolean): Optional<Parent<T>> {
        var parent: Parent<T>? = this

        do {
            parent?.let {
                if (predicate(it)) {
                    return Optional.of(it)
                }
            }
            parent = parent?.parent
        } while (parent != null)

        return Optional.empty<Parent<T>>()
    }

    override fun toString(): String {
        val sj = StringJoiner(", ", "[", "]")

        var parent: Parent<T>? = this

        do {
            parent?.let {
                sj.add(it.current.toString() + ". Target -> " + it.target)
            }

            parent = parent?.parent
        } while (parent != null)

        return sj.toString()
    }

    companion object {

        /**
         * Create a [Parent] instance.
         *
         * @param current Current information.
         * @param target  Object processed.
         * @param parent  Parent.
         * @param T     Type of current information.
         * @return New [Parent] instance.
         */
        @JvmStatic
        fun <T> create(current: T, target: Any, parent: Parent<T>?): Parent<T> {
            return Parent(current, target, parent)
        }
    }
}
