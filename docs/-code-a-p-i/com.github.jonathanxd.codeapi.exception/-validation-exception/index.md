[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.exception](../index.md) / [ValidationException](.)

# ValidationException

`class ValidationException : `[`RuntimeException`](http://docs.oracle.com/javase/6/docs/api/java/lang/RuntimeException.html)

Occurs when validation fails.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ValidationException()`<br>`ValidationException(message: String)`<br>`ValidationException(cause: Throwable)`<br>`ValidationException(message: String, cause: Throwable)`<br>`ValidationException(message: String, cause: Throwable, enableSuppression: Boolean, writableStackTrace: Boolean)`<br>`ValidationException(message: `[`ValidationMessage`](../../com.github.jonathanxd.codeapi.processor/-validation-message/index.md)`)`<br>`ValidationException(message: `[`ValidationMessage`](../../com.github.jonathanxd.codeapi.processor/-validation-message/index.md)`, cause: Throwable)`<br>`ValidationException(message: `[`ValidationMessage`](../../com.github.jonathanxd.codeapi.processor/-validation-message/index.md)`, cause: Throwable, enableSuppression: Boolean, writableStackTrace: Boolean)`<br>`ValidationException(message: `[`ContextedValidationMessage`](../../com.github.jonathanxd.codeapi.processor/-contexted-validation-message/index.md)`)`<br>`ValidationException(message: `[`ContextedValidationMessage`](../../com.github.jonathanxd.codeapi.processor/-contexted-validation-message/index.md)`, cause: Throwable)`<br>`ValidationException(message: `[`ContextedValidationMessage`](../../com.github.jonathanxd.codeapi.processor/-contexted-validation-message/index.md)`, cause: Throwable, enableSuppression: Boolean, writableStackTrace: Boolean)` |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
