//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.base](../../index.md)/[InvokeDynamicBase](../index.md)/[LambdaMethodRefBase](index.md)

# LambdaMethodRefBase

[jvm]\
interface [LambdaMethodRefBase](index.md) : [InvokeDynamicBase](../index.md), [ArgumentsHolder](../../-arguments-holder/index.md)

Dynamic invocation of lambda method reference.

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>interface [Builder](-builder/index.md)<out [T](-builder/index.md) : [InvokeDynamicBase.LambdaMethodRefBase](index.md), [S](-builder/index.md) : [InvokeDynamicBase.LambdaMethodRefBase.Builder](-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>> : [InvokeDynamicBase.Builder](../-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> , [ArgumentsHolder.Builder](../../-arguments-holder/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>abstract override fun [builder](builder.md)(): [InvokeDynamicBase.LambdaMethodRefBase.Builder](-builder/index.md)<[InvokeDynamicBase.LambdaMethodRefBase](index.md), *><br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [arguments](arguments.md) | [jvm]<br>abstract override val [arguments](arguments.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)><br>Arguments to pass to method ref |
| [array](array.md) | [jvm]<br>open override val [array](array.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Array arguments |
| [baseSam](base-sam.md) | [jvm]<br>abstract val [baseSam](base-sam.md): [MethodTypeSpec](../../../com.github.jonathanxd.kores.common/-method-type-spec/index.md)<br>Description of base SAM method, example, if the target functional interface is [Supplier](https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html), then the base SAM method is the [Supplier.get](https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html#get--). |
| [bootstrap](bootstrap.md) | [jvm]<br>open override val [bootstrap](bootstrap.md): [MethodInvokeSpec](../../../com.github.jonathanxd.kores.common/-method-invoke-spec/index.md)<br>Bootstrap method invocation specification. |
| [bootstrapArgs](bootstrap-args.md) | [jvm]<br>open override val [bootstrapArgs](bootstrap-args.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)><br>Bootstrap method Arguments, must be an [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html), [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), [KoresType](../../../com.github.jonathanxd.kores.type/-kores-type/index.md) or [MethodInvokeSpec](../../../com.github.jonathanxd.kores.common/-method-invoke-spec/index.md). |
| [currentTypes](current-types.md) | [jvm]<br>open val [currentTypes](current-types.md): [TypeSpec](../../-type-spec/index.md)<br>Current types of lambda sam. |
| [dynamicMethod](dynamic-method.md) | [jvm]<br>open override val [dynamicMethod](dynamic-method.md): [DynamicMethodSpec](../../../com.github.jonathanxd.kores.common/-dynamic-method-spec/index.md)<br>Specification of dynamic method. |
| [expectedTypes](expected-types.md) | [jvm]<br>abstract val [expectedTypes](expected-types.md): [TypeSpec](../../-type-spec/index.md)<br>Types expected by the caller of lambda SAM. |
| [methodRef](method-ref.md) | [jvm]<br>abstract val [methodRef](method-ref.md): [MethodInvokeSpec](../../../com.github.jonathanxd.kores.common/-method-invoke-spec/index.md)<br>Method reference to invoke |
| [target](target.md) | [jvm]<br>abstract val [target](target.md): [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)<br>Target of method ref invocation |
| [type](type.md) | [jvm]<br>open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Return type of dynamic invocation |
| [types](types.md) | [jvm]<br>open override val [types](types.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)><br>Expected types of each argument |

## Inheritors

| Name |
|---|
| [InvokeDynamicBase](../-lambda-local-code-base/index.md) |
| [InvokeDynamic](../../-invoke-dynamic/-lambda-method-ref/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [additionalArgumentsType](../../additional-arguments-type.md) | [jvm]<br>val [InvokeDynamicBase.LambdaMethodRefBase](index.md).[additionalArgumentsType](../../additional-arguments-type.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)> |
