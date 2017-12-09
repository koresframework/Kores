[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.inspect](../index.md) / [SourceInspect](index.md) / [inspect](.)

# inspect

`fun inspect(source: `[`CodeSource`](../../com.github.jonathanxd.codeapi/-code-source/index.md)`): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<R>`

Inspect the [source](inspect.md#com.github.jonathanxd.codeapi.inspect.SourceInspect$inspect(com.github.jonathanxd.codeapi.CodeSource)/source) and return the list of elements where matches [predicate](predicate.md) (mapped with [mapper](mapper.md)).

`fun inspect(source: `[`CodeSource`](../../com.github.jonathanxd.codeapi/-code-source/index.md)`, start: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<R>`

Inspect the [source](inspect.md#com.github.jonathanxd.codeapi.inspect.SourceInspect$inspect(com.github.jonathanxd.codeapi.CodeSource, kotlin.Int)/source) starting at index [start](inspect.md#com.github.jonathanxd.codeapi.inspect.SourceInspect$inspect(com.github.jonathanxd.codeapi.CodeSource, kotlin.Int)/start) and return the list of elements where matches [predicate](predicate.md) (mapped with [mapper](mapper.md))..

### Exceptions

`IndexOutOfBoundsException` - If [start](inspect.md#com.github.jonathanxd.codeapi.inspect.SourceInspect$inspect(com.github.jonathanxd.codeapi.CodeSource, kotlin.Int)/start) index exceeds the [source](inspect.md#com.github.jonathanxd.codeapi.inspect.SourceInspect$inspect(com.github.jonathanxd.codeapi.CodeSource, kotlin.Int)/source) size.`fun inspect(source: `[`CodeSource`](../../com.github.jonathanxd.codeapi/-code-source/index.md)`, inspect: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, consumer: (R) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`, start: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Inspect [source](inspect.md#com.github.jonathanxd.codeapi.inspect.SourceInspect$inspect(com.github.jonathanxd.codeapi.CodeSource, kotlin.Boolean, kotlin.Function1((com.github.jonathanxd.codeapi.inspect.SourceInspect.R, kotlin.Unit)), kotlin.Int)/source) starting at index [start](inspect.md#com.github.jonathanxd.codeapi.inspect.SourceInspect$inspect(com.github.jonathanxd.codeapi.CodeSource, kotlin.Boolean, kotlin.Function1((com.github.jonathanxd.codeapi.inspect.SourceInspect.R, kotlin.Unit)), kotlin.Int)/start) and call [consumer](inspect.md#com.github.jonathanxd.codeapi.inspect.SourceInspect$inspect(com.github.jonathanxd.codeapi.CodeSource, kotlin.Boolean, kotlin.Function1((com.github.jonathanxd.codeapi.inspect.SourceInspect.R, kotlin.Unit)), kotlin.Int)/consumer) function with each
element (mapped with [mapper](mapper.md)) where matches [predicate](predicate.md).

**Return**
False if inspection stopped before ending as result of [stopPredicate](stop-predicate.md) returning true for an element.

