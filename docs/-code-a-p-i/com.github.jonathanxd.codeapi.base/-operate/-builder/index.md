[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [Operate](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-value-holder/-builder/index.md)`<`[`Operate`](../index.md)`, Builder>, `[`Builder`](../../-typed/-builder/index.md)`<`[`Operate`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`Operate`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [operation](operation.md) | `lateinit var operation: `[`Math`](../../../com.github.jonathanxd.codeapi.operator/-operator/-math/index.md) |
| [target](target.md) | `lateinit var target: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md) |
| [value](value.md) | `var value: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md) |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`Operate`](../index.md)<br>Build the object of type [T](#). |
| [operation](operation.md) | `fun operation(value: `[`Math`](../../../com.github.jonathanxd.codeapi.operator/-operator/-math/index.md)`): Builder`<br>See [Operate.operation](../operation.md) |
| [target](target.md) | `fun target(value: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): Builder`<br>See [Operate.target](../target.md) |
| [type](type.md) | `fun type(value: Type): Builder`<br>See [T.type](#) |
| [value](value.md) | `fun value(value: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): Builder`<br>See [T.value](#) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`Operate`](../index.md)`): Builder` |
