//[Kores](../../../index.md)/[com.koresframework.kores.base](../index.md)/[Synchronized](index.md)

# Synchronized

[jvm]\
class [Synchronized](index.md)(**instruction**: [Instruction](../../com.koresframework.kores/-instruction/index.md), **body**: [Instructions](../../com.koresframework.kores/-instructions/index.md)) : [BodyHolder](../-body-holder/index.md), [Instruction](../../com.koresframework.kores/-instruction/index.md)

Synchronized statement. Locks resources to thread access.

## Constructors

| | |
|---|---|
| [Synchronized](-synchronized.md) | [jvm]<br>fun [Synchronized](-synchronized.md)(instruction: [Instruction](../../com.koresframework.kores/-instruction/index.md), body: [Instructions](../../com.koresframework.kores/-instructions/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [BodyHolder.Builder](../-body-holder/-builder/index.md)<[Synchronized](index.md), [Synchronized.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [Synchronized.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [body](body.md) | [jvm]<br>open override val [body](body.md): [Instructions](../../com.koresframework.kores/-instructions/index.md)<br>Body. |
| [instruction](instruction.md) | [jvm]<br>val [instruction](instruction.md): [Instruction](../../com.koresframework.kores/-instruction/index.md)<br>Part to lock access. |
