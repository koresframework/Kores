//[Kores](../../../../index.md)/[com.koresframework.kores.base](../../index.md)/[InvokeDynamicBase](../index.md)/[LambdaMethodRefBase](index.md)

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
| [arguments](arguments.md) | [jvm]<br>abstract override val [arguments](arguments.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../../com.koresframework.kores/-instruction/index.md)><br>Arguments to pass to method ref |
| [array](array.md) | [jvm]<br>open override val [array](array.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Array arguments |
| [baseSam](base-sam.md) | [jvm]<br>abstract val [baseSam](base-sam.md): [MethodTypeSpec](../../../com.koresframework.kores.common/-method-type-spec/index.md)<br>Description of base SAM method, example, if the target functional interface is [Supplier](https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html), then the base SAM method is the [Supplier.get](https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html#get--). |
| [bootstrap](bootstrap.md) | [jvm]<br>open override val [bootstrap](bootstrap.md): [MethodInvokeHandleSpec](../../../com.koresframework.kores.common/-method-invoke-handle-spec/index.md)<br>Bootstrap method invocation specification. |
| [bootstrapArgs](bootstrap-args.md) | [jvm]<br>open override val [bootstrapArgs](bootstrap-args.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)><br>Bootstrap method Arguments, must be one of the following types:<br><ul><li>[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)</li><li>[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html),</li><li>[Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)</li><li>[Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)</li><li>[Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)</li><li>[KoresType](../../../com.koresframework.kores.type/-kores-type/index.md)/[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)</li><li>[MethodInvokeSpec](../../../com.koresframework.kores.common/-method-invoke-spec/index.md) (normally translated into [MethodHandle](https://docs.oracle.com/javase/8/docs/api/java/lang/invoke/MethodHandle.html) at runtime, by the JVM)</li><li>[FieldAccessHandleSpec](../../../com.koresframework.kores.common/-field-access-handle-spec/index.md) (normally translated into [MethodHandle](https://docs.oracle.com/javase/8/docs/api/java/lang/invoke/MethodHandle.html) at runtime, by the JVM)</li><li>[MethodInvokeHandleSpec](../../../com.koresframework.kores.common/-method-invoke-handle-spec/index.md) (normally translated into [MethodHandle](https://docs.oracle.com/javase/8/docs/api/java/lang/invoke/MethodHandle.html) at runtime, by the JVM)</li><li>[TypeSpec](../../-type-spec/index.md) (normally translated into [MethodType](https://docs.oracle.com/javase/8/docs/api/java/lang/invoke/MethodType.html) at runtime, by the JVM)</li><li>[DynamicConstantSpec](../../../com.koresframework.kores.common/-dynamic-constant-spec/index.md) (as specified in [JEP 309](https://openjdk.java.net/jeps/309), translated into a constant).</li></ul><br>This is the value provided to the bootstrap method which resolves the target method to invoke. |
| [bootstrapLocalization](index.md#-1333815028%2FProperties%2F-1216412040) | [jvm]<br>open val [bootstrapLocalization](index.md#-1333815028%2FProperties%2F-1216412040): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>The [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) that declares the [bootstrap method](../bootstrap.md). |
| [currentTypes](current-types.md) | [jvm]<br>open val [currentTypes](current-types.md): [TypeSpec](../../-type-spec/index.md)<br>Current types of lambda sam. |
| [dynamicMethod](dynamic-method.md) | [jvm]<br>open override val [dynamicMethod](dynamic-method.md): [DynamicMethodSpec](../../../com.koresframework.kores.common/-dynamic-method-spec/index.md)<br>Specification of the method to invoke dynamically. |
| [expectedTypes](expected-types.md) | [jvm]<br>abstract val [expectedTypes](expected-types.md): [TypeSpec](../../-type-spec/index.md)<br>Types expected by the caller of lambda SAM. |
| [methodRef](method-ref.md) | [jvm]<br>abstract val [methodRef](method-ref.md): [MethodInvokeSpec](../../../com.koresframework.kores.common/-method-invoke-spec/index.md)<br>Method reference to invoke |
| [target](target.md) | [jvm]<br>abstract val [target](target.md): [Instruction](../../../com.koresframework.kores/-instruction/index.md)<br>Target of method ref invocation |
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
