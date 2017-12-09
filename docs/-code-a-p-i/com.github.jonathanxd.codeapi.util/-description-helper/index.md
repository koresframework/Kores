[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.util](../index.md) / [DescriptionHelper](.)

# DescriptionHelper

`object DescriptionHelper`

Description utilities

### Functions

| Name | Summary |
|---|---|
| [toTypeSpec](to-type-spec.md) | `fun toTypeSpec(description: Description, resolver: `[`TypeResolver`](../-type-resolver/index.md)`): `[`TypeSpec`](../../com.github.jonathanxd.codeapi.base/-type-spec/index.md)<br>Resolve types of [description](to-type-spec.md#com.github.jonathanxd.codeapi.util.DescriptionHelper$toTypeSpec(com.github.jonathanxd.iutils.description.Description, com.github.jonathanxd.codeapi.util.TypeResolver)/description) using [resolver](to-type-spec.md#com.github.jonathanxd.codeapi.util.DescriptionHelper$toTypeSpec(com.github.jonathanxd.iutils.description.Description, com.github.jonathanxd.codeapi.util.TypeResolver)/resolver) and convert to [TypeSpec](../../com.github.jonathanxd.codeapi.base/-type-spec/index.md)`fun toTypeSpec(desc: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, resolver: `[`TypeResolver`](../-type-resolver/index.md)`): `[`TypeSpec`](../../com.github.jonathanxd.codeapi.base/-type-spec/index.md)<br>Resolve types of [desc](to-type-spec.md#com.github.jonathanxd.codeapi.util.DescriptionHelper$toTypeSpec(kotlin.String, com.github.jonathanxd.codeapi.util.TypeResolver)/desc) using [resolver](to-type-spec.md#com.github.jonathanxd.codeapi.util.DescriptionHelper$toTypeSpec(kotlin.String, com.github.jonathanxd.codeapi.util.TypeResolver)/resolver) and convert to [TypeSpec](../../com.github.jonathanxd.codeapi.base/-type-spec/index.md) |

### Extension Functions

| Name | Summary |
|---|---|
| [annotationValue](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/annotation-value.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.annotationValue(rType: Class<*>): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) |
| [asString](../kotlin.-any/as-string.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?.asString(simple: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)<br>Convert this value to a literal |
| [toLiteralOrNull](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal-or-null.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteralOrNull(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
