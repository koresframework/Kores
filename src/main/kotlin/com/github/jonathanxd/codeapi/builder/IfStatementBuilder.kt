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

import com.github.jonathanxd.codeapi.base.impl.IfStatementImpl
import com.github.jonathanxd.codeapi.base.IfStatement

// Generated by BuilderGen
open class IfStatementBuilder(): IfStatement.Builder<IfStatement, IfStatementBuilder> {

    /**
     * See [IfStatement.expressions]
     */
    var expressions: kotlin.collections.List<com.github.jonathanxd.codeapi.CodePart> = emptyList()

    /**
     * See [IfStatement.body]
     */
    var body: com.github.jonathanxd.codeapi.CodeSource? = null

    /**
     * See [IfStatement.elseStatement]
     */
    var elseStatement: com.github.jonathanxd.codeapi.CodeSource = com.github.jonathanxd.codeapi.CodeSource.empty()

    constructor(defaults: IfStatement) : this() {
        this.expressions = defaults.expressions
        this.body = defaults.body
        this.elseStatement = defaults.elseStatement
    }


    /**
     * See [IfStatement.expressions]
     */
    override fun withExpressions(value: kotlin.collections.List<com.github.jonathanxd.codeapi.CodePart>): IfStatementBuilder {
        this.expressions = value
        return this
    }


    /**
     * See [IfStatement.expressions]
     */
    override fun withExpressions(vararg values: com.github.jonathanxd.codeapi.CodePart): IfStatementBuilder {
        this.expressions = values.toList()
        return this
    }


    /**
     * See [IfStatement.body]
     */
    override fun withBody(value: com.github.jonathanxd.codeapi.CodeSource?): IfStatementBuilder {
        this.body = value
        return this
    }


    /**
     * See [IfStatement.elseStatement]
     */
    override fun withElseStatement(value: com.github.jonathanxd.codeapi.CodeSource): IfStatementBuilder {
        this.elseStatement = value
        return this
    }

    override fun build(): IfStatement = IfStatementImpl(
            expressions = this.expressions,
            body = this.body,
            elseStatement = this.elseStatement
    )


    companion object {
        @JvmStatic
        fun builder() = IfStatementBuilder()
    }
}