[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi](index.md) / [visit](.)

# visit

`fun `[`CodeSource`](-code-source/index.md)`.visit(consumer: (`[`CodeInstruction`](-code-instruction.md)`, `[`Location`](-location/index.md)`, `[`MutableCodeSource`](-mutable-code-source/index.md)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`MutableCodeSource`](-mutable-code-source/index.md)

Visit Code Source elements.

This method create a new [CodeSource](-code-source/index.md) and add all elements from `codeSource`
before and after visits each [CodePart](-code-part/index.md) of `codeSource`.

When visiting process finish, it will clear `codeSource` and add all elements from new
[CodeSource](-code-source/index.md)

### Parameters

`consumer` - Consumer

**Return**
Result source.

