//[Kores](../../../index.md)/[com.github.jonathanxd.kores.common](../index.md)/[MethodInvokeSpec](index.md)

# MethodInvokeSpec

[jvm]\
data class [MethodInvokeSpec](index.md)(**invokeType**: [InvokeType](../../com.github.jonathanxd.kores.base/-invoke-type/index.md), **methodTypeSpec**: [MethodTypeSpec](../-method-type-spec/index.md)) : [Typed](../../com.github.jonathanxd.kores.base/-typed/index.md), [Comparable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-comparable/index.html)<[MethodInvokeSpec](index.md)>

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [Typed.Builder](../../com.github.jonathanxd.kores.base/-typed/-builder/index.md)<[MethodInvokeSpec](index.md), [MethodInvokeSpec.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [MethodInvokeSpec.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |
| [compareTo](compare-to.md) | [jvm]<br>open operator override fun [compareTo](compare-to.md)(other: [MethodInvokeSpec](index.md)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [invoke](invoke.md) | [jvm]<br>operator fun [invoke](invoke.md)(target: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)): [MethodInvocation](../../com.github.jonathanxd.kores.base/-method-invocation/index.md)<br>Invokes this method in [target](invoke.md).<br>[jvm]<br>operator fun [invoke](invoke.md)(target: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), arguments: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)>): [MethodInvocation](../../com.github.jonathanxd.kores.base/-method-invocation/index.md)<br>Invokes this method in [target](invoke.md) with [arguments](invoke.md). |
| [toInvocationString](to-invocation-string.md) | [jvm]<br>fun [toInvocationString](to-invocation-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Human readable method invocation string. |

## Properties

| Name | Summary |
|---|---|
| [invokeType](invoke-type.md) | [jvm]<br>val [invokeType](invoke-type.md): [InvokeType](../../com.github.jonathanxd.kores.base/-invoke-type/index.md) |
| [methodTypeSpec](method-type-spec.md) | [jvm]<br>val [methodTypeSpec](method-type-spec.md): [MethodTypeSpec](../-method-type-spec/index.md) |
| [type](type.md) | [jvm]<br>open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Element type |

## Extensions

| Name | Summary |
|---|---|
| [toInvocation](../../com.github.jonathanxd.kores.util.conversion/to-invocation.md) | [jvm]<br>fun [MethodInvokeSpec](index.md).[toInvocation](../../com.github.jonathanxd.kores.util.conversion/to-invocation.md)(target: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), arguments: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)>): [MethodInvocation](../../com.github.jonathanxd.kores.base/-method-invocation/index.md)<br>Create [MethodInvocation](../../com.github.jonathanxd.kores.base/-method-invocation/index.md) from [MethodInvokeSpec](index.md) |
