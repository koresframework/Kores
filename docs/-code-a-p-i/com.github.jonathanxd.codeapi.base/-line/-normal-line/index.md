[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [Line](../index.md) / [NormalLine](.)

# NormalLine

`data class NormalLine : `[`Line`](../index.md)

A Line which does extends [Line](../index.md)

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `class Builder : `[`Builder`](../-builder/index.md)`<NormalLine, `[`Builder`](-builder/index.md)`>` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `NormalLine(line: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, value: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`)`<br>A Line which does extends [Line](../index.md) |

### Properties

| Name | Summary |
|---|---|
| [line](line.md) | `val line: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Line index |
| [value](value.md) | `val value: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Instruction mapped to line |

### Inherited Properties

| Name | Summary |
|---|---|
| [wrappedInstruction](../wrapped-instruction.md) | `open val wrappedInstruction: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Wrapped instruction instance. |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): `[`Builder`](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |
