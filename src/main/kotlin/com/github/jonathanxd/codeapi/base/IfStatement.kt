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
package com.github.jonathanxd.codeapi.base

import com.github.jonathanxd.codeapi.CodeInstruction
import com.github.jonathanxd.codeapi.CodePart
import com.github.jonathanxd.codeapi.CodeSource

/**
 * If statement.
 *
 * @property elseStatement Else statement
 * @see IfExpr
 */
data class IfStatement(override val expressions: List<CodePart>, override val body: CodeSource, val elseStatement: CodeSource) : IfExpressionHolder, BodyHolder, CodeInstruction {
    init {
        BodyHolder.checkBody(this)
    }

    override fun builder(): Builder = Builder(this)

    class Builder() :
            IfExpressionHolder.Builder<IfStatement, Builder>,
            BodyHolder.Builder<IfStatement, Builder> {

        var expressions: List<CodePart> = emptyList()
        var body: CodeSource = CodeSource.empty()
        var elseStatement: CodeSource = CodeSource.empty()

        constructor(defaults: IfStatement) : this() {
            this.expressions = defaults.expressions
            this.body = defaults.body
            this.elseStatement = defaults.elseStatement
        }

        /**
         * See [IfStatement.elseStatement]
         */
        fun withElseStatement(value: CodeSource): Builder {
            this.elseStatement = value
            return this
        }

        override fun withExpressions(value: List<CodePart>): Builder {
            this.expressions = value
            return this
        }

        override fun withBody(value: CodeSource): Builder {
            this.body = value
            return this
        }

        override fun build(): IfStatement = IfStatement(this.expressions, this.body, this.elseStatement)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: IfStatement): Builder = Builder(defaults)
        }

    }
}
