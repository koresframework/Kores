[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [LocalCode](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<`[`LocalCode`](../index.md)`, Builder>, `[`Builder`](../../-inner-types-holder/-builder/index.md)`<`[`LocalCode`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`LocalCode`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [declaration](declaration.md) | `lateinit var declaration: `[`MethodDeclaration`](../../-method-declaration/index.md) |
| [declaringType](declaring-type.md) | `lateinit var declaringType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) |
| [innerTypes](inner-types.md) | `var innerTypes: List<`[`TypeDeclaration`](../../-type-declaration/index.md)`>` |
| [invokeType](invoke-type.md) | `var invokeType: `[`InvokeType`](../../-invoke-type/index.md)`?` |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`LocalCode`](../index.md)<br>Build the object of type [T](#). |
| [withDeclaration](with-declaration.md) | `fun withDeclaration(value: `[`MethodDeclaration`](../../-method-declaration/index.md)`): Builder`<br>See [LocalCode.declaration](../declaration.md) |
| [withDeclaringType](with-declaring-type.md) | `fun withDeclaringType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [LocalCode.declaringType](../declaring-type.md) |
| [withInnerTypes](with-inner-types.md) | `fun withInnerTypes(value: List<`[`TypeDeclaration`](../../-type-declaration/index.md)`>): Builder`<br>See [T.innerTypes](#) |
| [withInvokeType](with-invoke-type.md) | `fun withInvokeType(value: `[`InvokeType`](../../-invoke-type/index.md)`): Builder`<br>See [LocalCode.invokeType](../invoke-type.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [withInnerTypes](../../-inner-types-holder/-builder/with-inner-types.md) | `open fun withInnerTypes(vararg values: `[`TypeDeclaration`](../../-type-declaration/index.md)`): S`<br>See [T.innerTypes](../../-inner-types-holder/inner-types.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`LocalCode`](../index.md)`): Builder` |
