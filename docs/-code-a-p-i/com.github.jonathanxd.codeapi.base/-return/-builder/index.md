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
| [type](type.md) | `lateinit var type: Type` |
| [value](value.md) | `lateinit var value: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md) |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`Return`](../index.md)<br>Build the object of type [T](#). |
| [type](type.md) | `fun type(value: Type): Builder`<br>See [T.type](#) |
| [value](value.md) | `fun value(value: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): Builder`<br>See [T.value](#) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`Return`](../index.md)`): Builder` |
