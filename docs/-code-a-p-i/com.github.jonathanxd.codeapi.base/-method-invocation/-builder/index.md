[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [MethodInvocation](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-accessor/-builder/index.md)`<`[`MethodInvocation`](../index.md)`, Builder>, `[`Builder`](../../-argument-holder/-builder/index.md)`<`[`MethodInvocation`](../index.md)`, Builder>, `[`Builder`](../../-typed/-builder/index.md)`<`[`MethodInvocation`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`MethodInvocation`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [arguments](arguments.md) | `var arguments: List<`[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`>` |
| [invokeType](invoke-type.md) | `lateinit var invokeType: `[`InvokeType`](../../-invoke-type/index.md) |
| [spec](spec.md) | `lateinit var spec: `[`MethodTypeSpec`](../../../com.github.jonathanxd.codeapi.common/-method-type-spec/index.md) |
| [target](target.md) | `lateinit var target: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md) |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`MethodInvocation`](../index.md)<br>Build the object of type [T](#). |
| [withArguments](with-arguments.md) | `fun withArguments(value: List<`[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`>): Builder`<br>See [T.arguments](#) |
| [withArray](with-array.md) | `fun withArray(value: Boolean): Builder`<br>See [T.array](#) |
| [withInvokeType](with-invoke-type.md) | `fun withInvokeType(value: `[`InvokeType`](../../-invoke-type/index.md)`): Builder`<br>See [MethodInvocation.invokeType](../invoke-type.md) |
| [withLocalization](with-localization.md) | `fun withLocalization(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [T.localization](#) |
| [withSpec](with-spec.md) | `fun withSpec(value: `[`MethodTypeSpec`](../../../com.github.jonathanxd.codeapi.common/-method-type-spec/index.md)`): Builder`<br>See [MethodInvocation.spec](../spec.md) |
| [withTarget](with-target.md) | `fun withTarget(value: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`): Builder`<br>See [T.target](#) |
| [withType](with-type.md) | `fun withType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [T.type](#) |

### Inherited Functions

| Name | Summary |
|---|---|
| [withArguments](../../-argument-holder/-builder/with-arguments.md) | `open fun withArguments(vararg values: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`): S`<br>See [T.arguments](../../-argument-holder/arguments.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`MethodInvocation`](../index.md)`): Builder` |
