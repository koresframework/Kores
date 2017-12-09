[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [IfGroup](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-if-expression-holder/-builder/index.md)`<`[`IfGroup`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`IfGroup`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [expressions](expressions.md) | `var expressions: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`IfGroup`](../index.md)<br>Build the object of type [T](#). |
| [expressions](expressions.md) | `fun expressions(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): Builder`<br>`fun expressions(vararg values: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): Builder`<br>See [T.expressions](#) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`IfGroup`](../index.md)`): Builder` |
