[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [Case](.)

# Case

`data class Case : `[`ValueHolder`](../-value-holder/index.md)`, `[`Typed`](../-typed/index.md)`, `[`BodyHolder`](../-body-holder/index.md)

Case statement of [SwitchStatement](../-switch-statement/index.md).

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `class Builder : `[`Builder`](../-value-holder/-builder/index.md)`<Case, `[`Builder`](-builder/index.md)`>, `[`Builder`](../-typed/-builder/index.md)`<Case, `[`Builder`](-builder/index.md)`>, `[`Builder`](../-body-holder/-builder/index.md)`<Case, `[`Builder`](-builder/index.md)`>` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Case(value: `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`, body: `[`CodeSource`](../../com.github.jonathanxd.codeapi/-code-source/index.md)`)`<br>Case statement of [SwitchStatement](../-switch-statement/index.md). |

### Properties

| Name | Summary |
|---|---|
| [body](body.md) | `val body: `[`CodeSource`](../../com.github.jonathanxd.codeapi/-code-source/index.md)<br>Body of case statement. |
| [isDefault](is-default.md) | `val isDefault: Boolean`<br>Is case default |
| [isNotDefault](is-not-default.md) | `val isNotDefault: Boolean`<br>Is not case default |
| [type](type.md) | `val type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Element type |
| [value](value.md) | `val value: `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Value to check if operating element matches, null for `default` case. |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): `[`Builder`](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

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
