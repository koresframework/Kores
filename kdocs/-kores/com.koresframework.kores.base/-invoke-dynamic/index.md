//[Kores](../../../index.md)/[com.koresframework.kores.base](../index.md)/[InvokeDynamic](index.md)

# InvokeDynamic

[jvm]\
data class [InvokeDynamic](index.md)(**bootstrap**: [MethodInvokeHandleSpec](../../com.koresframework.kores.common/-method-invoke-handle-spec/index.md), **dynamicDescriptor**: [DynamicDescriptor](../../com.koresframework.kores.common/-dynamic-descriptor/index.md), **bootstrapArgs**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>) : [InvokeDynamicBase](../-invoke-dynamic-base/index.md)

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [InvokeDynamicBase.Builder](../-invoke-dynamic-base/-builder/index.md)<[InvokeDynamic](index.md), [InvokeDynamic.Builder](-builder/index.md)> |
| [LambdaLocalCode](-lambda-local-code/index.md) | [jvm]<br>data class [LambdaLocalCode](-lambda-local-code/index.md)(**baseSam**: [MethodTypeSpec](../../com.koresframework.kores.common/-method-type-spec/index.md), **expectedTypes**: [TypeSpec](../-type-spec/index.md), **localCode**: [LocalCode](../-local-code/index.md), **arguments**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.koresframework.kores/-instruction/index.md)>) : [InvokeDynamicBase.LambdaLocalCodeBase](../-invoke-dynamic-base/-lambda-local-code-base/index.md) |
| [LambdaMethodRef](-lambda-method-ref/index.md) | [jvm]<br>data class [LambdaMethodRef](-lambda-method-ref/index.md)(**methodRef**: [MethodInvokeSpec](../../com.koresframework.kores.common/-method-invoke-spec/index.md), **target**: [Instruction](../../com.koresframework.kores/-instruction/index.md), **arguments**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.koresframework.kores/-instruction/index.md)>, **baseSam**: [MethodTypeSpec](../../com.koresframework.kores.common/-method-type-spec/index.md), **expectedTypes**: [TypeSpec](../-type-spec/index.md)) : [InvokeDynamicBase.LambdaMethodRefBase](../-invoke-dynamic-base/-lambda-method-ref-base/index.md) |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [InvokeDynamic.Builder](-builder/index.md) |

## Properties

| Name | Summary |
|---|---|
| [bootstrap](bootstrap.md) | [jvm]<br>open override val [bootstrap](bootstrap.md): [MethodInvokeHandleSpec](../../com.koresframework.kores.common/-method-invoke-handle-spec/index.md)<br>Bootstrap method invocation specification. |
| [bootstrapArgs](bootstrap-args.md) | [jvm]<br>open override val [bootstrapArgs](bootstrap-args.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)><br>Bootstrap method Arguments, must be one of the following types:<br><ul><li>[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)</li><li>[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html),</li><li>[Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)</li><li>[Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)</li><li>[Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)</li><li>[KoresType](../../com.koresframework.kores.type/-kores-type/index.md)/[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)</li><li>[MethodInvokeSpec](../../com.koresframework.kores.common/-method-invoke-spec/index.md) (normally translated into [MethodHandle](https://docs.oracle.com/javase/8/docs/api/java/lang/invoke/MethodHandle.html) at runtime, by the JVM)</li><li>[FieldAccessHandleSpec](../../com.koresframework.kores.common/-field-access-handle-spec/index.md) (normally translated into [MethodHandle](https://docs.oracle.com/javase/8/docs/api/java/lang/invoke/MethodHandle.html) at runtime, by the JVM)</li><li>[MethodInvokeHandleSpec](../../com.koresframework.kores.common/-method-invoke-handle-spec/index.md) (normally translated into [MethodHandle](https://docs.oracle.com/javase/8/docs/api/java/lang/invoke/MethodHandle.html) at runtime, by the JVM)</li><li>[TypeSpec](../-type-spec/index.md) (normally translated into [MethodType](https://docs.oracle.com/javase/8/docs/api/java/lang/invoke/MethodType.html) at runtime, by the JVM)</li><li>[DynamicConstantSpec](../../com.koresframework.kores.common/-dynamic-constant-spec/index.md) (as specified in [JEP 309](https://openjdk.java.net/jeps/309), translated into a constant).</li></ul><br>This is the value provided to the bootstrap method which resolves the target method to invoke. |
| [bootstrapLocalization](index.md#-1467954261%2FProperties%2F-1216412040) | [jvm]<br>open val [bootstrapLocalization](index.md#-1467954261%2FProperties%2F-1216412040): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>The [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) that declares the [bootstrap method](../-invoke-dynamic-base/bootstrap.md). |
| [dynamicDescriptor](dynamic-descriptor.md) | [jvm]<br>open override val [dynamicDescriptor](dynamic-descriptor.md): [DynamicDescriptor](../../com.koresframework.kores.common/-dynamic-descriptor/index.md)<br>Specification of the method to invoke dynamically. |
| [type](index.md#-182504722%2FProperties%2F-1216412040) | [jvm]<br>open override val [type](index.md#-182504722%2FProperties%2F-1216412040): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Return type of dynamic invocation |
