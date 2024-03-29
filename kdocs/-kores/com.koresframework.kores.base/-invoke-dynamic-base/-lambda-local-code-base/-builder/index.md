//[Kores](../../../../../index.md)/[com.koresframework.kores.base](../../../index.md)/[InvokeDynamicBase](../../index.md)/[LambdaLocalCodeBase](../index.md)/[Builder](index.md)

# Builder

[jvm]\
interface [Builder](index.md)<out [T](index.md) : [InvokeDynamicBase.LambdaLocalCodeBase](../index.md), [S](index.md) : [InvokeDynamicBase.LambdaLocalCodeBase.Builder](index.md)<[T](index.md), [S](index.md)>> : [InvokeDynamicBase.LambdaMethodRefBase.Builder](../../-lambda-method-ref-base/-builder/index.md)<[T](index.md), [S](index.md)> , [ArgumentsHolder.Builder](../../../-arguments-holder/-builder/index.md)<[T](index.md), [S](index.md)>

## Functions

| Name | Summary |
|---|---|
| [arguments](../../../-arguments-holder/-builder/arguments.md) | [jvm]<br>open fun [arguments](../../../-arguments-holder/-builder/arguments.md)(vararg values: [Instruction](../../../../com.koresframework.kores/-instruction/index.md)): [S](index.md)<br>abstract fun [arguments](../../../-arguments-holder/-builder/arguments.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../../../com.koresframework.kores/-instruction/index.md)>): [S](index.md)<br>See T. |
| [array](../../-lambda-method-ref-base/-builder/array.md) | [jvm]<br>open override fun [array](../../-lambda-method-ref-base/-builder/array.md)(value: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [S](index.md)<br>See T. |
| [baseSam](../../-lambda-method-ref-base/-builder/base-sam.md) | [jvm]<br>abstract fun [baseSam](../../-lambda-method-ref-base/-builder/base-sam.md)(value: [MethodTypeSpec](../../../../com.koresframework.kores.common/-method-type-spec/index.md)): [S](index.md)<br>See [LambdaMethodRefBase.baseSam](../../-lambda-method-ref-base/base-sam.md) |
| [bootstrap](bootstrap.md) | [jvm]<br>open override fun [bootstrap](bootstrap.md)(value: [MethodInvokeSpec](../../../../com.koresframework.kores.common/-method-invoke-spec/index.md)): [S](index.md)<br>open override fun [bootstrap](../../-lambda-method-ref-base/-builder/bootstrap.md)(value: [MethodInvokeHandleSpec](../../../../com.koresframework.kores.common/-method-invoke-handle-spec/index.md)): [S](index.md)<br>See [InvokeDynamic.bootstrap](../../../-invoke-dynamic/bootstrap.md) |
| [bootstrapArgs](../../-builder/bootstrap-args.md) | [jvm]<br>open fun [bootstrapArgs](../../-builder/bootstrap-args.md)(vararg values: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)): [S](index.md)<br>open override fun [bootstrapArgs](bootstrap-args.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>): [S](index.md)<br>See [InvokeDynamic.bootstrapArgs](../../../-invoke-dynamic/bootstrap-args.md) |
| [build](../../../../com.koresframework.kores.builder/-builder/build.md) | [jvm]<br>abstract fun [build](../../../../com.koresframework.kores.builder/-builder/build.md)(): [T](index.md)<br>Build the object of type [T](../../../../com.koresframework.kores.builder/-builder/index.md). |
| [dynamicDescriptor](dynamic-descriptor.md) | [jvm]<br>open override fun [dynamicDescriptor](dynamic-descriptor.md)(value: [DynamicDescriptor](../../../../com.koresframework.kores.common/-dynamic-descriptor/index.md)): [S](index.md)<br>See [InvokeDynamic.dynamicDescriptor](../../../-invoke-dynamic/dynamic-descriptor.md) |
| [expectedTypes](../../-lambda-method-ref-base/-builder/expected-types.md) | [jvm]<br>abstract fun [expectedTypes](../../-lambda-method-ref-base/-builder/expected-types.md)(value: [TypeSpec](../../../-type-spec/index.md)): [S](index.md)<br>See [LambdaMethodRefBase.expectedTypes](../../-lambda-method-ref-base/expected-types.md) |
| [localCode](local-code.md) | [jvm]<br>abstract fun [localCode](local-code.md)(value: [LocalCode](../../../-local-code/index.md)): [S](index.md)<br>See [LambdaLocalCodeBase.localCode](../local-code.md) |
| [methodRef](method-ref.md) | [jvm]<br>open override fun [methodRef](method-ref.md)(value: [MethodInvokeSpec](../../../../com.koresframework.kores.common/-method-invoke-spec/index.md)): [S](index.md)<br>See [LambdaMethodRefBase.methodRef](../../-lambda-method-ref-base/method-ref.md) |
| [target](../../-lambda-method-ref-base/-builder/target.md) | [jvm]<br>abstract fun [target](../../-lambda-method-ref-base/-builder/target.md)(value: [Instruction](../../../../com.koresframework.kores/-instruction/index.md)): [S](index.md)<br>See [LambdaMethodRefBase.target](../../-lambda-method-ref-base/target.md) |
| [type](type.md) | [jvm]<br>open override fun [type](type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [S](index.md)<br>See T. |

## Inheritors

| Name |
|---|
| [InvokeDynamic.LambdaLocalCode](../../../-invoke-dynamic/-lambda-local-code/-builder/index.md) |
