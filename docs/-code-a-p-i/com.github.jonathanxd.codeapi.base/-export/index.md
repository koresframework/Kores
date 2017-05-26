[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [Export](.)

# Export

`data class Export : Any`

Exports [module](module.md) to modules [to](to.md).

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Export(module: `[`ModuleReference`](../-module-reference/index.md)`, to: List<`[`ModuleReference`](../-module-reference/index.md)`>)`<br>Exports [module](-init-.md#com.github.jonathanxd.codeapi.base.Export$<init>(com.github.jonathanxd.codeapi.base.ModuleReference, kotlin.collections.List((com.github.jonathanxd.codeapi.base.ModuleReference)))/module) to modules [to](-init-.md#com.github.jonathanxd.codeapi.base.Export$<init>(com.github.jonathanxd.codeapi.base.ModuleReference, kotlin.collections.List((com.github.jonathanxd.codeapi.base.ModuleReference)))/to). |

### Properties

| Name | Summary |
|---|---|
| [module](module.md) | `val module: `[`ModuleReference`](../-module-reference/index.md)<br>Modules to export. |
| [to](to.md) | `val to: List<`[`ModuleReference`](../-module-reference/index.md)`>`<br>Modules to export to. (Empty list to export to all modules). |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
