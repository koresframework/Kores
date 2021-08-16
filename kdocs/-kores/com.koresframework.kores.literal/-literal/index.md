//[Kores](../../../index.md)/[com.koresframework.kores.literal](../index.md)/[Literal](index.md)

# Literal

[jvm]\
abstract class [Literal](index.md) : [TypedInstruction](../../com.koresframework.kores.base/-typed-instruction/index.md), [Named](../../com.koresframework.kores.base/-named/index.md)

A JVM Literal.

Example of literals: Strings, Ints, Doubles, Longs, Types, etc.

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [Nothing](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html)<br>This builder may or may not accept null values, it depends on implementation. |
| [equals](equals.md) | [jvm]<br>open operator override fun [equals](equals.md)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hashCode](hash-code.md) | [jvm]<br>open override fun [hashCode](hash-code.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [toString](to-string.md) | [jvm]<br>open override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Properties

| Name | Summary |
|---|---|
| [name](name.md) | [jvm]<br>~~abstract~~ ~~override~~ ~~val~~ [~~name~~](name.md)~~:~~ [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Name |
| [type](type.md) | [jvm]<br>abstract override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Element type |
| [value](value.md) | [jvm]<br>open val [value](value.md): [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) |

## Inheritors

| Name |
|---|
| [Stack](../../com.koresframework.kores.common/-stack/index.md) |
| [Literals](../-literals/-null-literal/index.md) |
| [Literals](../-literals/-class-literal/index.md) |
| [Literals](../-literals/-byte-literal/index.md) |
| [Literals](../-literals/-short-literal/index.md) |
| [Literals](../-literals/-int-literal/index.md) |
| [Literals](../-literals/-bool-literal/index.md) |
| [Literals](../-literals/-long-literal/index.md) |
| [Literals](../-literals/-float-literal/index.md) |
| [Literals](../-literals/-double-literal/index.md) |
| [Literals](../-literals/-char-literal/index.md) |
| [Literals](../-literals/-string-literal/index.md) |
| [Literals](../-literals/-dynamic-constant-literal/index.md) |
