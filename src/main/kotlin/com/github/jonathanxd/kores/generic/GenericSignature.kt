/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2020 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
package com.github.jonathanxd.kores.generic

import com.github.jonathanxd.kores.type.GenericType
import java.util.*

/**
 * Hold information about generic signatures.
 */
class GenericSignature(private val _types: Array<out GenericType>) {

    val types get() = _types.clone()

    /**
     * Returns true if this generic signature is empty (no types).

     * @return true if this generic signature is empty (no types).
     */
    val isEmpty: Boolean
        get() = this === EMPTY || types.isEmpty()

    /**
     * Returns true if this generic signature is not empty.

     * @return true if this generic signature is not empty.
     */
    val isNotEmpty: Boolean
        get() = !this.isEmpty

    override fun toString(): String {
        return "GenericSignature[" + Arrays.toString(this.types) + "]"
    }

    companion object {

        /**
         * Empty generic signature.
         */
        private val EMPTY = GenericSignature(emptyArray())

        /**
         * Create generic signature.
         *
         * @param types Generic Types.
         * @return New [GenericSignature] holding [GenericTypes][GenericType]
         */
        @JvmStatic
        fun create(vararg types: GenericType): GenericSignature {
            return GenericSignature(types)
        }

        /**
         * Create generic signature.
         *
         * @param types Generic Types.
         * @return New [GenericSignature] holding [GenericTypes][GenericType]
         */
        @JvmStatic
        fun create(types: List<GenericType>): GenericSignature {
            return GenericSignature(types.toTypedArray())
        }

        /**
         * Empty generic signature.

         * @return Empty [GenericSignature].
         */
        @JvmStatic
        fun empty(): GenericSignature {
            return EMPTY
        }
    }
}
