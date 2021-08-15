//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.base](../../index.md)/[ForStatement](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [IfExpressionHolder.Builder](../../-if-expression-holder/-builder/index.md)<[ForStatement](../index.md), [ForStatement.Builder](index.md)> , [BodyHolder.Builder](../../-body-holder/-builder/index.md)<[ForStatement](../index.md), [ForStatement.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [ForStatement](../index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [body](body.md) | [jvm]<br>open override fun [body](body.md)(value: [Instructions](../../../com.github.jonathanxd.kores/-instructions/index.md)): [ForStatement.Builder](index.md)<br>See T. |
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [ForStatement](../index.md)<br>Build the object of type T. |
| [expressions](expressions.md) | [jvm]<br>open override fun [expressions](expressions.md)(vararg values: [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)): [ForStatement.Builder](index.md)<br>open override fun [expressions](expressions.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)>): [ForStatement.Builder](index.md)<br>See T. |
| [forExpression](for-expression.md) | [jvm]<br>fun [forExpression](for-expression.md)(vararg values: [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)): [ForStatement.Builder](index.md)<br>fun [forExpression](for-expression.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)>): [ForStatement.Builder](index.md)<br>See [ForStatement.forExpression](../for-expression.md) |
| [forInit](for-init.md) | [jvm]<br>fun [forInit](for-init.md)(vararg values: [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)): [ForStatement.Builder](index.md)<br>fun [forInit](for-init.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)>): [ForStatement.Builder](index.md)<br>See [ForStatement.forInit](../for-init.md) |
| [forUpdate](for-update.md) | [jvm]<br>fun [forUpdate](for-update.md)(vararg values: [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)): [ForStatement.Builder](index.md)<br>fun [forUpdate](for-update.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)>): [ForStatement.Builder](index.md)<br>See [ForStatement.forUpdate](../for-update.md) |

## Properties

| Name | Summary |
|---|---|
| [body](body.md) | [jvm]<br>var [body](body.md): [Instructions](../../../com.github.jonathanxd.kores/-instructions/index.md) |
| [forExpression](for-expression.md) | [jvm]<br>var [forExpression](for-expression.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)> |
| [forInit](for-init.md) | [jvm]<br>var [forInit](for-init.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)> |
| [forUpdate](for-update.md) | [jvm]<br>var [forUpdate](for-update.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)> |
