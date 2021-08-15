//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[ConstructorsHolder](index.md)

# ConstructorsHolder

[jvm]\
interface [ConstructorsHolder](index.md) : [KoresPart](../../com.github.jonathanxd.kores/-kores-part/index.md)

Same as [ElementsHolder](../-elements-holder/index.md) but holds constructors.

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>interface [Builder](-builder/index.md)<out [T](-builder/index.md) : [ConstructorsHolder](index.md), [S](-builder/index.md) : [ConstructorsHolder.Builder](-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>> : [Builder](../../com.github.jonathanxd.kores.builder/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>abstract override fun [builder](builder.md)(): [ConstructorsHolder.Builder](-builder/index.md)<[ConstructorsHolder](index.md), *><br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [constructors](constructors.md) | [jvm]<br>abstract val [constructors](constructors.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[ConstructorDeclaration](../-constructor-declaration/index.md)><br>Constructor declarations |

## Inheritors

| Name |
|---|
| [AnonymousClass](../-anonymous-class/index.md) |
| [ClassDeclaration](../-class-declaration/index.md) |
| [EnumDeclaration](../-enum-declaration/index.md) |
