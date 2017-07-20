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
| [index](--index--.md) | `lateinit var index: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md) |
| [target](target.md) | `lateinit var target: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md) |
| [valueToStore](value-to-store.md) | `lateinit var valueToStore: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md) |
| [valueType](value-type.md) | `lateinit var valueType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) |

### Functions

| Name | Summary |
|---|---|
| [arrayType](array-type.md) | `fun arrayType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [T.arrayType](#) |
| [build](build.md) | `fun build(): `[`ArrayStore`](../index.md)<br>Build the object of type [T](#). |
| [index](--index--.md) | `fun index(value: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): Builder`<br>See [ArrayStore.index](../--index--.md) |
| [target](target.md) | `fun target(value: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): Builder`<br>See [T.target](#) |
| [value](value.md) | `fun value(value: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): Builder`<br>See [T.value](#) |
| [valueToStore](value-to-store.md) | `fun valueToStore(value: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): Builder`<br>See [ArrayStore.valueToStore](../value-to-store.md) |
| [valueType](value-type.md) | `fun valueType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [ArrayStore.valueType](../value-type.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`ArrayStore`](../index.md)`): Builder` |
