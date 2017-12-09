[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [InvokeDynamic](../index.md) / [LambdaMethodRef](.)

# LambdaMethodRef

`data class LambdaMethodRef : `[`LambdaMethodRefBase`](../../-invoke-dynamic-base/-lambda-method-ref-base/index.md)

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `class Builder : `[`Builder`](../../-invoke-dynamic-base/-lambda-method-ref-base/-builder/index.md)`<LambdaMethodRef, `[`Builder`](-builder/index.md)`>` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `LambdaMethodRef(invocation: `[`MethodInvocation`](../../-method-invocation/index.md)`, baseSam: `[`MethodTypeSpec`](../../../com.github.jonathanxd.codeapi.common/-method-type-spec/index.md)`, expectedTypes: `[`TypeSpec`](../../-type-spec/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [baseSam](base-sam.md) | `val baseSam: `[`MethodTypeSpec`](../../../com.github.jonathanxd.codeapi.common/-method-type-spec/index.md)<br>Description of base SAM method, example, if the target functional interface is [Supplier](#), then the base SAM method is the [Supplier.get](#). |
| [expectedTypes](expected-types.md) | `val expectedTypes: `[`TypeSpec`](../../-type-spec/index.md)<br>Types expected by the caller of lambda SAM. |
| [invocation](invocation.md) | `val invocation: `[`MethodInvocation`](../../-method-invocation/index.md)<br>Invocation to handle dynamically. |

### Inherited Properties

| Name | Summary |
|---|---|
| [args](../../-invoke-dynamic-base/-lambda-method-ref-base/args.md) | `open val args: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>`<br>Bootstrap method Arguments, must be an [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html), [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), [CodeType](../../../com.github.jonathanxd.codeapi.type/-code-type/index.md) or [MethodInvokeSpec](../../../com.github.jonathanxd.codeapi.common/-method-invoke-spec/index.md). |
| [bootstrap](../../-invoke-dynamic-base/-lambda-method-ref-base/bootstrap.md) | `open val bootstrap: `[`MethodInvokeSpec`](../../../com.github.jonathanxd.codeapi.common/-method-invoke-spec/index.md)<br>Bootstrap method invocation specification. |
| [type](../../-invoke-dynamic-base/-lambda-method-ref-base/type.md) | `open val type: Type`<br>Return type of dynamic invocation |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): `[`Builder`](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |
