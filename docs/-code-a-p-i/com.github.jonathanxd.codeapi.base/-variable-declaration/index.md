[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [VariableDeclaration](.)

# VariableDeclaration

`data class VariableDeclaration : `[`VariableBase`](../-variable-base/index.md)`, `[`ValueHolder`](../-value-holder/index.md)`, `[`Typed`](../-typed/index.md)`, `[`ModifiersHolder`](../-modifiers-holder/index.md)`, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)

Declares a variable of type [variableType](variable-type.md) and name [name](name.md) with default value [value](value.md) (null does not
mean that you declared a variable with null value, it means that you declared a variable without a default value,
for null values use `Literals.NULL`).

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `class Builder : `[`Builder`](../-variable-base/-builder/index.md)`<VariableDeclaration, `[`Builder`](-builder/index.md)`>, `[`Builder`](../-value-holder/-builder/index.md)`<VariableDeclaration, `[`Builder`](-builder/index.md)`>, `[`Builder`](../-modifiers-holder/-builder/index.md)`<VariableDeclaration, `[`Builder`](-builder/index.md)`>` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `VariableDeclaration(modifiers: Set<`[`CodeModifier`](../-code-modifier/index.md)`>, variableType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, name: String, value: `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`?)`<br>Declares a variable of type [variableType](-init-.md#com.github.jonathanxd.codeapi.base.VariableDeclaration$<init>(kotlin.collections.Set((com.github.jonathanxd.codeapi.base.CodeModifier)), java.lang.reflect.Type, kotlin.String, com.github.jonathanxd.codeapi.CodePart)/variableType) and name [name](-init-.md#com.github.jonathanxd.codeapi.base.VariableDeclaration$<init>(kotlin.collections.Set((com.github.jonathanxd.codeapi.base.CodeModifier)), java.lang.reflect.Type, kotlin.String, com.github.jonathanxd.codeapi.CodePart)/name) with default value [value](-init-.md#com.github.jonathanxd.codeapi.base.VariableDeclaration$<init>(kotlin.collections.Set((com.github.jonathanxd.codeapi.base.CodeModifier)), java.lang.reflect.Type, kotlin.String, com.github.jonathanxd.codeapi.CodePart)/value) (null does not
mean that you declared a variable with null value, it means that you declared a variable without a default value,
for null values use `Literals.NULL`). |

### Properties

| Name | Summary |
|---|---|
| [modifiers](modifiers.md) | `val modifiers: Set<`[`CodeModifier`](../-code-modifier/index.md)`>`<br>Modifiers. Empty modifier set is the same as public. For package private, an explicit
[CodeModifier.PACKAGE_PRIVATE](../-code-modifier/-p-a-c-k-a-g-e_-p-r-i-v-a-t-e.md) is required. |
| [name](name.md) | `val name: String`<br>Variable name |
| [value](value.md) | `val value: `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`?`<br>Value |
| [variableType](variable-type.md) | `val variableType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Variable type |

### Inherited Properties

| Name | Summary |
|---|---|
| [isPublic](../-modifiers-holder/is-public.md) | `open val isPublic: Boolean`<br>Returns true if is public. |
| [type](../-variable-base/type.md) | `open val type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Element type |

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
