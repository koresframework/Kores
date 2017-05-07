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

import java.util.*
import java.util.function.Consumer
import java.util.stream.Stream
import java.util.stream.StreamSupport

/**
 * CodeSource is an iterable of [CodeParts][CodePart].
 *
 * This class is backed by an [Array] of [CodePart].
 *
 * @see MutableCodeSource
 */
class ArrayCodeSource(val parts: Array<CodePart> = emptyArray()) : CodeSource() {

    constructor() : this(emptyArray())

    override val size: Int get() = this.parts.size


    override protected fun getAtIndex(index: Int): CodePart =
        this.parts[index]


    override operator fun contains(o: Any): Boolean {
        return this.parts.any { equals(it, o) }
    }

    override operator fun plus(other: CodePart): CodeSource {
        return ArrayCodeSource(this.parts + other)
    }

    override operator fun minus(other: CodePart): CodeSource {
        return ArrayCodeSource((this.parts.toList() - other).toTypedArray())
    }

    override operator fun plus(other: Iterable<CodePart>): CodeSource {
        return ArrayCodeSource((this.toList() + other).toTypedArray())
    }

    override operator fun minus(other: Iterable<CodePart>): CodeSource {
        return ArrayCodeSource(this.parts.filter { it in other }.toTypedArray())
    }

    override fun indexOf(o: Any): Int = this.parts.indices.firstOrNull { equals(this.parts[it], o) } ?: -1

    override fun lastIndexOf(o: Any): Int = this.parts.indices.lastOrNull { Companion.equals(this.parts[it], o) } ?: -1

    override fun forEach(action: Consumer<in CodePart>) {
        for (part in this.parts) {
            action.accept(part)
        }
    }

    override fun toArray(): Array<CodePart> = this.parts.clone()

    override fun spliterator(): Spliterator<CodePart> = Spliterators.spliterator(this.parts.clone(), Spliterator.ORDERED)

    override fun iterator(): Iterator<CodePart> = Iterat()

    override fun subSource(fromIndex: Int, toIndex: Int): CodeSource =
            CodeSourceView(this, fromIndex, toIndex)

    override fun listIterator(): ListIterator<CodePart> = this.listIterator(0)

    override fun listIterator(index: Int): ListIterator<CodePart> = ListIterat(index)

    override fun stream(): Stream<CodePart> = StreamSupport.stream(this.spliterator(), false)

    override fun parallelStream(): Stream<CodePart> = StreamSupport.stream(this.spliterator(), true)

    override fun toString(): String = if (this.isEmpty) "CodeSource[]" else "CodeSource[...]"

    private inner class Iterat : Iterator<CodePart> {

        private var index = 0

        override fun hasNext(): Boolean {
            return this.index < this@ArrayCodeSource.size
        }

        override fun next(): CodePart {
            if (!this.hasNext())
                throw java.util.NoSuchElementException()

            return this@ArrayCodeSource[this.index++]
        }
    }

    private inner class ListIterat internal constructor(index: Int) : ListIterator<CodePart> {

        private var index = 0

        init {
            this.index = index
        }

        override fun hasNext(): Boolean {
            return this.index < this@ArrayCodeSource.size
        }

        override fun next(): CodePart {
            if (!this.hasNext())
                throw java.util.NoSuchElementException()

            return this@ArrayCodeSource[this.index++]
        }

        override fun hasPrevious(): Boolean {
            return this.index - 1 >= 0
        }

        override fun previous(): CodePart {

            if (!this.hasPrevious())
                throw java.util.NoSuchElementException()

            return this@ArrayCodeSource[--this.index]
        }

        override fun nextIndex(): Int {
            return this.index
        }

        override fun previousIndex(): Int {
            return this.index - 1
        }

    }

    inline fun ArrayCodeSource(size: Int, init: (index: Int) -> CodePart): CodeSource = ArrayCodeSource(Array(size, { init(it) }))

    companion object {

        /**
         * Helper method.
         */
        private fun equals(a: Any?, b: Any?): Boolean {
            return a == null && b == null || a === b || a != null && b != null && a == b
        }
    }
}

