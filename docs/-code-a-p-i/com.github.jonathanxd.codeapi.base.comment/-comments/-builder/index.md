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
| [comments](comments.md) | `fun comments(value: List<`[`Comment`](../../-comment/index.md)`>): Builder`<br>`fun comments(vararg values: `[`Comment`](../../-comment/index.md)`): Builder`<br>See [Comments.comments](../comments.md) |
| [type](type.md) | `fun type(value: `[`Type`](../-type/index.md)`): Builder`<br>See [Comments.type](../type.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`Comments`](../index.md)`): Builder` |
