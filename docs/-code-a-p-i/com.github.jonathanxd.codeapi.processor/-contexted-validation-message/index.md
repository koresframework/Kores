[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.processor](../index.md) / [ContextedValidationMessage](.)

# ContextedValidationMessage

`data class ContextedValidationMessage : Any`

Validation message with a [context](context.md).

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ContextedValidationMessage(message: `[`ValidationMessage`](../-validation-message/index.md)`, context: List<Any>)`<br>Validation message with a [context](-init-.md#com.github.jonathanxd.codeapi.processor.ContextedValidationMessage$<init>(com.github.jonathanxd.codeapi.processor.ValidationMessage, kotlin.collections.List((kotlin.Any)))/context). |

### Properties

| Name | Summary |
|---|---|
| [context](context.md) | `val context: List<Any>`<br>Message context. |
| [message](message.md) | `val message: `[`ValidationMessage`](../-validation-message/index.md)<br>Validation message |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
