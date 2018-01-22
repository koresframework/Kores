[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.inspect](../index.md) / [EqCheck](.)

# EqCheck

`data class EqCheck`

Data class to hold equality check against a boolean constant.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `EqCheck(instruction: `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`, operator: `[`Operator`](../../com.github.jonathanxd.codeapi.operator/-operator/index.md)`, booleanConstant: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`)`<br>Data class to hold equality check against a boolean constant. |

### Properties

| Name | Summary |
|---|---|
| [booleanConstant](boolean-constant.md) | `val booleanConstant: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Boolean constant to compare to, does not have any direct relation to [operator](operator.md). |
| [instruction](instruction.md) | `val instruction: `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Instruction to check if is equal to [booleanConstant](boolean-constant.md) |
| [operator](operator.md) | `val operator: `[`Operator`](../../com.github.jonathanxd.codeapi.operator/-operator/index.md)<br>Operator used in [IfExpr](../../com.github.jonathanxd.codeapi.base/-if-expr/index.md) to denote the comparison, does not have any direct relation to comparison against [booleanConstant](boolean-constant.md). |

### Extension Functions

| Name | Summary |
|---|---|
| [annotationValue](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/annotation-value.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.annotationValue(rType: Class<*>): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) |
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?.asString(simple: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)<br>Convert this value to a literal |
| [toLiteralOrNull](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal-or-null.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteralOrNull(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
