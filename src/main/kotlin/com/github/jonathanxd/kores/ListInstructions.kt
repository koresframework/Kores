/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
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
package com.github.jonathanxd.kores

import java.util.*
import java.util.function.Consumer
import java.util.function.Predicate
import java.util.function.UnaryOperator
import java.util.stream.Stream

/**
 * A [MutableInstructions] backing to a [ArrayList].
 */
class ListInstructions(private val backingList: MutableList<Instruction>) : MutableInstructions(),
    Cloneable {

    constructor() : this(mutableListOf())

    constructor(iterable: Iterable<Instruction>) : this(iterable.toMutableList())

    constructor(a: Array<Instruction>) : this(a.toMutableList())

    override val size: Int
        get() = this.backingList.size

    override fun removeIf(filter: Predicate<in Instruction>): Boolean {
        return this.backingList.removeIf(filter)
    }

    override fun replaceAll(operator: UnaryOperator<Instruction>) {
        this.backingList.replaceAll(operator)
    }

    override fun sort(c: Comparator<in Instruction>) {
        this.backingList.sortedWith(c)
    }

    override fun add(instruction: Instruction): Boolean {
        return this.backingList.add(instruction)
    }

    override fun remove(o: Any): Boolean {
        return this.backingList.remove(o)
    }

    override fun addAll(c: Collection<Instruction>): Boolean {
        return this.backingList.addAll(c)
    }

    override fun addAll(index: Int, c: Collection<Instruction>): Boolean {
        return this.backingList.addAll(index, c)
    }

    override fun addAll(index: Int, c: Iterable<Instruction>): Boolean {
        return this.addAll(index, c.toList())
    }

    override fun removeAll(c: Collection<*>): Boolean {
        return this.backingList.removeAll(c)
    }

    override fun retainAll(c: Collection<*>): Boolean {
        return this.backingList.retainAll(c)
    }

    override fun removeAll(c: Iterable<Instruction>): Boolean {
        return this.backingList.removeAll(c)
    }

    override fun retainAll(c: Iterable<Instruction>): Boolean {
        return this.backingList.retainAll(c)
    }

    override fun clear() {
        this.backingList.clear()
    }

    override fun add(index: Int, element: Instruction) {
        return this.backingList.add(index, element)
    }

    override fun remove(index: Int): Instruction {
        return this.backingList.removeAt(index)
    }

    override operator fun plusAssign(other: Iterable<Instruction>) {
        this.addAll(other)
    }

    override operator fun minusAssign(other: Iterable<Instruction>) {
        this.removeAll(other)
    }

    override operator fun plusAssign(other: Instruction) {
        this.add(other)
    }

    override operator fun minusAssign(other: Instruction) {
        this.remove(other)
    }

    override fun subSource(fromIndex: Int, toIndex: Int): MutableInstructions {
        if (fromIndex < 0 || toIndex > this.size || fromIndex > toIndex)
            throw IndexOutOfBoundsException("fromIndex: $fromIndex, toIndex: $toIndex")

        return InstructionsView(this, fromIndex, toIndex)
    }

    override operator fun plus(other: Instruction): MutableInstructions =
        ListInstructions(this.backingList + other)

    override operator fun minus(other: Instruction): MutableInstructions =
        ListInstructions(this.backingList - other)

    override operator fun plus(other: Iterable<Instruction>): MutableInstructions =
        ListInstructions(this.backingList + other)

    override operator fun minus(other: Iterable<Instruction>): MutableInstructions =
        ListInstructions(this.backingList - other)

    override fun contains(o: Any): Boolean = this.backingList.contains(o)

    override fun iterator(): Iterator<Instruction> = this.backingList.iterator()

    override fun toArray(): Array<Instruction> = this.backingList.toTypedArray()

    override fun containsAll(c: Collection<*>): Boolean = this.backingList.containsAll(c)

    override fun getAtIndex(index: Int): Instruction = this.backingList[index]

    override operator fun set(index: Int, element: Instruction): Instruction =
        this.backingList.set(index, element)

    override fun indexOf(o: Any): Int = this.backingList.indexOf(o)

    override fun lastIndexOf(o: Any): Int = this.backingList.lastIndexOf(o)

    override fun listIterator(): ListIterator<Instruction> = this.backingList.listIterator()

    override fun listIterator(index: Int): ListIterator<Instruction> =
        this.backingList.listIterator(index)

    override fun clone(): Any = ListInstructions(this.backingList)

    override fun forEach(action: Consumer<in Instruction>) {
        this.backingList.forEach(action)
    }

    override fun spliterator(): Spliterator<Instruction> = this.backingList.spliterator()

    override fun equals(other: Any?): Boolean = this.backingList == other

    override fun hashCode(): Int = this.backingList.hashCode()

    override fun toString(): String =
        if (this.isEmpty) "ListInstructions[]" else "ListInstructions[...]"

    override fun stream(): Stream<Instruction> = this.backingList.stream()

    override fun parallelStream(): Stream<Instruction> = this.backingList.parallelStream()

    override fun toImmutable(): Instructions = Instructions.fromArray(this.toArray())

    override fun toMutable(): MutableInstructions = ListInstructions(this)

    companion object {
        @JvmStatic
        inline fun ListInstructions(
            size: Int,
            init: (index: Int) -> Instruction
        ): ListInstructions =
            ListInstructions(MutableList(size, init))
    }

}
