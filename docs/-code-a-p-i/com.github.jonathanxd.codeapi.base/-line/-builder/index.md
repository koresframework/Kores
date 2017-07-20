[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [Line](../index.md) / [Builder](.)

# Builder

`interface Builder<out T : `[`Line`](../index.md)`, S : Builder<T, S>> : `[`Builder`](../../-value-holder/-builder/index.md)`<T, S>`

### Functions

| Name | Summary |
|---|---|
| [line](line.md) | `abstract fun line(value: Int): S`<br>See [Line.line](../line.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [value](../../-value-holder/-builder/value.md) | `abstract fun value(value: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): S`<br>See [T.value](../../-value-holder/-builder/value.md) |

### Inheritors

| Name | Summary |
|---|---|
| [Builder](../-typed-line/-builder/index.md) | `class Builder : Builder<`[`TypedLine`](../-typed-line/index.md)`, `[`Builder`](../-typed-line/-builder/index.md)`>, `[`Builder`](../../-typed/-builder/index.md)`<`[`TypedLine`](../-typed-line/index.md)`, `[`Builder`](../-typed-line/-builder/index.md)`>` |
| [Builder](../-normal-line/-builder/index.md) | `class Builder : Builder<`[`NormalLine`](../-normal-line/index.md)`, `[`Builder`](../-normal-line/-builder/index.md)`>` |
