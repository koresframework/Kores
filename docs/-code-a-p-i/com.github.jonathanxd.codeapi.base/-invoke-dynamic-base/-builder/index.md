[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [InvokeDynamicBase](../index.md) / [Builder](.)

# Builder

`interface Builder<out T : `[`InvokeDynamicBase`](../index.md)`, S : Builder<T, S>> : `[`Builder`](../../-typed/-builder/index.md)`<T, S>`

### Functions

| Name | Summary |
|---|---|
| [bootstrap](bootstrap.md) | `abstract fun bootstrap(value: `[`MethodInvokeSpec`](../../../com.github.jonathanxd.codeapi.common/-method-invoke-spec/index.md)`): S`<br>See [InvokeDynamic.bootstrap](../../-invoke-dynamic/bootstrap.md) |
| [bootstrapArgs](bootstrap-args.md) | `abstract fun bootstrapArgs(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>): S`<br>`open fun bootstrapArgs(vararg values: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`): S`<br>See [InvokeDynamic.bootstrapArgs](../../-invoke-dynamic/bootstrap-args.md) |
| [dynamicMethod](dynamic-method.md) | `abstract fun dynamicMethod(value: `[`DynamicMethodSpec`](../../../com.github.jonathanxd.codeapi.common/-dynamic-method-spec/index.md)`): S`<br>See [InvokeDynamic.dynamicMethod](../../-invoke-dynamic/dynamic-method.md) |
| [type](type.md) | `open fun type(value: Type): S`<br>See [T.type](type.md) |

### Inheritors

| Name | Summary |
|---|---|
| [Builder](../-lambda-method-ref-base/-builder/index.md) | `interface Builder<out T : `[`LambdaMethodRefBase`](../-lambda-method-ref-base/index.md)`, S : `[`Builder`](../-lambda-method-ref-base/-builder/index.md)`<T, S>> : Builder<T, S>, `[`Builder`](../../-arguments-holder/-builder/index.md)`<T, S>` |
| [Builder](../../-invoke-dynamic/-builder/index.md) | `class Builder : Builder<`[`InvokeDynamic`](../../-invoke-dynamic/index.md)`, `[`Builder`](../../-invoke-dynamic/-builder/index.md)`>` |
