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

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [getPartType](../../com.github.jonathanxd.codeapi.util/get-part-type.md) | `fun `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.getPartType(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or throws [IllegalStateException](http://docs.oracle.com/javase/6/docs/api/java/lang/IllegalStateException.html) if [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is not instance of [Typed](../../com.github.jonathanxd.codeapi.base/-typed/index.md) |
| [getPartTypeOrNull](../../com.github.jonathanxd.codeapi.util/get-part-type-or-null.md) | `fun `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.getPartTypeOrNull(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or `null` if [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is not instance of [Typed](../../com.github.jonathanxd.codeapi.base/-typed/index.md). |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
