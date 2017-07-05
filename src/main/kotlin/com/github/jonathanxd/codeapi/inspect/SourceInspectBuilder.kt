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
@file:Suppress("UNCHECKED_CAST")

package com.github.jonathanxd.codeapi.inspect

import com.github.jonathanxd.codeapi.CodePart
import com.github.jonathanxd.codeapi.CodeSource
import com.github.jonathanxd.codeapi.base.BodyHolder

class SourceInspectBuilder<R> private constructor() {

    /**
     * Predicate to test [CodePart]
     */
    private lateinit var partPredicate: (CodePart) -> Boolean

    /**
     * Predicate to test [BodyHolder] elements. If test returns true, inspect elements inside
     * the [BodyHolder].
     */
    private var subFindPredicate: ((BodyHolder) -> Boolean)? = null

    /**
     * Predicate to test where to stop inspection.
     */
    private var stopPredicate: (CodePart) -> Boolean = { false }

    /**
     * True to inspect [CodeSource], and not only sub elements.
     */
    private var inspectCodeSource = true

    /**
     * [CodePart] mapper.
     */
    private var mapper: (CodePart) -> R = { codePart -> codePart as R }

    /**
     * Sets the matcher of elements to collect.
     */
    fun find(codePartPredicate: (CodePart) -> Boolean): SourceInspectBuilder<R> {
        this.partPredicate = codePartPredicate

        return this
    }

    /**
     * Sets to inspect **only** elements inside [BodyHolders][BodyHolder] that matches the [predicate].
     */
    fun inside(predicate: (BodyHolder) -> Boolean): SourceInspectBuilder<R> {
        this.subFindPredicate = predicate
        this.inspectCodeSource = false
        return this
    }

    /**
     * Sets to include elements inside [BodyHolders][BodyHolder] that matches the [predicate] in the inspection.
     */
    fun include(predicate: (BodyHolder) -> Boolean): SourceInspectBuilder<R> {
        this.subFindPredicate = predicate

        return this
    }

    /**
     * Sets to include elements inside [CodeSource] passed to [SourceInspect.inspect] in the inspection.
     *
     * [inside] sets this to false.
     */
    fun includeSource(inspectCodeSource: Boolean): SourceInspectBuilder<R> {
        this.inspectCodeSource = inspectCodeSource
        return this
    }

    /**
     * Sets predicate to test when to stop inspection. If [predicate] returns `true`, the inspection stops,
     * if return `false`, the inspection continues.
     */
    fun stopWhen(predicate: (CodePart) -> Boolean): SourceInspectBuilder<R> {
        this.stopPredicate = predicate
        return this
    }

    /**
     * Sets the mapper function. Mapper function convert elements before its get consumed by a function.
     *
     * Obs: This function does not return a new [SourceInspectBuilder], it only "unsafe cast" the current.
     */
    fun <V> mapTo(mapper: (CodePart) -> V): SourceInspectBuilder<V> {
        this as SourceInspectBuilder<V>

        this.mapper = mapper

        return this
    }

    /**
     * Calls [SourceInspect.inspect]
     */
    fun inspect(codeSource: CodeSource): List<R> {
        val build = this.build()

        return build.inspect(codeSource)
    }

    /**
     * Calls [SourceInspect.inspect]
     */
    fun inspect(codeSource: CodeSource, start: Int): List<R> {
        val build = this.build()

        return build.inspect(codeSource, start)
    }

    /**
     * Builds a [SourceInspect] with current properties.
     */
    fun build(): SourceInspect<R> {
        return SourceInspect(this.partPredicate, this.inspectCodeSource, this.subFindPredicate, this.stopPredicate, this.mapper)
    }

    companion object {

        /**
         * Creates a [SourceInspectBuilder].
         */
        @JvmStatic
        internal fun <R> builder(): SourceInspectBuilder<R> {
            return SourceInspectBuilder()
        }
    }
}
