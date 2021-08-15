//[Kores](../../../index.md)/[com.github.jonathanxd.kores](../index.md)/[Instructions](index.md)

# Instructions

[jvm]\
abstract class [Instructions](index.md) : [Iterable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)<[Instruction](../-instruction/index.md)> , [KoresPart](../-kores-part/index.md)

Abstract [Instruction](../-instruction/index.md) iterable.

## See also

jvm

| | |
|---|---|
| [com.github.jonathanxd.kores.ArrayInstructions](../-array-instructions/index.md) |  |
| [com.github.jonathanxd.kores.MutableInstructions](../-mutable-instructions/index.md) |  |

## Constructors

| | |
|---|---|
| [Instructions](-instructions.md) | [jvm]<br>fun [Instructions](-instructions.md)() |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md)<br>Factory methods to create immutable [Instructions](index.md). |

## Functions

| Name | Summary |
|---|---|
| [builder](../-kores-part/builder.md) | [jvm]<br>open fun [builder](../-kores-part/builder.md)(): [Builder](../../com.github.jonathanxd.kores.builder/-builder/index.md)<[KoresPart](../-kores-part/index.md), *><br>This builder may or may not accept null values, it depends on implementation. |
| [contains](contains.md) | [jvm]<br>abstract operator fun [contains](contains.md)(o: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if this [Instructions](index.md) contains [o](contains.md). |
| [containsAll](contains-all.md) | [jvm]<br>open fun [containsAll](contains-all.md)(c: [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)<*>): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if this [Instructions](index.md) contains all elements of [c](contains-all.md). |
| [forEach](for-each.md) | [jvm]<br>abstract override fun [forEach](for-each.md)(action: [Consumer](https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html)<in [Instruction](../-instruction/index.md)>)<br>For each all elements of this [Instructions](index.md). |
| [get](get.md) | [jvm]<br>operator fun [get](get.md)(index: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Instruction](../-instruction/index.md)<br>Gets element at index [index](get.md). |
| [indexOf](index-of.md) | [jvm]<br>abstract fun [indexOf](index-of.md)(o: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Returns the index of [o](index-of.md) in this [Instructions](index.md). |
| [iterator](iterator.md) | [jvm]<br>abstract operator override fun [iterator](iterator.md)(): [Iterator](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterator/index.html)<[Instruction](../-instruction/index.md)><br>Creates an [Iterator](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterator/index.html) that iterates elements of this [Instructions](index.md). |
| [lastIndexOf](last-index-of.md) | [jvm]<br>abstract fun [lastIndexOf](last-index-of.md)(o: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Returns the last index of [o](last-index-of.md) in this [Instructions](index.md). |
| [listIterator](list-iterator.md) | [jvm]<br>abstract fun [listIterator](list-iterator.md)(): [ListIterator](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list-iterator/index.html)<[Instruction](../-instruction/index.md)><br>Creates a [ListIterator](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list-iterator/index.html) that iterates this [Instructions](index.md).<br>[jvm]<br>abstract fun [listIterator](list-iterator.md)(index: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [ListIterator](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list-iterator/index.html)<[Instruction](../-instruction/index.md)><br>Creates a [ListIterator](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list-iterator/index.html) that iterates this [Instructions](index.md) and starts at [index](list-iterator.md). |
| [minus](minus.md) | [jvm]<br>abstract operator fun [minus](minus.md)(other: [Instruction](../-instruction/index.md)): [Instructions](index.md)<br>Removes [other](minus.md) from this [Instructions](index.md).<br>[jvm]<br>abstract operator fun [minus](minus.md)(other: [Iterable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)<[Instruction](../-instruction/index.md)>): [Instructions](index.md)<br>Removes all [Instruction](../-instruction/index.md) of [other](minus.md) from this [Instructions](index.md) |
| [parallelStream](parallel-stream.md) | [jvm]<br>abstract fun [parallelStream](parallel-stream.md)(): [Stream](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html)<[Instruction](../-instruction/index.md)><br>Creates a parallel [Stream](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html) of this [Instructions](index.md) (which may or may not be parallel). |
| [plus](plus.md) | [jvm]<br>abstract operator fun [plus](plus.md)(other: [Instruction](../-instruction/index.md)): [Instructions](index.md)<br>Adds [other](plus.md) to this [Instructions](index.md).<br>[jvm]<br>abstract operator fun [plus](plus.md)(other: [Iterable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)<[Instruction](../-instruction/index.md)>): [Instructions](index.md)<br>Adds all [Instruction](../-instruction/index.md) of [other](plus.md) to this [Instructions](index.md) |
| [spliterator](spliterator.md) | [jvm]<br>abstract override fun [spliterator](spliterator.md)(): [Spliterator](https://docs.oracle.com/javase/8/docs/api/java/util/Spliterator.html)<[Instruction](../-instruction/index.md)><br>Creates a [Spliterator](https://docs.oracle.com/javase/8/docs/api/java/util/Spliterator.html) from elements of this [Instructions](index.md). |
| [stream](stream.md) | [jvm]<br>abstract fun [stream](stream.md)(): [Stream](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html)<[Instruction](../-instruction/index.md)><br>Creates a [Stream](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html) of this [Instructions](index.md). |
| [subSource](sub-source.md) | [jvm]<br>abstract fun [subSource](sub-source.md)(fromIndex: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), toIndex: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Instructions](index.md)<br>Creates a view of this [Instructions](index.md) from index [fromIndex](sub-source.md) to index [toIndex](sub-source.md), changes to this [Instructions](index.md) is reflected in current [Instructions](index.md). |
| [toArray](to-array.md) | [jvm]<br>abstract fun [toArray](to-array.md)(): [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<[Instruction](../-instruction/index.md)><br>Creates an array of [Instruction](../-instruction/index.md) of all elements of this [Instructions](index.md). |
| [toImmutable](to-immutable.md) | [jvm]<br>open fun [toImmutable](to-immutable.md)(): [Instructions](index.md)<br>Creates a immutable [Instructions](index.md) with elements of this [Instructions](index.md). |
| [toMutable](to-mutable.md) | [jvm]<br>open fun [toMutable](to-mutable.md)(): [MutableInstructions](../-mutable-instructions/index.md)<br>Creates a mutable [Instructions](index.md) with elements of this [Instructions](index.md). |
| [toString](to-string.md) | [jvm]<br>open override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Properties

| Name | Summary |
|---|---|
| [isEmpty](is-empty.md) | [jvm]<br>val [isEmpty](is-empty.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True if is empty, false otherwise. |
| [isNotEmpty](is-not-empty.md) | [jvm]<br>val [isNotEmpty](is-not-empty.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True if is not empty, false otherwise. |
| [size](size.md) | [jvm]<br>abstract val [size](size.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Size of source. |

## Inheritors

| Name |
|---|
| [ArrayInstructions](../-array-instructions/index.md) |
| [MutableInstructions](../-mutable-instructions/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [find](../find.md) | [jvm]<br>fun <[U](../find.md)> [Instructions](index.md).[find](../find.md)(predicate: ([Instruction](../-instruction/index.md)) -> [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), function: ([Instruction](../-instruction/index.md)) -> [U](../find.md)): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[U](../find.md)><br>Find an element in a code source. |
| [getLeaveType](../get-leave-type.md) | [jvm]<br>fun [Instructions](index.md).[getLeaveType](../get-leave-type.md)(): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)?<br>Returns the type that this [Instructions](index.md) leaves on stack. |
| [insertAfter](../insert-after.md) | [jvm]<br>fun [Instructions](index.md).[insertAfter](../insert-after.md)(predicate: ([Instruction](../-instruction/index.md)) -> [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), toInsert: [Instructions](index.md)): [MutableInstructions](../-mutable-instructions/index.md)<br>Insert element toInsert in source after element determined by predicate |
| [insertAfterOrEnd](../insert-after-or-end.md) | [jvm]<br>fun [Instructions](index.md).[insertAfterOrEnd](../insert-after-or-end.md)(predicate: ([Instruction](../-instruction/index.md)) -> [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), toInsert: [Instructions](index.md)): [MutableInstructions](../-mutable-instructions/index.md)<br>Insert element toInsert in source after element determined by predicate or at end of source if not found. |
| [insertAfterOrStart](../insert-after-or-start.md) | [jvm]<br>fun [Instructions](index.md).[insertAfterOrStart](../insert-after-or-start.md)(predicate: ([Instruction](../-instruction/index.md)) -> [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), toInsert: [Instructions](index.md)): [MutableInstructions](../-mutable-instructions/index.md)<br>Insert element toInsert in source after element determined by predicate or at start of source if not found. |
| [insertBefore](../insert-before.md) | [jvm]<br>fun [Instructions](index.md).[insertBefore](../insert-before.md)(predicate: ([Instruction](../-instruction/index.md)) -> [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), toInsert: [Instructions](index.md)): [MutableInstructions](../-mutable-instructions/index.md)<br>Insert element toInsert in source before element determined by predicate |
| [insertBeforeOrEnd](../insert-before-or-end.md) | [jvm]<br>fun [Instructions](index.md).[insertBeforeOrEnd](../insert-before-or-end.md)(predicate: ([Instruction](../-instruction/index.md)) -> [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), toInsert: [Instructions](index.md)): [MutableInstructions](../-mutable-instructions/index.md)<br>Insert element toInsert in source before element determined by predicate or at end of source if not found. |
| [insertBeforeOrStart](../insert-before-or-start.md) | [jvm]<br>fun [Instructions](index.md).[insertBeforeOrStart](../insert-before-or-start.md)(predicate: ([Instruction](../-instruction/index.md)) -> [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), toInsert: [Instructions](index.md)): [MutableInstructions](../-mutable-instructions/index.md)<br>Insert element toInsert in source before element determined by predicate or at start of source if not found. |
| [visit](../visit.md) | [jvm]<br>fun [Instructions](index.md).[visit](../visit.md)(consumer: ([Instruction](../-instruction/index.md), [Location](../-location/index.md), [MutableInstructions](../-mutable-instructions/index.md)) -> [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [MutableInstructions](../-mutable-instructions/index.md)<br>Visit Code Source elements. |
