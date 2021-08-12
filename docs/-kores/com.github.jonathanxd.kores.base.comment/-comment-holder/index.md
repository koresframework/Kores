//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base.comment](../index.md)/[CommentHolder](index.md)

# CommentHolder

[jvm]\
interface [CommentHolder](index.md) : [KoresPart](../../com.github.jonathanxd.kores/-kores-part/index.md)

Hold comments and documentation.

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>interface [Builder](-builder/index.md)<out [T](-builder/index.md) : [CommentHolder](index.md), [S](-builder/index.md) : [CommentHolder.Builder](-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>> : [Builder](../../com.github.jonathanxd.kores.builder/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](../../com.github.jonathanxd.kores/-kores-part/builder.md) | [jvm]<br>open fun [builder](../../com.github.jonathanxd.kores/-kores-part/builder.md)(): [Builder](../../com.github.jonathanxd.kores.builder/-builder/index.md)<[KoresPart](../../com.github.jonathanxd.kores/-kores-part/index.md), *><br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [comments](comments.md) | [jvm]<br>abstract val [comments](comments.md): [Comments](../-comments/index.md)<br>All comments of this element. |

## Inheritors

| Name |
|---|
| [AnnotationProperty](../../com.github.jonathanxd.kores.base/-annotation-property/index.md) |
| [FieldDeclaration](../../com.github.jonathanxd.kores.base/-field-declaration/index.md) |
| [MethodDeclarationBase](../../com.github.jonathanxd.kores.base/-method-declaration-base/index.md) |
| [TypeDeclaration](../../com.github.jonathanxd.kores.base/-type-declaration/index.md) |
