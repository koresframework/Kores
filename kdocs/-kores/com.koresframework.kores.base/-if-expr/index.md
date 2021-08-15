//[Kores](../../../index.md)/[com.koresframework.kores.base](../index.md)/[IfExpr](index.md)

# IfExpr

[jvm]\
data class [IfExpr](index.md)(**expr1**: [Instruction](../../com.koresframework.kores/-instruction/index.md), **operation**: [Operator.Conditional](../../com.koresframework.kores.operator/-operator/-conditional/index.md), **expr2**: [Instruction](../../com.koresframework.kores/-instruction/index.md)) : [KoresPart](../../com.koresframework.kores/-kores-part/index.md), [Instruction](../../com.koresframework.kores/-instruction/index.md)

Condition evaluation.

## See also

jvm

| | |
|---|---|
| [com.koresframework.kores.base.IfStatement](../-if-statement/index.md) |  |

## Constructors

| | |
|---|---|
| [IfExpr](-if-expr.md) | [jvm]<br>fun [IfExpr](-if-expr.md)(expr1: [Instruction](../../com.koresframework.kores/-instruction/index.md), operation: [Operator.Conditional](../../com.koresframework.kores.operator/-operator/-conditional/index.md), expr2: [Instruction](../../com.koresframework.kores/-instruction/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [Builder](../../com.koresframework.kores.builder/-builder/index.md)<[IfExpr](index.md), [IfExpr.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [IfExpr.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [expr1](expr1.md) | [jvm]<br>val [expr1](expr1.md): [Instruction](../../com.koresframework.kores/-instruction/index.md)<br>First expression |
| [expr2](expr2.md) | [jvm]<br>val [expr2](expr2.md): [Instruction](../../com.koresframework.kores/-instruction/index.md)<br>Second expression |
| [operation](operation.md) | [jvm]<br>val [operation](operation.md): [Operator.Conditional](../../com.koresframework.kores.operator/-operator/-conditional/index.md)<br>Operation |

## Extensions

| Name | Summary |
|---|---|
| [getRuntimeBooleanEqCheck](../../com.koresframework.kores.inspect/get-runtime-boolean-eq-check.md) | [jvm]<br>fun [IfExpr](index.md).[getRuntimeBooleanEqCheck](../../com.koresframework.kores.inspect/get-runtime-boolean-eq-check.md)(): [EqCheck](../../com.koresframework.kores.inspect/-eq-check/index.md)?<br>Gets the runtime [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) value that [IfExpr](index.md) check equality to. |
| [isCheckFalse](../../com.koresframework.kores.inspect/is-check-false.md) | [jvm]<br>fun [IfExpr](index.md).[isCheckFalse](../../com.koresframework.kores.inspect/is-check-false.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if receiver[IfExpr](index.md) is a check of [Instruction](../../com.koresframework.kores/-instruction/index.md) equality to false constant. |
| [isCheckFalseAnd](../../com.koresframework.kores.inspect/is-check-false-and.md) | [jvm]<br>inline fun [IfExpr](index.md).[isCheckFalseAnd](../../com.koresframework.kores.inspect/is-check-false-and.md)(predicate: ([Instruction](../../com.koresframework.kores/-instruction/index.md)) -> [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if receiver[IfExpr](index.md) is a check of [instruction](../../com.koresframework.kores/-instruction/index.md) equality to false constant and [predicate](../../com.koresframework.kores.inspect/is-check-false-and.md) returns true for the [instruction](../../com.koresframework.kores/-instruction/index.md). |
| [isCheckTrue](../../com.koresframework.kores.inspect/is-check-true.md) | [jvm]<br>fun [IfExpr](index.md).[isCheckTrue](../../com.koresframework.kores.inspect/is-check-true.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if receiver[IfExpr](index.md) is a check of [Instruction](../../com.koresframework.kores/-instruction/index.md) equality to true constant. |
| [isCheckTrueAnd](../../com.koresframework.kores.inspect/is-check-true-and.md) | [jvm]<br>inline fun [IfExpr](index.md).[isCheckTrueAnd](../../com.koresframework.kores.inspect/is-check-true-and.md)(predicate: ([Instruction](../../com.koresframework.kores/-instruction/index.md)) -> [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if receiver[IfExpr](index.md) is a check of [instruction](../../com.koresframework.kores/-instruction/index.md) equality to true constant and [predicate](../../com.koresframework.kores.inspect/is-check-true-and.md) returns true for the [instruction](../../com.koresframework.kores/-instruction/index.md). |
| [removeRedundantNot](../../com.koresframework.kores.inspect/remove-redundant-not.md) | [jvm]<br>fun [IfExpr](index.md).[removeRedundantNot](../../com.koresframework.kores.inspect/remove-redundant-not.md)(): [IfExpr](index.md)<br>Removes redundant not check. |
