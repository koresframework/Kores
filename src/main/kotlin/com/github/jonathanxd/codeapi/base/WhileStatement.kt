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
package com.github.jonathanxd.codeapi.base

import com.github.jonathanxd.codeapi.CodeInstruction
import com.github.jonathanxd.codeapi.CodeSource

/**
 * While statement
 *
 * @property type Type of the while block (while or do-while).
 * @property expressions Expression to check to start and/or continue the loop.
 * @property body Code to execute.
 */
data class WhileStatement(
    val type: Type,
    override val expressions: List<CodeInstruction>,
    override val body: CodeSource
) : IfExpressionHolder, BodyHolder, CodeInstruction {

    init {
        BodyHolder.checkBody(this)
    }

    override fun builder(): Builder = Builder(this)

    class Builder() :
        IfExpressionHolder.Builder<WhileStatement, Builder>,
        BodyHolder.Builder<WhileStatement, Builder> {

        lateinit var type: Type
        var expressions: List<CodeInstruction> = emptyList()
        var body: CodeSource = CodeSource.empty()

        constructor(defaults: WhileStatement) : this() {
            this.type = defaults.type
            this.expressions = defaults.expressions
            this.body = defaults.body
        }

        /**
         * See [WhileStatement.type]
         */
        fun type(value: Type): Builder {
            this.type = value
            return this
        }

        override fun body(value: CodeSource): Builder {
            this.body = value
            return this
        }

        override fun expressions(value: List<CodeInstruction>): Builder {
            this.expressions = value
            return this
        }

        override fun build(): WhileStatement =
            WhileStatement(this.type, this.expressions, this.body)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: WhileStatement): Builder = Builder(defaults)
        }

    }

    enum class Type {
        /**
         * While statement. First check expressions and then run the code if expressions succeeded.
         */
        WHILE,

        /**
         * Do-while statement. Run the code and then check expressions, if succeed continue the loop.
         */
        DO_WHILE
    }

}
