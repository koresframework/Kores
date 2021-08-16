//[Kores](../../../../index.md)/[com.koresframework.kores.base](../../index.md)/[InvokeDynamic](../index.md)/[LambdaLocalCode](index.md)

# LambdaLocalCode

[jvm]\
data class [LambdaLocalCode](index.md)(**baseSam**: [MethodTypeSpec](../../../com.koresframework.kores.common/-method-type-spec/index.md), **expectedTypes**: [TypeSpec](../../-type-spec/index.md), **localCode**: [LocalCode](../../-local-code/index.md), **arguments**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../../com.koresframework.kores/-instruction/index.md)>) : [InvokeDynamicBase.LambdaLocalCodeBase](../../-invoke-dynamic-base/-lambda-local-code-base/index.md)

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [InvokeDynamicBase.LambdaLocalCodeBase.Builder](../../-invoke-dynamic-base/-lambda-local-code-base/-builder/index.md)<[InvokeDynamic.LambdaLocalCode](index.md), [InvokeDynamic.LambdaLocalCode.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [InvokeDynamic.LambdaLocalCode.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [arguments](arguments.md) | [jvm]<br>open override val [arguments](arguments.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../../com.koresframework.kores/-instruction/index.md)><br>Argument to capture from current context and pass to [localCode](local-code.md) |
| [array](index.md#213304694%2FProperties%2F-1216412040) | [jvm]<br>open override val [array](index.md#213304694%2FProperties%2F-1216412040): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Array arguments |
| [baseSam](base-sam.md) | [jvm]<br>open override val [baseSam](base-sam.md): [MethodTypeSpec](../../../com.koresframework.kores.common/-method-type-spec/index.md)<br>Description of base SAM method, example, if the target functional interface is [Supplier](https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html), then the base SAM method is the [Supplier.get](https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html#get--). |
| [bootstrap](index.md#-1866173951%2FProperties%2F-1216412040) | [jvm]<br>open override val [bootstrap](index.md#-1866173951%2FProperties%2F-1216412040): [MethodInvokeHandleSpec](../../../com.koresframework.kores.common/-method-invoke-handle-spec/index.md)<br>Bootstrap method invocation specification. |
| [bootstrapArgs](index.md#872944036%2FProperties%2F-1216412040) | [jvm]<br>open override val [bootstrapArgs](index.md#872944036%2FProperties%2F-1216412040): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)><br>Bootstrap method Arguments, must be one of the following types:<br><ul><li>[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)</li><li>[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html),</li><li>[Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)</li><li>[Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)</li><li>[Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)</li><li>[KoresType](../../../com.koresframework.kores.type/-kores-type/index.md)/[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)</li><li>[MethodInvokeSpec](../../../com.koresframework.kores.common/-method-invoke-spec/index.md) (normally translated into [MethodHandle](https://docs.oracle.com/javase/8/docs/api/java/lang/invoke/MethodHandle.html) at runtime, by the JVM)</li><li>[FieldAccessHandleSpec](../../../com.koresframework.kores.common/-field-access-handle-spec/index.md) (normally translated into [MethodHandle](https://docs.oracle.com/javase/8/docs/api/java/lang/invoke/MethodHandle.html) at runtime, by the JVM)</li><li>[MethodInvokeHandleSpec](../../../com.koresframework.kores.common/-method-invoke-handle-spec/index.md) (normally translated into [MethodHandle](https://docs.oracle.com/javase/8/docs/api/java/lang/invoke/MethodHandle.html) at runtime, by the JVM)</li><li>[TypeSpec](../../-type-spec/index.md) (normally translated into [MethodType](https://docs.oracle.com/javase/8/docs/api/java/lang/invoke/MethodType.html) at runtime, by the JVM)</li><li>[DynamicConstantSpec](../../../com.koresframework.kores.common/-dynamic-constant-spec/index.md) (as specified in [JEP 309](https://openjdk.java.net/jeps/309), translated into a constant).</li></ul><br>This is the value provided to the bootstrap method which resolves the target method to invoke. |
| [bootstrapLocalization](index.md#-746167448%2FProperties%2F-1216412040) | [jvm]<br>open val [bootstrapLocalization](index.md#-746167448%2FProperties%2F-1216412040): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>The [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) that declares the [bootstrap method](../../-invoke-dynamic-base/bootstrap.md). |
| [currentTypes](index.md#-275111157%2FProperties%2F-1216412040) | [jvm]<br>open val [currentTypes](index.md#-275111157%2FProperties%2F-1216412040): [TypeSpec](../../-type-spec/index.md)<br>Current types of lambda sam. |
| [dynamicDescriptor](index.md#335598945%2FProperties%2F-1216412040) | [jvm]<br>open override val [dynamicDescriptor](index.md#335598945%2FProperties%2F-1216412040): [DynamicMethodSpec](../../../com.koresframework.kores.common/-dynamic-method-spec/index.md)<br>Specification of the method to invoke dynamically. |
| [expectedTypes](expected-types.md) | [jvm]<br>open override val [expectedTypes](expected-types.md): [TypeSpec](../../-type-spec/index.md)<br>Types expected by the caller of lambda SAM. |
| [localCode](local-code.md) | [jvm]<br>open override val [localCode](local-code.md): [LocalCode](../../-local-code/index.md)<br>Local method to invoke |
| [methodRef](index.md#363955453%2FProperties%2F-1216412040) | [jvm]<br>open override val [methodRef](index.md#363955453%2FProperties%2F-1216412040): [MethodInvokeSpec](../../../com.koresframework.kores.common/-method-invoke-spec/index.md)<br>Method reference to invoke |
| [target](target.md) | [jvm]<br>open override val [target](target.md): [Instruction](../../../com.koresframework.kores/-instruction/index.md)<br>Target of method ref invocation |
| [type](index.md#1085592977%2FProperties%2F-1216412040) | [jvm]<br>open override val [type](index.md#1085592977%2FProperties%2F-1216412040): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Return type of dynamic invocation |
| [types](types.md) | [jvm]<br>open override val [types](types.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)><br>Expected types of each argument |
