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
| [parameterTypes](parameter-types.md) | `var parameterTypes: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Type>` |
| [returnType](return-type.md) | `var returnType: Type` |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`TypeSpec`](../index.md)<br>Build the object of type [T](#). |
| [parameterTypes](parameter-types.md) | `fun parameterTypes(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Type>): Builder`<br>`fun parameterTypes(vararg values: Type): Builder` |
| [returnType](return-type.md) | `fun returnType(value: Type): Builder` |
| [type](type.md) | `fun type(value: Type): Builder`<br>See [T.type](#) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`TypeSpec`](../index.md)`): Builder` |
