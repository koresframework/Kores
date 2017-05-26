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
| [build](build.md) | `fun build(): `[`EnumValue`](../index.md)<br>Build the object of type [T](#). |
| [withEnumEntry](with-enum-entry.md) | `fun withEnumEntry(value: String): Builder`<br>See [EnumValue.enumEntry](../enum-entry.md) |
| [withEnumType](with-enum-type.md) | `fun withEnumType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [EnumValue.enumType](../enum-type.md) |
| [withName](with-name.md) | `fun withName(value: String): Builder` |
| [withOrdinal](with-ordinal.md) | `fun withOrdinal(value: Int): Builder`<br>See [EnumValue.ordinal](../ordinal.md) |
| [withType](with-type.md) | `fun withType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [T.type](#) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`EnumValue`](../index.md)`): Builder` |
