//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[IfGroup](index.md)

# IfGroup

[jvm]\
data class [IfGroup](index.md)(**expressions**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)>) : [KoresPart](../../com.github.jonathanxd.kores/-kores-part/index.md), [IfExpressionHolder](../-if-expression-holder/index.md), [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)

Group of if expressions.

## Constructors

| | |
|---|---|
| [IfGroup](-if-group.md) | [jvm]<br>fun [IfGroup](-if-group.md)(expressions: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)>) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [IfExpressionHolder.Builder](../-if-expression-holder/-builder/index.md)<[IfGroup](index.md), [IfGroup.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [IfGroup.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [expressions](expressions.md) | [jvm]<br>open override val [expressions](expressions.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)><br>Same rules of [IfExpressionHolder.expressions](../-if-expression-holder/expressions.md) applies to [expressions](expressions.md). |
