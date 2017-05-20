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

import java.util.Comparator
import java.util.Spliterator
import java.util.Spliterators
import java.util.function.Consumer
import java.util.function.Predicate
import java.util.function.UnaryOperator
import java.util.stream.Stream
import java.util.stream.StreamSupport

open class CodeSourceView(val original: CodeSource, val start: Int, var end: Int) : MutableCodeSource() {
    override val size: Int
        get() = start - end

    override fun getAtIndex(index: Int): CodeInstruction {
        return original[start + index]
    }

    override fun contains(o: Any): Boolean =
            this.any { it == o }

    override fun containsAll(c: Collection<*>): Boolean =
            c.all { it in this }

    override fun plus(other: CodeInstruction): CodeSource {
        val all = this.toList() + other

        return fromIterable(all)
    }

    override fun minus(other: CodeInstruction): CodeSource {
        val all = this.toList() - other

        return fromIterable(all)
    }

    override fun plus(other: Iterable<CodeInstruction>): CodeSource {
        val all = this.toList() + other

        return fromIterable(all)
    }

    override fun minus(other: Iterable<CodeInstruction>): CodeSource {
        val all = this.toList() - other

        return fromIterable(all)
    }

    override fun indexOf(o: Any): Int {
        val iter = this.listIterator()

        while (iter.hasNext()) {
            if (iter.next() == o)
                return iter.previousIndex()
        }

        return -1
    }

    override fun lastIndexOf(o: Any): Int {
        val iter = this.listIterator(this.size)

        while (iter.hasPrevious()) {
            if (iter.previous() == o)
                return iter.nextIndex()
        }

        return -1
    }

    override fun forEach(action: Consumer<in CodeInstruction>) {
        this.forEach { action.accept(it) }
    }

    override fun toArray(): Array<CodeInstruction> =
            this.toList().toTypedArray()


    override fun spliterator(): Spliterator<CodeInstruction> =
            Spliterators.spliteratorUnknownSize(this.listIterator(), Spliterator.ORDERED)

    override fun subSource(fromIndex: Int, toIndex: Int): CodeSource =
            this.original.subSource(fromIndex + this.start, toIndex + this.size)

    override fun toImmutable(): CodeSource =
            super.toImmutable()

    override fun toMutable(): MutableCodeSource =
            super.toMutable()

    override fun iterator(): Iterator<CodeInstruction> =
            SubIterator()

    override fun listIterator(): MutableListIterator<CodeInstruction> =
            SubIterator()

    override fun listIterator(index: Int): MutableListIterator<CodeInstruction> =
            SubIterator(index)

    override fun stream(): Stream<CodeInstruction> = StreamSupport.stream(this.spliterator(), false)
    override fun parallelStream(): Stream<CodeInstruction> = StreamSupport.stream(this.spliterator(), true)

    override fun toString(): String = if (this.isEmpty) "CodeSourceView[]" else "CodeSourceView[...]"

    inner class SubIterator(var index: Int = 0) : MutableListIterator<CodeInstruction> {

        override fun hasNext(): Boolean =
                this.index + 1 < this@CodeSourceView.size

        override fun hasPrevious(): Boolean =
                this.index - 1 >= 0

        override fun next(): CodeInstruction {
            if (!hasNext())
                throw NoSuchElementException()

            return this@CodeSourceView[this.index++]
        }

        override fun nextIndex(): Int =
                this.index


        override fun previous(): CodeInstruction {
            if (!hasNext())
                throw NoSuchElementException()

            return this@CodeSourceView[--this.index]
        }

        override fun add(element: CodeInstruction) {
            this@CodeSourceView.add(this.index, element)
        }

        override fun set(element: CodeInstruction) {
            this@CodeSourceView[this.index] = element
        }

        override fun previousIndex(): Int =
                this.index + 1

        override fun remove() {
            this@CodeSourceView.remove(this.index)
            this.index--
        }
    }


    // Mutable

    private val asMutable: MutableCodeSource
        get() = (this.original as? MutableCodeSource)
                ?: throw IllegalStateException("Invalid state, wrapped CodeSource must be mutable")

