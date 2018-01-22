/*
 *      CodeAPI - Java source and Bytecode generation framework <https://github.com/JonathanxD/CodeAPI>
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
package com.github.jonathanxd.codeapi.inspect

import com.github.jonathanxd.codeapi.CodePart
import com.github.jonathanxd.codeapi.CodeSource
import com.github.jonathanxd.codeapi.base.BodyHolder
import java.util.*

/**
 * Utility to inspect [CodeSource].
 *
 * @param R Mapper type.
 * @property predicate Predicate check if elements match requirements.
 * @property inspectCodeSource True to inspect [CodeSource] and not only sub elements.
 * @property subPredicate Predicate to check whether a [BodyHolder] should be inspected.
 * @property stopPredicate Predicate to determine when the inspection should stop (`true` to stop, `false` to continue).
 * @property mapper Function to map processed values to another type.
 */
class SourceInspect<out R> internal constructor(
    val predicate: (CodePart) -> Boolean,
    val inspectCodeSource: Boolean,
    val subPredicate: ((BodyHolder) -> Boolean)?,
    val stopPredicate: (CodePart) -> Boolean,
    val mapper: (CodePart) -> R
) {


    /**
     * Inspect the [source] and return the list of elements where matches [predicate] (mapped with [mapper]).
     */
    fun inspect(source: CodeSource): List<R> {

        val list = ArrayList<R>()

        this.inspect(source, this.inspectCodeSource, { list.add(it) }, 0)

        return list
    }

    /**
     * Inspect the [source] starting at index [start] and return the list of elements where matches [predicate] (mapped with [mapper])..
     *
     * @throws IndexOutOfBoundsException If [start] index exceeds the [source] size.
     */
    fun inspect(source: CodeSource, start: Int): List<R> {
        val list = mutableListOf<R>()

        this.inspect(source, this.inspectCodeSource, { list.add(it) }, start)

        return list
    }

    /**
     * Inspect [source] starting at index [start] and call [consumer] function with each
     * element (mapped with [mapper]) where matches [predicate].
     *
     * @return False if inspection stopped before ending as result of [stopPredicate] returning true for an element.
     */
    fun inspect(source: CodeSource, inspect: Boolean, consumer: (R) -> Unit, start: Int): Boolean {

        if (start == 0 && source.size == 0)
            return true

        if (start >= source.size)
            throw IndexOutOfBoundsException("Start index '" + start + "' is out of bounds. Size: " + source.size + ".")

        for (i in start..source.size - 1) {
            val codePart = source[i]

            // Deep inspection
            if (codePart is BodyHolder) {
                if (this.subPredicate != null && this.subPredicate.invoke(codePart)) {
                    val body = codePart.body

                    if (!this.inspect(body, true, consumer, 0)) {
                        return false
                    }
                }
            }

            if (inspect) {
                if (this.predicate(codePart)) {
                    consumer(this.mapper(codePart))
                } else if (this.stopPredicate(codePart)) {
                    return false
                }
            }

        }

        return true
    }

    companion object {

        /**
         * Creates a [SourceInspectBuilder] with [codePartPredicate] as matcher of elements
         * to collect.
         */
        @JvmStatic
        fun builder(codePartPredicate: (CodePart) -> Boolean): SourceInspectBuilder<CodePart> {
            return SourceInspectBuilder.builder<CodePart>().find(codePartPredicate)
        }
    }
}
