//[Kores](../../../index.md)/[com.koresframework.kores.base](../index.md)/[Operate](index.md)

# Operate

[jvm]\
data class [Operate](index.md)(**target**: [Instruction](../../com.koresframework.kores/-instruction/index.md), **operation**: [Operator.Math](../../com.koresframework.kores.operator/-operator/-math/index.md), **value**: [Instruction](../../com.koresframework.kores/-instruction/index.md)) : [ValueHolder](../-value-holder/index.md), [TypedInstruction](../-typed-instruction/index.md)

Operate a value and return result of operation.

## Constructors

| | |
|---|---|
| [Operate](-operate.md) | [jvm]<br>fun [Operate](-operate.md)(target: [Instruction](../../com.koresframework.kores/-instruction/index.md), operation: [Operator.Math](../../com.koresframework.kores.operator/-operator/-math/index.md), value: [Instruction](../../com.koresframework.kores/-instruction/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [ValueHolder.Builder](../-value-holder/-builder/index.md)<[Operate](index.md), [Operate.Builder](-builder/index.md)> , [Typed.Builder](../-typed/-builder/index.md)<[Operate](index.md), [Operate.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [Operate.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [hasSecondArg](has-second-arg.md) | [jvm]<br>val [hasSecondArg](has-second-arg.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [operation](operation.md) | [jvm]<br>val [operation](operation.md): [Operator.Math](../../com.koresframework.kores.operator/-operator/-math/index.md)<br>Operation. |
| [target](target.md) | [jvm]<br>val [target](target.md): [Instruction](../../com.koresframework.kores/-instruction/index.md)<br>Target part to operate. |
| [type](type.md) | [jvm]<br>open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Element type |
| [value](value.md) | [jvm]<br>open override val [value](value.md): [Instruction](../../com.koresframework.kores/-instruction/index.md)<br>Second argument of the operation, may be [KoresNothing](../../com.koresframework.kores.common/index.md#-1539736051%2FClasslikes%2F-1216412040). |
