[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.util](../index.md) / [CodeTypeResolver](.)

# CodeTypeResolver

`abstract class CodeTypeResolver : (String) -> `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`, `[`Function`](http://docs.oracle.com/javase/6/docs/api/java/util/function/Function.html)`<String, `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CodeTypeResolver()` |

### Functions

| Name | Summary |
|---|---|
| [apply](apply.md) | `open fun apply(t: String): `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md) |
| [invoke](invoke.md) | `open fun invoke(p1: String): `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md) |
| [resolve](resolve.md) | `abstract fun resolve(t: String): `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [fromJavaFunction](from-java-function.md) | `fun fromJavaFunction(func: `[`Function`](http://docs.oracle.com/javase/6/docs/api/java/util/function/Function.html)`<String, `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`>): CodeTypeResolver` |
| [fromKtFunction](from-kt-function.md) | `fun fromKtFunction(func: (String) -> `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`): CodeTypeResolver` |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
