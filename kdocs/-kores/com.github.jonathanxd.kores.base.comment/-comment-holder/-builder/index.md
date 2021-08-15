//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.base.comment](../../index.md)/[CommentHolder](../index.md)/[Builder](index.md)

# Builder

[jvm]\
interface [Builder](index.md)<out [T](index.md) : [CommentHolder](../index.md), [S](index.md) : [CommentHolder.Builder](index.md)<[T](index.md), [S](index.md)>> : [Builder](../../../com.github.jonathanxd.kores.builder/-builder/index.md)<[T](index.md), [S](index.md)>

## Functions

| Name | Summary |
|---|---|
| [build](../../../com.github.jonathanxd.kores.builder/-builder/build.md) | [jvm]<br>abstract fun [build](../../../com.github.jonathanxd.kores.builder/-builder/build.md)(): [T](index.md)<br>Build the object of type [T](../../../com.github.jonathanxd.kores.builder/-builder/index.md). |
| [comments](comments.md) | [jvm]<br>abstract fun [comments](comments.md)(value: [Comments](../../-comments/index.md)): [S](index.md)<br>See [CommentHolder.comments](../comments.md) |

## Inheritors

| Name |
|---|
| [AnnotationProperty](../../../com.github.jonathanxd.kores.base/-annotation-property/-builder/index.md) |
| [FieldDeclaration](../../../com.github.jonathanxd.kores.base/-field-declaration/-builder/index.md) |
| [MethodDeclarationBase](../../../com.github.jonathanxd.kores.base/-method-declaration-base/-builder/index.md) |
| [TypeDeclaration](../../../com.github.jonathanxd.kores.base/-type-declaration/-builder/index.md) |
