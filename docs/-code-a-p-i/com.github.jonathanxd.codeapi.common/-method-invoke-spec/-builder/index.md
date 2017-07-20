[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.common](../../index.md) / [MethodInvokeSpec](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../../com.github.jonathanxd.codeapi.base/-typed/-builder/index.md)`<`[`MethodInvokeSpec`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`MethodInvokeSpec`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [invokeType](invoke-type.md) | `lateinit var invokeType: `[`InvokeType`](../../../com.github.jonathanxd.codeapi.base/-invoke-type/index.md) |
| [methodTypeSpec](method-type-spec.md) | `lateinit var methodTypeSpec: `[`MethodTypeSpec`](../../-method-type-spec/index.md) |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`MethodInvokeSpec`](../index.md)<br>Build the object of type [T](#). |
| [type](type.md) | `fun type(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [T.type](#) |
| [withInvokeType](with-invoke-type.md) | `fun withInvokeType(value: `[`InvokeType`](../../../com.github.jonathanxd.codeapi.base/-invoke-type/index.md)`): Builder` |
| [withMethodTypeSpec](with-method-type-spec.md) | `fun withMethodTypeSpec(value: `[`MethodTypeSpec`](../../-method-type-spec/index.md)`): Builder` |
