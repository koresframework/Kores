[CodeAPI](../../../../index.md) / [com.github.jonathanxd.codeapi.base](../../../index.md) / [InvokeDynamic](../../index.md) / [LambdaMethodRef](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../../-invoke-dynamic-base/-lambda-method-ref-base/-builder/index.md)`<`[`LambdaMethodRef`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`LambdaMethodRef`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [baseSam](base-sam.md) | `lateinit var baseSam: `[`MethodTypeSpec`](../../../../com.github.jonathanxd.codeapi.common/-method-type-spec/index.md) |
| [expectedTypes](expected-types.md) | `lateinit var expectedTypes: `[`TypeSpec`](../../../-type-spec/index.md) |
| [invocation](invocation.md) | `lateinit var invocation: `[`MethodInvocation`](../../../-method-invocation/index.md) |

### Functions

| Name | Summary |
|---|---|
| [baseSam](base-sam.md) | `fun baseSam(value: `[`MethodTypeSpec`](../../../../com.github.jonathanxd.codeapi.common/-method-type-spec/index.md)`): Builder`<br>See [T.baseSam](#) |
| [build](build.md) | `fun build(): `[`LambdaMethodRef`](../index.md)<br>Build the object of type [T](#). |
| [expectedTypes](expected-types.md) | `fun expectedTypes(value: `[`TypeSpec`](../../../-type-spec/index.md)`): Builder`<br>See [T.expectedTypes](#) |
| [invocation](invocation.md) | `fun invocation(value: `[`MethodInvocation`](../../../-method-invocation/index.md)`): Builder`<br>See [T.invocation](#) |

### Inherited Functions

| Name | Summary |
|---|---|
| [args](../../../-invoke-dynamic-base/-lambda-method-ref-base/-builder/args.md) | `open fun args(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>): S`<br>See [T.args](../../../-invoke-dynamic-base/-lambda-method-ref-base/-builder/args.md) |
| [bootstrap](../../../-invoke-dynamic-base/-lambda-method-ref-base/-builder/bootstrap.md) | `open fun bootstrap(value: `[`MethodInvokeSpec`](../../../../com.github.jonathanxd.codeapi.common/-method-invoke-spec/index.md)`): S`<br>See [T.bootstrap](../../../-invoke-dynamic-base/-lambda-method-ref-base/-builder/bootstrap.md) |
| [type](../../../-invoke-dynamic-base/-lambda-method-ref-base/-builder/type.md) | `open fun type(value: Type): S`<br>See [T.type](../../../-invoke-dynamic-base/-lambda-method-ref-base/-builder/type.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`LambdaMethodRef`](../index.md)`): Builder` |
