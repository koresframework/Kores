[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.util](../index.md) / [TypeResolver](.)

# TypeResolver

`@FunctionalInterface interface TypeResolver`

Resolves a class name which may vary to a [Type](#) and cache the resolved type.

### Functions

| Name | Summary |
|---|---|
| [resolve](resolve.md) | `abstract fun resolve(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, isInterface: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): Type`<br>Resolves type with [name](resolve.md#com.github.jonathanxd.codeapi.util.TypeResolver$resolve(kotlin.String, kotlin.Boolean)/name) to a [Type](#). If [isInterface](resolve.md#com.github.jonathanxd.codeapi.util.TypeResolver$resolve(kotlin.String, kotlin.Boolean)/isInterface) is `true`, and resolved type is cached as non-interface, then the type should be replaced with one that is marked as interface. |

### Extension Functions

| Name | Summary |
|---|---|
| [annotationValue](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/annotation-value.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.annotationValue(rType: Class<*>): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) |
| [asString](../kotlin.-any/as-string.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?.asString(simple: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [resolveClass](../resolve-class.md) | `fun TypeResolver.resolveClass(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Type`<br>Resolve type as class. |
| [resolveInterface](../resolve-interface.md) | `fun TypeResolver.resolveInterface(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Type`<br>Resolve type as interface. |
| [resolveUnknown](../resolve-unknown.md) | `fun TypeResolver.resolveUnknown(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Type`<br>Resolve type as unknown, same as [resolveClass](../resolve-class.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)<br>Convert this value to a literal |
| [toLiteralOrNull](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal-or-null.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteralOrNull(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |

### Inheritors

| Name | Summary |
|---|---|
| [SimpleResolver](../-simple-resolver/index.md) | `class SimpleResolver : TypeResolver`<br>Simple type resolver |
