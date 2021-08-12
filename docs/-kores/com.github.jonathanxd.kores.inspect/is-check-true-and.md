//[Kores](../../index.md)/[com.github.jonathanxd.kores.inspect](index.md)/[isCheckTrueAnd](is-check-true-and.md)

# isCheckTrueAnd

[jvm]\
inline fun [IfExpr](../com.github.jonathanxd.kores.base/-if-expr/index.md).[isCheckTrueAnd](is-check-true-and.md)(predicate: ([Instruction](../com.github.jonathanxd.kores/-instruction/index.md)) -> [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Returns true if receiver[IfExpr](../com.github.jonathanxd.kores.base/-if-expr/index.md) is a check of [instruction](../com.github.jonathanxd.kores/-instruction/index.md) equality to true constant and [predicate](is-check-true-and.md) returns true for the [instruction](../com.github.jonathanxd.kores/-instruction/index.md).
