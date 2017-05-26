[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.operator](../index.md) / [Operators](.)

# Operators

`object Operators : Any`

[Operators](../-operator/index.md) constants.

### Properties

| Name | Summary |
|---|---|
| [ADD](-a-d-d.md) | `val ADD: <ERROR CLASS>` |
| [AND](-a-n-d.md) | `val AND: <ERROR CLASS>` |
| [BITWISE_AND](-b-i-t-w-i-s-e_-a-n-d.md) | `val BITWISE_AND: <ERROR CLASS>` |
| [BITWISE_EXCLUSIVE_OR](-b-i-t-w-i-s-e_-e-x-c-l-u-s-i-v-e_-o-r.md) | `val BITWISE_EXCLUSIVE_OR: <ERROR CLASS>` |
| [BITWISE_INCLUSIVE_OR](-b-i-t-w-i-s-e_-i-n-c-l-u-s-i-v-e_-o-r.md) | `val BITWISE_INCLUSIVE_OR: <ERROR CLASS>` |
| [DIVISION](-d-i-v-i-s-i-o-n.md) | `val DIVISION: <ERROR CLASS>` |
| [EQUAL_TO](-e-q-u-a-l_-t-o.md) | `val EQUAL_TO: <ERROR CLASS>` |
| [GREATER_THAN](-g-r-e-a-t-e-r_-t-h-a-n.md) | `val GREATER_THAN: <ERROR CLASS>` |
| [GREATER_THAN_OR_EQUAL_TO](-g-r-e-a-t-e-r_-t-h-a-n_-o-r_-e-q-u-a-l_-t-o.md) | `val GREATER_THAN_OR_EQUAL_TO: <ERROR CLASS>` |
| [LESS_THAN](-l-e-s-s_-t-h-a-n.md) | `val LESS_THAN: <ERROR CLASS>` |
| [LESS_THAN_OR_EQUAL_TO](-l-e-s-s_-t-h-a-n_-o-r_-e-q-u-a-l_-t-o.md) | `val LESS_THAN_OR_EQUAL_TO: <ERROR CLASS>` |
| [MULTIPLY](-m-u-l-t-i-p-l-y.md) | `val MULTIPLY: <ERROR CLASS>` |
| [NOT](-n-o-t.md) | `val NOT: <ERROR CLASS>` |
| [NOT_EQUAL_TO](-n-o-t_-e-q-u-a-l_-t-o.md) | `val NOT_EQUAL_TO: <ERROR CLASS>` |
| [OR](-o-r.md) | `val OR: <ERROR CLASS>` |
| [REMAINDER](-r-e-m-a-i-n-d-e-r.md) | `val REMAINDER: <ERROR CLASS>` |
| [SIGNED_LEFT_SHIFT](-s-i-g-n-e-d_-l-e-f-t_-s-h-i-f-t.md) | `val SIGNED_LEFT_SHIFT: <ERROR CLASS>` |
| [SIGNED_RIGHT_SHIFT](-s-i-g-n-e-d_-r-i-g-h-t_-s-h-i-f-t.md) | `val SIGNED_RIGHT_SHIFT: <ERROR CLASS>` |
| [SUBTRACT](-s-u-b-t-r-a-c-t.md) | `val SUBTRACT: <ERROR CLASS>` |
| [UNARY_BITWISE_COMPLEMENT](-u-n-a-r-y_-b-i-t-w-i-s-e_-c-o-m-p-l-e-m-e-n-t.md) | `val UNARY_BITWISE_COMPLEMENT: <ERROR CLASS>` |
| [UNSIGNED_RIGHT_SHIFT](-u-n-s-i-g-n-e-d_-r-i-g-h-t_-s-h-i-f-t.md) | `val UNSIGNED_RIGHT_SHIFT: <ERROR CLASS>` |
| [knownOperators](known-operators.md) | `val knownOperators: Map<String, `[`Operator`](../-operator/index.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [createConditional](create-conditional.md) | `fun createConditional(name: String): <ERROR CLASS>` |
| [createMath](create-math.md) | `fun createMath(name: String): <ERROR CLASS>` |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
