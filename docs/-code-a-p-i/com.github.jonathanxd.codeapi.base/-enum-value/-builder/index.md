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
| [enumEntry](enum-entry.md) | `lateinit var enumEntry: String` |
| [enumType](enum-type.md) | `lateinit var enumType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) |
| [ordinal](ordinal.md) | `var ordinal: Int` |

### Functions

| Name | Summary |
|---|---|
| [base](base.md) | `fun base(enum: Enum<*>): Builder`<br>Base this EnumValue on an [Enum](#). |
| [build](build.md) | `fun build(): `[`EnumValue`](../index.md)<br>Build the object of type [T](#). |
| [enumEntry](enum-entry.md) | `fun enumEntry(value: String): Builder`<br>See [EnumValue.enumEntry](../enum-entry.md) |
| [enumType](enum-type.md) | `fun enumType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [EnumValue.enumType](../enum-type.md) |
| [name](name.md) | `fun name(value: String): Builder` |
| [ordinal](ordinal.md) | `fun ordinal(value: Int): Builder`<br>See [EnumValue.ordinal](../ordinal.md) |
| [type](type.md) | `fun type(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [T.type](#) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`EnumValue`](../index.md)`): Builder` |
