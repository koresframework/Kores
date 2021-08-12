//[Kores](../../index.md)/[com.github.jonathanxd.kores.inspect](index.md)

# Package com.github.jonathanxd.kores.inspect

## Types

| Name | Summary |
|---|---|
| [EqCheck](-eq-check/index.md) | [jvm]<br>data class [EqCheck](-eq-check/index.md)(**instruction**: [Instruction](../com.github.jonathanxd.kores/-instruction/index.md), **operator**: [Operator](../com.github.jonathanxd.kores.operator/-operator/index.md), **booleanConstant**: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html))<br>Data class to hold equality check against a boolean constant. |
| [InstructionsInspect](-instructions-inspect/index.md) | [jvm]<br>class [InstructionsInspect](-instructions-inspect/index.md)<out [R](-instructions-inspect/index.md)><br>Utility to inspect [Instructions](../com.github.jonathanxd.kores/-instructions/index.md). |
| [InstructionsInspectBuilder](-instructions-inspect-builder/index.md) | [jvm]<br>class [InstructionsInspectBuilder](-instructions-inspect-builder/index.md)<[R](-instructions-inspect-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [alwaysBranch](always-branch.md) | [jvm]<br>fun [IfExpressionHolder](../com.github.jonathanxd.kores.base/-if-expression-holder/index.md).[alwaysBranch](always-branch.md)(matcher: ([Instruction](../com.github.jonathanxd.kores/-instruction/index.md)) -> [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>[jvm]<br>fun [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../com.github.jonathanxd.kores/-instruction/index.md)>.[alwaysBranch](always-branch.md)(matcher: ([Instruction](../com.github.jonathanxd.kores/-instruction/index.md)) -> [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if the body is only reached when [matched](always-branch.md)[Instruction](../com.github.jonathanxd.kores/-instruction/index.md) returns true. |
| [getRuntimeBooleanEqCheck](get-runtime-boolean-eq-check.md) | [jvm]<br>fun [IfExpr](../com.github.jonathanxd.kores.base/-if-expr/index.md).[getRuntimeBooleanEqCheck](get-runtime-boolean-eq-check.md)(): [EqCheck](-eq-check/index.md)?<br>Gets the runtime [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) value that [IfExpr](../com.github.jonathanxd.kores.base/-if-expr/index.md) check equality to. |
| [isCheckFalse](is-check-false.md) | [jvm]<br>fun [IfExpr](../com.github.jonathanxd.kores.base/-if-expr/index.md).[isCheckFalse](is-check-false.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if receiver[IfExpr](../com.github.jonathanxd.kores.base/-if-expr/index.md) is a check of [Instruction](../com.github.jonathanxd.kores/-instruction/index.md) equality to false constant. |
| [isCheckFalseAnd](is-check-false-and.md) | [jvm]<br>inline fun [IfExpr](../com.github.jonathanxd.kores.base/-if-expr/index.md).[isCheckFalseAnd](is-check-false-and.md)(predicate: ([Instruction](../com.github.jonathanxd.kores/-instruction/index.md)) -> [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if receiver[IfExpr](../com.github.jonathanxd.kores.base/-if-expr/index.md) is a check of [instruction](../com.github.jonathanxd.kores/-instruction/index.md) equality to false constant and [predicate](is-check-false-and.md) returns true for the [instruction](../com.github.jonathanxd.kores/-instruction/index.md). |
| [isCheckTrue](is-check-true.md) | [jvm]<br>fun [IfExpr](../com.github.jonathanxd.kores.base/-if-expr/index.md).[isCheckTrue](is-check-true.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if receiver[IfExpr](../com.github.jonathanxd.kores.base/-if-expr/index.md) is a check of [Instruction](../com.github.jonathanxd.kores/-instruction/index.md) equality to true constant. |
| [isCheckTrueAnd](is-check-true-and.md) | [jvm]<br>inline fun [IfExpr](../com.github.jonathanxd.kores.base/-if-expr/index.md).[isCheckTrueAnd](is-check-true-and.md)(predicate: ([Instruction](../com.github.jonathanxd.kores/-instruction/index.md)) -> [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if receiver[IfExpr](../com.github.jonathanxd.kores.base/-if-expr/index.md) is a check of [instruction](../com.github.jonathanxd.kores/-instruction/index.md) equality to true constant and [predicate](is-check-true-and.md) returns true for the [instruction](../com.github.jonathanxd.kores/-instruction/index.md). |
| [removeRedundantNot](remove-redundant-not.md) | [jvm]<br>fun [Instruction](../com.github.jonathanxd.kores/-instruction/index.md).[removeRedundantNot](remove-redundant-not.md)(): [Instruction](../com.github.jonathanxd.kores/-instruction/index.md)<br>fun [IfExpr](../com.github.jonathanxd.kores.base/-if-expr/index.md).[removeRedundantNot](remove-redundant-not.md)(): [IfExpr](../com.github.jonathanxd.kores.base/-if-expr/index.md)<br>fun [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../com.github.jonathanxd.kores/-instruction/index.md)>.[removeRedundantNot](remove-redundant-not.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../com.github.jonathanxd.kores/-instruction/index.md)><br>Removes redundant not check. |