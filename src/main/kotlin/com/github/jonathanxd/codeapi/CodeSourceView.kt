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

    override fun getAtIndex(index: Int): CodePart {
        return original[start + index]
    }

    override fun contains(o: Any): Boolean =
            this.any { it == o }

    override fun containsAll(c: Collection<*>): Boolean =
            c.all { it in this }

    override fun plus(other: CodePart): CodeSource {
        val all = this.toList() + other

        return fromIterable(all)
    }

    override fun minus(other: CodePart): CodeSource {
        val all = this.toList() - other

        return fromIterable(all)
    }

    override fun plus(other: Iterable<CodePart>): CodeSource {
        val all = this.toList() + other

        return fromIterable(all)
    }

    override fun minus(other: Iterable<CodePart>): CodeSource {
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

    override fun forEach(action: Consumer<in CodePart>) {
        this.forEach { action.accept(it) }
    }

    override fun toArray(): Array<CodePart> =
            this.toList().toTypedArray()


    @Suppress("UNCHECKED_CAST")
    override fun <T : CodePart> toArray(a: Array<T>): Array<T> =
            this.toList().let {
                it.forEachIndexed { index, codePart ->
                    a[index] = codePart as T
                }
                return@let a
            }

    override fun spliterator(): Spliterator<CodePart> =
            Spliterators.spliteratorUnknownSize(this.listIterator(), Spliterator.ORDERED)

    override fun subSource(fromIndex: Int, toIndex: Int): CodeSource =
            this.original.subSource(fromIndex + this.start, toIndex + this.size)

    override fun toImmutable(): CodeSource =
            super.toImmutable()

    override fun toMutable(): MutableCodeSource =
            super.toMutable()

    override fun iterator(): Iterator<CodePart> =
            SubIterator()

    override fun listIterator(): MutableListIterator<CodePart> =
            SubIterator()

    override fun listIterator(index: Int): MutableListIterator<CodePart> =
            SubIterator(index)

    override fun stream(): Stream<CodePart> = StreamSupport.stream(this.spliterator(), false)
    override fun parallelStream(): Stream<CodePart> = StreamSupport.stream(this.spliterator(), true)

    override fun toString(): String = if (this.isEmpty) "CodeSourceView[]" else "CodeSourceView[...]"

    inner class SubIterator(var index: Int = 0) : MutableListIterator<CodePart> {

        override fun hasNext(): Boolean =
                this.index + 1 < this@CodeSourceView.size

        override fun hasPrevious(): Boolean =
                this.index - 1 >= 0

        override fun next(): CodePart {
            if (!hasNext())
                throw NoSuchElementException()

            return this@CodeSourceView[this.index++]
        }

        override fun nextIndex(): Int =
                this.index


        override fun previous(): CodePart {
            if (!hasNext())
                throw NoSuchElementException()

            return this@CodeSourceView[--this.index]
        }

        override fun add(element: CodePart) {
            this@CodeSourceView.add(this.index, element)
        }

        override fun set(element: CodePart) {
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

    override fun removeIf(filter: Predicate<in CodePart>): Boolean {
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

    override fun replaceAll(operator: UnaryOperator<CodePart>) {
        val iterator = this.listIterator()

        while (iterator.hasNext()) {
            val next = iterator.next()

            iterator.set(operator.apply(next))
        }
    }

    override fun sort(c: Comparator<in CodePart>) {

        val array = this.toArray().sortedWith(c)

        array.forEachIndexed { index, codePart ->
            this[index] = codePart
        }
    }

    override fun trimToSize() {
        this.asMutable.trimToSize()
    }

    override fun ensureCapacity(minCapacity: Int) {
        this.asMutable.ensureCapacity((this.asMutable.size - this.size) + minCapacity)
    }

    override fun add(codePart: CodePart): Boolean {
        this.asMutable.add(this.size, codePart)
        this.end++
        return true
    }

    override operator fun set(index: Int, element: CodePart): CodePart {
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

    override fun addAll(c: Collection<CodePart>): Boolean {
        var any = false

        for (codePart in c) {
            any = any or this.add(codePart)
        }

        return any
    }

    override fun addAll(index: Int, c: Collection<CodePart>): Boolean {
        this.checkIndex(index)

        for ((pos, codePart) in c.withIndex()) {
            this.add(index + pos + this.start, codePart)
        }

        return true
    }

    override fun addAll(index: Int, c: Iterable<CodePart>): Boolean {
        this.checkIndex(index)

        for ((pos, codePart) in c.withIndex()) {
            this.add(index + pos + this.start, codePart)
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

    override fun removeAll(c: Iterable<CodePart>): Boolean {
        var changed = false

        for (any in c) {
            changed = changed or this.remove(any)
        }

        return changed
    }

    override fun retainAll(c: Iterable<CodePart>): Boolean {
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

    override fun add(index: Int, element: CodePart) {
        this.checkIndex(index)

        this.asMutable.add(index + this.start, element)
        this.end++
    }

    override fun remove(index: Int): CodePart {
        this.checkIndex(index)

        val removed = this.asMutable.remove(index + this.start)
        this.end --

        return removed
    }

    override fun plusAssign(other: Iterable<CodePart>) {
        other.forEach {
            this.add(it)
        }
    }

    override fun minusAssign(other: Iterable<CodePart>) {
        other.forEach {
            this.remove(it)
        }
    }

    override fun plusAssign(other: CodePart) {
        this.add(other)
    }

    override fun minusAssign(other: CodePart) {
        this.remove(other)
    }

    private fun checkIndex(index: Int) {
        if(index > this.size)
            throw IndexOutOfBoundsException("Index: $index. Size: $size.")
    }

}
