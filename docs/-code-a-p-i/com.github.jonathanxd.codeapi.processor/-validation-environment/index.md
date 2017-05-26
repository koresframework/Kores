[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.processor](../index.md) / [ValidationEnvironment](.)

# ValidationEnvironment

`interface ValidationEnvironment : Any`

Validation environment to index [ValidationMessages](../-validation-message/index.md).

### Types

| Name | Summary |
|---|---|
| [Impl](-impl/index.md) | `class Impl : ValidationEnvironment`<br>Common implementation of ValidationEnvironment |

### Properties

| Name | Summary |
|---|---|
| [context](context.md) | `abstract val context: List<Any>`<br>Immutable view list of current context (LIFO stack) |
| [data](data.md) | `abstract val data: TypedData`<br>Data |
| [validationMessages](validation-messages.md) | `abstract val validationMessages: List<`[`ContextedValidationMessage`](../-contexted-validation-message/index.md)`>`<br>Immutable view list of indexed contexted validation messages. |

### Functions

| Name | Summary |
|---|---|
| [addMessage](add-message.md) | `abstract fun addMessage(message: `[`ValidationMessage`](../-validation-message/index.md)`): Unit`<br>Adds a [ValidationMessage](../-validation-message/index.md) to index. |
| [enterInspectionOf](enter-inspection-of.md) | `abstract fun enterInspectionOf(part: Any): Unit`<br>Adds [part](enter-inspection-of.md#com.github.jonathanxd.codeapi.processor.ValidationEnvironment$enterInspectionOf(kotlin.Any)/part) to inspection context |
| [exitInspectionOf](exit-inspection-of.md) | `abstract fun exitInspectionOf(part: Any): Unit`<br>Exits the inspection of [part](exit-inspection-of.md#com.github.jonathanxd.codeapi.processor.ValidationEnvironment$exitInspectionOf(kotlin.Any)/part). This method may throw [UnexpectedInspectionContext](../-unexpected-inspection-context/index.md), if
the last value of inspection context is not [Any.equals](#) to [part](exit-inspection-of.md#com.github.jonathanxd.codeapi.processor.ValidationEnvironment$exitInspectionOf(kotlin.Any)/part). |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |

### Inheritors

| Name | Summary |
|---|---|
| [Impl](-impl/index.md) | `class Impl : ValidationEnvironment`<br>Common implementation of ValidationEnvironment |
