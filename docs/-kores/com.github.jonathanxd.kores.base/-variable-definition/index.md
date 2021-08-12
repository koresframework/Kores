//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[VariableDefinition](index.md)

# VariableDefinition

[jvm]\
data class [VariableDefinition](index.md)(**type**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), **name**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **value**: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)) : [Named](../-named/index.md), [TypedInstruction](../-typed-instruction/index.md), [ValueHolder](../-value-holder/index.md)

Defines the value of variable of type [type](type.md) and name [name](name.md) to [value](value.md).

## Constructors

| | |
|---|---|
| [VariableDefinition](-variable-definition.md) | [jvm]<br>fun [VariableDefinition](-variable-definition.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), value: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [Named.Builder](../-named/-builder/index.md)<[VariableDefinition](index.md), [VariableDefinition.Builder](-builder/index.md)> , [Typed.Builder](../-typed/-builder/index.md)<[VariableDefinition](index.md), [VariableDefinition.Builder](-builder/index.md)> , [ValueHolder.Builder](../-value-holder/-builder/index.md)<[VariableDefinition](index.md), [VariableDefinition.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [VariableDefinition.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [name](name.md) | [jvm]<br>open override val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Name |
| [type](type.md) | [jvm]<br>open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Element type |
| [value](value.md) | [jvm]<br>open override val [value](value.md): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)<br>Value |
