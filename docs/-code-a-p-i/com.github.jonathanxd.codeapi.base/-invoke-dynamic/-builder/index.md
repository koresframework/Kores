[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [InvokeDynamic](../index.md) / [Builder](.)

# Builder

`class Builder : Builder<`[`InvokeDynamic`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`InvokeDynamic`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [args](args.md) | `var args: List<Any>` |
| [bootstrap](bootstrap.md) | `lateinit var bootstrap: `[`MethodInvokeSpec`](../../../com.github.jonathanxd.codeapi.common/-method-invoke-spec/index.md) |
| [invocation](invocation.md) | `lateinit var invocation: `[`MethodInvocation`](../../-method-invocation/index.md) |
| [type](type.md) | `lateinit var type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`InvokeDynamic`](../index.md)<br>Build the object of type [T](#). |
| [withArgs](with-args.md) | `fun withArgs(value: List<Any>): Builder`<br>See [T.args](#) |
| [withBootstrap](with-bootstrap.md) | `fun withBootstrap(value: `[`MethodInvokeSpec`](../../../com.github.jonathanxd.codeapi.common/-method-invoke-spec/index.md)`): Builder`<br>See [T.bootstrap](#) |
| [withInvocation](with-invocation.md) | `fun withInvocation(value: `[`MethodInvocation`](../../-method-invocation/index.md)`): Builder`<br>See [T.invocation](#) |
| [withType](with-type.md) | `fun withType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [T.type](#) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`InvokeDynamic`](../index.md)`): Builder` |