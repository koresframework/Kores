//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[Annotation](index.md)

# Annotation

[jvm]\
data class [Annotation](index.md)(**type**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), **values**: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)<[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>, **retention**: [Retention](../-retention/index.md)) : [Typed](../-typed/index.md)

An annotation, an annotation is composed by a pair of property name and property value.

#  In Java

[type](type.md) is the annotation type and [values](values.md) are the pairs that denote annotation properties and their respective values.

Example:

Annotation(Override, emptyMap(), false) is equal to @OverrideAnnotation(Named, mapOf("value" to "Wow"), true) is equal to @Named("Wow")Annotation(Wow, mapOf("a" to 9, "b" to 7), true) is equal to @Wow(a = 9, b = 7)

The [retention](retention.md) is determined by the compiler, which inspects [type](type.md) and reads [Retention](../-retention/index.md) annotation, but here it need to be explicitly specified (you can also use [Retention.resolveRetention](../-retention/-companion/resolve-retention.md) to try to resolve the retention of [type](type.md)).

## Constructors

| | |
|---|---|
| [Annotation](-annotation.md) | [jvm]<br>fun [Annotation](-annotation.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), values: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)<[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>, retention: [Retention](../-retention/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [Typed.Builder](../-typed/-builder/index.md)<[Annotation](index.md), [Annotation.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [Annotation.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [retention](retention.md) | [jvm]<br>val [retention](retention.md): [Retention](../-retention/index.md)<br>Annotation retention, this property must match the same retention of annotation [type](type.md). |
| [type](type.md) | [jvm]<br>open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Type of annotation. |
| [values](values.md) | [jvm]<br>val [values](values.md): [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)<[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)><br>Map of annotation values (key is the property of annotation), the Annotation value must be: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html), [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), [Char](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html), [Short](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short/index.html), [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html), [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), [EnumValue](../-enum-value/index.md), other [Annotation](index.md) or a List of one of types cited above (with or without elements). |
