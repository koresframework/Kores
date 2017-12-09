[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [Export](.)

# Export

`data class Export`

Exports [module](module.md) to modules [to](to.md).

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Export(module: `[`ModuleReference`](../-module-reference/index.md)`, to: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`ModuleReference`](../-module-reference/index.md)`>, modifiers: `[`Set`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)`<`[`CodeModifier`](../-code-modifier/index.md)`>)`<br>Exports [module](-init-.md#com.github.jonathanxd.codeapi.base.Export$<init>(com.github.jonathanxd.codeapi.base.ModuleReference, kotlin.collections.List((com.github.jonathanxd.codeapi.base.ModuleReference)), kotlin.collections.Set((com.github.jonathanxd.codeapi.base.CodeModifier)))/module) to modules [to](-init-.md#com.github.jonathanxd.codeapi.base.Export$<init>(com.github.jonathanxd.codeapi.base.ModuleReference, kotlin.collections.List((com.github.jonathanxd.codeapi.base.ModuleReference)), kotlin.collections.Set((com.github.jonathanxd.codeapi.base.CodeModifier)))/to). |

### Properties

| Name | Summary |
|---|---|
| [modifiers](modifiers.md) | `val modifiers: `[`Set`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)`<`[`CodeModifier`](../-code-modifier/index.md)`>`<br>Modifiers. Valid modifiers are [CodeModifier.SYNTHETIC](../-code-modifier/-s-y-n-t-h-e-t-i-c.md) and [CodeModifier.MANDATED](../-code-modifier/-m-a-n-d-a-t-e-d.md) |
| [module](module.md) | `val module: `[`ModuleReference`](../-module-reference/index.md)<br>Module to export. |
| [to](to.md) | `val to: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`ModuleReference`](../-module-reference/index.md)`>`<br>Modules to export to. (Empty list to export to all modules). |

### Extension Functions

| Name | Summary |
|---|---|
| [annotationValue](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/annotation-value.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.annotationValue(rType: Class<*>): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) |
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?.asString(simple: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)<br>Convert this value to a literal |
| [toLiteralOrNull](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal-or-null.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteralOrNull(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
