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
package com.koresframework.kores.helper

import com.koresframework.kores.Instruction
import com.koresframework.kores.base.Operate
import com.koresframework.kores.common.KoresNothing
import com.koresframework.kores.operator.Operator
import com.koresframework.kores.operator.Operators

/**
 * Operator helper.
 */
class OperateHelper private constructor(private var part: Instruction?) {

    /**
     * Plus (+).
     *
     * @param value 2nd value to add.
     * @return This.
     */
    operator fun plus(value: Instruction): OperateHelper {
        val operation = Operators.ADD

        return this.operate(operation, value)
    }

    /**
     * Subtract (-).
     *
     * @param value 2nd value to divide.
     * @return This.
     */
    fun subtract(value: Instruction): OperateHelper {
        val operation = Operators.SUBTRACT

        return this.operate(operation, value)
    }

    /**
     * Multiply (*)
     *
     * @param value 2nd value to divide.
     * @return This.
     */
    fun multiply(value: Instruction): OperateHelper {
        val operation = Operators.MULTIPLY

        return this.operate(operation, value)
    }

    /**
     * Multiply (/)
     *
     * @param value 2nd value to divide.
     * @return This.
     */
    fun divide(value: Instruction): OperateHelper {
        val operation = Operators.DIVISION

        return this.operate(operation, value)
    }

    /**
     * Remainder (%)
     *
     * @param value 2nd value to remainder.
     * @return This.
     */
    fun remainder(value: Instruction): OperateHelper {
        val operation = Operators.REMAINDER

        return this.operate(operation, value)
    }

    /**
     * Negate value.
     *
     * @return This.
     */
    fun neg(): OperateHelper {
        val operation = Operators.SUBTRACT

        return this.operate(operation, KoresNothing)
    }

    // &
    /**
     * Inclusive or (&amp;).
     *
     * @param value 2nd value to operate.
     * @return This.
     */
    fun or(value: Instruction): OperateHelper {
        val operation = Operators.BITWISE_INCLUSIVE_OR

        return this.operate(operation, value)
    }

    // ^
    /**
     * Exclusive or (&#94;).
     *
     * @param value 2nd value to operate.
     * @return This.
     */
    fun xor(value: Instruction): OperateHelper {
        val operation = Operators.BITWISE_EXCLUSIVE_OR

        return this.operate(operation, value)
    }


    /**
     * Bitwise not (~).
     *
     * @param value 2nd value to operate.
     * @return This.
     */
    fun not(value: Instruction): OperateHelper {
        val operation = Operators.UNARY_BITWISE_COMPLEMENT

        return this.operate(operation, value)
    }

    // >>
    /**
     * Bitwise shift right (>>).
     *
     * @param value 2nd value to operate.
     * @return This.
     */
    fun shiftRight(value: Instruction): OperateHelper {
        val operation = Operators.SIGNED_RIGHT_SHIFT
        return this.operate(operation, value)
    }

    /**
     * Bitwise logical shift right (>>>).
     *
     * @param value 2nd value to operate.
     * @return This.
     */
    fun logicalShiftRight(value: Instruction): OperateHelper {
        val operation = Operators.UNSIGNED_RIGHT_SHIFT

        return this.operate(operation, value)
    }

    /**
     * Bitwise left shift (<<).
     *
     * @param value 2nd value to operate.
     * @return This.
     */
    fun leftShift(value: Instruction): OperateHelper {
        val operation = Operators.SIGNED_LEFT_SHIFT

        return this.operate(operation, value)
    }

    private fun operate(operation: Operator.Math, value: Instruction): OperateHelper {
        this.part = Operate(this.part!!, operation, value)

        return this
    }

    fun build(): Instruction {
        return this.part!!
    }

    companion object {

        @JvmStatic
        fun builder(part: Instruction): OperateHelper {
            return OperateHelper(part)
        }
    }
}
