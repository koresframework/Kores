/*
 *      CodeAPI - Framework to generate Java code and Bytecode code. <https://github.com/JonathanxD/CodeAPI>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2017 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/ & https://github.com/TheRealBuggy/) <jonathan.scripter@programmer.net>
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
package com.github.jonathanxd.codeapi.operator

import com.github.jonathanxd.codeapi.annotation.GenerateTo
import com.github.jonathanxd.codeapi.base.Named

/**
 * [Operators][Operator] constants.
 *
 * @see [Summary of Operators](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/opsummary.html)
 */
object Operators {

    @JvmField
    val ASSIGNMENT: Operator = SimpleOperator("=")

    @JvmField
    val ADD: Operator = SimpleOperator("+")

    @JvmField
    val SUBTRACT: Operator = SimpleOperator("-")

    @JvmField
    val MULTIPLY: Operator = SimpleOperator("*")

    @JvmField
    val DIVISION: Operator = SimpleOperator("/")

    @JvmField
    val REMAINDER: Operator = SimpleOperator("%")

    @JvmField
    val INCREMENT: Operator = SimpleOperator("++")

    @JvmField
    val DECREMENT: Operator = SimpleOperator("--")

    @JvmField
    val NOT: Operator = SimpleOperator("!")

    @JvmField
    val EQUAL_TO: Operator = SimpleOperator("==")

    @JvmField
    val NOT_EQUAL_TO: Operator = SimpleOperator("!=")

    @JvmField
    val GREATER_THAN: Operator = SimpleOperator(">")

    @JvmField
    val GREATER_THAN_OR_EQUAL_TO: Operator = SimpleOperator(">=")

    @JvmField
    val LESS_THAN: Operator = SimpleOperator("<")

    @JvmField
    val LESS_THAN_OR_EQUAL_TO: Operator = SimpleOperator("<=")

    @JvmField
    val AND: Operator = SimpleOperator("&&")

    @JvmField
    val OR: Operator = SimpleOperator("||")

    @JvmField
    val UNARY_BITWISE_COMPLEMENT: Operator = SimpleOperator("~")

    @JvmField
    val BITWISE_AND: Operator = SimpleOperator("&")

    @JvmField
    val BITWISE_EXCLUSIVE_OR: Operator = SimpleOperator("^")

    @JvmField
    val BITWISE_INCLUSIVE_OR: Operator = SimpleOperator("|")

    @JvmField
    val SIGNED_LEFT_SHIFT: Operator = SimpleOperator("<<")

    @JvmField
    val SIGNED_RIGHT_SHIFT: Operator = SimpleOperator(">>")

    @JvmField
    val UNSIGNED_RIGHT_SHIFT: Operator = SimpleOperator(">>>")

    @GenerateTo(Named::class)
    private class SimpleOperator(name: String) : Operator(name)

}
