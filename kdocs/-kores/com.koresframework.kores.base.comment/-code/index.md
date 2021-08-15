//[Kores](../../../index.md)/[com.koresframework.kores.base.comment](../index.md)/[Code](index.md)

# Code

[jvm]\
data class [Code](index.md)(**code**: [Code.CodeNode](-code-node/index.md)) : [Comment](../-comment/index.md)

Code comment

## Constructors

| | |
|---|---|
| [Code](-code.md) | [jvm]<br>fun [Code](-code.md)(code: [Code.CodeNode](-code-node/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [Builder](../../com.koresframework.kores.builder/-builder/index.md)<[Code](index.md), [Code.Builder](-builder/index.md)> |
| [CodeNode](-code-node/index.md) | [jvm]<br>interface [CodeNode](-code-node/index.md)<br>Node of the code. |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [Code.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [code](code.md) | [jvm]<br>val [code](code.md): [Code.CodeNode](-code-node/index.md)<br>Code Node |
