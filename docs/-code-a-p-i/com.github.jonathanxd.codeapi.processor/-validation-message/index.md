[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.processor](../index.md) / [ValidationMessage](.)

# ValidationMessage

`data class ValidationMessage : Any`

Validation message.

### Types

| Name | Summary |
|---|---|
| [Type](-type/index.md) | `enum class Type : Enum<`[`Type`](-type/index.md)`>` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ValidationMessage(message: String, type: `[`Type`](-type/index.md)`)`<br>Validation message. |

### Properties

| Name | Summary |
|---|---|
| [message](message.md) | `val message: String`<br>Message. |
| [type](type.md) | `val type: `[`Type`](-type/index.md)<br>Type of the message. |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
| [toMessage](../to-message.md) | `fun ValidationMessage.toMessage(): String`<br>Creates a string representation of the ValidationMessage |
