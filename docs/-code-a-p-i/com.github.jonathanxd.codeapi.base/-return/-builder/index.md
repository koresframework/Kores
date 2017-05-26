[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [Return](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-value-holder/-builder/index.md)`<`[`Return`](../index.md)`, Builder>, `[`Builder`](../../-typed/-builder/index.md)`<`[`Return`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`Return`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [type](type.md) | `lateinit var type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) |
| [value](value.md) | `lateinit var value: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md) |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`Return`](../index.md)<br>Build the object of type [T](#). |
| [withType](with-type.md) | `fun withType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [T.type](#) |
| [withValue](with-value.md) | `fun withValue(value: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`?): Builder`<br>See [T.value](#) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`Return`](../index.md)`): Builder` |
