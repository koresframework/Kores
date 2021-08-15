//[Kores](../../../index.md)/[com.koresframework.kores.common](../index.md)/[DynamicMethodSpec](index.md)

# DynamicMethodSpec

[jvm]\
data class [DynamicMethodSpec](index.md)(**name**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **typeSpec**: [TypeSpec](../../com.koresframework.kores.base/-type-spec/index.md), **arguments**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.koresframework.kores/-instruction/index.md)>) : [Typed](../../com.koresframework.kores.base/-typed/index.md), [Named](../../com.koresframework.kores.base/-named/index.md), [ArgumentsHolder](../../com.koresframework.kores.base/-arguments-holder/index.md)

This class specifies a dynamic method to invoke.

Read more at [InvokeDynamicBase](../../com.koresframework.kores.base/-invoke-dynamic-base/index.md).

## See also

jvm

| | |
|---|---|
| [com.koresframework.kores.base.InvokeDynamicBase](../../com.koresframework.kores.base/-invoke-dynamic-base/index.md) |  |

## Constructors

| | |
|---|---|
| [DynamicMethodSpec](-dynamic-method-spec.md) | [jvm]<br>fun [DynamicMethodSpec](-dynamic-method-spec.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), typeSpec: [TypeSpec](../../com.koresframework.kores.base/-type-spec/index.md), arguments: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.koresframework.kores/-instruction/index.md)>) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [Typed.Builder](../../com.koresframework.kores.base/-typed/-builder/index.md)<[DynamicMethodSpec](index.md), [DynamicMethodSpec.Builder](-builder/index.md)> , [Named.Builder](../../com.koresframework.kores.base/-named/-builder/index.md)<[DynamicMethodSpec](index.md), [DynamicMethodSpec.Builder](-builder/index.md)> , [ArgumentsHolder.Builder](../../com.koresframework.kores.base/-arguments-holder/-builder/index.md)<[DynamicMethodSpec](index.md), [DynamicMethodSpec.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [DynamicMethodSpec.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |
| [invoke](invoke.md) | [jvm]<br>operator fun [invoke](invoke.md)(bootstrap: [MethodInvokeSpec](../-method-invoke-spec/index.md)): [InvokeDynamic](../../com.koresframework.kores.base/-invoke-dynamic/index.md)<br>operator fun [invoke](invoke.md)(bootstrap: [MethodInvokeHandleSpec](../-method-invoke-handle-spec/index.md), bootstrapArgs: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>): [InvokeDynamic](../../com.koresframework.kores.base/-invoke-dynamic/index.md)<br>operator fun [invoke](invoke.md)(bootstrap: [MethodInvokeSpec](../-method-invoke-spec/index.md), bootstrapArgs: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>): [InvokeDynamic](../../com.koresframework.kores.base/-invoke-dynamic/index.md)<br>Creates a dynamic invocation of this dynamic method spec. |
| [toMethodString](to-method-string.md) | [jvm]<br>fun [toMethodString](to-method-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Human-readable method string. |

## Properties

| Name | Summary |
|---|---|
| [arguments](arguments.md) | [jvm]<br>open override val [arguments](arguments.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.koresframework.kores/-instruction/index.md)><br>Arguments to pass to resolved dynamic method (may include the receiver). |
| [array](array.md) | [jvm]<br>open override val [array](array.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Array arguments |
| [name](name.md) | [jvm]<br>open override val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Name of the dynamic method to resolve. |
| [type](type.md) | [jvm]<br>open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Element type |
| [types](types.md) | [jvm]<br>open override val [types](types.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)><br>Expected types of each argument |
| [typeSpec](type-spec.md) | [jvm]<br>val [typeSpec](type-spec.md): [TypeSpec](../../com.koresframework.kores.base/-type-spec/index.md)<br>Signature of dynamic method to resolve. |
