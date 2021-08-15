//[Kores](../../../index.md)/[com.koresframework.kores.sugar](../index.md)/[SugarSyntaxProcessor](index.md)/[process](process.md)

# process

[jvm]\
abstract fun [process](process.md)(t: [T](index.md), codeProcessor: [ProcessorManager](../../com.koresframework.kores.processor/-processor-manager/index.md)<*>): [KoresPart](../../com.koresframework.kores/-kores-part/index.md)

Process [t](process.md) and transforms in [KoresPart](../../com.koresframework.kores/-kores-part/index.md).

This class should only convert [t](process.md) to [KoresPart](../../com.koresframework.kores/-kores-part/index.md) and should not call [ProcessorManager.process](../../com.koresframework.kores.processor/-processor-manager/process.md). This class is intended only for simple conversions, if you need complex conversions you need to write a [Processor](../../com.koresframework.kores.processor/-processor/index.md).

[jvm]\
open override fun [process](process.md)(part: [T](index.md), data: TypedData, processorManager: [ProcessorManager](../../com.koresframework.kores.processor/-processor-manager/index.md)<*>)

Process the [part](process.md).
