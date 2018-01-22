[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi](index.md) / [insertBefore](.)

# insertBefore

`fun `[`CodeSource`](-code-source/index.md)`.insertBefore(predicate: (`[`CodeInstruction`](-code-instruction.md)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, toInsert: `[`CodeSource`](-code-source/index.md)`): `[`MutableCodeSource`](-mutable-code-source/index.md)

Insert element `toInsert` in `source` before element determined by `predicate`

### Parameters

`predicate` - Predicate to determine element

`toInsert` - Element to insert before element determined by `predicate`

**Return**
`source`

