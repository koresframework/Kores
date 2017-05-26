[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [FieldAccess](.)

# FieldAccess

`data class FieldAccess : `[`Accessor`](../-accessor/index.md)`, `[`Typed`](../-typed/index.md)`, `[`Named`](../-named/index.md)`, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)

Access a field of type [type](type.md), name [name](name.md) in type [localization](localization.md) using [target](target.md) as instance (Use a [Access.Type.STATIC](#) to
static accesses).

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `class Builder : `[`Builder`](../-accessor/-builder/index.md)`<FieldAccess, `[`Builder`](-builder/index.md)`>, `[`Builder`](../-typed/-builder/index.md)`<FieldAccess, `[`Builder`](-builder/index.md)`>, `[`Builder`](../-named/-builder/index.md)`<FieldAccess, `[`Builder`](-builder/index.md)`>` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `FieldAccess(localization: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, target: `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`, type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, name: String)`<br>Access a field of type [type](-init-.md#com.github.jonathanxd.codeapi.base.FieldAccess$<init>(java.lang.reflect.Type, com.github.jonathanxd.codeapi.CodePart, java.lang.reflect.Type, kotlin.String)/type), name [name](-init-.md#com.github.jonathanxd.codeapi.base.FieldAccess$<init>(java.lang.reflect.Type, com.github.jonathanxd.codeapi.CodePart, java.lang.reflect.Type, kotlin.String)/name) in type [localization](-init-.md#com.github.jonathanxd.codeapi.base.FieldAccess$<init>(java.lang.reflect.Type, com.github.jonathanxd.codeapi.CodePart, java.lang.reflect.Type, kotlin.String)/localization) using [target](-init-.md#com.github.jonathanxd.codeapi.base.FieldAccess$<init>(java.lang.reflect.Type, com.github.jonathanxd.codeapi.CodePart, java.lang.reflect.Type, kotlin.String)/target) as instance (Use a [Access.Type.STATIC](#) to
static accesses). |

### Properties

| Name | Summary |
|---|---|
| [localization](localization.md) | `val localization: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Access localization |
| [name](name.md) | `val name: String`<br>Name |
| [target](target.md) | `val target: `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)<br>Access target |
| [type](type.md) | `val type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Element type |

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
