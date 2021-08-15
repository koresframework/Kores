//[Kores](../../../../index.md)/[com.koresframework.kores.processor](../../index.md)/[ValidationEnvironment](../index.md)/[Impl](index.md)

# Impl

[jvm]\
class [Impl](index.md)(**data**: TypedData) : [ValidationEnvironment](../index.md)

Common implementation of [ValidationEnvironment](../index.md)

## Constructors

| | |
|---|---|
| [Impl](-impl.md) | [jvm]<br>fun [Impl](-impl.md)(data: TypedData) |

## Functions

| Name | Summary |
|---|---|
| [addMessage](add-message.md) | [jvm]<br>open override fun [addMessage](add-message.md)(message: [ValidationMessage](../../-validation-message/index.md))<br>Adds a [ValidationMessage](../../-validation-message/index.md) to index. |
| [enterInspectionOf](enter-inspection-of.md) | [jvm]<br>open override fun [enterInspectionOf](enter-inspection-of.md)(part: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html))<br>Adds [part](enter-inspection-of.md) to inspection context |
| [enterSession](enter-session.md) | [jvm]<br>open override fun [enterSession](enter-session.md)(): [ValidationEnvironment.Session](../-session/index.md)<br>Enters a session, a session is used to keep track about all messages added after [enterSession](enter-session.md) invocation. |
| [exitInspectionOf](exit-inspection-of.md) | [jvm]<br>open override fun [exitInspectionOf](exit-inspection-of.md)(part: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html))<br>Exits the inspection of [part](exit-inspection-of.md). |
| [exitSession](exit-session.md) | [jvm]<br>open override fun [exitSession](exit-session.md)(): [ValidationEnvironment.Session](../-session/index.md)<br>Exists current session. |
| [toString](to-string.md) | [jvm]<br>open override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Properties

| Name | Summary |
|---|---|
| [context](context.md) | [jvm]<br>open override val [context](context.md): Context<br>Current context. |
| [data](data.md) | [jvm]<br>open override val [data](data.md): TypedData<br>Data |
| [validationMessages](validation-messages.md) | [jvm]<br>open override val [validationMessages](validation-messages.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[ContextedValidationMessage](../../-contexted-validation-message/index.md)><br>Immutable view list of indexed contexted validation messages. |
