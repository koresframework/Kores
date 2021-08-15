//[Kores](../../../index.md)/[com.koresframework.kores.inspect](../index.md)/[InstructionsInspect](index.md)

# InstructionsInspect

[jvm]\
class [InstructionsInspect](index.md)<out [R](index.md)>

Utility to inspect [Instructions](../../com.koresframework.kores/-instructions/index.md).

## Parameters

jvm

| | |
|---|---|
| R | Mapper type. |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [inspect](inspect.md) | [jvm]<br>fun [inspect](inspect.md)(source: [Instructions](../../com.koresframework.kores/-instructions/index.md)): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[R](index.md)><br>Inspect the [source](inspect.md) and return the list of elements where matches [predicate](predicate.md) (mapped with [mapper](mapper.md)).<br>[jvm]<br>fun [inspect](inspect.md)(source: [Instructions](../../com.koresframework.kores/-instructions/index.md), start: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[R](index.md)><br>Inspect the [source](inspect.md) starting at index [start](inspect.md) and return the list of elements where matches [predicate](predicate.md) (mapped with [mapper](mapper.md))..<br>[jvm]<br>fun [inspect](inspect.md)(source: [Instructions](../../com.koresframework.kores/-instructions/index.md), inspect: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), consumer: ([R](index.md)) -> [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), start: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Inspect [source](inspect.md) starting at index [start](inspect.md) and call [consumer](inspect.md) function with each element (mapped with [mapper](mapper.md)) where matches [predicate](predicate.md). |

## Properties

| Name | Summary |
|---|---|
| [inspectRootInstructions](inspect-root-instructions.md) | [jvm]<br>val [inspectRootInstructions](inspect-root-instructions.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True to inspect [Instructions](../../com.koresframework.kores/-instructions/index.md) and not only sub elements. |
| [mapper](mapper.md) | [jvm]<br>val [mapper](mapper.md): ([KoresPart](../../com.koresframework.kores/-kores-part/index.md)) -> [R](index.md)<br>Function to map processed values to another type. |
| [predicate](predicate.md) | [jvm]<br>val [predicate](predicate.md): ([KoresPart](../../com.koresframework.kores/-kores-part/index.md)) -> [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Predicate check if elements match requirements. |
| [stopPredicate](stop-predicate.md) | [jvm]<br>val [stopPredicate](stop-predicate.md): ([KoresPart](../../com.koresframework.kores/-kores-part/index.md)) -> [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Predicate to determine when the inspection should stop (true to stop, false to continue). |
| [subPredicate](sub-predicate.md) | [jvm]<br>val [subPredicate](sub-predicate.md): ([BodyHolder](../../com.koresframework.kores.base/-body-holder/index.md)) -> [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)?<br>Predicate to check whether a [BodyHolder](../../com.koresframework.kores.base/-body-holder/index.md) should be inspected. |
