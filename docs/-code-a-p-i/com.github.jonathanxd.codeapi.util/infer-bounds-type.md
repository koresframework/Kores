[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.util](index.md) / [inferBoundsType](.)

# inferBoundsType

`fun inferBoundsType(bounds: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<out `[`Bound`](../com.github.jonathanxd.codeapi.type/-generic-type/-bound/index.md)`>, parameterizedType: `[`GenericType`](../com.github.jonathanxd.codeapi.type/-generic-type/index.md)`, startingType: `[`GenericType`](../com.github.jonathanxd.codeapi.type/-generic-type/index.md)`, codeTypeResolver: `[`CodeTypeResolver`](../com.github.jonathanxd.codeapi.type/-code-type-resolver/index.md)`<*>, genericResolver: `[`GenericResolver`](-generic-resolver/index.md)`, filter: (`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = {true}): `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`Bound`](../com.github.jonathanxd.codeapi.type/-generic-type/-bound/index.md)`>`

Calls [inferType](infer-type.md) against [bounds](infer-bounds-type.md#com.github.jonathanxd.codeapi.util$inferBoundsType(kotlin.Array((com.github.jonathanxd.codeapi.type.GenericType.Bound)), com.github.jonathanxd.codeapi.type.GenericType, com.github.jonathanxd.codeapi.type.GenericType, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)), com.github.jonathanxd.codeapi.util.GenericResolver, kotlin.Function1((kotlin.String, kotlin.Boolean)))/bounds) types.

