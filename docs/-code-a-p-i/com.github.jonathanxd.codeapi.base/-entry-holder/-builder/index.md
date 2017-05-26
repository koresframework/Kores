[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [EntryHolder](../index.md) / [Builder](.)

# Builder

`interface Builder<out T : `[`EntryHolder`](../index.md)`, S : Builder<T, S>> : `[`Builder`](../../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<T, S>`

### Functions

| Name | Summary |
|---|---|
| [withEntries](with-entries.md) | `abstract fun withEntries(value: List<`[`EnumEntry`](../../-enum-entry/index.md)`>): S`<br>`open fun withEntries(vararg values: `[`EnumEntry`](../../-enum-entry/index.md)`): S`<br>See [T.entries](../entries.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [build](../../../com.github.jonathanxd.codeapi.builder/-builder/build.md) | `abstract fun build(): T`<br>Build the object of type [T](#). |

### Inheritors

| Name | Summary |
|---|---|
| [Builder](../../-enum-declaration/-builder/index.md) | `class Builder : `[`Builder`](../../-type-declaration/-builder/index.md)`<`[`EnumDeclaration`](../../-enum-declaration/index.md)`, `[`Builder`](../../-enum-declaration/-builder/index.md)`>, `[`Builder`](../../-implementation-holder/-builder/index.md)`<`[`EnumDeclaration`](../../-enum-declaration/index.md)`, `[`Builder`](../../-enum-declaration/-builder/index.md)`>, Builder<`[`EnumDeclaration`](../../-enum-declaration/index.md)`, `[`Builder`](../../-enum-declaration/-builder/index.md)`>` |
