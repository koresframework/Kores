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
| [annotations](annotations.md) | `var annotations: List<`[`Annotation`](../../-annotation/index.md)`>` |
| [comments](comments.md) | `var comments: `[`Comments`](../../../com.github.jonathanxd.codeapi.base.comment/-comments/index.md) |
| [name](name.md) | `lateinit var name: String` |
| [type](type.md) | `lateinit var type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) |
| [value](value.md) | `var value: Any?` |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`AnnotationProperty`](../index.md)<br>Build the object of type [T](#). |
| [withAnnotations](with-annotations.md) | `fun withAnnotations(value: List<`[`Annotation`](../../-annotation/index.md)`>): Builder`<br>See [T.annotations](#) |
| [withComments](with-comments.md) | `fun withComments(value: `[`Comments`](../../../com.github.jonathanxd.codeapi.base.comment/-comments/index.md)`): Builder`<br>See [T.comments](#) |
| [withName](with-name.md) | `fun withName(value: String): Builder` |
| [withReturnType](with-return-type.md) | `fun withReturnType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [T.returnType](#) |
| [withType](with-type.md) | `fun withType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder`<br>See [T.type](#) |
| [withValue](with-value.md) | `fun withValue(value: Any?): Builder`<br>See [AnnotationProperty.defaultValue](../default-value.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [withAnnotations](../../-annotable/-builder/with-annotations.md) | `open fun withAnnotations(vararg values: `[`Annotation`](../../-annotation/index.md)`): S`<br>See [T.annotations](../../-annotable/annotations.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`AnnotationProperty`](../index.md)`): Builder` |
