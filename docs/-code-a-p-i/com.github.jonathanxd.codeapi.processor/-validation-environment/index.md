[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.processor](../index.md) / [ValidationEnvironment](.)

# ValidationEnvironment

`interface ValidationEnvironment : Any`

Validation environment to index [ValidationMessages](../-validation-message/index.md).

### Types

| Name | Summary |
|---|---|
| [Impl](-impl/index.md) | `class Impl : ValidationEnvironment`<br>Common implementation of ValidationEnvironment |
| [Session](-session/index.md) | `class Session : Any`<br>A session, used to keep track of a fragment of messages added by other validations. |

### Properties

| Name | Summary |
|---|---|
| [context](context.md) | `abstract val context: Context`<br>Current context. |
| [data](data.md) | `abstract val data: TypedData`<br>Data |
| [validationMessages](validation-messages.md) | `abstract val validationMessages: List<`[`ContextedValidationMessage`](../-contexted-validation-message/index.md)`>`<br>Immutable view list of indexed contexted validation messages. |

### Functions

| Name | Summary |
|---|---|
| [addMessage](add-message.md) | `abstract fun addMessage(message: `[`ValidationMessage`](../-validation-message/index.md)`): Unit`<br>Adds a [ValidationMessage](../-validation-message/index.md) to index. |
| [enterInspectionOf](enter-inspection-of.md) | `abstract fun enterInspectionOf(part: Any): Unit`<br>Adds [part](enter-inspection-of.md#com.github.jonathanxd.codeapi.processor.ValidationEnvironment$enterInspectionOf(kotlin.Any)/part) to inspection context |
| [enterSession](enter-session.md) | `abstract fun enterSession(): `[`Session`](-session/index.md)<br>Enters a session, a session is used to keep track about all messages
added after [enterSession](enter-session.md) invocation. |
| [exitInspectionOf](exit-inspection-of.md) | `abstract fun exitInspectionOf(part: Any): Unit`<br>Exits the inspection of [part](exit-inspection-of.md#com.github.jonathanxd.codeapi.processor.ValidationEnvironment$exitInspectionOf(kotlin.Any)/part). This method may throw [UnexpectedInspectionContext](../-unexpected-inspection-context/index.md), if
the last value of inspection context is not [Any.equals](#) to [part](exit-inspection-of.md#com.github.jonathanxd.codeapi.processor.ValidationEnvironment$exitInspectionOf(kotlin.Any)/part). |
| [exitSession](exit-session.md) | `abstract fun exitSession(): `[`Session`](-session/index.md)<br>Exists current session. |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [inspectionInContext](../inspection-in-context.md) | `fun <P, R> ValidationEnvironment.inspectionInContext(part: P, context: (P) -> R): <ERROR CLASS>`<br>Immediately enters the inspection of [part](../inspection-in-context.md#com.github.jonathanxd.codeapi.processor$inspectionInContext(com.github.jonathanxd.codeapi.processor.ValidationEnvironment, com.github.jonathanxd.codeapi.processor.inspectionInContext.P, kotlin.Function1((com.github.jonathanxd.codeapi.processor.inspectionInContext.P, com.github.jonathanxd.codeapi.processor.inspectionInContext.R)))/part), calls [context](../inspection-in-context.md#com.github.jonathanxd.codeapi.processor$inspectionInContext(com.github.jonathanxd.codeapi.processor.ValidationEnvironment, com.github.jonathanxd.codeapi.processor.inspectionInContext.P, kotlin.Function1((com.github.jonathanxd.codeapi.processor.inspectionInContext.P, com.github.jonathanxd.codeapi.processor.inspectionInContext.R)))/context) and then immediately exits the inspection of [part](../inspection-in-context.md#com.github.jonathanxd.codeapi.processor$inspectionInContext(com.github.jonathanxd.codeapi.processor.ValidationEnvironment, com.github.jonathanxd.codeapi.processor.inspectionInContext.P, kotlin.Function1((com.github.jonathanxd.codeapi.processor.inspectionInContext.P, com.github.jonathanxd.codeapi.processor.inspectionInContext.R)))/part). |
| [printMessages](../print-messages.md) | `fun ValidationEnvironment.printMessages(printer: (String) -> Unit, includeStack: Boolean = false): Unit`<br>Prints messages registered in ValidationEnvironment. |
| [sessionInContext](../session-in-context.md) | `fun <R> ValidationEnvironment.sessionInContext(context: (`[`Session`](-session/index.md)`) -> R): <ERROR CLASS>`<br>Creates session to be used only within [context](../session-in-context.md#com.github.jonathanxd.codeapi.processor$sessionInContext(com.github.jonathanxd.codeapi.processor.ValidationEnvironment, kotlin.Function1((com.github.jonathanxd.codeapi.processor.ValidationEnvironment.Session, com.github.jonathanxd.codeapi.processor.sessionInContext.R)))/context), this session is exited immediately after [context](../session-in-context.md#com.github.jonathanxd.codeapi.processor$sessionInContext(com.github.jonathanxd.codeapi.processor.ValidationEnvironment, kotlin.Function1((com.github.jonathanxd.codeapi.processor.ValidationEnvironment.Session, com.github.jonathanxd.codeapi.processor.sessionInContext.R)))/context) invocation. |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |

### Inheritors

| Name | Summary |
|---|---|
| [Impl](-impl/index.md) | `class Impl : ValidationEnvironment`<br>Common implementation of ValidationEnvironment |
