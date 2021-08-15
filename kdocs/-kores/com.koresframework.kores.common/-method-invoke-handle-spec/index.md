//[Kores](../../../index.md)/[com.koresframework.kores.common](../index.md)/[MethodInvokeHandleSpec](index.md)

# MethodInvokeHandleSpec

[jvm]\
data class [MethodInvokeHandleSpec](index.md)(**invokeType**: [DynamicInvokeType](../../com.koresframework.kores.base/-dynamic-invoke-type/index.md), **methodTypeSpec**: [MethodTypeSpec](../-method-type-spec/index.md)) : [Typed](../../com.koresframework.kores.base/-typed/index.md), [Comparable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-comparable/index.html)<[MethodInvokeHandleSpec](index.md)> 

Specify a method invocation in [InvokeDynamicBase.bootstrapArgs](../../com.koresframework.kores.base/-invoke-dynamic-base/bootstrap-args.md). This is a richer version of [MethodInvokeSpec](../-method-invoke-spec/index.md) only used in [invokedynamic](../../com.koresframework.kores.base/-invoke-dynamic-base/index.md).

## Constructors

| | |
|---|---|
| [MethodInvokeHandleSpec](-method-invoke-handle-spec.md) | [jvm]<br>fun [MethodInvokeHandleSpec](-method-invoke-handle-spec.md)(invokeType: [DynamicInvokeType](../../com.koresframework.kores.base/-dynamic-invoke-type/index.md), methodTypeSpec: [MethodTypeSpec](../-method-type-spec/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [Typed.Builder](../../com.koresframework.kores.base/-typed/-builder/index.md)<[MethodInvokeHandleSpec](index.md), [MethodInvokeHandleSpec.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [MethodInvokeHandleSpec.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |
| [compareTo](compare-to.md) | [jvm]<br>open operator override fun [compareTo](compare-to.md)(other: [MethodInvokeHandleSpec](index.md)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [invoke](invoke.md) | [jvm]<br>operator fun [invoke](invoke.md)(target: [Instruction](../../com.koresframework.kores/-instruction/index.md)): [MethodInvocation](../../com.koresframework.kores.base/-method-invocation/index.md)<br>Invokes this method in [target](invoke.md).<br>[jvm]<br>operator fun [invoke](invoke.md)(target: [Instruction](../../com.koresframework.kores/-instruction/index.md), arguments: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.koresframework.kores/-instruction/index.md)>): [MethodInvocation](../../com.koresframework.kores.base/-method-invocation/index.md)<br>Invokes this method in [target](invoke.md) with [arguments](invoke.md). |
| [toInvocationString](to-invocation-string.md) | [jvm]<br>fun [toInvocationString](to-invocation-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Human-readable method invocation string. |

## Properties

| Name | Summary |
|---|---|
| [invokeType](invoke-type.md) | [jvm]<br>val [invokeType](invoke-type.md): [DynamicInvokeType](../../com.koresframework.kores.base/-dynamic-invoke-type/index.md) |
| [methodTypeSpec](method-type-spec.md) | [jvm]<br>val [methodTypeSpec](method-type-spec.md): [MethodTypeSpec](../-method-type-spec/index.md) |
| [type](type.md) | [jvm]<br>open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Element type |
