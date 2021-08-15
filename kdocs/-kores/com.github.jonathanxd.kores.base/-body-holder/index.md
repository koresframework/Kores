//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[BodyHolder](index.md)

# BodyHolder

[jvm]\
interface [BodyHolder](index.md) : [KoresPart](../../com.github.jonathanxd.kores/-kores-part/index.md)

Holds a body. Example: method declarations, type declarations, static block, constructors...

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>interface [Builder](-builder/index.md)<out [T](-builder/index.md) : [BodyHolder](index.md), [S](-builder/index.md) : [BodyHolder.Builder](-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>> : [Builder](../../com.github.jonathanxd.kores.builder/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> |
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>abstract override fun [builder](builder.md)(): [BodyHolder.Builder](-builder/index.md)<[BodyHolder](index.md), *><br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [body](body.md) | [jvm]<br>abstract val [body](body.md): [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)<br>Body. |

## Inheritors

| Name |
|---|
| [Case](../-case/index.md) |
| [CatchStatement](../-catch-statement/index.md) |
| [ForEachStatement](../-for-each-statement/index.md) |
| [ForStatement](../-for-statement/index.md) |
| [IfStatement](../-if-statement/index.md) |
| [Label](../-label/index.md) |
| [MethodDeclarationBase](../-method-declaration-base/index.md) |
| [Synchronized](../-synchronized/index.md) |
| [TryStatementBase](../-try-statement-base/index.md) |
| [WhileStatement](../-while-statement/index.md) |
