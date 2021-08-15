//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.base](../../index.md)/[TryStatement](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [TryStatementBase.Builder](../../-try-statement-base/-builder/index.md)<[TryStatement](../index.md), [TryStatement.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [TryStatement](../index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [body](body.md) | [jvm]<br>open override fun [body](body.md)(value: [Instructions](../../../com.github.jonathanxd.kores/-instructions/index.md)): [TryStatement.Builder](index.md)<br>See T. |
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [TryStatement](../index.md)<br>Build the object of type T. |
| [catchStatements](catch-statements.md) | [jvm]<br>open override fun [catchStatements](catch-statements.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[CatchStatement](../../-catch-statement/index.md)>): [TryStatement.Builder](index.md)<br>open fun [catchStatements](../../-try-statement-base/-builder/catch-statements.md)(vararg values: [CatchStatement](../../-catch-statement/index.md)): [TryStatement.Builder](index.md)<br>See [TryStatementBase.catchStatements](../../-try-statement-base/catch-statements.md) |
| [finallyStatement](finally-statement.md) | [jvm]<br>open override fun [finallyStatement](finally-statement.md)(value: [Instructions](../../../com.github.jonathanxd.kores/-instructions/index.md)): [TryStatement.Builder](index.md)<br>See [TryStatementBase.finallyStatement](../../-try-statement-base/finally-statement.md) |

## Properties

| Name | Summary |
|---|---|
| [body](body.md) | [jvm]<br>var [body](body.md): [Instructions](../../../com.github.jonathanxd.kores/-instructions/index.md) |
| [catchStatements](catch-statements.md) | [jvm]<br>var [catchStatements](catch-statements.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[CatchStatement](../../-catch-statement/index.md)> |
| [finallyStatement](finally-statement.md) | [jvm]<br>var [finallyStatement](finally-statement.md): [Instructions](../../../com.github.jonathanxd.kores/-instructions/index.md) |
