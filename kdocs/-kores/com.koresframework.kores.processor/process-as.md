//[Kores](../../index.md)/[com.koresframework.kores.processor](index.md)/[processAs](process-as.md)

# processAs

[jvm]\
inline fun <[T](process-as.md)> [ProcessorManager](-processor-manager/index.md)<*>.[processAs](process-as.md)(part: [T](process-as.md), data: TypedData): [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?

Process [part](process-as.md) as of reified type [T](process-as.md). This function is inlined, this means that type passed to [ProcessorManager.process](-processor-manager/process.md) will be the inferred type and not the the [part](process-as.md) type. This is useful when you want to call a specific processor instead of exact processor.
