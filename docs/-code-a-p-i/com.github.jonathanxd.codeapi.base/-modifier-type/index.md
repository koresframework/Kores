[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [ModifierType](.)

# ModifierType

`enum class ModifierType`

Modifier type enum.

### Enum Values

| Name | Summary |
|---|---|
| [VISIBILITY](-v-i-s-i-b-i-l-i-t-y.md) | <ul><li>No Visibility Modifiers</li> <li>Public, Protected Private</li></ul> |
| [CONCURRENCY](-c-o-n-c-u-r-r-e-n-c-y.md) | <ul><li>Synchronized</li> <li>Volatile</li></ul> |
| [SERIALIZATION](-s-e-r-i-a-l-i-z-a-t-i-o-n.md) | <ul><li>Transient</li></ul> |
| [ABSTRACTION](-a-b-s-t-r-a-c-t-i-o-n.md) | <ul><li>Default</li> <li>Abstract</li></ul> |
| [OTHER](-o-t-h-e-r.md) | <ul><li>Other Modifiers like: Static, Final</li></ul> |
| [MODULE](-m-o-d-u-l-e.md) | Java 9 module modifiers |

### Extension Functions

| Name | Summary |
|---|---|
| [annotationValue](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/annotation-value.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.annotationValue(rType: Class<*>): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) |
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?.asString(simple: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)<br>Convert this value to a literal |
| [toLiteralOrNull](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal-or-null.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteralOrNull(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
