[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [ControlFlow](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<`[`ControlFlow`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`ControlFlow`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [at](at.md) | `var at: `[`Label`](../../-label/index.md)`?` |
| [type](type.md) | `lateinit var type: `[`Type`](../-type/index.md) |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`ControlFlow`](../index.md)<br>Build the object of type [T](#). |
| [withAt](with-at.md) | `fun withAt(value: `[`Label`](../../-label/index.md)`?): Builder`<br>See [ControlFlow.at](../at.md) |
| [withType](with-type.md) | `fun withType(value: `[`Type`](../-type/index.md)`): Builder`<br>See [ControlFlow.type](../type.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`ControlFlow`](../index.md)`): Builder` |
