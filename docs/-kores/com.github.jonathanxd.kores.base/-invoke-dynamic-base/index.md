//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[InvokeDynamicBase](index.md)

# InvokeDynamicBase

[jvm]\
interface [InvokeDynamicBase](index.md) : [TypedInstruction](../-typed-instruction/index.md)

A dynamic invocation of a method.

Note: this class does not extends [MethodInvocation](../-method-invocation/index.md) because it is not a normal invocation.

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>interface [Builder](-builder/index.md)<out [T](-builder/index.md) : [InvokeDynamicBase](index.md), [S](-builder/index.md) : [InvokeDynamicBase.Builder](-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>> : [Typed.Builder](../-typed/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> |
| [LambdaLocalCodeBase](-lambda-local-code-base/index.md) | [jvm]<br>interface [LambdaLocalCodeBase](-lambda-local-code-base/index.md) : [InvokeDynamicBase.LambdaMethodRefBase](-lambda-method-ref-base/index.md), [ArgumentsHolder](../-arguments-holder/index.md)<br>Invocation of lambda function. |
| [LambdaMethodRefBase](-lambda-method-ref-base/index.md) | [jvm]<br>interface [LambdaMethodRefBase](-lambda-method-ref-base/index.md) : [InvokeDynamicBase](index.md), [ArgumentsHolder](../-arguments-holder/index.md)<br>Dynamic invocation of lambda method reference. |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>abstract override fun [builder](builder.md)(): [InvokeDynamicBase.Builder](-builder/index.md)<[InvokeDynamicBase](index.md), *><br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [bootstrap](bootstrap.md) | [jvm]<br>abstract val [bootstrap](bootstrap.md): [MethodInvokeSpec](../../com.github.jonathanxd.kores.common/-method-invoke-spec/index.md)<br>Bootstrap method invocation specification. |
| [bootstrapArgs](bootstrap-args.md) | [jvm]<br>abstract val [bootstrapArgs](bootstrap-args.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)><br>Bootstrap method Arguments, must be an [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html), [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), [KoresType](../../com.github.jonathanxd.kores.type/-kores-type/index.md) or [MethodInvokeSpec](../../com.github.jonathanxd.kores.common/-method-invoke-spec/index.md). |
| [dynamicMethod](dynamic-method.md) | [jvm]<br>abstract val [dynamicMethod](dynamic-method.md): [DynamicMethodSpec](../../com.github.jonathanxd.kores.common/-dynamic-method-spec/index.md)<br>Specification of dynamic method. |
| [type](type.md) | [jvm]<br>open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Return type of dynamic invocation |

## Inheritors

| Name |
|---|
| [InvokeDynamicBase](-lambda-method-ref-base/index.md) |
| [InvokeDynamic](../-invoke-dynamic/index.md) |
