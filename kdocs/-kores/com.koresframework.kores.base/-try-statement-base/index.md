//[Kores](../../../index.md)/[com.koresframework.kores.base](../index.md)/[TryStatementBase](index.md)

# TryStatementBase

[jvm]\
interface [TryStatementBase](index.md) : [BodyHolder](../-body-holder/index.md), [Instruction](../../com.koresframework.kores/-instruction/index.md)

Try-catch-finally statement

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>interface [Builder](-builder/index.md)<out [T](-builder/index.md) : [TryStatementBase](index.md), [S](-builder/index.md) : [TryStatementBase.Builder](-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>> : [BodyHolder.Builder](../-body-holder/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>abstract override fun [builder](builder.md)(): [TryStatementBase.Builder](-builder/index.md)<[TryStatementBase](index.md), *><br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [body](index.md#468172094%2FProperties%2F-1216412040) | [jvm]<br>abstract val [body](index.md#468172094%2FProperties%2F-1216412040): [Instructions](../../com.koresframework.kores/-instructions/index.md)<br>Body. |
| [catchStatements](catch-statements.md) | [jvm]<br>abstract val [catchStatements](catch-statements.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[CatchStatement](../-catch-statement/index.md)><br>Exception handler statements |
| [finallyStatement](finally-statement.md) | [jvm]<br>abstract val [finallyStatement](finally-statement.md): [Instructions](../../com.koresframework.kores/-instructions/index.md)<br>Finally block statement |

## Inheritors

| Name |
|---|
| [TryStatement](../-try-statement/index.md) |
| [TryWithResources](../-try-with-resources/index.md) |
