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
| [args](args.md) | `open val args: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>`<br>Bootstrap method Arguments, must be an [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html), [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), [CodeType](../../../com.github.jonathanxd.codeapi.type/-code-type/index.md) or [MethodInvokeSpec](../../../com.github.jonathanxd.codeapi.common/-method-invoke-spec/index.md). |
| [baseSam](base-sam.md) | `abstract val baseSam: `[`MethodTypeSpec`](../../../com.github.jonathanxd.codeapi.common/-method-type-spec/index.md)<br>Description of base SAM method, example, if the target functional interface is [Supplier](#), then the base SAM method is the [Supplier.get](#). |
| [bootstrap](bootstrap.md) | `open val bootstrap: `[`MethodInvokeSpec`](../../../com.github.jonathanxd.codeapi.common/-method-invoke-spec/index.md)<br>Bootstrap method invocation specification. |
| [expectedTypes](expected-types.md) | `abstract val expectedTypes: `[`TypeSpec`](../../-type-spec/index.md)<br>Types expected by the caller of lambda SAM. |
| [type](type.md) | `open val type: Type`<br>Return type of dynamic invocation |

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
