[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [InvokeDynamic](../index.md) / [LambdaMethodRef](.)

# LambdaMethodRef

`data class LambdaMethodRef : LambdaMethodRefBase`

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `class Builder : Builder<LambdaMethodRef, `[`Builder`](-builder/index.md)`>` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `LambdaMethodRef(invocation: `[`MethodInvocation`](../../-method-invocation/index.md)`, baseSam: `[`MethodTypeSpec`](../../../com.github.jonathanxd.codeapi.common/-method-type-spec/index.md)`, expectedTypes: `[`TypeSpec`](../../-type-spec/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [baseSam](base-sam.md) | `val baseSam: `[`MethodTypeSpec`](../../../com.github.jonathanxd.codeapi.common/-method-type-spec/index.md)<br>Description of base SAM method, example, if the target functional interface
is [Supplier](http://docs.oracle.com/javase/6/docs/api/java/util/function/Supplier.html), then the base SAM method is the [Supplier.get](http://docs.oracle.com/javase/6/docs/api/java/util/function/Supplier.html#get()). |
| [expectedTypes](expected-types.md) | `val expectedTypes: `[`TypeSpec`](../../-type-spec/index.md)<br>Types expected by the caller of lambda SAM. |
| [invocation](invocation.md) | `val invocation: `[`MethodInvocation`](../../-method-invocation/index.md)<br>Invocation to handle dynamically. |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): `[`Builder`](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |
