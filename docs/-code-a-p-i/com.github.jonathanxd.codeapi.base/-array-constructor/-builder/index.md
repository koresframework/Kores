[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [ArrayConstructor](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-arguments-holder/-builder/index.md)`<`[`ArrayConstructor`](../index.md)`, Builder>, `[`Builder`](../../-typed/-builder/index.md)`<`[`ArrayConstructor`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`ArrayConstructor`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [arguments](arguments.md) | `var arguments: List<`[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`>` |
| [arrayType](array-type.md) | `lateinit var arrayType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) |
| [dimensions](dimensions.md) | `var dimensions: List<`[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [arguments](arguments.md) | `fun arguments(value: List<`[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): Builder`<br>See [T.arguments](#) |
| [array](array.md) | `fun array(value: Boolean): Builder`<br>See [T.array](#) |
| [arrayType](array-type.md) | `fun arrayType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [ArrayConstructor.arrayType](../array-type.md) |
| [build](build.md) | `fun build(): `[`ArrayConstructor`](../index.md)<br>Build the object of type [T](#). |
| [dimensions](dimensions.md) | `fun dimensions(value: List<`[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): Builder`<br>`fun dimensions(vararg values: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): Builder`<br>See [ArrayConstructor.dimensions](../dimensions.md) |
| [type](type.md) | `fun type(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [T.type](#) |

### Inherited Functions

| Name | Summary |
|---|---|
| [arguments](../../-arguments-holder/-builder/arguments.md) | `open fun arguments(vararg values: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): S`<br>See [T.arguments](../../-arguments-holder/-builder/arguments.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`ArrayConstructor`](../index.md)`): Builder` |
