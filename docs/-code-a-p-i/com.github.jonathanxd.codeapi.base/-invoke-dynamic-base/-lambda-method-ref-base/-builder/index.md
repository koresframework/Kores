[CodeAPI](../../../../index.md) / [com.github.jonathanxd.codeapi.base](../../../index.md) / [InvokeDynamicBase](../../index.md) / [LambdaMethodRefBase](../index.md) / [Builder](.)

# Builder

`interface Builder<out T : `[`LambdaMethodRefBase`](../index.md)`, S : Builder<T, S>> : `[`Builder`](../../-builder/index.md)`<T, S>, `[`Builder`](../../../-arguments-holder/-builder/index.md)`<T, S>`

### Functions

| Name | Summary |
|---|---|
| [array](array.md) | `open fun array(value: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): S`<br>See [T.array](array.md) |
| [baseSam](base-sam.md) | `abstract fun baseSam(value: `[`MethodTypeSpec`](../../../../com.github.jonathanxd.codeapi.common/-method-type-spec/index.md)`): S`<br>See [LambdaMethodRefBase.baseSam](../base-sam.md) |
| [bootstrap](bootstrap.md) | `open fun bootstrap(value: `[`MethodInvokeSpec`](../../../../com.github.jonathanxd.codeapi.common/-method-invoke-spec/index.md)`): S`<br>See [InvokeDynamic.bootstrap](../../../-invoke-dynamic/bootstrap.md) |
| [bootstrapArgs](bootstrap-args.md) | `open fun bootstrapArgs(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>): S`<br>See [InvokeDynamic.bootstrapArgs](../../../-invoke-dynamic/bootstrap-args.md) |
| [dynamicMethod](dynamic-method.md) | `open fun dynamicMethod(value: `[`DynamicMethodSpec`](../../../../com.github.jonathanxd.codeapi.common/-dynamic-method-spec/index.md)`): S`<br>See [InvokeDynamic.dynamicMethod](../../../-invoke-dynamic/dynamic-method.md) |
| [expectedTypes](expected-types.md) | `abstract fun expectedTypes(value: `[`TypeSpec`](../../../-type-spec/index.md)`): S`<br>See [LambdaMethodRefBase.expectedTypes](../expected-types.md) |
| [methodRef](method-ref.md) | `abstract fun methodRef(value: `[`MethodInvokeSpec`](../../../../com.github.jonathanxd.codeapi.common/-method-invoke-spec/index.md)`): S`<br>See [LambdaMethodRefBase.methodRef](../method-ref.md) |
| [target](target.md) | `abstract fun target(value: `[`CodeInstruction`](../../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): S`<br>See [LambdaMethodRefBase.target](../target.md) |
| [type](type.md) | `open fun type(value: Type): S`<br>See [T.type](type.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [arguments](../../../-arguments-holder/-builder/arguments.md) | `abstract fun arguments(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): S`<br>`open fun arguments(vararg values: `[`CodeInstruction`](../../../../com.github.jonathanxd.codeapi/-code-instruction.md)`): S`<br>See [T.arguments](../../../-arguments-holder/-builder/arguments.md) |
| [bootstrapArgs](../../-builder/bootstrap-args.md) | `open fun bootstrapArgs(vararg values: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`): S`<br>See [InvokeDynamic.bootstrapArgs](../../../-invoke-dynamic/bootstrap-args.md) |

### Inheritors

| Name | Summary |
|---|---|
| [Builder](../../-lambda-local-code-base/-builder/index.md) | `interface Builder<out T : `[`LambdaLocalCodeBase`](../../-lambda-local-code-base/index.md)`, S : `[`Builder`](../../-lambda-local-code-base/-builder/index.md)`<T, S>> : Builder<T, S>, `[`Builder`](../../../-arguments-holder/-builder/index.md)`<T, S>` |
| [Builder](../../../-invoke-dynamic/-lambda-method-ref/-builder/index.md) | `class Builder : Builder<`[`LambdaMethodRef`](../../../-invoke-dynamic/-lambda-method-ref/index.md)`, `[`Builder`](../../../-invoke-dynamic/-lambda-method-ref/-builder/index.md)`>` |
