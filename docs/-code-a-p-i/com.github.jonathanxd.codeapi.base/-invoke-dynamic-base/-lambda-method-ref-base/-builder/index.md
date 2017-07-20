[CodeAPI](../../../../index.md) / [com.github.jonathanxd.codeapi.base](../../../index.md) / [InvokeDynamicBase](../../index.md) / [LambdaMethodRefBase](../index.md) / [Builder](.)

# Builder

`interface Builder<out T : `[`LambdaMethodRefBase`](../index.md)`, S : Builder<T, S>> : `[`Builder`](../../-builder/index.md)`<T, S>`

### Functions

| Name | Summary |
|---|---|
| [args](args.md) | `open fun args(value: List<Any>): S`<br>See [T.args](args.md) |
| [baseSam](base-sam.md) | `abstract fun baseSam(value: `[`MethodTypeSpec`](../../../../com.github.jonathanxd.codeapi.common/-method-type-spec/index.md)`): S`<br>See [T.baseSam](base-sam.md) |
| [bootstrap](bootstrap.md) | `open fun bootstrap(value: `[`MethodInvokeSpec`](../../../../com.github.jonathanxd.codeapi.common/-method-invoke-spec/index.md)`): S`<br>See [T.bootstrap](bootstrap.md) |
| [expectedTypes](expected-types.md) | `abstract fun expectedTypes(value: `[`TypeSpec`](../../../-type-spec/index.md)`): S`<br>See [T.expectedTypes](expected-types.md) |
| [type](type.md) | `open fun type(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): S`<br>See [T.type](type.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [args](../../-builder/args.md) | `open fun args(vararg values: Any): S`<br>See [T.args](../../-builder/args.md) |
| [invocation](../../-builder/invocation.md) | `abstract fun invocation(value: `[`MethodInvocation`](../../../-method-invocation/index.md)`): S`<br>See [T.invocation](../../-builder/invocation.md) |

### Inheritors

| Name | Summary |
|---|---|
| [Builder](../../-lambda-local-code-base/-builder/index.md) | `interface Builder<out T : `[`LambdaLocalCodeBase`](../../-lambda-local-code-base/index.md)`, S : `[`Builder`](../../-lambda-local-code-base/-builder/index.md)`<T, S>> : Builder<T, S>, `[`Builder`](../../../-arguments-holder/-builder/index.md)`<T, S>` |
| [Builder](../../../-invoke-dynamic/-lambda-method-ref/-builder/index.md) | `class Builder : Builder<`[`LambdaMethodRef`](../../../-invoke-dynamic/-lambda-method-ref/index.md)`, `[`Builder`](../../../-invoke-dynamic/-lambda-method-ref/-builder/index.md)`>` |
