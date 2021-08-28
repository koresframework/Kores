//[Kores](../../index.md)/[com.github.jonathanxd.kores.processor](index.md)

# Package com.github.jonathanxd.kores.processor

## Types

| Name | Summary |
|---|---|
| [AbstractProcessorManager](-abstract-processor-manager/index.md) | [jvm]<br>abstract class [AbstractProcessorManager](-abstract-processor-manager/index.md)<out [R](-abstract-processor-manager/index.md)> : [ProcessorManager](-processor-manager/index.md)<[R](-abstract-processor-manager/index.md)> <br>An abstract manager backed by a [MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html). |
| [AbstractValidatorManager](-abstract-validator-manager/index.md) | [jvm]<br>abstract class [AbstractValidatorManager](-abstract-validator-manager/index.md) : [ValidatorManager](-validator-manager/index.md)<br>Validator manager backed by an [MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html). |
| [ContextedValidationMessage](-contexted-validation-message/index.md) | [jvm]<br>data class [ContextedValidationMessage](-contexted-validation-message/index.md)(**message**: [ValidationMessage](-validation-message/index.md), **context**: Context)<br>Validation message with a [context](-contexted-validation-message/context.md). |
| [Processor](-processor/index.md) | [jvm]<br>interface [Processor](-processor/index.md)<in [P](-processor/index.md)><br>Process [part](-processor/index.md) and do required things. |
| [ProcessorManager](-processor-manager/index.md) | [jvm]<br>interface [ProcessorManager](-processor-manager/index.md)<out [R](-processor-manager/index.md)><br>ProcessorManager manages all processors required to transform [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) into [R](-processor-manager/index.md). |
| [UnexpectedInspectionContext](-unexpected-inspection-context/index.md) | [jvm]<br>class [UnexpectedInspectionContext](-unexpected-inspection-context/index.md) : [IllegalStateException](https://docs.oracle.com/javase/8/docs/api/java/lang/IllegalStateException.html)<br>Occurs when a unexpected inspection context is found. |
| [ValidationEnvironment](-validation-environment/index.md) | [jvm]<br>interface [ValidationEnvironment](-validation-environment/index.md)<br>Validation environment to index [ValidationMessages](-validation-message/index.md). |
| [ValidationMessage](-validation-message/index.md) | [jvm]<br>data class [ValidationMessage](-validation-message/index.md)(**message**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **type**: [ValidationMessage.Type](-validation-message/-type/index.md))<br>Validation message. |
| [Validator](-validator/index.md) | [jvm]<br>interface [Validator](-validator/index.md)<in [P](-validator/index.md)><br>Custom validator |
| [ValidatorManager](-validator-manager/index.md) | [jvm]<br>interface [ValidatorManager](-validator-manager/index.md)<br>Manages all [Validators](-validator/index.md) used to validate [part](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html). |
| [VoidValidatorManager](-void-validator-manager/index.md) | [jvm]<br>object [VoidValidatorManager](-void-validator-manager/index.md) : [ValidatorManager](-validator-manager/index.md)<br>**Only a void implementation**, this class does nothing, literally. |

## Functions

| Name | Summary |
|---|---|
| [error](error.md) | [jvm]<br>inline fun [error](error.md)(message: () -> [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ValidationMessage](-validation-message/index.md)<br>Creates a error validation message. |
| [hasContextedError](has-contexted-error.md) | [jvm]<br>fun [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[ContextedValidationMessage](-contexted-validation-message/index.md)>.[hasContextedError](has-contexted-error.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if receiver has any [ValidationMessage](-validation-message/index.md) of [type](-validation-message/type.md)[ValidationMessage.Type.ERROR](-validation-message/-type/-e-r-r-o-r/index.md). |
| [hasError](has-error.md) | [jvm]<br>fun [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[ValidationMessage](-validation-message/index.md)>.[hasError](has-error.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if receiver has any [ValidationMessage](-validation-message/index.md) of [type](-validation-message/type.md)[ValidationMessage.Type.ERROR](-validation-message/-type/-e-r-r-o-r/index.md). |
| [info](info.md) | [jvm]<br>inline fun [info](info.md)(message: () -> [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ValidationMessage](-validation-message/index.md)<br>Creates a info validation message. |
| [inspectionInContext](inspection-in-context.md) | [jvm]<br>inline fun <[P](inspection-in-context.md), [R](inspection-in-context.md)> [ValidationEnvironment](-validation-environment/index.md).[inspectionInContext](inspection-in-context.md)(part: [P](inspection-in-context.md), context: ([P](inspection-in-context.md)) -> [R](inspection-in-context.md)): [R](inspection-in-context.md)<br>Immediately enters the inspection of [part](inspection-in-context.md), calls [context](inspection-in-context.md) and then immediately exits the inspection of [part](inspection-in-context.md). |
| [other](other.md) | [jvm]<br>inline fun [other](other.md)(message: () -> [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ValidationMessage](-validation-message/index.md)<br>Creates a other validation message. |
| [performance](performance.md) | [jvm]<br>inline fun [performance](performance.md)(message: () -> [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ValidationMessage](-validation-message/index.md)<br>Creates a performance validation message. |
| [printMessages](print-messages.md) | [jvm]<br>fun [ValidationEnvironment](-validation-environment/index.md).[printMessages](print-messages.md)(printer: ([String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -> [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), includeStack: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false)<br>Prints messages registered in [ValidationEnvironment](-validation-environment/index.md). |
| [processAs](process-as.md) | [jvm]<br>inline fun <[T](process-as.md)> [ProcessorManager](-processor-manager/index.md)<*>.[processAs](process-as.md)(part: [T](process-as.md), data: TypedData): [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?<br>Process [part](process-as.md) as of reified type [T](process-as.md). |
| [registerProcessor](register-processor.md) | [jvm]<br>inline fun <[R](register-processor.md), [T](register-processor.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [ProcessorManager](-processor-manager/index.md)<[R](register-processor.md)>.[registerProcessor](register-processor.md)(processor: [Processor](-processor/index.md)<[T](register-processor.md)>)<br>Registers [processor](register-processor.md) of [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) of type: [T](register-processor.md). |
| [registerSugarSyntaxProcessor](register-sugar-syntax-processor.md) | [jvm]<br>inline fun <[R](register-sugar-syntax-processor.md), [T](register-sugar-syntax-processor.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [ProcessorManager](-processor-manager/index.md)<[R](register-sugar-syntax-processor.md)>.[registerSugarSyntaxProcessor](register-sugar-syntax-processor.md)(sugarSyntaxProcessor: [SugarSyntaxProcessor](../com.github.jonathanxd.kores.sugar/-sugar-syntax-processor/index.md)<[T](register-sugar-syntax-processor.md)>)<br>Registers a [sugarSyntaxProcessor](register-sugar-syntax-processor.md) of [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) of type: [T](register-sugar-syntax-processor.md). |
| [registerValidator](register-validator.md) | [jvm]<br>inline fun <[P](register-validator.md)> [ValidatorManager](-validator-manager/index.md).[registerValidator](register-validator.md)(validator: [Validator](-validator/index.md)<[P](register-validator.md)>)<br>Registers a custom [validator](register-validator.md) of [KoresPart](../com.github.jonathanxd.kores/-kores-part/index.md) of type [P](register-validator.md). |
| [sessionInContext](session-in-context.md) | [jvm]<br>inline fun <[R](session-in-context.md)> [ValidationEnvironment](-validation-environment/index.md).[sessionInContext](session-in-context.md)(context: (session: [ValidationEnvironment.Session](-validation-environment/-session/index.md)) -> [R](session-in-context.md)): [R](session-in-context.md)<br>Creates session to be used only within [context](session-in-context.md), this session is exited immediately after [context](session-in-context.md) invocation. |
| [toMessage](to-message.md) | [jvm]<br>fun [ContextedValidationMessage](-contexted-validation-message/index.md).[toMessage](to-message.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Creates a string representation of the [ContextedValidationMessage](-contexted-validation-message/index.md)<br>[jvm]<br>fun [ValidationMessage](-validation-message/index.md).[toMessage](to-message.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Creates a string representation of the [ValidationMessage](-validation-message/index.md) |
| [validatePart](validate-part.md) | [jvm]<br>inline fun <[P](validate-part.md)> [ValidatorManager](-validator-manager/index.md).[validatePart](validate-part.md)(part: [P](validate-part.md), data: TypedData): [ValidationEnvironment](-validation-environment/index.md)<br>Validates [part](validate-part.md) of type [P](validate-part.md). |
| [warning](warning.md) | [jvm]<br>inline fun [warning](warning.md)(message: () -> [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ValidationMessage](-validation-message/index.md)<br>Creates a warning validation message. |

## Properties

| Name | Summary |
|---|---|
| [FIRST_CALL](-f-i-r-s-t_-c-a-l-l.md) | [jvm]<br>@[JvmField](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-field/index.html)()<br>val [FIRST_CALL](-f-i-r-s-t_-c-a-l-l.md): TypedKey<[Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)><br>Stores call state |
| [VALIDATE](-v-a-l-i-d-a-t-e.md) | [jvm]<br>@[JvmField](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-field/index.html)()<br>val [VALIDATE](-v-a-l-i-d-a-t-e.md): Option<[Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)><br>True to validate part before processing. |