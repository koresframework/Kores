//[Kores](../../../../../index.md)/[com.github.jonathanxd.kores.base](../../../index.md)/[InvokeDynamicBase](../../index.md)/[LambdaMethodRefBase](../index.md)/[Builder](index.md)

# Builder

[jvm]\
interface [Builder](index.md)<out [T](index.md) : [InvokeDynamicBase.LambdaMethodRefBase](../index.md), [S](index.md) : [InvokeDynamicBase.LambdaMethodRefBase.Builder](index.md)<[T](index.md), [S](index.md)>> : [InvokeDynamicBase.Builder](../../-builder/index.md)<[T](index.md), [S](index.md)> , [ArgumentsHolder.Builder](../../../-arguments-holder/-builder/index.md)<[T](index.md), [S](index.md)>

## Functions

| Name | Summary |
|---|---|
| [arguments](../../../-arguments-holder/-builder/arguments.md) | [jvm]<br>open fun [arguments](../../../-arguments-holder/-builder/arguments.md)(vararg values: [Instruction](../../../../com.github.jonathanxd.kores/-instruction/index.md)): [S](index.md)<br>abstract fun [arguments](../../../-arguments-holder/-builder/arguments.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../../../com.github.jonathanxd.kores/-instruction/index.md)>): [S](index.md)<br>See T. |
| [array](array.md) | [jvm]<br>open override fun [array](array.md)(value: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [S](index.md)<br>See T. |
| [baseSam](base-sam.md) | [jvm]<br>abstract fun [baseSam](base-sam.md)(value: [MethodTypeSpec](../../../../com.github.jonathanxd.kores.common/-method-type-spec/index.md)): [S](index.md)<br>See [LambdaMethodRefBase.baseSam](../base-sam.md) |
| [bootstrap](../../-builder/bootstrap.md) | [jvm]<br>open fun [bootstrap](../../-builder/bootstrap.md)(value: [MethodInvokeSpec](../../../../com.github.jonathanxd.kores.common/-method-invoke-spec/index.md)): [S](index.md)<br>open override fun [bootstrap](bootstrap.md)(value: [MethodInvokeHandleSpec](../../../../com.github.jonathanxd.kores.common/-method-invoke-handle-spec/index.md)): [S](index.md)<br>See [InvokeDynamic.bootstrap](../../../-invoke-dynamic/bootstrap.md) |
| [bootstrapArgs](../../-builder/bootstrap-args.md) | [jvm]<br>open fun [bootstrapArgs](../../-builder/bootstrap-args.md)(vararg values: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)): [S](index.md)<br>open override fun [bootstrapArgs](bootstrap-args.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>): [S](index.md)<br>See [InvokeDynamic.bootstrapArgs](../../../-invoke-dynamic/bootstrap-args.md) |
| [build](../../../../com.github.jonathanxd.kores.builder/-builder/build.md) | [jvm]<br>abstract fun [build](../../../../com.github.jonathanxd.kores.builder/-builder/build.md)(): [T](index.md)<br>Build the object of type [T](../../../../com.github.jonathanxd.kores.builder/-builder/index.md). |
| [dynamicMethod](dynamic-method.md) | [jvm]<br>open override fun [dynamicMethod](dynamic-method.md)(value: [DynamicMethodSpec](../../../../com.github.jonathanxd.kores.common/-dynamic-method-spec/index.md)): [S](index.md)<br>See [InvokeDynamic.dynamicMethod](../../../-invoke-dynamic/dynamic-method.md) |
| [expectedTypes](expected-types.md) | [jvm]<br>abstract fun [expectedTypes](expected-types.md)(value: [TypeSpec](../../../-type-spec/index.md)): [S](index.md)<br>See [LambdaMethodRefBase.expectedTypes](../expected-types.md) |
| [methodRef](method-ref.md) | [jvm]<br>abstract fun [methodRef](method-ref.md)(value: [MethodInvokeSpec](../../../../com.github.jonathanxd.kores.common/-method-invoke-spec/index.md)): [S](index.md)<br>See [LambdaMethodRefBase.methodRef](../method-ref.md) |
| [target](target.md) | [jvm]<br>abstract fun [target](target.md)(value: [Instruction](../../../../com.github.jonathanxd.kores/-instruction/index.md)): [S](index.md)<br>See [LambdaMethodRefBase.target](../target.md) |
| [type](type.md) | [jvm]<br>open override fun [type](type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [S](index.md)<br>See T. |

## Inheritors

| Name |
|---|
| [InvokeDynamicBase.LambdaLocalCodeBase](../../-lambda-local-code-base/-builder/index.md) |
| [InvokeDynamic.LambdaMethodRef](../../../-invoke-dynamic/-lambda-method-ref/-builder/index.md) |
