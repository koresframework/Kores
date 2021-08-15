//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[ThrowException](index.md)

# ThrowException

[jvm]\
data class [ThrowException](index.md)(**value**: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)) : [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), [ValueHolder](../-value-holder/index.md)

Throws [value](value.md).

## Constructors

| | |
|---|---|
| [ThrowException](-throw-exception.md) | [jvm]<br>fun [ThrowException](-throw-exception.md)(value: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [ValueHolder.Builder](../-value-holder/-builder/index.md)<[ThrowException](index.md), [ThrowException.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [ThrowException.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [value](value.md) | [jvm]<br>open override val [value](value.md): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)<br>Value |
