[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.inspect](../index.md) / [SourceInspectBuilder](.)

# SourceInspectBuilder

`class SourceInspectBuilder<R> : Any`

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`SourceInspect`](../-source-inspect/index.md)`<R>`<br>Builds a [SourceInspect](../-source-inspect/index.md) with current properties. |
| [find](find.md) | `fun find(codePartPredicate: (`[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`) -> Boolean): SourceInspectBuilder<R>`<br>Sets the matcher of elements to collect. |
| [include](include.md) | `fun include(predicate: (`[`BodyHolder`](../../com.github.jonathanxd.codeapi.base/-body-holder/index.md)`) -> Boolean): SourceInspectBuilder<R>`<br>Sets to include elements inside [BodyHolders](../../com.github.jonathanxd.codeapi.base/-body-holder/index.md) that matches the [predicate](include.md#com.github.jonathanxd.codeapi.inspect.SourceInspectBuilder$include(kotlin.Function1((com.github.jonathanxd.codeapi.base.BodyHolder, kotlin.Boolean)))/predicate) in the inspection. |
| [includeSource](include-source.md) | `fun includeSource(inspectCodeSource: Boolean): SourceInspectBuilder<R>`<br>Sets to include elements inside [CodeSource](../../com.github.jonathanxd.codeapi/-code-source/index.md) passed to [SourceInspect.inspect](../-source-inspect/inspect.md) in the inspection. |
| [inside](inside.md) | `fun inside(predicate: (`[`BodyHolder`](../../com.github.jonathanxd.codeapi.base/-body-holder/index.md)`) -> Boolean): SourceInspectBuilder<R>`<br>Sets to inspect **only** elements inside [BodyHolders](../../com.github.jonathanxd.codeapi.base/-body-holder/index.md) that matches the [predicate](inside.md#com.github.jonathanxd.codeapi.inspect.SourceInspectBuilder$inside(kotlin.Function1((com.github.jonathanxd.codeapi.base.BodyHolder, kotlin.Boolean)))/predicate). |
| [inspect](inspect.md) | `fun inspect(codeSource: `[`CodeSource`](../../com.github.jonathanxd.codeapi/-code-source/index.md)`): List<R>`<br>`fun inspect(codeSource: `[`CodeSource`](../../com.github.jonathanxd.codeapi/-code-source/index.md)`, start: Int): List<R>`<br>Calls [SourceInspect.inspect](../-source-inspect/inspect.md) |
| [mapTo](map-to.md) | `fun <V> mapTo(mapper: (`[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`) -> V): SourceInspectBuilder<V>`<br>Sets the mapper function. Mapper function convert elements before its get consumed by a function. |
| [stopWhen](stop-when.md) | `fun stopWhen(predicate: (`[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`) -> Boolean): SourceInspectBuilder<R>`<br>Sets predicate to test when to stop inspection. If [predicate](stop-when.md#com.github.jonathanxd.codeapi.inspect.SourceInspectBuilder$stopWhen(kotlin.Function1((com.github.jonathanxd.codeapi.CodePart, kotlin.Boolean)))/predicate) returns `true`, the inspection stops,
if return `false`, the inspection continues. |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
