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
package com.koresframework.kores.base

import com.koresframework.kores.KoresPart
import com.koresframework.kores.Instructions

/**
 * Holds a body. Example: method declarations, type declarations, static block, constructors...
 */
interface BodyHolder : KoresPart {

    /**
     * Body.
     */
    val body: Instructions

    override fun builder(): Builder<BodyHolder, *>

    interface Builder<out T : BodyHolder, S : Builder<T, S>> :
        com.koresframework.kores.builder.Builder<T, S> {

        /**
         * See [T.body]
         */
        fun body(value: Instructions): S //default: empty
    }

    companion object {
        /**
         * Validates the method body (avoid infinite recursion)
         */
        fun checkBody(self: BodyHolder) {
            val body = self.body

            if (body.any { it == self }) {
                throw IllegalStateException("You have putted $self instance inside your own body, it may cause StackOverFlow Exception.")
            }
        }
    }
}