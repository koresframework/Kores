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

import com.github.jonathanxd.codeapi.util.IterableUtil
import java.util.*
import java.util.function.Consumer
import java.util.stream.Stream
import java.util.stream.StreamSupport

open class CodeSource private constructor(private val parts: Array<CodePart> = emptyArray()) : Iterable<CodePart>, CodePart {

    protected constructor(): this(emptyArray())

    open val size: Int = this.parts.size

    open val isEmpty: Boolean = this.parts.isEmpty()

    open operator fun get(index: Int): CodePart {
        if (index >= this.parts.size)
            throw IndexOutOfBoundsException("Index: " + index + ". Size: " + this.parts.size + ".")

        return this.parts[index]
    }

    open operator fun contains(o: Any): Boolean {
        return this.parts.any { Companion.equals(it, o) }
    }


    open fun containsAll(c: Collection<*>): Boolean {
        return c.any { this.contains(it) }
    }


    open fun indexOf(o: Any): Int = this.parts.indices.firstOrNull { Companion.equals(this.parts[it], o) } ?: -1

    open fun lastIndexOf(o: Any): Int = this.parts.indices.reversed().firstOrNull { Companion.equals(this.parts[it], o) } ?: -1

    override fun forEach(action: Consumer<in CodePart>) {
        for (part in this.parts) {
            action.accept(part)
        }
    }

    open fun toArray(): Array<CodePart> = this.parts.clone()

    open fun <T> toArray(a: Array<T>): Array<T> = Arrays.copyOf(this.parts, this.parts.size, a.javaClass)

    override fun spliterator(): Spliterator<CodePart> = Spliterators.spliterator(this.parts.clone(), Spliterator.ORDERED)

    override fun iterator(): Iterator<CodePart> = Iterat()

    open fun subSource(fromIndex: Int, toIndex: Int): CodeSource = CodeSource(Arrays.copyOfRange(this.parts, fromIndex, toIndex))

    open fun toImmutable(): CodeSource = CodeSource(this.parts.clone())

    open fun toMutable(): MutableCodeSource = MutableCodeSource(this)

    open fun listIterator(): ListIterator<CodePart> = this.listIterator(0)

    open fun listIterator(index: Int): ListIterator<CodePart> = ListIterat(index)

    open fun stream(): Stream<CodePart> = StreamSupport.stream(this.spliterator(), false)

    open fun parallelStream(): Stream<CodePart> = StreamSupport.stream(this.spliterator(), true)

    private inner class Iterat : Iterator<CodePart> {

        private var index = 0

        override fun hasNext(): Boolean {
            return this.index < this@CodeSource.size
        }

        override fun next(): CodePart {
            if (!this.hasNext())
                throw java.util.NoSuchElementException()

            return this@CodeSource.get(this.index++)
        }
    }

    private inner class ListIterat internal constructor(index: Int) : ListIterator<CodePart> {

        private var index = 0

        init {
            this.index = index
        }

        override fun hasNext(): Boolean {
            return this.index < this@CodeSource.size
        }

        override fun next(): CodePart {
            if (!this.hasNext())
                throw java.util.NoSuchElementException()

            return this@CodeSource.get(this.index++)
        }

        override fun hasPrevious(): Boolean {
            return this.index - 1 >= 0
        }

        override fun previous(): CodePart {

            if (!this.hasPrevious())
                throw java.util.NoSuchElementException()

            return this@CodeSource.get(--this.index)
        }

        override fun nextIndex(): Int {
            return this.index
        }

        override fun previousIndex(): Int {
            return this.index - 1
        }

    }

    companion object {
        private val EMPTY = emptyArray<CodePart>()
        private val EMPTY_CODE_SOURCE = CodeSource(EMPTY)

        @JvmStatic
        fun empty(): CodeSource {
            return CodeSource.EMPTY_CODE_SOURCE
        }

        @JvmStatic
        fun fromArray(parts: Array<CodePart>): CodeSource {
            return CodeSource(parts)
        }

        @JvmStatic
        fun fromPart(part: CodePart): CodeSource {
            return CodeSource(arrayOf(part))
        }

        @JvmStatic
        fun fromVarArgs(vararg parts: CodePart): CodeSource {
            return CodeSource(Array(parts.size, { parts[it] }))
        }

        @Suppress("UNCHECKED_CAST")
        @JvmStatic
        fun fromIterable(iterable: Iterable<CodePart>): CodeSource {
            return CodeSource(IterableUtil.stream(iterable).toArray { arrayOfNulls<CodePart>(it) as Array<CodePart> })
        }

        @Suppress("UNCHECKED_CAST")
        @JvmStatic
        fun fromGenericIterable(iterable: Iterable<*>): CodeSource {
            return CodeSource(IterableUtil.stream(iterable).toArray { arrayOfNulls<CodePart>(it) as Array<CodePart> })
        }

        @Suppress("UNCHECKED_CAST")
        @JvmStatic
        fun fromCodeSourceIterable(iterable: Iterable<CodeSource>): CodeSource {
            return CodeSource(IterableUtil.stream(iterable).flatMap { it.stream() }.toArray { arrayOfNulls<CodePart>(it) as Array<CodePart> })
        }

        private fun equals(a: Any?, b: Any?): Boolean {
            return a == null && b == null || a === b || a != null && b != null && a == b
        }

    }
}