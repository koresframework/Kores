//[Kores](../../../index.md)/[com.koresframework.kores.processor](../index.md)/[Processor](index.md)

# Processor

[jvm]\
interface [Processor](index.md)<in [P](index.md)>

Process [part](index.md) and do required things.

## Functions

| Name | Summary |
|---|---|
| [endProcess](end-process.md) | [jvm]<br>open fun [endProcess](end-process.md)(part: [P](index.md), data: TypedData, processorManager: [ProcessorManager](../-processor-manager/index.md)<*>)<br>Called when the process to [part](end-process.md) finishes. |
| [process](process.md) | [jvm]<br>abstract fun [process](process.md)(part: [P](index.md), data: TypedData, processorManager: [ProcessorManager](../-processor-manager/index.md)<*>)<br>Process the [part](process.md). |

## Inheritors

| Name |
|---|
| [SugarSyntaxProcessor](../../com.koresframework.kores.sugar/-sugar-syntax-processor/index.md) |
