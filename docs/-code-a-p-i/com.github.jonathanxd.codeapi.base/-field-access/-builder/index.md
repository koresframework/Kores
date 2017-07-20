[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [FieldAccess](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-accessor/-builder/index.md)`<`[`FieldAccess`](../index.md)`, Builder>, `[`Builder`](../../-typed/-builder/index.md)`<`[`FieldAccess`](../index.md)`, Builder>, `[`Builder`](../../-named/-builder/index.md)`<`[`FieldAccess`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`FieldAccess`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [localization](localization.md) | `lateinit var localization: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) |
| [name](name.md) | `lateinit var name: String` |
| [target](target.md) | `lateinit var target: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md) |
| [type](type.md) | `lateinit var type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) |

### Functions

| Name | Summary |
|---|---|
| [base](base.md) | `fun base(ref: `[`FieldRef`](../../../com.github.jonathanxd.codeapi.common/-field-ref/index.md)`): <ERROR CLASS>`<br>Base this builder in [ref](base.md#com.github.jonathanxd.codeapi.base.FieldAccess.Builder$base(com.github.jonathanxd.codeapi.common.FieldRef)/ref) |
| [build](build.md) | `fun build(): `[`FieldAccess`](../index.md)<br>Build the object of type [T](#). |
| [localization](localization.md) | `fun localization(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [T.localization](#) |
| [name](name.md) | `fun name(value: String): Builder` |
| [target](target.md) | `fun target(value: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): Builder`<br>See [T.target](#) |
| [type](type.md) | `fun type(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [T.type](#) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`FieldAccess`](../index.md)`): Builder` |
