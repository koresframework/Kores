[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.util](../index.md) / [TypeResolver](.)

# TypeResolver

`@FunctionalInterface interface TypeResolver : Any`

Resolves a class name which may vary to a [CodeType](../../com.github.jonathanxd.codeapi.type/-code-type/index.md) and cache the resolved type.

### Functions

| Name | Summary |
|---|---|
| [resolve](resolve.md) | `abstract fun resolve(name: String, isInterface: Boolean): `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)<br>Resolves type with [name](resolve.md#com.github.jonathanxd.codeapi.util.TypeResolver$resolve(kotlin.String, kotlin.Boolean)/name) to a [CodeType](../../com.github.jonathanxd.codeapi.type/-code-type/index.md). If [isInterface](resolve.md#com.github.jonathanxd.codeapi.util.TypeResolver$resolve(kotlin.String, kotlin.Boolean)/isInterface) is `true`, and resolved
type is cached as non-interface, then the type should be replaced with one that is marked as interface. |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [resolveClass](../resolve-class.md) | `fun TypeResolver.resolveClass(name: String): `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)<br>Resolve type as class. |
| [resolveInterface](../resolve-interface.md) | `fun TypeResolver.resolveInterface(name: String): `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)<br>Resolve type as interface. |
| [resolveUnknown](../resolve-unknown.md) | `fun TypeResolver.resolveUnknown(name: String): `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)<br>Resolve type as unknown, same as [resolveClass](../resolve-class.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |

### Inheritors

| Name | Summary |
|---|---|
| [SimpleResolver](../-simple-resolver/index.md) | `class SimpleResolver : TypeResolver`<br>Simple type resolver |
