//[Kores](../../index.md)/[com.github.jonathanxd.kores.factory](index.md)/[ifExprs](if-exprs.md)

# ifExprs

[jvm]\
fun [ifExprs](if-exprs.md)(vararg objects: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../com.github.jonathanxd.kores/-instruction/index.md)>

Helper function to create if expressions. This function converts a sequence of: [IfExpr](../com.github.jonathanxd.kores.base/-if-expr/index.md), [Operator](../com.github.jonathanxd.kores.operator/-operator/index.md), [IfGroup](../com.github.jonathanxd.kores.base/-if-group/index.md), [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html) and [KoresPart](../com.github.jonathanxd.kores/-kores-part/index.md) into a list of expressions (which for the three first types no conversion is done), if a [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html) is found, it will be converted to a [IfGroup](../com.github.jonathanxd.kores.base/-if-group/index.md). If a [KoresPart](../com.github.jonathanxd.kores/-kores-part/index.md) is found it will be converted to a [IfExpr](../com.github.jonathanxd.kores.base/-if-expr/index.md) that checks if the codePart is equal to true.

#### Return

Sequence of if expressions.

## Parameters

jvm

| | |
|---|---|
| objects | Sequence of operations. |

#### Throws

| | |
|---|---|
| [kotlin.IllegalArgumentException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-illegal-argument-exception/index.html) | If an element is not of a valid type. |
