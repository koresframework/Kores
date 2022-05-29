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
import com.koresframework.kores.KoresPart
import com.koresframework.kores.data.KoresData
import com.koresframework.kores.operator.Operator
import kotlinx.serialization.Serializable

/**
 * Condition evaluation.
 *
 * @property expr1 First expression
 * @property operation Operation
 * @property expr2 Second expression
 * @see IfStatement
 */
@Serializable
data class IfExpr(
    val expr1: Instruction,
    val operation: Operator.Conditional,
    val expr2: Instruction
) : KoresPart, Instruction {

    override val data: KoresData = KoresData()

    override fun builder(): Builder = Builder(this)

    class Builder() : com.koresframework.kores.builder.Builder<IfExpr, Builder>, KoresPart.PartBuilder<IfExpr, Builder> {

        override var data: KoresData = KoresData()
        lateinit var expr1: Instruction
        lateinit var operation: Operator.Conditional
        lateinit var expr2: Instruction

        constructor(defaults: IfExpr) : this() {
            this.expr1 = defaults.expr1
            this.operation = defaults.operation
            this.expr2 = defaults.expr2

            this.from(defaults)
        }

        /**
         * See [IfExpr.expr1]
         */
        fun expr1(value: Instruction): Builder {
            this.expr1 = value
            return this
        }

        /**
         * See [IfExpr.operation]
         */
        fun operation(value: Operator.Conditional): Builder {
            this.operation = value
            return this
        }

        /**
         * See [IfExpr.expr2]
         */
        fun expr2(value: Instruction): Builder {
            this.expr2 = value
            return this
        }

        override fun buildBasic(): IfExpr = IfExpr(this.expr1, this.operation, this.expr2)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: IfExpr): Builder = Builder(defaults)
        }

    }
}
