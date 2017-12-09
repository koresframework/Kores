[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [ArrayLength](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-array-access/-builder/index.md)`<`[`ArrayLength`](../index.md)`, Builder>, `[`Builder`](../../-typed/-builder/index.md)`<`[`ArrayLength`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`ArrayLength`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [arrayType](array-type.md) | `lateinit var arrayType: Type` |
| [target](target.md) | `lateinit var target: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md) |

### Functions

| Name | Summary |
|---|---|
| [arrayType](array-type.md) | `fun arrayType(value: Type): Builder`<br>See [T.arrayType](#) |
| [build](build.md) | `fun build(): `[`ArrayLength`](../index.md)<br>Build the object of type [T](#). |
| [target](target.md) | `fun target(value: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): Builder`<br>See [T.target](#) |
| [type](type.md) | `fun type(value: Type): Builder`<br>See [T.type](#) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`ArrayLength`](../index.md)`): Builder` |
