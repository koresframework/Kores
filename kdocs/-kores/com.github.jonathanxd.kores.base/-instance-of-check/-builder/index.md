//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.base](../../index.md)/[InstanceOfCheck](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [Typed.Builder](../../-typed/-builder/index.md)<[InstanceOfCheck](../index.md), [InstanceOfCheck.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [InstanceOfCheck](../index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [InstanceOfCheck](../index.md)<br>Build the object of type T. |
| [checkType](check-type.md) | [jvm]<br>fun [checkType](check-type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [InstanceOfCheck.Builder](index.md)<br>See [InstanceOfCheck.checkType](../check-type.md) |
| [part](part.md) | [jvm]<br>fun [part](part.md)(value: [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)): [InstanceOfCheck.Builder](index.md)<br>See [InstanceOfCheck.part](../part.md) |
| [type](type.md) | [jvm]<br>open override fun [type](type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [InstanceOfCheck.Builder](index.md)<br>See T. |

## Properties

| Name | Summary |
|---|---|
| [checkType](check-type.md) | [jvm]<br>lateinit var [checkType](check-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) |
| [part](part.md) | [jvm]<br>lateinit var [part](part.md): [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md) |
