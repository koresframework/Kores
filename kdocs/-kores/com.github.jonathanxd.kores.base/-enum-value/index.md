//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[EnumValue](index.md)

# EnumValue

[jvm]\
data class [EnumValue](index.md)(**enumType**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), **enumEntry**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [Named](../-named/index.md), [TypedInstruction](../-typed-instruction/index.md)

Enum value.

## Constructors

| | |
|---|---|
| [EnumValue](-enum-value.md) | [jvm]<br>fun [EnumValue](-enum-value.md)(enumType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), enumEntry: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [Named.Builder](../-named/-builder/index.md)<[EnumValue](index.md), [EnumValue.Builder](-builder/index.md)> , [Typed.Builder](../-typed/-builder/index.md)<[EnumValue](index.md), [EnumValue.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [EnumValue.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [enumEntry](enum-entry.md) | [jvm]<br>val [enumEntry](enum-entry.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Entry of enum. |
| [enumType](enum-type.md) | [jvm]<br>val [enumType](enum-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Type of enum |
| [name](name.md) | [jvm]<br>open override val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Name |
| [type](type.md) | [jvm]<br>open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Element type |
