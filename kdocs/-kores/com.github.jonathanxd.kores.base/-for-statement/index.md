//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[ForStatement](index.md)

# ForStatement

[jvm]\
data class [ForStatement](index.md)(**forInit**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)>, **forExpression**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)>, **forUpdate**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)>, **body**: [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)) : [IfExpressionHolder](../-if-expression-holder/index.md), [BodyHolder](../-body-holder/index.md), [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)

For statement.

for(forInit; forExpression; forUpdate)

## Constructors

| | |
|---|---|
| [ForStatement](-for-statement.md) | [jvm]<br>fun [ForStatement](-for-statement.md)(forInit: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)>, forExpression: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)>, forUpdate: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)>, body: [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [IfExpressionHolder.Builder](../-if-expression-holder/-builder/index.md)<[ForStatement](index.md), [ForStatement.Builder](-builder/index.md)> , [BodyHolder.Builder](../-body-holder/-builder/index.md)<[ForStatement](index.md), [ForStatement.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [ForStatement.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [body](body.md) | [jvm]<br>open override val [body](body.md): [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)<br>Body of for statement (ex: println(i)). |
| [expressions](expressions.md) | [jvm]<br>open override val [expressions](expressions.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)><br>If expressions and operationsExpressions can be: [IfExpr](../-if-expr/index.md) or [IfGroup](../-if-group/index.md) (both only before and/or after Operators. |
| [forExpression](for-expression.md) | [jvm]<br>val [forExpression](for-expression.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)><br>For expression. |
| [forInit](for-init.md) | [jvm]<br>val [forInit](for-init.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)><br>For initialization (ex: int i = 0, int i = 0, x = 9). |
| [forUpdate](for-update.md) | [jvm]<br>val [forUpdate](for-update.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)><br>For update. |
