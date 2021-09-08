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

import com.koresframework.kores.Instruction
import com.koresframework.kores.KoresPart
import com.koresframework.kores.builder.self
import java.lang.reflect.Type

/**
 * Hold arguments.
 */
interface ArgumentsHolder : KoresPart {

    /**
     * Expected types of each argument
     */
    val types: List<Type>

    /**
     * Argument list
     */
    val arguments: List<Instruction>

    /**
     * Array arguments
     */
    val array: Boolean

    override fun builder(): Builder<ArgumentsHolder, *>

    interface Builder<out T : ArgumentsHolder, S : Builder<T, S>> :
        com.koresframework.kores.builder.Builder<T, S>, KoresPart.PartBuilder<T, S> {
        var arguments: List<Instruction>

        /**
         * See [T.arguments]
         */
        fun arguments(value: List<Instruction>): S {
            this.arguments = value
            return self()
        }

        /**
         * See [T.arguments]
         */
        fun arguments(vararg values: Instruction): S = arguments(values.toList())

        /**
         * See [T.array]
         */
        fun array(value: Boolean): S
    }

}