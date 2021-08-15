//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[ForEachStatement](index.md)

# ForEachStatement

[jvm]\
data class [ForEachStatement](index.md)(**variable**: [VariableDeclaration](../-variable-declaration/index.md), **iterationType**: [IterationType](../-iteration-type/index.md), **iterableElement**: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), **body**: [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)) : [BodyHolder](../-body-holder/index.md), [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)

For each statement.

For each statement behavior depends on [IterationType](../-iteration-type/index.md). For Source generation [iterationType](iteration-type.md) is useless, but for bytecode generation it is useful because foreach is translated to a [ForStatement](../-for-statement/index.md), and arrays requires a special treatment to access length and values.

## See also

jvm

| | |
|---|---|
| [com.github.jonathanxd.kores.base.IterationType](../-iteration-type/index.md) |  |

## Constructors

| | |
|---|---|
| [ForEachStatement](-for-each-statement.md) | [jvm]<br>fun [ForEachStatement](-for-each-statement.md)(variable: [VariableDeclaration](../-variable-declaration/index.md), iterationType: [IterationType](../-iteration-type/index.md), iterableElement: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), body: [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [BodyHolder.Builder](../-body-holder/-builder/index.md)<[ForEachStatement](index.md), [ForEachStatement.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [ForEachStatement.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [body](body.md) | [jvm]<br>open override val [body](body.md): [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)<br>Body. |
| [iterableElement](iterable-element.md) | [jvm]<br>val [iterableElement](iterable-element.md): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)<br>Element to iterate |
| [iterationType](iteration-type.md) | [jvm]<br>val [iterationType](iteration-type.md): [IterationType](../-iteration-type/index.md)<br>Type of the iteration |
| [variable](variable.md) | [jvm]<br>val [variable](variable.md): [VariableDeclaration](../-variable-declaration/index.md)<br>Variable to store each element |
