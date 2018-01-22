[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.inspect](../index.md) / [kotlin.collections.List](.)

### Extensions for kotlin.collections.List

| Name | Summary |
|---|---|
| [alwaysBranch](always-branch.md) | `fun `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>.alwaysBranch(matcher: (`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns `true` if the body is only reached when [matched](always-branch.md#com.github.jonathanxd.codeapi.inspect$alwaysBranch(kotlin.collections.List((com.github.jonathanxd.codeapi.CodeInstruction)), kotlin.Function1((com.github.jonathanxd.codeapi.CodeInstruction, kotlin.Boolean)))/matcher) [CodeInstruction](../../com.github.jonathanxd.codeapi/-code-instruction.md) returns `true`. |
| [removeRedundantNot](remove-redundant-not.md) | `fun `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>.removeRedundantNot(): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>`<br>Removes redundant not check. |
