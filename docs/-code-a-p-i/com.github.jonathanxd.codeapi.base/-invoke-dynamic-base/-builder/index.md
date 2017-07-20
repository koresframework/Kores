[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [InvokeDynamicBase](../index.md) / [Builder](.)

# Builder

`interface Builder<out T : `[`InvokeDynamicBase`](../index.md)`, S : Builder<T, S>> : `[`Builder`](../../-typed/-builder/index.md)`<T, S>`

### Functions

| Name | Summary |
|---|---|
| [args](args.md) | `abstract fun args(value: List<Any>): S`<br>`open fun args(vararg values: Any): S`<br>See [T.args](args.md) |
| [bootstrap](bootstrap.md) | `abstract fun bootstrap(value: `[`MethodInvokeSpec`](../../../com.github.jonathanxd.codeapi.common/-method-invoke-spec/index.md)`): S`<br>See [T.bootstrap](bootstrap.md) |
| [invocation](invocation.md) | `abstract fun invocation(value: `[`MethodInvocation`](../../-method-invocation/index.md)`): S`<br>See [T.invocation](invocation.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [type](../../-typed/-builder/type.md) | `abstract fun type(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): S`<br>See [T.type](../../-typed/-builder/type.md) |

### Inheritors

| Name | Summary |
|---|---|
| [Builder](../-lambda-method-ref-base/-builder/index.md) | `interface Builder<out T : `[`LambdaMethodRefBase`](../-lambda-method-ref-base/index.md)`, S : `[`Builder`](../-lambda-method-ref-base/-builder/index.md)`<T, S>> : Builder<T, S>` |
| [Builder](../../-invoke-dynamic/-builder/index.md) | `class Builder : Builder<`[`InvokeDynamic`](../../-invoke-dynamic/index.md)`, `[`Builder`](../../-invoke-dynamic/-builder/index.md)`>` |
