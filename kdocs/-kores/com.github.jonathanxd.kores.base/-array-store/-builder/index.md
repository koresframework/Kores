//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.base](../../index.md)/[ArrayStore](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [ArrayAccess.Builder](../../-array-access/-builder/index.md)<[ArrayStore](../index.md), [ArrayStore.Builder](index.md)> , [ValueHolder.Builder](../../-value-holder/-builder/index.md)<[ArrayStore](../index.md), [ArrayStore.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [ArrayStore](../index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [arrayType](array-type.md) | [jvm]<br>open override fun [arrayType](array-type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [ArrayStore.Builder](index.md)<br>See T. |
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [ArrayStore](../index.md)<br>Build the object of type T. |
| [index](--index--.md) | [jvm]<br>fun [index](--index--.md)(value: [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)): [ArrayStore.Builder](index.md)<br>See [ArrayStore.index](../--index--.md) |
| [target](target.md) | [jvm]<br>open override fun [target](target.md)(value: [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)): [ArrayStore.Builder](index.md)<br>See T. |
| [value](value.md) | [jvm]<br>open override fun [value](value.md)(value: [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)): [ArrayStore.Builder](index.md)<br>See T. |
| [valueToStore](value-to-store.md) | [jvm]<br>fun [valueToStore](value-to-store.md)(value: [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)): [ArrayStore.Builder](index.md)<br>See [ArrayStore.valueToStore](../value-to-store.md) |
| [valueType](value-type.md) | [jvm]<br>fun [valueType](value-type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [ArrayStore.Builder](index.md)<br>See [ArrayStore.valueType](../value-type.md) |

## Properties

| Name | Summary |
|---|---|
| [arrayType](array-type.md) | [jvm]<br>lateinit var [arrayType](array-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) |
| [index](--index--.md) | [jvm]<br>lateinit var [index](--index--.md): [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md) |
| [target](target.md) | [jvm]<br>lateinit var [target](target.md): [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md) |
| [valueToStore](value-to-store.md) | [jvm]<br>lateinit var [valueToStore](value-to-store.md): [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md) |
| [valueType](value-type.md) | [jvm]<br>lateinit var [valueType](value-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) |
