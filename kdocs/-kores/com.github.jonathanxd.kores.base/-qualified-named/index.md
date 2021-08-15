//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[QualifiedNamed](index.md)

# QualifiedNamed

[jvm]\
interface [QualifiedNamed](index.md) : [Named](../-named/index.md)

A part that have a qualified name.

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>interface [Builder](-builder/index.md)<out [T](-builder/index.md) : [QualifiedNamed](index.md), [S](-builder/index.md) : [QualifiedNamed.Builder](-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>> : [Named.Builder](../-named/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>abstract override fun [builder](builder.md)(): [QualifiedNamed.Builder](-builder/index.md)<[QualifiedNamed](index.md), *><br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [name](name.md) | [jvm]<br>open override val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Name |
| [qualifiedName](qualified-name.md) | [jvm]<br>abstract val [qualifiedName](qualified-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The qualified name |

## Inheritors

| Name |
|---|
| [TypeDeclaration](../-type-declaration/index.md) |
