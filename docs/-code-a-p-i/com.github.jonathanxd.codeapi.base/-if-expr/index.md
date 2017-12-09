[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [IfExpr](.)

# IfExpr

`data class IfExpr : `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)

Condition evaluation.

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `class Builder : `[`Builder`](../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<IfExpr, `[`Builder`](-builder/index.md)`>` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `IfExpr(expr1: `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`, operation: `[`Conditional`](../../com.github.jonathanxd.codeapi.operator/-operator/-conditional/index.md)`, expr2: `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`)`<br>Condition evaluation. |

### Properties

| Name | Summary |
|---|---|
| [expr1](expr1.md) | `val expr1: `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>First expression |
| [expr2](expr2.md) | `val expr2: `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Second expression |
| [operation](operation.md) | `val operation: `[`Conditional`](../../com.github.jonathanxd.codeapi.operator/-operator/-conditional/index.md)<br>Operation |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): `[`Builder`](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

### Extension Properties

| Name | Summary |
|---|---|
| [isPrimitive](../../com.github.jonathanxd.codeapi.util/is-primitive.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.isPrimitive: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if the type of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is primitive |
| [safeForComparison](../../com.github.jonathanxd.codeapi.util/safe-for-comparison.md) | `val `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`.safeForComparison: `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Gets comparison safe version of a [CodeInstruction](../../com.github.jonathanxd.codeapi/-code-instruction.md) |
| [type](../../com.github.jonathanxd.codeapi.util/type.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.type: Type`<br>Gets the type of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [typeOrNull](../../com.github.jonathanxd.codeapi.util/type-or-null.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.typeOrNull: Type?`<br>Gets the type of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or null if receiver is not a [Typed](../-typed/index.md) instance. |

### Extension Functions

| Name | Summary |
|---|---|
| [annotationValue](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/annotation-value.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.annotationValue(rType: Class<*>): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) |
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?.asString(simple: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [getRuntimeBooleanEqCheck](../../com.github.jonathanxd.codeapi.util/get-runtime-boolean-eq-check.md) | `fun IfExpr.getRuntimeBooleanEqCheck(): `[`EqCheck`](../../com.github.jonathanxd.codeapi.util/-eq-check/index.md)`?`<br>Gets the runtime [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) value that IfExpr check equality to. Returns `null` if IfExpr does not check [CodeInstruction](../../com.github.jonathanxd.codeapi/-code-instruction.md) against a boolean. |
| [invoke](../../com.github.jonathanxd.codeapi.factory/invoke.md) | `fun `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`.invoke(invokeType: `[`InvokeType`](../-invoke-type/index.md)`, localization: Type, name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, spec: `[`TypeSpec`](../-type-spec/index.md)`, arguments: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): `[`MethodInvocation`](../-method-invocation/index.md)<br>Invokes method on [CodeInstruction](../../com.github.jonathanxd.codeapi/-code-instruction.md) |
| [invokeIntToString](../../com.github.jonathanxd.codeapi.helper/invoke-int-to-string.md) | `fun `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`.invokeIntToString(): `[`MethodInvocation`](../-method-invocation/index.md)<br>Invokes `String.valueOf(int)` on receiver. |
| [invokeInterface](../../com.github.jonathanxd.codeapi.factory/invoke-interface.md) | `fun `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`.invokeInterface(localization: Type, name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, spec: `[`TypeSpec`](../-type-spec/index.md)`, arguments: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): `[`MethodInvocation`](../-method-invocation/index.md)<br>Invokes method on [CodeInstruction](../../com.github.jonathanxd.codeapi/-code-instruction.md). |
| [invokeToString](../../com.github.jonathanxd.codeapi.helper/invoke-to-string.md) | `fun `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`.invokeToString(): `[`MethodInvocation`](../-method-invocation/index.md)<br>Invokes `Any.toString` on receiver. |
| [invokeVirtual](../../com.github.jonathanxd.codeapi.factory/invoke-virtual.md) | `fun `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`.invokeVirtual(localization: Type, name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, spec: `[`TypeSpec`](../-type-spec/index.md)`, arguments: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): `[`MethodInvocation`](../-method-invocation/index.md)<br>Invokes method on [CodeInstruction](../../com.github.jonathanxd.codeapi/-code-instruction.md). |
| [isCheckFalse](../../com.github.jonathanxd.codeapi.util/is-check-false.md) | `fun IfExpr.isCheckFalse(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns `true` if `receiver` IfExpr is a check of [CodeInstruction](../../com.github.jonathanxd.codeapi/-code-instruction.md) equality to `false` constant. |
| [isCheckFalseAnd](../../com.github.jonathanxd.codeapi.util/is-check-false-and.md) | `fun IfExpr.isCheckFalseAnd(predicate: (`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns `true` if `receiver` IfExpr is a check of [instruction](../../com.github.jonathanxd.codeapi/-code-instruction.md) equality to `false` constant and [predicate](../../com.github.jonathanxd.codeapi.util/is-check-false-and.md#com.github.jonathanxd.codeapi.util$isCheckFalseAnd(com.github.jonathanxd.codeapi.base.IfExpr, kotlin.Function1((com.github.jonathanxd.codeapi.CodeInstruction, kotlin.Boolean)))/predicate) returns true for the [instruction](../../com.github.jonathanxd.codeapi/-code-instruction.md). |
| [isCheckTrue](../../com.github.jonathanxd.codeapi.util/is-check-true.md) | `fun IfExpr.isCheckTrue(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns `true` if `receiver` IfExpr is a check of [CodeInstruction](../../com.github.jonathanxd.codeapi/-code-instruction.md) equality to `true` constant. |
| [isCheckTrueAnd](../../com.github.jonathanxd.codeapi.util/is-check-true-and.md) | `fun IfExpr.isCheckTrueAnd(predicate: (`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns `true` if `receiver` IfExpr is a check of [instruction](../../com.github.jonathanxd.codeapi/-code-instruction.md) equality to `true` constant and [predicate](../../com.github.jonathanxd.codeapi.util/is-check-true-and.md#com.github.jonathanxd.codeapi.util$isCheckTrueAnd(com.github.jonathanxd.codeapi.base.IfExpr, kotlin.Function1((com.github.jonathanxd.codeapi.CodeInstruction, kotlin.Boolean)))/predicate) returns true for the [instruction](../../com.github.jonathanxd.codeapi/-code-instruction.md). |
| [removeRedundantNot](../../com.github.jonathanxd.codeapi.util/remove-redundant-not.md) | `fun IfExpr.removeRedundantNot(): IfExpr`<br>Removes redundant not check. Example `if (!(!a))` is simplified to `if (a)` |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)<br>Convert this value to a literal |
| [toLiteralOrNull](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal-or-null.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteralOrNull(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
| [unwrap](../../com.github.jonathanxd.codeapi.util/unwrap.md) | `tailrec fun `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`.unwrap(): `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Unwraps [CodeInstruction](../../com.github.jonathanxd.codeapi/-code-instruction.md) if is a [InstructionWrapper](#) or return receiver if not. |
