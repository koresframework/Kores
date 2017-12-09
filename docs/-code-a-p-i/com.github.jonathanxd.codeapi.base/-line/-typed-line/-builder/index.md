[CodeAPI](../../../../index.md) / [com.github.jonathanxd.codeapi.base](../../../index.md) / [Line](../../index.md) / [TypedLine](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-builder/index.md)`<`[`TypedLine`](../index.md)`, Builder>, `[`Builder`](../../../-typed/-builder/index.md)`<`[`TypedLine`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`TypedLine`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [line](line.md) | `var line: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [type](type.md) | `lateinit var type: Type` |
| [value](value.md) | `lateinit var value: `[`CodeInstruction`](../../../../com.github.jonathanxd.codeapi/-code-instruction.md) |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`TypedLine`](../index.md)<br>Build the object of type [T](#). |
| [line](line.md) | `fun line(value: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Builder`<br>See [Line.line](../../line.md) |
| [type](type.md) | `fun type(value: Type): Builder`<br>See [T.type](#) |
| [value](value.md) | `fun value(value: `[`CodeInstruction`](../../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): Builder`<br>See [T.value](#) |
