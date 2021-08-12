//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.common](../../index.md)/[DynamicMethodSpec](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [Typed.Builder](../../../com.github.jonathanxd.kores.base/-typed/-builder/index.md)<[DynamicMethodSpec](../index.md), [DynamicMethodSpec.Builder](index.md)> , [Named.Builder](../../../com.github.jonathanxd.kores.base/-named/-builder/index.md)<[DynamicMethodSpec](../index.md), [DynamicMethodSpec.Builder](index.md)> , [ArgumentsHolder.Builder](../../../com.github.jonathanxd.kores.base/-arguments-holder/-builder/index.md)<[DynamicMethodSpec](../index.md), [DynamicMethodSpec.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [DynamicMethodSpec](../index.md)) |

## Functions

| Name | Summary |
|---|---|
| [arguments](../../../com.github.jonathanxd.kores.base/-arguments-holder/-builder/arguments.md) | [jvm]<br>open fun [arguments](../../../com.github.jonathanxd.kores.base/-arguments-holder/-builder/arguments.md)(vararg values: [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)): [DynamicMethodSpec.Builder](index.md)<br>open override fun [arguments](arguments.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)>): [DynamicMethodSpec.Builder](index.md)<br>See T. |
| [array](array.md) | [jvm]<br>open override fun [array](array.md)(value: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [DynamicMethodSpec.Builder](index.md)<br>See T. |
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [DynamicMethodSpec](../index.md)<br>Build the object of type T. |
| [name](name.md) | [jvm]<br>open override fun [name](name.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [DynamicMethodSpec.Builder](index.md) |
| [type](type.md) | [jvm]<br>open override fun [type](type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [DynamicMethodSpec.Builder](index.md)<br>See T. |
| [typeSpec](type-spec.md) | [jvm]<br>fun [typeSpec](type-spec.md)(value: [TypeSpec](../../../com.github.jonathanxd.kores.base/-type-spec/index.md)): [DynamicMethodSpec.Builder](index.md)<br>See [DynamicMethodSpec.typeSpec](../type-spec.md) |

## Properties

| Name | Summary |
|---|---|
| [arguments](arguments.md) | [jvm]<br>var [arguments](arguments.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)> |
| [name](name.md) | [jvm]<br>lateinit var [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [typeSpec](type-spec.md) | [jvm]<br>lateinit var [typeSpec](type-spec.md): [TypeSpec](../../../com.github.jonathanxd.kores.base/-type-spec/index.md) |
