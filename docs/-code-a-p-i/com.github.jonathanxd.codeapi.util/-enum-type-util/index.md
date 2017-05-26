[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.util](../index.md) / [EnumTypeUtil](.)

# EnumTypeUtil

`object EnumTypeUtil : Any`

Enum type utility

### Functions

| Name | Summary |
|---|---|
| [resolve](resolve.md) | `fun resolve(p: `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`, aSwitch: <ERROR CLASS><`[`SwitchStatement`](../../com.github.jonathanxd.codeapi.base/-switch-statement/index.md)`>): Int`<br>Try to resolve int value of part [p](resolve.md#com.github.jonathanxd.codeapi.util.EnumTypeUtil$resolve(com.github.jonathanxd.codeapi.CodePart, ((com.github.jonathanxd.codeapi.base.SwitchStatement)))/p). If is a numeric literal, returns the numeric value of
the literal, if is a string literal, returns the hashcode of the string, if is a [EnumValue](../../com.github.jonathanxd.codeapi.base/-enum-value/index.md), tries
to resolve the ordinal value. |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
