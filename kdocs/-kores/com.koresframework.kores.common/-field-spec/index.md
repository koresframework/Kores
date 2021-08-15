//[Kores](../../../index.md)/[com.koresframework.kores.common](../index.md)/[FieldSpec](index.md)

# FieldSpec

[jvm]\
data class [FieldSpec](index.md)(**fieldName**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **fieldType**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)) : [Typed](../../com.koresframework.kores.base/-typed/index.md), [Comparable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-comparable/index.html)<[FieldSpec](index.md)> 

Specification of a field for [InvokeDynamicBase.bootstrapArgs](../../com.koresframework.kores.base/-invoke-dynamic-base/bootstrap-args.md).

## Constructors

| | |
|---|---|
| [FieldSpec](-field-spec.md) | [jvm]<br>fun [FieldSpec](-field-spec.md)(fieldName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), fieldType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [Typed.Builder](../../com.koresframework.kores.base/-typed/-builder/index.md)<[FieldSpec](index.md), [FieldSpec.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [FieldSpec.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |
| [compareTo](compare-to.md) | [jvm]<br>open operator override fun [compareTo](compare-to.md)(other: [FieldSpec](index.md)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>This method will not compare the method localization. |
| [toFieldString](to-field-string.md) | [jvm]<br>fun [toFieldString](to-field-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Human-readable method specification string. |
| [toFieldTypeSpec](to-field-type-spec.md) | [jvm]<br>fun [toFieldTypeSpec](to-field-type-spec.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [FieldTypeSpec](../-field-type-spec/index.md)<br>Converts this [FieldSpec](index.md) to [MethodTypeSpec](../-method-type-spec/index.md) |

## Properties

| Name | Summary |
|---|---|
| [fieldName](field-name.md) | [jvm]<br>val [fieldName](field-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [fieldType](field-type.md) | [jvm]<br>val [fieldType](field-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) |
| [type](type.md) | [jvm]<br>open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Element type |
