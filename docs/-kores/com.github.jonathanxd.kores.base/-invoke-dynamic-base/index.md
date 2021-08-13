//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[InvokeDynamicBase](index.md)

# InvokeDynamicBase

[jvm]\
interface [InvokeDynamicBase](index.md) : [TypedInstruction](../-typed-instruction/index.md)

Represents a dynamic invocation of a method. The mechanism of a dynamic invocation is very simple, when JVM encounters an invokedynamic instruction, it calls the [bootstrap](bootstrap.md) method (which is a static method defined in [bootstrapLocalization](bootstrap-localization.md)) to resolve the [target method](dynamic-method.md). Once resolved, the [target method](dynamic-method.md) keeps linked to the call-site and there is no way to revert this. Subsequent calls are routed to the resolved method without invoking the bootstrap. This allows optimizations to take in place (like the JIT compiler optimizations).

The [dynamicMethod](dynamic-method.md) corresponds to the dynamic method that need to be resolved, it contains important information about the method that need to be resolved. The [DynamicMethodSpec.name](../../com.github.jonathanxd.kores.common/-dynamic-method-spec/name.md) and [DynamicMethodSpec.typeSpec](../../com.github.jonathanxd.kores.common/-dynamic-method-spec/type-spec.md) (which are provided as [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) and [MethodType](https://docs.oracle.com/javase/8/docs/api/java/lang/invoke/MethodType.html), respectively) are available to the bootstrap method, but [DynamicMethodSpec.arguments](../../com.github.jonathanxd.kores.common/-dynamic-method-spec/arguments.md) is not, as specified in the documentation of the property.

Additional information can be provided through [bootstrapArgs](bootstrap-args.md) and are passed as the last argument of the [bootstrap method](bootstrap.md). The last parameter of [bootstrap method](bootstrap.md) can be a vararg, an [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html) of [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), or various parameters of the types accepted by bootstrap methods as specified in JVM Specification and in the java.lang.invoke package documentation. The known allowed parameter types are:

<ul><li>Literal Constants</li><li>[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html), [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) (it includes [dynamic constant](../../com.github.jonathanxd.kores.common/-dynamic-constant-spec/index.md)).</li><li>Type Constants</li><li>[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)/[Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)</li><li>Field and Method specification</li><li>[MethodHandle](https://docs.oracle.com/javase/8/docs/api/java/lang/invoke/MethodHandle.html)</li><li>Descriptors</li><li>[MethodType](https://docs.oracle.com/javase/8/docs/api/java/lang/invoke/MethodType.html)/[TypeDescriptor](https://docs.oracle.com/javase/8/docs/api/java/lang/invoke/TypeDescriptor.html) (since Java 12)</li></ul>

###  Relevant documents

<ul><li>[Java Virtual Machine Support for Non-Java Languages](https://docs.oracle.com/javase/8/docs/technotes/guides/vm/multiple-language-support.html)</li><li>[Understanding Java method invocation with invokedynamic](https://blogs.oracle.com/javamagazine/understanding-java-method-invocation-with-invokedynamic)</li><li>[Chapter 6. The Java Virtual Machine Instruction Set#invokedynamic](https://docs.oracle.com/javase/specs/jvms/se16/html/jvms-6.html#jvms-6.5.invokedynamic)</li></ul>

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
| [bootstrap](bootstrap.md) | [jvm]<br>abstract val [bootstrap](bootstrap.md): [MethodInvokeHandleSpec](../../com.github.jonathanxd.kores.common/-method-invoke-handle-spec/index.md)<br>Bootstrap method invocation specification. |
| [bootstrapArgs](bootstrap-args.md) | [jvm]<br>abstract val [bootstrapArgs](bootstrap-args.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)><br>Bootstrap method Arguments, must be one of the following types:<br><ul><li>[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)</li><li>[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html),</li><li>[Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)</li><li>[Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)</li><li>[Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)</li><li>[KoresType](../../com.github.jonathanxd.kores.type/-kores-type/index.md)/[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)</li><li>[MethodInvokeSpec](../../com.github.jonathanxd.kores.common/-method-invoke-spec/index.md) (normally translated into [MethodHandle](https://docs.oracle.com/javase/8/docs/api/java/lang/invoke/MethodHandle.html) at runtime, by the JVM)</li><li>[FieldAccessHandleSpec](../../com.github.jonathanxd.kores.common/-field-access-handle-spec/index.md) (normally translated into [MethodHandle](https://docs.oracle.com/javase/8/docs/api/java/lang/invoke/MethodHandle.html) at runtime, by the JVM)</li><li>[MethodInvokeHandleSpec](../../com.github.jonathanxd.kores.common/-method-invoke-handle-spec/index.md) (normally translated into [MethodHandle](https://docs.oracle.com/javase/8/docs/api/java/lang/invoke/MethodHandle.html) at runtime, by the JVM)</li><li>[TypeSpec](../-type-spec/index.md) (normally translated into [MethodType](https://docs.oracle.com/javase/8/docs/api/java/lang/invoke/MethodType.html) at runtime, by the JVM)</li><li>[DynamicConstantSpec](../../com.github.jonathanxd.kores.common/-dynamic-constant-spec/index.md) (as specified in [JEP 309](https://openjdk.java.net/jeps/309), translated into a constant).</li></ul><br>This is the value provided to the bootstrap method which resolves the target method to invoke. |
| [bootstrapLocalization](bootstrap-localization.md) | [jvm]<br>open val [bootstrapLocalization](bootstrap-localization.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>The [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) that declares the [bootstrap method](bootstrap.md). |
| [dynamicMethod](dynamic-method.md) | [jvm]<br>abstract val [dynamicMethod](dynamic-method.md): [DynamicMethodSpec](../../com.github.jonathanxd.kores.common/-dynamic-method-spec/index.md)<br>Specification of the method to invoke dynamically. |
| [type](type.md) | [jvm]<br>open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Return type of dynamic invocation |

## Inheritors

| Name |
|---|
| [InvokeDynamicBase](-lambda-method-ref-base/index.md) |
| [InvokeDynamic](../-invoke-dynamic/index.md) |
