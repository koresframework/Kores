[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [Cast](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-typed/-builder/index.md)`<`[`Cast`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`Cast`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [castedPart](casted-part.md) | `lateinit var castedPart: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md) |
| [originalType](original-type.md) | `var originalType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?` |
| [targetType](target-type.md) | `lateinit var targetType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`Cast`](../index.md)<br>Build the object of type [T](#). |
| [castedPart](casted-part.md) | `fun castedPart(value: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): Builder`<br>See [Cast.castedPart](../casted-part.md) |
| [originalType](original-type.md) | `fun originalType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?): Builder`<br>See [Cast.originalType](../original-type.md) |
| [targetType](target-type.md) | `fun targetType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [Cast.targetType](../target-type.md) |
| [type](type.md) | `fun type(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [T.type](#) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`Cast`](../index.md)`): Builder` |
