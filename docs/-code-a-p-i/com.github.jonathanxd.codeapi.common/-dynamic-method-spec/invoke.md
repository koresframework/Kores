[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.common](../index.md) / [DynamicMethodSpec](index.md) / [invoke](.)

# invoke

`operator fun invoke(bootstrap: `[`MethodInvokeSpec`](../-method-invoke-spec/index.md)`): `[`InvokeDynamic`](../../com.github.jonathanxd.codeapi.base/-invoke-dynamic/index.md)

Creates a dynamic invocation of this dynamic method spec. The dynamic invocation
uses [bootstrap](invoke.md#com.github.jonathanxd.codeapi.common.DynamicMethodSpec$invoke(com.github.jonathanxd.codeapi.common.MethodInvokeSpec)/bootstrap) to bind the invocation.

`operator fun invoke(bootstrap: `[`MethodInvokeSpec`](../-method-invoke-spec/index.md)`, bootstrapArgs: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>): `[`InvokeDynamic`](../../com.github.jonathanxd.codeapi.base/-invoke-dynamic/index.md)

Creates a dynamic invocation of this dynamic method spec. The dynamic invocation
uses [bootstrap](invoke.md#com.github.jonathanxd.codeapi.common.DynamicMethodSpec$invoke(com.github.jonathanxd.codeapi.common.MethodInvokeSpec, kotlin.collections.List((kotlin.Any)))/bootstrap) (with [bootstrapArgs](invoke.md#com.github.jonathanxd.codeapi.common.DynamicMethodSpec$invoke(com.github.jonathanxd.codeapi.common.MethodInvokeSpec, kotlin.collections.List((kotlin.Any)))/bootstrapArgs)) to bind the invocation.

