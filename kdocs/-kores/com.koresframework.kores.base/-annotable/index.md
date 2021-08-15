//[Kores](../../../index.md)/[com.koresframework.kores.base](../index.md)/[Annotable](index.md)

# Annotable

[jvm]\
interface [Annotable](index.md) : [KoresPart](../../com.koresframework.kores/-kores-part/index.md)

An part that can be annotated, like methods, fields, classes, type usage, etc...

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>interface [Builder](-builder/index.md)<out [T](-builder/index.md) : [Annotable](index.md), [S](-builder/index.md) : [Annotable.Builder](-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>> : [Builder](../../com.koresframework.kores.builder/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>abstract override fun [builder](builder.md)(): [Annotable.Builder](-builder/index.md)<[Annotable](index.md), *><br>This builder may or may not accept null values, it depends on implementation. |
| [getAnnotation](get-annotation.md) | [jvm]<br>open fun [getAnnotation](get-annotation.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Annotation](../-annotation/index.md)?<br>Gets the annotation of type [type](get-annotation.md) if present, or null otherwise. |
| [getDeclaredAnnotation](get-declared-annotation.md) | [jvm]<br>open fun [getDeclaredAnnotation](get-declared-annotation.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Annotation](../-annotation/index.md)?<br>Gets the annotation of type [type](get-declared-annotation.md) if present, or null otherwise. |
| [isAnnotationPresent](is-annotation-present.md) | [jvm]<br>open fun [isAnnotationPresent](is-annotation-present.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns whether this[Annotable](index.md) contains an annotation of specified [type](is-annotation-present.md). |

## Properties

| Name | Summary |
|---|---|
| [annotations](annotations.md) | [jvm]<br>abstract val [annotations](annotations.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Annotation](../-annotation/index.md)><br>Annotations |

## Inheritors

| Name |
|---|
| [AnnotationProperty](../-annotation-property/index.md) |
| [EnumEntry](../-enum-entry/index.md) |
| [FieldDeclaration](../-field-declaration/index.md) |
| [KoresParameter](../-kores-parameter/index.md) |
| [MethodDeclarationBase](../-method-declaration-base/index.md) |
| [TypeDeclaration](../-type-declaration/index.md) |
