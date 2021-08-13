//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.common](../../index.md)/[FieldAccessHandleSpec](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [Typed.Builder](../../../com.github.jonathanxd.kores.base/-typed/-builder/index.md)<[FieldAccessHandleSpec](../index.md), [FieldAccessHandleSpec.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [FieldAccessHandleSpec](../index.md)) |

## Functions

| Name | Summary |
|---|---|
| [accessKind](access-kind.md) | [jvm]<br>fun [accessKind](access-kind.md)(value: [FieldAccessKind](../../../com.github.jonathanxd.kores.base/-field-access-kind/index.md)): [FieldAccessHandleSpec.Builder](index.md) |
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [FieldAccessHandleSpec](../index.md)<br>Build the object of type T. |
| [fieldTypeSpec](field-type-spec.md) | [jvm]<br>fun [fieldTypeSpec](field-type-spec.md)(value: [FieldTypeSpec](../../-field-type-spec/index.md)): [FieldAccessHandleSpec.Builder](index.md) |
| [type](type.md) | [jvm]<br>open override fun [type](type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [FieldAccessHandleSpec.Builder](index.md)<br>See T. |
| [withAccessKind](with-access-kind.md) | [jvm]<br>fun [withAccessKind](with-access-kind.md)(value: [FieldAccessKind](../../../com.github.jonathanxd.kores.base/-field-access-kind/index.md)): [FieldAccessHandleSpec.Builder](index.md) |
| [withFieldTypeSpec](with-field-type-spec.md) | [jvm]<br>fun [withFieldTypeSpec](with-field-type-spec.md)(value: [FieldTypeSpec](../../-field-type-spec/index.md)): [FieldAccessHandleSpec.Builder](index.md) |

## Properties

| Name | Summary |
|---|---|
| [accessKind](access-kind.md) | [jvm]<br>lateinit var [accessKind](access-kind.md): [FieldAccessKind](../../../com.github.jonathanxd.kores.base/-field-access-kind/index.md) |
| [fieldTypeSpec](field-type-spec.md) | [jvm]<br>lateinit var [fieldTypeSpec](field-type-spec.md): [FieldTypeSpec](../../-field-type-spec/index.md) |