    override fun removeIf(filter: Predicate<in CodeInstruction>): Boolean {
        val iterator = this.listIterator()
        var any = false

        while (iterator.hasNext()) {
            val next = iterator.next()

            if (filter.test(next)) {
                any = true
                iterator.remove()
            }
        }

        return any
    }

    override fun replaceAll(operator: UnaryOperator<CodeInstruction>) {
        val iterator = this.listIterator()

        while (iterator.hasNext()) {
            val next = iterator.next()

            iterator.set(operator.apply(next))
        }
    }

    override fun sort(c: Comparator<in CodeInstruction>) {

        val array = this.toArray().sortedWith(c)

        array.forEachIndexed { index, instruction ->
            this[index] = instruction
        }
    }

    override fun add(instruction: CodeInstruction): Boolean {
        this.asMutable.add(this.size, instruction)
        this.end++
        return true
    }

    override operator fun set(index: Int, element: CodeInstruction): CodeInstruction {
        this.checkIndex(index)

        return this.asMutable.set(index + this.start, element)
    }

    override fun remove(o: Any): Boolean {
        val iterator = this.listIterator()

        while (iterator.hasNext()) {
            val next = iterator.next()

            if (next == o) {
                iterator.remove()
                return true
            }
        }

        return false
    }

    override fun addAll(c: Collection<CodeInstruction>): Boolean {
        var any = false

        for (instruction in c) {
            any = any or this.add(instruction)
        }

        return any
    }

    override fun addAll(index: Int, c: Collection<CodeInstruction>): Boolean {
        this.checkIndex(index)

        for ((pos, instruction) in c.withIndex()) {
            this.add(index + pos + this.start, instruction)
        }

        return true
    }

    override fun addAll(index: Int, c: Iterable<CodeInstruction>): Boolean {
        this.checkIndex(index)

        for ((pos, instruction) in c.withIndex()) {
            this.add(index + pos + this.start, instruction)
        }

        return true
    }

    override fun removeAll(c: Collection<*>): Boolean {
        var changed = false

        for (any in c) {
            if (any != null) {
                changed = changed or this.remove(any)
            }
        }

        return changed
    }

    override fun retainAll(c: Collection<*>): Boolean {
        val iterator = this.listIterator()
        var changed = false

        while (iterator.hasNext()) {
            val next = iterator.next()

            if (!c.contains(next)) {
                iterator.remove()
                changed = true
            }
        }

        return changed
    }

    override fun removeAll(c: Iterable<CodeInstruction>): Boolean {
        var changed = false

        for (any in c) {
            changed = changed or this.remove(any)
        }

        return changed
    }

    override fun retainAll(c: Iterable<CodeInstruction>): Boolean {
        val iterator = this.listIterator()
        var changed = false

        while (iterator.hasNext()) {
            val next = iterator.next()

            if (!c.contains(next)) {
                iterator.remove()
                changed = true
            }
        }

        return changed
    }

    override fun clear() {
        while (this.end != this.start) {
            this.remove(this.end - 1)
            --this.end
        }
    }

    override fun add(index: Int, element: CodeInstruction) {
        this.checkIndex(index)

        this.asMutable.add(index + this.start, element)
        this.end++
    }

    override fun remove(index: Int): CodeInstruction {
        this.checkIndex(index)

        val removed = this.asMutable.remove(index + this.start)
        this.end --

        return removed
    }

    override fun plusAssign(other: Iterable<CodeInstruction>) {
        other.forEach {
            this.add(it)
        }
    }

    override fun minusAssign(other: Iterable<CodeInstruction>) {
        other.forEach {
            this.remove(it)
        }
    }

    override fun plusAssign(other: CodeInstruction) {
        this.add(other)
    }

    override fun minusAssign(other: CodeInstruction) {
        this.remove(other)
    }

    private fun checkIndex(index: Int) {
        if(index > this.size)
            throw IndexOutOfBoundsException("Index: $index. Size: $size.")
    }

}
