//[Kores](../../../index.md)/[com.koresframework.kores.inspect](../index.md)/[InstructionsInspect](index.md)/[inspect](inspect.md)

# inspect

[jvm]\
fun [inspect](inspect.md)(source: [Instructions](../../com.koresframework.kores/-instructions/index.md)): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[R](index.md)>

Inspect the [source](inspect.md) and return the list of elements where matches [predicate](predicate.md) (mapped with [mapper](mapper.md)).

[jvm]\
fun [inspect](inspect.md)(source: [Instructions](../../com.koresframework.kores/-instructions/index.md), start: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[R](index.md)>

Inspect the [source](inspect.md) starting at index [start](inspect.md) and return the list of elements where matches [predicate](predicate.md) (mapped with [mapper](mapper.md))..

#### Throws

| | |
|---|---|
| [kotlin.IndexOutOfBoundsException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-index-out-of-bounds-exception/index.html) | If [start](inspect.md) index exceeds the [source](inspect.md) size. |

[jvm]\
fun [inspect](inspect.md)(source: [Instructions](../../com.koresframework.kores/-instructions/index.md), inspect: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), consumer: ([R](index.md)) -> [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), start: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Inspect [source](inspect.md) starting at index [start](inspect.md) and call [consumer](inspect.md) function with each element (mapped with [mapper](mapper.md)) where matches [predicate](predicate.md).

#### Return

False if inspection stopped before ending as result of [stopPredicate](stop-predicate.md) returning true for an element.
