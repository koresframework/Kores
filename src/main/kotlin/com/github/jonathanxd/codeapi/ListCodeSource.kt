/*
 *      CodeAPI - Framework to generate Java code and Bytecode code. <https://github.com/JonathanxD/CodeAPI>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2018 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/ & https://github.com/TheRealBuggy/) <jonathan.scripter@programmer.net>
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
import java.util.function.Predicate
import java.util.function.UnaryOperator
import java.util.stream.Stream

/**
 * A [MutableCodeSource] backing to a [ArrayList].
 */
class ListCodeSource(private val backingList: MutableList<CodeInstruction>) : MutableCodeSource(),
    Cloneable {

    constructor() : this(mutableListOf())

    constructor(iterable: Iterable<CodeInstruction>) : this(iterable.toMutableList())

    constructor(a: Array<CodeInstruction>) : this(a.toMutableList())

    override val size: Int
        get() = this.backingList.size

    override fun removeIf(filter: Predicate<in CodeInstruction>): Boolean {
        return this.backingList.removeIf(filter)
    }

    override fun replaceAll(operator: UnaryOperator<CodeInstruction>) {
        this.backingList.replaceAll(operator)
    }

    override fun sort(c: Comparator<in CodeInstruction>) {
        this.backingList.sortedWith(c)
    }

    override fun add(instruction: CodeInstruction): Boolean {
        return this.backingList.add(instruction)
    }

    override fun remove(o: Any): Boolean {
        return this.backingList.remove(o)
    }

    override fun addAll(c: Collection<CodeInstruction>): Boolean {
        return this.backingList.addAll(c)
    }

    override fun addAll(index: Int, c: Collection<CodeInstruction>): Boolean {
        return this.backingList.addAll(index, c)
    }

    override fun addAll(index: Int, c: Iterable<CodeInstruction>): Boolean {
        return this.addAll(index, c.toList())
    }

    override fun removeAll(c: Collection<*>): Boolean {
        return this.backingList.removeAll(c)
    }

    override fun retainAll(c: Collection<*>): Boolean {
        return this.backingList.retainAll(c)
    }

    override fun removeAll(c: Iterable<CodeInstruction>): Boolean {
        return this.backingList.removeAll(c)
    }

    override fun retainAll(c: Iterable<CodeInstruction>): Boolean {
        return this.backingList.retainAll(c)
    }

    override fun clear() {
        this.backingList.clear()
    }

    override fun add(index: Int, element: CodeInstruction) {
        return this.backingList.add(index, element)
    }

    override fun remove(index: Int): CodeInstruction {
        return this.backingList.removeAt(index)
    }

    override operator fun plusAssign(other: Iterable<CodeInstruction>) {
        this.addAll(other)
    }

    override operator fun minusAssign(other: Iterable<CodeInstruction>) {
        this.removeAll(other)
    }

    override operator fun plusAssign(other: CodeInstruction) {
        this.add(other)
    }

    override operator fun minusAssign(other: CodeInstruction) {
        this.remove(other)
    }

    override fun subSource(fromIndex: Int, toIndex: Int): MutableCodeSource {
        if (fromIndex < 0 || toIndex > this.size || fromIndex > toIndex)
            throw IndexOutOfBoundsException("fromIndex: $fromIndex, toIndex: $toIndex")

        return CodeSourceView(this, fromIndex, toIndex)
    }

    override operator fun plus(other: CodeInstruction): MutableCodeSource =
        ListCodeSource(this.backingList + other)

    override operator fun minus(other: CodeInstruction): MutableCodeSource =
        ListCodeSource(this.backingList - other)

    override operator fun plus(other: Iterable<CodeInstruction>): MutableCodeSource =
        ListCodeSource(this.backingList + other)

    override operator fun minus(other: Iterable<CodeInstruction>): MutableCodeSource =
        ListCodeSource(this.backingList - other)

    override fun contains(o: Any): Boolean = this.backingList.contains(o)

    override fun iterator(): Iterator<CodeInstruction> = this.backingList.iterator()

    override fun toArray(): Array<CodeInstruction> = this.backingList.toTypedArray()

    override fun containsAll(c: Collection<*>): Boolean = this.backingList.containsAll(c)

    override fun getAtIndex(index: Int): CodeInstruction = this.backingList[index]

    override operator fun set(index: Int, element: CodeInstruction): CodeInstruction =
        this.backingList.set(index, element)

    override fun indexOf(o: Any): Int = this.backingList.indexOf(o)

    override fun lastIndexOf(o: Any): Int = this.backingList.lastIndexOf(o)

    override fun listIterator(): ListIterator<CodeInstruction> = this.backingList.listIterator()

    override fun listIterator(index: Int): ListIterator<CodeInstruction> =
        this.backingList.listIterator(index)

    override fun clone(): Any = ListCodeSource(this.backingList)

    override fun forEach(action: Consumer<in CodeInstruction>) {
        this.backingList.forEach(action)
    }

    override fun spliterator(): Spliterator<CodeInstruction> = this.backingList.spliterator()

    override fun equals(other: Any?): Boolean = this.backingList == other

    override fun hashCode(): Int = this.backingList.hashCode()

    override fun toString(): String =
        if (this.isEmpty) "MutableCodeSource[]" else "MutableCodeSource[...]"

    override fun stream(): Stream<CodeInstruction> = this.backingList.stream()

    override fun parallelStream(): Stream<CodeInstruction> = this.backingList.parallelStream()

    override fun toImmutable(): CodeSource = CodeSource.fromArray(this.toArray())

    override fun toMutable(): MutableCodeSource = ListCodeSource(this)

    companion object {
        @JvmStatic
        inline fun ListCodeSource(
            size: Int,
            init: (index: Int) -> CodeInstruction
        ): ListCodeSource =
            ListCodeSource(MutableList(size, init))
    }

}
