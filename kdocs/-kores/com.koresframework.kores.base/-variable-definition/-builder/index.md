//[Kores](../../../../index.md)/[com.koresframework.kores.base](../../index.md)/[VariableDefinition](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [Named.Builder](../../-named/-builder/index.md)<[VariableDefinition](../index.md), [VariableDefinition.Builder](index.md)> , [Typed.Builder](../../-typed/-builder/index.md)<[VariableDefinition](../index.md), [VariableDefinition.Builder](index.md)> , [ValueHolder.Builder](../../-value-holder/-builder/index.md)<[VariableDefinition](../index.md), [VariableDefinition.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [VariableDefinition](../index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [VariableDefinition](../index.md)<br>Build the object of type T. |
| [name](name.md) | [jvm]<br>open override fun [name](name.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [VariableDefinition.Builder](index.md) |
| [type](type.md) | [jvm]<br>open override fun [type](type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [VariableDefinition.Builder](index.md)<br>See T. |
| [value](value.md) | [jvm]<br>open override fun [value](value.md)(value: [Instruction](../../../com.koresframework.kores/-instruction/index.md)): [VariableDefinition.Builder](index.md)<br>See T. |

## Properties

| Name | Summary |
|---|---|
| [name](name.md) | [jvm]<br>lateinit var [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [type](type.md) | [jvm]<br>lateinit var [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) |
| [value](value.md) | [jvm]<br>lateinit var [value](value.md): [Instruction](../../../com.koresframework.kores/-instruction/index.md) |
