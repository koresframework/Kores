//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.base](../../index.md)/[ForEachStatement](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [BodyHolder.Builder](../../-body-holder/-builder/index.md)<[ForEachStatement](../index.md), [ForEachStatement.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [ForEachStatement](../index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [body](body.md) | [jvm]<br>open override fun [body](body.md)(value: [Instructions](../../../com.github.jonathanxd.kores/-instructions/index.md)): [ForEachStatement.Builder](index.md)<br>See T. |
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [ForEachStatement](../index.md)<br>Build the object of type T. |
| [iterableElement](iterable-element.md) | [jvm]<br>fun [iterableElement](iterable-element.md)(value: [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)): [ForEachStatement.Builder](index.md)<br>See [ForEachStatement.iterableElement](../iterable-element.md) |
| [iterationType](iteration-type.md) | [jvm]<br>fun [iterationType](iteration-type.md)(value: [IterationType](../../-iteration-type/index.md)): [ForEachStatement.Builder](index.md)<br>See [ForEachStatement.iterationType](../iteration-type.md) |
| [variable](variable.md) | [jvm]<br>fun [variable](variable.md)(value: [VariableDeclaration](../../-variable-declaration/index.md)): [ForEachStatement.Builder](index.md)<br>See [ForEachStatement.variable](../variable.md) |

## Properties

| Name | Summary |
|---|---|
| [body](body.md) | [jvm]<br>var [body](body.md): [Instructions](../../../com.github.jonathanxd.kores/-instructions/index.md) |
| [iterableElement](iterable-element.md) | [jvm]<br>lateinit var [iterableElement](iterable-element.md): [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md) |
| [iterationType](iteration-type.md) | [jvm]<br>lateinit var [iterationType](iteration-type.md): [IterationType](../../-iteration-type/index.md) |
| [variable](variable.md) | [jvm]<br>lateinit var [variable](variable.md): [VariableDeclaration](../../-variable-declaration/index.md) |
