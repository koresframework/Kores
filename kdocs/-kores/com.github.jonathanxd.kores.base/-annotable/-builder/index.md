//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.base](../../index.md)/[Annotable](../index.md)/[Builder](index.md)

# Builder

[jvm]\
interface [Builder](index.md)<out [T](index.md) : [Annotable](../index.md), [S](index.md) : [Annotable.Builder](index.md)<[T](index.md), [S](index.md)>> : [Builder](../../../com.github.jonathanxd.kores.builder/-builder/index.md)<[T](index.md), [S](index.md)>

## Functions

| Name | Summary |
|---|---|
| [annotations](annotations.md) | [jvm]<br>open fun [annotations](annotations.md)(vararg values: [Annotation](../../-annotation/index.md)): [S](index.md)<br>abstract fun [annotations](annotations.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Annotation](../../-annotation/index.md)>): [S](index.md)<br>See T. |
| [build](../../../com.github.jonathanxd.kores.builder/-builder/build.md) | [jvm]<br>abstract fun [build](../../../com.github.jonathanxd.kores.builder/-builder/build.md)(): [T](index.md)<br>Build the object of type [T](../../../com.github.jonathanxd.kores.builder/-builder/index.md). |

## Inheritors

| Name |
|---|
| [AnnotationProperty](../../-annotation-property/-builder/index.md) |
| [EnumEntry](../../-enum-entry/-builder/index.md) |
| [FieldDeclaration](../../-field-declaration/-builder/index.md) |
| [KoresParameter](../../-kores-parameter/-builder/index.md) |
| [MethodDeclarationBase](../../-method-declaration-base/-builder/index.md) |
| [TypeDeclaration](../../-type-declaration/-builder/index.md) |
