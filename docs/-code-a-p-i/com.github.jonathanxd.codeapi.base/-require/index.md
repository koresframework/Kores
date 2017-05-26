[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [Require](.)

# Require

`data class Require : Any`

Module requires statement

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Require(module: `[`ModuleReference`](../-module-reference/index.md)`, modifiers: Set<`[`CodeModifier`](../-code-modifier/index.md)`>)`<br>Module requires statement |

### Properties

| Name | Summary |
|---|---|
| [modifiers](modifiers.md) | `val modifiers: Set<`[`CodeModifier`](../-code-modifier/index.md)`>`<br>Modifiers. |
| [module](module.md) | `val module: `[`ModuleReference`](../-module-reference/index.md)<br>Module to require. |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
