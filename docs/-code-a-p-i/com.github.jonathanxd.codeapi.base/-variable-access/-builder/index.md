[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [VariableAccess](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-variable-base/-builder/index.md)`<`[`VariableAccess`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`VariableAccess`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [name](name.md) | `lateinit var name: String` |
| [variableType](variable-type.md) | `lateinit var variableType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`VariableAccess`](../index.md)<br>Build the object of type [T](#). |
| [withName](with-name.md) | `fun withName(value: String): Builder` |
| [withVariableType](with-variable-type.md) | `fun withVariableType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [T.variableType](#) |

### Inherited Functions

| Name | Summary |
|---|---|
| [withType](../../-variable-base/-builder/with-type.md) | `open fun withType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): S`<br>See [T.type](../../-variable-base/type.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`VariableAccess`](../index.md)`): Builder` |
