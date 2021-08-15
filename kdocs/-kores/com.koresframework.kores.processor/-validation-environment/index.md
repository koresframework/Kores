//[Kores](../../../index.md)/[com.koresframework.kores.processor](../index.md)/[ValidationEnvironment](index.md)

# ValidationEnvironment

[jvm]\
interface [ValidationEnvironment](index.md)

Validation environment to index [ValidationMessages](../-validation-message/index.md).

## Types

| Name | Summary |
|---|---|
| [Impl](-impl/index.md) | [jvm]<br>class [Impl](-impl/index.md)(**data**: TypedData) : [ValidationEnvironment](index.md)<br>Common implementation of [ValidationEnvironment](index.md) |
| [Session](-session/index.md) | [jvm]<br>class [Session](-session/index.md)(**parent**: [ValidationEnvironment.Session](-session/index.md)?, **context**: Context)<br>A session, used to keep track of a fragment of messages added by other validations. |

## Functions

| Name | Summary |
|---|---|
| [addMessage](add-message.md) | [jvm]<br>abstract fun [addMessage](add-message.md)(message: [ValidationMessage](../-validation-message/index.md))<br>Adds a [ValidationMessage](../-validation-message/index.md) to index. |
| [enterInspectionOf](enter-inspection-of.md) | [jvm]<br>abstract fun [enterInspectionOf](enter-inspection-of.md)(part: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html))<br>Adds [part](enter-inspection-of.md) to inspection context |
| [enterSession](enter-session.md) | [jvm]<br>abstract fun [enterSession](enter-session.md)(): [ValidationEnvironment.Session](-session/index.md)<br>Enters a session, a session is used to keep track about all messages added after [enterSession](enter-session.md) invocation. |
| [exitInspectionOf](exit-inspection-of.md) | [jvm]<br>abstract fun [exitInspectionOf](exit-inspection-of.md)(part: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html))<br>Exits the inspection of [part](exit-inspection-of.md). |
| [exitSession](exit-session.md) | [jvm]<br>abstract fun [exitSession](exit-session.md)(): [ValidationEnvironment.Session](-session/index.md)<br>Exists current session. |

## Properties

| Name | Summary |
|---|---|
| [context](context.md) | [jvm]<br>abstract val [context](context.md): Context<br>Current context. |
| [data](data.md) | [jvm]<br>abstract val [data](data.md): TypedData<br>Data |
| [validationMessages](validation-messages.md) | [jvm]<br>abstract val [validationMessages](validation-messages.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[ContextedValidationMessage](../-contexted-validation-message/index.md)><br>Immutable view list of indexed contexted validation messages. |

## Inheritors

| Name |
|---|
| [ValidationEnvironment](-impl/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [inspectionInContext](../inspection-in-context.md) | [jvm]<br>inline fun <[P](../inspection-in-context.md), [R](../inspection-in-context.md)> [ValidationEnvironment](index.md).[inspectionInContext](../inspection-in-context.md)(part: [P](../inspection-in-context.md), context: ([P](../inspection-in-context.md)) -> [R](../inspection-in-context.md)): [R](../inspection-in-context.md)<br>Immediately enters the inspection of [part](../inspection-in-context.md), calls [context](../inspection-in-context.md) and then immediately exits the inspection of [part](../inspection-in-context.md). |
| [printMessages](../print-messages.md) | [jvm]<br>fun [ValidationEnvironment](index.md).[printMessages](../print-messages.md)(printer: ([String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -> [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), includeStack: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false)<br>Prints messages registered in [ValidationEnvironment](index.md). |
| [sessionInContext](../session-in-context.md) | [jvm]<br>inline fun <[R](../session-in-context.md)> [ValidationEnvironment](index.md).[sessionInContext](../session-in-context.md)(context: (session: [ValidationEnvironment.Session](-session/index.md)) -> [R](../session-in-context.md)): [R](../session-in-context.md)<br>Creates session to be used only within [context](../session-in-context.md), this session is exited immediately after [context](../session-in-context.md) invocation. |
