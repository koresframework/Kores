//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.base](../../index.md)/[TryStatementBase](../index.md)/[Builder](index.md)

# Builder

[jvm]\
interface [Builder](index.md)<out [T](index.md) : [TryStatementBase](../index.md), [S](index.md) : [TryStatementBase.Builder](index.md)<[T](index.md), [S](index.md)>> : [BodyHolder.Builder](../../-body-holder/-builder/index.md)<[T](index.md), [S](index.md)>

## Functions

| Name | Summary |
|---|---|
| [body](../../-body-holder/-builder/body.md) | [jvm]<br>abstract fun [body](../../-body-holder/-builder/body.md)(value: [Instructions](../../../com.github.jonathanxd.kores/-instructions/index.md)): [S](index.md)<br>See T. |
| [build](../../../com.github.jonathanxd.kores.builder/-builder/build.md) | [jvm]<br>abstract fun [build](../../../com.github.jonathanxd.kores.builder/-builder/build.md)(): [T](index.md)<br>Build the object of type [T](../../../com.github.jonathanxd.kores.builder/-builder/index.md). |
| [catchStatements](catch-statements.md) | [jvm]<br>open fun [catchStatements](catch-statements.md)(vararg values: [CatchStatement](../../-catch-statement/index.md)): [S](index.md)<br>abstract fun [catchStatements](catch-statements.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[CatchStatement](../../-catch-statement/index.md)>): [S](index.md)<br>See [TryStatementBase.catchStatements](../catch-statements.md) |
| [finallyStatement](finally-statement.md) | [jvm]<br>abstract fun [finallyStatement](finally-statement.md)(value: [Instructions](../../../com.github.jonathanxd.kores/-instructions/index.md)): [S](index.md)<br>See [TryStatementBase.finallyStatement](../finally-statement.md) |

## Inheritors

| Name |
|---|
| [TryStatement](../../-try-statement/-builder/index.md) |
| [TryWithResources](../../-try-with-resources/-builder/index.md) |
