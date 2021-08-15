//[Kores](../../../../index.md)/[com.koresframework.kores.base](../../index.md)/[KoresModifier](../index.md)/[Companion](index.md)

# Companion

[jvm]\
object [Companion](index.md)

## Functions

| Name | Summary |
|---|---|
| [fromJavaModifiers](from-java-modifiers.md) | [jvm]<br>@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()<br>fun [fromJavaModifiers](from-java-modifiers.md)(modifiers: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [MutableSet](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-set/index.html)<[KoresModifier](../index.md)><br>Extract modifiers from Java modifiers flags ([Modifier](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Modifier.html)). |
| [fromJavaxModifiers](from-javax-modifiers.md) | [jvm]<br>@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()<br>fun [fromJavaxModifiers](from-javax-modifiers.md)(modifiers: [Iterable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)<JavaxModifier>): [MutableSet](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-set/index.html)<[KoresModifier](../index.md)><br>Extract modifiers from Javax model modifiers ([Modifier](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Modifier.html)). |
| [fromMember](from-member.md) | [jvm]<br>@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()<br>fun [fromMember](from-member.md)(member: [Member](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Member.html)): [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)<[KoresModifier](../index.md)><br>Extract modifiers from a [Member](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Member.html) |
| [toJavaModifier](to-java-modifier.md) | [jvm]<br>@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()<br>fun [toJavaModifier](to-java-modifier.md)(codeModifier: [KoresModifier](../index.md)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Convert a [KoresModifier](../index.md) to Java Modifiers flags.<br>[jvm]<br>@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()<br>fun [toJavaModifier](to-java-modifier.md)(modifiers: [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)<[KoresModifier](../index.md)>): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Convert [KoresModifier](../index.md)s to Java Modifiers flags. |
| [toString](to-string.md) | [jvm]<br>@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()<br>fun [toString](to-string.md)(collection: [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)<[KoresModifier](../index.md)>?): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Modifiers to String |
