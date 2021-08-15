//[Kores](../../../../index.md)/[com.koresframework.kores.base](../../index.md)/[KoresModifier](../index.md)/[Companion](index.md)/[fromJavaModifiers](from-java-modifiers.md)

# fromJavaModifiers

[jvm]\

@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()

fun [fromJavaModifiers](from-java-modifiers.md)(modifiers: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [MutableSet](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-set/index.html)<[KoresModifier](../index.md)>

Extract modifiers from Java modifiers flags ([Modifier](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Modifier.html)).

#### Return

Sorted Collection of modifiers.

## Parameters

jvm

| | |
|---|---|
| modifiers | Modifiers flags. |
