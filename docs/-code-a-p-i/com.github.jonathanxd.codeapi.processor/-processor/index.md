[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.processor](../index.md) / [Processor](.)

# Processor

`interface Processor<in P> : Any`

### Functions

| Name | Summary |
|---|---|
| [endProcess](end-process.md) | `open fun endProcess(part: P, data: TypedData, codeProcessor: `[`CodeProcessor`](../-code-processor/index.md)`<*>): Unit`<br>Called when the process to [part](end-process.md#com.github.jonathanxd.codeapi.processor.Processor$endProcess(com.github.jonathanxd.codeapi.processor.Processor.P, com.github.jonathanxd.iutils.data.TypedData, com.github.jonathanxd.codeapi.processor.CodeProcessor((kotlin.Any)))/part) finishes. |
| [process](process.md) | `abstract fun process(part: P, data: TypedData, codeProcessor: `[`CodeProcessor`](../-code-processor/index.md)`<*>): Unit`<br>Process the [part](process.md#com.github.jonathanxd.codeapi.processor.Processor$process(com.github.jonathanxd.codeapi.processor.Processor.P, com.github.jonathanxd.iutils.data.TypedData, com.github.jonathanxd.codeapi.processor.CodeProcessor((kotlin.Any)))/part). |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |

### Inheritors

| Name | Summary |
|---|---|
| [SugarSyntaxProcessor](../../com.github.jonathanxd.codeapi.sugar/-sugar-syntax-processor/index.md) | `abstract class SugarSyntaxProcessor<in T> : Processor<T>`<br>Sugar syntax processor. CodeAPI provides a way to register a sugar syntax processor, a sugar
syntax processor transforms a value of type [T](#) into a [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md). |
