[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [ArrayLoad](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-array-access/-builder/index.md)`<`[`ArrayLoad`](../index.md)`, Builder>, `[`Builder`](../../-typed/-builder/index.md)`<`[`ArrayLoad`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`ArrayLoad`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [arrayType](array-type.md) | `lateinit var arrayType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) |
| [index](--index--.md) | `lateinit var index: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [target](target.md) | `lateinit var target: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [valueType](value-type.md) | `lateinit var valueType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`ArrayLoad`](../index.md)<br>Build the object of type [T](#). |
| [withArrayType](with-array-type.md) | `fun withArrayType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [T.arrayType](#) |
| [withIndex](with-index.md) | `fun withIndex(value: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`): Builder`<br>See [ArrayLoad.index](../--index--.md) |
| [withTarget](with-target.md) | `fun withTarget(value: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`): Builder`<br>See [T.target](#) |
| [withType](with-type.md) | `fun withType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [T.type](#) |
| [withValueType](with-value-type.md) | `fun withValueType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [ArrayLoad.valueType](../value-type.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`ArrayLoad`](../index.md)`): Builder` |
