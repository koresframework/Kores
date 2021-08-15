//[Kores](../../../../index.md)/[com.koresframework.kores.base](../../index.md)/[KoresModifier](../index.md)/[Companion](index.md)/[fromJavaxModifiers](from-javax-modifiers.md)

# fromJavaxModifiers

[jvm]\

@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()

fun [fromJavaxModifiers](from-javax-modifiers.md)(modifiers: [Iterable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)<JavaxModifier>): [MutableSet](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-set/index.html)<[KoresModifier](../index.md)>

Extract modifiers from Javax model modifiers ([Modifier](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Modifier.html)).

#### Return

Sorted Collection of modifiers.

## Parameters

jvm

| | |
|---|---|
| modifiers | Modifiers. |
