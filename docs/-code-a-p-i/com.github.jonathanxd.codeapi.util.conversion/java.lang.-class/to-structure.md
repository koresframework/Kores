[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.util.conversion](../index.md) / [java.lang.Class](index.md) / [toStructure](.)

# toStructure

`@JvmOverloads fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> Class<T>.toStructure(includeFields: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true, includeMethods: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true, includeSubClasses: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`TypeDeclaration`](../../com.github.jonathanxd.codeapi.base/-type-declaration/index.md)`>`

Convert this [Class](#) structure to [TypeDeclaration](../../com.github.jonathanxd.codeapi.base/-type-declaration/index.md)s (first element is the
input class, other elements is inner-classes).

### Parameters

`includeFields` - True to include fields.

`includeMethods` - True to include methods.

`includeSubClasses` - True to include sub classes.

**Return**
[TypeDeclaration](../../com.github.jonathanxd.codeapi.base/-type-declaration/index.md) structure from [Class](#).

