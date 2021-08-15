//[Kores](../../../../index.md)/[com.koresframework.kores.base](../../index.md)/[IfStatement](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [IfExpressionHolder.Builder](../../-if-expression-holder/-builder/index.md)<[IfStatement](../index.md), [IfStatement.Builder](index.md)> , [BodyHolder.Builder](../../-body-holder/-builder/index.md)<[IfStatement](../index.md), [IfStatement.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [IfStatement](../index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [body](body.md) | [jvm]<br>open override fun [body](body.md)(value: [Instructions](../../../com.koresframework.kores/-instructions/index.md)): [IfStatement.Builder](index.md)<br>See T. |
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [IfStatement](../index.md)<br>Build the object of type T. |
| [elseStatement](else-statement.md) | [jvm]<br>fun [elseStatement](else-statement.md)(value: [Instructions](../../../com.koresframework.kores/-instructions/index.md)): [IfStatement.Builder](index.md)<br>See [IfStatement.elseStatement](../else-statement.md) |
| [expressions](../../-if-expression-holder/-builder/expressions.md) | [jvm]<br>open fun [expressions](../../-if-expression-holder/-builder/expressions.md)(vararg values: [Instruction](../../../com.koresframework.kores/-instruction/index.md)): [IfStatement.Builder](index.md)<br>open override fun [expressions](expressions.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../../com.koresframework.kores/-instruction/index.md)>): [IfStatement.Builder](index.md)<br>See T. |

## Properties

| Name | Summary |
|---|---|
| [body](body.md) | [jvm]<br>var [body](body.md): [Instructions](../../../com.koresframework.kores/-instructions/index.md) |
| [elseStatement](else-statement.md) | [jvm]<br>var [elseStatement](else-statement.md): [Instructions](../../../com.koresframework.kores/-instructions/index.md) |
| [expressions](expressions.md) | [jvm]<br>var [expressions](expressions.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../../com.koresframework.kores/-instruction/index.md)> |
