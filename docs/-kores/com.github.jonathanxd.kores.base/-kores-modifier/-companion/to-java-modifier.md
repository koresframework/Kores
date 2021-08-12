//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.base](../../index.md)/[KoresModifier](../index.md)/[Companion](index.md)/[toJavaModifier](to-java-modifier.md)

# toJavaModifier

[jvm]\

@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()

fun [toJavaModifier](to-java-modifier.md)(modifiers: [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)<[KoresModifier](../index.md)>): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)

Convert [KoresModifier](../index.md)s to Java Modifiers flags.

#### Return

Java modifiers flags ([Modifier](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Modifier.html))

## Parameters

jvm

| | |
|---|---|
| modifiers | Modifiers |

[jvm]\

@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()

fun [toJavaModifier](to-java-modifier.md)(codeModifier: [KoresModifier](../index.md)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)

Convert a [KoresModifier](../index.md) to Java Modifiers flags.

#### Return

Java modifiers flags ([Modifier](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Modifier.html))

## Parameters

jvm

| | |
|---|---|
| codeModifier | Modifier to convert |
