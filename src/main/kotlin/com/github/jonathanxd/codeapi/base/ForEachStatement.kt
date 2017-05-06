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

import com.github.jonathanxd.codeapi.CodePart
import com.github.jonathanxd.codeapi.CodeSource

/**
 * For each statement.
 *
 * For each statement behavior depends on [IterationType]. For Source generation [iterationType] is useless,
 * but for bytecode generation it is useful because `foreach` is translated to a [ForStatement], and arrays
 * requires a special treatment to access length and values.
 *
 * @property variable Variable to store each element
 * @property iterationType Type of the iteration
 * @property iterableElement Element to iterate
 * @see IterationType
 */
data class ForEachStatement(val variable: VariableDeclaration, val iterationType: IterationType, val iterableElement: CodePart, override val body: CodeSource) : BodyHolder {
    init {
        BodyHolder.checkBody(this)
    }

    override fun builder(): Builder = Builder(this)

    class Builder() : BodyHolder.Builder<ForEachStatement, Builder> {

        lateinit var variable: VariableDeclaration
        lateinit var iterationType: IterationType
        lateinit var iterableElement: CodePart
        var body: CodeSource = CodeSource.empty()

        constructor(defaults: ForEachStatement) : this() {
            this.variable = defaults.variable
            this.iterationType = defaults.iterationType
            this.iterableElement = defaults.iterableElement
        }

        /**
         * See [ForEachStatement.variable]
         */
        fun withVariable(value: VariableDeclaration): Builder {
            this.variable = value
            return this
        }

        /**
         * See [ForEachStatement.iterationType]
         */
        fun withIterationType(value: IterationType): Builder {
            this.iterationType = value
            return this
        }

        /**
         * See [ForEachStatement.iterableElement]
         */
        fun withIterableElement(value: CodePart): Builder {
            this.iterableElement = value
            return this
        }

        override fun withBody(value: CodeSource): Builder {
            this.body = value
            return this
        }

        override fun build(): ForEachStatement = ForEachStatement(this.variable, this.iterationType, this.iterableElement, this.body)

        companion object {
            @JvmStatic
            fun builder(): Builder = Builder()

            @JvmStatic
            fun builder(defaults: ForEachStatement): Builder = Builder(defaults)
        }

    }
}

/**
 * Iteration type used to generate bytecode and source code iterations.
 */
enum class IterationType  {

    ARRAY,
    ITERABLE_ELEMENT

}