//[Kores](../../../index.md)/[com.koresframework.kores.base](../index.md)/[Case](index.md)

# Case

[jvm]\
data class [Case](index.md)(**value**: [Instruction](../../com.koresframework.kores/-instruction/index.md), **body**: [Instructions](../../com.koresframework.kores/-instructions/index.md)) : [ValueHolder](../-value-holder/index.md), [Typed](../-typed/index.md), [BodyHolder](../-body-holder/index.md)

Case statement of [SwitchStatement](../-switch-statement/index.md).

## Constructors

| | |
|---|---|
| [Case](-case.md) | [jvm]<br>fun [Case](-case.md)(value: [Instruction](../../com.koresframework.kores/-instruction/index.md), body: [Instructions](../../com.koresframework.kores/-instructions/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [ValueHolder.Builder](../-value-holder/-builder/index.md)<[Case](index.md), [Case.Builder](-builder/index.md)> , [Typed.Builder](../-typed/-builder/index.md)<[Case](index.md), [Case.Builder](-builder/index.md)> , [BodyHolder.Builder](../-body-holder/-builder/index.md)<[Case](index.md), [Case.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [Case.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [body](body.md) | [jvm]<br>open override val [body](body.md): [Instructions](../../com.koresframework.kores/-instructions/index.md)<br>Body of case statement. |
| [isDefault](is-default.md) | [jvm]<br>val [isDefault](is-default.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Is case default |
| [isNotDefault](is-not-default.md) | [jvm]<br>val [isNotDefault](is-not-default.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Is not case default |
| [type](type.md) | [jvm]<br>open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Element type |
| [value](value.md) | [jvm]<br>open override val [value](value.md): [Instruction](../../com.koresframework.kores/-instruction/index.md)<br>Value to check if operating element matches, null for default case. |
