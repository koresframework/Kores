//[Kores](../../../../index.md)/[com.koresframework.kores.base](../../index.md)/[AnnotationProperty](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [Named.Builder](../../-named/-builder/index.md)<[AnnotationProperty](../index.md), [AnnotationProperty.Builder](index.md)> , [Typed.Builder](../../-typed/-builder/index.md)<[AnnotationProperty](../index.md), [AnnotationProperty.Builder](index.md)> , [Annotable.Builder](../../-annotable/-builder/index.md)<[AnnotationProperty](../index.md), [AnnotationProperty.Builder](index.md)> , [ReturnTypeHolder.Builder](../../-return-type-holder/-builder/index.md)<[AnnotationProperty](../index.md), [AnnotationProperty.Builder](index.md)> , [CommentHolder.Builder](../../../com.koresframework.kores.base.comment/-comment-holder/-builder/index.md)<[AnnotationProperty](../index.md), [AnnotationProperty.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [AnnotationProperty](../index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [annotations](../../-annotable/-builder/annotations.md) | [jvm]<br>open fun [annotations](../../-annotable/-builder/annotations.md)(vararg values: [Annotation](../../-annotation/index.md)): [AnnotationProperty.Builder](index.md)<br>open override fun [annotations](annotations.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Annotation](../../-annotation/index.md)>): [AnnotationProperty.Builder](index.md)<br>See T. |
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [AnnotationProperty](../index.md)<br>Build the object of type T. |
| [comments](comments.md) | [jvm]<br>open override fun [comments](comments.md)(value: [Comments](../../../com.koresframework.kores.base.comment/-comments/index.md)): [AnnotationProperty.Builder](index.md)<br>See [CommentHolder.comments](../../../com.koresframework.kores.base.comment/-comment-holder/comments.md) |
| [defaultValue](default-value.md) | [jvm]<br>fun [defaultValue](default-value.md)(value: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [AnnotationProperty.Builder](index.md)<br>See [AnnotationProperty.defaultValue](../default-value.md) |
| [name](name.md) | [jvm]<br>open override fun [name](name.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [AnnotationProperty.Builder](index.md) |
| [returnType](return-type.md) | [jvm]<br>open override fun [returnType](return-type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [AnnotationProperty.Builder](index.md)<br>See T. |
| [type](type.md) | [jvm]<br>open override fun [type](type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [AnnotationProperty.Builder](index.md)<br>See T. |

## Properties

| Name | Summary |
|---|---|
| [annotations](annotations.md) | [jvm]<br>var [annotations](annotations.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Annotation](../../-annotation/index.md)> |
| [comments](comments.md) | [jvm]<br>var [comments](comments.md): [Comments](../../../com.koresframework.kores.base.comment/-comments/index.md) |
| [defaultValue](default-value.md) | [jvm]<br>var [defaultValue](default-value.md): [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)? = null |
| [name](name.md) | [jvm]<br>lateinit var [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [type](type.md) | [jvm]<br>lateinit var [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) |
