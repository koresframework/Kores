[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [Operate](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-value-holder/-builder/index.md)`<`[`Operate`](../index.md)`, Builder>, `[`Builder`](../../-typed/-builder/index.md)`<`[`Operate`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`Operate`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [operation](operation.md) | `lateinit var operation: `[`Math`](../../../com.github.jonathanxd.codeapi.operator/-operator/-math/index.md) |
| [target](target.md) | `lateinit var target: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [value](value.md) | `var value: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`?` |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`Operate`](../index.md)<br>Build the object of type [T](#). |
| [withOperation](with-operation.md) | `fun withOperation(value: `[`Math`](../../../com.github.jonathanxd.codeapi.operator/-operator/-math/index.md)`): Builder`<br>See [Operate.operation](../operation.md) |
| [withTarget](with-target.md) | `fun withTarget(value: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`): Builder`<br>See [Operate.target](../target.md) |
| [withType](with-type.md) | `fun withType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [T.type](#) |
| [withValue](with-value.md) | `fun withValue(value: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`?): Builder`<br>See [T.value](#) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`Operate`](../index.md)`): Builder` |
