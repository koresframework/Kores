[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.util](../index.md) / [kotlin.collections.List](index.md) / [alwaysBranch](.)

# alwaysBranch

`fun `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>.alwaysBranch(matcher: (`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Returns `true` if the body is only reached when [matched](always-branch.md#com.github.jonathanxd.codeapi.util$alwaysBranch(kotlin.collections.List((com.github.jonathanxd.codeapi.CodeInstruction)), kotlin.Function1((com.github.jonathanxd.codeapi.CodeInstruction, kotlin.Boolean)))/matcher) [CodeInstruction](../../com.github.jonathanxd.codeapi/-code-instruction.md) returns `true`,
assuming that `receiver` contains entirely expressions of if statement, example:

```
if (x == y && (x % 2 == 0 || x == 3))
```

* alwaysBranch returns `true` for `x == y` because always when the body of the flow is reached, `x` is equal to `y`.
* alwaysBranch returns `false` for `x % 2 == 0` because when the body of flow is reached,
`x % 2 == 0` may or may not be `true`, the same condition applies to `x == 3`.

An example of where this function can be useful:

```
if (a instanceof AccountManager) { body }
```

You can use this function to ensures that `a instanceof AccountManager` is always true when `body` is reached
to allow smart casting of `a` to `AccountManager` (inside the body).

