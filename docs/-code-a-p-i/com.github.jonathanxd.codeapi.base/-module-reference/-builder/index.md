[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [ModuleReference](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-named/-builder/index.md)`<`[`ModuleReference`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`ModuleReference`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [name](name.md) | `lateinit var name: String` |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`ModuleReference`](../index.md)<br>Build the object of type [T](#). |
| [withName](with-name.md) | `fun withName(value: String): Builder` |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`ModuleReference`](../index.md)`): Builder` |
