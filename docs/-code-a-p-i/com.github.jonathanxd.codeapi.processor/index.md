[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.processor](.)

## Package com.github.jonathanxd.codeapi.processor

### Types

| Name | Summary |
|---|---|
| [CodeProcessor](-code-processor/index.md) | `interface CodeProcessor<out R> : Any`<br>CodeProcessor transforms [Any](#) into [R](#). |
| [CodeValidator](-code-validator/index.md) | `interface CodeValidator : Any`<br>Validation and Validation manager. Validates and manage custom validators. |
| [ContextedValidationMessage](-contexted-validation-message/index.md) | `data class ContextedValidationMessage : Any`<br>Validation message with a [context](-contexted-validation-message/context.md). |
| [Processor](-processor/index.md) | `interface Processor<in P> : Any` |
| [ValidationEnvironment](-validation-environment/index.md) | `interface ValidationEnvironment : Any`<br>Validation environment to index [ValidationMessages](-validation-message/index.md). |
| [ValidationMessage](-validation-message/index.md) | `data class ValidationMessage : Any`<br>Validation message. |
| [Validator](-validator/index.md) | `interface Validator<in P> : Any`<br>Custom validator |
| [VoidValidator](-void-validator/index.md) | `object VoidValidator : `[`CodeValidator`](-code-validator/index.md)<br>**Only a void implementation**, this class does not validate, does not register validators,
this class does nothing, literally. |

### Exceptions

| Name | Summary |
|---|---|
| [UnexpectedInspectionContext](-unexpected-inspection-context/index.md) | `class UnexpectedInspectionContext : `[`IllegalStateException`](http://docs.oracle.com/javase/6/docs/api/java/lang/IllegalStateException.html)<br>Occurs when a unexpected inspection context is found. |

### Extensions for External Classes

| Name | Summary |
|---|---|
| [kotlin.collections.List](kotlin.collections.-list/index.md) |  |

### Functions

| Name | Summary |
|---|---|
| [error](error.md) | `fun error(message: () -> String): `[`ValidationMessage`](-validation-message/index.md)<br>Creates a error validation message. |
| [info](info.md) | `fun info(message: () -> String): `[`ValidationMessage`](-validation-message/index.md)<br>Creates a info validation message. |
| [other](other.md) | `fun other(message: () -> String): `[`ValidationMessage`](-validation-message/index.md)<br>Creates a other validation message. |
| [performance](performance.md) | `fun performance(message: () -> String): `[`ValidationMessage`](-validation-message/index.md)<br>Creates a performance validation message. |
| [registerProcessor](register-processor.md) | `fun <R, T : Any> `[`CodeProcessor`](-code-processor/index.md)`<R>.registerProcessor(processor: `[`Processor`](-processor/index.md)`<T>): Unit`<br>Registers [processor](register-processor.md#com.github.jonathanxd.codeapi.processor$registerProcessor(com.github.jonathanxd.codeapi.processor.ProcessorManager((com.github.jonathanxd.codeapi.processor.registerProcessor.R)), com.github.jonathanxd.codeapi.processor.Processor((com.github.jonathanxd.codeapi.processor.registerProcessor.T)))/processor) of [Any](#) of type: [T](#). |
| [registerSugarSyntaxProcessor](register-sugar-syntax-processor.md) | `fun <R, T : Any> `[`CodeProcessor`](-code-processor/index.md)`<R>.registerSugarSyntaxProcessor(sugarSyntaxProcessor: `[`SugarSyntaxProcessor`](../com.github.jonathanxd.codeapi.sugar/-sugar-syntax-processor/index.md)`<T>): Unit`<br>Registers a [sugarSyntaxProcessor](register-sugar-syntax-processor.md#com.github.jonathanxd.codeapi.processor$registerSugarSyntaxProcessor(com.github.jonathanxd.codeapi.processor.ProcessorManager((com.github.jonathanxd.codeapi.processor.registerSugarSyntaxProcessor.R)), com.github.jonathanxd.codeapi.sugar.SugarSyntaxProcessor((com.github.jonathanxd.codeapi.processor.registerSugarSyntaxProcessor.T)))/sugarSyntaxProcessor) of [Any](#) of type: [T](#). |
| [registerValidator](register-validator.md) | `fun <P> `[`CodeValidator`](-code-validator/index.md)`.registerValidator(validator: `[`Validator`](-validator/index.md)`<P>): Unit`<br>Registers a custom [validator](register-validator.md#com.github.jonathanxd.codeapi.processor$registerValidator(com.github.jonathanxd.codeapi.processor.ValidatorManager, com.github.jonathanxd.codeapi.processor.Validator((com.github.jonathanxd.codeapi.processor.registerValidator.P)))/validator) of [CodePart](../com.github.jonathanxd.codeapi/-code-part/index.md) of type [P](#). |
| [validatePart](validate-part.md) | `fun <P> `[`CodeValidator`](-code-validator/index.md)`.validatePart(part: P, data: TypedData): `[`ValidationEnvironment`](-validation-environment/index.md)<br>Validates [part](validate-part.md#com.github.jonathanxd.codeapi.processor$validatePart(com.github.jonathanxd.codeapi.processor.ValidatorManager, com.github.jonathanxd.codeapi.processor.validatePart.P, com.github.jonathanxd.iutils.data.TypedData)/part) of type [P](#). |
| [warning](warning.md) | `fun warning(message: () -> String): `[`ValidationMessage`](-validation-message/index.md)<br>Creates a warning validation message. |
