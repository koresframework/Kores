//[Kores](../../../index.md)/[com.github.jonathanxd.kores.common](../index.md)/[FieldTypeSpec](index.md)

# FieldTypeSpec

[jvm]\
data class [FieldTypeSpec](index.md)(**localization**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), **fieldSpec**: [FieldSpec](../-field-spec/index.md)) : [Typed](../../com.github.jonathanxd.kores.base/-typed/index.md), [Comparable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-comparable/index.html)<[FieldTypeSpec](index.md)>

## Constructors

| | |
|---|---|
| [FieldTypeSpec](-field-type-spec.md) | [jvm]<br>fun [FieldTypeSpec](-field-type-spec.md)(localization: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), fieldName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), fieldType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [Typed.Builder](../../com.github.jonathanxd.kores.base/-typed/-builder/index.md)<[FieldTypeSpec](index.md), [FieldTypeSpec.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [FieldTypeSpec.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |
| [compareTo](compare-to.md) | [jvm]<br>open operator override fun [compareTo](compare-to.md)(other: [FieldTypeSpec](index.md)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>This method will not compare the method localization. |
| [copy](copy.md) | [jvm]<br>fun [copy](copy.md)(localization: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) = this.localization, fieldName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = this.fieldName, fieldType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) = this.fieldType): [FieldTypeSpec](index.md) |
| [toFieldString](to-field-string.md) | [jvm]<br>fun [toFieldString](to-field-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Human-readable method specification string. |

## Properties

| Name | Summary |
|---|---|
| [fieldName](field-name.md) | [jvm]<br>val [fieldName](field-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [fieldSpec](field-spec.md) | [jvm]<br>val [fieldSpec](field-spec.md): [FieldSpec](../-field-spec/index.md) |
| [fieldType](field-type.md) | [jvm]<br>val [fieldType](field-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) |
| [localization](localization.md) | [jvm]<br>val [localization](localization.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) |
| [type](type.md) | [jvm]<br>open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Element type |
