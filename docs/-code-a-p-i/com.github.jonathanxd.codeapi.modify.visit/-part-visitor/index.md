[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.modify.visit](../index.md) / [PartVisitor](.)

# PartVisitor

`interface PartVisitor<U : Any> : Any`

Visitor that transforms part [U](#).

### Functions

| Name | Summary |
|---|---|
| [visit](visit.md) | `abstract fun visit(codePart: U, data: TypedData, visitManager: `[`VisitManager`](../-visit-manager/index.md)`<*>): U`<br>Visits part of type [U](#). |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
