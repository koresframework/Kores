[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.inspect](../index.md) / [SourceInspect](.)

# SourceInspect

`class SourceInspect<out R>`

Utility to inspect [CodeSource](../../com.github.jonathanxd.codeapi/-code-source/index.md).

### Parameters

`R` - Mapper type.

### Properties

| Name | Summary |
|---|---|
| [inspectCodeSource](inspect-code-source.md) | `val inspectCodeSource: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True to inspect [CodeSource](../../com.github.jonathanxd.codeapi/-code-source/index.md) and not only sub elements. |
| [mapper](mapper.md) | `val mapper: (`[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`) -> R`<br>Function to map processed values to another type. |
| [predicate](predicate.md) | `val predicate: (`[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Predicate check if elements match requirements. |
| [stopPredicate](stop-predicate.md) | `val stopPredicate: (`[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Predicate to determine when the inspection should stop (`true` to stop, `false` to continue). |
| [subPredicate](sub-predicate.md) | `val subPredicate: (`[`BodyHolder`](../../com.github.jonathanxd.codeapi.base/-body-holder/index.md)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Predicate to check whether a [BodyHolder](../../com.github.jonathanxd.codeapi.base/-body-holder/index.md) should be inspected. |

### Functions

| Name | Summary |
|---|---|
| [inspect](inspect.md) | `fun inspect(source: `[`CodeSource`](../../com.github.jonathanxd.codeapi/-code-source/index.md)`): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<R>`<br>Inspect the [source](inspect.md#com.github.jonathanxd.codeapi.inspect.SourceInspect$inspect(com.github.jonathanxd.codeapi.CodeSource)/source) and return the list of elements where matches [predicate](predicate.md) (mapped with [mapper](mapper.md)).`fun inspect(source: `[`CodeSource`](../../com.github.jonathanxd.codeapi/-code-source/index.md)`, start: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<R>`<br>Inspect the [source](inspect.md#com.github.jonathanxd.codeapi.inspect.SourceInspect$inspect(com.github.jonathanxd.codeapi.CodeSource, kotlin.Int)/source) starting at index [start](inspect.md#com.github.jonathanxd.codeapi.inspect.SourceInspect$inspect(com.github.jonathanxd.codeapi.CodeSource, kotlin.Int)/start) and return the list of elements where matches [predicate](predicate.md) (mapped with [mapper](mapper.md))..`fun inspect(source: `[`CodeSource`](../../com.github.jonathanxd.codeapi/-code-source/index.md)`, inspect: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, consumer: (R) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`, start: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Inspect [source](inspect.md#com.github.jonathanxd.codeapi.inspect.SourceInspect$inspect(com.github.jonathanxd.codeapi.CodeSource, kotlin.Boolean, kotlin.Function1((com.github.jonathanxd.codeapi.inspect.SourceInspect.R, kotlin.Unit)), kotlin.Int)/source) starting at index [start](inspect.md#com.github.jonathanxd.codeapi.inspect.SourceInspect$inspect(com.github.jonathanxd.codeapi.CodeSource, kotlin.Boolean, kotlin.Function1((com.github.jonathanxd.codeapi.inspect.SourceInspect.R, kotlin.Unit)), kotlin.Int)/start) and call [consumer](inspect.md#com.github.jonathanxd.codeapi.inspect.SourceInspect$inspect(com.github.jonathanxd.codeapi.CodeSource, kotlin.Boolean, kotlin.Function1((com.github.jonathanxd.codeapi.inspect.SourceInspect.R, kotlin.Unit)), kotlin.Int)/consumer) function with each element (mapped with [mapper](mapper.md)) where matches [predicate](predicate.md). |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(codePartPredicate: (`[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`SourceInspectBuilder`](../-source-inspect-builder/index.md)`<`[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`>`<br>Creates a [SourceInspectBuilder](../-source-inspect-builder/index.md) with [codePartPredicate](builder.md#com.github.jonathanxd.codeapi.inspect.SourceInspect.Companion$builder(kotlin.Function1((com.github.jonathanxd.codeapi.CodePart, kotlin.Boolean)))/codePartPredicate) as matcher of elements to collect. |

### Extension Functions

| Name | Summary |
|---|---|
| [annotationValue](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/annotation-value.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.annotationValue(rType: Class<*>): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) |
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?.asString(simple: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)<br>Convert this value to a literal |
| [toLiteralOrNull](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal-or-null.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteralOrNull(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
