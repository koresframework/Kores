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
| [part](part.md) | `lateinit var part: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md) |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`InstanceOfCheck`](../index.md)<br>Build the object of type [T](#). |
| [withCheckType](with-check-type.md) | `fun withCheckType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [InstanceOfCheck.checkType](../check-type.md) |
| [withPart](with-part.md) | `fun withPart(value: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`): Builder`<br>See [InstanceOfCheck.part](../part.md) |
| [withType](with-type.md) | `fun withType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [T.type](#) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`InstanceOfCheck`](../index.md)`): Builder` |
