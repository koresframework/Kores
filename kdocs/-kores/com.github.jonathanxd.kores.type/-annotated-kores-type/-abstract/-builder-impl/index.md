//[Kores](../../../../../index.md)/[com.github.jonathanxd.kores.type](../../../index.md)/[AnnotatedKoresType](../../index.md)/[Abstract](../index.md)/[BuilderImpl](index.md)

# BuilderImpl

[jvm]\
class [BuilderImpl](index.md)<[T](index.md) : [AnnotatedKoresType.Abstract](../index.md)<[T](index.md)>>(**factory**: (type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), annotations: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Annotation](../../../../com.github.jonathanxd.kores.base/-annotation/index.md)>) -> [T](index.md)) : [AnnotatedKoresType.Builder](../../-builder/index.md)<[T](index.md), [AnnotatedKoresType.Abstract.BuilderImpl](index.md)<[T](index.md)>>

## Constructors

| | |
|---|---|
| [BuilderImpl](-builder-impl.md) | [jvm]<br>fun <[T](index.md) : [AnnotatedKoresType.Abstract](../index.md)<[T](index.md)>> [BuilderImpl](-builder-impl.md)(defaults: [AnnotatedKoresType.Abstract](../index.md)<[T](index.md)>) |

## Functions

| Name | Summary |
|---|---|
| [addAnnotation](add-annotation.md) | [jvm]<br>open override fun [addAnnotation](add-annotation.md)(annotation: [Annotation](../../../../com.github.jonathanxd.kores.base/-annotation/index.md)): [AnnotatedKoresType.Abstract.BuilderImpl](index.md)<[T](index.md)><br>Adds an [Annotation](../../../../com.github.jonathanxd.kores.base/-annotation/index.md) to [AnnotatedKoresType.annotations](../../annotations.md). |
| [annotatedType](annotated-type.md) | [jvm]<br>open override fun [annotatedType](annotated-type.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [AnnotatedKoresType.Abstract.BuilderImpl](index.md)<[T](index.md)><br>The [type](annotated-type.md) that is annotated with [annotations](annotations.md). |
| [annotations](annotations.md) | [jvm]<br>open override fun [annotations](annotations.md)(annotations: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Annotation](../../../../com.github.jonathanxd.kores.base/-annotation/index.md)>): [AnnotatedKoresType.Abstract.BuilderImpl](index.md)<[T](index.md)><br>open fun [annotations](../../-builder/annotations.md)(vararg annotations: [Annotation](../../../../com.github.jonathanxd.kores.base/-annotation/index.md)): [AnnotatedKoresType.Builder](../../-builder/index.md)<[T](index.md), [AnnotatedKoresType.Abstract.BuilderImpl](index.md)<[T](index.md)>><br>Defines [AnnotatedKoresType.annotations](../../annotations.md). |
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [T](index.md)<br>Build the object of type [T](index.md). |

## Properties

| Name | Summary |
|---|---|
| [annotatedType](annotated-type.md) | [jvm]<br>lateinit var [annotatedType](annotated-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) |
| [annotations](annotations.md) | [jvm]<br>var [annotations](annotations.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Annotation](../../../../com.github.jonathanxd.kores.base/-annotation/index.md)> |
