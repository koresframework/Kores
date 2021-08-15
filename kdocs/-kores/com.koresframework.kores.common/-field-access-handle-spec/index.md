//[Kores](../../../index.md)/[com.koresframework.kores.common](../index.md)/[FieldAccessHandleSpec](index.md)

# FieldAccessHandleSpec

[jvm]\
data class [FieldAccessHandleSpec](index.md)(**accessKind**: [FieldAccessKind](../../com.koresframework.kores.base/-field-access-kind/index.md), **fieldTypeSpec**: [FieldTypeSpec](../-field-type-spec/index.md)) : [Typed](../../com.koresframework.kores.base/-typed/index.md), [Comparable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-comparable/index.html)<[FieldAccessHandleSpec](index.md)> 

Specify a field access or definition in [InvokeDynamicBase.bootstrapArgs](../../com.koresframework.kores.base/-invoke-dynamic-base/bootstrap-args.md).

## Constructors

| | |
|---|---|
| [FieldAccessHandleSpec](-field-access-handle-spec.md) | [jvm]<br>fun [FieldAccessHandleSpec](-field-access-handle-spec.md)(accessKind: [FieldAccessKind](../../com.koresframework.kores.base/-field-access-kind/index.md), fieldTypeSpec: [FieldTypeSpec](../-field-type-spec/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [Typed.Builder](../../com.koresframework.kores.base/-typed/-builder/index.md)<[FieldAccessHandleSpec](index.md), [FieldAccessHandleSpec.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [FieldAccessHandleSpec.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |
| [compareTo](compare-to.md) | [jvm]<br>open operator override fun [compareTo](compare-to.md)(other: [FieldAccessHandleSpec](index.md)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [toInvocationString](to-invocation-string.md) | [jvm]<br>fun [toInvocationString](to-invocation-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Human-readable method invocation string. |

## Properties

| Name | Summary |
|---|---|
| [accessKind](access-kind.md) | [jvm]<br>val [accessKind](access-kind.md): [FieldAccessKind](../../com.koresframework.kores.base/-field-access-kind/index.md) |
| [fieldTypeSpec](field-type-spec.md) | [jvm]<br>val [fieldTypeSpec](field-type-spec.md): [FieldTypeSpec](../-field-type-spec/index.md) |
| [type](type.md) | [jvm]<br>open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Element type |
