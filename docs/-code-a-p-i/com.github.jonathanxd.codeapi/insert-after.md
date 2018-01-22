[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi](index.md) / [insertAfter](.)

# insertAfter

`fun `[`CodeSource`](-code-source/index.md)`.insertAfter(predicate: (`[`CodeInstruction`](-code-instruction.md)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, toInsert: `[`CodeSource`](-code-source/index.md)`): `[`MutableCodeSource`](-mutable-code-source/index.md)

Insert element `toInsert` in `source` after element determined by `predicate`

### Parameters

`predicate` - Predicate to determine element

`toInsert` - Element to insert after element determined by `predicate`

**Return**
`source`

