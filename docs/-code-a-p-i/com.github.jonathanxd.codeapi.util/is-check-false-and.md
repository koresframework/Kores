[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.util](index.md) / [isCheckFalseAnd](.)

# isCheckFalseAnd

`inline fun `[`IfExpr`](../com.github.jonathanxd.codeapi.base/-if-expr/index.md)`.isCheckFalseAnd(predicate: (`[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Returns `true` if `receiver` [IfExpr](../com.github.jonathanxd.codeapi.base/-if-expr/index.md) is a check of [instruction](../com.github.jonathanxd.codeapi/-code-instruction.md) equality to `false` constant
and [predicate](is-check-false-and.md#com.github.jonathanxd.codeapi.util$isCheckFalseAnd(com.github.jonathanxd.codeapi.base.IfExpr, kotlin.Function1((com.github.jonathanxd.codeapi.CodeInstruction, kotlin.Boolean)))/predicate) returns true for the [instruction](../com.github.jonathanxd.codeapi/-code-instruction.md).

