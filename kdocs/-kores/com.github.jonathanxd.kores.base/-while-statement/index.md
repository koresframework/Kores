//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[WhileStatement](index.md)

# WhileStatement

[jvm]\
data class [WhileStatement](index.md)(**type**: [WhileStatement.Type](-type/index.md), **expressions**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)>, **body**: [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)) : [IfExpressionHolder](../-if-expression-holder/index.md), [BodyHolder](../-body-holder/index.md), [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)

While statement

## Constructors

| | |
|---|---|
| [WhileStatement](-while-statement.md) | [jvm]<br>fun [WhileStatement](-while-statement.md)(type: [WhileStatement.Type](-type/index.md), expressions: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)>, body: [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [IfExpressionHolder.Builder](../-if-expression-holder/-builder/index.md)<[WhileStatement](index.md), [WhileStatement.Builder](-builder/index.md)> , [BodyHolder.Builder](../-body-holder/-builder/index.md)<[WhileStatement](index.md), [WhileStatement.Builder](-builder/index.md)> |
| [Type](-type/index.md) | [jvm]<br>enum [Type](-type/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)<[WhileStatement.Type](-type/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [WhileStatement.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [body](body.md) | [jvm]<br>open override val [body](body.md): [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)<br>Code to execute. |
| [expressions](expressions.md) | [jvm]<br>open override val [expressions](expressions.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)><br>Expression to check to start and/or continue the loop. |
| [type](type.md) | [jvm]<br>val [type](type.md): [WhileStatement.Type](-type/index.md)<br>Type of the while block (while or do-while). |
