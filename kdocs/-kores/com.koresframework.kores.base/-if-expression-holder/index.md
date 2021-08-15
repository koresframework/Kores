//[Kores](../../../index.md)/[com.koresframework.kores.base](../index.md)/[IfExpressionHolder](index.md)

# IfExpressionHolder

[jvm]\
interface [IfExpressionHolder](index.md) : [KoresPart](../../com.koresframework.kores/-kores-part/index.md)

A element that holds [IfExpressions](../-if-expr/index.md) and [Operations](../../com.koresframework.kores.operator/-operators/index.md).

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>interface [Builder](-builder/index.md)<out [T](-builder/index.md) : [IfExpressionHolder](index.md), [S](-builder/index.md) : [IfExpressionHolder.Builder](-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>> : [Builder](../../com.koresframework.kores.builder/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> |
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>abstract override fun [builder](builder.md)(): [IfExpressionHolder.Builder](-builder/index.md)<[IfExpressionHolder](index.md), *><br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [expressions](expressions.md) | [jvm]<br>abstract val [expressions](expressions.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.koresframework.kores/-instruction/index.md)><br>If expressions and operationsExpressions can be: [IfExpr](../-if-expr/index.md) or [IfGroup](../-if-group/index.md) (both only before and/or after [Operators.OR](../../com.koresframework.kores.operator/-operators/-o-r.md) and [Operators.AND](../../com.koresframework.kores.operator/-operators/-a-n-d.md)), [Operators.AND](../../com.koresframework.kores.operator/-operators/-a-n-d.md) (only after a [IfExpr](../-if-expr/index.md)/[IfGroup](../-if-group/index.md), followed by other [IfExpr](../-if-expr/index.md) or [IfGroup](../-if-group/index.md)) and [Operators.OR](../../com.koresframework.kores.operator/-operators/-o-r.md) (only after a [IfExpr](../-if-expr/index.md)/[IfGroup](../-if-group/index.md) and followed by other [IfExpr](../-if-expr/index.md) or [IfGroup](../-if-group/index.md)). |

## Inheritors

| Name |
|---|
| [ForStatement](../-for-statement/index.md) |
| [IfGroup](../-if-group/index.md) |
| [IfStatement](../-if-statement/index.md) |
| [WhileStatement](../-while-statement/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [alwaysBranch](../../com.koresframework.kores.inspect/always-branch.md) | [jvm]<br>fun [IfExpressionHolder](index.md).[alwaysBranch](../../com.koresframework.kores.inspect/always-branch.md)(matcher: ([Instruction](../../com.koresframework.kores/-instruction/index.md)) -> [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
