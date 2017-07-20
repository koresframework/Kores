[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.processor](../index.md) / [ValidatorManager](.)

# ValidatorManager

`interface ValidatorManager : Any`

Manages all [Validators](../-validator/index.md) used to validate [part](#).

### Functions

| Name | Summary |
|---|---|
| [createData](create-data.md) | `open fun createData(): TypedData`<br>Creates default [TypedData](#) instance. |
| [createEnvironment](create-environment.md) | `open fun createEnvironment(data: TypedData): `[`ValidationEnvironment`](../-validation-environment/index.md)<br>Creates default [ValidationEnvironment](../-validation-environment/index.md) |
| [registerValidator](register-validator.md) | `abstract fun <P> registerValidator(validator: `[`Validator`](../-validator/index.md)`<P>, type: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<P>): Unit`<br>Registers a custom [validator](register-validator.md#com.github.jonathanxd.codeapi.processor.ValidatorManager$registerValidator(com.github.jonathanxd.codeapi.processor.Validator((com.github.jonathanxd.codeapi.processor.ValidatorManager.registerValidator.P)), java.lang.Class((com.github.jonathanxd.codeapi.processor.ValidatorManager.registerValidator.P)))/validator) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) of [type](register-validator.md#com.github.jonathanxd.codeapi.processor.ValidatorManager$registerValidator(com.github.jonathanxd.codeapi.processor.Validator((com.github.jonathanxd.codeapi.processor.ValidatorManager.registerValidator.P)), java.lang.Class((com.github.jonathanxd.codeapi.processor.ValidatorManager.registerValidator.P)))/type). |
| [validate](validate.md) | `open fun validate(part: Any, data: TypedData, environment: `[`ValidationEnvironment`](../-validation-environment/index.md)`? = null): `[`ValidationEnvironment`](../-validation-environment/index.md)<br>Validates [part](validate.md#com.github.jonathanxd.codeapi.processor.ValidatorManager$validate(kotlin.Any, com.github.jonathanxd.iutils.data.TypedData, com.github.jonathanxd.codeapi.processor.ValidationEnvironment)/part) and return environment used to validate.`abstract fun <P> validate(type: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<out P>, part: P, data: TypedData, environment: `[`ValidationEnvironment`](../-validation-environment/index.md)`? = null): `[`ValidationEnvironment`](../-validation-environment/index.md)<br>Validates [part](validate.md#com.github.jonathanxd.codeapi.processor.ValidatorManager$validate(java.lang.Class((com.github.jonathanxd.codeapi.processor.ValidatorManager.validate.P)), com.github.jonathanxd.codeapi.processor.ValidatorManager.validate.P, com.github.jonathanxd.iutils.data.TypedData, com.github.jonathanxd.codeapi.processor.ValidationEnvironment)/part) of type [type](validate.md#com.github.jonathanxd.codeapi.processor.ValidatorManager$validate(java.lang.Class((com.github.jonathanxd.codeapi.processor.ValidatorManager.validate.P)), com.github.jonathanxd.codeapi.processor.ValidatorManager.validate.P, com.github.jonathanxd.iutils.data.TypedData, com.github.jonathanxd.codeapi.processor.ValidationEnvironment)/type) and return environment used to validate. |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [registerValidator](../register-validator.md) | `fun <P> ValidatorManager.registerValidator(validator: `[`Validator`](../-validator/index.md)`<P>): Unit`<br>Registers a custom [validator](../register-validator.md#com.github.jonathanxd.codeapi.processor$registerValidator(com.github.jonathanxd.codeapi.processor.ValidatorManager, com.github.jonathanxd.codeapi.processor.Validator((com.github.jonathanxd.codeapi.processor.registerValidator.P)))/validator) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) of type [P](#). |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
| [validatePart](../validate-part.md) | `fun <P> ValidatorManager.validatePart(part: P, data: TypedData): `[`ValidationEnvironment`](../-validation-environment/index.md)<br>Validates [part](../validate-part.md#com.github.jonathanxd.codeapi.processor$validatePart(com.github.jonathanxd.codeapi.processor.ValidatorManager, com.github.jonathanxd.codeapi.processor.validatePart.P, com.github.jonathanxd.iutils.data.TypedData)/part) of type [P](#). |

### Inheritors

| Name | Summary |
|---|---|
| [AbstractValidatorManager](../-abstract-validator-manager/index.md) | `abstract class AbstractValidatorManager : ValidatorManager`<br>Validator manager backed by an [MutableMap](#). |
| [VoidValidatorManager](../-void-validator-manager/index.md) | `object VoidValidatorManager : ValidatorManager`<br>**Only a void implementation**, this class does nothing, literally. |
