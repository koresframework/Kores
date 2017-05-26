[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.util](../index.md) / [DescriptionHelper](.)

# DescriptionHelper

`object DescriptionHelper : Any`

Description utilities

### Functions

| Name | Summary |
|---|---|
| [toTypeSpec](to-type-spec.md) | `fun toTypeSpec(description: Description, resolver: `[`TypeResolver`](../-type-resolver/index.md)`): `[`TypeSpec`](../../com.github.jonathanxd.codeapi.base/-type-spec/index.md)<br>Resolve types of [description](to-type-spec.md#com.github.jonathanxd.codeapi.util.DescriptionHelper$toTypeSpec(com.github.jonathanxd.iutils.description.Description, com.github.jonathanxd.codeapi.util.TypeResolver)/description) using [resolver](to-type-spec.md#com.github.jonathanxd.codeapi.util.DescriptionHelper$toTypeSpec(com.github.jonathanxd.iutils.description.Description, com.github.jonathanxd.codeapi.util.TypeResolver)/resolver) and convert to [TypeSpec](../../com.github.jonathanxd.codeapi.base/-type-spec/index.md)`fun toTypeSpec(desc: String, resolver: `[`TypeResolver`](../-type-resolver/index.md)`): `[`TypeSpec`](../../com.github.jonathanxd.codeapi.base/-type-spec/index.md)<br>Resolve types of [desc](to-type-spec.md#com.github.jonathanxd.codeapi.util.DescriptionHelper$toTypeSpec(kotlin.String, com.github.jonathanxd.codeapi.util.TypeResolver)/desc) using [resolver](to-type-spec.md#com.github.jonathanxd.codeapi.util.DescriptionHelper$toTypeSpec(kotlin.String, com.github.jonathanxd.codeapi.util.TypeResolver)/resolver) and convert to [TypeSpec](../../com.github.jonathanxd.codeapi.base/-type-spec/index.md) |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
