[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.util](../index.md) / [SimpleResolver](.)

# SimpleResolver

`class SimpleResolver : `[`TypeResolver`](../-type-resolver/index.md)

Simple type resolver

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `SimpleResolver(wrapped: `[`TypeResolver`](../-type-resolver/index.md)`, resolveLoadedClasses: Boolean)`<br>Simple type resolver |

### Functions

| Name | Summary |
|---|---|
| [resolve](resolve.md) | `fun resolve(name: String, isInterface: Boolean): `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)<br>Resolves type with [name](resolve.md#com.github.jonathanxd.codeapi.util.SimpleResolver$resolve(kotlin.String, kotlin.Boolean)/name) to a [CodeType](../../com.github.jonathanxd.codeapi.type/-code-type/index.md). If [isInterface](resolve.md#com.github.jonathanxd.codeapi.util.SimpleResolver$resolve(kotlin.String, kotlin.Boolean)/isInterface) is `true`, and resolved
type is cached as non-interface, then the type should be replaced with one that is marked as interface. |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [resolveClass](../resolve-class.md) | `fun `[`TypeResolver`](../-type-resolver/index.md)`.resolveClass(name: String): `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)<br>Resolve type as class. |
| [resolveInterface](../resolve-interface.md) | `fun `[`TypeResolver`](../-type-resolver/index.md)`.resolveInterface(name: String): `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)<br>Resolve type as interface. |
| [resolveUnknown](../resolve-unknown.md) | `fun `[`TypeResolver`](../-type-resolver/index.md)`.resolveUnknown(name: String): `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)<br>Resolve type as unknown, same as [resolveClass](../resolve-class.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
