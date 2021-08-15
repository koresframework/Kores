//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[AnnotationProperty](index.md)

# AnnotationProperty

[jvm]\
data class [AnnotationProperty](index.md)(**comments**: [Comments](../../com.github.jonathanxd.kores.base.comment/-comments/index.md), **annotations**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Annotation](../-annotation/index.md)>, **type**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), **name**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **defaultValue**: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?) : [Named](../-named/index.md), [Typed](../-typed/index.md), [Annotable](../-annotable/index.md), [ReturnTypeHolder](../-return-type-holder/index.md), [CommentHolder](../../com.github.jonathanxd.kores.base.comment/-comment-holder/index.md)

Annotation property, this is part of [AnnotationDeclaration](../-annotation-declaration/index.md).

## Constructors

| | |
|---|---|
| [AnnotationProperty](-annotation-property.md) | [jvm]<br>fun [AnnotationProperty](-annotation-property.md)(comments: [Comments](../../com.github.jonathanxd.kores.base.comment/-comments/index.md), annotations: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Annotation](../-annotation/index.md)>, type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), defaultValue: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [Named.Builder](../-named/-builder/index.md)<[AnnotationProperty](index.md), [AnnotationProperty.Builder](-builder/index.md)> , [Typed.Builder](../-typed/-builder/index.md)<[AnnotationProperty](index.md), [AnnotationProperty.Builder](-builder/index.md)> , [Annotable.Builder](../-annotable/-builder/index.md)<[AnnotationProperty](index.md), [AnnotationProperty.Builder](-builder/index.md)> , [ReturnTypeHolder.Builder](../-return-type-holder/-builder/index.md)<[AnnotationProperty](index.md), [AnnotationProperty.Builder](-builder/index.md)> , [CommentHolder.Builder](../../com.github.jonathanxd.kores.base.comment/-comment-holder/-builder/index.md)<[AnnotationProperty](index.md), [AnnotationProperty.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [AnnotationProperty.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |
| [getAnnotation](../-annotable/get-annotation.md) | [jvm]<br>open fun [getAnnotation](../-annotable/get-annotation.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Annotation](../-annotation/index.md)?<br>Gets the annotation of type [type](../-annotable/get-annotation.md) if present, or null otherwise. |
| [getDeclaredAnnotation](../-annotable/get-declared-annotation.md) | [jvm]<br>open fun [getDeclaredAnnotation](../-annotable/get-declared-annotation.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Annotation](../-annotation/index.md)?<br>Gets the annotation of type [type](../-annotable/get-declared-annotation.md) if present, or null otherwise. |
| [isAnnotationPresent](../-annotable/is-annotation-present.md) | [jvm]<br>open fun [isAnnotationPresent](../-annotable/is-annotation-present.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns whether this[Annotable](../-annotable/index.md) contains an annotation of specified [type](../-annotable/is-annotation-present.md). |

## Properties

| Name | Summary |
|---|---|
| [annotations](annotations.md) | [jvm]<br>open override val [annotations](annotations.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Annotation](../-annotation/index.md)><br>Annotations |
| [comments](comments.md) | [jvm]<br>open override val [comments](comments.md): [Comments](../../com.github.jonathanxd.kores.base.comment/-comments/index.md)<br>All comments of this element. |
| [defaultValue](default-value.md) | [jvm]<br>val [defaultValue](default-value.md): [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?<br>Annotation default value, must be: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html), [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), [Char](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html), [Short](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short/index.html), [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html), [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), [EnumValue](../-enum-value/index.md), other [Annotation](../-annotation/index.md) or a List of one of types cited above (with or without elements). |
| [name](name.md) | [jvm]<br>open override val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Name |
| [returnType](return-type.md) | [jvm]<br>open override val [returnType](return-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Type of return |
| [type](type.md) | [jvm]<br>open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Element type |
