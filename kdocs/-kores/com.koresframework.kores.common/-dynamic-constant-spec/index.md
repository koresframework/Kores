//[Kores](../../../index.md)/[com.koresframework.kores.common](../index.md)/[DynamicConstantSpec](index.md)

# DynamicConstantSpec

[jvm]\
data class [DynamicConstantSpec](index.md)(**constantName**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **constantType**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), **bootstrapMethod**: [MethodInvokeHandleSpec](../-method-invoke-handle-spec/index.md), **bootstrapArgs**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>) : [Typed](../../com.koresframework.kores.base/-typed/index.md), [Comparable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-comparable/index.html)<[DynamicConstantSpec](index.md)> 

Dynamic Constant as specified in [JEP 309](https://openjdk.java.net/jeps/309) to be used in [com.koresframework.kores.base.InvokeDynamicBase.bootstrapArgs](../../com.koresframework.kores.base/-invoke-dynamic-base/bootstrap-args.md) and in [bootstrapArgs](bootstrap-args.md).

## Constructors

| | |
|---|---|
| [DynamicConstantSpec](-dynamic-constant-spec.md) | [jvm]<br>fun [DynamicConstantSpec](-dynamic-constant-spec.md)(constantName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), constantType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), bootstrapMethod: [MethodInvokeHandleSpec](../-method-invoke-handle-spec/index.md), bootstrapArgs: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)>) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [Typed.Builder](../../com.koresframework.kores.base/-typed/-builder/index.md)<[DynamicConstantSpec](index.md), [DynamicConstantSpec.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [DynamicConstantSpec.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |
| [compareTo](compare-to.md) | [jvm]<br>open operator override fun [compareTo](compare-to.md)(other: [DynamicConstantSpec](index.md)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [toInvocationString](to-invocation-string.md) | [jvm]<br>fun [toInvocationString](to-invocation-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Human-readable method invocation string. |

## Properties

| Name | Summary |
|---|---|
| [bootstrapArgs](bootstrap-args.md) | [jvm]<br>val [bootstrapArgs](bootstrap-args.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)><br>The constraints as [com.koresframework.kores.base.InvokeDynamicBase.bootstrapArgs](../../com.koresframework.kores.base/-invoke-dynamic-base/bootstrap-args.md). |
| [bootstrapMethod](bootstrap-method.md) | [jvm]<br>val [bootstrapMethod](bootstrap-method.md): [MethodInvokeHandleSpec](../-method-invoke-handle-spec/index.md)<br>The bootstrap method used to resolve the constant. |
| [constantName](constant-name.md) | [jvm]<br>val [constantName](constant-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The name of the constant to resolve dynamically. |
| [constantType](constant-type.md) | [jvm]<br>val [constantType](constant-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>The type of the constant value that the method produces. |
| [type](type.md) | [jvm]<br>open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Element type |
