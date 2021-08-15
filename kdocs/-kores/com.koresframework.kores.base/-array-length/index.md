//[Kores](../../../index.md)/[com.koresframework.kores.base](../index.md)/[ArrayLength](index.md)

# ArrayLength

[jvm]\
data class [ArrayLength](index.md)(**arrayType**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), **target**: [Instruction](../../com.koresframework.kores/-instruction/index.md)) : [ArrayAccess](../-array-access/index.md), [TypedInstruction](../-typed-instruction/index.md)

Access length of array [target](target.md) of type [arrayType](array-type.md).

## Constructors

| | |
|---|---|
| [ArrayLength](-array-length.md) | [jvm]<br>fun [ArrayLength](-array-length.md)(arrayType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), target: [Instruction](../../com.koresframework.kores/-instruction/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [ArrayAccess.Builder](../-array-access/-builder/index.md)<[ArrayLength](index.md), [ArrayLength.Builder](-builder/index.md)> , [Typed.Builder](../-typed/-builder/index.md)<[ArrayLength](index.md), [ArrayLength.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [ArrayLength.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [arrayType](array-type.md) | [jvm]<br>open override val [arrayType](array-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Array type |
| [target](target.md) | [jvm]<br>open override val [target](target.md): [Instruction](../../com.koresframework.kores/-instruction/index.md)<br>Target array to access |
| [type](type.md) | [jvm]<br>open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Element type |
