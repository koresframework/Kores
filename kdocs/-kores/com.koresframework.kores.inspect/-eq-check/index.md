//[Kores](../../../index.md)/[com.koresframework.kores.inspect](../index.md)/[EqCheck](index.md)

# EqCheck

[jvm]\
data class [EqCheck](index.md)(**instruction**: [Instruction](../../com.koresframework.kores/-instruction/index.md), **operator**: [Operator](../../com.koresframework.kores.operator/-operator/index.md), **booleanConstant**: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html))

Data class to hold equality check against a boolean constant.

## Constructors

| | |
|---|---|
| [EqCheck](-eq-check.md) | [jvm]<br>fun [EqCheck](-eq-check.md)(instruction: [Instruction](../../com.koresframework.kores/-instruction/index.md), operator: [Operator](../../com.koresframework.kores.operator/-operator/index.md), booleanConstant: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [booleanConstant](boolean-constant.md) | [jvm]<br>val [booleanConstant](boolean-constant.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Boolean constant to compare to, does not have any direct relation to [operator](operator.md). |
| [instruction](instruction.md) | [jvm]<br>val [instruction](instruction.md): [Instruction](../../com.koresframework.kores/-instruction/index.md)<br>Instruction to check if is equal to [booleanConstant](boolean-constant.md) |
| [operator](operator.md) | [jvm]<br>val [operator](operator.md): [Operator](../../com.koresframework.kores.operator/-operator/index.md)<br>Operator used in [IfExpr](../../com.koresframework.kores.base/-if-expr/index.md) to denote the comparison, does not have any direct relation to comparison against [booleanConstant](boolean-constant.md). |
