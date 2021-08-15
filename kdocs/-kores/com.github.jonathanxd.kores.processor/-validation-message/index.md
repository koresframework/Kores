//[Kores](../../../index.md)/[com.github.jonathanxd.kores.processor](../index.md)/[ValidationMessage](index.md)

# ValidationMessage

[jvm]\
data class [ValidationMessage](index.md)(**message**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **type**: [ValidationMessage.Type](-type/index.md))

Validation message.

## Constructors

| | |
|---|---|
| [ValidationMessage](-validation-message.md) | [jvm]<br>fun [ValidationMessage](-validation-message.md)(message: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), type: [ValidationMessage.Type](-type/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Type](-type/index.md) | [jvm]<br>enum [Type](-type/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)<[ValidationMessage.Type](-type/index.md)> |

## Properties

| Name | Summary |
|---|---|
| [message](message.md) | [jvm]<br>val [message](message.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Message. |
| [type](type.md) | [jvm]<br>val [type](type.md): [ValidationMessage.Type](-type/index.md)<br>Type of the message. |

## Extensions

| Name | Summary |
|---|---|
| [toMessage](../to-message.md) | [jvm]<br>fun [ValidationMessage](index.md).[toMessage](../to-message.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Creates a string representation of the [ValidationMessage](index.md) |
