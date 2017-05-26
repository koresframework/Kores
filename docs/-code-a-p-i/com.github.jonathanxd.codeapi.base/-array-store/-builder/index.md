[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [ArrayStore](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-array-access/-builder/index.md)`<`[`ArrayStore`](../index.md)`, Builder>, `[`Builder`](../../-value-holder/-builder/index.md)`<`[`ArrayStore`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`ArrayStore`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [arrayType](array-type.md) | `lateinit var arrayType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) |
| [index](--index--.md) | `lateinit var index: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [target](target.md) | `lateinit var target: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [valueToStore](value-to-store.md) | `lateinit var valueToStore: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [valueType](value-type.md) | `lateinit var valueType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`ArrayStore`](../index.md)<br>Build the object of type [T](#). |
| [withArrayType](with-array-type.md) | `fun withArrayType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [T.arrayType](#) |
| [withIndex](with-index.md) | `fun withIndex(value: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`): Builder`<br>See [ArrayStore.index](../--index--.md) |
| [withTarget](with-target.md) | `fun withTarget(value: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`): Builder`<br>See [T.target](#) |
| [withValue](with-value.md) | `fun withValue(value: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`?): Builder`<br>See [T.value](#) |
| [withValueToStore](with-value-to-store.md) | `fun withValueToStore(value: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`): Builder`<br>See [ArrayStore.valueToStore](../value-to-store.md) |
| [withValueType](with-value-type.md) | `fun withValueType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [ArrayStore.valueType](../value-type.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`ArrayStore`](../index.md)`): Builder` |
