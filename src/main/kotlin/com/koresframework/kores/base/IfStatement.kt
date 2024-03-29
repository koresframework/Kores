/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2022 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
import com.koresframework.kores.Instructions
import com.koresframework.kores.data.KoresData
import kotlinx.serialization.Serializable

/**
 * If statement.
 *
 * @property elseStatement Else statement
 * @see IfExpr
 */
@Serializable
data class IfStatement(
    override val expressions: List<Instruction>,
    override val body: Instructions,
    val elseStatement: Instructions
) : IfExpressionHolder, BodyHolder, Instruction {
    override val data: KoresData = KoresData()

    init {
        BodyHolder.checkBody(this)
    }

    override fun builder(): Builder = Builder(this)

    class Builder() :
        IfExpressionHolder.Builder<IfStatement, Builder>,
        BodyHolder.Builder<IfStatement, Builder> {

        override var data: KoresData = KoresData()
        override var expressions: List<Instruction> = emptyList()
        override var body: Instructions = Instructions.empty()
        var elseStatement: Instructions = Instructions.empty()

        constructor(defaults: IfStatement) : this() {
            this.expressions = defaults.expressions
            this.body = defaults.body
            this.elseStatement = defaults.elseStatement

            this.from(defaults)
        }

        /**
         * See [IfStatement.elseStatement]
         */
        fun elseStatement(value: Instructions): Builder {
            this.elseStatement = value
            return this
        }

        override fun buildBasic(): IfStatement =
            IfStatement(this.expressions, this.body, this.elseStatement)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: IfStatement): Builder = Builder(defaults)
        }

    }
}
