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
| [&lt;init&gt;](-init-.md) | `LambdaMethodRef(methodRef: `[`MethodInvokeSpec`](../../../com.github.jonathanxd.codeapi.common/-method-invoke-spec/index.md)`, target: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`, arguments: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`>, baseSam: `[`MethodTypeSpec`](../../../com.github.jonathanxd.codeapi.common/-method-type-spec/index.md)`, expectedTypes: `[`TypeSpec`](../../-type-spec/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [arguments](arguments.md) | `val arguments: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`>`<br>Arguments to pass to method ref |
| [baseSam](base-sam.md) | `val baseSam: `[`MethodTypeSpec`](../../../com.github.jonathanxd.codeapi.common/-method-type-spec/index.md)<br>Description of base SAM method, example, if the target functional interface is [Supplier](#), then the base SAM method is the [Supplier.get](#). |
| [expectedTypes](expected-types.md) | `val expectedTypes: `[`TypeSpec`](../../-type-spec/index.md)<br>Types expected by the caller of lambda SAM. |
| [methodRef](method-ref.md) | `val methodRef: `[`MethodInvokeSpec`](../../../com.github.jonathanxd.codeapi.common/-method-invoke-spec/index.md)<br>Method reference to invoke |
| [target](target.md) | `val target: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Target of method ref invocation |

### Inherited Properties

| Name | Summary |
|---|---|
| [array](../../-invoke-dynamic-base/-lambda-method-ref-base/array.md) | `open val array: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Array arguments |
| [bootstrap](../../-invoke-dynamic-base/-lambda-method-ref-base/bootstrap.md) | `open val bootstrap: `[`MethodInvokeSpec`](../../../com.github.jonathanxd.codeapi.common/-method-invoke-spec/index.md)<br>Bootstrap method invocation specification. |
| [bootstrapArgs](../../-invoke-dynamic-base/-lambda-method-ref-base/bootstrap-args.md) | `open val bootstrapArgs: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>`<br>Bootstrap method Arguments, must be an [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html), [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), [CodeType](../../../com.github.jonathanxd.codeapi.type/-code-type/index.md) or [MethodInvokeSpec](../../../com.github.jonathanxd.codeapi.common/-method-invoke-spec/index.md). |
| [currentTypes](../../-invoke-dynamic-base/-lambda-method-ref-base/current-types.md) | `open val currentTypes: `[`TypeSpec`](../../-type-spec/index.md)<br>Current types of lambda sam. |
| [dynamicMethod](../../-invoke-dynamic-base/-lambda-method-ref-base/dynamic-method.md) | `open val dynamicMethod: `[`DynamicMethodSpec`](../../../com.github.jonathanxd.codeapi.common/-dynamic-method-spec/index.md)<br>Specification of dynamic method. |
| [type](../../-invoke-dynamic-base/-lambda-method-ref-base/type.md) | `open val type: Type`<br>Return type of dynamic invocation |
| [types](../../-invoke-dynamic-base/-lambda-method-ref-base/types.md) | `open val types: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Type>`<br>Expected types of each argument |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): `[`Builder`](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |
