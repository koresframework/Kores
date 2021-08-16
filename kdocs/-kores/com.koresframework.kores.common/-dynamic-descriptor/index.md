//[Kores](../../../index.md)/[com.koresframework.kores.common](../index.md)/[DynamicDescriptor](index.md)

# DynamicDescriptor

[jvm]\
sealed class [DynamicDescriptor](index.md) : [Named](../../com.koresframework.kores.base/-named/index.md), [Typed](../../com.koresframework.kores.base/-typed/index.md)

Dynamic descriptor describes an invocation target of a invokedynamic instruction.

Since Java 12, [java.lang.invoke.TypeDescriptor](https://docs.oracle.com/javase/8/docs/api/java/lang/invoke/TypeDescriptor.html) is available to abstract the third argument of a bootstrap method. It can be a [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html) (represented by [DynamicTypeSpec](../-dynamic-type-spec/index.md) in Kores), when linking to constants, or a [MethodType](https://docs.oracle.com/javase/8/docs/api/java/lang/invoke/MethodType.html) (represented by [DynamicMethodSpec](../-dynamic-method-spec/index.md)) when linking for methods.

#### Since

4.2.2.base

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>interface [Builder](-builder/index.md)<out [T](-builder/index.md) : [DynamicDescriptor](index.md), [S](-builder/index.md) : [DynamicDescriptor.Builder](-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>> : [Typed.Builder](../../com.koresframework.kores.base/-typed/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> , [Named.Builder](../../com.koresframework.kores.base/-named/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>abstract override fun [builder](builder.md)(): [DynamicDescriptor.Builder](-builder/index.md)<[DynamicDescriptor](index.md), *><br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [name](index.md#2141766718%2FProperties%2F-1216412040) | [jvm]<br>abstract val [name](index.md#2141766718%2FProperties%2F-1216412040): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Name |
| [type](index.md#-1223425425%2FProperties%2F-1216412040) | [jvm]<br>abstract val [type](index.md#-1223425425%2FProperties%2F-1216412040): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Element type |

## Inheritors

| Name |
|---|
| [DynamicMethodSpec](../-dynamic-method-spec/index.md) |
| [DynamicTypeSpec](../-dynamic-type-spec/index.md) |
