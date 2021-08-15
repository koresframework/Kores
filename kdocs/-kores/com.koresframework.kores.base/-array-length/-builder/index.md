//[Kores](../../../../index.md)/[com.koresframework.kores.base](../../index.md)/[ArrayLength](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [ArrayAccess.Builder](../../-array-access/-builder/index.md)<[ArrayLength](../index.md), [ArrayLength.Builder](index.md)> , [Typed.Builder](../../-typed/-builder/index.md)<[ArrayLength](../index.md), [ArrayLength.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [ArrayLength](../index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [arrayType](array-type.md) | [jvm]<br>open override fun [arrayType](array-type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [ArrayLength.Builder](index.md)<br>See T. |
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [ArrayLength](../index.md)<br>Build the object of type T. |
| [target](target.md) | [jvm]<br>open override fun [target](target.md)(value: [Instruction](../../../com.koresframework.kores/-instruction/index.md)): [ArrayLength.Builder](index.md)<br>See T. |
| [type](type.md) | [jvm]<br>open override fun [type](type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [ArrayLength.Builder](index.md)<br>See T. |

## Properties

| Name | Summary |
|---|---|
| [arrayType](array-type.md) | [jvm]<br>lateinit var [arrayType](array-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) |
| [target](target.md) | [jvm]<br>lateinit var [target](target.md): [Instruction](../../../com.koresframework.kores/-instruction/index.md) |
