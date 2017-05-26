[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.common](../../index.md) / [MethodTypeSpec](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../../com.github.jonathanxd.codeapi.base/-typed/-builder/index.md)`<`[`MethodTypeSpec`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`MethodTypeSpec`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [localization](localization.md) | `lateinit var localization: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) |
| [methodName](method-name.md) | `lateinit var methodName: String` |
| [typeSpec](type-spec.md) | `lateinit var typeSpec: `[`TypeSpec`](../../../com.github.jonathanxd.codeapi.base/-type-spec/index.md) |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`MethodTypeSpec`](../index.md)<br>Build the object of type [T](#). |
| [withLocalization](with-localization.md) | `fun withLocalization(value: `[`CodeType`](../../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`): Builder` |
| [withMethodName](with-method-name.md) | `fun withMethodName(value: String): Builder` |
| [withType](with-type.md) | `fun withType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [T.type](#) |
| [withTypeSpec](with-type-spec.md) | `fun withTypeSpec(value: `[`TypeSpec`](../../../com.github.jonathanxd.codeapi.base/-type-spec/index.md)`): Builder` |
