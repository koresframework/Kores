[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [FieldDefinition](.)

# FieldDefinition

`data class FieldDefinition : `[`Accessor`](../-accessor/index.md)`, `[`FieldBase`](../-field-base/index.md)`, `[`ValueHolder`](../-value-holder/index.md)`, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)

Defines the value of a field of type [type](type.md), name [name](name.md) in type [localization](localization.md) to [value](value.md), and use [target](target.md) as instance to access
([Access.Type.STATIC](#) for static accesses).

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `class Builder : `[`Builder`](../-accessor/-builder/index.md)`<FieldDefinition, `[`Builder`](-builder/index.md)`>, `[`Builder`](../-field-base/-builder/index.md)`<FieldDefinition, `[`Builder`](-builder/index.md)`>, `[`Builder`](../-value-holder/-builder/index.md)`<FieldDefinition, `[`Builder`](-builder/index.md)`>` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `FieldDefinition(localization: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, target: `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`, type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, name: String, value: `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`)`<br>Defines the value of a field of type [type](-init-.md#com.github.jonathanxd.codeapi.base.FieldDefinition$<init>(java.lang.reflect.Type, com.github.jonathanxd.codeapi.CodePart, java.lang.reflect.Type, kotlin.String, com.github.jonathanxd.codeapi.CodePart)/type), name [name](-init-.md#com.github.jonathanxd.codeapi.base.FieldDefinition$<init>(java.lang.reflect.Type, com.github.jonathanxd.codeapi.CodePart, java.lang.reflect.Type, kotlin.String, com.github.jonathanxd.codeapi.CodePart)/name) in type [localization](-init-.md#com.github.jonathanxd.codeapi.base.FieldDefinition$<init>(java.lang.reflect.Type, com.github.jonathanxd.codeapi.CodePart, java.lang.reflect.Type, kotlin.String, com.github.jonathanxd.codeapi.CodePart)/localization) to [value](-init-.md#com.github.jonathanxd.codeapi.base.FieldDefinition$<init>(java.lang.reflect.Type, com.github.jonathanxd.codeapi.CodePart, java.lang.reflect.Type, kotlin.String, com.github.jonathanxd.codeapi.CodePart)/value), and use [target](-init-.md#com.github.jonathanxd.codeapi.base.FieldDefinition$<init>(java.lang.reflect.Type, com.github.jonathanxd.codeapi.CodePart, java.lang.reflect.Type, kotlin.String, com.github.jonathanxd.codeapi.CodePart)/target) as instance to access
([Access.Type.STATIC](#) for static accesses). |

### Properties

| Name | Summary |
|---|---|
| [localization](localization.md) | `val localization: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Access localization |
| [name](name.md) | `val name: String`<br>Name |
| [target](target.md) | `val target: `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)<br>Access target |
| [type](type.md) | `val type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Element type |
| [value](value.md) | `val value: `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)<br>Value |

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
