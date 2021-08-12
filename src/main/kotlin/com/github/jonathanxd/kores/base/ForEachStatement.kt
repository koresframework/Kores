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
package com.github.jonathanxd.kores.base

import com.github.jonathanxd.kores.Instruction
import com.github.jonathanxd.kores.Instructions
import com.github.jonathanxd.kores.common.MethodTypeSpec
import kotlinx.serialization.Serializable

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
@Serializable
data class ForEachStatement(
    val variable: VariableDeclaration,
    val iterationType: IterationType,
    val iterableElement: Instruction,
    override val body: Instructions
) : BodyHolder, Instruction {
    init {
        BodyHolder.checkBody(this)
    }

    override fun builder(): Builder = Builder(this)

    class Builder() : BodyHolder.Builder<ForEachStatement, Builder> {

        lateinit var variable: VariableDeclaration
        lateinit var iterationType: IterationType
        lateinit var iterableElement: Instruction
        var body: Instructions = Instructions.empty()

        constructor(defaults: ForEachStatement) : this() {
            this.variable = defaults.variable
            this.iterationType = defaults.iterationType
            this.iterableElement = defaults.iterableElement
        }

        /**
         * See [ForEachStatement.variable]
         */
        fun variable(value: VariableDeclaration): Builder {
            this.variable = value
            return this
        }

        /**
         * See [ForEachStatement.iterationType]
         */
        fun iterationType(value: IterationType): Builder {
            this.iterationType = value
            return this
        }

        /**
         * See [ForEachStatement.iterableElement]
         */
        fun iterableElement(value: Instruction): Builder {
            this.iterableElement = value
            return this
        }

        override fun body(value: Instructions): Builder {
            this.body = value
            return this
        }

        override fun build(): ForEachStatement =
            ForEachStatement(this.variable, this.iterationType, this.iterableElement, this.body)

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
 *
 * @property iteratorMethodSpec Specification of iterator method.
 * @property hasNextName Name of method which returns true if has next elements.
 * @property nextMethodSpec Specification of method which returns the next element.
 */
@Serializable
data class IterationType(
    val iteratorMethodSpec: MethodTypeSpec,
    val hasNextName: String,
    val nextMethodSpec: MethodTypeSpec
) {

    companion object {

        private val NOTHING_SPEC =
            MethodTypeSpec(Nothing::class.java, "", TypeSpec(Nothing::class.java))

        /**
         * Foreach on array. Requires special handling.
         */
        @JvmField
        val ARRAY = IterationType(NOTHING_SPEC, "", NOTHING_SPEC)

        /**
         * Foreach on an element which extends iterable
         */
        @JvmField
        val ITERABLE_ELEMENT = IterationType(
            MethodTypeSpec(
                localization = Iterable::class.java,
                methodName = "iterator",
                typeSpec = TypeSpec(Iterator::class.java)
            ),
            "hasNext",
            MethodTypeSpec(
                localization = Iterator::class.java,
                methodName = "next",
                typeSpec = TypeSpec(Any::class.java)
            )
        )

    }


}