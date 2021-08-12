//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[InvokeDynamic](index.md)

# InvokeDynamic

[jvm]\
data class [InvokeDynamic](index.md)(**bootstrap**: [MethodInvokeSpec](../../com.github.jonathanxd.kores.common/-method-invoke-spec/index.md), **dynamicMethod**: [DynamicMethodSpec](../../com.github.jonathanxd.kores.common/-dynamic-method-spec/index.md), **bootstrapArgs**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>) : [InvokeDynamicBase](../-invoke-dynamic-base/index.md)

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [InvokeDynamicBase.Builder](../-invoke-dynamic-base/-builder/index.md)<[InvokeDynamic](index.md), [InvokeDynamic.Builder](-builder/index.md)> |
| [LambdaLocalCode](-lambda-local-code/index.md) | [jvm]<br>data class [LambdaLocalCode](-lambda-local-code/index.md)(**baseSam**: [MethodTypeSpec](../../com.github.jonathanxd.kores.common/-method-type-spec/index.md), **expectedTypes**: [TypeSpec](../-type-spec/index.md), **localCode**: [LocalCode](../-local-code/index.md), **arguments**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)>) : [InvokeDynamicBase.LambdaLocalCodeBase](../-invoke-dynamic-base/-lambda-local-code-base/index.md) |
| [LambdaMethodRef](-lambda-method-ref/index.md) | [jvm]<br>data class [LambdaMethodRef](-lambda-method-ref/index.md)(**methodRef**: [MethodInvokeSpec](../../com.github.jonathanxd.kores.common/-method-invoke-spec/index.md), **target**: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), **arguments**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)>, **baseSam**: [MethodTypeSpec](../../com.github.jonathanxd.kores.common/-method-type-spec/index.md), **expectedTypes**: [TypeSpec](../-type-spec/index.md)) : [InvokeDynamicBase.LambdaMethodRefBase](../-invoke-dynamic-base/-lambda-method-ref-base/index.md) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [InvokeDynamic.Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [bootstrap](bootstrap.md) | [jvm]<br>open override val [bootstrap](bootstrap.md): [MethodInvokeSpec](../../com.github.jonathanxd.kores.common/-method-invoke-spec/index.md)<br>Bootstrap method invocation specification. |
| [bootstrapArgs](bootstrap-args.md) | [jvm]<br>open override val [bootstrapArgs](bootstrap-args.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)><br>Bootstrap method Arguments, must be an [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html), [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), [KoresType](../../com.github.jonathanxd.kores.type/-kores-type/index.md) or [MethodInvokeSpec](../../com.github.jonathanxd.kores.common/-method-invoke-spec/index.md). |
| [dynamicMethod](dynamic-method.md) | [jvm]<br>open override val [dynamicMethod](dynamic-method.md): [DynamicMethodSpec](../../com.github.jonathanxd.kores.common/-dynamic-method-spec/index.md)<br>Specification of dynamic method. |
| [type](index.md#554082682%2FProperties%2F-1216412040) | [jvm]<br>open override val [type](index.md#554082682%2FProperties%2F-1216412040): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Return type of dynamic invocation |
