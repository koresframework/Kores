//[Kores](../../../index.md)/[com.koresframework.kores.processor](../index.md)/[AbstractProcessorManager](index.md)

# AbstractProcessorManager

[jvm]\
abstract class [AbstractProcessorManager](index.md)<out [R](index.md)> : [ProcessorManager](../-processor-manager/index.md)<[R](index.md)> 

An abstract manager backed by a [MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html).

You can enable validation via [VALIDATE](../-v-a-l-i-d-a-t-e.md) option.

## Constructors

| | |
|---|---|
| [AbstractProcessorManager](-abstract-processor-manager.md) | [jvm]<br>fun [AbstractProcessorManager](-abstract-processor-manager.md)() |

## Functions

| Name | Summary |
|---|---|
| [createData](../-processor-manager/create-data.md) | [jvm]<br>abstract fun [createData](../-processor-manager/create-data.md)(): TypedData<br>Creates TypedData object. |
| [getProcessorOf](get-processor-of.md) | [jvm]<br>fun <[P](get-processor-of.md)> [getProcessorOf](get-processor-of.md)(type: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<*>, part: [P](get-processor-of.md), data: TypedData): [Processor](../-processor/index.md)<[P](get-processor-of.md)><br>Gets processor of [type](get-processor-of.md). |
| [process](../-processor-manager/process.md) | [jvm]<br>open fun [process](../-processor-manager/process.md)(part: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)): [R](index.md)<br>open fun <[T](../-processor-manager/process.md)> [process](../-processor-manager/process.md)(type: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<[T](../-processor-manager/process.md)>, part: [T](../-processor-manager/process.md)): [R](index.md)<br>Process [part](../-processor-manager/process.md) and returns a value of type [R](../-processor-manager/index.md).<br>[jvm]<br>open fun [process](../-processor-manager/process.md)(part: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), data: TypedData): [R](index.md)<br>Process [part](../-processor-manager/process.md) with [data](../-processor-manager/process.md) and returns a value of type [R](../-processor-manager/index.md).<br>[jvm]<br>open override fun <[T](process.md)> [process](process.md)(type: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<out [T](process.md)>, part: [T](process.md), data: TypedData): [R](index.md)<br>Process [part](process.md) of type [type](process.md) with [data](process.md) and returns a value of type [R](index.md). |
| [registerProcessor](register-processor.md) | [jvm]<br>open override fun <[T](register-processor.md)> [registerProcessor](register-processor.md)(processor: [Processor](../-processor/index.md)<[T](register-processor.md)>, type: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<[T](register-processor.md)>)<br>Registers [processor](register-processor.md) of [KoresPart](../../com.koresframework.kores/-kores-part/index.md) of type: [type](register-processor.md). |
| [registerProcessorOfTypes](register-processor-of-types.md) | [jvm]<br>inline fun <[T](register-processor-of-types.md)> [registerProcessorOfTypes](register-processor-of-types.md)(processor: [Processor](../-processor/index.md)<[T](register-processor-of-types.md)>, types: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<[Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<out [T](register-processor-of-types.md)>>) |
| [registerSugarSyntaxProcessor](register-sugar-syntax-processor.md) | [jvm]<br>open override fun <[T](register-sugar-syntax-processor.md)> [registerSugarSyntaxProcessor](register-sugar-syntax-processor.md)(sugarSyntaxProcessor: [SugarSyntaxProcessor](../../com.koresframework.kores.sugar/-sugar-syntax-processor/index.md)<[T](register-sugar-syntax-processor.md)>, type: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<[T](register-sugar-syntax-processor.md)>)<br>Registers a [sugarSyntaxProcessor](register-sugar-syntax-processor.md) of [KoresPart](../../com.koresframework.kores/-kores-part/index.md) of type: [type](register-sugar-syntax-processor.md). |

## Properties

| Name | Summary |
|---|---|
| [options](index.md#55060931%2FProperties%2F-1216412040) | [jvm]<br>abstract val [options](index.md#55060931%2FProperties%2F-1216412040): Options<br>Options of generator |
| [validatorManager](index.md#1497262526%2FProperties%2F-1216412040) | [jvm]<br>abstract val [validatorManager](index.md#1497262526%2FProperties%2F-1216412040): [ValidatorManager](../-validator-manager/index.md)<br>Validator. |
