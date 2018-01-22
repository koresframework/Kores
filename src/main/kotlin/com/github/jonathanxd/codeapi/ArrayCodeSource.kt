/*
 *      CodeAPI - Java source and Bytecode generation framework <https://github.com/JonathanxD/CodeAPI>
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
package com.github.jonathanxd.codeapi

import java.util.*
import java.util.function.Consumer
import java.util.stream.Stream
import java.util.stream.StreamSupport

/**
 * CodeSource is an iterable of [CodeInstructions][CodeInstruction].
 *
 * This class is backed by an [Array] of [CodeInstruction].
 *
 * @see MutableCodeSource
 */
class ArrayCodeSource(private val parts: Array<CodeInstruction> = emptyArray()) : CodeSource() {

    constructor() : this(emptyArray())

    override val size: Int get() = this.parts.size

    override protected fun getAtIndex(index: Int): CodeInstruction =
        this.parts[index]

    override operator fun contains(o: Any): Boolean = this.parts.any { equals(it, o) }

    override operator fun plus(other: CodeInstruction): CodeSource =
        ArrayCodeSource(this.parts + other)

    override operator fun minus(other: CodeInstruction): CodeSource =
        ArrayCodeSource((this.parts.toList() - other).toTypedArray())

    override operator fun plus(other: Iterable<CodeInstruction>): CodeSource =
        ArrayCodeSource((this.toList() + other).toTypedArray())

    override operator fun minus(other: Iterable<CodeInstruction>): CodeSource =
        ArrayCodeSource(this.parts.filter { it in other }.toTypedArray())

    override fun indexOf(o: Any): Int =
        this.parts.indices.firstOrNull { equals(this.parts[it], o) } ?: -1

    override fun lastIndexOf(o: Any): Int =
        this.parts.indices.lastOrNull { Companion.equals(this.parts[it], o) } ?: -1

    override fun forEach(action: Consumer<in CodeInstruction>) {
        for (part in this.parts) {
            action.accept(part)
        }
    }

    override fun toArray(): Array<CodeInstruction> = this.parts.clone()

    override fun spliterator(): Spliterator<CodeInstruction> =
        Spliterators.spliterator(this.parts.clone(), Spliterator.ORDERED)

    override fun iterator(): Iterator<CodeInstruction> = Iterat()

    override fun subSource(fromIndex: Int, toIndex: Int): CodeSource {
        if (fromIndex < 0 || toIndex > this.size || fromIndex > toIndex)
            throw IndexOutOfBoundsException("fromIndex: $fromIndex, toIndex: $toIndex")

        return CodeSourceView(this, fromIndex, toIndex)
    }

    override fun listIterator(): ListIterator<CodeInstruction> = this.listIterator(0)

    override fun listIterator(index: Int): ListIterator<CodeInstruction> = ListIterat(index)

    override fun stream(): Stream<CodeInstruction> = StreamSupport.stream(this.spliterator(), false)

    override fun parallelStream(): Stream<CodeInstruction> =
        StreamSupport.stream(this.spliterator(), true)

    override fun toString(): String = if (this.isEmpty) "CodeSource[]" else "CodeSource[...]"

    private inner class Iterat : Iterator<CodeInstruction> {

        private var index = 0

        override fun hasNext(): Boolean = this.index < this@ArrayCodeSource.size

        override fun next(): CodeInstruction {
            if (!this.hasNext())
                throw java.util.NoSuchElementException()

            return this@ArrayCodeSource[this.index++]
        }
    }

    private inner class ListIterat internal constructor(index: Int) :
        ListIterator<CodeInstruction> {

        private var index = 0

        init {
            this.index = index
        }

        override fun hasNext(): Boolean = this.index < this@ArrayCodeSource.size

        override fun next(): CodeInstruction {
            if (!this.hasNext())
                throw java.util.NoSuchElementException()

            return this@ArrayCodeSource[this.index++]
        }

        override fun hasPrevious(): Boolean = this.index - 1 >= 0

        override fun previous(): CodeInstruction {

            if (!this.hasPrevious())
                throw java.util.NoSuchElementException()

            return this@ArrayCodeSource[--this.index]
        }

        override fun nextIndex(): Int = this.index

        override fun previousIndex(): Int = this.index - 1

    }


    companion object {

        @JvmStatic
        inline fun ArrayCodeSource(size: Int, init: (index: Int) -> CodeInstruction): CodeSource =
            ArrayCodeSource(Array(size, { init(it) }))

        /**
         * Helper method.
         */
        private fun equals(a: Any?, b: Any?): Boolean =
            a == null && b == null || a === b || a != null && b != null && a == b
    }
}

