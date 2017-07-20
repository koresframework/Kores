[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [IfExpressionHolder](.)

# IfExpressionHolder

`interface IfExpressionHolder : `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)

A element that holds [IfExpressions](../-if-expr/index.md) and [Operations](../../com.github.jonathanxd.codeapi.operator/-operators/index.md).

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `interface Builder<out T : IfExpressionHolder, S : `[`Builder`](-builder/index.md)`<T, S>> : `[`Builder`](../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<T, S>` |

### Properties

| Name | Summary |
|---|---|
| [expressions](expressions.md) | `abstract val expressions: List<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>`<br>If expressions and operations |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `abstract fun builder(): `[`Builder`](-builder/index.md)`<IfExpressionHolder, *>`<br>This builder may or may not accept null values, it depends on implementation. |

### Companion Object Functions

| Name | Summary |
|---|---|
| [check](check.md) | `fun check(part: `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`): Unit` |

### Extension Properties

| Name | Summary |
|---|---|
| [isPrimitive](../../com.github.jonathanxd.codeapi.util/is-primitive.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.isPrimitive: Boolean`<br>Returns true if the type of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is primitive |
| [type](../../com.github.jonathanxd.codeapi.util/type.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Gets the type of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [typeOrNull](../../com.github.jonathanxd.codeapi.util/type-or-null.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.typeOrNull: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Gets the type of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or null if receiver is not a [Typed](../-typed/index.md) instance. |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |

### Inheritors

| Name | Summary |
|---|---|
| [ForStatement](../-for-statement/index.md) | `data class ForStatement : IfExpressionHolder, `[`BodyHolder`](../-body-holder/index.md)`, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>For statement. |
| [IfGroup](../-if-group/index.md) | `data class IfGroup : `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`, IfExpressionHolder, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Group of if expressions. |
| [IfStatement](../-if-statement/index.md) | `data class IfStatement : IfExpressionHolder, `[`BodyHolder`](../-body-holder/index.md)`, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>If statement. |
| [WhileStatement](../-while-statement/index.md) | `data class WhileStatement : IfExpressionHolder, `[`BodyHolder`](../-body-holder/index.md)`, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>While statement |
