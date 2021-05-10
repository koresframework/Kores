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
package com.github.jonathanxd.kores.base

import com.github.jonathanxd.kores.KoresPart

/**
 * Same as [ElementsHolder] but holds constructors.
 */
interface ConstructorsHolder : KoresPart {

    /**
     * Constructor declarations
     */
    val constructors: List<ConstructorDeclaration>

    override fun builder(): Builder<ConstructorsHolder, *>

    interface Builder<out T : ConstructorsHolder, S : Builder<T, S>> :
        com.github.jonathanxd.kores.builder.Builder<T, S> {

        /**
         * See [ConstructorsHolder.constructors]
         */
        fun constructors(value: List<ConstructorDeclaration>): S

        /**
         * See [ConstructorsHolder.constructors]
         */
        fun constructors(vararg values: ConstructorDeclaration): S =
            this.constructors(values.toList())

        /**
         * See [ConstructorsHolder.constructors]
         */
        fun constructors(value: ConstructorDeclaration): S = this.constructors(listOf(value))
    }
}