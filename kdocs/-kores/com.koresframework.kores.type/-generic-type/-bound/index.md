//[Kores](../../../../index.md)/[com.koresframework.kores.type](../../index.md)/[GenericType](../index.md)/[Bound](index.md)

# Bound

[jvm]\
abstract class [Bound](index.md)(**type**: [KoresType](../../-kores-type/index.md))

Generic type bounds.

## Constructors

| | |
|---|---|
| [Bound](-bound.md) | [jvm]<br>fun [Bound](-bound.md)(type: [KoresType](../../-kores-type/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [equals](equals.md) | [jvm]<br>open operator override fun [equals](equals.md)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hashCode](hash-code.md) | [jvm]<br>open override fun [hashCode](hash-code.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

## Properties

| Name | Summary |
|---|---|
| [sign](sign.md) | [jvm]<br>abstract val [sign](sign.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Symbol of this bound. |
| [type](type.md) | [jvm]<br>val [type](type.md): [KoresType](../../-kores-type/index.md) |

## Inheritors

| Name |
|---|
| [GenericType](../-wildcard-bound/index.md) |
| [GenericType](../-generic-bound/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [toComponentString](../../../com.koresframework.kores.util/to-component-string.md) | [jvm]<br>fun [GenericType.Bound](index.md).[toComponentString](../../../com.koresframework.kores.util/to-component-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Creates a string representation of components of [GenericType.Bound](index.md). |
| [toInstruction](../../../com.koresframework.kores.util.conversion/to-instruction.md) | [jvm]<br>fun [GenericType.Bound](index.md).[toInstruction](../../../com.koresframework.kores.util.conversion/to-instruction.md)(): [Instruction](../../../com.koresframework.kores/-instruction/index.md)<br>Creates [Instruction](../../../com.koresframework.kores/-instruction/index.md) from [bound representation](index.md). |
