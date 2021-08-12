//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.type](../../index.md)/[AnnotatedKoresType](../index.md)/[Builder](index.md)

# Builder

[jvm]\
interface [Builder](index.md)<out [T](index.md) : [AnnotatedKoresType](../index.md), [S](index.md) : [AnnotatedKoresType.Builder](index.md)<[T](index.md), [S](index.md)>> : [Builder](../../../com.github.jonathanxd.kores.builder/-builder/index.md)<[T](index.md), [S](index.md)>

## Functions

| Name | Summary |
|---|---|
| [addAnnotation](add-annotation.md) | [jvm]<br>abstract fun [addAnnotation](add-annotation.md)(annotation: [Annotation](../../../com.github.jonathanxd.kores.base/-annotation/index.md)): [AnnotatedKoresType.Builder](index.md)<[T](index.md), [S](index.md)><br>Adds an [Annotation](../../../com.github.jonathanxd.kores.base/-annotation/index.md) to [AnnotatedKoresType.annotations](../annotations.md). |
| [annotatedType](annotated-type.md) | [jvm]<br>abstract fun [annotatedType](annotated-type.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [AnnotatedKoresType.Builder](index.md)<[T](index.md), [S](index.md)><br>The [type](annotated-type.md) that is annotated with [annotations](annotations.md). |
| [annotations](annotations.md) | [jvm]<br>open fun [annotations](annotations.md)(vararg annotations: [Annotation](../../../com.github.jonathanxd.kores.base/-annotation/index.md)): [AnnotatedKoresType.Builder](index.md)<[T](index.md), [S](index.md)><br>abstract fun [annotations](annotations.md)(annotations: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Annotation](../../../com.github.jonathanxd.kores.base/-annotation/index.md)>): [AnnotatedKoresType.Builder](index.md)<[T](index.md), [S](index.md)><br>Defines [AnnotatedKoresType.annotations](../annotations.md). |
| [build](../../../com.github.jonathanxd.kores.builder/-builder/build.md) | [jvm]<br>abstract fun [build](../../../com.github.jonathanxd.kores.builder/-builder/build.md)(): [T](index.md)<br>Build the object of type [T](../../../com.github.jonathanxd.kores.builder/-builder/index.md). |

## Inheritors

| Name |
|---|
| [AnnotatedKoresType.Abstract](../-abstract/-builder-impl/index.md) |
| [AnnotatedKoresType.GenericAnnotatedKoresType](../-generic-annotated-kores-type/-generic-builder/index.md) |
