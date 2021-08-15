//[Kores](../../../index.md)/[com.koresframework.kores.base](../index.md)/[ArrayLoad](index.md)

# ArrayLoad

[jvm]\
data class [ArrayLoad](index.md)(**arrayType**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), **target**: [Instruction](../../com.koresframework.kores/-instruction/index.md), **index**: [Instruction](../../com.koresframework.kores/-instruction/index.md), **valueType**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)) : [ArrayAccess](../-array-access/index.md), [TypedInstruction](../-typed-instruction/index.md)

Loads a value of type [valueType](value-type.md) at [index](--index--.md) from array [target](target.md) of type [arrayType](array-type.md).

## Constructors

| | |
|---|---|
| [ArrayLoad](-array-load.md) | [jvm]<br>fun [ArrayLoad](-array-load.md)(arrayType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), target: [Instruction](../../com.koresframework.kores/-instruction/index.md), index: [Instruction](../../com.koresframework.kores/-instruction/index.md), valueType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [ArrayAccess.Builder](../-array-access/-builder/index.md)<[ArrayLoad](index.md), [ArrayLoad.Builder](-builder/index.md)> , [Typed.Builder](../-typed/-builder/index.md)<[ArrayLoad](index.md), [ArrayLoad.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [ArrayLoad.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [arrayType](array-type.md) | [jvm]<br>open override val [arrayType](array-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Array type |
| [index](--index--.md) | [jvm]<br>val [index](--index--.md): [Instruction](../../com.koresframework.kores/-instruction/index.md)<br>Index to access |
| [target](target.md) | [jvm]<br>open override val [target](target.md): [Instruction](../../com.koresframework.kores/-instruction/index.md)<br>Target array to access |
| [type](type.md) | [jvm]<br>open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Element type |
| [valueType](value-type.md) | [jvm]<br>val [valueType](value-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Type of value |
