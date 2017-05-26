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
| [castedPart](casted-part.md) | `lateinit var castedPart: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [originalType](original-type.md) | `var originalType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?` |
| [targetType](target-type.md) | `lateinit var targetType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`Cast`](../index.md)<br>Build the object of type [T](#). |
| [withCastedPart](with-casted-part.md) | `fun withCastedPart(value: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`): Builder`<br>See [Cast.castedPart](../casted-part.md) |
| [withOriginalType](with-original-type.md) | `fun withOriginalType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?): Builder`<br>See [Cast.originalType](../original-type.md) |
| [withTargetType](with-target-type.md) | `fun withTargetType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [Cast.targetType](../target-type.md) |
| [withType](with-type.md) | `fun withType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [T.type](#) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`Cast`](../index.md)`): Builder` |
