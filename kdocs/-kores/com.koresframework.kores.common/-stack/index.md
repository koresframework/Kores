//[Kores](../../../index.md)/[com.koresframework.kores.common](../index.md)/[Stack](index.md)

# Stack

[jvm]\
object [Stack](index.md) : [Literal](../../com.koresframework.kores.literal/-literal/index.md)

Use JVM Stack value (is supported by BytecodeGenerators).

## Functions

| Name | Summary |
|---|---|
| [builder](../../com.koresframework.kores.literal/-literal/builder.md) | [jvm]<br>open override fun [builder](../../com.koresframework.kores.literal/-literal/builder.md)(): [Nothing](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html)<br>This builder may or may not accept null values, it depends on implementation. |
| [equals](../../com.koresframework.kores.literal/-literal/equals.md) | [jvm]<br>open operator override fun [equals](../../com.koresframework.kores.literal/-literal/equals.md)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hashCode](../../com.koresframework.kores.literal/-literal/hash-code.md) | [jvm]<br>open override fun [hashCode](../../com.koresframework.kores.literal/-literal/hash-code.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [toString](../../com.koresframework.kores.literal/-literal/to-string.md) | [jvm]<br>open override fun [toString](../../com.koresframework.kores.literal/-literal/to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Properties

| Name | Summary |
|---|---|
| [name](name.md) | [jvm]<br>open override val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Name |
| [type](type.md) | [jvm]<br>open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Element type |
| [value](index.md#-1781100538%2FProperties%2F-1216412040) | [jvm]<br>open val [value](index.md#-1781100538%2FProperties%2F-1216412040): [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) |
