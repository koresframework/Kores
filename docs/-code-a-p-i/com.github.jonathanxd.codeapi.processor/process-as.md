[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.processor](index.md) / [processAs](.)

# processAs

`inline fun <reified T> `[`ProcessorManager`](-processor-manager/index.md)`<*>.processAs(part: T, data: TypedData): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?`

Process [part](process-as.md#com.github.jonathanxd.codeapi.processor$processAs(com.github.jonathanxd.codeapi.processor.ProcessorManager((kotlin.Any)), com.github.jonathanxd.codeapi.processor.processAs.T, com.github.jonathanxd.iutils.data.TypedData)/part) as of reified type [T](#). This function is inlined, this means that type passed to [ProcessorManager.process](-processor-manager/process.md)
will be the inferred type and not the the [part](process-as.md#com.github.jonathanxd.codeapi.processor$processAs(com.github.jonathanxd.codeapi.processor.ProcessorManager((kotlin.Any)), com.github.jonathanxd.codeapi.processor.processAs.T, com.github.jonathanxd.iutils.data.TypedData)/part) type. This is useful when you want to call a specific processor
instead of exact processor.

