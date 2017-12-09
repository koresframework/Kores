[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.processor](../index.md) / [ProcessorManager](index.md) / [process](.)

# process

`open fun process(part: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`): R`
`open fun <T> process(type: Class<T>, part: T): R`

Process [part](process.md#com.github.jonathanxd.codeapi.processor.ProcessorManager$process(kotlin.Any)/part) and returns a value of type [R](#).

`open fun process(part: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, data: TypedData): R`

Process [part](process.md#com.github.jonathanxd.codeapi.processor.ProcessorManager$process(kotlin.Any, com.github.jonathanxd.iutils.data.TypedData)/part) with [data](process.md#com.github.jonathanxd.codeapi.processor.ProcessorManager$process(kotlin.Any, com.github.jonathanxd.iutils.data.TypedData)/data) and returns a value of type [R](#).

`abstract fun <T> process(type: Class<out T>, part: T, data: TypedData): R`

Process [part](process.md#com.github.jonathanxd.codeapi.processor.ProcessorManager$process(java.lang.Class((com.github.jonathanxd.codeapi.processor.ProcessorManager.process.T)), com.github.jonathanxd.codeapi.processor.ProcessorManager.process.T, com.github.jonathanxd.iutils.data.TypedData)/part) of type [type](process.md#com.github.jonathanxd.codeapi.processor.ProcessorManager$process(java.lang.Class((com.github.jonathanxd.codeapi.processor.ProcessorManager.process.T)), com.github.jonathanxd.codeapi.processor.ProcessorManager.process.T, com.github.jonathanxd.iutils.data.TypedData)/type) with [data](process.md#com.github.jonathanxd.codeapi.processor.ProcessorManager$process(java.lang.Class((com.github.jonathanxd.codeapi.processor.ProcessorManager.process.T)), com.github.jonathanxd.codeapi.processor.ProcessorManager.process.T, com.github.jonathanxd.iutils.data.TypedData)/data) and returns a value of type [R](#).

