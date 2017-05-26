[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [Case](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-value-holder/-builder/index.md)`<`[`Case`](../index.md)`, Builder>, `[`Builder`](../../-typed/-builder/index.md)`<`[`Case`](../index.md)`, Builder>, `[`Builder`](../../-body-holder/-builder/index.md)`<`[`Case`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`Case`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [body](body.md) | `var body: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md) |
| [value](value.md) | `var value: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`?` |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`Case`](../index.md)<br>Build the object of type [T](#). |
| [setDefault](set-default.md) | `fun setDefault(): Builder`<br>Sets the case statement as `default` case (same as `withValue(null)`). |
| [withBody](with-body.md) | `fun withBody(value: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md)`): Builder`<br>See [T.body](#) |
| [withType](with-type.md) | `fun withType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [T.type](#) |
| [withValue](with-value.md) | `fun withValue(value: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`?): Builder`<br>See [T.value](#) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`Case`](../index.md)`): Builder` |
