//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.base](../../index.md)/[ArrayLoad](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [ArrayAccess.Builder](../../-array-access/-builder/index.md)<[ArrayLoad](../index.md), [ArrayLoad.Builder](index.md)> , [Typed.Builder](../../-typed/-builder/index.md)<[ArrayLoad](../index.md), [ArrayLoad.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [ArrayLoad](../index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [arrayType](array-type.md) | [jvm]<br>open override fun [arrayType](array-type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [ArrayLoad.Builder](index.md)<br>See T. |
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [ArrayLoad](../index.md)<br>Build the object of type T. |
| [index](--index--.md) | [jvm]<br>fun [index](--index--.md)(value: [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)): [ArrayLoad.Builder](index.md)<br>See [ArrayLoad.index](../--index--.md) |
| [target](target.md) | [jvm]<br>open override fun [target](target.md)(value: [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)): [ArrayLoad.Builder](index.md)<br>See T. |
| [type](type.md) | [jvm]<br>open override fun [type](type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [ArrayLoad.Builder](index.md)<br>See T. |
| [valueType](value-type.md) | [jvm]<br>fun [valueType](value-type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [ArrayLoad.Builder](index.md)<br>See [ArrayLoad.valueType](../value-type.md) |

## Properties

| Name | Summary |
|---|---|
| [arrayType](array-type.md) | [jvm]<br>lateinit var [arrayType](array-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) |
| [index](--index--.md) | [jvm]<br>lateinit var [index](--index--.md): [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md) |
| [target](target.md) | [jvm]<br>lateinit var [target](target.md): [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md) |
| [valueType](value-type.md) | [jvm]<br>lateinit var [valueType](value-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) |
