/*
 *      Kores - Java source and Bytecode generation framework <https://github.com/JonathanxD/Kores>
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2019 TheRealBuggy/JonathanxD (https://github.com/JonathanxD/) <jonathan.scripter@programmer.net>
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
package com.github.jonathanxd.kores.inspect

import com.github.jonathanxd.kores.Instruction
import com.github.jonathanxd.kores.base.IfExpr
import com.github.jonathanxd.kores.base.IfExpressionHolder
import com.github.jonathanxd.kores.base.IfGroup
import com.github.jonathanxd.kores.literal.Literal
import com.github.jonathanxd.kores.literal.Literals
import com.github.jonathanxd.kores.operator.Operator
import com.github.jonathanxd.kores.operator.Operators
import com.github.jonathanxd.iutils.annotation.Wip

/**
 * Returns `true` if the body is only reached when [matched][matcher] [Instruction] returns `true`.
 *
 * **The `receiver` list must contains entirely expressions of if statement.**
 *
 * Examples:
 *
 * ```
 * if (x == y && (x % 2 == 0 || x == 3))
 * ```
 *
 * - [alwaysBranch] returns `true` for `x == y` because whenever the body of the flow is reached, `x` is equal to `y`.
 * - [alwaysBranch] returns `false` for `x % 2 == 0` because when the body of flow is reached,
 * `x % 2 == 0` may or may not be `true`, the same condition applies to `x == 3`.
 *
 *
 * An example of where this function can be useful:
 *
 * ```
 * if (a instanceof AccountManager) { body }
 * ```
 *
 * You can use this function to ensures that `a instanceof AccountManager` is always true when `body` is reached
 * to allow smart casting of `a` to `AccountManager` (inside the body).
 */
@Wip
fun List<Instruction>.alwaysBranch(matcher: (Instruction) -> Boolean): Boolean {
    var found = false

    for (i in this) {
        val i2 = i.removeRedundantNot()

        if (!found && matcher(i2)) {
            found = true
        }

        // Always keep this logic:
        // never reaches the `if (!found)` (code below) if any `operator != Operators.AND`
        // Or changes the logic of `if (!found)`
        if (i is Operator && i != Operators.AND) {
            return false
        }
    }

    if (!found) {
        for (i in this) {
            if (i is IfGroup) {
                if (i.alwaysBranch(matcher))
                    return true
            }
        }
    }

    return found
}


/**
 * @see alwaysBranch
 */
@Wip
fun IfExpressionHolder.alwaysBranch(matcher: (Instruction) -> Boolean) =
    this.expressions.alwaysBranch(matcher)


/**
 * Removes redundant not check.
 */
fun List<Instruction>.removeRedundantNot(): List<Instruction> =
    this.map { it.removeRedundantNot() }

/**
 * Returns `true` if `receiver` [IfExpr] is a check of [Instruction] equality to `true` constant.
 */
fun IfExpr.isCheckTrue() = this.getRuntimeBooleanEqCheck()?.booleanConstant == true

/**
 * Returns `true` if `receiver` [IfExpr] is a check of [Instruction] equality to `false` constant.
 */
fun IfExpr.isCheckFalse() = this.getRuntimeBooleanEqCheck()?.booleanConstant == false


/**
 * Returns `true` if `receiver` [IfExpr] is a check of [instruction][Instruction] equality to `true` constant
 * and [predicate] returns true for the [instruction][Instruction].
 */
inline fun IfExpr.isCheckTrueAnd(predicate: (Instruction) -> Boolean) =
    this.getRuntimeBooleanEqCheck()?.let { (ins, _, const) -> const && predicate(ins) } ?: false

/**
 * Returns `true` if `receiver` [IfExpr] is a check of [instruction][Instruction] equality to `false` constant
 * and [predicate] returns true for the [instruction][Instruction].
 */
inline fun IfExpr.isCheckFalseAnd(predicate: (Instruction) -> Boolean) =
    this.getRuntimeBooleanEqCheck()?.let { (ins, _, const) -> const && predicate(ins) } ?: false

/**
 * Removes redundant not check.
 */
fun Instruction.removeRedundantNot(): Instruction =
    (this as? IfExpr)?.removeRedundantNot() ?: this

/**
 * Removes redundant not check. Example `if (!(!a))` is simplified to `if (a)`
 */
fun IfExpr.removeRedundantNot(): IfExpr =
    this.getRuntimeBooleanEqCheck()?.let { (expr, _, const) ->
        val ifGpExprBConst = when (expr) {
            is IfGroup -> (expr.expressions.singleOrNull() as? IfExpr)?.getRuntimeBooleanEqCheck()
            is IfExpr -> expr.getRuntimeBooleanEqCheck()
            else -> null
        }

        if (ifGpExprBConst != null) {
            val (xp, _, const2) = ifGpExprBConst

            val value = const == const2

            return@let this.builder()
                .expr1(xp.removeRedundantNot())
                .operation(Operators.EQUAL_TO)
                .expr2(Literals.BOOLEAN(value))
                .build()
        }


        return@let this
    } ?: this


/**
 * Gets the runtime [Boolean] value that [IfExpr] check equality to. Returns `null` if [IfExpr] does not check
 * [Instruction] against a boolean.
 */
fun IfExpr.getRuntimeBooleanEqCheck(): EqCheck? {
    val constant = (this.expr1 as? Literal) ?: (this.expr2 as? Literal)
    val expr2 = if (this.expr2 == constant) this.expr1 else this.expr2
    val op = this.operation

    if (op != Operators.NOT_EQUAL_TO && op != Operators.EQUAL_TO)
        return null

    if (constant != null && (constant.value == "true" || constant.value == "false")) {
        val bConstant = ((constant.value as String).toBoolean())
        val boolValue =
            if (op == Operators.NOT_EQUAL_TO) !bConstant
            else bConstant

        return EqCheck(expr2, op, boolValue)
    }

    return null
}

/**
 * Data class to hold equality check against a boolean constant.
 *
 * @property instruction Instruction to check if is equal to [booleanConstant]
 * @property operator Operator used in [IfExpr] to denote the comparison, does not have any direct
 * relation to comparison against [booleanConstant].
 * @property booleanConstant Boolean constant to compare to, does not have any direct relation to [operator].
 */
data class EqCheck(
    val instruction: Instruction,
    val operator: Operator,
    val booleanConstant: Boolean
)