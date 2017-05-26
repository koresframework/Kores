[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [ArrayConstructor](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-argument-holder/-builder/index.md)`<`[`ArrayConstructor`](../index.md)`, Builder>, `[`Builder`](../../-typed/-builder/index.md)`<`[`ArrayConstructor`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`ArrayConstructor`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [arguments](arguments.md) | `var arguments: List<`[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`>` |
| [arrayType](array-type.md) | `lateinit var arrayType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) |
| [dimensions](dimensions.md) | `var dimensions: List<`[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`ArrayConstructor`](../index.md)<br>Build the object of type [T](#). |
| [withArguments](with-arguments.md) | `fun withArguments(value: List<`[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`>): Builder`<br>See [T.arguments](#) |
| [withArray](with-array.md) | `fun withArray(value: Boolean): Builder`<br>See [T.array](#) |
| [withArrayType](with-array-type.md) | `fun withArrayType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [ArrayConstructor.arrayType](../array-type.md) |
| [withDimensions](with-dimensions.md) | `fun withDimensions(value: List<`[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`>): Builder`<br>`fun withDimensions(vararg values: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`): Builder`<br>See [ArrayConstructor.dimensions](../dimensions.md) |
| [withType](with-type.md) | `fun withType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [T.type](#) |

### Inherited Functions

| Name | Summary |
|---|---|
| [withArguments](../../-argument-holder/-builder/with-arguments.md) | `open fun withArguments(vararg values: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`): S`<br>See [T.arguments](../../-argument-holder/arguments.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`ArrayConstructor`](../index.md)`): Builder` |
