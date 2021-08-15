//[Kores](../../../../index.md)/[com.koresframework.kores.processor](../../index.md)/[ValidationEnvironment](../index.md)/[Session](index.md)

# Session

[jvm]\
class [Session](index.md)(**parent**: [ValidationEnvironment.Session](index.md)?, **context**: Context)

A session, used to keep track of a fragment of messages added by other validations.

## See also

jvm

| | |
|---|---|
| [com.koresframework.kores.processor.ValidationEnvironment](../enter-session.md) |  |

## Constructors

| | |
|---|---|
| [Session](-session.md) | [jvm]<br>fun [Session](-session.md)(parent: [ValidationEnvironment.Session](index.md)?, context: Context) |

## Functions

| Name | Summary |
|---|---|
| [addMessage](add-message.md) | [jvm]<br>fun [addMessage](add-message.md)(message: [ContextedValidationMessage](../../-contexted-validation-message/index.md)) |
| [anyError](any-error.md) | [jvm]<br>fun [anyError](any-error.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

## Properties

| Name | Summary |
|---|---|
| [context](context.md) | [jvm]<br>val [context](context.md): Context |
| [messages](messages.md) | [jvm]<br>val [messages](messages.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[ContextedValidationMessage](../../-contexted-validation-message/index.md)> |
