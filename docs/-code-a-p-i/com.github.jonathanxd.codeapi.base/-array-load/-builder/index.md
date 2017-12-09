[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [ArrayLoad](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-array-access/-builder/index.md)`<`[`ArrayLoad`](../index.md)`, Builder>, `[`Builder`](../../-typed/-builder/index.md)`<`[`ArrayLoad`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`ArrayLoad`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [arrayType](array-type.md) | `lateinit var arrayType: Type` |
| [index](--index--.md) | `lateinit var index: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md) |
| [target](target.md) | `lateinit var target: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md) |
| [valueType](value-type.md) | `lateinit var valueType: Type` |

### Functions

| Name | Summary |
|---|---|
| [arrayType](array-type.md) | `fun arrayType(value: Type): Builder`<br>See [T.arrayType](#) |
| [build](build.md) | `fun build(): `[`ArrayLoad`](../index.md)<br>Build the object of type [T](#). |
| [index](--index--.md) | `fun index(value: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): Builder`<br>See [ArrayLoad.index](../--index--.md) |
| [target](target.md) | `fun target(value: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): Builder`<br>See [T.target](#) |
| [type](type.md) | `fun type(value: Type): Builder`<br>See [T.type](#) |
| [valueType](value-type.md) | `fun valueType(value: Type): Builder`<br>See [ArrayLoad.valueType](../value-type.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`ArrayLoad`](../index.md)`): Builder` |
