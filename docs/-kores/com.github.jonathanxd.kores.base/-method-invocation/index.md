//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[MethodInvocation](index.md)

# MethodInvocation

[jvm]\
data class [MethodInvocation](index.md)(**invokeType**: [InvokeType](../-invoke-type/index.md), **target**: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), **spec**: [MethodTypeSpec](../../com.github.jonathanxd.kores.common/-method-type-spec/index.md), **arguments**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)>) : [Accessor](../-accessor/index.md), [ArgumentsHolder](../-arguments-holder/index.md), [TypedInstruction](../-typed-instruction/index.md)

Invokes a method.

## Constructors

| | |
|---|---|
| [MethodInvocation](-method-invocation.md) | [jvm]<br>fun [MethodInvocation](-method-invocation.md)(invokeType: [InvokeType](../-invoke-type/index.md), target: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), spec: [MethodTypeSpec](../../com.github.jonathanxd.kores.common/-method-type-spec/index.md), arguments: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)>) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [Accessor.Builder](../-accessor/-builder/index.md)<[MethodInvocation](index.md), [MethodInvocation.Builder](-builder/index.md)> , [ArgumentsHolder.Builder](../-arguments-holder/-builder/index.md)<[MethodInvocation](index.md), [MethodInvocation.Builder](-builder/index.md)> , [Typed.Builder](../-typed/-builder/index.md)<[MethodInvocation](index.md), [MethodInvocation.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [MethodInvocation.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [arguments](arguments.md) | [jvm]<br>open override val [arguments](arguments.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)><br>Argument list |
| [array](array.md) | [jvm]<br>open override val [array](array.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Array arguments |
| [invokeType](invoke-type.md) | [jvm]<br>val [invokeType](invoke-type.md): [InvokeType](../-invoke-type/index.md) |
| [localization](localization.md) | [jvm]<br>open override val [localization](localization.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Method localization |
| [spec](spec.md) | [jvm]<br>val [spec](spec.md): [MethodTypeSpec](../../com.github.jonathanxd.kores.common/-method-type-spec/index.md) |
| [target](target.md) | [jvm]<br>open override val [target](target.md): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)<br>Target of the invocation (Access to static context for static methods), for instance constructors, you must to pass a [New](../-new/index.md) instance, for super constructor or this constructors you must to pass either an [Alias](../-alias/index.md) or an [Access](../-access/index.md) to this context. |
| [type](type.md) | [jvm]<br>open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Method return type |
| [types](types.md) | [jvm]<br>open override val [types](types.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)><br>Expected types of each argument |

## Extensions

| Name | Summary |
|---|---|
| [isSuperConstructorInvocation](../is-super-constructor-invocation.md) | [jvm]<br>val [MethodInvocation](index.md).[isSuperConstructorInvocation](../is-super-constructor-invocation.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if a [MethodInvocation](index.md) is a invocation of super constructor |
