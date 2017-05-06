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

import java.util.ArrayList
import java.util.Comparator
import java.util.Spliterator
import java.util.function.Consumer
import java.util.function.Predicate
import java.util.function.UnaryOperator
import java.util.stream.Stream

/**
 * A [MutableCodeSource] backing to a [ArrayList].
 */
class ListCodeSource() : MutableCodeSource(), Cloneable {

    private val backingList: ArrayList<CodePart> = ArrayList()

    constructor(list: List<CodePart>) : this() {
        this.backingList.addAll(list)
    }

    constructor(iterable: Iterable<CodePart>) : this() {
        this.backingList.addAll(iterable)
    }

    constructor(a: Array<CodePart>) : this() {
        this.backingList.addAll(a)
    }

    override val size: Int
        get() = this.backingList.size

    override fun removeIf(filter: Predicate<in CodePart>): Boolean {
        return this.backingList.removeIf(filter)
    }

    override fun replaceAll(operator: UnaryOperator<CodePart>) {
        this.backingList.replaceAll(operator)
    }

    override fun sort(c: Comparator<in CodePart>) {
        this.backingList.sortedWith(c)
    }

    override fun trimToSize() {
        this.backingList.trimToSize()
    }

    override fun ensureCapacity(minCapacity: Int) {
        this.backingList.ensureCapacity(minCapacity)
    }

    override fun add(codePart: CodePart): Boolean {
        return this.backingList.add(codePart)
    }

    override fun remove(o: Any): Boolean {
        return this.backingList.remove(o)
    }

    override fun addAll(c: Collection<CodePart>): Boolean {
        return this.backingList.addAll(c)
    }

    override fun addAll(index: Int, c: Collection<CodePart>): Boolean {
        return this.backingList.addAll(index, c)
    }

    override fun addAll(index: Int, c: Iterable<CodePart>): Boolean {
        return this.addAll(index, c.toList())
    }

    override fun removeAll(c: Collection<*>): Boolean {
        return this.backingList.removeAll(c)
    }

    override fun retainAll(c: Collection<*>): Boolean {
        return this.backingList.retainAll(c)
    }

    override fun removeAll(c: Iterable<CodePart>): Boolean {
        return this.backingList.removeAll(c)
    }

    override fun retainAll(c: Iterable<CodePart>): Boolean {
        return this.backingList.retainAll(c)
    }

    override fun clear() {
        this.backingList.clear()
    }

    override fun add(index: Int, element: CodePart) {
        return this.backingList.add(index, element)
    }

    override fun remove(index: Int): CodePart {
        return this.backingList.removeAt(index)
    }

    override operator fun plusAssign(other: Iterable<CodePart>) {
        this.addAll(other)
    }

    override operator fun minusAssign(other: Iterable<CodePart>) {
        this.removeAll(other)
    }

    override operator fun plusAssign(other: CodePart) {
        this.add(other)
    }

    override operator fun minusAssign(other: CodePart) {
        this.remove(other)
    }

    override fun subSource(fromIndex: Int, toIndex: Int): MutableCodeSource =
            CodeSourceView(this, fromIndex, toIndex)

    override operator fun plus(other: CodePart): MutableCodeSource {
        return ListCodeSource(this.backingList + other)
    }

    override operator fun minus(other: CodePart): MutableCodeSource {
        return ListCodeSource(this.backingList - other)
    }

    override operator fun plus(other: Iterable<CodePart>): MutableCodeSource {
        return ListCodeSource(this.backingList + other)
    }

    override operator fun minus(other: Iterable<CodePart>): MutableCodeSource {
        return ListCodeSource(this.backingList - other)
    }

    override fun contains(o: Any): Boolean {
        return this.backingList.contains(o)
    }

    override fun iterator(): Iterator<CodePart> {
        return this.backingList.iterator()
    }

    override fun toArray(): Array<CodePart> {
        return this.backingList.toTypedArray()
    }

    override fun <T : CodePart> toArray(a: Array<T>): Array<T> {
        return this.backingList.toArray(a)
    }

    override fun containsAll(c: Collection<*>): Boolean {
        return this.backingList.containsAll(c)
    }

    override fun getAtIndex(index: Int): CodePart {
        return this.backingList[index]
    }

    override operator fun set(index: Int, element: CodePart): CodePart {
        return this.backingList.set(index, element)
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

    override fun toString(): String = if (this.isEmpty) "MutableCodeSource[]" else "MutableCodeSource[...]"

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
        return ListCodeSource(this)
    }


    inline fun ListCodeSource(size: Int, init: (index: Int) -> CodePart): ListCodeSource =
            ListCodeSource().let {
                for (i in 0..size - 1) it += init(i)
                return@let it
            }

}
