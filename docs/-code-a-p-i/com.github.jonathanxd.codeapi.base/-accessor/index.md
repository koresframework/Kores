[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [Accessor](.)

# Accessor

`interface Accessor : `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)

Accessor of an element. Example: field access/definition, method invocation
and executable code.

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `interface Builder<out T : Accessor, S : `[`Builder`](-builder/index.md)`<T, S>> : `[`Builder`](../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<T, S>` |

### Properties

| Name | Summary |
|---|---|
| [localization](localization.md) | `abstract val localization: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Access localization |
| [target](target.md) | `abstract val target: `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)<br>Access target |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `abstract fun builder(): `[`Builder`](-builder/index.md)`<Accessor, *>`<br>This builder may or may not accept null values, it depends on implementation. |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [getPartType](../../com.github.jonathanxd.codeapi.util/get-part-type.md) | `fun `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.getPartType(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or throws [IllegalStateException](http://docs.oracle.com/javase/6/docs/api/java/lang/IllegalStateException.html) if [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is not instance of [Typed](../-typed/index.md) |
| [getPartTypeOrNull](../../com.github.jonathanxd.codeapi.util/get-part-type-or-null.md) | `fun `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.getPartTypeOrNull(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or `null` if [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is not instance of [Typed](../-typed/index.md). |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |

### Inheritors

| Name | Summary |
|---|---|
| [FieldAccess](../-field-access/index.md) | `data class FieldAccess : Accessor, `[`Typed`](../-typed/index.md)`, `[`Named`](../-named/index.md)`, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Access a field of type [type](../-field-access/type.md), name [name](../-field-access/name.md) in type [localization](../-field-access/localization.md) using [target](../-field-access/target.md) as instance (Use a [Access.Type.STATIC](#) to
static accesses). |
| [FieldDefinition](../-field-definition/index.md) | `data class FieldDefinition : Accessor, `[`FieldBase`](../-field-base/index.md)`, `[`ValueHolder`](../-value-holder/index.md)`, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Defines the value of a field of type [type](../-field-definition/type.md), name [name](../-field-definition/name.md) in type [localization](../-field-definition/localization.md) to [value](../-field-definition/value.md), and use [target](../-field-definition/target.md) as instance to access
([Access.Type.STATIC](#) for static accesses). |
| [MethodInvocation](../-method-invocation/index.md) | `data class MethodInvocation : Accessor, `[`ArgumentHolder`](../-argument-holder/index.md)`, `[`Typed`](../-typed/index.md)`, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Invokes a method. |
