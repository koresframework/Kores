//[Kores](../../../index.md)/[com.koresframework.kores.base](../index.md)/[ArrayStore](index.md)

# ArrayStore

[jvm]\
data class [ArrayStore](index.md)(**arrayType**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), **target**: [Instruction](../../com.koresframework.kores/-instruction/index.md), **index**: [Instruction](../../com.koresframework.kores/-instruction/index.md), **valueType**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), **valueToStore**: [Instruction](../../com.koresframework.kores/-instruction/index.md)) : [ArrayAccess](../-array-access/index.md), [ValueHolder](../-value-holder/index.md), [Instruction](../../com.koresframework.kores/-instruction/index.md)

Stores [value](value-to-store.md) of type [valueType](value-type.md) in array [target](target.md) of type [arrayType](array-type.md) at [index](--index--.md).

## Constructors

| | |
|---|---|
| [ArrayStore](-array-store.md) | [jvm]<br>fun [ArrayStore](-array-store.md)(arrayType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), target: [Instruction](../../com.koresframework.kores/-instruction/index.md), index: [Instruction](../../com.koresframework.kores/-instruction/index.md), valueType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), valueToStore: [Instruction](../../com.koresframework.kores/-instruction/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [ArrayAccess.Builder](../-array-access/-builder/index.md)<[ArrayStore](index.md), [ArrayStore.Builder](-builder/index.md)> , [ValueHolder.Builder](../-value-holder/-builder/index.md)<[ArrayStore](index.md), [ArrayStore.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [ArrayStore.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [arrayType](array-type.md) | [jvm]<br>open override val [arrayType](array-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Array type |
| [index](--index--.md) | [jvm]<br>val [index](--index--.md): [Instruction](../../com.koresframework.kores/-instruction/index.md)<br>Index to access |
| [target](target.md) | [jvm]<br>open override val [target](target.md): [Instruction](../../com.koresframework.kores/-instruction/index.md)<br>Target array to access |
| [value](value.md) | [jvm]<br>open override val [value](value.md): [Instruction](../../com.koresframework.kores/-instruction/index.md)<br>Value |
| [valueToStore](value-to-store.md) | [jvm]<br>val [valueToStore](value-to-store.md): [Instruction](../../com.koresframework.kores/-instruction/index.md)<br>Value to store |
| [valueType](value-type.md) | [jvm]<br>val [valueType](value-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Type of value to store |
