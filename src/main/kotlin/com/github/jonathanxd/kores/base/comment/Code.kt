/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
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
package com.github.jonathanxd.kores.base.comment

import com.github.jonathanxd.kores.KoresPart

/**
 * Code comment
 *
 * @property code Code Node
 */
data class Code(val code: CodeNode) : Comment {
    override fun builder(): Builder = Builder(this)

    /**
     * Node of the code.
     */
    interface CodeNode {

        /**
         * Plain code
         *
         * @param plain Code string,
         */
        data class Plain(val plain: String) : CodeNode

        /**
         * Kores code representation (let generator generate the code).
         *
         * @param representation Code representation.
         */
        data class CodeRepresentation(val representation: KoresPart) : CodeNode

    }

    class Builder() : com.github.jonathanxd.kores.builder.Builder<Code, Builder> {

        lateinit var code: CodeNode

        constructor(defaults: Code) : this() {
            this.code = defaults.code
        }

        /**
         * See [Code.code]
         */
        fun code(value: CodeNode): Builder {
            this.code = value
            return this
        }

        override fun build(): Code = Code(this.code)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: Code): Builder = Builder(defaults)
        }

    }

}