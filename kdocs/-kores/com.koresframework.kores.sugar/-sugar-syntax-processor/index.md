//[Kores](../../../index.md)/[com.koresframework.kores.sugar](../index.md)/[SugarSyntaxProcessor](index.md)

# SugarSyntaxProcessor

[jvm]\
abstract class [SugarSyntaxProcessor](index.md)<in [T](index.md)> : [Processor](../../com.koresframework.kores.processor/-processor/index.md)<[T](index.md)> 

Sugar syntax processor. Kores provides a way to register a sugar syntax processor, a sugar syntax processor transforms a value of type [T](index.md) into a [KoresPart](../../com.koresframework.kores/-kores-part/index.md).

## Constructors

| | |
|---|---|
| [SugarSyntaxProcessor](-sugar-syntax-processor.md) | [jvm]<br>fun [SugarSyntaxProcessor](-sugar-syntax-processor.md)() |

## Functions

| Name | Summary |
|---|---|
| [endProcess](../../com.koresframework.kores.processor/-processor/end-process.md) | [jvm]<br>open fun [endProcess](../../com.koresframework.kores.processor/-processor/end-process.md)(part: [T](index.md), data: TypedData, processorManager: [ProcessorManager](../../com.koresframework.kores.processor/-processor-manager/index.md)<*>)<br>Called when the process to [part](../../com.koresframework.kores.processor/-processor/end-process.md) finishes. |
| [process](process.md) | [jvm]<br>abstract fun [process](process.md)(t: [T](index.md), codeProcessor: [ProcessorManager](../../com.koresframework.kores.processor/-processor-manager/index.md)<*>): [KoresPart](../../com.koresframework.kores/-kores-part/index.md)<br>Process [t](process.md) and transforms in [KoresPart](../../com.koresframework.kores/-kores-part/index.md).<br>[jvm]<br>open override fun [process](process.md)(part: [T](index.md), data: TypedData, processorManager: [ProcessorManager](../../com.koresframework.kores.processor/-processor-manager/index.md)<*>)<br>Process the [part](process.md). |
