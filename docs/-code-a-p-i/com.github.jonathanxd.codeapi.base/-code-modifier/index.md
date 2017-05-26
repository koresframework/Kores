[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [CodeModifier](.)

# CodeModifier

`enum class CodeModifier : Enum<CodeModifier>, `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)

Modifiers enum.

### Enum Values

| Name | Summary |
|---|---|
| [PUBLIC](-p-u-b-l-i-c.md) |  |
| [PROTECTED](-p-r-o-t-e-c-t-e-d.md) |  |
| [PRIVATE](-p-r-i-v-a-t-e.md) |  |
| [PACKAGE_PRIVATE](-p-a-c-k-a-g-e_-p-r-i-v-a-t-e.md) |  |
| [ABSTRACT](-a-b-s-t-r-a-c-t.md) |  |
| [DEFAULT](-d-e-f-a-u-l-t.md) |  |
| [STATIC](-s-t-a-t-i-c.md) |  |
| [FINAL](-f-i-n-a-l.md) |  |
| [TRANSIENT](-t-r-a-n-s-i-e-n-t.md) |  |
| [VOLATILE](-v-o-l-a-t-i-l-e.md) |  |
| [SYNCHRONIZED](-s-y-n-c-h-r-o-n-i-z-e-d.md) |  |
| [NATIVE](-n-a-t-i-v-e.md) |  |
| [STRICTFP](-s-t-r-i-c-t-f-p.md) |  |
| [BRIDGE](-b-r-i-d-g-e.md) |  |
| [VARARGS](-v-a-r-a-r-g-s.md) |  |
| [SYNTHETIC](-s-y-n-t-h-e-t-i-c.md) |  |
| [ANNOTATION](-a-n-n-o-t-a-t-i-o-n.md) |  |
| [ENUM](-e-n-u-m.md) |  |
| [MANDATED](-m-a-n-d-a-t-e-d.md) |  |

### Properties

| Name | Summary |
|---|---|
| [expr](expr.md) | `val expr: String`<br>Modifier name. |
| [modifierType](modifier-type.md) | `val modifierType: `[`ModifierType`](../-modifier-type/index.md)<br>Type of modifier. |

### Inherited Functions

| Name | Summary |
|---|---|
| [builder](../../com.github.jonathanxd.codeapi/-code-part/builder.md) | `open fun builder(): `[`Builder`](../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<`[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`, *>`<br>This builder may or may not accept null values, it depends on implementation. |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [getPartType](../../com.github.jonathanxd.codeapi.util/get-part-type.md) | `fun `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.getPartType(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or throws [IllegalStateException](http://docs.oracle.com/javase/6/docs/api/java/lang/IllegalStateException.html) if [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is not instance of [Typed](../-typed/index.md) |
| [getPartTypeOrNull](../../com.github.jonathanxd.codeapi.util/get-part-type-or-null.md) | `fun `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.getPartTypeOrNull(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or `null` if [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is not instance of [Typed](../-typed/index.md). |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
