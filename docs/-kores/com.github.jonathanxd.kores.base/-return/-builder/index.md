//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.base](../../index.md)/[Return](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [ValueHolder.Builder](../../-value-holder/-builder/index.md)<[Return](../index.md), [Return.Builder](index.md)> , [Typed.Builder](../../-typed/-builder/index.md)<[Return](../index.md), [Return.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [Return](../index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [Return](../index.md)<br>Build the object of type T. |
| [type](type.md) | [jvm]<br>open override fun [type](type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Return.Builder](index.md)<br>See T. |
| [value](value.md) | [jvm]<br>open override fun [value](value.md)(value: [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)): [Return.Builder](index.md)<br>See T. |

## Properties

| Name | Summary |
|---|---|
| [type](type.md) | [jvm]<br>lateinit var [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) |
| [value](value.md) | [jvm]<br>lateinit var [value](value.md): [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md) |
