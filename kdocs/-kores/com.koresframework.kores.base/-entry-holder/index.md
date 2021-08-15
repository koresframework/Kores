//[Kores](../../../index.md)/[com.koresframework.kores.base](../index.md)/[EntryHolder](index.md)

# EntryHolder

[jvm]\
interface [EntryHolder](index.md) : [KoresPart](../../com.koresframework.kores/-kores-part/index.md)

Enum entry holder

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>interface [Builder](-builder/index.md)<out [T](-builder/index.md) : [EntryHolder](index.md), [S](-builder/index.md) : [EntryHolder.Builder](-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>> : [Builder](../../com.koresframework.kores.builder/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>abstract override fun [builder](builder.md)(): [EntryHolder.Builder](-builder/index.md)<[EntryHolder](index.md), *><br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [entries](entries.md) | [jvm]<br>abstract val [entries](entries.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[EnumEntry](../-enum-entry/index.md)><br>Enum entries. |

## Inheritors

| Name |
|---|
| [EnumDeclaration](../-enum-declaration/index.md) |
