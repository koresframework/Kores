//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.base](../../index.md)/[Case](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [ValueHolder.Builder](../../-value-holder/-builder/index.md)<[Case](../index.md), [Case.Builder](index.md)> , [Typed.Builder](../../-typed/-builder/index.md)<[Case](../index.md), [Case.Builder](index.md)> , [BodyHolder.Builder](../../-body-holder/-builder/index.md)<[Case](../index.md), [Case.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [Case](../index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [body](body.md) | [jvm]<br>open override fun [body](body.md)(value: [Instructions](../../../com.github.jonathanxd.kores/-instructions/index.md)): [Case.Builder](index.md)<br>See T. |
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [Case](../index.md)<br>Build the object of type T. |
| [defaultCase](default-case.md) | [jvm]<br>fun [defaultCase](default-case.md)(): [Case.Builder](index.md)<br>Sets the case statement as default case (same as withValue(Void)). |
| [type](type.md) | [jvm]<br>open override fun [type](type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Case.Builder](index.md)<br>See T. |
| [value](value.md) | [jvm]<br>open override fun [value](value.md)(value: [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)): [Case.Builder](index.md)<br>See T. |

## Properties

| Name | Summary |
|---|---|
| [body](body.md) | [jvm]<br>var [body](body.md): [Instructions](../../../com.github.jonathanxd.kores/-instructions/index.md) |
| [value](value.md) | [jvm]<br>var [value](value.md): [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md) |
