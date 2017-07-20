[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [InstanceOfCheck](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-typed/-builder/index.md)`<`[`InstanceOfCheck`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`InstanceOfCheck`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [checkType](check-type.md) | `lateinit var checkType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) |
| [part](part.md) | `lateinit var part: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md) |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`InstanceOfCheck`](../index.md)<br>Build the object of type [T](#). |
| [checkType](check-type.md) | `fun checkType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [InstanceOfCheck.checkType](../check-type.md) |
| [part](part.md) | `fun part(value: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): Builder`<br>See [InstanceOfCheck.part](../part.md) |
| [type](type.md) | `fun type(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [T.type](#) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`InstanceOfCheck`](../index.md)`): Builder` |
