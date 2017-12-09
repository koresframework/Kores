[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.util](index.md) / [eq](.)

# eq

`fun `[`GenericType`](../com.github.jonathanxd.codeapi.type/-generic-type/index.md)`.eq(other: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Default equals algorithm for [GenericType](../com.github.jonathanxd.codeapi.type/-generic-type/index.md)

`fun `[`CodeType`](../com.github.jonathanxd.codeapi.type/-code-type/index.md)`.eq(obj: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Default equals method.

### Parameters

`obj` - Object to test.

**Return**
True if this [CodeType](../com.github.jonathanxd.codeapi.type/-code-type/index.md) is equals to another [CodeType](../com.github.jonathanxd.codeapi.type/-code-type/index.md).

`fun <T> `[`LoadedCodeType`](../com.github.jonathanxd.codeapi.type/-loaded-code-type/index.md)`<T>.eq(obj: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Default equality check for [LoadedCodeType](../com.github.jonathanxd.codeapi.type/-loaded-code-type/index.md), this method checks if the loaded types are equal.

