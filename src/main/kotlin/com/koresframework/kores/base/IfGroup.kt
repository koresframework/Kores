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
import kotlinx.serialization.Serializable

/**
 * Group of if expressions.
 *
 * @property expressions Same rules of [IfExpressionHolder.expressions] applies to [expressions].
 */
@Serializable
data class IfGroup(override val expressions: List<Instruction>) : KoresPart, IfExpressionHolder,
    Instruction {

    override fun builder(): Builder = Builder(this)

    class Builder() : IfExpressionHolder.Builder<IfGroup, Builder> {

        var expressions: List<Instruction> = emptyList()

        constructor(defaults: IfGroup) : this() {
            this.expressions = defaults.expressions
        }

        override fun expressions(value: List<Instruction>): Builder {
            this.expressions = value
            return this
        }

        override fun expressions(vararg values: Instruction): Builder {
            this.expressions = values.toList()
            return this
        }

        override fun build(): IfGroup = IfGroup(this.expressions)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: IfGroup): Builder = Builder(defaults)
        }
    }

}