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
 * For statement.
 *
 * for(forInit; forExpression; forUpdate)
 *
 * @property forInit For initialization (ex: `int i = 0`).
 * @property forExpression For expression. See [IfExpressionHolder.expressions]. (ex: `i < 10`)
 * @property forUpdate For update. (ex: `i++`)
 * @property body Body of for statement (ex: `println(i)`).
 */
data class ForStatement(val forInit: CodePart?,
                        val forExpression: List<CodePart>,
                        val forUpdate: CodePart?,
                        override val body: CodeSource) : IfExpressionHolder, BodyHolder, CodeInstruction {
    init {
        BodyHolder.checkBody(this)
    }

    override val expressions: List<CodePart>
        get() = this.forExpression

    override fun builder(): Builder = Builder(this)

    class Builder() :
            IfExpressionHolder.Builder<ForStatement, Builder>,
            BodyHolder.Builder<ForStatement, Builder> {

        var forInit: CodePart? = null
        var forExpression: List<CodePart> = emptyList()
        var forUpdate: CodePart? = null
        var body: CodeSource = CodeSource.empty()

        constructor(defaults: ForStatement) : this() {
            this.forInit = defaults.forInit
            this.forExpression = defaults.forExpression
            this.forUpdate = defaults.forUpdate
        }

        override fun withExpressions(value: List<CodePart>): Builder = this.withForExpression(value)

        override fun withExpressions(vararg values: CodePart): Builder = this.withForExpression(values.toList())

        /**
         * See [ForStatement.forInit]
         */
        fun withForInit(value: CodePart?): Builder {
            this.forInit = value
            return this
        }

        /**
         * See [ForStatement.forExpression]
         */
        fun withForExpression(value: List<CodePart>): Builder {
            this.forExpression = value
            return this
        }

        /**
         * See [ForStatement.forExpression]
         */
        fun withForExpression(vararg values: CodePart): Builder = withForExpression(values.toList())

        /**
         * See [ForStatement.forUpdate]
         */
        fun withForUpdate(value: CodePart?): Builder {
            this.forUpdate = value
            return this
        }

        override fun withBody(value: CodeSource): Builder {
            this.body = value
            return this
        }

        override fun build(): ForStatement = ForStatement(this.forInit, this.forExpression, this.forUpdate, this.body)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: ForStatement): Builder = Builder(defaults)
        }

    }
}
