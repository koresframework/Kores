[CodeAPI](../../../../index.md) / [com.github.jonathanxd.codeapi.base](../../../index.md) / [Line](../../index.md) / [NormalLine](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-builder/index.md)`<`[`NormalLine`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`NormalLine`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [line](line.md) | `var line: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [value](value.md) | `lateinit var value: `[`CodeInstruction`](../../../../com.github.jonathanxd.codeapi/-code-instruction.md) |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`NormalLine`](../index.md)<br>Build the object of type [T](#). |
| [line](line.md) | `fun line(value: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Builder`<br>See [Line.line](../../line.md) |
| [value](value.md) | `fun value(value: `[`CodeInstruction`](../../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): Builder`<br>See [T.value](#) |
