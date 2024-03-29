//[Kores](../../../../../index.md)/[com.github.jonathanxd.kores.base](../../../index.md)/[InvokeDynamic](../../index.md)/[LambdaLocalCode](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [InvokeDynamicBase.LambdaLocalCodeBase.Builder](../../../-invoke-dynamic-base/-lambda-local-code-base/-builder/index.md)<[InvokeDynamic.LambdaLocalCode](../index.md), [InvokeDynamic.LambdaLocalCode.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [InvokeDynamic.LambdaLocalCode](../index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [arguments](../../../-arguments-holder/-builder/arguments.md) | [jvm]<br>open fun [arguments](../../../-arguments-holder/-builder/arguments.md)(vararg values: [Instruction](../../../../com.github.jonathanxd.kores/-instruction/index.md)): [InvokeDynamic.LambdaLocalCode.Builder](index.md)<br>open override fun [arguments](arguments.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../../../com.github.jonathanxd.kores/-instruction/index.md)>): [InvokeDynamic.LambdaLocalCode.Builder](index.md)<br>See T. |
| [array](array.md) | [jvm]<br>open override fun [array](array.md)(value: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [InvokeDynamic.LambdaLocalCode.Builder](index.md)<br>See T. |
| [baseSam](base-sam.md) | [jvm]<br>open override fun [baseSam](base-sam.md)(value: [MethodTypeSpec](../../../../com.github.jonathanxd.kores.common/-method-type-spec/index.md)): [InvokeDynamic.LambdaLocalCode.Builder](index.md)<br>See LambdaMethodRefBase. |
| [bootstrap](../../../-invoke-dynamic-base/-lambda-local-code-base/-builder/bootstrap.md) | [jvm]<br>open override fun [bootstrap](../../../-invoke-dynamic-base/-lambda-local-code-base/-builder/bootstrap.md)(value: [MethodInvokeSpec](../../../../com.github.jonathanxd.kores.common/-method-invoke-spec/index.md)): [InvokeDynamic.LambdaLocalCode.Builder](index.md)<br>open override fun [bootstrap](../../../-invoke-dynamic-base/-lambda-method-ref-base/-builder/bootstrap.md)(value: [MethodInvokeHandleSpec](../../../../com.github.jonathanxd.kores.common/-method-invoke-handle-spec/index.md)): [InvokeDynamic.LambdaLocalCode.Builder](index.md)<br>See [InvokeDynamic.bootstrap](../../bootstrap.md) |
| [bootstrapArgs](../../../-invoke-dynamic-base/-builder/bootstrap-args.md) | [jvm]<br>open fun [bootstrapArgs](../../../-invoke-dynamic-base/-builder/bootstrap-args.md)(vararg values: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)): [InvokeDynamic.LambdaLocalCode.Builder](index.md)<br>open override fun [bootstrapArgs](../../../-invoke-dynamic-base/-lambda-local-code-base/-builder/bootstrap-args.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>): [InvokeDynamic.LambdaLocalCode.Builder](index.md)<br>See [InvokeDynamic.bootstrapArgs](../../bootstrap-args.md) |
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [InvokeDynamic.LambdaLocalCode](../index.md)<br>Build the object of type [T](../../../../com.github.jonathanxd.kores.builder/-builder/index.md). |
| [dynamicMethod](../../../-invoke-dynamic-base/-lambda-local-code-base/-builder/dynamic-method.md) | [jvm]<br>open override fun [dynamicMethod](../../../-invoke-dynamic-base/-lambda-local-code-base/-builder/dynamic-method.md)(value: [DynamicMethodSpec](../../../../com.github.jonathanxd.kores.common/-dynamic-method-spec/index.md)): [InvokeDynamic.LambdaLocalCode.Builder](index.md)<br>See [InvokeDynamic.dynamicMethod](../../dynamic-method.md) |
| [expectedTypes](expected-types.md) | [jvm]<br>open override fun [expectedTypes](expected-types.md)(value: [TypeSpec](../../../-type-spec/index.md)): [InvokeDynamic.LambdaLocalCode.Builder](index.md)<br>See LambdaMethodRefBase. |
| [localCode](local-code.md) | [jvm]<br>open override fun [localCode](local-code.md)(value: [LocalCode](../../../-local-code/index.md)): [InvokeDynamic.LambdaLocalCode.Builder](index.md)<br>See LambdaLocalCodeBase. |
| [methodRef](../../../-invoke-dynamic-base/-lambda-local-code-base/-builder/method-ref.md) | [jvm]<br>open override fun [methodRef](../../../-invoke-dynamic-base/-lambda-local-code-base/-builder/method-ref.md)(value: [MethodInvokeSpec](../../../../com.github.jonathanxd.kores.common/-method-invoke-spec/index.md)): [InvokeDynamic.LambdaLocalCode.Builder](index.md)<br>See [LambdaMethodRefBase.methodRef](../../../-invoke-dynamic-base/-lambda-method-ref-base/method-ref.md) |
| [target](target.md) | [jvm]<br>open override fun [target](target.md)(value: [Instruction](../../../../com.github.jonathanxd.kores/-instruction/index.md)): [InvokeDynamic.LambdaLocalCode.Builder](index.md)<br>See LambdaMethodRefBase. |
| [type](../../../-invoke-dynamic-base/-lambda-local-code-base/-builder/type.md) | [jvm]<br>open override fun [type](../../../-invoke-dynamic-base/-lambda-local-code-base/-builder/type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [InvokeDynamic.LambdaLocalCode.Builder](index.md)<br>See T. |

## Properties

| Name | Summary |
|---|---|
| [arguments](arguments.md) | [jvm]<br>var [arguments](arguments.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../../../com.github.jonathanxd.kores/-instruction/index.md)> |
| [baseSam](base-sam.md) | [jvm]<br>lateinit var [baseSam](base-sam.md): [MethodTypeSpec](../../../../com.github.jonathanxd.kores.common/-method-type-spec/index.md) |
| [expectedTypes](expected-types.md) | [jvm]<br>lateinit var [expectedTypes](expected-types.md): [TypeSpec](../../../-type-spec/index.md) |
| [localCode](local-code.md) | [jvm]<br>lateinit var [localCode](local-code.md): [LocalCode](../../../-local-code/index.md) |
