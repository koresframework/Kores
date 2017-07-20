[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [Synchronized](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-body-holder/-builder/index.md)`<`[`Synchronized`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`Synchronized`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [body](body.md) | `var body: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md) |
| [instruction](instruction.md) | `lateinit var instruction: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md) |

### Functions

| Name | Summary |
|---|---|
| [body](body.md) | `fun body(value: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md)`): Builder`<br>See [T.body](#) |
| [build](build.md) | `fun build(): `[`Synchronized`](../index.md)<br>Build the object of type [T](#). |
| [instruction](instruction.md) | `fun instruction(value: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): Builder`<br>See [Synchronized.instruction](../instruction.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`Synchronized`](../index.md)`): Builder` |
