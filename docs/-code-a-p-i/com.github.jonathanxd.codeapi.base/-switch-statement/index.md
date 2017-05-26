[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [SwitchStatement](.)

# SwitchStatement

`data class SwitchStatement : `[`ValueHolder`](../-value-holder/index.md)`, `[`Typed`](../-typed/index.md)`, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)

Switch statement, this switch can switch numeric values and object values (like Enum, String or other
objects).

You could switch objects, but make sure that the object implements [Any.hashCode](#)
and [Any.equals](#) methods.

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `class Builder : `[`Builder`](../-value-holder/-builder/index.md)`<SwitchStatement, `[`Builder`](-builder/index.md)`>, `[`Builder`](../-typed/-builder/index.md)`<SwitchStatement, `[`Builder`](-builder/index.md)`>` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `SwitchStatement(value: `[`Typed`](../-typed/index.md)`, switchType: `[`SwitchType`](../-switch-type/index.md)`, cases: List<`[`Case`](../-case/index.md)`>)`<br>Switch statement, this switch can switch numeric values and object values (like Enum, String or other
objects). |

### Properties

| Name | Summary |
|---|---|
| [cases](cases.md) | `val cases: List<`[`Case`](../-case/index.md)`>`<br>Cases statements. |
| [switchType](switch-type.md) | `val switchType: `[`SwitchType`](../-switch-type/index.md)<br>Type of the switch |
| [type](type.md) | `val type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Element type |
| [value](value.md) | `val value: `[`Typed`](../-typed/index.md)<br>Value to switch |

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
