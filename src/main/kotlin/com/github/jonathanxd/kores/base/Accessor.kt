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

import com.github.jonathanxd.kores.Instruction
import java.lang.reflect.Type

/**
 * Accessor of an element. Example: field access/definition, method invocation
 * and executable code.
 *
 * # In Java
 *
 * [target] is the receiver of access.
 *
 * [localization] is the inferred or exact type of [target]
 *
 * Example: `String hello; hello.charAt(0);` The [target] is `hello`
 * variable and [localization] is `String` class.
 */
interface Accessor : Instruction {

    /**
     * Access target
     */
    val target: Instruction

    /**
     * Access localization
     */
    val localization: Type

    override fun builder(): Builder<Accessor, *>

    interface Builder<out T : Accessor, S : Builder<T, S>> :
        com.github.jonathanxd.kores.builder.Builder<T, S> {

        /**
         * See [Accessor.target]
         */
        fun target(value: Instruction): S

        /**
         * See [Accessor.localization]
         */
        fun localization(value: Type): S
    }
}