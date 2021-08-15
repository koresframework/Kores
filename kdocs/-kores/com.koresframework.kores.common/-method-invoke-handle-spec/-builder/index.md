//[Kores](../../../../index.md)/[com.koresframework.kores.common](../../index.md)/[MethodInvokeHandleSpec](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [Typed.Builder](../../../com.koresframework.kores.base/-typed/-builder/index.md)<[MethodInvokeHandleSpec](../index.md), [MethodInvokeHandleSpec.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [MethodInvokeHandleSpec](../index.md)) |

## Functions

| Name | Summary |
|---|---|
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [MethodInvokeHandleSpec](../index.md)<br>Build the object of type T. |
| [invokeType](invoke-type.md) | [jvm]<br>fun [invokeType](invoke-type.md)(value: [DynamicInvokeType](../../../com.koresframework.kores.base/-dynamic-invoke-type/index.md)): [MethodInvokeHandleSpec.Builder](index.md)<br>fun [invokeType](invoke-type.md)(value: [InvokeType](../../../com.koresframework.kores.base/-invoke-type/index.md)): [MethodInvokeHandleSpec.Builder](index.md) |
| [methodTypeSpec](method-type-spec.md) | [jvm]<br>fun [methodTypeSpec](method-type-spec.md)(value: [MethodTypeSpec](../../-method-type-spec/index.md)): [MethodInvokeHandleSpec.Builder](index.md) |
| [type](type.md) | [jvm]<br>open override fun [type](type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [MethodInvokeHandleSpec.Builder](index.md)<br>See T. |
| [withInvokeType](with-invoke-type.md) | [jvm]<br>fun [withInvokeType](with-invoke-type.md)(value: [DynamicInvokeType](../../../com.koresframework.kores.base/-dynamic-invoke-type/index.md)): [MethodInvokeHandleSpec.Builder](index.md)<br>fun [withInvokeType](with-invoke-type.md)(value: [InvokeType](../../../com.koresframework.kores.base/-invoke-type/index.md)): [MethodInvokeHandleSpec.Builder](index.md) |
| [withMethodTypeSpec](with-method-type-spec.md) | [jvm]<br>fun [withMethodTypeSpec](with-method-type-spec.md)(value: [MethodTypeSpec](../../-method-type-spec/index.md)): [MethodInvokeHandleSpec.Builder](index.md) |

## Properties

| Name | Summary |
|---|---|
| [invokeType](invoke-type.md) | [jvm]<br>lateinit var [invokeType](invoke-type.md): [DynamicInvokeType](../../../com.koresframework.kores.base/-dynamic-invoke-type/index.md) |
| [methodTypeSpec](method-type-spec.md) | [jvm]<br>lateinit var [methodTypeSpec](method-type-spec.md): [MethodTypeSpec](../../-method-type-spec/index.md) |
