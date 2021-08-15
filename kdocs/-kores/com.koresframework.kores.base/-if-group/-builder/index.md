//[Kores](../../../../index.md)/[com.koresframework.kores.base](../../index.md)/[IfGroup](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [IfExpressionHolder.Builder](../../-if-expression-holder/-builder/index.md)<[IfGroup](../index.md), [IfGroup.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [IfGroup](../index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [IfGroup](../index.md)<br>Build the object of type T. |
| [expressions](expressions.md) | [jvm]<br>open override fun [expressions](expressions.md)(vararg values: [Instruction](../../../com.koresframework.kores/-instruction/index.md)): [IfGroup.Builder](index.md)<br>open override fun [expressions](expressions.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../../com.koresframework.kores/-instruction/index.md)>): [IfGroup.Builder](index.md)<br>See T. |

## Properties

| Name | Summary |
|---|---|
| [expressions](expressions.md) | [jvm]<br>var [expressions](expressions.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../../com.koresframework.kores/-instruction/index.md)> |
