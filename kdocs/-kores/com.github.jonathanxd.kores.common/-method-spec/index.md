//[Kores](../../../index.md)/[com.github.jonathanxd.kores.common](../index.md)/[MethodSpec](index.md)

# MethodSpec

[jvm]\
data class [MethodSpec](index.md)(**methodName**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **typeSpec**: [TypeSpec](../../com.github.jonathanxd.kores.base/-type-spec/index.md)) : [Typed](../../com.github.jonathanxd.kores.base/-typed/index.md), [Comparable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-comparable/index.html)<[MethodSpec](index.md)>

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [Typed.Builder](../../com.github.jonathanxd.kores.base/-typed/-builder/index.md)<[MethodSpec](index.md), [MethodSpec.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [MethodSpec.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |
| [compareTo](compare-to.md) | [jvm]<br>open operator override fun [compareTo](compare-to.md)(other: [MethodSpec](index.md)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>This method will not compare the method localization. |
| [invoke](invoke.md) | [jvm]<br>operator fun [invoke](invoke.md)(invokeType: [InvokeType](../../com.github.jonathanxd.kores.base/-invoke-type/index.md), type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), target: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)): [MethodInvocation](../../com.github.jonathanxd.kores.base/-method-invocation/index.md)<br>Invokes this method in [target](invoke.md).<br>[jvm]<br>operator fun [invoke](invoke.md)(invokeType: [InvokeType](../../com.github.jonathanxd.kores.base/-invoke-type/index.md), type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), target: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), arguments: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)>): [MethodInvocation](../../com.github.jonathanxd.kores.base/-method-invocation/index.md)<br>Invokes this method in [target](invoke.md) with [arguments](invoke.md). |
| [toMethodString](to-method-string.md) | [jvm]<br>fun [toMethodString](to-method-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Human readable method specification string. |
| [toMethodTypeSpec](to-method-type-spec.md) | [jvm]<br>fun [toMethodTypeSpec](to-method-type-spec.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [MethodTypeSpec](../-method-type-spec/index.md)<br>Converts this [MethodSpec](index.md) to [MethodTypeSpec](../-method-type-spec/index.md) |

## Properties

| Name | Summary |
|---|---|
| [methodName](method-name.md) | [jvm]<br>val [methodName](method-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [type](type.md) | [jvm]<br>open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Element type |
| [typeSpec](type-spec.md) | [jvm]<br>val [typeSpec](type-spec.md): [TypeSpec](../../com.github.jonathanxd.kores.base/-type-spec/index.md) |
