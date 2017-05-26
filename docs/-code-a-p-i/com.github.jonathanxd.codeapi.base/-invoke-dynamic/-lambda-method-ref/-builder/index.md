[CodeAPI](../../../../index.md) / [com.github.jonathanxd.codeapi.base](../../../index.md) / [InvokeDynamic](../../index.md) / [LambdaMethodRef](../index.md) / [Builder](.)

# Builder

`class Builder : Builder<`[`LambdaMethodRef`](../index.md)`, Builder>`

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
| [build](build.md) | `fun build(): `[`LambdaMethodRef`](../index.md)<br>Build the object of type [T](#). |
| [withBaseSam](with-base-sam.md) | `fun withBaseSam(value: `[`MethodTypeSpec`](../../../../com.github.jonathanxd.codeapi.common/-method-type-spec/index.md)`): Builder`<br>See [T.baseSam](#) |
| [withExpectedTypes](with-expected-types.md) | `fun withExpectedTypes(value: `[`TypeSpec`](../../../-type-spec/index.md)`): Builder`<br>See [T.expectedTypes](#) |
| [withInvocation](with-invocation.md) | `fun withInvocation(value: `[`MethodInvocation`](../../../-method-invocation/index.md)`): Builder`<br>See [T.invocation](#) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`LambdaMethodRef`](../index.md)`): Builder` |
