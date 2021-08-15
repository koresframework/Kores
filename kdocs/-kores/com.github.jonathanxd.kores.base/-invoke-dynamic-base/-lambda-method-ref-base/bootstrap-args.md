//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.base](../../index.md)/[InvokeDynamicBase](../index.md)/[LambdaMethodRefBase](index.md)/[bootstrapArgs](bootstrap-args.md)

# bootstrapArgs

[jvm]\
open override val [bootstrapArgs](bootstrap-args.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>

Bootstrap method Arguments, must be one of the following types:

<ul><li>[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)</li><li>[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html),</li><li>[Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)</li><li>[Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)</li><li>[Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)</li><li>[KoresType](../../../com.github.jonathanxd.kores.type/-kores-type/index.md)/[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)</li><li>[MethodInvokeSpec](../../../com.github.jonathanxd.kores.common/-method-invoke-spec/index.md) (normally translated into [MethodHandle](https://docs.oracle.com/javase/8/docs/api/java/lang/invoke/MethodHandle.html) at runtime, by the JVM)</li><li>[FieldAccessHandleSpec](../../../com.github.jonathanxd.kores.common/-field-access-handle-spec/index.md) (normally translated into [MethodHandle](https://docs.oracle.com/javase/8/docs/api/java/lang/invoke/MethodHandle.html) at runtime, by the JVM)</li><li>[MethodInvokeHandleSpec](../../../com.github.jonathanxd.kores.common/-method-invoke-handle-spec/index.md) (normally translated into [MethodHandle](https://docs.oracle.com/javase/8/docs/api/java/lang/invoke/MethodHandle.html) at runtime, by the JVM)</li><li>[TypeSpec](../../-type-spec/index.md) (normally translated into [MethodType](https://docs.oracle.com/javase/8/docs/api/java/lang/invoke/MethodType.html) at runtime, by the JVM)</li><li>[DynamicConstantSpec](../../../com.github.jonathanxd.kores.common/-dynamic-constant-spec/index.md) (as specified in [JEP 309](https://openjdk.java.net/jeps/309), translated into a constant).</li></ul>

This is the value provided to the bootstrap method which resolves the target method to invoke. Those values are stored in the **ConstantPool** and are not provided to the target method.

Arguments that must be provided to the target method must be provided in the [dynamicMethod](dynamic-method.md) specification.
