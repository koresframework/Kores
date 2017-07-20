[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.util](../index.md) / [SimpleResolver](index.md) / [resolve](.)

# resolve

`fun resolve(name: String, isInterface: Boolean): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)

Overrides [TypeResolver.resolve](../-type-resolver/resolve.md)

Resolves type with [name](resolve.md#com.github.jonathanxd.codeapi.util.SimpleResolver$resolve(kotlin.String, kotlin.Boolean)/name) to a [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html). If [isInterface](resolve.md#com.github.jonathanxd.codeapi.util.SimpleResolver$resolve(kotlin.String, kotlin.Boolean)/isInterface) is `true`, and resolved
type is cached as non-interface, then the type should be replaced with one that is marked as interface.

