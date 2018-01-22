[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [Annotation](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-typed/-builder/index.md)`<`[`Annotation`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`Annotation`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [retention](retention.md) | `var retention: `[`CodeRetention`](../../-code-retention/index.md) |
| [type](type.md) | `lateinit var type: Type` |
| [values](values.md) | `var values: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>` |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`Annotation`](../index.md)<br>Build the object of type [T](#). |
| [retention](retention.md) | `fun retention(value: `[`CodeRetention`](../../-code-retention/index.md)`): Builder`<br>See [Annotation.retention](../retention.md) |
| [type](type.md) | `fun type(value: Type): Builder`<br>See [Annotation.type](../type.md) |
| [values](values.md) | `fun values(value: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>): Builder`<br>See [Annotation.values](../values.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`Annotation`](../index.md)`): Builder` |
