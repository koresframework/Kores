//[Kores](../../../index.md)/[com.koresframework.kores.base](../index.md)/[IfStatement](index.md)

# IfStatement

[jvm]\
data class [IfStatement](index.md)(**expressions**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.koresframework.kores/-instruction/index.md)>, **body**: [Instructions](../../com.koresframework.kores/-instructions/index.md), **elseStatement**: [Instructions](../../com.koresframework.kores/-instructions/index.md)) : [IfExpressionHolder](../-if-expression-holder/index.md), [BodyHolder](../-body-holder/index.md), [Instruction](../../com.koresframework.kores/-instruction/index.md)

If statement.

## See also

jvm

| | |
|---|---|
| [com.koresframework.kores.base.IfExpr](../-if-expr/index.md) |  |

## Constructors

| | |
|---|---|
| [IfStatement](-if-statement.md) | [jvm]<br>fun [IfStatement](-if-statement.md)(expressions: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.koresframework.kores/-instruction/index.md)>, body: [Instructions](../../com.koresframework.kores/-instructions/index.md), elseStatement: [Instructions](../../com.koresframework.kores/-instructions/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [IfExpressionHolder.Builder](../-if-expression-holder/-builder/index.md)<[IfStatement](index.md), [IfStatement.Builder](-builder/index.md)> , [BodyHolder.Builder](../-body-holder/-builder/index.md)<[IfStatement](index.md), [IfStatement.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [IfStatement.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [body](body.md) | [jvm]<br>open override val [body](body.md): [Instructions](../../com.koresframework.kores/-instructions/index.md)<br>Body. |
| [elseStatement](else-statement.md) | [jvm]<br>val [elseStatement](else-statement.md): [Instructions](../../com.koresframework.kores/-instructions/index.md)<br>Else statement |
| [expressions](expressions.md) | [jvm]<br>open override val [expressions](expressions.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.koresframework.kores/-instruction/index.md)><br>If expressions and operationsExpressions can be: [IfExpr](../-if-expr/index.md) or [IfGroup](../-if-group/index.md) (both only before and/or after Operators. |
