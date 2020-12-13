//[Kores](../index.md)/[com.github.jonathanxd.kores.base.comment](index.md)



# Package com.github.jonathanxd.kores.base.comment  


## Types  
  
|  Name|  Summary| 
|---|---|
| <a name="com.github.jonathanxd.kores.base.comment/Code///PointingToDeclaration/"></a>[Code](-code/index.md)| <a name="com.github.jonathanxd.kores.base.comment/Code///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>data class [Code](-code/index.md)(**code**: [Code.CodeNode](-code/-code-node/index.md)) : [Comment](-comment/index.md)  <br>More info  <br>Code comment  <br><br><br>
| <a name="com.github.jonathanxd.kores.base.comment/Comment///PointingToDeclaration/"></a>[Comment](-comment/index.md)| <a name="com.github.jonathanxd.kores.base.comment/Comment///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>interface [Comment](-comment/index.md) : [KoresPart](../com.github.jonathanxd.kores/-kores-part/index.md)  <br>More info  <br>Comment  <br><br><br>
| <a name="com.github.jonathanxd.kores.base.comment/CommentHolder///PointingToDeclaration/"></a>[CommentHolder](-comment-holder/index.md)| <a name="com.github.jonathanxd.kores.base.comment/CommentHolder///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>interface [CommentHolder](-comment-holder/index.md) : [KoresPart](../com.github.jonathanxd.kores/-kores-part/index.md)  <br>More info  <br>Hold comments and documentation.  <br><br><br>
| <a name="com.github.jonathanxd.kores.base.comment/Comments///PointingToDeclaration/"></a>[Comments](-comments/index.md)| <a name="com.github.jonathanxd.kores.base.comment/Comments///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>data class [Comments](-comments/index.md)(**comments**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Comment](-comment/index.md)>, **type**: [Comments.Type](-comments/-type/index.md)) : [KoresPart](../com.github.jonathanxd.kores/-kores-part/index.md), [Instruction](../com.github.jonathanxd.kores/-instruction/index.md)  <br>More info  <br>Hold a list of comments.  <br><br><br>
| <a name="com.github.jonathanxd.kores.base.comment/Link///PointingToDeclaration/"></a>[Link](-link/index.md)| <a name="com.github.jonathanxd.kores.base.comment/Link///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>data class [Link](-link/index.md)(**name**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, **target**: [Link.LinkTarget](-link/-link-target/index.md)) : [Comment](-comment/index.md)  <br>More info  <br>Link comment: comment linking to an element or a url  <br><br><br>
| <a name="com.github.jonathanxd.kores.base.comment/Plain///PointingToDeclaration/"></a>[Plain](-plain/index.md)| <a name="com.github.jonathanxd.kores.base.comment/Plain///PointingToDeclaration/"></a>[jvm]  <br>Content  <br>data class [Plain](-plain/index.md)(**text**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [Comment](-comment/index.md)  <br>More info  <br>Plain comment (like texts)  <br><br><br>

