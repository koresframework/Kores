//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.base](../../index.md)/[Line](../index.md)/[NormalLine](index.md)

# NormalLine

[jvm]\
data class [NormalLine](index.md)(**line**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), **value**: [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)) : [Line](../index.md)

A Line which does extends [Line](../index.md)

## Constructors

| | |
|---|---|
| [NormalLine](-normal-line.md) | [jvm]<br>fun [NormalLine](-normal-line.md)(line: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), value: [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [Line.Builder](../-builder/index.md)<[Line.NormalLine](index.md), [Line.NormalLine.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [Line.NormalLine.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [line](line.md) | [jvm]<br>open override val [line](line.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Line index |
| [value](value.md) | [jvm]<br>open override val [value](value.md): [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)<br>Instruction mapped to line |
| [wrappedInstruction](index.md#-1693822215%2FProperties%2F-1216412040) | [jvm]<br>open override val [wrappedInstruction](index.md#-1693822215%2FProperties%2F-1216412040): [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)<br>Wrapped instruction instance. |
