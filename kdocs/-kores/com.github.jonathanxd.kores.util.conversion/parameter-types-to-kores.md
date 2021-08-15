//[Kores](../../index.md)/[com.github.jonathanxd.kores.util.conversion](index.md)/[parameterTypesToKores](parameter-types-to-kores.md)

# parameterTypesToKores

[jvm]\
fun [Method](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Method.html).[parameterTypesToKores](parameter-types-to-kores.md)(nameProvider: (index: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), parameter: [Parameter](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Parameter.html)) -> [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = { i, _ -> this.parameterNames[i] }): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[KoresParameter](../com.github.jonathanxd.kores.base/-kores-parameter/index.md)>

Method parameter types to kores (transform generic types into [Kores Generic Type](../com.github.jonathanxd.kores.type/-generic-type/index.md))

[jvm]\
fun <[T](parameter-types-to-kores.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [Constructor](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Constructor.html)<[T](parameter-types-to-kores.md)>.[parameterTypesToKores](parameter-types-to-kores.md)(nameProvider: (index: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), parameter: [Parameter](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Parameter.html)) -> [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = { i, _ -> this.parameterNames[i] }): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[KoresParameter](../com.github.jonathanxd.kores.base/-kores-parameter/index.md)>

Constructor parameter types to Kores (transform generic types into [Kores Generic Type](../com.github.jonathanxd.kores.type/-generic-type/index.md))
