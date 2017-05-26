[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.generic](../index.md) / [GenericSignature](.)

# GenericSignature

`class GenericSignature : Any`

Hold information about generic signatures.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `GenericSignature(types_: Array<out `[`GenericType`](../../com.github.jonathanxd.codeapi.type/-generic-type/index.md)`>)`<br>Hold information about generic signatures. |

### Properties

| Name | Summary |
|---|---|
| [isEmpty](is-empty.md) | `val isEmpty: Boolean`<br>Returns true if this generic signature is empty (no types). |
| [isNotEmpty](is-not-empty.md) | `val isNotEmpty: Boolean`<br>Returns true if this generic signature is not empty. |
| [types](types.md) | `val types: Array<out `[`GenericType`](../../com.github.jonathanxd.codeapi.type/-generic-type/index.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [toString](to-string.md) | `fun toString(): String` |

### Companion Object Functions

| Name | Summary |
|---|---|
| [create](create.md) | `fun create(vararg types: `[`GenericType`](../../com.github.jonathanxd.codeapi.type/-generic-type/index.md)`): GenericSignature`<br>Create generic signature. |
| [empty](empty.md) | `fun empty(): GenericSignature`<br>Empty generic signature. |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
