//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[ArgumentsHolder](index.md)

# ArgumentsHolder

[jvm]\
interface [ArgumentsHolder](index.md) : [KoresPart](../../com.github.jonathanxd.kores/-kores-part/index.md)

Hold arguments.

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>interface [Builder](-builder/index.md)<out [T](-builder/index.md) : [ArgumentsHolder](index.md), [S](-builder/index.md) : [ArgumentsHolder.Builder](-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>> : [Builder](../../com.github.jonathanxd.kores.builder/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>abstract override fun [builder](builder.md)(): [ArgumentsHolder.Builder](-builder/index.md)<[ArgumentsHolder](index.md), *><br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [arguments](arguments.md) | [jvm]<br>abstract val [arguments](arguments.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)><br>Argument list |
| [array](array.md) | [jvm]<br>abstract val [array](array.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Array arguments |
| [types](types.md) | [jvm]<br>abstract val [types](types.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)><br>Expected types of each argument |

## Inheritors

| Name |
|---|
| [AnonymousClass](../-anonymous-class/index.md) |
| [ArrayConstructor](../-array-constructor/index.md) |
| [EnumEntry](../-enum-entry/index.md) |
| [InvokeDynamicBase](../-invoke-dynamic-base/-lambda-method-ref-base/index.md) |
| [InvokeDynamicBase](../-invoke-dynamic-base/-lambda-local-code-base/index.md) |
| [MethodInvocation](../-method-invocation/index.md) |
| [DynamicMethodSpec](../../com.github.jonathanxd.kores.common/-dynamic-method-spec/index.md) |
