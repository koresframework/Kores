//[Kores](../../../../index.md)/[com.koresframework.kores.base](../../index.md)/[EnumValue](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [Named.Builder](../../-named/-builder/index.md)<[EnumValue](../index.md), [EnumValue.Builder](index.md)> , [Typed.Builder](../../-typed/-builder/index.md)<[EnumValue](../index.md), [EnumValue.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [EnumValue](../index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [base](base.md) | [jvm]<br>fun [base](base.md)(enum: [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)<*>): [EnumValue.Builder](index.md)<br>Base this EnumValue on an [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html). |
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [EnumValue](../index.md)<br>Build the object of type T. |
| [enumEntry](enum-entry.md) | [jvm]<br>fun [enumEntry](enum-entry.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [EnumValue.Builder](index.md)<br>See [EnumValue.enumEntry](../enum-entry.md) |
| [enumType](enum-type.md) | [jvm]<br>fun [enumType](enum-type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [EnumValue.Builder](index.md)<br>See [EnumValue.enumType](../enum-type.md) |
| [name](name.md) | [jvm]<br>open override fun [name](name.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [EnumValue.Builder](index.md) |
| [type](type.md) | [jvm]<br>open override fun [type](type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [EnumValue.Builder](index.md)<br>See T. |

## Properties

| Name | Summary |
|---|---|
| [enumEntry](enum-entry.md) | [jvm]<br>lateinit var [enumEntry](enum-entry.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [enumType](enum-type.md) | [jvm]<br>lateinit var [enumType](enum-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) |
