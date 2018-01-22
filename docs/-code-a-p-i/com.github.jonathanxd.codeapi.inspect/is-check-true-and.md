[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.inspect](index.md) / [isCheckTrueAnd](.)

# isCheckTrueAnd

`inline fun `[`IfExpr`](../com.github.jonathanxd.codeapi.base/-if-expr/index.md)`.isCheckTrueAnd(predicate: (`[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Returns `true` if `receiver` [IfExpr](../com.github.jonathanxd.codeapi.base/-if-expr/index.md) is a check of [instruction](../com.github.jonathanxd.codeapi/-code-instruction.md) equality to `true` constant
and [predicate](is-check-true-and.md#com.github.jonathanxd.codeapi.inspect$isCheckTrueAnd(com.github.jonathanxd.codeapi.base.IfExpr, kotlin.Function1((com.github.jonathanxd.codeapi.CodeInstruction, kotlin.Boolean)))/predicate) returns true for the [instruction](../com.github.jonathanxd.codeapi/-code-instruction.md).

