//[Kores](../../../index.md)/[com.koresframework.kores.common](../index.md)/[MethodTypeSpec](index.md)

# MethodTypeSpec

[jvm]\
data class [MethodTypeSpec](index.md)(**localization**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), **methodSpec**: [MethodSpec](../-method-spec/index.md)) : [Typed](../../com.koresframework.kores.base/-typed/index.md), [Comparable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-comparable/index.html)<[MethodTypeSpec](index.md)>

## Constructors

| | |
|---|---|
| [MethodTypeSpec](-method-type-spec.md) | [jvm]<br>fun [MethodTypeSpec](-method-type-spec.md)(localization: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), methodName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), typeSpec: [TypeSpec](../../com.koresframework.kores.base/-type-spec/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [Typed.Builder](../../com.koresframework.kores.base/-typed/-builder/index.md)<[MethodTypeSpec](index.md), [MethodTypeSpec.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [MethodTypeSpec.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |
| [compareTo](compare-to.md) | [jvm]<br>open operator override fun [compareTo](compare-to.md)(other: [MethodTypeSpec](index.md)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>This method will not compare the method localization. |
| [copy](copy.md) | [jvm]<br>fun [copy](copy.md)(localization: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) = this.localization, methodName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = this.methodName, typeSpec: [TypeSpec](../../com.koresframework.kores.base/-type-spec/index.md) = this.typeSpec): [MethodTypeSpec](index.md)<br>fun [copy](copy.md)(localization: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) = this.localization, methodName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = this.methodName, type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) = this.typeSpec.returnType): [MethodTypeSpec](index.md) |
| [invoke](invoke.md) | [jvm]<br>operator fun [invoke](invoke.md)(invokeType: [InvokeType](../../com.koresframework.kores.base/-invoke-type/index.md), target: [Instruction](../../com.koresframework.kores/-instruction/index.md)): [MethodInvocation](../../com.koresframework.kores.base/-method-invocation/index.md)<br>Invokes this method in [target](invoke.md).<br>[jvm]<br>operator fun [invoke](invoke.md)(invokeType: [InvokeType](../../com.koresframework.kores.base/-invoke-type/index.md), target: [Instruction](../../com.koresframework.kores/-instruction/index.md), arguments: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.koresframework.kores/-instruction/index.md)>): [MethodInvocation](../../com.koresframework.kores.base/-method-invocation/index.md)<br>Invokes this method in [target](invoke.md) with [arguments](invoke.md). |
| [toMethodString](to-method-string.md) | [jvm]<br>fun [toMethodString](to-method-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Human readable method specification string. |

## Properties

| Name | Summary |
|---|---|
| [localization](localization.md) | [jvm]<br>val [localization](localization.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) |
| [methodName](method-name.md) | [jvm]<br>val [methodName](method-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [methodSpec](method-spec.md) | [jvm]<br>val [methodSpec](method-spec.md): [MethodSpec](../-method-spec/index.md) |
| [type](type.md) | [jvm]<br>open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Element type |
| [typeSpec](type-spec.md) | [jvm]<br>val [typeSpec](type-spec.md): [TypeSpec](../../com.koresframework.kores.base/-type-spec/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [toInvocation](../../com.koresframework.kores.util.conversion/to-invocation.md) | [jvm]<br>fun [MethodTypeSpec](index.md).[toInvocation](../../com.koresframework.kores.util.conversion/to-invocation.md)(invokeType: [InvokeType](../../com.koresframework.kores.base/-invoke-type/index.md), target: [Instruction](../../com.koresframework.kores/-instruction/index.md), arguments: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.koresframework.kores/-instruction/index.md)>): [MethodInvocation](../../com.koresframework.kores.base/-method-invocation/index.md)<br>Create [MethodInvocation](../../com.koresframework.kores.base/-method-invocation/index.md) from [MethodTypeSpec](index.md) |
