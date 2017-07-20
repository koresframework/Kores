[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.util](../index.md) / [State](.)

# State

`enum class State : Enum<State>`

### Enum Values

| Name | Summary |
|---|---|
| [NONE](-n-o-n-e.md) | No one matching type was found |
| [FOUND](-f-o-u-n-d.md) | Matching type found |
| [REQUIRE_SUPER](-r-e-q-u-i-r-e_-s-u-p-e-r.md) | Matching type uses a type parameter provided by super class. |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
