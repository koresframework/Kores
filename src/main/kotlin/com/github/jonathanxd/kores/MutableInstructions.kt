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
package com.github.jonathanxd.kores

import java.util.*
import java.util.function.Predicate
import java.util.function.UnaryOperator

/**
 * A mutable [Instructions] backing to a [ArrayList] instead of to an [Array].
 */
abstract class MutableInstructions : Instructions(), Cloneable {

    /**
     * Removes all [Instruction]s that matches [filter].
     */
    abstract fun removeIf(filter: Predicate<in Instruction>): Boolean

    /**
     * Replaces each element with element returned by [operator].
     */
    abstract fun replaceAll(operator: UnaryOperator<Instruction>)

    /**
     * Sorts this [MutableInstructions] using [Comparator] [c].
     */
    abstract fun sort(c: Comparator<in Instruction>)

    /**
     * Adds [instruction] to list.
     */
    abstract fun add(instruction: Instruction): Boolean

    /**
     * Removes [o] from list.
     */
    abstract fun remove(o: Any): Boolean

    /**
     * Adds all [Instruction] of [c] into this list.
     */
    abstract fun addAll(c: Collection<Instruction>): Boolean

    /**
     * Adds all [Instruction] of [c] into this list.
     */
    fun addAll(c: Iterable<Instruction>): Boolean {
        var any = false

        for (part in c) {
            any = any or this.add(part)
        }

        return any
    }

    /**
     * Adds all [Instruction] of [c] into this list at [index].
     */
    abstract fun addAll(index: Int, c: Collection<Instruction>): Boolean

    /**
     * Adds all [Instruction] of [c] into this list at [index].
     */
    abstract fun addAll(index: Int, c: Iterable<Instruction>): Boolean

    /**
     * Removes all elements which is present in [c] from this list.
     */
    abstract fun removeAll(c: Collection<*>): Boolean

    /**
     * Retains all elements which is present in [c] in this list.
     */
    abstract fun retainAll(c: Collection<*>): Boolean

    /**
     * Removes all elements which is present in [c] from this list.
     */
    abstract fun removeAll(c: Iterable<Instruction>): Boolean

    /**
     * Retains all elements which is present in [c] in this list.
     */
    abstract fun retainAll(c: Iterable<Instruction>): Boolean

    /**
     * Clears this list.
     */
    abstract fun clear()

    /**
     * Adds [element] at [index].
     */
    abstract fun add(index: Int, element: Instruction)

    /**
     * Sets element at [index] to [element].
     */
    abstract operator fun set(index: Int, element: Instruction): Instruction

    /**
     * Removes [Instruction] which is at [index]. And returns removed element.
     */
    abstract fun remove(index: Int): Instruction

    /**
     * Adds all elements of [other] to this list.
     */
    abstract operator fun plusAssign(other: Iterable<Instruction>)

    /**
     * Removes all elements of [other] from this list.
     */
    abstract operator fun minusAssign(other: Iterable<Instruction>)

    /**
     * Adds [other] to this list.
     */
    abstract operator fun plusAssign(other: Instruction)

    /**
     * Removes [other] from this list.
     */
    abstract operator fun minusAssign(other: Instruction)

    override fun toString(): String =
        if (this.isEmpty) "MutableInstructions[]" else "MutableInstructions[...]"

    companion object {

        /**
         * Create a [MutableInstructions].
         */
        @JvmStatic
        fun create(): MutableInstructions = ListInstructions()

        /**
         * Create a [MutableInstructions] from a copy of [list].
         */
        @JvmStatic
        fun create(list: List<Instruction>): MutableInstructions =
            ListInstructions(list.toMutableList())

        /**
         * Create a [MutableInstructions] delegating to [list].
         */
        @JvmStatic
        fun delegate(list: MutableList<Instruction>): MutableInstructions =
            ListInstructions(list)

    }
}
