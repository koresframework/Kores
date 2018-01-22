[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [InvokeDynamicBase](../index.md) / [LambdaMethodRefBase](.)

# LambdaMethodRefBase

`interface LambdaMethodRefBase : `[`InvokeDynamicBase`](../index.md)`, `[`ArgumentsHolder`](../../-arguments-holder/index.md)

Dynamic invocation of lambda method reference.

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `interface Builder<out T : LambdaMethodRefBase, S : `[`Builder`](-builder/index.md)`<T, S>> : `[`Builder`](../-builder/index.md)`<T, S>, `[`Builder`](../../-arguments-holder/-builder/index.md)`<T, S>` |

### Properties

| Name | Summary |
|---|---|
| [arguments](arguments.md) | `abstract val arguments: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)`>`<br>Arguments to pass to method ref |
| [array](array.md) | `open val array: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Array arguments |
| [baseSam](base-sam.md) | `abstract val baseSam: `[`MethodTypeSpec`](../../../com.github.jonathanxd.codeapi.common/-method-type-spec/index.md)<br>Description of base SAM method, example, if the target functional interface is [Supplier](#), then the base SAM method is the [Supplier.get](#). |
| [bootstrap](bootstrap.md) | `open val bootstrap: `[`MethodInvokeSpec`](../../../com.github.jonathanxd.codeapi.common/-method-invoke-spec/index.md)<br>Bootstrap method invocation specification. |
| [bootstrapArgs](bootstrap-args.md) | `open val bootstrapArgs: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>`<br>Bootstrap method Arguments, must be an [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html), [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), [CodeType](../../../com.github.jonathanxd.codeapi.type/-code-type/index.md) or [MethodInvokeSpec](../../../com.github.jonathanxd.codeapi.common/-method-invoke-spec/index.md). |
| [currentTypes](current-types.md) | `open val currentTypes: `[`TypeSpec`](../../-type-spec/index.md)<br>Current types of lambda sam. |
| [dynamicMethod](dynamic-method.md) | `open val dynamicMethod: `[`DynamicMethodSpec`](../../../com.github.jonathanxd.codeapi.common/-dynamic-method-spec/index.md)<br>Specification of dynamic method. |
| [expectedTypes](expected-types.md) | `abstract val expectedTypes: `[`TypeSpec`](../../-type-spec/index.md)<br>Types expected by the caller of lambda SAM. |
| [methodRef](method-ref.md) | `abstract val methodRef: `[`MethodInvokeSpec`](../../../com.github.jonathanxd.codeapi.common/-method-invoke-spec/index.md)<br>Method reference to invoke |
| [target](target.md) | `abstract val target: `[`CodeInstruction`](../../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Target of method ref invocation |
| [type](type.md) | `open val type: Type`<br>Return type of dynamic invocation |
| [types](types.md) | `open val types: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Type>`<br>Expected types of each argument |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `abstract fun builder(): `[`Builder`](-builder/index.md)`<LambdaMethodRefBase, *>`<br>This builder may or may not accept null values, it depends on implementation. |

### Extension Properties

| Name | Summary |
|---|---|
| [additionalArgumentsType](../../additional-arguments-type.md) | `val LambdaMethodRefBase.additionalArgumentsType: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Type>` |

### Inheritors

| Name | Summary |
|---|---|
| [LambdaLocalCodeBase](../-lambda-local-code-base/index.md) | `interface LambdaLocalCodeBase : LambdaMethodRefBase, `[`ArgumentsHolder`](../../-arguments-holder/index.md)<br>Invocation of lambda function. |
| [LambdaMethodRef](../../-invoke-dynamic/-lambda-method-ref/index.md) | `data class LambdaMethodRef : LambdaMethodRefBase` |
