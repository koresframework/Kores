[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.util](index.md) / [insertAfterOrEnd](.)

# insertAfterOrEnd

`fun insertAfterOrEnd(predicate: (`[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, toInsert: `[`CodeSource`](../com.github.jonathanxd.codeapi/-code-source/index.md)`, source: `[`CodeSource`](../com.github.jonathanxd.codeapi/-code-source/index.md)`): `[`MutableCodeSource`](../com.github.jonathanxd.codeapi/-mutable-code-source/index.md)

Insert element `toInsert` in `source` after element determined by `predicate` or at end of source if not found.

### Parameters

`predicate` - Predicate to determine element

`toInsert` - Element to insert after element determined by `predicate`

`source` - Source to find element and insert element `toInsert`

**Return**
`source`

