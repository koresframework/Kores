[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base.comment](../../index.md) / [Link](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<`[`Link`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`Link`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [name](name.md) | `var name: String?` |
| [target](target.md) | `lateinit var target: `[`LinkTarget`](../-link-target/index.md) |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`Link`](../index.md)<br>Build the object of type [T](#). |
| [withName](with-name.md) | `fun withName(value: String?): Builder`<br>See [Link.name](../name.md) |
| [withTarget](with-target.md) | `fun withTarget(value: `[`LinkTarget`](../-link-target/index.md)`): Builder`<br>See [Link.target](../target.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`Link`](../index.md)`): Builder` |
