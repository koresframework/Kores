[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [Line](../index.md) / [TypedLine](.)

# TypedLine

`data class TypedLine : `[`Line`](../index.md)`, `[`Typed`](../../-typed/index.md)

A [Line](../index.md) which extends [Typed](../../-typed/index.md).

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `class Builder : `[`Builder`](../-builder/index.md)`<TypedLine, `[`Builder`](-builder/index.md)`>, `[`Builder`](../../-typed/-builder/index.md)`<TypedLine, `[`Builder`](-builder/index.md)`>` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `TypedLine(line: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, value: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`, type: Type)`<br>A [Line](../index.md) which extends [Typed](../../-typed/index.md). |

### Properties

| Name | Summary |
|---|---|
| [line](line.md) | `val line: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Line index |
| [type](type.md) | `val type: Type`<br>Element type |
| [value](value.md) | `val value: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Instruction mapped to line |

### Inherited Properties

| Name | Summary |
|---|---|
| [wrappedInstruction](../wrapped-instruction.md) | `open val wrappedInstruction: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Wrapped instruction instance. |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): `[`Builder`](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |
