//[Kores](../../index.md)/[com.github.jonathanxd.kores.util](index.md)/[eq](eq.md)

# eq

[jvm]\
fun [GenericType](../com.github.jonathanxd.kores.type/-generic-type/index.md).[eq](eq.md)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Default equals algorithm for [GenericType](../com.github.jonathanxd.kores.type/-generic-type/index.md)

[jvm]\
fun [KoresType](../com.github.jonathanxd.kores.type/-kores-type/index.md).[eq](eq.md)(obj: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Default equals method.

#### Return

True if this [KoresType](../com.github.jonathanxd.kores.type/-kores-type/index.md) is equals to another [KoresType](../com.github.jonathanxd.kores.type/-kores-type/index.md).

## Parameters

jvm

| | |
|---|---|
| obj | Object to test. |

[jvm]\
fun <[T](eq.md)> [LoadedKoresType](../com.github.jonathanxd.kores.type/-loaded-kores-type/index.md)<[T](eq.md)>.[eq](eq.md)(obj: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Default equality check for [LoadedKoresType](../com.github.jonathanxd.kores.type/-loaded-kores-type/index.md), this method checks if the loaded types are equal.
