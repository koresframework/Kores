[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.util](index.md) / [insertAfter](.)

# insertAfter

`fun insertAfter(predicate: (`[`CodePart`](../com.github.jonathanxd.codeapi/-code-part/index.md)`) -> Boolean, toInsert: `[`CodeSource`](../com.github.jonathanxd.codeapi/-code-source/index.md)`, source: `[`CodeSource`](../com.github.jonathanxd.codeapi/-code-source/index.md)`): `[`MutableCodeSource`](../com.github.jonathanxd.codeapi/-mutable-code-source/index.md)

Insert element `toInsert` in `source` after element determined by `predicate`

### Parameters

`predicate` - Predicate to determine element

`toInsert` - Element to insert after element determined by `predicate`

`source` - Source to find element and insert element `toInsert`

**Return**
`source`

