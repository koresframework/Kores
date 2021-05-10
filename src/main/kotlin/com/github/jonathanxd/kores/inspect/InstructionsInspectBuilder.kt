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
@file:Suppress("UNCHECKED_CAST")

package com.github.jonathanxd.kores.inspect

import com.github.jonathanxd.kores.KoresPart
import com.github.jonathanxd.kores.Instructions
import com.github.jonathanxd.kores.base.BodyHolder

class InstructionsInspectBuilder<R> private constructor() {

    /**
     * Predicate to test [KoresPart]
     */
    private lateinit var partPredicate: (KoresPart) -> Boolean

    /**
     * Predicate to test [BodyHolder] elements. If test returns true, inspect elements inside
     * the [BodyHolder].
     */
    private var subFindPredicate: ((BodyHolder) -> Boolean)? = null

    /**
     * Predicate to test where to stop inspection.
     */
    private var stopPredicate: (KoresPart) -> Boolean = { false }

    /**
     * True to inspect [Instructions], and not only sub elements.
     */
    private var inspectRootInstructions = true

    /**
     * [KoresPart] mapper.
     */
    private var mapper: (KoresPart) -> R = { codePart -> codePart as R }

    /**
     * Sets the matcher of elements to collect.
     */
    fun find(codePartPredicate: (KoresPart) -> Boolean): InstructionsInspectBuilder<R> {
        this.partPredicate = codePartPredicate

        return this
    }

    /**
     * Sets to inspect **only** elements inside [BodyHolders][BodyHolder] that matches the [predicate].
     */
    fun inside(predicate: (BodyHolder) -> Boolean): InstructionsInspectBuilder<R> {
        this.subFindPredicate = predicate
        this.inspectRootInstructions = false
        return this
    }

    /**
     * Sets to include elements inside [BodyHolders][BodyHolder] that matches the [predicate] in the inspection.
     */
    fun include(predicate: (BodyHolder) -> Boolean): InstructionsInspectBuilder<R> {
        this.subFindPredicate = predicate

        return this
    }

    /**
     * Sets to include elements inside [Instructions] passed to [InstructionsInspect.inspect] in the inspection.
     *
     * [inside] sets this to false.
     */
    fun includeRoot(inspectRootInstructions: Boolean): InstructionsInspectBuilder<R> {
        this.inspectRootInstructions = inspectRootInstructions
        return this
    }

    /**
     * Sets predicate to test when to stop inspection. If [predicate] returns `true`, the inspection stops,
     * if return `false`, the inspection continues.
     */
    fun stopWhen(predicate: (KoresPart) -> Boolean): InstructionsInspectBuilder<R> {
        this.stopPredicate = predicate
        return this
    }

    /**
     * Sets the mapper function. Mapper function convert elements before its get consumed by a function.
     *
     * Obs: This function does not return a new [InstructionsInspectBuilder], it only "unsafe cast" the current.
     */
    fun <V> mapTo(mapper: (KoresPart) -> V): InstructionsInspectBuilder<V> {
        this as InstructionsInspectBuilder<V>

        this.mapper = mapper

        return this
    }

    /**
     * Calls [InstructionsInspect.inspect]
     */
    fun inspect(codeSource: Instructions): List<R> {
        val build = this.build()

        return build.inspect(codeSource)
    }

    /**
     * Calls [InstructionsInspect.inspect]
     */
    fun inspect(codeSource: Instructions, start: Int): List<R> {
        val build = this.build()

        return build.inspect(codeSource, start)
    }

    /**
     * Builds a [InstructionsInspect] with current properties.
     */
    fun build(): InstructionsInspect<R> {
        return InstructionsInspect(
            this.partPredicate,
            this.inspectRootInstructions,
            this.subFindPredicate,
            this.stopPredicate,
            this.mapper
        )
    }

    companion object {

        /**
         * Creates a [InstructionsInspectBuilder].
         */
        @JvmStatic
        internal fun <R> builder(): InstructionsInspectBuilder<R> {
            return InstructionsInspectBuilder()
        }
    }
}
