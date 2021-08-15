//[Kores](../../index.md)/[com.koresframework.kores.inspect](index.md)/[isCheckFalseAnd](is-check-false-and.md)

# isCheckFalseAnd

[jvm]\
inline fun [IfExpr](../com.koresframework.kores.base/-if-expr/index.md).[isCheckFalseAnd](is-check-false-and.md)(predicate: ([Instruction](../com.koresframework.kores/-instruction/index.md)) -> [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Returns true if receiver[IfExpr](../com.koresframework.kores.base/-if-expr/index.md) is a check of [instruction](../com.koresframework.kores/-instruction/index.md) equality to false constant and [predicate](is-check-false-and.md) returns true for the [instruction](../com.koresframework.kores/-instruction/index.md).
