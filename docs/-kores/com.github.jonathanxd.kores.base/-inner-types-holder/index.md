//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[InnerTypesHolder](index.md)

# InnerTypesHolder

[jvm]\
interface [InnerTypesHolder](index.md) : [KoresPart](../../com.github.jonathanxd.kores/-kores-part/index.md)

A holder of inner types

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>interface [Builder](-builder/index.md)<out [T](-builder/index.md) : [InnerTypesHolder](index.md), [S](-builder/index.md) : [InnerTypesHolder.Builder](-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>> : [Builder](../../com.github.jonathanxd.kores.builder/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>abstract override fun [builder](builder.md)(): [InnerTypesHolder.Builder](-builder/index.md)<[InnerTypesHolder](index.md), *><br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [innerTypes](inner-types.md) | [jvm]<br>abstract val [innerTypes](inner-types.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[TypeDeclaration](../-type-declaration/index.md)><br>Inner types |

## Inheritors

| Name |
|---|
| [ElementsHolder](../-elements-holder/index.md) |
| [FieldDeclaration](../-field-declaration/index.md) |
| [LocalCode](../-local-code/index.md) |
| [MethodDeclarationBase](../-method-declaration-base/index.md) |
| [TypeDeclaration](../-type-declaration/index.md) |
