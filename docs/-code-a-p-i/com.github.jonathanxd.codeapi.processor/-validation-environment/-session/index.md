[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.processor](../../index.md) / [ValidationEnvironment](../index.md) / [Session](.)

# Session

`class Session : Any`

A session, used to keep track of a fragment of messages added by other validations.

**See Also**

[enterSession](../enter-session.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Session(parent: Session?, context: Context)`<br>A session, used to keep track of a fragment of messages added by other validations. |

### Properties

| Name | Summary |
|---|---|
| [context](context.md) | `val context: Context` |
| [messages](messages.md) | `val messages: List<`[`ContextedValidationMessage`](../../-contexted-validation-message/index.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [addMessage](add-message.md) | `fun addMessage(message: `[`ContextedValidationMessage`](../../-contexted-validation-message/index.md)`): Unit` |
| [anyError](any-error.md) | `fun anyError(): <ERROR CLASS>` |
