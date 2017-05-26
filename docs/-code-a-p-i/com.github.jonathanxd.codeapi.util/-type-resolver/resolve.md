[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.util](../index.md) / [TypeResolver](index.md) / [resolve](.)

# resolve

`abstract fun resolve(name: String, isInterface: Boolean): `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)

Resolves type with [name](resolve.md#com.github.jonathanxd.codeapi.util.TypeResolver$resolve(kotlin.String, kotlin.Boolean)/name) to a [CodeType](../../com.github.jonathanxd.codeapi.type/-code-type/index.md). If [isInterface](resolve.md#com.github.jonathanxd.codeapi.util.TypeResolver$resolve(kotlin.String, kotlin.Boolean)/isInterface) is `true`, and resolved
type is cached as non-interface, then the type should be replaced with one that is marked as interface.

