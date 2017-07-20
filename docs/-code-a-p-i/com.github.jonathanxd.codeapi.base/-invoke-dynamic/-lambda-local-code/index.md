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
| [&lt;init&gt;](-init-.md) | `LambdaLocalCode(baseSam: `[`MethodTypeSpec`](../../../com.github.jonathanxd.codeapi.common/-method-type-spec/index.md)`, localCode: `[`LocalCode`](../../-local-code/index.md)`, arguments: List<`[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`>)` |

### Properties

| Name | Summary |
|---|---|
| [arguments](arguments.md) | `val arguments: List<`[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`>`<br>Argument to capture from current context and pass to [localCode](local-code.md) |
| [baseSam](base-sam.md) | `val baseSam: `[`MethodTypeSpec`](../../../com.github.jonathanxd.codeapi.common/-method-type-spec/index.md)<br>Description of base SAM method, example, if the target functional interface
is [Supplier](http://docs.oracle.com/javase/6/docs/api/java/util/function/Supplier.html), then the base SAM method is the [Supplier.get](http://docs.oracle.com/javase/6/docs/api/java/util/function/Supplier.html#get()). |
| [invocation](invocation.md) | `val invocation: `[`MethodInvocation`](../../-method-invocation/index.md)<br>Invocation to handle dynamically. |
| [localCode](local-code.md) | `val localCode: `[`LocalCode`](../../-local-code/index.md)<br>Local method to invoke |
| [types](types.md) | `val types: List<`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`>`<br>Expected types of each argument |

### Inherited Properties

| Name | Summary |
|---|---|
| [array](../../-invoke-dynamic-base/-lambda-local-code-base/array.md) | `open val array: Boolean`<br>Array arguments |
| [expectedTypes](../../-invoke-dynamic-base/-lambda-local-code-base/expected-types.md) | `open val expectedTypes: `[`TypeSpec`](../../-type-spec/index.md)<br>Types expected by the caller of lambda SAM. |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): `[`Builder`](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |
