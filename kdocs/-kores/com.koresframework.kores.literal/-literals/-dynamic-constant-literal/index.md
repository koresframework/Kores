//[Kores](../../../../index.md)/[com.koresframework.kores.literal](../../index.md)/[Literals](../index.md)/[DynamicConstantLiteral](index.md)

# DynamicConstantLiteral

[jvm]\
class [DynamicConstantLiteral](index.md) : [Literal](../../-literal/index.md)

## Functions

| Name | Summary |
|---|---|
| [builder](../../-literal/builder.md) | [jvm]<br>open override fun [builder](../../-literal/builder.md)(): [Nothing](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html)<br>This builder may or may not accept null values, it depends on implementation. |
| [equals](../../-literal/equals.md) | [jvm]<br>open operator override fun [equals](../../-literal/equals.md)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hashCode](../../-literal/hash-code.md) | [jvm]<br>open override fun [hashCode](../../-literal/hash-code.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [toString](../../-literal/to-string.md) | [jvm]<br>open override fun [toString](../../-literal/to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Properties

| Name | Summary |
|---|---|
| [name](name.md) | [jvm]<br>open override val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Name |
| [spec](spec.md) | [jvm]<br>val [spec](spec.md): [DynamicConstantSpec](../../../com.koresframework.kores.common/-dynamic-constant-spec/index.md) |
| [type](type.md) | [jvm]<br>open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Element type |
| [value](index.md#-1425902474%2FProperties%2F-1216412040) | [jvm]<br>open val [value](index.md#-1425902474%2FProperties%2F-1216412040): [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) |
