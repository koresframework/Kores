//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.common](../../index.md)/[FieldSpec](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [Typed.Builder](../../../com.github.jonathanxd.kores.base/-typed/-builder/index.md)<[FieldSpec](../index.md), [FieldSpec.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [FieldSpec](../index.md)) |

## Functions

| Name | Summary |
|---|---|
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [FieldSpec](../index.md)<br>Build the object of type T. |
| [fieldName](field-name.md) | [jvm]<br>fun [fieldName](field-name.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [FieldSpec.Builder](index.md) |
| [type](type.md) | [jvm]<br>open override fun [type](type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [FieldSpec.Builder](index.md)<br>See T. |
| [withFieldName](with-field-name.md) | [jvm]<br>fun [withFieldName](with-field-name.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [FieldSpec.Builder](index.md) |
| [withFieldType](with-field-type.md) | [jvm]<br>fun [withFieldType](with-field-type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [FieldSpec.Builder](index.md) |

## Properties

| Name | Summary |
|---|---|
| [fieldName](field-name.md) | [jvm]<br>lateinit var [fieldName](field-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [fieldType](field-type.md) | [jvm]<br>lateinit var [fieldType](field-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) |
