[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [InvokeDynamicBase](../index.md) / [LambdaMethodRefBase](.)

# LambdaMethodRefBase

`interface LambdaMethodRefBase : `[`InvokeDynamicBase`](../index.md)

Dynamic invocation of lambda method reference.

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `interface Builder<out T : LambdaMethodRefBase, S : `[`Builder`](-builder/index.md)`<T, S>> : `[`Builder`](../-builder/index.md)`<T, S>` |

### Properties

| Name | Summary |
|---|---|
| [args](args.md) | `open val args: List<Any>`<br>Bootstrap method Arguments, must be an [String](#), [Int](#),
[Long](#), [Float](#), [Double](#), [CodeType](../../../com.github.jonathanxd.codeapi.type/-code-type/index.md) or [MethodInvokeSpec](../../../com.github.jonathanxd.codeapi.common/-method-invoke-spec/index.md). |
| [baseSam](base-sam.md) | `abstract val baseSam: `[`MethodTypeSpec`](../../../com.github.jonathanxd.codeapi.common/-method-type-spec/index.md)<br>Description of base SAM method, example, if the target functional interface
is [Supplier](http://docs.oracle.com/javase/6/docs/api/java/util/function/Supplier.html), then the base SAM method is the [Supplier.get](http://docs.oracle.com/javase/6/docs/api/java/util/function/Supplier.html#get()). |
| [bootstrap](bootstrap.md) | `open val bootstrap: `[`MethodInvokeSpec`](../../../com.github.jonathanxd.codeapi.common/-method-invoke-spec/index.md)<br>Bootstrap method invocation specification. |
| [expectedTypes](expected-types.md) | `abstract val expectedTypes: `[`TypeSpec`](../../-type-spec/index.md)<br>Types expected by the caller of lambda SAM. |
| [type](type.md) | `open val type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Return type of dynamic invocation |

### Inherited Properties

| Name | Summary |
|---|---|
| [invocation](../invocation.md) | `abstract val invocation: `[`MethodInvocation`](../../-method-invocation/index.md)<br>Invocation to handle dynamically. |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `abstract fun builder(): `[`Builder`](-builder/index.md)`<LambdaMethodRefBase, *>`<br>This builder may or may not accept null values, it depends on implementation. |

### Inheritors

| Name | Summary |
|---|---|
| [LambdaLocalCodeBase](../-lambda-local-code-base/index.md) | `interface LambdaLocalCodeBase : LambdaMethodRefBase, `[`ArgumentsHolder`](../../-arguments-holder/index.md)<br>Invocation of lambda function. |
| [LambdaMethodRef](../../-invoke-dynamic/-lambda-method-ref/index.md) | `data class LambdaMethodRef : LambdaMethodRefBase` |
