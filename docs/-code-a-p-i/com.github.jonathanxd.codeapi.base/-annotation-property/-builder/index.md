[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [AnnotationProperty](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-named/-builder/index.md)`<`[`AnnotationProperty`](../index.md)`, Builder>, `[`Builder`](../../-typed/-builder/index.md)`<`[`AnnotationProperty`](../index.md)`, Builder>, `[`Builder`](../../-annotable/-builder/index.md)`<`[`AnnotationProperty`](../index.md)`, Builder>, `[`Builder`](../../-return-type-holder/-builder/index.md)`<`[`AnnotationProperty`](../index.md)`, Builder>, `[`Builder`](../../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/-builder/index.md)`<`[`AnnotationProperty`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`AnnotationProperty`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [annotations](annotations.md) | `var annotations: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Annotation`](../../-annotation/index.md)`>` |
| [comments](comments.md) | `var comments: `[`Comments`](../../../com.github.jonathanxd.codeapi.base.comment/-comments/index.md) |
| [defaultValue](default-value.md) | `var defaultValue: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?` |
| [name](name.md) | `lateinit var name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [type](type.md) | `lateinit var type: Type` |

### Functions

| Name | Summary |
|---|---|
| [annotations](annotations.md) | `fun annotations(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Annotation`](../../-annotation/index.md)`>): Builder`<br>See [T.annotations](#) |
| [build](build.md) | `fun build(): `[`AnnotationProperty`](../index.md)<br>Build the object of type [T](#). |
| [comments](comments.md) | `fun comments(value: `[`Comments`](../../../com.github.jonathanxd.codeapi.base.comment/-comments/index.md)`): Builder`<br>See [T.comments](#) |
| [defaultValue](default-value.md) | `fun defaultValue(value: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?): Builder`<br>See [AnnotationProperty.defaultValue](../default-value.md) |
| [name](name.md) | `fun name(value: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Builder` |
| [returnType](return-type.md) | `fun returnType(value: Type): Builder`<br>See [T.returnType](#) |
| [type](type.md) | `fun type(value: Type): Builder`<br>See [T.type](#) |

### Inherited Functions

| Name | Summary |
|---|---|
| [annotations](../../-annotable/-builder/annotations.md) | `open fun annotations(vararg values: `[`Annotation`](../../-annotation/index.md)`): S`<br>See [T.annotations](../../-annotable/-builder/annotations.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`AnnotationProperty`](../index.md)`): Builder` |
