[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [EnumValue](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-named/-builder/index.md)`<`[`EnumValue`](../index.md)`, Builder>, `[`Builder`](../../-typed/-builder/index.md)`<`[`EnumValue`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`EnumValue`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [enumEntry](enum-entry.md) | `lateinit var enumEntry: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [enumType](enum-type.md) | `lateinit var enumType: Type` |

### Functions

| Name | Summary |
|---|---|
| [base](base.md) | `fun base(enum: `[`Enum`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)`<*>): Builder`<br>Base this EnumValue on an [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html). |
| [build](build.md) | `fun build(): `[`EnumValue`](../index.md)<br>Build the object of type [T](#). |
| [enumEntry](enum-entry.md) | `fun enumEntry(value: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Builder`<br>See [EnumValue.enumEntry](../enum-entry.md) |
| [enumType](enum-type.md) | `fun enumType(value: Type): Builder`<br>See [EnumValue.enumType](../enum-type.md) |
| [name](name.md) | `fun name(value: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Builder` |
| [type](type.md) | `fun type(value: Type): Builder`<br>See [T.type](#) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`EnumValue`](../index.md)`): Builder` |
