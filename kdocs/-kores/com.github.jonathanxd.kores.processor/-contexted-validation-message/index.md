//[Kores](../../../index.md)/[com.github.jonathanxd.kores.processor](../index.md)/[ContextedValidationMessage](index.md)

# ContextedValidationMessage

[jvm]\
data class [ContextedValidationMessage](index.md)(**message**: [ValidationMessage](../-validation-message/index.md), **context**: Context)

Validation message with a [context](context.md).

## Constructors

| | |
|---|---|
| [ContextedValidationMessage](-contexted-validation-message.md) | [jvm]<br>fun [ContextedValidationMessage](-contexted-validation-message.md)(message: [ValidationMessage](../-validation-message/index.md), context: Context) |

## Properties

| Name | Summary |
|---|---|
| [context](context.md) | [jvm]<br>val [context](context.md): Context<br>Message context. |
| [message](message.md) | [jvm]<br>val [message](message.md): [ValidationMessage](../-validation-message/index.md)<br>Validation message |

## Extensions

| Name | Summary |
|---|---|
| [toMessage](../to-message.md) | [jvm]<br>fun [ContextedValidationMessage](index.md).[toMessage](../to-message.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Creates a string representation of the [ContextedValidationMessage](index.md) |
