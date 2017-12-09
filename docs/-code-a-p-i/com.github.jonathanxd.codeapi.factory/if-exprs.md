[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.factory](index.md) / [ifExprs](.)

# ifExprs

`fun ifExprs(vararg objects: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../com.github.jonathanxd.codeapi/-code-instruction.md)`>`

Helper function to create if expressions. This function converts a sequence of: [IfExpr](../com.github.jonathanxd.codeapi.base/-if-expr/index.md),
[Operator](../com.github.jonathanxd.codeapi.operator/-operator/index.md), [IfGroup](../com.github.jonathanxd.codeapi.base/-if-group/index.md), [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html) and [CodePart](../com.github.jonathanxd.codeapi/-code-part/index.md) into a list of expressions (which for the three first types
no conversion is done), if a [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html) is found, it will be converted to a [IfGroup](../com.github.jonathanxd.codeapi.base/-if-group/index.md). If a [CodePart](../com.github.jonathanxd.codeapi/-code-part/index.md) is found
it will be converted to a [IfExpr](../com.github.jonathanxd.codeapi.base/-if-expr/index.md) that checks if the `codePart` is equal to `true`.

### Parameters

`objects` - Sequence of operations.

### Exceptions

`IllegalArgumentException` - If an element is not of a valid type.

**Return**
Sequence of if expressions.

