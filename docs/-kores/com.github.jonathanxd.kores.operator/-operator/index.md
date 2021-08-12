//[Kores](../../../index.md)/[com.github.jonathanxd.kores.operator](../index.md)/[Operator](index.md)

# Operator

[jvm]\
sealed class [Operator](index.md) : [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), [Named](../../com.github.jonathanxd.kores.base/-named/index.md)

Operator.

Example of operators: Increment, Decrement, Less_than, etc...

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [Named.Builder](../../com.github.jonathanxd.kores.base/-named/-builder/index.md)<[Operator](index.md), [Operator.Builder](-builder/index.md)> |
| [Conditional](-conditional/index.md) | [jvm]<br>class [Conditional](-conditional/index.md)(**name**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [Operator](index.md)<br>Conditional operator |
| [Math](-math/index.md) | [jvm]<br>class [Math](-math/index.md)(**name**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [Operator](index.md)<br>Mathematical operator |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [Operator.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |
| [toString](to-string.md) | [jvm]<br>open override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Properties

| Name | Summary |
|---|---|
| [name](name.md) | [jvm]<br>abstract override val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Name |

## Inheritors

| Name |
|---|
| [Operator](-math/index.md) |
| [Operator](-conditional/index.md) |
