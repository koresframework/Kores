[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [InvokeDynamic](../index.md) / [LambdaLocalCode](.)

# LambdaLocalCode

`data class LambdaLocalCode : `[`LambdaLocalCodeBase`](../../-invoke-dynamic-base/-lambda-local-code-base/index.md)

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `class Builder : `[`Builder`](../../-invoke-dynamic-base/-lambda-local-code-base/-builder/index.md)`<LambdaLocalCode, `[`Builder`](-builder/index.md)`>` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `LambdaLocalCode(baseSam: `[`MethodTypeSpec`](../../../com.github.jonathanxd.codeapi.common/-method-type-spec/index.md)`, expectedTypes: `[`TypeSpec`](../../-type-spec/index.md)`, localCode: `[`LocalCode`](../../-local-code/index.md)`, arguments: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`>)` |

### Properties

| Name | Summary |
|---|---|
| [arguments](arguments.md) | `val arguments: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`>`<br>Argument to capture from current context and pass to [localCode](local-code.md) |
| [baseSam](base-sam.md) | `val baseSam: `[`MethodTypeSpec`](../../../com.github.jonathanxd.codeapi.common/-method-type-spec/index.md)<br>Description of base SAM method, example, if the target functional interface is [Supplier](#), then the base SAM method is the [Supplier.get](#). |
| [expectedTypes](expected-types.md) | `val expectedTypes: `[`TypeSpec`](../../-type-spec/index.md)<br>Types expected by the caller of lambda SAM. |
| [localCode](local-code.md) | `val localCode: `[`LocalCode`](../../-local-code/index.md)<br>Local method to invoke |
| [target](target.md) | `val target: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Target of method ref invocation |
| [types](types.md) | `val types: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Type>`<br>Expected types of each argument |

### Inherited Properties

| Name | Summary |
|---|---|
| [array](../../-invoke-dynamic-base/-lambda-local-code-base/array.md) | `open val array: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Array arguments |
| [methodRef](../../-invoke-dynamic-base/-lambda-local-code-base/method-ref.md) | `open val methodRef: `[`MethodInvokeSpec`](../../../com.github.jonathanxd.codeapi.common/-method-invoke-spec/index.md)<br>Method reference to invoke |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): `[`Builder`](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |
