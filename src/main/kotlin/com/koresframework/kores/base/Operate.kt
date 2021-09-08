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
import com.koresframework.kores.builder.self
import com.koresframework.kores.common.KoresNothing
import com.koresframework.kores.data.KoresData
import com.koresframework.kores.operator.Operator
import com.koresframework.kores.operator.Operators
import com.koresframework.kores.type
import kotlinx.serialization.Serializable
import java.lang.reflect.Type

/**
 * Operate a value and return result of operation.
 *
 * @property target Target part to operate.
 * @property operation Operation.
 * @property value Second argument of the operation, may be [KoresNothing].
 * Some operations may not require a second argument and some can behave different without them,
 * example, if a second argument is provided for [Operators.SUBTRACT], the operation
 * will be `target-value`, otherwise, if [KoresNothing] is provided, the operation will be `-target` (or negative target).
 */
@Serializable
data class Operate(
    val target: Instruction,
    val operation: Operator.Math,
    override val value: Instruction
) : ValueHolder, TypedInstruction {

    override val data: KoresData = KoresData()

    override val type: Type
        get() = this.target.type

    val hasSecondArg: Boolean
        get() = this.value != KoresNothing

    override fun builder(): Builder = Builder(this)

    class Builder() :
        ValueHolder.Builder<Operate, Builder>,
        Typed.Builder<Operate, Builder> {

        override var data: KoresData = KoresData()
        lateinit var target: Instruction
        lateinit var operation: Operator.Math
        override var value: Instruction = KoresNothing

        override var type: Type
            get() = this.target.type
            set(value) {}

        constructor(defaults: Operate) : this() {
            this.target = defaults.target
            this.operation = defaults.operation
            this.value = defaults.value
        }

        override fun type(value: Type): Builder = self()

        /**
         * See [Operate.target]
         */
        fun target(value: Instruction): Builder {
            this.target = value
            return this
        }

        /**
         * See [Operate.operation]
         */
        fun operation(value: Operator.Math): Builder {
            this.operation = value
            return this
        }

        override fun value(value: Instruction): Builder {
            this.value = value
            return this
        }

        override fun buildBasic(): Operate = Operate(this.target, this.operation, this.value)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: Operate): Builder = Builder(defaults)
        }

    }

}
