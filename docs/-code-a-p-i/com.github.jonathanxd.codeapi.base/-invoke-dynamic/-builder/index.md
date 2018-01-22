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
| [dynamic](dynamic.md) | `lateinit var dynamic: `[`DynamicMethodSpec`](../../../com.github.jonathanxd.codeapi.common/-dynamic-method-spec/index.md) |

### Functions

| Name | Summary |
|---|---|
| [bootstrap](bootstrap.md) | `fun bootstrap(value: `[`MethodInvokeSpec`](../../../com.github.jonathanxd.codeapi.common/-method-invoke-spec/index.md)`): Builder`<br>See [InvokeDynamic.bootstrap](../bootstrap.md) |
| [bootstrapArgs](bootstrap-args.md) | `fun bootstrapArgs(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>): Builder`<br>See [InvokeDynamic.bootstrapArgs](../bootstrap-args.md) |
| [build](build.md) | `fun build(): `[`InvokeDynamic`](../index.md)<br>Build the object of type [T](#). |
| [dynamicMethod](dynamic-method.md) | `fun dynamicMethod(value: `[`DynamicMethodSpec`](../../../com.github.jonathanxd.codeapi.common/-dynamic-method-spec/index.md)`): Builder`<br>See [InvokeDynamic.dynamicMethod](../dynamic-method.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [bootstrapArgs](../../-invoke-dynamic-base/-builder/bootstrap-args.md) | `open fun bootstrapArgs(vararg values: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`): S`<br>See [InvokeDynamic.bootstrapArgs](../bootstrap-args.md) |
| [type](../../-invoke-dynamic-base/-builder/type.md) | `open fun type(value: Type): S`<br>See [T.type](../../-invoke-dynamic-base/-builder/type.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`InvokeDynamic`](../index.md)`): Builder` |
