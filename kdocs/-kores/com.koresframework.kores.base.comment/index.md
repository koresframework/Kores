//[Kores](../../index.md)/[com.koresframework.kores.base.comment](index.md)

# Package com.koresframework.kores.base.comment

## Types

| Name | Summary |
|---|---|
| [Code](-code/index.md) | [jvm]<br>data class [Code](-code/index.md)(**code**: [Code.CodeNode](-code/-code-node/index.md)) : [Comment](-comment/index.md)<br>Code comment |
| [Comment](-comment/index.md) | [jvm]<br>interface [Comment](-comment/index.md) : [KoresPart](../com.koresframework.kores/-kores-part/index.md)<br>Comment |
| [CommentHolder](-comment-holder/index.md) | [jvm]<br>interface [CommentHolder](-comment-holder/index.md) : [KoresPart](../com.koresframework.kores/-kores-part/index.md)<br>Hold comments and documentation. |
| [Comments](-comments/index.md) | [jvm]<br>data class [Comments](-comments/index.md)(**comments**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Comment](-comment/index.md)>, **type**: [Comments.Type](-comments/-type/index.md)) : [KoresPart](../com.koresframework.kores/-kores-part/index.md), [Instruction](../com.koresframework.kores/-instruction/index.md)<br>Hold a list of comments. |
| [Link](-link/index.md) | [jvm]<br>data class [Link](-link/index.md)(**name**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, **target**: [Link.LinkTarget](-link/-link-target/index.md)) : [Comment](-comment/index.md)<br>Link comment: comment linking to an element or a url |
| [Plain](-plain/index.md) | [jvm]<br>data class [Plain](-plain/index.md)(**text**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [Comment](-comment/index.md)<br>Plain comment (like texts) |
