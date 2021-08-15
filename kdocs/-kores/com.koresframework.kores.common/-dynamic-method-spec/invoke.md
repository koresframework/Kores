//[Kores](../../../index.md)/[com.koresframework.kores.common](../index.md)/[DynamicMethodSpec](index.md)/[invoke](invoke.md)

# invoke

[jvm]\
operator fun [invoke](invoke.md)(bootstrap: [MethodInvokeSpec](../-method-invoke-spec/index.md)): [InvokeDynamic](../../com.koresframework.kores.base/-invoke-dynamic/index.md)

Creates a dynamic invocation of this dynamic method spec. The dynamic invocation uses [bootstrap](invoke.md) to bind the invocation.

[jvm]\
operator fun [invoke](invoke.md)(bootstrap: [MethodInvokeSpec](../-method-invoke-spec/index.md), bootstrapArgs: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>): [InvokeDynamic](../../com.koresframework.kores.base/-invoke-dynamic/index.md)

operator fun [invoke](invoke.md)(bootstrap: [MethodInvokeHandleSpec](../-method-invoke-handle-spec/index.md), bootstrapArgs: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>): [InvokeDynamic](../../com.koresframework.kores.base/-invoke-dynamic/index.md)

Creates a dynamic invocation of this dynamic method spec. The dynamic invocation uses [bootstrap](invoke.md) (with [bootstrapArgs](invoke.md)) to bind the invocation.
