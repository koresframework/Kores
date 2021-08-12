//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.base](../../index.md)/[InvokeDynamicBase](../index.md)/[LambdaLocalCodeBase](index.md)

# LambdaLocalCodeBase

[jvm]\
interface [LambdaLocalCodeBase](index.md) : [InvokeDynamicBase.LambdaMethodRefBase](../-lambda-method-ref-base/index.md), [ArgumentsHolder](../../-arguments-holder/index.md)

Invocation of lambda function.

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>interface [Builder](-builder/index.md)<out [T](-builder/index.md) : [InvokeDynamicBase.LambdaLocalCodeBase](index.md), [S](-builder/index.md) : [InvokeDynamicBase.LambdaLocalCodeBase.Builder](-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>> : [InvokeDynamicBase.LambdaMethodRefBase.Builder](../-lambda-method-ref-base/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> , [ArgumentsHolder.Builder](../../-arguments-holder/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>abstract override fun [builder](builder.md)(): [InvokeDynamicBase.LambdaLocalCodeBase.Builder](-builder/index.md)<[InvokeDynamicBase.LambdaLocalCodeBase](index.md), *><br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [arguments](arguments.md) | [jvm]<br>abstract override val [arguments](arguments.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)><br>Argument to capture from current context and pass to [localCode](local-code.md) |
| [array](array.md) | [jvm]<br>open override val [array](array.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Array arguments |
| [baseSam](index.md#-124805133%2FProperties%2F-1216412040) | [jvm]<br>abstract val [baseSam](index.md#-124805133%2FProperties%2F-1216412040): [MethodTypeSpec](../../../com.github.jonathanxd.kores.common/-method-type-spec/index.md)<br>Description of base SAM method, example, if the target functional interface is [Supplier](https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html), then the base SAM method is the [Supplier.get](https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html#get--). |
| [bootstrap](index.md#-2037074989%2FProperties%2F-1216412040) | [jvm]<br>open override val [bootstrap](index.md#-2037074989%2FProperties%2F-1216412040): [MethodInvokeSpec](../../../com.github.jonathanxd.kores.common/-method-invoke-spec/index.md)<br>Bootstrap method invocation specification. |
| [bootstrapArgs](index.md#1633622646%2FProperties%2F-1216412040) | [jvm]<br>open override val [bootstrapArgs](index.md#1633622646%2FProperties%2F-1216412040): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)><br>Bootstrap method Arguments, must be an [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html), [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), [KoresType](../../../com.github.jonathanxd.kores.type/-kores-type/index.md) or [MethodInvokeSpec](../../../com.github.jonathanxd.kores.common/-method-invoke-spec/index.md). |
| [currentTypes](index.md#-2051688455%2FProperties%2F-1216412040) | [jvm]<br>open val [currentTypes](index.md#-2051688455%2FProperties%2F-1216412040): [TypeSpec](../../-type-spec/index.md)<br>Current types of lambda sam. |
| [dynamicMethod](index.md#-665348479%2FProperties%2F-1216412040) | [jvm]<br>open override val [dynamicMethod](index.md#-665348479%2FProperties%2F-1216412040): [DynamicMethodSpec](../../../com.github.jonathanxd.kores.common/-dynamic-method-spec/index.md)<br>Specification of dynamic method. |
| [expectedTypes](expected-types.md) | [jvm]<br>open override val [expectedTypes](expected-types.md): [TypeSpec](../../-type-spec/index.md)<br>Types expected by the caller of lambda SAM. |
| [localCode](local-code.md) | [jvm]<br>abstract val [localCode](local-code.md): [LocalCode](../../-local-code/index.md)<br>Local method to invoke |
| [methodRef](method-ref.md) | [jvm]<br>open override val [methodRef](method-ref.md): [MethodInvokeSpec](../../../com.github.jonathanxd.kores.common/-method-invoke-spec/index.md)<br>Method reference to invoke |
| [target](index.md#2041059080%2FProperties%2F-1216412040) | [jvm]<br>abstract val [target](index.md#2041059080%2FProperties%2F-1216412040): [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)<br>Target of method ref invocation |
| [type](index.md#-1431095169%2FProperties%2F-1216412040) | [jvm]<br>open override val [type](index.md#-1431095169%2FProperties%2F-1216412040): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Return type of dynamic invocation |
| [types](index.md#151977512%2FProperties%2F-1216412040) | [jvm]<br>open override val [types](index.md#151977512%2FProperties%2F-1216412040): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)><br>Expected types of each argument |

## Inheritors

| Name |
|---|
| [InvokeDynamic](../../-invoke-dynamic/-lambda-local-code/index.md) |
