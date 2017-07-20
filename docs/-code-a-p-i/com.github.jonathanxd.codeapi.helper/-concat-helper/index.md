[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.helper](../index.md) / [ConcatHelper](.)

# ConcatHelper

`class ConcatHelper : Any`

Concatenation helper.

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`Concat`](../../com.github.jonathanxd.codeapi.base/-concat/index.md)<br>Builds [Concat](../../com.github.jonathanxd.codeapi.base/-concat/index.md) instance with concatenations. |
| [concat](concat.md) | `fun concat(codePart: `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`): ConcatHelper`<br>Concatenate [codePart](concat.md#com.github.jonathanxd.codeapi.helper.ConcatHelper$concat(com.github.jonathanxd.codeapi.CodeInstruction)/codePart).`fun concat(str: String): ConcatHelper`<br>Concatenate [str](concat.md#com.github.jonathanxd.codeapi.helper.ConcatHelper$concat(kotlin.String)/str). |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): ConcatHelper`<br>Creates a ConcatHelper instance.`fun builder(part: `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`): ConcatHelper`<br>Creates a ConcatHelper instance and concatenate [part](builder.md#com.github.jonathanxd.codeapi.helper.ConcatHelper.Companion$builder(com.github.jonathanxd.codeapi.CodeInstruction)/part).`fun builder(str: String): ConcatHelper`<br>Creates a ConcatHelper instance and concatenate [str](builder.md#com.github.jonathanxd.codeapi.helper.ConcatHelper.Companion$builder(kotlin.String)/str). |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
