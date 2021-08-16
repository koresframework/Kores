//[Kores](../../../../index.md)/[com.koresframework.kores.common](../../index.md)/[DynamicTypeSpec](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [DynamicDescriptor.Builder](../../-dynamic-descriptor/-builder/index.md)<[DynamicTypeSpec](../index.md), [DynamicTypeSpec.Builder](index.md)> , [Typed.Builder](../../../com.koresframework.kores.base/-typed/-builder/index.md)<[DynamicTypeSpec](../index.md), [DynamicTypeSpec.Builder](index.md)> , [Named.Builder](../../../com.koresframework.kores.base/-named/-builder/index.md)<[DynamicTypeSpec](../index.md), [DynamicTypeSpec.Builder](index.md)> , [ArgumentsHolder.Builder](../../../com.koresframework.kores.base/-arguments-holder/-builder/index.md)<[DynamicTypeSpec](../index.md), [DynamicTypeSpec.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [DynamicTypeSpec](../index.md)) |

## Functions

| Name | Summary |
|---|---|
| [arguments](../../../com.koresframework.kores.base/-arguments-holder/-builder/arguments.md) | [jvm]<br>open fun [arguments](../../../com.koresframework.kores.base/-arguments-holder/-builder/arguments.md)(vararg values: [Instruction](../../../com.koresframework.kores/-instruction/index.md)): [DynamicTypeSpec.Builder](index.md)<br>open override fun [arguments](arguments.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../../com.koresframework.kores/-instruction/index.md)>): [DynamicTypeSpec.Builder](index.md)<br>See T. |
| [array](array.md) | [jvm]<br>open override fun [array](array.md)(value: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [DynamicTypeSpec.Builder](index.md)<br>See T. |
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [DynamicTypeSpec](../index.md)<br>Build the object of type T. |
| [name](name.md) | [jvm]<br>open override fun [name](name.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [DynamicTypeSpec.Builder](index.md) |
| [type](type.md) | [jvm]<br>open override fun [type](type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [DynamicTypeSpec.Builder](index.md)<br>See T. |

## Properties

| Name | Summary |
|---|---|
| [arguments](arguments.md) | [jvm]<br>var [arguments](arguments.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../../com.koresframework.kores/-instruction/index.md)> |
| [name](name.md) | [jvm]<br>lateinit var [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [type](type.md) | [jvm]<br>lateinit var [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) |
