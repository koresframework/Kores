[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [InvokeDynamic](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-invoke-dynamic-base/-builder/index.md)`<`[`InvokeDynamic`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`InvokeDynamic`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [args](args.md) | `var args: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>` |
| [bootstrap](bootstrap.md) | `lateinit var bootstrap: `[`MethodInvokeSpec`](../../../com.github.jonathanxd.codeapi.common/-method-invoke-spec/index.md) |
| [invocation](invocation.md) | `lateinit var invocation: `[`MethodInvocation`](../../-method-invocation/index.md) |
| [type](type.md) | `lateinit var type: Type` |

### Functions

| Name | Summary |
|---|---|
| [args](args.md) | `fun args(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>): Builder`<br>See [T.args](#) |
| [bootstrap](bootstrap.md) | `fun bootstrap(value: `[`MethodInvokeSpec`](../../../com.github.jonathanxd.codeapi.common/-method-invoke-spec/index.md)`): Builder`<br>See [T.bootstrap](#) |
| [build](build.md) | `fun build(): `[`InvokeDynamic`](../index.md)<br>Build the object of type [T](#). |
| [invocation](invocation.md) | `fun invocation(value: `[`MethodInvocation`](../../-method-invocation/index.md)`): Builder`<br>See [T.invocation](#) |
| [type](type.md) | `fun type(value: Type): Builder`<br>See [T.type](#) |

### Inherited Functions

| Name | Summary |
|---|---|
| [args](../../-invoke-dynamic-base/-builder/args.md) | `open fun args(vararg values: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`): S`<br>See [T.args](../../-invoke-dynamic-base/-builder/args.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`InvokeDynamic`](../index.md)`): Builder` |
