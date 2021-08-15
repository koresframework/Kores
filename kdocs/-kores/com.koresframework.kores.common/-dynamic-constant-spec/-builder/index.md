//[Kores](../../../../index.md)/[com.koresframework.kores.common](../../index.md)/[DynamicConstantSpec](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [Typed.Builder](../../../com.koresframework.kores.base/-typed/-builder/index.md)<[DynamicConstantSpec](../index.md), [DynamicConstantSpec.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [DynamicConstantSpec](../index.md)) |

## Functions

| Name | Summary |
|---|---|
| [bootstrapArgs](bootstrap-args.md) | [jvm]<br>fun [bootstrapArgs](bootstrap-args.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>): [DynamicConstantSpec.Builder](index.md) |
| [bootstrapMethod](bootstrap-method.md) | [jvm]<br>fun [bootstrapMethod](bootstrap-method.md)(value: [MethodInvokeHandleSpec](../../-method-invoke-handle-spec/index.md)): [DynamicConstantSpec.Builder](index.md) |
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [DynamicConstantSpec](../index.md)<br>Build the object of type T. |
| [constantName](constant-name.md) | [jvm]<br>fun [constantName](constant-name.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [DynamicConstantSpec.Builder](index.md) |
| [descriptor](descriptor.md) | [jvm]<br>fun [descriptor](descriptor.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [DynamicConstantSpec.Builder](index.md) |
| [type](type.md) | [jvm]<br>open override fun [type](type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [DynamicConstantSpec.Builder](index.md)<br>See T. |

## Properties

| Name | Summary |
|---|---|
| [bootstrapArgs](bootstrap-args.md) | [jvm]<br>lateinit var [bootstrapArgs](bootstrap-args.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> |
| [bootstrapMethod](bootstrap-method.md) | [jvm]<br>lateinit var [bootstrapMethod](bootstrap-method.md): [MethodInvokeHandleSpec](../../-method-invoke-handle-spec/index.md) |
| [constantName](constant-name.md) | [jvm]<br>lateinit var [constantName](constant-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [descriptor](descriptor.md) | [jvm]<br>lateinit var [descriptor](descriptor.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) |
