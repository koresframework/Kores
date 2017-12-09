[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [IfStatement](index.md) / [expressions](.)

# expressions

`val expressions: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>`

Overrides [IfExpressionHolder.expressions](../-if-expression-holder/expressions.md)

If expressions and operations

Expressions can be: [IfExpr](../-if-expr/index.md) or [IfGroup](../-if-group/index.md) (both only before and/or after [Operators.OR](#) and [Operators.AND](#)),
[Operators.AND](#) (only after a [IfExpr](../-if-expr/index.md)/[IfGroup](../-if-group/index.md), followed by other [IfExpr](../-if-expr/index.md) or [IfGroup](../-if-group/index.md))
and [Operators.OR](#) (only after a [IfExpr](../-if-expr/index.md)/[IfGroup](../-if-group/index.md) and followed by other [IfExpr](../-if-expr/index.md) or [IfGroup](../-if-group/index.md)).

Example of valid and invalid expressions:

[IfExpr](#) [IfExpr](../-if-expr/index.md) = Valid
[IfExpr](#) [IfExpr](../-if-expr/index.md) = Valid
[IfExpr](../-if-expr/index.md) = Invalid
[Operators.OR](../-if-expr/index.md) = Invalid
[Operators.OR](../-if-group/index.md) = Invalid
[IfExpr](#) = Invalid
[IfExpr](../-if-group/index.md) = Invalid
[IfExpr](#) [IfGroup](../-if-group/index.md) = Valid

