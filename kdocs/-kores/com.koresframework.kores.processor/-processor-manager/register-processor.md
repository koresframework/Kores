//[Kores](../../../index.md)/[com.koresframework.kores.processor](../index.md)/[ProcessorManager](index.md)/[registerProcessor](register-processor.md)

# registerProcessor

[jvm]\
abstract fun <[T](register-processor.md)> [registerProcessor](register-processor.md)(processor: [Processor](../-processor/index.md)<[T](register-processor.md)>, type: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<[T](register-processor.md)>)

Registers [processor](register-processor.md) of [KoresPart](../../com.koresframework.kores/-kores-part/index.md) of type: [type](register-processor.md).

**Obs: registering a processor for a type that already have one does not means that the default processor will be replaced.**
