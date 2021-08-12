//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.base](../../index.md)/[WhileStatement](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [IfExpressionHolder.Builder](../../-if-expression-holder/-builder/index.md)<[WhileStatement](../index.md), [WhileStatement.Builder](index.md)> , [BodyHolder.Builder](../../-body-holder/-builder/index.md)<[WhileStatement](../index.md), [WhileStatement.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [WhileStatement](../index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [body](body.md) | [jvm]<br>open override fun [body](body.md)(value: [Instructions](../../../com.github.jonathanxd.kores/-instructions/index.md)): [WhileStatement.Builder](index.md)<br>See T. |
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [WhileStatement](../index.md)<br>Build the object of type T. |
| [expressions](../../-if-expression-holder/-builder/expressions.md) | [jvm]<br>open fun [expressions](../../-if-expression-holder/-builder/expressions.md)(vararg values: [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)): [WhileStatement.Builder](index.md)<br>open override fun [expressions](expressions.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)>): [WhileStatement.Builder](index.md)<br>See T. |
| [type](type.md) | [jvm]<br>fun [type](type.md)(value: [WhileStatement.Type](../-type/index.md)): [WhileStatement.Builder](index.md)<br>See [WhileStatement.type](../type.md) |

## Properties

| Name | Summary |
|---|---|
| [body](body.md) | [jvm]<br>var [body](body.md): [Instructions](../../../com.github.jonathanxd.kores/-instructions/index.md) |
| [expressions](expressions.md) | [jvm]<br>var [expressions](expressions.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)> |
| [type](type.md) | [jvm]<br>lateinit var [type](type.md): [WhileStatement.Type](../-type/index.md) |
