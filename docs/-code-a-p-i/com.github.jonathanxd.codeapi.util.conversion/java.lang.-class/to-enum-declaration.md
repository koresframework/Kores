[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.util.conversion](../index.md) / [java.lang.Class](index.md) / [toEnumDeclaration](.)

# toEnumDeclaration

`@JvmOverloads fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> Class<T>.toEnumDeclaration(nameProvider: (method: Method, index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, parameter: Parameter) -> `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = { m, i, _ -> m.parameterNames[i] }): `[`EnumDeclaration`](../../com.github.jonathanxd.codeapi.base/-enum-declaration/index.md)

Creates enum declaration from receiver [Class](#) using parameter name provider: [nameProvider](to-enum-declaration.md#com.github.jonathanxd.codeapi.util.conversion$toEnumDeclaration(java.lang.Class((com.github.jonathanxd.codeapi.util.conversion.toEnumDeclaration.T)), kotlin.Function3((java.lang.reflect.Method, kotlin.Int, java.lang.reflect.Parameter, kotlin.String)))/nameProvider).

