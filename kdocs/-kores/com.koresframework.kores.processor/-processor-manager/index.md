//[Kores](../../../index.md)/[com.koresframework.kores.processor](../index.md)/[ProcessorManager](index.md)

# ProcessorManager

[jvm]\
interface [ProcessorManager](index.md)<out [R](index.md)>

ProcessorManager manages all processors required to transform [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) into [R](index.md).

Supported types depends on implementation.

## Functions

| Name | Summary |
|---|---|
| [createData](create-data.md) | [jvm]<br>abstract fun [createData](create-data.md)(): TypedData<br>Creates TypedData object. |
| [process](process.md) | [jvm]<br>open fun [process](process.md)(part: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)): [R](index.md)<br>open fun <[T](process.md)> [process](process.md)(type: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<[T](process.md)>, part: [T](process.md)): [R](index.md)<br>Process [part](process.md) and returns a value of type [R](index.md).<br>[jvm]<br>open fun [process](process.md)(part: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), data: TypedData): [R](index.md)<br>Process [part](process.md) with [data](process.md) and returns a value of type [R](index.md).<br>[jvm]<br>abstract fun <[T](process.md)> [process](process.md)(type: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<out [T](process.md)>, part: [T](process.md), data: TypedData): [R](index.md)<br>Process [part](process.md) of type [type](process.md) with [data](process.md) and returns a value of type [R](index.md). |
| [registerProcessor](register-processor.md) | [jvm]<br>abstract fun <[T](register-processor.md)> [registerProcessor](register-processor.md)(processor: [Processor](../-processor/index.md)<[T](register-processor.md)>, type: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<[T](register-processor.md)>)<br>Registers [processor](register-processor.md) of [KoresPart](../../com.koresframework.kores/-kores-part/index.md) of type: [type](register-processor.md). |
| [registerSugarSyntaxProcessor](register-sugar-syntax-processor.md) | [jvm]<br>abstract fun <[T](register-sugar-syntax-processor.md)> [registerSugarSyntaxProcessor](register-sugar-syntax-processor.md)(sugarSyntaxProcessor: [SugarSyntaxProcessor](../../com.koresframework.kores.sugar/-sugar-syntax-processor/index.md)<[T](register-sugar-syntax-processor.md)>, type: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<[T](register-sugar-syntax-processor.md)>)<br>Registers a [sugarSyntaxProcessor](register-sugar-syntax-processor.md) of [KoresPart](../../com.koresframework.kores/-kores-part/index.md) of type: [type](register-sugar-syntax-processor.md). |

## Properties

| Name | Summary |
|---|---|
| [options](options.md) | [jvm]<br>abstract val [options](options.md): Options<br>Options of generator |
| [validatorManager](validator-manager.md) | [jvm]<br>abstract val [validatorManager](validator-manager.md): [ValidatorManager](../-validator-manager/index.md)<br>Validator. |

## Inheritors

| Name |
|---|
| [AbstractProcessorManager](../-abstract-processor-manager/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [processAs](../process-as.md) | [jvm]<br>inline fun <[T](../process-as.md)> [ProcessorManager](index.md)<*>.[processAs](../process-as.md)(part: [T](../process-as.md), data: TypedData): [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?<br>Process [part](../process-as.md) as of reified type [T](../process-as.md). |
| [registerProcessor](../register-processor.md) | [jvm]<br>inline fun <[R](../register-processor.md), [T](../register-processor.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [ProcessorManager](index.md)<[R](../register-processor.md)>.[registerProcessor](../register-processor.md)(processor: [Processor](../-processor/index.md)<[T](../register-processor.md)>)<br>Registers [processor](../register-processor.md) of [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) of type: [T](../register-processor.md). |
| [registerSugarSyntaxProcessor](../register-sugar-syntax-processor.md) | [jvm]<br>inline fun <[R](../register-sugar-syntax-processor.md), [T](../register-sugar-syntax-processor.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [ProcessorManager](index.md)<[R](../register-sugar-syntax-processor.md)>.[registerSugarSyntaxProcessor](../register-sugar-syntax-processor.md)(sugarSyntaxProcessor: [SugarSyntaxProcessor](../../com.koresframework.kores.sugar/-sugar-syntax-processor/index.md)<[T](../register-sugar-syntax-processor.md)>)<br>Registers a [sugarSyntaxProcessor](../register-sugar-syntax-processor.md) of [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) of type: [T](../register-sugar-syntax-processor.md). |
