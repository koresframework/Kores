/*
 *      CodeAPI - Framework to generate Java code and Bytecode code. <https://github.com/JonathanxD/CodeAPI>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2018 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/ & https://github.com/TheRealBuggy/) <jonathan.scripter@programmer.net>
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

import java.util.*

/**
 * [Operators][Operator] constants.
 *
 * @see [Summary of Operators](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/opsummary.html)
 */
object Operators {

    private val knownOperators_ = mutableMapOf<String, Operator>()

    @JvmField
    val knownOperators: Map<String, Operator> = Collections.unmodifiableMap(this.knownOperators_)!!

    @JvmField
    val ADD = createMath("+")

    @JvmField
    val SUBTRACT = createMath("-")

    @JvmField
    val MULTIPLY = createMath("*")

    @JvmField
    val DIVISION = createMath("/")

    @JvmField
    val REMAINDER = createMath("%")

    @JvmField
    val UNARY_BITWISE_COMPLEMENT = createMath("~")

    @JvmField
    val BITWISE_AND = createMath("&")

    @JvmField
    val BITWISE_EXCLUSIVE_OR = createMath("^")

    @JvmField
    val BITWISE_INCLUSIVE_OR = createMath("|")

    @JvmField
    val SIGNED_LEFT_SHIFT = createMath("<<")

    @JvmField
    val SIGNED_RIGHT_SHIFT = createMath(">>")

    @JvmField
    val UNSIGNED_RIGHT_SHIFT = createMath(">>>")

    @JvmField
    val NOT = createConditional("!")

    @JvmField
    val EQUAL_TO = createConditional("==")

    @JvmField
    val NOT_EQUAL_TO = createConditional("!=")

    @JvmField
    val GREATER_THAN = createConditional(">")

    @JvmField
    val GREATER_THAN_OR_EQUAL_TO = createConditional(">=")

    @JvmField
    val LESS_THAN = createConditional("<")

    @JvmField
    val LESS_THAN_OR_EQUAL_TO = createConditional("<=")

    @JvmField
    val AND = createConditional("&&")

    @JvmField
    val OR = createConditional("||")

    fun createMath(name: String) = Operator.Math(name).let {
        it.registerOperator()
        it
    }

    fun createConditional(name: String) = Operator.Conditional(name).let {
        it.registerOperator()
        it
    }

    private fun Operator.registerOperator() {
        knownOperators_[name] = this
    }
}
