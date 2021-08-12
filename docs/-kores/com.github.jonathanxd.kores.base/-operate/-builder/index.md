//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.base](../../index.md)/[Operate](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [ValueHolder.Builder](../../-value-holder/-builder/index.md)<[Operate](../index.md), [Operate.Builder](index.md)> , [Typed.Builder](../../-typed/-builder/index.md)<[Operate](../index.md), [Operate.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [Operate](../index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [Operate](../index.md)<br>Build the object of type T. |
| [operation](operation.md) | [jvm]<br>fun [operation](operation.md)(value: [Operator.Math](../../../com.github.jonathanxd.kores.operator/-operator/-math/index.md)): [Operate.Builder](index.md)<br>See [Operate.operation](../operation.md) |
| [target](target.md) | [jvm]<br>fun [target](target.md)(value: [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)): [Operate.Builder](index.md)<br>See [Operate.target](../target.md) |
| [type](type.md) | [jvm]<br>open override fun [type](type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Operate.Builder](index.md)<br>See T. |
| [value](value.md) | [jvm]<br>open override fun [value](value.md)(value: [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)): [Operate.Builder](index.md)<br>See T. |

## Properties

| Name | Summary |
|---|---|
| [operation](operation.md) | [jvm]<br>lateinit var [operation](operation.md): [Operator.Math](../../../com.github.jonathanxd.kores.operator/-operator/-math/index.md) |
| [target](target.md) | [jvm]<br>lateinit var [target](target.md): [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md) |
| [value](value.md) | [jvm]<br>var [value](value.md): [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md) |
