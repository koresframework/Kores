[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [VariableBase](.)

# VariableBase

`interface VariableBase : `[`Named`](../-named/index.md)`, `[`Typed`](../-typed/index.md)

Base variable manipulation.

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `interface Builder<out T : VariableBase, S : `[`Builder`](-builder/index.md)`<T, S>> : `[`Builder`](../-named/-builder/index.md)`<T, S>, `[`Builder`](../-typed/-builder/index.md)`<T, S>` |

### Properties

| Name | Summary |
|---|---|
| [name](name.md) | `abstract val name: String`<br>Variable name |
| [type](type.md) | `open val type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Element type |
| [variableType](variable-type.md) | `abstract val variableType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Variable type |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `abstract fun builder(): `[`Builder`](-builder/index.md)`<VariableBase, *>`<br>This builder may or may not accept null values, it depends on implementation. |

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

### Inheritors

| Name | Summary |
|---|---|
| [VariableAccess](../-variable-access/index.md) | `data class VariableAccess : VariableBase, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Access to a variable in local scope. |
| [VariableDeclaration](../-variable-declaration/index.md) | `data class VariableDeclaration : VariableBase, `[`ValueHolder`](../-value-holder/index.md)`, `[`Typed`](../-typed/index.md)`, `[`ModifiersHolder`](../-modifiers-holder/index.md)`, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Declares a variable of type [variableType](../-variable-declaration/variable-type.md) and name [name](../-variable-declaration/name.md) with default value [value](../-variable-declaration/value.md) (null does not
mean that you declared a variable with null value, it means that you declared a variable without a default value,
for null values use `Literals.NULL`). |
| [VariableRef](../../com.github.jonathanxd.codeapi.common/-variable-ref/index.md) | `data class VariableRef : VariableBase`<br>Reference to a Variable, this class must never appear in CodeSource. |
