[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.common](../index.md) / [VariableRef](.)

# VariableRef

`data class VariableRef : `[`VariableBase`](../../com.github.jonathanxd.codeapi.base/-variable-base/index.md)

Reference to a Variable, this class must never appear in CodeSource.

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `class Builder : `[`Builder`](../../com.github.jonathanxd.codeapi.base/-variable-base/-builder/index.md)`<VariableRef, `[`Builder`](-builder/index.md)`>` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `VariableRef(variableType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, name: String)`<br>Reference to a Variable, this class must never appear in CodeSource. |

### Properties

| Name | Summary |
|---|---|
| [name](name.md) | `val name: String`<br>Variable name |
| [variableType](variable-type.md) | `val variableType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Variable type |

### Inherited Properties

| Name | Summary |
|---|---|
| [type](../../com.github.jonathanxd.codeapi.base/-variable-base/type.md) | `open val type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Element type |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): `[`Builder`](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

### Extension Properties

| Name | Summary |
|---|---|
| [isPrimitive](../../com.github.jonathanxd.codeapi.util/is-primitive.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.isPrimitive: Boolean`<br>Returns true if the type of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is primitive |
| [type](../../com.github.jonathanxd.codeapi.util/type.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Gets the type of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [typeOrNull](../../com.github.jonathanxd.codeapi.util/type-or-null.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.typeOrNull: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Gets the type of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or null if receiver is not a [Typed](../../com.github.jonathanxd.codeapi.base/-typed/index.md) instance. |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
