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
| [context](context.md) | `val context: List<Any>`<br>Immutable view list of current context (LIFO stack) |
| [data](data.md) | `val data: TypedData`<br>Data |
| [validationMessages](validation-messages.md) | `val validationMessages: List<`[`ContextedValidationMessage`](../../-contexted-validation-message/index.md)`>`<br>Immutable view list of indexed contexted validation messages. |

### Functions

| Name | Summary |
|---|---|
| [addMessage](add-message.md) | `fun addMessage(message: `[`ValidationMessage`](../../-validation-message/index.md)`): Unit`<br>Adds a [ValidationMessage](../../-validation-message/index.md) to index. |
| [enterInspectionOf](enter-inspection-of.md) | `fun enterInspectionOf(part: Any): Unit`<br>Adds [part](enter-inspection-of.md#com.github.jonathanxd.codeapi.processor.ValidationEnvironment.Impl$enterInspectionOf(kotlin.Any)/part) to inspection context |
| [exitInspectionOf](exit-inspection-of.md) | `fun exitInspectionOf(part: Any): Unit`<br>Exits the inspection of [part](exit-inspection-of.md#com.github.jonathanxd.codeapi.processor.ValidationEnvironment.Impl$exitInspectionOf(kotlin.Any)/part). This method may throw [UnexpectedInspectionContext](../../-unexpected-inspection-context/index.md), if
the last value of inspection context is not [Any.equals](#) to [part](exit-inspection-of.md#com.github.jonathanxd.codeapi.processor.ValidationEnvironment.Impl$exitInspectionOf(kotlin.Any)/part). |
