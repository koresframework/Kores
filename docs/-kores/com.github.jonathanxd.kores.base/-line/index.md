//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[Line](index.md)

# Line

[jvm]\
sealed class [Line](index.md) : [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), [ValueHolder](../-value-holder/index.md), InstructionWrapper

Base class of line mapping. Line mapping behaves differently for different generators.

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>interface [Builder](-builder/index.md)<out [T](-builder/index.md) : [Line](index.md), [S](-builder/index.md) : [Line.Builder](-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>> : [ValueHolder.Builder](../-value-holder/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> |
| [NormalLine](-normal-line/index.md) | [jvm]<br>data class [NormalLine](-normal-line/index.md)(**line**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), **value**: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)) : [Line](index.md)<br>A Line which does extends [Line](index.md) |
| [TypedLine](-typed-line/index.md) | [jvm]<br>data class [TypedLine](-typed-line/index.md)(**line**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), **value**: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), **type**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)) : [Line](index.md), [Typed](../-typed/index.md)<br>A [Line](index.md) which extends [Typed](../-typed/index.md). |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>abstract override fun [builder](builder.md)(): [Line.Builder](-builder/index.md)<[Line](index.md), *><br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [line](line.md) | [jvm]<br>abstract val [line](line.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Line index |
| [value](value.md) | [jvm]<br>abstract override val [value](value.md): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)<br>Instruction mapped to line |
| [wrappedInstruction](wrapped-instruction.md) | [jvm]<br>open override val [wrappedInstruction](wrapped-instruction.md): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)<br>Wrapped instruction instance. |

## Inheritors

| Name |
|---|
| [Line](-typed-line/index.md) |
| [Line](-normal-line/index.md) |
