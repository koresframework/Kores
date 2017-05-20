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
package com.github.jonathanxd.codeapi

import java.util.Spliterator
import java.util.function.Consumer
import java.util.stream.Stream

/**
 * Abstract [CodeInstruction] iterable.
 *
 * @see ArrayCodeSource
 * @see MutableCodeSource
 */
abstract class CodeSource : Iterable<CodeInstruction>, CodePart {

    /**
     * Size of source.
     */
    abstract val size: Int

    /**
     * True if is empty, false otherwise.
     */
    val isEmpty: Boolean get() = this.size == 0

    /**
     * True if is not empty, false otherwise.
     */
    val isNotEmpty: Boolean get() = !this.isEmpty

    /**
     * Gets element at index [index].
     *
     * @throws IndexOutOfBoundsException If the [index] is either negative or greater than [size].
     */
    operator fun get(index: Int): CodeInstruction {
        if (index < 0 || index >= this.size)
            throw IndexOutOfBoundsException("Index: $index. Size: $size")

        return this.getAtIndex(index)
    }

    /**
     * Gets element at index [index]. This method should only be called if the index
     * is in the bounds.
     */
    abstract protected fun getAtIndex(index: Int): CodeInstruction

    /**
     * Returns true if this [CodeSource] contains [o].
     */
    abstract operator fun contains(o: Any): Boolean

    /**
     * Returns true if this [CodeSource] contains all elements of [c].
     */
    open fun containsAll(c: Collection<*>): Boolean {
        return c.all { this.contains(it) }
    }

    /**
     * Adds [other] to this [CodeSource].
     */
    abstract operator fun plus(other: CodeInstruction): CodeSource

    /**
     * Removes [other] from this [CodeSource].
     */
    abstract operator fun minus(other: CodeInstruction): CodeSource

    /**
     * Adds all [CodeInstruction] of [other] to this [CodeSource]
     */
    abstract operator fun plus(other: Iterable<CodeInstruction>): CodeSource

    /**
     * Removes all [CodeInstruction] of [other] from this [CodeSource]
     */
    abstract operator fun minus(other: Iterable<CodeInstruction>): CodeSource

    /**
     * Returns the index of [o] in this [CodeSource].
     */
    abstract fun indexOf(o: Any): Int

    /**
     * Returns the last index of [o] in this [CodeSource].
     */
    abstract fun lastIndexOf(o: Any): Int

    /**
     * For each all elements of this [CodeSource].
     */
    abstract override fun forEach(action: Consumer<in CodeInstruction>)

    /**
     * Creates an array of [CodeInstruction] of all elements of this [CodeSource].
     */
    abstract fun toArray(): Array<CodeInstruction>

    /**
     * Creates a [Spliterator] from elements of this [CodeSource].
     */
    abstract override fun spliterator(): Spliterator<CodeInstruction>

    /**
     * Creates an [Iterator] that iterates elements of this [CodeSource].
     */
    abstract override fun iterator(): Iterator<CodeInstruction>

    /**
     * Creates a view of this [CodeSource] from index [fromIndex] to index [toIndex],
     * changes to this [CodeSource] is reflected in current [CodeSource].
     */
    abstract fun subSource(fromIndex: Int, toIndex: Int): CodeSource

    /**
     * Creates a immutable [CodeSource] with elements of this [CodeSource].
     */
    open fun toImmutable(): CodeSource = ArrayCodeSource(this.toArray())

    /**
     * Creates a mutable [CodeSource] with elements of this [CodeSource].
     */
    open fun toMutable(): MutableCodeSource = ListCodeSource(this)

    /**
     * Creates a [ListIterator] that iterates this [CodeSource].
     */
    abstract fun listIterator(): ListIterator<CodeInstruction>

    /**
     * Creates a [ListIterator] that iterates this [CodeSource] and starts at [index].
     */
    abstract fun listIterator(index: Int): ListIterator<CodeInstruction>

    /**
     * Creates a [Stream] of this [CodeSource].
     */
    abstract fun stream(): Stream<CodeInstruction>

    /**
     * Creates a parallel [Stream] of this [CodeSource] (which may or may not be parallel).
     */
    abstract fun parallelStream(): Stream<CodeInstruction>

    override fun toString(): String = if (this.isEmpty) "CodeSource[]" else "CodeSource[...]"

    /**
     * Factory methods to create immutable [CodeSource].
     */
    companion object {
        private val EMPTY = emptyArray<CodeInstruction>()
        private val EMPTY_CODE_SOURCE = ArrayCodeSource(EMPTY)

        /**
         * Returns a empty immutable [CodeSource].
         */
        @JvmStatic
        fun empty(): CodeSource {
            return CodeSource.EMPTY_CODE_SOURCE
        }

        /**
         * Creates a immutable [CodeSource] with all elements of [parts].
         */
        @JvmStatic
        fun fromArray(parts: Array<CodeInstruction>): CodeSource {
            return ArrayCodeSource(parts.clone())
        }

        /**
         * Creates a immutable [CodeSource] with a single [part].
         */
        @JvmStatic
        fun fromPart(part: CodeInstruction): CodeSource {
            return ArrayCodeSource(arrayOf(part))
        }

        /**
         * Creates a immutable [CodeSource] with all elements of vararg [parts].
         */
        @JvmStatic
        fun fromVarArgs(vararg parts: CodeInstruction): CodeSource {
            return ArrayCodeSource(Array(parts.size, { parts[it] }))
        }

        /**
         * Creates a immutable [CodeSource] from elements of [iterable].
         */
        @Suppress("UNCHECKED_CAST")
        @JvmStatic
        fun fromIterable(iterable: Iterable<CodeInstruction>): CodeSource {
            if (iterable is Collection<CodeInstruction>)
                return ArrayCodeSource(iterable.toTypedArray())

            return ArrayCodeSource(iterable.toList().toTypedArray())
        }

        /**
         * Creates a immutable [CodeSource] from elements of generic [iterable].
         */
        @Suppress("UNCHECKED_CAST")
        @JvmStatic
        fun fromGenericIterable(iterable: Iterable<*>): CodeSource {
            if (iterable is Collection<*>)
                return ArrayCodeSource((iterable as Collection<CodeInstruction>).toTypedArray())

            return ArrayCodeSource((iterable as Iterable<CodeInstruction>).toList().toTypedArray())
        }

        /**
         * Creates a immutable [CodeSource] with all elements of [CodeSources][CodeSource] of [iterable].
         */
        @Suppress("UNCHECKED_CAST")
        @JvmStatic
        fun fromCodeSourceIterable(iterable: Iterable<CodeSource>): CodeSource {
            return ArrayCodeSource(iterable.flatMap { it }.toTypedArray())
        }

    }
}