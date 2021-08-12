//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.base](../../index.md)/[Concat](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [Typed.Builder](../../-typed/-builder/index.md)<[Concat](../index.md), [Concat.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [Concat](../index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [Concat](../index.md)<br>Build the object of type T. |
| [concatenations](concatenations.md) | [jvm]<br>fun [concatenations](concatenations.md)(vararg values: [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)): [Concat.Builder](index.md)<br>fun [concatenations](concatenations.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)>): [Concat.Builder](index.md)<br>See [Concat.concatenations](../concatenations.md) |
| [type](type.md) | [jvm]<br>open override fun [type](type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Concat.Builder](index.md)<br>See T. |

## Properties

| Name | Summary |
|---|---|
| [concatenations](concatenations.md) | [jvm]<br>var [concatenations](concatenations.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)> |
