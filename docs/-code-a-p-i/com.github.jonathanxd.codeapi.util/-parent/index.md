[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.util](../index.md) / [Parent](.)

# Parent

`data class Parent<out V, O> : Any`

Parent utility.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Parent(value: V, owner: O, parent: Parent<*, O>?)`<br>Parent utility. |

### Properties

| Name | Summary |
|---|---|
| [owner](owner.md) | `val owner: O` |
| [parent](parent.md) | `val parent: Parent<*, O>?` |
| [value](value.md) | `val value: V` |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
