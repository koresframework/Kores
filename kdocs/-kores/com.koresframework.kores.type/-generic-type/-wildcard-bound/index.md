//[Kores](../../../../index.md)/[com.koresframework.kores.type](../../index.md)/[GenericType](../index.md)/[WildcardBound](index.md)

# WildcardBound

[jvm]\
abstract class [WildcardBound](index.md)(**type**: [KoresType](../../-kores-type/index.md)) : [GenericType.Bound](../-bound/index.md)

Bound to wildcard.

## Constructors

| | |
|---|---|
| [WildcardBound](-wildcard-bound.md) | [jvm]<br>fun [WildcardBound](-wildcard-bound.md)(type: [KoresType](../../-kores-type/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [equals](../-bound/equals.md) | [jvm]<br>open operator override fun [equals](../-bound/equals.md)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hashCode](../-bound/hash-code.md) | [jvm]<br>open override fun [hashCode](../-bound/hash-code.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

## Properties

| Name | Summary |
|---|---|
| [sign](index.md#-1203807180%2FProperties%2F-1216412040) | [jvm]<br>abstract val [sign](index.md#-1203807180%2FProperties%2F-1216412040): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Symbol of this bound. |
| [type](index.md#-506109609%2FProperties%2F-1216412040) | [jvm]<br>val [type](index.md#-506109609%2FProperties%2F-1216412040): [KoresType](../../-kores-type/index.md) |

## Inheritors

| Name |
|---|
| [GenericType](../-extends/index.md) |
| [GenericType](../-super/index.md) |
