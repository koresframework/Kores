//[Kores](../../../index.md)/[com.github.jonathanxd.kores](../index.md)/[ArrayInstructions](index.md)

# ArrayInstructions

[jvm]\
class [ArrayInstructions](index.md)(**parts**: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<[Instruction](../-instruction/index.md)>) : [Instructions](../-instructions/index.md)

Backed by an [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html) of [Instruction](../-instruction/index.md).

## See also

jvm

| | |
|---|---|
| [com.github.jonathanxd.kores.MutableInstructions](../-mutable-instructions/index.md) |  |

## Constructors

| | |
|---|---|
| [ArrayInstructions](-array-instructions.md) | [jvm]<br>fun [ArrayInstructions](-array-instructions.md)() |
| [ArrayInstructions](-array-instructions.md) | [jvm]<br>fun [ArrayInstructions](-array-instructions.md)(parts: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<[Instruction](../-instruction/index.md)> = emptyArray()) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [builder](../-kores-part/builder.md) | [jvm]<br>open fun [builder](../-kores-part/builder.md)(): [Builder](../../com.github.jonathanxd.kores.builder/-builder/index.md)<[KoresPart](../-kores-part/index.md), *><br>This builder may or may not accept null values, it depends on implementation. |
| [contains](contains.md) | [jvm]<br>open operator override fun [contains](contains.md)(o: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if this [Instructions](../-instructions/index.md) contains [o](contains.md). |
| [containsAll](../-instructions/contains-all.md) | [jvm]<br>open fun [containsAll](../-instructions/contains-all.md)(c: [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)<*>): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if this [Instructions](../-instructions/index.md) contains all elements of [c](../-instructions/contains-all.md). |
| [forEach](for-each.md) | [jvm]<br>open override fun [forEach](for-each.md)(action: [Consumer](https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html)<in [Instruction](../-instruction/index.md)>)<br>For each all elements of this [Instructions](../-instructions/index.md). |
| [get](../-instructions/get.md) | [jvm]<br>operator fun [get](../-instructions/get.md)(index: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Instruction](../-instruction/index.md)<br>Gets element at index [index](../-instructions/get.md). |
| [indexOf](index-of.md) | [jvm]<br>open override fun [indexOf](index-of.md)(o: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Returns the index of [o](index-of.md) in this [Instructions](../-instructions/index.md). |
| [iterator](iterator.md) | [jvm]<br>open operator override fun [iterator](iterator.md)(): [Iterator](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterator/index.html)<[Instruction](../-instruction/index.md)><br>Creates an [Iterator](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterator/index.html) that iterates elements of this [Instructions](../-instructions/index.md). |
| [lastIndexOf](last-index-of.md) | [jvm]<br>open override fun [lastIndexOf](last-index-of.md)(o: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Returns the last index of [o](last-index-of.md) in this [Instructions](../-instructions/index.md). |
| [listIterator](list-iterator.md) | [jvm]<br>open override fun [listIterator](list-iterator.md)(): [ListIterator](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list-iterator/index.html)<[Instruction](../-instruction/index.md)><br>Creates a [ListIterator](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list-iterator/index.html) that iterates this [Instructions](../-instructions/index.md).<br>[jvm]<br>open override fun [listIterator](list-iterator.md)(index: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [ListIterator](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list-iterator/index.html)<[Instruction](../-instruction/index.md)><br>Creates a [ListIterator](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list-iterator/index.html) that iterates this [Instructions](../-instructions/index.md) and starts at [index](list-iterator.md). |
| [minus](minus.md) | [jvm]<br>open operator override fun [minus](minus.md)(other: [Instruction](../-instruction/index.md)): [Instructions](../-instructions/index.md)<br>Removes [other](minus.md) from this [Instructions](../-instructions/index.md).<br>[jvm]<br>open operator override fun [minus](minus.md)(other: [Iterable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)<[Instruction](../-instruction/index.md)>): [Instructions](../-instructions/index.md)<br>Removes all [Instruction](../-instruction/index.md) of [other](minus.md) from this [Instructions](../-instructions/index.md) |
| [parallelStream](parallel-stream.md) | [jvm]<br>open override fun [parallelStream](parallel-stream.md)(): [Stream](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html)<[Instruction](../-instruction/index.md)><br>Creates a parallel [Stream](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html) of this [Instructions](../-instructions/index.md) (which may or may not be parallel). |
| [plus](plus.md) | [jvm]<br>open operator override fun [plus](plus.md)(other: [Instruction](../-instruction/index.md)): [Instructions](../-instructions/index.md)<br>Adds [other](plus.md) to this [Instructions](../-instructions/index.md).<br>[jvm]<br>open operator override fun [plus](plus.md)(other: [Iterable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)<[Instruction](../-instruction/index.md)>): [Instructions](../-instructions/index.md)<br>Adds all [Instruction](../-instruction/index.md) of [other](plus.md) to this [Instructions](../-instructions/index.md) |
| [spliterator](spliterator.md) | [jvm]<br>open override fun [spliterator](spliterator.md)(): [Spliterator](https://docs.oracle.com/javase/8/docs/api/java/util/Spliterator.html)<[Instruction](../-instruction/index.md)><br>Creates a [Spliterator](https://docs.oracle.com/javase/8/docs/api/java/util/Spliterator.html) from elements of this [Instructions](../-instructions/index.md). |
| [stream](stream.md) | [jvm]<br>open override fun [stream](stream.md)(): [Stream](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html)<[Instruction](../-instruction/index.md)><br>Creates a [Stream](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html) of this [Instructions](../-instructions/index.md). |
| [subSource](sub-source.md) | [jvm]<br>open override fun [subSource](sub-source.md)(fromIndex: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), toIndex: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Instructions](../-instructions/index.md)<br>Creates a view of this [Instructions](../-instructions/index.md) from index [fromIndex](sub-source.md) to index [toIndex](sub-source.md), changes to this [Instructions](../-instructions/index.md) is reflected in current [Instructions](../-instructions/index.md). |
| [toArray](to-array.md) | [jvm]<br>open override fun [toArray](to-array.md)(): [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<[Instruction](../-instruction/index.md)><br>Creates an array of [Instruction](../-instruction/index.md) of all elements of this [Instructions](../-instructions/index.md). |
| [toImmutable](../-instructions/to-immutable.md) | [jvm]<br>open fun [toImmutable](../-instructions/to-immutable.md)(): [Instructions](../-instructions/index.md)<br>Creates a immutable [Instructions](../-instructions/index.md) with elements of this [Instructions](../-instructions/index.md). |
| [toMutable](../-instructions/to-mutable.md) | [jvm]<br>open fun [toMutable](../-instructions/to-mutable.md)(): [MutableInstructions](../-mutable-instructions/index.md)<br>Creates a mutable [Instructions](../-instructions/index.md) with elements of this [Instructions](../-instructions/index.md). |
| [toString](to-string.md) | [jvm]<br>open override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Properties

| Name | Summary |
|---|---|
| [isEmpty](index.md#1858414665%2FProperties%2F-1216412040) | [jvm]<br>val [isEmpty](index.md#1858414665%2FProperties%2F-1216412040): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True if is empty, false otherwise. |
| [isNotEmpty](index.md#-1021746454%2FProperties%2F-1216412040) | [jvm]<br>val [isNotEmpty](index.md#-1021746454%2FProperties%2F-1216412040): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True if is not empty, false otherwise. |
| [size](size.md) | [jvm]<br>open override val [size](size.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Size of source. |
