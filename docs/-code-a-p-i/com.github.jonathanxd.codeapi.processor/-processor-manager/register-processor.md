[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.processor](../index.md) / [ProcessorManager](index.md) / [registerProcessor](.)

# registerProcessor

`abstract fun <T> registerProcessor(processor: `[`Processor`](../-processor/index.md)`<T>, type: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<T>): Unit`

Registers [processor](register-processor.md#com.github.jonathanxd.codeapi.processor.ProcessorManager$registerProcessor(com.github.jonathanxd.codeapi.processor.Processor((com.github.jonathanxd.codeapi.processor.ProcessorManager.registerProcessor.T)), java.lang.Class((com.github.jonathanxd.codeapi.processor.ProcessorManager.registerProcessor.T)))/processor) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) of type: [type](register-processor.md#com.github.jonathanxd.codeapi.processor.ProcessorManager$registerProcessor(com.github.jonathanxd.codeapi.processor.Processor((com.github.jonathanxd.codeapi.processor.ProcessorManager.registerProcessor.T)), java.lang.Class((com.github.jonathanxd.codeapi.processor.ProcessorManager.registerProcessor.T)))/type).

**Obs:registering a processor for a type that already have one does not means that the defaultprocessor will be replaced.**

