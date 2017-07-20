[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [IterationType](.)

# IterationType

`data class IterationType : Any`

Iteration type used to generate bytecode and source code iterations.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `IterationType(iteratorMethodSpec: `[`MethodTypeSpec`](../../com.github.jonathanxd.codeapi.common/-method-type-spec/index.md)`, hasNextName: String, nextMethodSpec: `[`MethodTypeSpec`](../../com.github.jonathanxd.codeapi.common/-method-type-spec/index.md)`)`<br>Iteration type used to generate bytecode and source code iterations. |

### Properties

| Name | Summary |
|---|---|
| [hasNextName](has-next-name.md) | `val hasNextName: String`<br>Name of method which returns true if has next elements. |
| [iteratorMethodSpec](iterator-method-spec.md) | `val iteratorMethodSpec: `[`MethodTypeSpec`](../../com.github.jonathanxd.codeapi.common/-method-type-spec/index.md)<br>Specification of iterator method. |
| [nextMethodSpec](next-method-spec.md) | `val nextMethodSpec: `[`MethodTypeSpec`](../../com.github.jonathanxd.codeapi.common/-method-type-spec/index.md)<br>Specification of method which returns the next element. |

### Companion Object Properties

| Name | Summary |
|---|---|
| [ARRAY](-a-r-r-a-y.md) | `val ARRAY: IterationType`<br>Foreach on array. Requires special handling. |
| [ITERABLE_ELEMENT](-i-t-e-r-a-b-l-e_-e-l-e-m-e-n-t.md) | `val ITERABLE_ELEMENT: IterationType`<br>Foreach on an element which extends iterable |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
