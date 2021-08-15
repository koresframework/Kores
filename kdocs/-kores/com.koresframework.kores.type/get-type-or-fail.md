//[Kores](../../index.md)/[com.koresframework.kores.type](index.md)/[getTypeOrFail](get-type-or-fail.md)

# getTypeOrFail

[jvm]\
fun [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html).[getTypeOrFail](get-type-or-fail.md)(isParameterized: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false): [Result](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-result/index.html)<[KoresType](-kores-type/index.md)>

fun [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html).[getTypeOrFail](get-type-or-fail.md)(previous: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)? = null, isParameterized: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false): [Result](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-result/index.html)<[KoresType](-kores-type/index.md)>

Gets the [KoresType](-kores-type/index.md) from a [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html). This method only works for Java Reflection Types and [KoresType](-kores-type/index.md).
