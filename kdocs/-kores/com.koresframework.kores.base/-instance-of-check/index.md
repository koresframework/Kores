//[Kores](../../../index.md)/[com.koresframework.kores.base](../index.md)/[InstanceOfCheck](index.md)

# InstanceOfCheck

[jvm]\
data class [InstanceOfCheck](index.md)(**part**: [Instruction](../../com.koresframework.kores/-instruction/index.md), **checkType**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)) : [Typed](../-typed/index.md), [Instruction](../../com.koresframework.kores/-instruction/index.md)

Checks if [part](part.md) is instanceof[checkType](check-type.md).

## Constructors

| | |
|---|---|
| [InstanceOfCheck](-instance-of-check.md) | [jvm]<br>fun [InstanceOfCheck](-instance-of-check.md)(part: [Instruction](../../com.koresframework.kores/-instruction/index.md), checkType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [Typed.Builder](../-typed/-builder/index.md)<[InstanceOfCheck](index.md), [InstanceOfCheck.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [InstanceOfCheck.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [checkType](check-type.md) | [jvm]<br>val [checkType](check-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Type to check if part value is instance. |
| [part](part.md) | [jvm]<br>val [part](part.md): [Instruction](../../com.koresframework.kores/-instruction/index.md)<br>Casted part |
| [type](type.md) | [jvm]<br>open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Element type |
