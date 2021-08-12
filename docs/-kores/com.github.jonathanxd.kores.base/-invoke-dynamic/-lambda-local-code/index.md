//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.base](../../index.md)/[InvokeDynamic](../index.md)/[LambdaLocalCode](index.md)

# LambdaLocalCode

[jvm]\
data class [LambdaLocalCode](index.md)(**baseSam**: [MethodTypeSpec](../../../com.github.jonathanxd.kores.common/-method-type-spec/index.md), **expectedTypes**: [TypeSpec](../../-type-spec/index.md), **localCode**: [LocalCode](../../-local-code/index.md), **arguments**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)>) : [InvokeDynamicBase.LambdaLocalCodeBase](../../-invoke-dynamic-base/-lambda-local-code-base/index.md)

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
| [arguments](arguments.md) | [jvm]<br>open override val [arguments](arguments.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)><br>Argument to capture from current context and pass to [localCode](local-code.md) |
| [array](index.md#2057355370%2FProperties%2F-1216412040) | [jvm]<br>open override val [array](index.md#2057355370%2FProperties%2F-1216412040): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Array arguments |
| [baseSam](base-sam.md) | [jvm]<br>open override val [baseSam](base-sam.md): [MethodTypeSpec](../../../com.github.jonathanxd.kores.common/-method-type-spec/index.md)<br>Description of base SAM method, example, if the target functional interface is [Supplier](https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html), then the base SAM method is the [Supplier.get](https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html#get--). |
| [bootstrap](index.md#-1299197195%2FProperties%2F-1216412040) | [jvm]<br>open override val [bootstrap](index.md#-1299197195%2FProperties%2F-1216412040): [MethodInvokeSpec](../../../com.github.jonathanxd.kores.common/-method-invoke-spec/index.md)<br>Bootstrap method invocation specification. |
| [bootstrapArgs](index.md#-829302632%2FProperties%2F-1216412040) | [jvm]<br>open override val [bootstrapArgs](index.md#-829302632%2FProperties%2F-1216412040): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)><br>Bootstrap method Arguments, must be an [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html), [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), [KoresType](../../../com.github.jonathanxd.kores.type/-kores-type/index.md) or [MethodInvokeSpec](../../../com.github.jonathanxd.kores.common/-method-invoke-spec/index.md). |
| [currentTypes](index.md#-1576948329%2FProperties%2F-1216412040) | [jvm]<br>open val [currentTypes](index.md#-1576948329%2FProperties%2F-1216412040): [TypeSpec](../../-type-spec/index.md)<br>Current types of lambda sam. |
| [dynamicMethod](index.md#1166693539%2FProperties%2F-1216412040) | [jvm]<br>open override val [dynamicMethod](index.md#1166693539%2FProperties%2F-1216412040): [DynamicMethodSpec](../../../com.github.jonathanxd.kores.common/-dynamic-method-spec/index.md)<br>Specification of dynamic method. |
| [expectedTypes](expected-types.md) | [jvm]<br>open override val [expectedTypes](expected-types.md): [TypeSpec](../../-type-spec/index.md)<br>Types expected by the caller of lambda SAM. |
| [localCode](local-code.md) | [jvm]<br>open override val [localCode](local-code.md): [LocalCode](../../-local-code/index.md)<br>Local method to invoke |
| [methodRef](index.md#930932209%2FProperties%2F-1216412040) | [jvm]<br>open override val [methodRef](index.md#930932209%2FProperties%2F-1216412040): [MethodInvokeSpec](../../../com.github.jonathanxd.kores.common/-method-invoke-spec/index.md)<br>Method reference to invoke |
| [target](target.md) | [jvm]<br>open override val [target](target.md): [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)<br>Target of method ref invocation |
| [type](index.md#-656036835%2FProperties%2F-1216412040) | [jvm]<br>open override val [type](index.md#-656036835%2FProperties%2F-1216412040): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Return type of dynamic invocation |
| [types](types.md) | [jvm]<br>open override val [types](types.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)><br>Expected types of each argument |
