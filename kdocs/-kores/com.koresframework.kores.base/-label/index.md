//[Kores](../../../index.md)/[com.koresframework.kores.base](../index.md)/[Label](index.md)

# Label

[jvm]\
data class [Label](index.md)(**name**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **body**: [Instructions](../../com.koresframework.kores/-instructions/index.md)) : [BodyHolder](../-body-holder/index.md), [Named](../-named/index.md), [Instruction](../../com.koresframework.kores/-instruction/index.md)

Label.

Labels with empty name will be treated as a scope block.

## Constructors

| | |
|---|---|
| [Label](-label.md) | [jvm]<br>fun [Label](-label.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), body: [Instructions](../../com.koresframework.kores/-instructions/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [BodyHolder.Builder](../-body-holder/-builder/index.md)<[Label](index.md), [Label.Builder](-builder/index.md)> , [Named.Builder](../-named/-builder/index.md)<[Label](index.md), [Label.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [Label.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [body](body.md) | [jvm]<br>open override val [body](body.md): [Instructions](../../com.koresframework.kores/-instructions/index.md)<br>Body. |
| [name](name.md) | [jvm]<br>open override val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Name |
