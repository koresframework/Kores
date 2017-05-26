[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [ControlFlow](.)

# ControlFlow

`data class ControlFlow : `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)

Control the flow of a statement.

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `class Builder : `[`Builder`](../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<ControlFlow, `[`Builder`](-builder/index.md)`>` |
| [Type](-type/index.md) | `enum class Type : Enum<`[`Type`](-type/index.md)`>` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ControlFlow(type: `[`Type`](-type/index.md)`, at: `[`Label`](../-label/index.md)`?)`<br>Control the flow of a statement. |

### Properties

| Name | Summary |
|---|---|
| [at](at.md) | `val at: `[`Label`](../-label/index.md)`?`<br>Label to control flow (Note: [Type.CONTINUE](-type/-c-o-n-t-i-n-u-e.md) goes to Start of label and [Type.BREAK](-type/-b-r-e-a-k.md) goes to end of label).
**Note**: [Type.CONTINUE](-type/-c-o-n-t-i-n-u-e.md) to a label may be unstable. |
| [type](type.md) | `val type: `[`Type`](-type/index.md)<br>Type of the flow control |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): `[`Builder`](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [getPartType](../../com.github.jonathanxd.codeapi.util/get-part-type.md) | `fun `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.getPartType(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or throws [IllegalStateException](http://docs.oracle.com/javase/6/docs/api/java/lang/IllegalStateException.html) if [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is not instance of [Typed](../-typed/index.md) |
| [getPartTypeOrNull](../../com.github.jonathanxd.codeapi.util/get-part-type-or-null.md) | `fun `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.getPartTypeOrNull(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or `null` if [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is not instance of [Typed](../-typed/index.md). |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
