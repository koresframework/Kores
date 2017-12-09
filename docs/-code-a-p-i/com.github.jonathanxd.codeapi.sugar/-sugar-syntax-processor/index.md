[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.sugar](../index.md) / [SugarSyntaxProcessor](.)

# SugarSyntaxProcessor

`abstract class SugarSyntaxProcessor<in T> : `[`Processor`](../../com.github.jonathanxd.codeapi.processor/-processor/index.md)`<T>`

Sugar syntax processor. CodeAPI provides a way to register a sugar syntax processor, a sugar
syntax processor transforms a value of type [T](#) into a [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md).

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `SugarSyntaxProcessor()`<br>Sugar syntax processor. CodeAPI provides a way to register a sugar syntax processor, a sugar syntax processor transforms a value of type [T](#) into a [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md). |

### Functions

| Name | Summary |
|---|---|
| [process](process.md) | `abstract fun process(t: T, codeProcessor: `[`ProcessorManager`](../../com.github.jonathanxd.codeapi.processor/-processor-manager/index.md)`<*>): `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)<br>Process [t](process.md#com.github.jonathanxd.codeapi.sugar.SugarSyntaxProcessor$process(com.github.jonathanxd.codeapi.sugar.SugarSyntaxProcessor.T, com.github.jonathanxd.codeapi.processor.ProcessorManager((kotlin.Any)))/t) and transforms in [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md).`open fun process(part: T, data: TypedData, processorManager: `[`ProcessorManager`](../../com.github.jonathanxd.codeapi.processor/-processor-manager/index.md)`<*>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Process the [part](process.md#com.github.jonathanxd.codeapi.sugar.SugarSyntaxProcessor$process(com.github.jonathanxd.codeapi.sugar.SugarSyntaxProcessor.T, com.github.jonathanxd.iutils.data.TypedData, com.github.jonathanxd.codeapi.processor.ProcessorManager((kotlin.Any)))/part). |

### Extension Functions

| Name | Summary |
|---|---|
| [annotationValue](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/annotation-value.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.annotationValue(rType: Class<*>): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) |
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?.asString(simple: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)<br>Convert this value to a literal |
| [toLiteralOrNull](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal-or-null.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteralOrNull(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
