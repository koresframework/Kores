[CodeAPI](../../../../index.md) / [com.github.jonathanxd.codeapi.base](../../../index.md) / [InvokeDynamic](../../index.md) / [LambdaLocalCode](../index.md) / [Builder](.)

# Builder

`class Builder : Builder<`[`LambdaLocalCode`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`LambdaLocalCode`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [arguments](arguments.md) | `var arguments: List<`[`CodePart`](../../../../com.github.jonathanxd.codeapi/-code-part/index.md)`>` |
| [baseSam](base-sam.md) | `lateinit var baseSam: `[`MethodTypeSpec`](../../../../com.github.jonathanxd.codeapi.common/-method-type-spec/index.md) |
| [localCode](local-code.md) | `lateinit var localCode: `[`LocalCode`](../../../-local-code/index.md) |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`LambdaLocalCode`](../index.md)<br>Build the object of type [T](#). |
| [withArguments](with-arguments.md) | `fun withArguments(value: List<`[`CodePart`](../../../../com.github.jonathanxd.codeapi/-code-part/index.md)`>): Builder`<br>See [T.arguments](#) |
| [withArray](with-array.md) | `fun withArray(value: Boolean): Builder`<br>See [T.array](#) |
| [withBaseSam](with-base-sam.md) | `fun withBaseSam(value: `[`MethodTypeSpec`](../../../../com.github.jonathanxd.codeapi.common/-method-type-spec/index.md)`): Builder`<br>See [T.baseSam](#) |
| [withLocalCode](with-local-code.md) | `fun withLocalCode(value: `[`LocalCode`](../../../-local-code/index.md)`): Builder`<br>See [T.localCode](#) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`LambdaLocalCode`](../index.md)`): Builder` |
