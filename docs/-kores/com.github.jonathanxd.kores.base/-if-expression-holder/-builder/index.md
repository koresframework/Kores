//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.base](../../index.md)/[IfExpressionHolder](../index.md)/[Builder](index.md)

# Builder

[jvm]\
interface [Builder](index.md)<out [T](index.md) : [IfExpressionHolder](../index.md), [S](index.md) : [IfExpressionHolder.Builder](index.md)<[T](index.md), [S](index.md)>> : [Builder](../../../com.github.jonathanxd.kores.builder/-builder/index.md)<[T](index.md), [S](index.md)>

## Functions

| Name | Summary |
|---|---|
| [build](../../../com.github.jonathanxd.kores.builder/-builder/build.md) | [jvm]<br>abstract fun [build](../../../com.github.jonathanxd.kores.builder/-builder/build.md)(): [T](index.md)<br>Build the object of type [T](../../../com.github.jonathanxd.kores.builder/-builder/index.md). |
| [expressions](expressions.md) | [jvm]<br>open fun [expressions](expressions.md)(vararg values: [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)): [S](index.md)<br>abstract fun [expressions](expressions.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)>): [S](index.md)<br>See T. |

## Inheritors

| Name |
|---|
| [ForStatement](../../-for-statement/-builder/index.md) |
| [IfGroup](../../-if-group/-builder/index.md) |
| [IfStatement](../../-if-statement/-builder/index.md) |
| [WhileStatement](../../-while-statement/-builder/index.md) |
