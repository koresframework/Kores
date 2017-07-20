[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [CodeParameter](.)

# CodeParameter

`data class CodeParameter : `[`Typed`](../-typed/index.md)`, `[`Named`](../-named/index.md)`, `[`Annotable`](../-annotable/index.md)`, `[`ModifiersHolder`](../-modifiers-holder/index.md)

Parameter part.

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `class Builder : `[`Builder`](../-named/-builder/index.md)`<CodeParameter, `[`Builder`](-builder/index.md)`>, `[`Builder`](../-typed/-builder/index.md)`<CodeParameter, `[`Builder`](-builder/index.md)`>, `[`Builder`](../-annotable/-builder/index.md)`<CodeParameter, `[`Builder`](-builder/index.md)`>, `[`Builder`](../-modifiers-holder/-builder/index.md)`<CodeParameter, `[`Builder`](-builder/index.md)`>` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CodeParameter(annotations: List<`[`Annotation`](../-annotation/index.md)`>, modifiers: Set<`[`CodeModifier`](../-code-modifier/index.md)`>, type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, name: String)`<br>Parameter part. |

### Properties

| Name | Summary |
|---|---|
| [annotations](annotations.md) | `val annotations: List<`[`Annotation`](../-annotation/index.md)`>`<br>Annotations |
| [modifiers](modifiers.md) | `val modifiers: Set<`[`CodeModifier`](../-code-modifier/index.md)`>`<br>Modifiers. Empty modifier set is the same as public. For package private, an explicit
[CodeModifier.PACKAGE_PRIVATE](../-code-modifier/-p-a-c-k-a-g-e_-p-r-i-v-a-t-e.md) is required. |
| [name](name.md) | `val name: String`<br>Name |
| [type](type.md) | `val type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Element type |

### Inherited Properties

| Name | Summary |
|---|---|
| [isPublic](../-modifiers-holder/is-public.md) | `open val isPublic: Boolean`<br>Returns true if is public. |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): `[`Builder`](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

### Extension Properties

| Name | Summary |
|---|---|
| [access](../../com.github.jonathanxd.codeapi.util.conversion/access.md) | `val CodeParameter.access: `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Convert CodeParameter to variable access |
| [isPrimitive](../../com.github.jonathanxd.codeapi.util/is-primitive.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.isPrimitive: Boolean`<br>Returns true if the type of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is primitive |
| [type](../../com.github.jonathanxd.codeapi.util/type.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Gets the type of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [typeOrNull](../../com.github.jonathanxd.codeapi.util/type-or-null.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.typeOrNull: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Gets the type of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or null if receiver is not a [Typed](../-typed/index.md) instance. |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
| [toVariableAccess](../../com.github.jonathanxd.codeapi.util.conversion/to-variable-access.md) | `fun CodeParameter.toVariableAccess(): `[`VariableAccess`](../-variable-access/index.md) |
