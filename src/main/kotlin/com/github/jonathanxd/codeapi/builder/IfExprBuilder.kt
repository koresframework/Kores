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
package com.github.jonathanxd.codeapi.builder

import com.github.jonathanxd.codeapi.base.impl.IfExprImpl
import com.github.jonathanxd.codeapi.base.IfExpr

// Generated by BuilderGen
class IfExprBuilder(): Builder<IfExpr, IfExprBuilder>() {
    lateinit var expr1: com.github.jonathanxd.codeapi.CodePart
    lateinit var operation: com.github.jonathanxd.codeapi.operator.Operator
    lateinit var expr2: com.github.jonathanxd.codeapi.CodePart

    constructor(defaults: IfExpr) : this() {
        this.expr1 = defaults.expr1
        this.operation = defaults.operation
        this.expr2 = defaults.expr2
    }

    fun withExpr1(value: com.github.jonathanxd.codeapi.CodePart): IfExprBuilder {
        this.expr1 = value
        return this
    }

    fun withOperation(value: com.github.jonathanxd.codeapi.operator.Operator): IfExprBuilder {
        this.operation = value
        return this
    }

    fun withExpr2(value: com.github.jonathanxd.codeapi.CodePart): IfExprBuilder {
        this.expr2 = value
        return this
    }

    override fun build(): IfExpr = IfExprImpl(
            expr1 = this.expr1,
            operation = this.operation,
            expr2 = this.expr2
    )
}