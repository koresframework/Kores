[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.inspect](.)

## Package com.github.jonathanxd.codeapi.inspect

### Types

| Name | Summary |
|---|---|
| [EqCheck](-eq-check/index.md) | `data class EqCheck`<br>Data class to hold equality check against a boolean constant. |
| [SourceInspect](-source-inspect/index.md) | `class SourceInspect<out R>`<br>Utility to inspect [CodeSource](../com.github.jonathanxd.codeapi/-code-source/index.md). |
| [SourceInspectBuilder](-source-inspect-builder/index.md) | `class SourceInspectBuilder<R>` |

### Extensions for External Classes

| Name | Summary |
|---|---|
| [kotlin.collections.List](kotlin.collections.-list/index.md) |  |

### Functions

| Name | Summary |
|---|---|
| [alwaysBranch](always-branch.md) | `fun `[`IfExpressionHolder`](../com.github.jonathanxd.codeapi.base/-if-expression-holder/index.md)`.alwaysBranch(matcher: (`[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [getRuntimeBooleanEqCheck](get-runtime-boolean-eq-check.md) | `fun `[`IfExpr`](../com.github.jonathanxd.codeapi.base/-if-expr/index.md)`.getRuntimeBooleanEqCheck(): `[`EqCheck`](-eq-check/index.md)`?`<br>Gets the runtime [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) value that [IfExpr](../com.github.jonathanxd.codeapi.base/-if-expr/index.md) check equality to. Returns `null` if [IfExpr](../com.github.jonathanxd.codeapi.base/-if-expr/index.md) does not check [CodeInstruction](../com.github.jonathanxd.codeapi/-code-instruction.md) against a boolean. |
| [isCheckFalse](is-check-false.md) | `fun `[`IfExpr`](../com.github.jonathanxd.codeapi.base/-if-expr/index.md)`.isCheckFalse(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns `true` if `receiver` [IfExpr](../com.github.jonathanxd.codeapi.base/-if-expr/index.md) is a check of [CodeInstruction](../com.github.jonathanxd.codeapi/-code-instruction.md) equality to `false` constant. |
| [isCheckFalseAnd](is-check-false-and.md) | `fun `[`IfExpr`](../com.github.jonathanxd.codeapi.base/-if-expr/index.md)`.isCheckFalseAnd(predicate: (`[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns `true` if `receiver` [IfExpr](../com.github.jonathanxd.codeapi.base/-if-expr/index.md) is a check of [instruction](../com.github.jonathanxd.codeapi/-code-instruction.md) equality to `false` constant and [predicate](is-check-false-and.md#com.github.jonathanxd.codeapi.inspect$isCheckFalseAnd(com.github.jonathanxd.codeapi.base.IfExpr, kotlin.Function1((com.github.jonathanxd.codeapi.CodeInstruction, kotlin.Boolean)))/predicate) returns true for the [instruction](../com.github.jonathanxd.codeapi/-code-instruction.md). |
| [isCheckTrue](is-check-true.md) | `fun `[`IfExpr`](../com.github.jonathanxd.codeapi.base/-if-expr/index.md)`.isCheckTrue(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns `true` if `receiver` [IfExpr](../com.github.jonathanxd.codeapi.base/-if-expr/index.md) is a check of [CodeInstruction](../com.github.jonathanxd.codeapi/-code-instruction.md) equality to `true` constant. |
| [isCheckTrueAnd](is-check-true-and.md) | `fun `[`IfExpr`](../com.github.jonathanxd.codeapi.base/-if-expr/index.md)`.isCheckTrueAnd(predicate: (`[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns `true` if `receiver` [IfExpr](../com.github.jonathanxd.codeapi.base/-if-expr/index.md) is a check of [instruction](../com.github.jonathanxd.codeapi/-code-instruction.md) equality to `true` constant and [predicate](is-check-true-and.md#com.github.jonathanxd.codeapi.inspect$isCheckTrueAnd(com.github.jonathanxd.codeapi.base.IfExpr, kotlin.Function1((com.github.jonathanxd.codeapi.CodeInstruction, kotlin.Boolean)))/predicate) returns true for the [instruction](../com.github.jonathanxd.codeapi/-code-instruction.md). |
| [removeRedundantNot](remove-redundant-not.md) | `fun `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`.removeRedundantNot(): `[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Removes redundant not check.`fun `[`IfExpr`](../com.github.jonathanxd.codeapi.base/-if-expr/index.md)`.removeRedundantNot(): `[`IfExpr`](../com.github.jonathanxd.codeapi.base/-if-expr/index.md)<br>Removes redundant not check. Example `if (!(!a))` is simplified to `if (a)` |
