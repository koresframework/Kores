//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.common](../../index.md)/[MethodInvokeSpec](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [Typed.Builder](../../../com.github.jonathanxd.kores.base/-typed/-builder/index.md)<[MethodInvokeSpec](../index.md), [MethodInvokeSpec.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [MethodInvokeSpec](../index.md)) |

## Functions

| Name | Summary |
|---|---|
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [MethodInvokeSpec](../index.md)<br>Build the object of type T. |
| [type](type.md) | [jvm]<br>open override fun [type](type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [MethodInvokeSpec.Builder](index.md)<br>See T. |
| [withInvokeType](with-invoke-type.md) | [jvm]<br>fun [withInvokeType](with-invoke-type.md)(value: [InvokeType](../../../com.github.jonathanxd.kores.base/-invoke-type/index.md)): [MethodInvokeSpec.Builder](index.md) |
| [withMethodTypeSpec](with-method-type-spec.md) | [jvm]<br>fun [withMethodTypeSpec](with-method-type-spec.md)(value: [MethodTypeSpec](../../-method-type-spec/index.md)): [MethodInvokeSpec.Builder](index.md) |

## Properties

| Name | Summary |
|---|---|
| [invokeType](invoke-type.md) | [jvm]<br>lateinit var [invokeType](invoke-type.md): [InvokeType](../../../com.github.jonathanxd.kores.base/-invoke-type/index.md) |
| [methodTypeSpec](method-type-spec.md) | [jvm]<br>lateinit var [methodTypeSpec](method-type-spec.md): [MethodTypeSpec](../../-method-type-spec/index.md) |
