[CodeAPI](../../../../index.md) / [com.github.jonathanxd.codeapi.base](../../../index.md) / [InvokeDynamicBase](../../index.md) / [LambdaLocalCodeBase](../index.md) / [Builder](.)

# Builder

`interface Builder<out T : `[`LambdaLocalCodeBase`](../index.md)`, S : Builder<T, S>> : `[`Builder`](../../-lambda-method-ref-base/-builder/index.md)`<T, S>, `[`Builder`](../../../-arguments-holder/-builder/index.md)`<T, S>`

### Functions

| Name | Summary |
|---|---|
| [bootstrap](bootstrap.md) | `open fun bootstrap(value: `[`MethodInvokeSpec`](../../../../com.github.jonathanxd.codeapi.common/-method-invoke-spec/index.md)`): S`<br>See [InvokeDynamic.bootstrap](../../../-invoke-dynamic/bootstrap.md) |
| [bootstrapArgs](bootstrap-args.md) | `open fun bootstrapArgs(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>): S`<br>See [InvokeDynamic.bootstrapArgs](../../../-invoke-dynamic/bootstrap-args.md) |
| [dynamicMethod](dynamic-method.md) | `open fun dynamicMethod(value: `[`DynamicMethodSpec`](../../../../com.github.jonathanxd.codeapi.common/-dynamic-method-spec/index.md)`): S`<br>See [InvokeDynamic.dynamicMethod](../../../-invoke-dynamic/dynamic-method.md) |
| [localCode](local-code.md) | `abstract fun localCode(value: `[`LocalCode`](../../../-local-code/index.md)`): S`<br>See [LambdaLocalCodeBase.localCode](../local-code.md) |
| [methodRef](method-ref.md) | `open fun methodRef(value: `[`MethodInvokeSpec`](../../../../com.github.jonathanxd.codeapi.common/-method-invoke-spec/index.md)`): S`<br>See [LambdaMethodRefBase.methodRef](../../-lambda-method-ref-base/method-ref.md) |
| [type](type.md) | `open fun type(value: Type): S`<br>See [T.type](type.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [array](../../-lambda-method-ref-base/-builder/array.md) | `open fun array(value: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): S`<br>See [T.array](../../-lambda-method-ref-base/-builder/array.md) |
| [baseSam](../../-lambda-method-ref-base/-builder/base-sam.md) | `abstract fun baseSam(value: `[`MethodTypeSpec`](../../../../com.github.jonathanxd.codeapi.common/-method-type-spec/index.md)`): S`<br>See [LambdaMethodRefBase.baseSam](../../-lambda-method-ref-base/base-sam.md) |
| [expectedTypes](../../-lambda-method-ref-base/-builder/expected-types.md) | `abstract fun expectedTypes(value: `[`TypeSpec`](../../../-type-spec/index.md)`): S`<br>See [LambdaMethodRefBase.expectedTypes](../../-lambda-method-ref-base/expected-types.md) |
| [target](../../-lambda-method-ref-base/-builder/target.md) | `abstract fun target(value: `[`CodeInstruction`](../../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): S`<br>See [LambdaMethodRefBase.target](../../-lambda-method-ref-base/target.md) |

### Inheritors

| Name | Summary |
|---|---|
| [Builder](../../../-invoke-dynamic/-lambda-local-code/-builder/index.md) | `class Builder : Builder<`[`LambdaLocalCode`](../../../-invoke-dynamic/-lambda-local-code/index.md)`, `[`Builder`](../../../-invoke-dynamic/-lambda-local-code/-builder/index.md)`>` |
