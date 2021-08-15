//[Kores](../../../../index.md)/[com.koresframework.kores.base.comment](../../index.md)/[CommentHolder](../index.md)/[Builder](index.md)

# Builder

[jvm]\
interface [Builder](index.md)<out [T](index.md) : [CommentHolder](../index.md), [S](index.md) : [CommentHolder.Builder](index.md)<[T](index.md), [S](index.md)>> : [Builder](../../../com.koresframework.kores.builder/-builder/index.md)<[T](index.md), [S](index.md)>

## Functions

| Name | Summary |
|---|---|
| [build](../../../com.koresframework.kores.builder/-builder/build.md) | [jvm]<br>abstract fun [build](../../../com.koresframework.kores.builder/-builder/build.md)(): [T](index.md)<br>Build the object of type [T](../../../com.koresframework.kores.builder/-builder/index.md). |
| [comments](comments.md) | [jvm]<br>abstract fun [comments](comments.md)(value: [Comments](../../-comments/index.md)): [S](index.md)<br>See [CommentHolder.comments](../comments.md) |

## Inheritors

| Name |
|---|
| [AnnotationProperty](../../../com.koresframework.kores.base/-annotation-property/-builder/index.md) |
| [FieldDeclaration](../../../com.koresframework.kores.base/-field-declaration/-builder/index.md) |
| [MethodDeclarationBase](../../../com.koresframework.kores.base/-method-declaration-base/-builder/index.md) |
| [TypeDeclaration](../../../com.koresframework.kores.base/-type-declaration/-builder/index.md) |
