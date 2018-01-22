/*
 *      CodeAPI - Java source and Bytecode generation framework <https://github.com/JonathanxD/CodeAPI>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2018 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
import com.github.jonathanxd.codeapi.operator.Operators

/**
 * A element that holds [IfExpressions][IfExpr] and [Operations][Operators].
 */
interface IfExpressionHolder : CodePart {

    /**
     * If expressions and operations
     *
     * Expressions can be: [IfExpr] or [IfGroup] (both only before and/or after [Operators.OR] and [Operators.AND]),
     * [Operators.AND] (only after a [IfExpr]/[IfGroup], followed by other [IfExpr] or [IfGroup])
     * and [Operators.OR] (only after a [IfExpr]/[IfGroup] and followed by other [IfExpr] or [IfGroup]).
     *
     * Example of valid and invalid expressions:
     *
     * [IfExpr] [Operators.OR] [IfExpr] = Valid
     * [IfExpr] [Operators.AND] [IfExpr] = Valid
     * [IfExpr] [IfExpr] = Invalid
     * [Operators.OR] [IfExpr] = Invalid
     * [Operators.OR] [IfGroup] = Invalid
     * [IfExpr] [Operators.AND] = Invalid
     * [IfExpr] [IfGroup] = Invalid
     * [IfExpr] [Operators.AND] [IfGroup] = Valid
     */
    val expressions: List<CodeInstruction>

    override fun builder(): Builder<IfExpressionHolder, *>

    interface Builder<out T : IfExpressionHolder, S : Builder<T, S>> :
        com.github.jonathanxd.codeapi.builder.Builder<T, S> {
        /**
         * See [T.expressions]
         */
        fun expressions(value: List<CodeInstruction>): S

        /**
         * See [T.expressions]
         */
        fun expressions(vararg values: CodeInstruction): S = expressions(values.toList())
    }

    companion object {
        fun check(part: CodeInstruction) {
            if (!(part is IfExpr || part === Operators.AND || part === Operators.OR)) {
                throw IllegalArgumentException("Accept only IfExpr and Operators AND & OR. Current: " + part)
            }
        }
    }
}