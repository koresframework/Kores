[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.processor](../index.md) / [AbstractValidatorManager](.)

# AbstractValidatorManager

`abstract class AbstractValidatorManager : `[`ValidatorManager`](../-validator-manager/index.md)

Validator manager backed by an [MutableMap](#).

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `AbstractValidatorManager()`<br>Validator manager backed by an [MutableMap](#). |

### Functions

| Name | Summary |
|---|---|
| [getValidatorOf](get-validator-of.md) | `fun <P> getValidatorOf(type: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<*>, part: P, data: TypedData, environment: `[`ValidationEnvironment`](../-validation-environment/index.md)`): `[`Validator`](../-validator/index.md)`<P>`<br>Gets processor of [type](get-validator-of.md#com.github.jonathanxd.codeapi.processor.AbstractValidatorManager$getValidatorOf(java.lang.Class((kotlin.Any)), com.github.jonathanxd.codeapi.processor.AbstractValidatorManager.getValidatorOf.P, com.github.jonathanxd.iutils.data.TypedData, com.github.jonathanxd.codeapi.processor.ValidationEnvironment)/type). |
| [registerValidator](register-validator.md) | `open fun <P> registerValidator(validator: `[`Validator`](../-validator/index.md)`<P>, type: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<P>): Unit`<br>Registers a custom [validator](register-validator.md#com.github.jonathanxd.codeapi.processor.AbstractValidatorManager$registerValidator(com.github.jonathanxd.codeapi.processor.Validator((com.github.jonathanxd.codeapi.processor.AbstractValidatorManager.registerValidator.P)), java.lang.Class((com.github.jonathanxd.codeapi.processor.AbstractValidatorManager.registerValidator.P)))/validator) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) of [type](register-validator.md#com.github.jonathanxd.codeapi.processor.AbstractValidatorManager$registerValidator(com.github.jonathanxd.codeapi.processor.Validator((com.github.jonathanxd.codeapi.processor.AbstractValidatorManager.registerValidator.P)), java.lang.Class((com.github.jonathanxd.codeapi.processor.AbstractValidatorManager.registerValidator.P)))/type). |
| [validate](validate.md) | `open fun <P> validate(type: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<out P>, part: P, data: TypedData, environment: `[`ValidationEnvironment`](../-validation-environment/index.md)`?): `[`ValidationEnvironment`](../-validation-environment/index.md)<br>Validates [part](validate.md#com.github.jonathanxd.codeapi.processor.AbstractValidatorManager$validate(java.lang.Class((com.github.jonathanxd.codeapi.processor.AbstractValidatorManager.validate.P)), com.github.jonathanxd.codeapi.processor.AbstractValidatorManager.validate.P, com.github.jonathanxd.iutils.data.TypedData, com.github.jonathanxd.codeapi.processor.ValidationEnvironment)/part) of type [type](validate.md#com.github.jonathanxd.codeapi.processor.AbstractValidatorManager$validate(java.lang.Class((com.github.jonathanxd.codeapi.processor.AbstractValidatorManager.validate.P)), com.github.jonathanxd.codeapi.processor.AbstractValidatorManager.validate.P, com.github.jonathanxd.iutils.data.TypedData, com.github.jonathanxd.codeapi.processor.ValidationEnvironment)/type) and return environment used to validate. |

### Inherited Functions

| Name | Summary |
|---|---|
| [createData](../-validator-manager/create-data.md) | `open fun createData(): TypedData`<br>Creates default [TypedData](#) instance. |
| [createEnvironment](../-validator-manager/create-environment.md) | `open fun createEnvironment(data: TypedData): `[`ValidationEnvironment`](../-validation-environment/index.md)<br>Creates default [ValidationEnvironment](../-validation-environment/index.md) |
| [validate](../-validator-manager/validate.md) | `open fun validate(part: Any, data: TypedData, environment: `[`ValidationEnvironment`](../-validation-environment/index.md)`? = null): `[`ValidationEnvironment`](../-validation-environment/index.md)<br>Validates [part](../-validator-manager/validate.md#com.github.jonathanxd.codeapi.processor.ValidatorManager$validate(kotlin.Any, com.github.jonathanxd.iutils.data.TypedData, com.github.jonathanxd.codeapi.processor.ValidationEnvironment)/part) and return environment used to validate. |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [registerValidator](../register-validator.md) | `fun <P> `[`ValidatorManager`](../-validator-manager/index.md)`.registerValidator(validator: `[`Validator`](../-validator/index.md)`<P>): Unit`<br>Registers a custom [validator](../register-validator.md#com.github.jonathanxd.codeapi.processor$registerValidator(com.github.jonathanxd.codeapi.processor.ValidatorManager, com.github.jonathanxd.codeapi.processor.Validator((com.github.jonathanxd.codeapi.processor.registerValidator.P)))/validator) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) of type [P](#). |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
| [validatePart](../validate-part.md) | `fun <P> `[`ValidatorManager`](../-validator-manager/index.md)`.validatePart(part: P, data: TypedData): `[`ValidationEnvironment`](../-validation-environment/index.md)<br>Validates [part](../validate-part.md#com.github.jonathanxd.codeapi.processor$validatePart(com.github.jonathanxd.codeapi.processor.ValidatorManager, com.github.jonathanxd.codeapi.processor.validatePart.P, com.github.jonathanxd.iutils.data.TypedData)/part) of type [P](#). |