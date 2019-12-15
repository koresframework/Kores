/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2019 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
package com.github.jonathanxd.kores.helper

import com.github.jonathanxd.kores.Instruction
import com.github.jonathanxd.kores.Types
import com.github.jonathanxd.kores.base.IfExpr
import com.github.jonathanxd.kores.base.IfGroup
import com.github.jonathanxd.kores.factory.invokeVirtual
import com.github.jonathanxd.kores.factory.isInstanceOf
import com.github.jonathanxd.kores.factory.typeSpec
import com.github.jonathanxd.kores.operator.Operator
import com.github.jonathanxd.kores.operator.Operators
import java.lang.reflect.Type

/**
 * If expression helper.
 */
class IfExpressionHelper private constructor() {

    private val list = mutableListOf<Instruction>()

    /**
     * Checks if [part1] [operation] [part2].
     */
    fun check(
        part1: Instruction,
        operation: Operator.Conditional,
        part2: Instruction
    ): IfExpressionHelper {
        this.list.add(IfExpr(part1, operation, part2))
        return this
    }

    /**
     * Compares [part1] and [part2] by reference.
     */
    fun checkRefEqual(part1: Instruction, part2: Instruction): IfExpressionHelper {
        this.list.add(IfExpr(part1, Operators.EQUAL_TO, part2))
        return this
    }

    /**
     * Compares [part1] and [part2] using [Any.equals] method.
     */
    fun checkObjectEqual(part1: Instruction, part2: Instruction): IfExpressionHelper {
        return this.checkTrue(
            invokeVirtual(
                Any::class.java, part1, "equals",
                typeSpec(Types.BOOLEAN, Types.OBJECT),
                listOf(part2)
            )
        )
    }

    /**
     * Checks if [part1] is not `null`.
     */
    fun checkNotNull(part1: Instruction): IfExpressionHelper {
        this.list.add(com.github.jonathanxd.kores.factory.checkNotNull(part1))
        return this
    }

    /**
     * Checks if [part1] is `null`.
     */
    fun checkNull(part1: Instruction): IfExpressionHelper {
        this.list.add(com.github.jonathanxd.kores.factory.checkNull(part1))
        return this
    }

    /**
     * Checks if [part1] is `true`.
     */
    fun checkTrue(part1: Instruction): IfExpressionHelper {
        this.list.add(com.github.jonathanxd.kores.factory.checkTrue(part1))
        return this
    }

    /**
     * Checks if [part1] is `false`.
     */
    fun checkFalse(part1: Instruction): IfExpressionHelper {
        this.list.add(com.github.jonathanxd.kores.factory.checkFalse(part1))
        return this
    }

    /**
     * Checks if [part1] is `instanceof` [type].
     */
    fun checkInstance(part1: Instruction, type: Type): IfExpressionHelper {
        this.list.add(isInstanceOf(part1, type))
        return this
    }

    // And

    /**
     * And checks if [part1] [operation] [part2].
     */
    fun and(
        part1: Instruction,
        operation: Operator.Conditional,
        part2: Instruction
    ): IfExpressionHelper =
        this.and().check(part1, operation, part2)

    /**
     * And compares [part1] and [part2] by reference.
     */
    fun andRefEqual(part1: Instruction, part2: Instruction): IfExpressionHelper =
        this.and().checkRefEqual(part1, part2)

    /**
     * And compares [part1] and [part2] using [Any.equals] method.
     */
    fun andObjectEqual(part1: Instruction, part2: Instruction): IfExpressionHelper =
        this.and().checkObjectEqual(part1, part2)

    /**
     * And checks if [part1] is not `null`.
     */
    fun andNotNull(part1: Instruction): IfExpressionHelper =
        this.and().checkNotNull(part1)

    /**
     * And checks if [part1] is `null`.
     */
    fun andNull(part1: Instruction): IfExpressionHelper =
        this.and().checkNull(part1)

    /**
     * And checks if [part1] is `true`.
     */
    fun andTrue(part1: Instruction): IfExpressionHelper =
        this.and().checkTrue(part1)

    /**
     * And checks if [part1] is `false`.
     */
    fun andFalse(part1: Instruction): IfExpressionHelper =
        this.and().checkFalse(part1)

    /**
     * And checks if [part1] is `instanceof` [type].
     */
    fun andCheckInstance(part1: Instruction, type: Type): IfExpressionHelper =
        this.and().checkInstance(part1, type)


    // Or

    /**
     * Or checks if [part1] [operation] [part2].
     */
    fun or(
        part1: Instruction,
        operation: Operator.Conditional,
        part2: Instruction
    ): IfExpressionHelper =
        this.or().check(part1, operation, part2)


    /**
     * Or compares [part1] and [part2] by reference.
     */
    fun orRefEqual(part1: Instruction, part2: Instruction): IfExpressionHelper =
        this.or().checkRefEqual(part1, part2)

    /**
     * Or compares [part1] and [part2] using [Any.equals] method.
     */
    fun orObjectEqual(part1: Instruction, part2: Instruction): IfExpressionHelper =
        this.or().checkObjectEqual(part1, part2)

    /**
     * Or checks if [part1] is not `null`.
     */
    fun orNotNull(part1: Instruction): IfExpressionHelper =
        this.or().checkNotNull(part1)

    /**
     * Or checks if [part1] is `null`.
     */
    fun orNull(part1: Instruction): IfExpressionHelper =
        this.or().checkNull(part1)

    /**
     * Or checks if [part1] is `true`.
     */
    fun orTrue(part1: Instruction): IfExpressionHelper =
        this.or().checkTrue(part1)

    /**
     * Or checks if [part1] is `false`.
     */
    fun orFalse(part1: Instruction): IfExpressionHelper =
        this.or().checkFalse(part1)


    /**
     * Or checks if [part1] is `instanceof` [type].
     */
    fun orCheckInstance(part1: Instruction, type: Type): IfExpressionHelper =
        this.or().checkInstance(part1, type)

    /**
     * Adds and expression.
     */
    fun and(): IfExpressionHelper {
        this.list.add(Operators.AND)
        return this
    }

    /**
     * Adds or expression.
     */
    fun or(): IfExpressionHelper {
        this.list.add(Operators.OR)
        return this
    }

    /**
     * Adds a if group to expression list.
     */
    fun addIfGroup(ifGroup: IfGroup): IfExpressionHelper {
        this.list.add(ifGroup)
        return this
    }

    /**
     * Build expressions.
     */
    fun build(): List<Instruction> {
        return this.list
    }

    companion object {

        /**
         * Creates [IfExpressionHelper].
         */
        @JvmStatic
        fun builder(): IfExpressionHelper {
            return IfExpressionHelper()
        }
    }
}
