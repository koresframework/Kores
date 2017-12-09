[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.processor](../index.md) / [ContextedValidationMessage](.)

# ContextedValidationMessage

`data class ContextedValidationMessage`

Validation message with a [context](context.md).

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ContextedValidationMessage(message: `[`ValidationMessage`](../-validation-message/index.md)`, context: Context)`<br>Validation message with a [context](-init-.md#com.github.jonathanxd.codeapi.processor.ContextedValidationMessage$<init>(com.github.jonathanxd.codeapi.processor.ValidationMessage, com.github.jonathanxd.iutils.processing.Context)/context). |

### Properties

| Name | Summary |
|---|---|
| [context](context.md) | `val context: Context`<br>Message context. |
| [message](message.md) | `val message: `[`ValidationMessage`](../-validation-message/index.md)<br>Validation message |

### Extension Functions

| Name | Summary |
|---|---|
| [annotationValue](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/annotation-value.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.annotationValue(rType: Class<*>): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) |
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?.asString(simple: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)<br>Convert this value to a literal |
| [toLiteralOrNull](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal-or-null.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteralOrNull(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
| [toMessage](../to-message.md) | `fun ContextedValidationMessage.toMessage(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Creates a string representation of the ContextedValidationMessage |
