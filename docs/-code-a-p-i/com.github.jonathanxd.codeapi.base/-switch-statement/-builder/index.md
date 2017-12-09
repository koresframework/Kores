[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [SwitchStatement](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-value-holder/-builder/index.md)`<`[`SwitchStatement`](../index.md)`, Builder>, `[`Builder`](../../-typed/-builder/index.md)`<`[`SwitchStatement`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`SwitchStatement`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [cases](cases.md) | `var cases: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Case`](../../-case/index.md)`>` |
| [switchType](switch-type.md) | `lateinit var switchType: `[`SwitchType`](../../-switch-type/index.md) |
| [value](value.md) | `lateinit var value: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md) |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`SwitchStatement`](../index.md)<br>Build the object of type [T](#). |
| [cases](cases.md) | `fun cases(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Case`](../../-case/index.md)`>): Builder`<br>`fun cases(vararg values: `[`Case`](../../-case/index.md)`): Builder`<br>See [SwitchStatement.cases](../cases.md) |
| [switchType](switch-type.md) | `fun switchType(value: `[`SwitchType`](../../-switch-type/index.md)`): Builder`<br>See [SwitchStatement.switchType](../switch-type.md) |
| [type](type.md) | `fun type(value: Type): Builder`<br>See [T.type](#) |
| [value](value.md) | `fun value(value: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): Builder`<br>See [SwitchStatement.value](../value.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`SwitchStatement`](../index.md)`): Builder` |
