[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.inspect](../index.md) / [SourceInspect](.)

# SourceInspect

`class SourceInspect<out R> : Any`

Utility to inspect [CodeSource](../../com.github.jonathanxd.codeapi/-code-source/index.md).

### Parameters

`R` - Mapper type.

### Properties

| Name | Summary |
|---|---|
| [inspectCodeSource](inspect-code-source.md) | `val inspectCodeSource: Boolean`<br>True to inspect [CodeSource](../../com.github.jonathanxd.codeapi/-code-source/index.md) and not only sub elements. |
| [mapper](mapper.md) | `val mapper: (`[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`) -> R`<br>Function to map processed values to another type. |
| [predicate](predicate.md) | `val predicate: (`[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`) -> Boolean`<br>Predicate check if elements match requirements. |
| [stopPredicate](stop-predicate.md) | `val stopPredicate: (`[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`) -> Boolean`<br>Predicate to determine when the inspection should stop (`true` to stop, `false` to continue). |
| [subPredicate](sub-predicate.md) | `val subPredicate: (`[`BodyHolder`](../../com.github.jonathanxd.codeapi.base/-body-holder/index.md)`) -> Boolean`<br>Predicate to check whether a [BodyHolder](../../com.github.jonathanxd.codeapi.base/-body-holder/index.md) should be inspected. |

### Functions

| Name | Summary |
|---|---|
| [inspect](inspect.md) | `fun inspect(source: `[`CodeSource`](../../com.github.jonathanxd.codeapi/-code-source/index.md)`): List<R>`<br>Inspect the [source](inspect.md#com.github.jonathanxd.codeapi.inspect.SourceInspect$inspect(com.github.jonathanxd.codeapi.CodeSource)/source) and return the list of elements where matches [predicate](predicate.md) (mapped with [mapper](mapper.md)).`fun inspect(source: `[`CodeSource`](../../com.github.jonathanxd.codeapi/-code-source/index.md)`, start: Int): List<R>`<br>Inspect the [source](inspect.md#com.github.jonathanxd.codeapi.inspect.SourceInspect$inspect(com.github.jonathanxd.codeapi.CodeSource, kotlin.Int)/source) starting at index [start](inspect.md#com.github.jonathanxd.codeapi.inspect.SourceInspect$inspect(com.github.jonathanxd.codeapi.CodeSource, kotlin.Int)/start) and return the list of elements where matches [predicate](predicate.md) (mapped with [mapper](mapper.md))..`fun inspect(source: `[`CodeSource`](../../com.github.jonathanxd.codeapi/-code-source/index.md)`, inspect: Boolean, consumer: (R) -> Unit, start: Int): Boolean`<br>Inspect [source](inspect.md#com.github.jonathanxd.codeapi.inspect.SourceInspect$inspect(com.github.jonathanxd.codeapi.CodeSource, kotlin.Boolean, kotlin.Function1((com.github.jonathanxd.codeapi.inspect.SourceInspect.R, kotlin.Unit)), kotlin.Int)/source) starting at index [start](inspect.md#com.github.jonathanxd.codeapi.inspect.SourceInspect$inspect(com.github.jonathanxd.codeapi.CodeSource, kotlin.Boolean, kotlin.Function1((com.github.jonathanxd.codeapi.inspect.SourceInspect.R, kotlin.Unit)), kotlin.Int)/start) and call [consumer](inspect.md#com.github.jonathanxd.codeapi.inspect.SourceInspect$inspect(com.github.jonathanxd.codeapi.CodeSource, kotlin.Boolean, kotlin.Function1((com.github.jonathanxd.codeapi.inspect.SourceInspect.R, kotlin.Unit)), kotlin.Int)/consumer) function with each
element (mapped with [mapper](mapper.md)) where matches [predicate](predicate.md). |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(codePartPredicate: (`[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`) -> Boolean): `[`SourceInspectBuilder`](../-source-inspect-builder/index.md)`<`[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`>`<br>Creates a [SourceInspectBuilder](../-source-inspect-builder/index.md) with [codePartPredicate](builder.md#com.github.jonathanxd.codeapi.inspect.SourceInspect.Companion$builder(kotlin.Function1((com.github.jonathanxd.codeapi.CodePart, kotlin.Boolean)))/codePartPredicate) as matcher of elements
to collect. |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
