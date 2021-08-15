//[Kores](../../index.md)/[com.koresframework.kores.util.conversion](index.md)/[toEnumDeclaration](to-enum-declaration.md)

# toEnumDeclaration

[jvm]\

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

fun <[T](to-enum-declaration.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)> [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<[T](to-enum-declaration.md)>.[toEnumDeclaration](to-enum-declaration.md)(nameProvider: (method: [Method](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Method.html), index: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), parameter: [Parameter](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Parameter.html)) -> [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = { m, i, _ -> m.parameterNames[i] }): [EnumDeclaration](../com.koresframework.kores.base/-enum-declaration/index.md)

Creates enum declaration from receiver [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html) using parameter name provider: [nameProvider](to-enum-declaration.md).
