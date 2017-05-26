[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.base.comment](.)

## Package com.github.jonathanxd.codeapi.base.comment

### Types

| Name | Summary |
|---|---|
| [Code](-code/index.md) | `data class Code : `[`Comment`](-comment/index.md)<br>Code comment |
| [Comment](-comment/index.md) | `interface Comment : `[`CodePart`](../com.github.jonathanxd.codeapi/-code-part/index.md)<br>Comment |
| [CommentHolder](-comment-holder/index.md) | `interface CommentHolder : `[`CodePart`](../com.github.jonathanxd.codeapi/-code-part/index.md)<br>Hold comments and documentation. |
| [Comments](-comments/index.md) | `data class Comments : `[`CodePart`](../com.github.jonathanxd.codeapi/-code-part/index.md)`, `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Hold a list of comments. |
| [Link](-link/index.md) | `data class Link : `[`Comment`](-comment/index.md)<br>Link comment: comment linking to an element or a url |
| [Plain](-plain/index.md) | `data class Plain : `[`Comment`](-comment/index.md)<br>Plain comment (like texts) |
