[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [Case](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-value-holder/-builder/index.md)`<`[`Case`](../index.md)`, Builder>, `[`Builder`](../../-typed/-builder/index.md)`<`[`Case`](../index.md)`, Builder>, `[`Builder`](../../-body-holder/-builder/index.md)`<`[`Case`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`Case`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [body](body.md) | `var body: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md) |
| [value](value.md) | `var value: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md) |

### Functions

| Name | Summary |
|---|---|
| [body](body.md) | `fun body(value: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md)`): Builder`<br>See [T.body](#) |
| [build](build.md) | `fun build(): `[`Case`](../index.md)<br>Build the object of type [T](#). |
| [defaultCase](default-case.md) | `fun defaultCase(): Builder`<br>Sets the case statement as `default` case (same as `withValue(Void)`). |
| [type](type.md) | `fun type(value: Type): Builder`<br>See [T.type](#) |
| [value](value.md) | `fun value(value: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): Builder`<br>See [T.value](#) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`Case`](../index.md)`): Builder` |
