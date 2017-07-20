[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.processor](.)

## Package com.github.jonathanxd.codeapi.processor

### Types

| Name | Summary |
|---|---|
| [AbstractProcessorManager](-abstract-processor-manager/index.md) | `abstract class AbstractProcessorManager<out R> : `[`ProcessorManager`](-processor-manager/index.md)`<R>`<br>An abstract manager backed by a [MutableMap](#). |
| [AbstractValidatorManager](-abstract-validator-manager/index.md) | `abstract class AbstractValidatorManager : `[`ValidatorManager`](-validator-manager/index.md)<br>Validator manager backed by an [MutableMap](#). |
| [ContextedValidationMessage](-contexted-validation-message/index.md) | `data class ContextedValidationMessage : Any`<br>Validation message with a [context](-contexted-validation-message/context.md). |
| [Processor](-processor/index.md) | `interface Processor<in P> : Any`<br>Process [part](#) and do required things. |
| [ProcessorManager](-processor-manager/index.md) | `interface ProcessorManager<out R> : Any`<br>ProcessorManager manages all processors required to transform [Any](#) into [R](#). |
| [ValidationEnvironment](-validation-environment/index.md) | `interface ValidationEnvironment : Any`<br>Validation environment to index [ValidationMessages](-validation-message/index.md). |
| [ValidationMessage](-validation-message/index.md) | `data class ValidationMessage : Any`<br>Validation message. |
| [Validator](-validator/index.md) | `interface Validator<in P> : Any`<br>Custom validator |
| [ValidatorManager](-validator-manager/index.md) | `interface ValidatorManager : Any`<br>Manages all [Validators](-validator/index.md) used to validate [part](#). |
| [VoidValidatorManager](-void-validator-manager/index.md) | `object VoidValidatorManager : `[`ValidatorManager`](-validator-manager/index.md)<br>**Only a void implementation**, this class does nothing, literally. |

### Exceptions

| Name | Summary |
|---|---|
| [UnexpectedInspectionContext](-unexpected-inspection-context/index.md) | `class UnexpectedInspectionContext : `[`IllegalStateException`](http://docs.oracle.com/javase/6/docs/api/java/lang/IllegalStateException.html)<br>Occurs when a unexpected inspection context is found. |

### Extensions for External Classes

| Name | Summary |
|---|---|
| [kotlin.collections.List](kotlin.collections.-list/index.md) |  |

### Properties

| Name | Summary |
|---|---|
| [FIRST_CALL](-f-i-r-s-t_-c-a-l-l.md) | `val FIRST_CALL: TypedKey<Boolean>`<br>Stores call state |
| [VALIDATE](-v-a-l-i-d-a-t-e.md) | `val VALIDATE: Option<Boolean>`<br>True to validate part before processing. |

### Functions

| Name | Summary |
|---|---|
| [error](error.md) | `fun error(message: () -> String): `[`ValidationMessage`](-validation-message/index.md)<br>Creates a error validation message. |
| [info](info.md) | `fun info(message: () -> String): `[`ValidationMessage`](-validation-message/index.md)<br>Creates a info validation message. |
| [inspectionInContext](inspection-in-context.md) | `fun <P, R> `[`ValidationEnvironment`](-validation-environment/index.md)`.inspectionInContext(part: P, context: (P) -> R): <ERROR CLASS>`<br>Immediately enters the inspection of [part](inspection-in-context.md#com.github.jonathanxd.codeapi.processor$inspectionInContext(com.github.jonathanxd.codeapi.processor.ValidationEnvironment, com.github.jonathanxd.codeapi.processor.inspectionInContext.P, kotlin.Function1((com.github.jonathanxd.codeapi.processor.inspectionInContext.P, com.github.jonathanxd.codeapi.processor.inspectionInContext.R)))/part), calls [context](inspection-in-context.md#com.github.jonathanxd.codeapi.processor$inspectionInContext(com.github.jonathanxd.codeapi.processor.ValidationEnvironment, com.github.jonathanxd.codeapi.processor.inspectionInContext.P, kotlin.Function1((com.github.jonathanxd.codeapi.processor.inspectionInContext.P, com.github.jonathanxd.codeapi.processor.inspectionInContext.R)))/context) and then immediately exits the inspection of [part](inspection-in-context.md#com.github.jonathanxd.codeapi.processor$inspectionInContext(com.github.jonathanxd.codeapi.processor.ValidationEnvironment, com.github.jonathanxd.codeapi.processor.inspectionInContext.P, kotlin.Function1((com.github.jonathanxd.codeapi.processor.inspectionInContext.P, com.github.jonathanxd.codeapi.processor.inspectionInContext.R)))/part). |
| [other](other.md) | `fun other(message: () -> String): `[`ValidationMessage`](-validation-message/index.md)<br>Creates a other validation message. |
| [performance](performance.md) | `fun performance(message: () -> String): `[`ValidationMessage`](-validation-message/index.md)<br>Creates a performance validation message. |
| [printMessages](print-messages.md) | `fun `[`ValidationEnvironment`](-validation-environment/index.md)`.printMessages(printer: (String) -> Unit, includeStack: Boolean = false): Unit`<br>Prints messages registered in [ValidationEnvironment](-validation-environment/index.md). |
| [processAs](process-as.md) | `fun <T> `[`ProcessorManager`](-processor-manager/index.md)`<*>.processAs(part: T, data: TypedData): Any?`<br>Process [part](process-as.md#com.github.jonathanxd.codeapi.processor$processAs(com.github.jonathanxd.codeapi.processor.ProcessorManager((kotlin.Any)), com.github.jonathanxd.codeapi.processor.processAs.T, com.github.jonathanxd.iutils.data.TypedData)/part) as of reified type [T](#). This function is inlined, this means that type passed to [ProcessorManager.process](-processor-manager/process.md)
will be the inferred type and not the the [part](process-as.md#com.github.jonathanxd.codeapi.processor$processAs(com.github.jonathanxd.codeapi.processor.ProcessorManager((kotlin.Any)), com.github.jonathanxd.codeapi.processor.processAs.T, com.github.jonathanxd.iutils.data.TypedData)/part) type. This is useful when you want to call a specific processor
instead of exact processor. |
| [registerProcessor](register-processor.md) | `fun <R, T : Any> `[`ProcessorManager`](-processor-manager/index.md)`<R>.registerProcessor(processor: `[`Processor`](-processor/index.md)`<T>): Unit`<br>Registers [processor](register-processor.md#com.github.jonathanxd.codeapi.processor$registerProcessor(com.github.jonathanxd.codeapi.processor.ProcessorManager((com.github.jonathanxd.codeapi.processor.registerProcessor.R)), com.github.jonathanxd.codeapi.processor.Processor((com.github.jonathanxd.codeapi.processor.registerProcessor.T)))/processor) of [Any](#) of type: [T](#). |
| [registerSugarSyntaxProcessor](register-sugar-syntax-processor.md) | `fun <R, T : Any> `[`ProcessorManager`](-processor-manager/index.md)`<R>.registerSugarSyntaxProcessor(sugarSyntaxProcessor: `[`SugarSyntaxProcessor`](../com.github.jonathanxd.codeapi.sugar/-sugar-syntax-processor/index.md)`<T>): Unit`<br>Registers a [sugarSyntaxProcessor](register-sugar-syntax-processor.md#com.github.jonathanxd.codeapi.processor$registerSugarSyntaxProcessor(com.github.jonathanxd.codeapi.processor.ProcessorManager((com.github.jonathanxd.codeapi.processor.registerSugarSyntaxProcessor.R)), com.github.jonathanxd.codeapi.sugar.SugarSyntaxProcessor((com.github.jonathanxd.codeapi.processor.registerSugarSyntaxProcessor.T)))/sugarSyntaxProcessor) of [Any](#) of type: [T](#). |
| [registerValidator](register-validator.md) | `fun <P> `[`ValidatorManager`](-validator-manager/index.md)`.registerValidator(validator: `[`Validator`](-validator/index.md)`<P>): Unit`<br>Registers a custom [validator](register-validator.md#com.github.jonathanxd.codeapi.processor$registerValidator(com.github.jonathanxd.codeapi.processor.ValidatorManager, com.github.jonathanxd.codeapi.processor.Validator((com.github.jonathanxd.codeapi.processor.registerValidator.P)))/validator) of [CodePart](../com.github.jonathanxd.codeapi/-code-part/index.md) of type [P](#). |
| [sessionInContext](session-in-context.md) | `fun <R> `[`ValidationEnvironment`](-validation-environment/index.md)`.sessionInContext(context: (`[`Session`](-validation-environment/-session/index.md)`) -> R): <ERROR CLASS>`<br>Creates session to be used only within [context](session-in-context.md#com.github.jonathanxd.codeapi.processor$sessionInContext(com.github.jonathanxd.codeapi.processor.ValidationEnvironment, kotlin.Function1((com.github.jonathanxd.codeapi.processor.ValidationEnvironment.Session, com.github.jonathanxd.codeapi.processor.sessionInContext.R)))/context), this session is exited immediately after [context](session-in-context.md#com.github.jonathanxd.codeapi.processor$sessionInContext(com.github.jonathanxd.codeapi.processor.ValidationEnvironment, kotlin.Function1((com.github.jonathanxd.codeapi.processor.ValidationEnvironment.Session, com.github.jonathanxd.codeapi.processor.sessionInContext.R)))/context) invocation. |
| [toMessage](to-message.md) | `fun `[`ValidationMessage`](-validation-message/index.md)`.toMessage(): String`<br>Creates a string representation of the [ValidationMessage](-validation-message/index.md)`fun `[`ContextedValidationMessage`](-contexted-validation-message/index.md)`.toMessage(): String`<br>Creates a string representation of the [ContextedValidationMessage](-contexted-validation-message/index.md) |
| [validatePart](validate-part.md) | `fun <P> `[`ValidatorManager`](-validator-manager/index.md)`.validatePart(part: P, data: TypedData): `[`ValidationEnvironment`](-validation-environment/index.md)<br>Validates [part](validate-part.md#com.github.jonathanxd.codeapi.processor$validatePart(com.github.jonathanxd.codeapi.processor.ValidatorManager, com.github.jonathanxd.codeapi.processor.validatePart.P, com.github.jonathanxd.iutils.data.TypedData)/part) of type [P](#). |
| [warning](warning.md) | `fun warning(message: () -> String): `[`ValidationMessage`](-validation-message/index.md)<br>Creates a warning validation message. |
