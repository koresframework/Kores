//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[TryStatement](index.md)

# TryStatement

[jvm]\
data class [TryStatement](index.md)(**body**: [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md), **catchStatements**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[CatchStatement](../-catch-statement/index.md)>, **finallyStatement**: [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)) : [TryStatementBase](../-try-statement-base/index.md)

Try-catch-finally statement.

## Constructors

| | |
|---|---|
| [TryStatement](-try-statement.md) | [jvm]<br>fun [TryStatement](-try-statement.md)(body: [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md), catchStatements: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[CatchStatement](../-catch-statement/index.md)>, finallyStatement: [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [TryStatementBase.Builder](../-try-statement-base/-builder/index.md)<[TryStatement](index.md), [TryStatement.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [TryStatement.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [body](body.md) | [jvm]<br>open override val [body](body.md): [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)<br>Body of try statement |
| [catchStatements](catch-statements.md) | [jvm]<br>open override val [catchStatements](catch-statements.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[CatchStatement](../-catch-statement/index.md)><br>Catch clauses/exception handlers. |
| [finallyStatement](finally-statement.md) | [jvm]<br>open override val [finallyStatement](finally-statement.md): [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)<br>Finally block (Obs: for bytecode generation, finally blocks is always inlined). |
