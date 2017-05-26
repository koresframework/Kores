[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [ThrowException](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<`[`ThrowException`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`ThrowException`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [partToThrow](part-to-throw.md) | `lateinit var partToThrow: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md) |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`ThrowException`](../index.md)<br>Build the object of type [T](#). |
| [withPartToThrow](with-part-to-throw.md) | `fun withPartToThrow(value: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`): Builder`<br>See [ThrowException.partToThrow](../part-to-throw.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`ThrowException`](../index.md)`): Builder` |
