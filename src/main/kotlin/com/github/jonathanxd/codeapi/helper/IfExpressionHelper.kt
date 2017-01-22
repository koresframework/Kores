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
package com.github.jonathanxd.codeapi.helper

import com.github.jonathanxd.codeapi.CodeAPI
import com.github.jonathanxd.codeapi.CodePart
import com.github.jonathanxd.codeapi.Types
import com.github.jonathanxd.codeapi.base.IfExpr
import com.github.jonathanxd.codeapi.base.impl.IfExprImpl
import com.github.jonathanxd.codeapi.operator.Operator
import com.github.jonathanxd.codeapi.operator.Operators

class IfExpressionHelper private constructor() {

    private val list = mutableListOf<CodePart>()

    fun check(part1: CodePart, operation: Operator.Conditional, part2: CodePart): IfExpressionHelper {
        this.list.add(IfExprImpl(part1, operation, part2))
        return this
    }

    fun checkRefEqual(part1: CodePart, part2: CodePart): IfExpressionHelper {
        this.list.add(IfExprImpl(part1, Operators.EQUAL_TO, part2))
        return this
    }

    fun checkObjectEqual(part1: CodePart, part2: CodePart): IfExpressionHelper {
        return this.checkTrue(
                CodeAPI.invokeVirtual(Any::class.java, part1, "equals",
                        CodeAPI.typeSpec(Types.BOOLEAN, Types.OBJECT),
                        listOf(part2))
        )
    }

    fun checkNotNull(part1: CodePart): IfExpressionHelper {
        this.list.add(CodeAPI.checkNotNull(part1))
        return this
    }

    fun checkNull(part1: CodePart): IfExpressionHelper {
        this.list.add(CodeAPI.checkNull(part1))
        return this
    }

    fun checkTrue(part1: CodePart): IfExpressionHelper {
        this.list.add(CodeAPI.checkTrue(part1))
        return this
    }

    fun checkFalse(part1: CodePart): IfExpressionHelper {
        this.list.add(CodeAPI.checkFalse(part1))
        return this
    }

    // And
    fun and(part1: CodePart, operation: Operator.Conditional, part2: CodePart): IfExpressionHelper {

        this.list.add(Operators.AND)

        return this.check(part1, operation, part2)
    }

    fun andRefEqual(part1: CodePart, part2: CodePart): IfExpressionHelper {

        this.list.add(Operators.AND)

        return this.checkRefEqual(part1, part2)
    }

    fun andObjectEqual(part1: CodePart, part2: CodePart): IfExpressionHelper {

        this.list.add(Operators.AND)

        return this.checkObjectEqual(part1, part2)
    }

    fun andNotNull(part1: CodePart): IfExpressionHelper {

        this.list.add(Operators.AND)

        return this.checkNotNull(part1)
    }

    fun andNull(part1: CodePart): IfExpressionHelper {

        this.list.add(Operators.AND)

        return this.checkNull(part1)
    }

    fun andTrue(part1: CodePart): IfExpressionHelper {

        this.list.add(Operators.AND)

        return this.checkTrue(part1)
    }

    fun andFalse(part1: CodePart): IfExpressionHelper {

        this.list.add(Operators.AND)

        return this.checkFalse(part1)
    }

    // Or
    fun or(part1: CodePart, operation: Operator.Conditional, part2: CodePart): IfExpressionHelper {

        this.list.add(Operators.OR)

        return this.check(part1, operation, part2)
    }

    fun orRefEqual(part1: CodePart, part2: CodePart): IfExpressionHelper {

        this.list.add(Operators.OR)

        return this.checkRefEqual(part1, part2)
    }

    fun orObjectEqual(part1: CodePart, part2: CodePart): IfExpressionHelper {

        this.list.add(Operators.OR)

        return this.checkObjectEqual(part1, part2)
    }

    fun orNotNull(part1: CodePart): IfExpressionHelper {

        this.list.add(Operators.OR)

        return this.checkNotNull(part1)
    }

    fun orNull(part1: CodePart): IfExpressionHelper {

        this.list.add(Operators.OR)

        return this.checkNull(part1)
    }

    fun orTrue(part1: CodePart): IfExpressionHelper {

        this.list.add(Operators.OR)

        return this.checkTrue(part1)
    }

    fun orFalse(part1: CodePart): IfExpressionHelper {

        this.list.add(Operators.OR)

        return this.checkFalse(part1)
    }

    // Build
    fun build(): List<CodePart> {
        return this.list
    }

    companion object {

        @JvmStatic
        fun builder(): IfExpressionHelper {
            return IfExpressionHelper()
        }
    }
}
