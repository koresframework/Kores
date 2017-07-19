[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.sugar](../index.md) / [SugarSyntaxProcessor](.)

# SugarSyntaxProcessor

`abstract class SugarSyntaxProcessor<in T> : `[`Processor`](../../com.github.jonathanxd.codeapi.processor/-processor/index.md)`<T>`

Sugar syntax processor. CodeAPI provides a way to register a sugar syntax processor, a sugar
syntax processor transforms a value of type [T](#) into a [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md).

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `SugarSyntaxProcessor()`<br>Sugar syntax processor. CodeAPI provides a way to register a sugar syntax processor, a sugar
syntax processor transforms a value of type [T](#) into a [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md). |

### Functions

| Name | Summary |
|---|---|
| [process](process.md) | `abstract fun process(t: T, codeProcessor: `[`CodeProcessor`](../../com.github.jonathanxd.codeapi.processor/-code-processor/index.md)`<*>): `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)<br>Process [t](process.md#com.github.jonathanxd.codeapi.sugar.SugarSyntaxProcessor$process(com.github.jonathanxd.codeapi.sugar.SugarSyntaxProcessor.T, com.github.jonathanxd.codeapi.processor.ProcessorManager((kotlin.Any)))/t) and transforms in [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md).`open fun process(part: T, data: TypedData, codeProcessor: `[`CodeProcessor`](../../com.github.jonathanxd.codeapi.processor/-code-processor/index.md)`<*>): Unit`<br>Process the [part](process.md#com.github.jonathanxd.codeapi.sugar.SugarSyntaxProcessor$process(com.github.jonathanxd.codeapi.sugar.SugarSyntaxProcessor.T, com.github.jonathanxd.iutils.data.TypedData, com.github.jonathanxd.codeapi.processor.ProcessorManager((kotlin.Any)))/part). |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
