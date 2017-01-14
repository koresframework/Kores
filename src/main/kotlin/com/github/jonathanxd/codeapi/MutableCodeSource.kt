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

import com.github.jonathanxd.codeapi.annotation.GenerateTo
import com.github.jonathanxd.codeapi.util.IterableUtil

import java.util.ArrayList
import java.util.Comparator
import java.util.Spliterator
import java.util.function.Consumer
import java.util.function.Predicate
import java.util.function.UnaryOperator
import java.util.stream.Collectors
import java.util.stream.Stream

/**
 * A mutable [CodeSource] backing to a [ArrayList].
 */
@GenerateTo(CodeSource::class)
class MutableCodeSource : CodeSource, Cloneable {

    private val backingList: BackingArrayList

    constructor() : super() {
        this.backingList = BackingArrayList()
    }

    constructor(iterable: Iterable<CodePart>) : super() {
        this.backingList = BackingArrayList(iterable)
    }

    constructor(a: Array<CodePart>) : super() {
        this.backingList = BackingArrayList(a)
    }

    override val size: Int
        get() = this.backingList.size

    override val isEmpty: Boolean
        get() = this.backingList.isEmpty()

    override val isNotEmpty: Boolean
        get() = !this.isEmpty

    override fun contains(o: Any): Boolean {
        return this.backingList.contains(o)
    }

    override fun iterator(): Iterator<CodePart> {
        return this.backingList.iterator()
    }

    override fun toArray(): Array<CodePart> {
        return this.backingList.toTypedArray()
    }

    override fun <T> toArray(a: Array<T>): Array<T> {
        return this.backingList.toArray(a)
    }

    fun add(codePart: CodePart): Boolean {
        return this.backingList.add(codePart)
    }

    fun remove(o: Any): Boolean {
        return this.backingList.remove(o)
    }

    override fun containsAll(c: Collection<*>): Boolean {
        return this.backingList.containsAll(c)
    }

    fun addAll(c: Collection<CodePart>): Boolean {
        return this.backingList.addAll(c)
    }

    fun addAll(c: Iterable<CodePart>): Boolean {
        var any = false

        for (part in c) {
            any = any or this.add(part)
        }

        return any
    }

    fun addAll(index: Int, c: Collection<CodePart>): Boolean {
        return this.backingList.addAll(index, c)
    }

    fun addAll(index: Int, c: Iterable<CodePart>): Boolean {
        return this.addAll(index, c.toList())
    }

    fun removeAll(c: Collection<*>): Boolean {
        return this.backingList.removeAll(c)
    }

    fun retainAll(c: Collection<*>): Boolean {
        return this.backingList.retainAll(c)
    }

    fun clear() {
        this.backingList.clear()
    }

    override fun get(index: Int): CodePart {
        return this.backingList[index]
    }

    operator fun set(index: Int, element: CodePart): CodePart {
        return this.backingList.set(index, element)
    }

    fun add(index: Int, element: CodePart) {
        this.backingList.add(index, element)
    }

    fun remove(index: Int): CodePart {
        return this.backingList.removeAt(index)
    }

    override fun indexOf(o: Any): Int {
        return this.backingList.indexOf(o)
    }

    override fun lastIndexOf(o: Any): Int {
        return this.backingList.lastIndexOf(o)
    }

    override fun listIterator(): ListIterator<CodePart> {
        return this.backingList.listIterator()
    }

    override fun listIterator(index: Int): ListIterator<CodePart> {
        return this.backingList.listIterator(index)
    }

    fun subList(fromIndex: Int, toIndex: Int): List<CodePart> {
        return this.backingList.subList(fromIndex, toIndex)
    }

    protected fun removeRange(fromIndex: Int, toIndex: Int) {
        this.backingList.removeRange(fromIndex, toIndex)
    }

    fun removeIf(filter: Predicate<in CodePart>): Boolean {
        return this.backingList.removeIf(filter)
    }

    fun replaceAll(operator: UnaryOperator<CodePart>) {
        this.backingList.replaceAll(operator)
    }

    fun sort(c: Comparator<in CodePart>) {
        this.backingList.sortedWith(c)
    }

    fun trimToSize() {
        this.backingList.trimToSize()
    }

    fun ensureCapacity(minCapacity: Int) {
        this.backingList.ensureCapacity(minCapacity)
    }

    override fun clone(): Any {
        return this.backingList.clone()
    }

    override fun forEach(action: Consumer<in CodePart>) {
        this.backingList.forEach(action)
    }

    override fun spliterator(): Spliterator<CodePart> {
        return this.backingList.spliterator()
    }

    override fun equals(other: Any?): Boolean {
        return this.backingList == other
    }

    override fun hashCode(): Int {
        return this.backingList.hashCode()
    }

    override fun toString(): String = if(this.isEmpty) "MutableCodeSource[]" else "MutableCodeSource[...]"

    override fun stream(): Stream<CodePart> {
        return this.backingList.stream()
    }

    override fun parallelStream(): Stream<CodePart> {
        return this.backingList.parallelStream()
    }

    override fun toImmutable(): CodeSource {
        return CodeSource.fromArray(this.toArray())
    }

    override fun toMutable(): MutableCodeSource {
        return MutableCodeSource(this)
    }


    /**
     * Exposes [.removeRange]
     */
    private class BackingArrayList : ArrayList<CodePart> {
        constructor() : super()

        constructor(c: Iterable<CodePart>?) : super() {

            if (c != null)
                for (part in c) {
                    this.add(part)
                }

        }

        constructor(a: Array<CodePart>?) {
            if (a != null)
                for (part in a) {
                    this.add(part)
                }
        }

        public override fun removeRange(fromIndex: Int, toIndex: Int) {
            super.removeRange(fromIndex, toIndex)
        }
    }
}
