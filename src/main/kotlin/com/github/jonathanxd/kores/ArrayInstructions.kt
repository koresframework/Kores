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
import java.util.function.Consumer
import java.util.stream.Stream
import java.util.stream.StreamSupport

/**
 * Backed by an [Array] of [Instruction].
 *
 * @see MutableInstructions
 */
class ArrayInstructions(private val parts: Array<Instruction> = emptyArray()) : Instructions() {

    constructor() : this(emptyArray())

    override val size: Int get() = this.parts.size

    override fun getAtIndex(index: Int): Instruction =
        this.parts[index]

    override operator fun contains(o: Any): Boolean = this.parts.any { equals(it, o) }

    override operator fun plus(other: Instruction): Instructions =
        ArrayInstructions(this.parts + other)

    override operator fun minus(other: Instruction): Instructions =
        ArrayInstructions((this.parts.toList() - other).toTypedArray())

    override operator fun plus(other: Iterable<Instruction>): Instructions =
        ArrayInstructions((this.toList() + other).toTypedArray())

    override operator fun minus(other: Iterable<Instruction>): Instructions =
        ArrayInstructions(this.parts.filter { it in other }.toTypedArray())

    override fun indexOf(o: Any): Int =
        this.parts.indices.firstOrNull { equals(this.parts[it], o) } ?: -1

    override fun lastIndexOf(o: Any): Int =
        this.parts.indices.lastOrNull { Companion.equals(this.parts[it], o) } ?: -1

    override fun forEach(action: Consumer<in Instruction>) {
        for (part in this.parts) {
            action.accept(part)
        }
    }

    override fun toArray(): Array<Instruction> = this.parts.clone()

    override fun spliterator(): Spliterator<Instruction> =
        Spliterators.spliterator(this.parts.clone(), Spliterator.ORDERED)

    override fun iterator(): Iterator<Instruction> = Iterat()

    override fun subSource(fromIndex: Int, toIndex: Int): Instructions {
        if (fromIndex < 0 || toIndex > this.size || fromIndex > toIndex)
            throw IndexOutOfBoundsException("fromIndex: $fromIndex, toIndex: $toIndex")

        return InstructionsView(this, fromIndex, toIndex)
    }

    override fun listIterator(): ListIterator<Instruction> = this.listIterator(0)

    override fun listIterator(index: Int): ListIterator<Instruction> = ListIterat(index)

    override fun stream(): Stream<Instruction> = StreamSupport.stream(this.spliterator(), false)

    override fun parallelStream(): Stream<Instruction> =
        StreamSupport.stream(this.spliterator(), true)

    override fun toString(): String = if (this.isEmpty) "CodeSource[]" else "CodeSource[...]"

    private inner class Iterat : Iterator<Instruction> {

        private var index = 0

        override fun hasNext(): Boolean = this.index < this@ArrayInstructions.size

        override fun next(): Instruction {
            if (!this.hasNext())
                throw java.util.NoSuchElementException()

            return this@ArrayInstructions[this.index++]
        }
    }

    private inner class ListIterat internal constructor(index: Int) :
        ListIterator<Instruction> {

        private var index = 0

        init {
            this.index = index
        }

        override fun hasNext(): Boolean = this.index < this@ArrayInstructions.size

        override fun next(): Instruction {
            if (!this.hasNext())
                throw java.util.NoSuchElementException()

            return this@ArrayInstructions[this.index++]
        }

        override fun hasPrevious(): Boolean = this.index - 1 >= 0

        override fun previous(): Instruction {

            if (!this.hasPrevious())
                throw java.util.NoSuchElementException()

            return this@ArrayInstructions[--this.index]
        }

        override fun nextIndex(): Int = this.index

        override fun previousIndex(): Int = this.index - 1

    }


    companion object {

        @JvmStatic
        inline fun ArrayInstructions(size: Int, init: (index: Int) -> Instruction): Instructions =
            ArrayInstructions(Array(size, { init(it) }))

        /**
         * Helper method.
         */
        private fun equals(a: Any?, b: Any?): Boolean =
            a == null && b == null || a === b || a != null && b != null && a == b
    }
}

