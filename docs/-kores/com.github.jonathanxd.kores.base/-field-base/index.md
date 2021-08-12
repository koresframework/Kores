//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[FieldBase](index.md)

# FieldBase

[jvm]\
interface [FieldBase](index.md) : [Named](../-named/index.md), [Typed](../-typed/index.md)

Base field (access and definition common class)

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>interface [Builder](-builder/index.md)<out [T](-builder/index.md) : [FieldBase](index.md), [S](-builder/index.md) : [FieldBase.Builder](-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>> : [Named.Builder](../-named/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> , [Typed.Builder](../-typed/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [access](access.md) | [jvm]<br>open fun [access](access.md)(): [FieldAccess](../-field-access/index.md)<br>Creates access to the field that this instance represents. |
| [builder](builder.md) | [jvm]<br>abstract override fun [builder](builder.md)(): [FieldBase.Builder](-builder/index.md)<[FieldBase](index.md), *><br>This builder may or may not accept null values, it depends on implementation. |
| [set](set.md) | [jvm]<br>open fun [set](set.md)(value: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)): [FieldDefinition](../-field-definition/index.md)<br>Creates a definition of the value of the field that this instance represents. |

## Properties

| Name | Summary |
|---|---|
| [localization](localization.md) | [jvm]<br>abstract val [localization](localization.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Field localization. |
| [name](index.md#-1974448627%2FProperties%2F-1216412040) | [jvm]<br>abstract val [name](index.md#-1974448627%2FProperties%2F-1216412040): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Name |
| [target](target.md) | [jvm]<br>abstract val [target](target.md): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)<br>Target of the access |
| [type](type.md) | [jvm]<br>abstract override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Element type |

## Inheritors

| Name |
|---|
| [FieldDeclaration](../-field-declaration/index.md) |
| [FieldDefinition](../-field-definition/index.md) |
| [FieldRef](../../com.github.jonathanxd.kores.common/-field-ref/index.md) |
