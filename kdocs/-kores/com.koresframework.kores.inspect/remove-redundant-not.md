//[Kores](../../index.md)/[com.koresframework.kores.inspect](index.md)/[removeRedundantNot](remove-redundant-not.md)

# removeRedundantNot

[jvm]\
fun [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../com.koresframework.kores/-instruction/index.md)>.[removeRedundantNot](remove-redundant-not.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../com.koresframework.kores/-instruction/index.md)>

fun [Instruction](../com.koresframework.kores/-instruction/index.md).[removeRedundantNot](remove-redundant-not.md)(): [Instruction](../com.koresframework.kores/-instruction/index.md)

Removes redundant not check.

[jvm]\
fun [IfExpr](../com.koresframework.kores.base/-if-expr/index.md).[removeRedundantNot](remove-redundant-not.md)(): [IfExpr](../com.koresframework.kores.base/-if-expr/index.md)

Removes redundant not check. Example if (!(!a)) is simplified to if (a)
