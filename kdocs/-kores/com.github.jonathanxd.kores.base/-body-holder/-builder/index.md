//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.base](../../index.md)/[BodyHolder](../index.md)/[Builder](index.md)

# Builder

[jvm]\
interface [Builder](index.md)<out [T](index.md) : [BodyHolder](../index.md), [S](index.md) : [BodyHolder.Builder](index.md)<[T](index.md), [S](index.md)>> : [Builder](../../../com.github.jonathanxd.kores.builder/-builder/index.md)<[T](index.md), [S](index.md)>

## Functions

| Name | Summary |
|---|---|
| [body](body.md) | [jvm]<br>abstract fun [body](body.md)(value: [Instructions](../../../com.github.jonathanxd.kores/-instructions/index.md)): [S](index.md)<br>See T. |
| [build](../../../com.github.jonathanxd.kores.builder/-builder/build.md) | [jvm]<br>abstract fun [build](../../../com.github.jonathanxd.kores.builder/-builder/build.md)(): [T](index.md)<br>Build the object of type [T](../../../com.github.jonathanxd.kores.builder/-builder/index.md). |

## Inheritors

| Name |
|---|
| [Case](../../-case/-builder/index.md) |
| [CatchStatement](../../-catch-statement/-builder/index.md) |
| [ForEachStatement](../../-for-each-statement/-builder/index.md) |
| [ForStatement](../../-for-statement/-builder/index.md) |
| [IfStatement](../../-if-statement/-builder/index.md) |
| [Label](../../-label/-builder/index.md) |
| [MethodDeclarationBase](../../-method-declaration-base/-builder/index.md) |
| [Synchronized](../../-synchronized/-builder/index.md) |
| [TryStatementBase](../../-try-statement-base/-builder/index.md) |
| [WhileStatement](../../-while-statement/-builder/index.md) |
