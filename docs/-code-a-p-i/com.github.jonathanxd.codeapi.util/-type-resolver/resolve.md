[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.util](../index.md) / [TypeResolver](index.md) / [resolve](.)

# resolve

`abstract fun resolve(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, isInterface: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): Type`

Resolves type with [name](resolve.md#com.github.jonathanxd.codeapi.util.TypeResolver$resolve(kotlin.String, kotlin.Boolean)/name) to a [Type](#). If [isInterface](resolve.md#com.github.jonathanxd.codeapi.util.TypeResolver$resolve(kotlin.String, kotlin.Boolean)/isInterface) is `true`, and resolved
type is cached as non-interface, then the type should be replaced with one that is marked as interface.

