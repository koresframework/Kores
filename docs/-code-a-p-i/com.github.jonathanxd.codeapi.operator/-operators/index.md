[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.operator](../index.md) / [Operators](.)

# Operators

`object Operators`

[Operators](../-operator/index.md) constants.

### Properties

| Name | Summary |
|---|---|
| [ADD](-a-d-d.md) | `val ADD: `[`Math`](../-operator/-math/index.md) |
| [AND](-a-n-d.md) | `val AND: `[`Conditional`](../-operator/-conditional/index.md) |
| [BITWISE_AND](-b-i-t-w-i-s-e_-a-n-d.md) | `val BITWISE_AND: `[`Math`](../-operator/-math/index.md) |
| [BITWISE_EXCLUSIVE_OR](-b-i-t-w-i-s-e_-e-x-c-l-u-s-i-v-e_-o-r.md) | `val BITWISE_EXCLUSIVE_OR: `[`Math`](../-operator/-math/index.md) |
| [BITWISE_INCLUSIVE_OR](-b-i-t-w-i-s-e_-i-n-c-l-u-s-i-v-e_-o-r.md) | `val BITWISE_INCLUSIVE_OR: `[`Math`](../-operator/-math/index.md) |
| [DIVISION](-d-i-v-i-s-i-o-n.md) | `val DIVISION: `[`Math`](../-operator/-math/index.md) |
| [EQUAL_TO](-e-q-u-a-l_-t-o.md) | `val EQUAL_TO: `[`Conditional`](../-operator/-conditional/index.md) |
| [GREATER_THAN](-g-r-e-a-t-e-r_-t-h-a-n.md) | `val GREATER_THAN: `[`Conditional`](../-operator/-conditional/index.md) |
| [GREATER_THAN_OR_EQUAL_TO](-g-r-e-a-t-e-r_-t-h-a-n_-o-r_-e-q-u-a-l_-t-o.md) | `val GREATER_THAN_OR_EQUAL_TO: `[`Conditional`](../-operator/-conditional/index.md) |
| [LESS_THAN](-l-e-s-s_-t-h-a-n.md) | `val LESS_THAN: `[`Conditional`](../-operator/-conditional/index.md) |
| [LESS_THAN_OR_EQUAL_TO](-l-e-s-s_-t-h-a-n_-o-r_-e-q-u-a-l_-t-o.md) | `val LESS_THAN_OR_EQUAL_TO: `[`Conditional`](../-operator/-conditional/index.md) |
| [MULTIPLY](-m-u-l-t-i-p-l-y.md) | `val MULTIPLY: `[`Math`](../-operator/-math/index.md) |
| [NOT](-n-o-t.md) | `val NOT: `[`Conditional`](../-operator/-conditional/index.md) |
| [NOT_EQUAL_TO](-n-o-t_-e-q-u-a-l_-t-o.md) | `val NOT_EQUAL_TO: `[`Conditional`](../-operator/-conditional/index.md) |
| [OR](-o-r.md) | `val OR: `[`Conditional`](../-operator/-conditional/index.md) |
| [REMAINDER](-r-e-m-a-i-n-d-e-r.md) | `val REMAINDER: `[`Math`](../-operator/-math/index.md) |
| [SIGNED_LEFT_SHIFT](-s-i-g-n-e-d_-l-e-f-t_-s-h-i-f-t.md) | `val SIGNED_LEFT_SHIFT: `[`Math`](../-operator/-math/index.md) |
| [SIGNED_RIGHT_SHIFT](-s-i-g-n-e-d_-r-i-g-h-t_-s-h-i-f-t.md) | `val SIGNED_RIGHT_SHIFT: `[`Math`](../-operator/-math/index.md) |
| [SUBTRACT](-s-u-b-t-r-a-c-t.md) | `val SUBTRACT: `[`Math`](../-operator/-math/index.md) |
| [UNARY_BITWISE_COMPLEMENT](-u-n-a-r-y_-b-i-t-w-i-s-e_-c-o-m-p-l-e-m-e-n-t.md) | `val UNARY_BITWISE_COMPLEMENT: `[`Math`](../-operator/-math/index.md) |
| [UNSIGNED_RIGHT_SHIFT](-u-n-s-i-g-n-e-d_-r-i-g-h-t_-s-h-i-f-t.md) | `val UNSIGNED_RIGHT_SHIFT: `[`Math`](../-operator/-math/index.md) |
| [knownOperators](known-operators.md) | `val knownOperators: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`Operator`](../-operator/index.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [createConditional](create-conditional.md) | `fun createConditional(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Conditional`](../-operator/-conditional/index.md) |
| [createMath](create-math.md) | `fun createMath(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Math`](../-operator/-math/index.md) |

### Extension Functions

| Name | Summary |
|---|---|
| [annotationValue](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/annotation-value.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.annotationValue(rType: Class<*>): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) |
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?.asString(simple: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)<br>Convert this value to a literal |
| [toLiteralOrNull](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal-or-null.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteralOrNull(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
