[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.processor](../../index.md) / [ValidationEnvironment](../index.md) / [Impl](.)

# Impl

`class Impl : `[`ValidationEnvironment`](../index.md)

Common implementation of [ValidationEnvironment](../index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Impl(data: TypedData)`<br>Common implementation of [ValidationEnvironment](../index.md) |

### Properties

| Name | Summary |
|---|---|
| [context](context.md) | `val context: Context`<br>Current context. |
| [data](data.md) | `val data: TypedData`<br>Data |
| [validationMessages](validation-messages.md) | `val validationMessages: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`ContextedValidationMessage`](../../-contexted-validation-message/index.md)`>`<br>Immutable view list of indexed contexted validation messages. |

### Functions

| Name | Summary |
|---|---|
| [addMessage](add-message.md) | `fun addMessage(message: `[`ValidationMessage`](../../-validation-message/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Adds a [ValidationMessage](../../-validation-message/index.md) to index. |
| [enterInspectionOf](enter-inspection-of.md) | `fun enterInspectionOf(part: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Adds [part](enter-inspection-of.md#com.github.jonathanxd.codeapi.processor.ValidationEnvironment.Impl$enterInspectionOf(kotlin.Any)/part) to inspection context |
| [enterSession](enter-session.md) | `fun enterSession(): `[`Session`](../-session/index.md)<br>Enters a session, a session is used to keep track about all messages added after [enterSession](enter-session.md) invocation. |
| [exitInspectionOf](exit-inspection-of.md) | `fun exitInspectionOf(part: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Exits the inspection of [part](exit-inspection-of.md#com.github.jonathanxd.codeapi.processor.ValidationEnvironment.Impl$exitInspectionOf(kotlin.Any)/part). This method may throw [UnexpectedInspectionContext](../../-unexpected-inspection-context/index.md), if the last value of inspection context is not [Any.equals](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html) to [part](exit-inspection-of.md#com.github.jonathanxd.codeapi.processor.ValidationEnvironment.Impl$exitInspectionOf(kotlin.Any)/part). |
| [exitSession](exit-session.md) | `fun exitSession(): `[`Session`](../-session/index.md)<br>Exists current session. |
| [toString](to-string.md) | `fun toString(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
