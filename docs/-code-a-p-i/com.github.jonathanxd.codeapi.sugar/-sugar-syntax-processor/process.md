[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.sugar](../index.md) / [SugarSyntaxProcessor](index.md) / [process](.)

# process

`abstract fun process(t: T, codeProcessor: `[`CodeProcessor`](../../com.github.jonathanxd.codeapi.processor/-code-processor/index.md)`<*>): `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)

Process [t](process.md#com.github.jonathanxd.codeapi.sugar.SugarSyntaxProcessor$process(com.github.jonathanxd.codeapi.sugar.SugarSyntaxProcessor.T, com.github.jonathanxd.codeapi.processor.ProcessorManager((kotlin.Any)))/t) and transforms in [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md).

This class should only convert [t](process.md#com.github.jonathanxd.codeapi.sugar.SugarSyntaxProcessor$process(com.github.jonathanxd.codeapi.sugar.SugarSyntaxProcessor.T, com.github.jonathanxd.codeapi.processor.ProcessorManager((kotlin.Any)))/t) to [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) and should not call [CodeProcessor.process](../../com.github.jonathanxd.codeapi.processor/-code-processor/process.md). This class
is intended only for simple conversions, if you need complex conversions you need to write a [Processor](../../com.github.jonathanxd.codeapi.processor/-processor/index.md).

`open fun process(part: T, data: TypedData, codeProcessor: `[`CodeProcessor`](../../com.github.jonathanxd.codeapi.processor/-code-processor/index.md)`<*>): Unit`

Process the [part](process.md#com.github.jonathanxd.codeapi.sugar.SugarSyntaxProcessor$process(com.github.jonathanxd.codeapi.sugar.SugarSyntaxProcessor.T, com.github.jonathanxd.iutils.data.TypedData, com.github.jonathanxd.codeapi.processor.ProcessorManager((kotlin.Any)))/part).

