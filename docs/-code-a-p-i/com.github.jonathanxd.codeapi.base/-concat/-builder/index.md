[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [Concat](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-typed/-builder/index.md)`<`[`Concat`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`Concat`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [concatenations](concatenations.md) | `var concatenations: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`Concat`](../index.md)<br>Build the object of type [T](#). |
| [concatenations](concatenations.md) | `fun concatenations(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): Builder`<br>`fun concatenations(vararg values: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): Builder`<br>See [Concat.concatenations](../concatenations.md) |
| [type](type.md) | `fun type(value: Type): Builder`<br>See [T.type](#) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`Concat`](../index.md)`): Builder` |
