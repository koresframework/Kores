[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi](index.md) / [insertBeforeOrEnd](.)

# insertBeforeOrEnd

`fun `[`CodeSource`](-code-source/index.md)`.insertBeforeOrEnd(predicate: (`[`CodeInstruction`](-code-instruction.md)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, toInsert: `[`CodeSource`](-code-source/index.md)`): `[`MutableCodeSource`](-mutable-code-source/index.md)

Insert element `toInsert` in `source` before element determined by `predicate` or at end of source if not found.

### Parameters

`predicate` - Predicate to determine element

`toInsert` - Element to insert after element determined by `predicate`

**Return**
`source`

