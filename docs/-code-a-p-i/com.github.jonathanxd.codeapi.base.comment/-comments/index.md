[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base.comment](../index.md) / [Comments](.)

# Comments

`data class Comments : `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)

Hold a list of comments.

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `class Builder : `[`Builder`](../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<Comments, `[`Builder`](-builder/index.md)`>` |
| [Type](-type/index.md) | `enum class Type : Enum<`[`Type`](-type/index.md)`>`<br>Comment type |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Comments(comments: List<`[`Comment`](../-comment/index.md)`>, type: `[`Type`](-type/index.md)`)`<br>Hold a list of comments. |

### Properties

| Name | Summary |
|---|---|
| [comments](comments.md) | `val comments: List<`[`Comment`](../-comment/index.md)`>`<br>Comment list |
| [type](type.md) | `val type: `[`Type`](-type/index.md)<br>Type of comments entry. |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): `[`Builder`](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |
| [isAbsent](is-absent.md) | `fun isAbsent(): Boolean`<br>Returns true if this Comments instance is [Absent](-absent.md). Absent comment is not the same as
empty comment. |
| [isNotAbsent](is-not-absent.md) | `fun isNotAbsent(): Boolean`<br>Returns true if this Comments instance is not [Absent](-absent.md). Absent comment is not the same as
empty comment. |

### Companion Object Properties

| Name | Summary |
|---|---|
| [Absent](-absent.md) | `val Absent: Comments`<br>Absent comments. Absent comment should not be generated. |

### Extension Properties

| Name | Summary |
|---|---|
| [isPrimitive](../../com.github.jonathanxd.codeapi.util/is-primitive.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.isPrimitive: Boolean`<br>Returns true if the type of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is primitive |
| [safeForComparison](../../com.github.jonathanxd.codeapi.util/safe-for-comparison.md) | `val `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`.safeForComparison: `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Gets comparison safe version of a [CodeInstruction](../../com.github.jonathanxd.codeapi/-code-instruction.md) |
| [type](../../com.github.jonathanxd.codeapi.util/type.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Gets the type of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [typeOrNull](../../com.github.jonathanxd.codeapi.util/type-or-null.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.typeOrNull: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Gets the type of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or null if receiver is not a [Typed](../../com.github.jonathanxd.codeapi.base/-typed/index.md) instance. |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [invoke](../../com.github.jonathanxd.codeapi.factory/invoke.md) | `fun `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`.invoke(invokeType: `[`InvokeType`](../../com.github.jonathanxd.codeapi.base/-invoke-type/index.md)`, localization: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, name: String, spec: `[`TypeSpec`](../../com.github.jonathanxd.codeapi.base/-type-spec/index.md)`, arguments: List<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Invokes method on [CodeInstruction](../../com.github.jonathanxd.codeapi/-code-instruction.md) |
| [invokeIntToString](../../com.github.jonathanxd.codeapi.helper/invoke-int-to-string.md) | `fun `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`.invokeIntToString(): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Invokes `String.valueOf(int)` on receiver. |
| [invokeInterface](../../com.github.jonathanxd.codeapi.factory/invoke-interface.md) | `fun `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`.invokeInterface(localization: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, name: String, spec: `[`TypeSpec`](../../com.github.jonathanxd.codeapi.base/-type-spec/index.md)`, arguments: List<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Invokes method on [CodeInstruction](../../com.github.jonathanxd.codeapi/-code-instruction.md). |
| [invokeToString](../../com.github.jonathanxd.codeapi.helper/invoke-to-string.md) | `fun `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`.invokeToString(): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Invokes `Any.toString` on receiver. |
| [invokeVirtual](../../com.github.jonathanxd.codeapi.factory/invoke-virtual.md) | `fun `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`.invokeVirtual(localization: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, name: String, spec: `[`TypeSpec`](../../com.github.jonathanxd.codeapi.base/-type-spec/index.md)`, arguments: List<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Invokes method on [CodeInstruction](../../com.github.jonathanxd.codeapi/-code-instruction.md). |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
| [unwrap](../../com.github.jonathanxd.codeapi.util/unwrap.md) | `tailrec fun `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`.unwrap(): `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Unwraps [CodeInstruction](../../com.github.jonathanxd.codeapi/-code-instruction.md) if is a [InstructionWrapper](#) or return receiver if not. |
