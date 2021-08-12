//[Kores](../../../index.md)/[com.github.jonathanxd.kores.processor](../index.md)/[ValidatorManager](index.md)

# ValidatorManager

[jvm]\
interface [ValidatorManager](index.md)

Manages all [Validators](../-validator/index.md) used to validate [part](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html).

## Functions

| Name | Summary |
|---|---|
| [createData](create-data.md) | [jvm]<br>open fun [createData](create-data.md)(): TypedData<br>Creates default TypedData instance. |
| [createEnvironment](create-environment.md) | [jvm]<br>open fun [createEnvironment](create-environment.md)(data: TypedData): [ValidationEnvironment](../-validation-environment/index.md)<br>Creates default [ValidationEnvironment](../-validation-environment/index.md) |
| [registerValidator](register-validator.md) | [jvm]<br>abstract fun <[P](register-validator.md)> [registerValidator](register-validator.md)(validator: [Validator](../-validator/index.md)<[P](register-validator.md)>, type: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<[P](register-validator.md)>)<br>Registers a custom [validator](register-validator.md) of [KoresPart](../../com.github.jonathanxd.kores/-kores-part/index.md) of [type](register-validator.md). |
| [validate](validate.md) | [jvm]<br>open fun [validate](validate.md)(part: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), data: TypedData, environment: [ValidationEnvironment](../-validation-environment/index.md)? = null): [ValidationEnvironment](../-validation-environment/index.md)<br>Validates [part](validate.md) and return environment used to validate.<br>[jvm]<br>abstract fun <[P](validate.md)> [validate](validate.md)(type: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<out [P](validate.md)>, part: [P](validate.md), data: TypedData, environment: [ValidationEnvironment](../-validation-environment/index.md)? = null): [ValidationEnvironment](../-validation-environment/index.md)<br>Validates [part](validate.md) of type [type](validate.md) and return environment used to validate. |

## Inheritors

| Name |
|---|
| [VoidValidatorManager](../-void-validator-manager/index.md) |
| [AbstractValidatorManager](../-abstract-validator-manager/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [registerValidator](../register-validator.md) | [jvm]<br>inline fun <[P](../register-validator.md)> [ValidatorManager](index.md).[registerValidator](../register-validator.md)(validator: [Validator](../-validator/index.md)<[P](../register-validator.md)>)<br>Registers a custom [validator](../register-validator.md) of [KoresPart](../../com.github.jonathanxd.kores/-kores-part/index.md) of type [P](../register-validator.md). |
| [validatePart](../validate-part.md) | [jvm]<br>inline fun <[P](../validate-part.md)> [ValidatorManager](index.md).[validatePart](../validate-part.md)(part: [P](../validate-part.md), data: TypedData): [ValidationEnvironment](../-validation-environment/index.md)<br>Validates [part](../validate-part.md) of type [P](../validate-part.md). |
