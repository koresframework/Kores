[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.processor](../index.md) / [AbstractProcessorManager](.)

# AbstractProcessorManager

`abstract class AbstractProcessorManager<out R> : `[`ProcessorManager`](../-processor-manager/index.md)`<R>`

An abstract manager backed by a [MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html).

You can enable validation via [VALIDATE](../-v-a-l-i-d-a-t-e.md) option.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `AbstractProcessorManager()`<br>An abstract manager backed by a [MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html). |

### Properties

| Name | Summary |
|---|---|
| [map](map.md) | `val map: `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<Class<*>, `[`Processor`](../-processor/index.md)`<*>>` |

### Inherited Properties

| Name | Summary |
|---|---|
| [options](../-processor-manager/options.md) | `abstract val options: Options`<br>Options of generator |
| [validatorManager](../-processor-manager/validator-manager.md) | `abstract val validatorManager: `[`ValidatorManager`](../-validator-manager/index.md)<br>Validator. |

### Functions

| Name | Summary |
|---|---|
| [getFinalValue](get-final-value.md) | `abstract fun getFinalValue(data: TypedData): R`<br>Gets the resulting value. |
| [getProcessorOf](get-processor-of.md) | `fun <P> getProcessorOf(type: Class<*>, part: P, data: TypedData): `[`Processor`](../-processor/index.md)`<P>`<br>Gets processor of [type](get-processor-of.md#com.github.jonathanxd.codeapi.processor.AbstractProcessorManager$getProcessorOf(java.lang.Class((kotlin.Any)), com.github.jonathanxd.codeapi.processor.AbstractProcessorManager.getProcessorOf.P, com.github.jonathanxd.iutils.data.TypedData)/type). |
| [printFailMessage](print-fail-message.md) | `abstract fun printFailMessage(message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Print fail message to output. |
| [process](process.md) | `open fun <T> process(type: Class<out T>, part: T, data: TypedData): R`<br>Process [part](process.md#com.github.jonathanxd.codeapi.processor.AbstractProcessorManager$process(java.lang.Class((com.github.jonathanxd.codeapi.processor.AbstractProcessorManager.process.T)), com.github.jonathanxd.codeapi.processor.AbstractProcessorManager.process.T, com.github.jonathanxd.iutils.data.TypedData)/part) of type [type](process.md#com.github.jonathanxd.codeapi.processor.AbstractProcessorManager$process(java.lang.Class((com.github.jonathanxd.codeapi.processor.AbstractProcessorManager.process.T)), com.github.jonathanxd.codeapi.processor.AbstractProcessorManager.process.T, com.github.jonathanxd.iutils.data.TypedData)/type) with [data](process.md#com.github.jonathanxd.codeapi.processor.AbstractProcessorManager$process(java.lang.Class((com.github.jonathanxd.codeapi.processor.AbstractProcessorManager.process.T)), com.github.jonathanxd.codeapi.processor.AbstractProcessorManager.process.T, com.github.jonathanxd.iutils.data.TypedData)/data) and returns a value of type [R](#). |
| [registerProcessor](register-processor.md) | `open fun <T> registerProcessor(processor: `[`Processor`](../-processor/index.md)`<T>, type: Class<T>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Registers [processor](register-processor.md#com.github.jonathanxd.codeapi.processor.AbstractProcessorManager$registerProcessor(com.github.jonathanxd.codeapi.processor.Processor((com.github.jonathanxd.codeapi.processor.AbstractProcessorManager.registerProcessor.T)), java.lang.Class((com.github.jonathanxd.codeapi.processor.AbstractProcessorManager.registerProcessor.T)))/processor) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) of type: [type](register-processor.md#com.github.jonathanxd.codeapi.processor.AbstractProcessorManager$registerProcessor(com.github.jonathanxd.codeapi.processor.Processor((com.github.jonathanxd.codeapi.processor.AbstractProcessorManager.registerProcessor.T)), java.lang.Class((com.github.jonathanxd.codeapi.processor.AbstractProcessorManager.registerProcessor.T)))/type). |
| [registerProcessorOfTypes](register-processor-of-types.md) | `fun <T> registerProcessorOfTypes(processor: `[`Processor`](../-processor/index.md)`<T>, types: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<Class<out T>>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [registerSugarSyntaxProcessor](register-sugar-syntax-processor.md) | `open fun <T> registerSugarSyntaxProcessor(sugarSyntaxProcessor: `[`SugarSyntaxProcessor`](../../com.github.jonathanxd.codeapi.sugar/-sugar-syntax-processor/index.md)`<T>, type: Class<T>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Registers a [sugarSyntaxProcessor](register-sugar-syntax-processor.md#com.github.jonathanxd.codeapi.processor.AbstractProcessorManager$registerSugarSyntaxProcessor(com.github.jonathanxd.codeapi.sugar.SugarSyntaxProcessor((com.github.jonathanxd.codeapi.processor.AbstractProcessorManager.registerSugarSyntaxProcessor.T)), java.lang.Class((com.github.jonathanxd.codeapi.processor.AbstractProcessorManager.registerSugarSyntaxProcessor.T)))/sugarSyntaxProcessor) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) of type: [type](register-sugar-syntax-processor.md#com.github.jonathanxd.codeapi.processor.AbstractProcessorManager$registerSugarSyntaxProcessor(com.github.jonathanxd.codeapi.sugar.SugarSyntaxProcessor((com.github.jonathanxd.codeapi.processor.AbstractProcessorManager.registerSugarSyntaxProcessor.T)), java.lang.Class((com.github.jonathanxd.codeapi.processor.AbstractProcessorManager.registerSugarSyntaxProcessor.T)))/type). |

### Inherited Functions

| Name | Summary |
|---|---|
| [createData](../-processor-manager/create-data.md) | `abstract fun createData(): TypedData`<br>Creates [TypedData](#) object. |
| [process](../-processor-manager/process.md) | `open fun process(part: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`): R`<br>`open fun <T> process(type: Class<T>, part: T): R`<br>Process [part](../-processor-manager/process.md#com.github.jonathanxd.codeapi.processor.ProcessorManager$process(kotlin.Any)/part) and returns a value of type [R](#).`open fun process(part: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`, data: TypedData): R`<br>Process [part](../-processor-manager/process.md#com.github.jonathanxd.codeapi.processor.ProcessorManager$process(kotlin.Any, com.github.jonathanxd.iutils.data.TypedData)/part) with [data](../-processor-manager/process.md#com.github.jonathanxd.codeapi.processor.ProcessorManager$process(kotlin.Any, com.github.jonathanxd.iutils.data.TypedData)/data) and returns a value of type [R](#). |

### Extension Functions

| Name | Summary |
|---|---|
| [annotationValue](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/annotation-value.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.annotationValue(rType: Class<*>): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) |
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?.asString(simple: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [processAs](../process-as.md) | `fun <T> `[`ProcessorManager`](../-processor-manager/index.md)`<*>.processAs(part: T, data: TypedData): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?`<br>Process [part](../process-as.md#com.github.jonathanxd.codeapi.processor$processAs(com.github.jonathanxd.codeapi.processor.ProcessorManager((kotlin.Any)), com.github.jonathanxd.codeapi.processor.processAs.T, com.github.jonathanxd.iutils.data.TypedData)/part) as of reified type [T](#). This function is inlined, this means that type passed to [ProcessorManager.process](../-processor-manager/process.md) will be the inferred type and not the the [part](../process-as.md#com.github.jonathanxd.codeapi.processor$processAs(com.github.jonathanxd.codeapi.processor.ProcessorManager((kotlin.Any)), com.github.jonathanxd.codeapi.processor.processAs.T, com.github.jonathanxd.iutils.data.TypedData)/part) type. This is useful when you want to call a specific processor instead of exact processor. |
| [registerProcessor](../register-processor.md) | `fun <R, T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`ProcessorManager`](../-processor-manager/index.md)`<R>.registerProcessor(processor: `[`Processor`](../-processor/index.md)`<T>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Registers [processor](../register-processor.md#com.github.jonathanxd.codeapi.processor$registerProcessor(com.github.jonathanxd.codeapi.processor.ProcessorManager((com.github.jonathanxd.codeapi.processor.registerProcessor.R)), com.github.jonathanxd.codeapi.processor.Processor((com.github.jonathanxd.codeapi.processor.registerProcessor.T)))/processor) of [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) of type: [T](#). |
| [registerSugarSyntaxProcessor](../register-sugar-syntax-processor.md) | `fun <R, T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`ProcessorManager`](../-processor-manager/index.md)`<R>.registerSugarSyntaxProcessor(sugarSyntaxProcessor: `[`SugarSyntaxProcessor`](../../com.github.jonathanxd.codeapi.sugar/-sugar-syntax-processor/index.md)`<T>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Registers a [sugarSyntaxProcessor](../register-sugar-syntax-processor.md#com.github.jonathanxd.codeapi.processor$registerSugarSyntaxProcessor(com.github.jonathanxd.codeapi.processor.ProcessorManager((com.github.jonathanxd.codeapi.processor.registerSugarSyntaxProcessor.R)), com.github.jonathanxd.codeapi.sugar.SugarSyntaxProcessor((com.github.jonathanxd.codeapi.processor.registerSugarSyntaxProcessor.T)))/sugarSyntaxProcessor) of [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) of type: [T](#). |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)<br>Convert this value to a literal |
| [toLiteralOrNull](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal-or-null.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteralOrNull(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
