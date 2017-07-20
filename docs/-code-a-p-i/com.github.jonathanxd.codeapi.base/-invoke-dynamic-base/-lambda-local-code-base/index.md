[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [InvokeDynamicBase](../index.md) / [LambdaLocalCodeBase](.)

# LambdaLocalCodeBase

`interface LambdaLocalCodeBase : `[`LambdaMethodRefBase`](../-lambda-method-ref-base/index.md)`, `[`ArgumentsHolder`](../../-arguments-holder/index.md)

Invocation of lambda function.

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `interface Builder<out T : LambdaLocalCodeBase, S : `[`Builder`](-builder/index.md)`<T, S>> : `[`Builder`](../-lambda-method-ref-base/-builder/index.md)`<T, S>, `[`Builder`](../../-arguments-holder/-builder/index.md)`<T, S>` |

### Properties

| Name | Summary |
|---|---|
| [arguments](arguments.md) | `abstract val arguments: List<`[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`>`<br>Argument to capture from current context and pass to [localCode](local-code.md) |
| [array](array.md) | `open val array: Boolean`<br>Array arguments |
| [expectedTypes](expected-types.md) | `open val expectedTypes: `[`TypeSpec`](../../-type-spec/index.md)<br>Types expected by the caller of lambda SAM. |
| [invocation](invocation.md) | `open val invocation: `[`MethodInvocation`](../../-method-invocation/index.md)<br>Invocation to handle dynamically. |
| [localCode](local-code.md) | `abstract val localCode: `[`LocalCode`](../../-local-code/index.md)<br>Local method to invoke |
| [types](types.md) | `open val types: List<`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`>`<br>Expected types of each argument |

### Inherited Properties

| Name | Summary |
|---|---|
| [args](../-lambda-method-ref-base/args.md) | `open val args: List<Any>`<br>Bootstrap method Arguments, must be an [String](#), [Int](#),
[Long](#), [Float](#), [Double](#), [CodeType](../../../com.github.jonathanxd.codeapi.type/-code-type/index.md) or [MethodInvokeSpec](../../../com.github.jonathanxd.codeapi.common/-method-invoke-spec/index.md). |
| [baseSam](../-lambda-method-ref-base/base-sam.md) | `abstract val baseSam: `[`MethodTypeSpec`](../../../com.github.jonathanxd.codeapi.common/-method-type-spec/index.md)<br>Description of base SAM method, example, if the target functional interface
is [Supplier](http://docs.oracle.com/javase/6/docs/api/java/util/function/Supplier.html), then the base SAM method is the [Supplier.get](http://docs.oracle.com/javase/6/docs/api/java/util/function/Supplier.html#get()). |
| [bootstrap](../-lambda-method-ref-base/bootstrap.md) | `open val bootstrap: `[`MethodInvokeSpec`](../../../com.github.jonathanxd.codeapi.common/-method-invoke-spec/index.md)<br>Bootstrap method invocation specification. |
| [type](../-lambda-method-ref-base/type.md) | `open val type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Return type of dynamic invocation |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `abstract fun builder(): `[`Builder`](-builder/index.md)`<LambdaLocalCodeBase, *>`<br>This builder may or may not accept null values, it depends on implementation. |

### Inheritors

| Name | Summary |
|---|---|
| [LambdaLocalCode](../../-invoke-dynamic/-lambda-local-code/index.md) | `data class LambdaLocalCode : LambdaLocalCodeBase` |
