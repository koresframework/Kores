//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.base](../../index.md)/[ArgumentsHolder](../index.md)/[Builder](index.md)

# Builder

[jvm]\
interface [Builder](index.md)<out [T](index.md) : [ArgumentsHolder](../index.md), [S](index.md) : [ArgumentsHolder.Builder](index.md)<[T](index.md), [S](index.md)>> : [Builder](../../../com.github.jonathanxd.kores.builder/-builder/index.md)<[T](index.md), [S](index.md)>

## Functions

| Name | Summary |
|---|---|
| [arguments](arguments.md) | [jvm]<br>open fun [arguments](arguments.md)(vararg values: [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)): [S](index.md)<br>abstract fun [arguments](arguments.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)>): [S](index.md)<br>See T. |
| [array](array.md) | [jvm]<br>abstract fun [array](array.md)(value: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [S](index.md)<br>See T. |
| [build](../../../com.github.jonathanxd.kores.builder/-builder/build.md) | [jvm]<br>abstract fun [build](../../../com.github.jonathanxd.kores.builder/-builder/build.md)(): [T](index.md)<br>Build the object of type [T](../../../com.github.jonathanxd.kores.builder/-builder/index.md). |

## Inheritors

| Name |
|---|
| [AnonymousClass](../../-anonymous-class/-builder/index.md) |
| [ArrayConstructor](../../-array-constructor/-builder/index.md) |
| [EnumEntry](../../-enum-entry/-builder/index.md) |
| [InvokeDynamicBase.LambdaMethodRefBase](../../-invoke-dynamic-base/-lambda-method-ref-base/-builder/index.md) |
| [InvokeDynamicBase.LambdaLocalCodeBase](../../-invoke-dynamic-base/-lambda-local-code-base/-builder/index.md) |
| [MethodInvocation](../../-method-invocation/-builder/index.md) |
| [DynamicMethodSpec](../../../com.github.jonathanxd.kores.common/-dynamic-method-spec/-builder/index.md) |
