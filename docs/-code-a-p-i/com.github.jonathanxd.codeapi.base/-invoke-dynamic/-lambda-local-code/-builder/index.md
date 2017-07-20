[CodeAPI](../../../../index.md) / [com.github.jonathanxd.codeapi.base](../../../index.md) / [InvokeDynamic](../../index.md) / [LambdaLocalCode](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../../-invoke-dynamic-base/-lambda-local-code-base/-builder/index.md)`<`[`LambdaLocalCode`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`LambdaLocalCode`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [arguments](arguments.md) | `var arguments: List<`[`CodeInstruction`](../../../../com.github.jonathanxd.codeapi/-code-instruction.md)`>` |
| [baseSam](base-sam.md) | `lateinit var baseSam: `[`MethodTypeSpec`](../../../../com.github.jonathanxd.codeapi.common/-method-type-spec/index.md) |
| [localCode](local-code.md) | `lateinit var localCode: `[`LocalCode`](../../../-local-code/index.md) |

### Functions

| Name | Summary |
|---|---|
| [arguments](arguments.md) | `fun arguments(value: List<`[`CodeInstruction`](../../../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): Builder`<br>See [T.arguments](#) |
| [array](array.md) | `fun array(value: Boolean): Builder`<br>See [T.array](#) |
| [baseSam](base-sam.md) | `fun baseSam(value: `[`MethodTypeSpec`](../../../../com.github.jonathanxd.codeapi.common/-method-type-spec/index.md)`): Builder`<br>See [T.baseSam](#) |
| [build](build.md) | `fun build(): `[`LambdaLocalCode`](../index.md)<br>Build the object of type [T](#). |
| [localCode](local-code.md) | `fun localCode(value: `[`LocalCode`](../../../-local-code/index.md)`): Builder`<br>See [T.localCode](#) |

### Inherited Functions

| Name | Summary |
|---|---|
| [args](../../../-invoke-dynamic-base/-lambda-local-code-base/-builder/args.md) | `open fun args(value: List<Any>): S`<br>See [T.args](../../../-invoke-dynamic-base/-lambda-local-code-base/-builder/args.md) |
| [bootstrap](../../../-invoke-dynamic-base/-lambda-local-code-base/-builder/bootstrap.md) | `open fun bootstrap(value: `[`MethodInvokeSpec`](../../../../com.github.jonathanxd.codeapi.common/-method-invoke-spec/index.md)`): S`<br>See [T.bootstrap](../../../-invoke-dynamic-base/-lambda-local-code-base/-builder/bootstrap.md) |
| [expectedTypes](../../../-invoke-dynamic-base/-lambda-local-code-base/-builder/expected-types.md) | `open fun expectedTypes(value: `[`TypeSpec`](../../../-type-spec/index.md)`): S`<br>See [T.expectedTypes](../../../-invoke-dynamic-base/-lambda-local-code-base/-builder/expected-types.md) |
| [invocation](../../../-invoke-dynamic-base/-lambda-local-code-base/-builder/invocation.md) | `open fun invocation(value: `[`MethodInvocation`](../../../-method-invocation/index.md)`): S`<br>See [T.invocation](../../../-invoke-dynamic-base/-lambda-local-code-base/-builder/invocation.md) |
| [type](../../../-invoke-dynamic-base/-lambda-local-code-base/-builder/type.md) | `open fun type(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): S`<br>See [T.type](../../../-invoke-dynamic-base/-lambda-local-code-base/-builder/type.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`LambdaLocalCode`](../index.md)`): Builder` |
