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
import com.github.jonathanxd.kores.Instructions
import kotlinx.serialization.Serializable

/**
 * For statement.
 *
 * for(forInit; forExpression; forUpdate)
 *
 * @property forInit For initialization (ex: `int i = 0`, `int i = 0, x = 9`).
 * @property forExpression For expression. See [IfExpressionHolder.expressions]. (ex: `i < 10`)
 * @property forUpdate For update. (ex: `i++`, `i++. x++`)
 * @property body Body of for statement (ex: `println(i)`).
 */
@Serializable
data class ForStatement(
    val forInit: List<Instruction>,
    val forExpression: List<Instruction>,
    val forUpdate: List<Instruction>,
    override val body: Instructions
) : IfExpressionHolder, BodyHolder, Instruction {
    init {
        BodyHolder.checkBody(this)
    }

    override val expressions: List<Instruction>
        get() = this.forExpression

    override fun builder(): Builder = Builder(this)

    class Builder() :
        IfExpressionHolder.Builder<ForStatement, Builder>,
        BodyHolder.Builder<ForStatement, Builder> {

        var forInit: List<Instruction> = emptyList()
        var forExpression: List<Instruction> = emptyList()
        var forUpdate: List<Instruction> = emptyList()
        var body: Instructions = Instructions.empty()

        constructor(defaults: ForStatement) : this() {
            this.forInit = defaults.forInit
            this.forExpression = defaults.forExpression
            this.forUpdate = defaults.forUpdate
        }

        override fun expressions(value: List<Instruction>): Builder = this.forExpression(value)

        override fun expressions(vararg values: Instruction): Builder =
            this.forExpression(values.toList())

        /**
         * See [ForStatement.forInit]
         */
        fun forInit(value: List<Instruction>): Builder {
            this.forInit = value
            return this
        }

        /**
         * See [ForStatement.forInit]
         */
        fun forInit(vararg values: Instruction): Builder = forInit(values.toList())

        /**
         * See [ForStatement.forExpression]
         */
        fun forExpression(value: List<Instruction>): Builder {
            this.forExpression = value
            return this
        }

        /**
         * See [ForStatement.forExpression]
         */
        fun forExpression(vararg values: Instruction): Builder = forExpression(values.toList())

        /**
         * See [ForStatement.forUpdate]
         */
        fun forUpdate(value: List<Instruction>): Builder {
            this.forUpdate = value
            return this
        }

        /**
         * See [ForStatement.forUpdate]
         */
        fun forUpdate(vararg values: Instruction): Builder = forUpdate(values.toList())

        override fun body(value: Instructions): Builder {
            this.body = value
            return this
        }

        override fun build(): ForStatement =
            ForStatement(this.forInit, this.forExpression, this.forUpdate, this.body)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: ForStatement): Builder = Builder(defaults)
        }

    }
}
