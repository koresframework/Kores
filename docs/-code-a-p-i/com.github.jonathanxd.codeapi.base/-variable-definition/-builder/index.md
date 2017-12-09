[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [VariableDefinition](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-named/-builder/index.md)`<`[`VariableDefinition`](../index.md)`, Builder>, `[`Builder`](../../-typed/-builder/index.md)`<`[`VariableDefinition`](../index.md)`, Builder>, `[`Builder`](../../-value-holder/-builder/index.md)`<`[`VariableDefinition`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`VariableDefinition`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [name](name.md) | `lateinit var name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [type](type.md) | `lateinit var type: Type` |
| [value](value.md) | `lateinit var value: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md) |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`VariableDefinition`](../index.md)<br>Build the object of type [T](#). |
| [name](name.md) | `fun name(value: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Builder` |
| [type](type.md) | `fun type(value: Type): Builder`<br>See [T.type](#) |
| [value](value.md) | `fun value(value: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): Builder`<br>See [T.value](#) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`VariableDefinition`](../index.md)`): Builder` |
