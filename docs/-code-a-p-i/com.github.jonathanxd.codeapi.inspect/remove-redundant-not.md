[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.inspect](index.md) / [removeRedundantNot](.)

# removeRedundantNot

`fun `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`.removeRedundantNot(): `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)

Removes redundant not check.

`fun `[`IfExpr`](../com.github.jonathanxd.codeapi.base/-if-expr/index.md)`.removeRedundantNot(): `[`IfExpr`](../com.github.jonathanxd.codeapi.base/-if-expr/index.md)

Removes redundant not check. Example `if (!(!a))` is simplified to `if (a)`

