//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[ControlFlow](index.md)

# ControlFlow

[jvm]\
data class [ControlFlow](index.md)(**type**: [ControlFlow.Type](-type/index.md), **at**: [Label](../-label/index.md)?) : [KoresPart](../../com.github.jonathanxd.kores/-kores-part/index.md), [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)

Control the flow of a statement.

## Constructors

| | |
|---|---|
| [ControlFlow](-control-flow.md) | [jvm]<br>fun [ControlFlow](-control-flow.md)(type: [ControlFlow.Type](-type/index.md), at: [Label](../-label/index.md)?) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [Builder](../../com.github.jonathanxd.kores.builder/-builder/index.md)<[ControlFlow](index.md), [ControlFlow.Builder](-builder/index.md)> |
| [Type](-type/index.md) | [jvm]<br>enum [Type](-type/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)<[ControlFlow.Type](-type/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [ControlFlow.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [at](at.md) | [jvm]<br>val [at](at.md): [Label](../-label/index.md)?<br>Label to control flow (Note: [Type.CONTINUE](-type/-c-o-n-t-i-n-u-e/index.md) goes to Start of label and [Type.BREAK](-type/-b-r-e-a-k/index.md) goes to end of label). |
| [type](type.md) | [jvm]<br>val [type](type.md): [ControlFlow.Type](-type/index.md)<br>Type of the flow control |
