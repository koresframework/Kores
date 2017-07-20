[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [TypeSpec](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-typed/-builder/index.md)`<`[`TypeSpec`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`TypeSpec`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [parameterTypes](parameter-types.md) | `var parameterTypes: List<`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`>` |
| [returnType](return-type.md) | `var returnType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`TypeSpec`](../index.md)<br>Build the object of type [T](#). |
| [parameterTypes](parameter-types.md) | `fun parameterTypes(value: List<`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`>): Builder`<br>`fun parameterTypes(vararg values: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder` |
| [returnType](return-type.md) | `fun returnType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder` |
| [type](type.md) | `fun type(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [T.type](#) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`TypeSpec`](../index.md)`): Builder` |
