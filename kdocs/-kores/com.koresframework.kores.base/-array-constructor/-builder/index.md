//[Kores](../../../../index.md)/[com.koresframework.kores.base](../../index.md)/[ArrayConstructor](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [ArgumentsHolder.Builder](../../-arguments-holder/-builder/index.md)<[ArrayConstructor](../index.md), [ArrayConstructor.Builder](index.md)> , [Typed.Builder](../../-typed/-builder/index.md)<[ArrayConstructor](../index.md), [ArrayConstructor.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [ArrayConstructor](../index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [arguments](../../-arguments-holder/-builder/arguments.md) | [jvm]<br>open fun [arguments](../../-arguments-holder/-builder/arguments.md)(vararg values: [Instruction](../../../com.koresframework.kores/-instruction/index.md)): [ArrayConstructor.Builder](index.md)<br>open override fun [arguments](arguments.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../../com.koresframework.kores/-instruction/index.md)>): [ArrayConstructor.Builder](index.md)<br>See T. |
| [array](array.md) | [jvm]<br>open override fun [array](array.md)(value: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [ArrayConstructor.Builder](index.md)<br>See T. |
| [arrayType](array-type.md) | [jvm]<br>fun [arrayType](array-type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [ArrayConstructor.Builder](index.md)<br>See [ArrayConstructor.arrayType](../array-type.md) |
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [ArrayConstructor](../index.md)<br>Build the object of type T. |
| [dimensions](dimensions.md) | [jvm]<br>fun [dimensions](dimensions.md)(vararg values: [Instruction](../../../com.koresframework.kores/-instruction/index.md)): [ArrayConstructor.Builder](index.md)<br>fun [dimensions](dimensions.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../../com.koresframework.kores/-instruction/index.md)>): [ArrayConstructor.Builder](index.md)<br>See [ArrayConstructor.dimensions](../dimensions.md) |
| [type](type.md) | [jvm]<br>open override fun [type](type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [ArrayConstructor.Builder](index.md)<br>See T. |

## Properties

| Name | Summary |
|---|---|
| [arguments](arguments.md) | [jvm]<br>var [arguments](arguments.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../../com.koresframework.kores/-instruction/index.md)> |
| [arrayType](array-type.md) | [jvm]<br>lateinit var [arrayType](array-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) |
| [dimensions](dimensions.md) | [jvm]<br>var [dimensions](dimensions.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../../com.koresframework.kores/-instruction/index.md)> |
