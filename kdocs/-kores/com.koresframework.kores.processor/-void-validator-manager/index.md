//[Kores](../../../index.md)/[com.koresframework.kores.processor](../index.md)/[VoidValidatorManager](index.md)

# VoidValidatorManager

[jvm]\
object [VoidValidatorManager](index.md) : [ValidatorManager](../-validator-manager/index.md)

**Only a void implementation**, this class does nothing, literally.

## Functions

| Name | Summary |
|---|---|
| [createData](../-validator-manager/create-data.md) | [jvm]<br>open fun [createData](../-validator-manager/create-data.md)(): TypedData<br>Creates default TypedData instance. |
| [createEnvironment](../-validator-manager/create-environment.md) | [jvm]<br>open fun [createEnvironment](../-validator-manager/create-environment.md)(data: TypedData): [ValidationEnvironment](../-validation-environment/index.md)<br>Creates default [ValidationEnvironment](../-validation-environment/index.md) |
| [registerValidator](register-validator.md) | [jvm]<br>open override fun <[P](register-validator.md)> [registerValidator](register-validator.md)(validator: [Validator](../-validator/index.md)<[P](register-validator.md)>, type: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<[P](register-validator.md)>)<br>Registers a custom [validator](register-validator.md) of [KoresPart](../../com.koresframework.kores/-kores-part/index.md) of [type](register-validator.md). |
| [validate](../-validator-manager/validate.md) | [jvm]<br>open fun [validate](../-validator-manager/validate.md)(part: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), data: TypedData, environment: [ValidationEnvironment](../-validation-environment/index.md)? = null): [ValidationEnvironment](../-validation-environment/index.md)<br>Validates [part](../-validator-manager/validate.md) and return environment used to validate.<br>[jvm]<br>open override fun <[P](validate.md)> [validate](validate.md)(type: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<out [P](validate.md)>, part: [P](validate.md), data: TypedData, environment: [ValidationEnvironment](../-validation-environment/index.md)?): [ValidationEnvironment](../-validation-environment/index.md)<br>Validates [part](validate.md) of type [type](validate.md) and return environment used to validate. |
