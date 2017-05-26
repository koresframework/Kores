[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base.comment](../../index.md) / [Comments](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<`[`Comments`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`Comments`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [comments](comments.md) | `var comments: List<`[`Comment`](../../-comment/index.md)`>` |
| [type](type.md) | `lateinit var type: `[`Type`](../-type/index.md) |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`Comments`](../index.md)<br>Build the object of type [T](#). |
| [withComments](with-comments.md) | `fun withComments(value: List<`[`Comment`](../../-comment/index.md)`>): Builder`<br>`fun withComments(vararg values: `[`Comment`](../../-comment/index.md)`): Builder`<br>See [Comments.comments](../comments.md) |
| [withType](with-type.md) | `fun withType(value: `[`Type`](../-type/index.md)`): Builder`<br>See [Comments.type](../type.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`Comments`](../index.md)`): Builder` |
