[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [Label](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-body-holder/-builder/index.md)`<`[`Label`](../index.md)`, Builder>, `[`Builder`](../../-named/-builder/index.md)`<`[`Label`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`Label`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [body](body.md) | `var body: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md) |
| [name](name.md) | `lateinit var name: String` |

### Functions

| Name | Summary |
|---|---|
| [body](body.md) | `fun body(value: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md)`): Builder`<br>See [T.body](#) |
| [build](build.md) | `fun build(): `[`Label`](../index.md)<br>Build the object of type [T](#). |
| [name](name.md) | `fun name(value: String): Builder` |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`Label`](../index.md)`): Builder` |
