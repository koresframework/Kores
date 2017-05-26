[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [ModifierType](.)

# ModifierType

`enum class ModifierType : Enum<ModifierType>`

Modifier type enum.

### Enum Values

| Name | Summary |
|---|---|
| [VISIBILITY](-v-i-s-i-b-i-l-i-t-y.md) | <ul><li>No Visibility Modifiers</li><li>Public, Protected Private</li></ul> |
| [CONCURRENCY](-c-o-n-c-u-r-r-e-n-c-y.md) | <ul><li>Synchronized</li><li>Volatile</li></ul> |
| [SERIALIZATION](-s-e-r-i-a-l-i-z-a-t-i-o-n.md) | <ul><li>Transient</li></ul> |
| [ABSTRACTION](-a-b-s-t-r-a-c-t-i-o-n.md) | <ul><li>Default</li><li>Abstract</li></ul> |
| [OTHER](-o-t-h-e-r.md) | <ul><li>Other Modifiers like: Static, Final</li></ul> |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
