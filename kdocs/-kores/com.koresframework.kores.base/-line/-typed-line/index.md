//[Kores](../../../../index.md)/[com.koresframework.kores.base](../../index.md)/[Line](../index.md)/[TypedLine](index.md)

# TypedLine

[jvm]\
data class [TypedLine](index.md)(**line**: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), **value**: [Instruction](../../../com.koresframework.kores/-instruction/index.md), **type**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)) : [Line](../index.md), [Typed](../../-typed/index.md)

A [Line](../index.md) which extends [Typed](../../-typed/index.md).

## Constructors

| | |
|---|---|
| [TypedLine](-typed-line.md) | [jvm]<br>fun [TypedLine](-typed-line.md)(line: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), value: [Instruction](../../../com.koresframework.kores/-instruction/index.md), type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [Line.Builder](../-builder/index.md)<[Line.TypedLine](index.md), [Line.TypedLine.Builder](-builder/index.md)> , [Typed.Builder](../../-typed/-builder/index.md)<[Line.TypedLine](index.md), [Line.TypedLine.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [Line.TypedLine.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [line](line.md) | [jvm]<br>open override val [line](line.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Line index |
| [type](type.md) | [jvm]<br>open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Element type |
| [value](value.md) | [jvm]<br>open override val [value](value.md): [Instruction](../../../com.koresframework.kores/-instruction/index.md)<br>Instruction mapped to line |
| [wrappedInstruction](index.md#529340534%2FProperties%2F-1216412040) | [jvm]<br>open override val [wrappedInstruction](index.md#529340534%2FProperties%2F-1216412040): [Instruction](../../../com.koresframework.kores/-instruction/index.md)<br>Wrapped instruction instance. |
