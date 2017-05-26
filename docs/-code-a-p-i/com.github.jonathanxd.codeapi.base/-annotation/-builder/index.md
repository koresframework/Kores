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
| [type](type.md) | `lateinit var type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) |
| [values](values.md) | `var values: Map<String, Any>` |
| [visible](visible.md) | `var visible: Boolean` |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`Annotation`](../index.md)<br>Build the object of type [T](#). |
| [withType](with-type.md) | `fun withType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [Annotation.type](../type.md) |
| [withValues](with-values.md) | `fun withValues(value: Map<String, Any>): Builder`<br>See [Annotation.values](../values.md) |
| [withVisible](with-visible.md) | `fun withVisible(value: Boolean): Builder`<br>See [Annotation.visible](../visible.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`Annotation`](../index.md)`): Builder` |
