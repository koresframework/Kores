[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.util](../index.md) / [Alias](.)

# Alias

`sealed class Alias : Any`

Aliases, only use alias in supported contexts.

Example of supported contexts: Method Invocation Target, Field Access Target, Local code declaring type.

### Types

| Name | Summary |
|---|---|
| [INTERFACE](-i-n-t-e-r-f-a-c-e/index.md) | `data class INTERFACE : Alias, `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)<br>Interface extension localization. |
| [SUPER](-s-u-p-e-r/index.md) | `object SUPER : Alias, `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)<br>Super class localization |
| [THIS](-t-h-i-s/index.md) | `object THIS : Alias, `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)<br>Current class localization. |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |

### Inheritors

| Name | Summary |
|---|---|
| [INTERFACE](-i-n-t-e-r-f-a-c-e/index.md) | `data class INTERFACE : Alias, `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)<br>Interface extension localization. |
| [SUPER](-s-u-p-e-r/index.md) | `object SUPER : Alias, `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)<br>Super class localization |
| [THIS](-t-h-i-s/index.md) | `object THIS : Alias, `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)<br>Current class localization. |
