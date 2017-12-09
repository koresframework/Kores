[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.processor](../index.md) / [AbstractProcessorManager](index.md) / [registerProcessor](.)

# registerProcessor

`open fun <T> registerProcessor(processor: `[`Processor`](../-processor/index.md)`<T>, type: Class<T>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Overrides [ProcessorManager.registerProcessor](../-processor-manager/register-processor.md)

Registers [processor](register-processor.md#com.github.jonathanxd.codeapi.processor.AbstractProcessorManager$registerProcessor(com.github.jonathanxd.codeapi.processor.Processor((com.github.jonathanxd.codeapi.processor.AbstractProcessorManager.registerProcessor.T)), java.lang.Class((com.github.jonathanxd.codeapi.processor.AbstractProcessorManager.registerProcessor.T)))/processor) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) of type: [type](register-processor.md#com.github.jonathanxd.codeapi.processor.AbstractProcessorManager$registerProcessor(com.github.jonathanxd.codeapi.processor.Processor((com.github.jonathanxd.codeapi.processor.AbstractProcessorManager.registerProcessor.T)), java.lang.Class((com.github.jonathanxd.codeapi.processor.AbstractProcessorManager.registerProcessor.T)))/type).

**Obs: registering a processor for a type that already have one does not means that the defaultprocessor will be replaced.**

