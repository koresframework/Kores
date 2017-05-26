[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi](../index.md) / [ArrayCodeSource](.)

# ArrayCodeSource

`class ArrayCodeSource : `[`CodeSource`](../-code-source/index.md)

CodeSource is an iterable of [CodeInstructions](../-code-instruction.md).

This class is backed by an [Array](#) of [CodeInstruction](../-code-instruction.md).

**See Also**

[MutableCodeSource](../-mutable-code-source/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ArrayCodeSource()``ArrayCodeSource(parts: Array<`[`CodeInstruction`](../-code-instruction.md)`> = emptyArray())`<br>CodeSource is an iterable of [CodeInstructions](../-code-instruction.md). |

### Properties

| Name | Summary |
|---|---|
| [parts](parts.md) | `val parts: Array<`[`CodeInstruction`](../-code-instruction.md)`>` |
| [size](size.md) | `val size: Int`<br>Size of source. |

### Inherited Properties

| Name | Summary |
|---|---|
| [isEmpty](../-code-source/is-empty.md) | `val isEmpty: Boolean`<br>True if is empty, false otherwise. |
| [isNotEmpty](../-code-source/is-not-empty.md) | `val isNotEmpty: Boolean`<br>True if is not empty, false otherwise. |

### Functions

| Name | Summary |
|---|---|
| [ArrayCodeSource](-array-code-source.md) | `fun ArrayCodeSource(size: Int, init: (Int) -> `[`CodeInstruction`](../-code-instruction.md)`): `[`CodeSource`](../-code-source/index.md) |
| [contains](contains.md) | `operator fun contains(o: Any): Boolean`<br>Returns true if this [CodeSource](../-code-source/index.md) contains [o](contains.md#com.github.jonathanxd.codeapi.ArrayCodeSource$contains(kotlin.Any)/o). |
| [forEach](for-each.md) | `fun forEach(action: `[`Consumer`](http://docs.oracle.com/javase/6/docs/api/java/util/function/Consumer.html)`<in `[`CodeInstruction`](../-code-instruction.md)`>): Unit`<br>For each all elements of this [CodeSource](../-code-source/index.md). |
| [getAtIndex](get-at-index.md) | `fun getAtIndex(index: Int): `[`CodeInstruction`](../-code-instruction.md)<br>Gets element at index [index](get-at-index.md#com.github.jonathanxd.codeapi.ArrayCodeSource$getAtIndex(kotlin.Int)/index). This method should only be called if the index
is in the bounds. |
| [indexOf](index-of.md) | `fun indexOf(o: Any): Int`<br>Returns the index of [o](index-of.md#com.github.jonathanxd.codeapi.ArrayCodeSource$indexOf(kotlin.Any)/o) in this [CodeSource](../-code-source/index.md). |
| [iterator](iterator.md) | `fun iterator(): Iterator<`[`CodeInstruction`](../-code-instruction.md)`>`<br>Creates an [Iterator](#) that iterates elements of this [CodeSource](../-code-source/index.md). |
| [lastIndexOf](last-index-of.md) | `fun lastIndexOf(o: Any): Int`<br>Returns the last index of [o](last-index-of.md#com.github.jonathanxd.codeapi.ArrayCodeSource$lastIndexOf(kotlin.Any)/o) in this [CodeSource](../-code-source/index.md). |
| [listIterator](list-iterator.md) | `fun listIterator(): ListIterator<`[`CodeInstruction`](../-code-instruction.md)`>`<br>Creates a [ListIterator](#) that iterates this [CodeSource](../-code-source/index.md).`fun listIterator(index: Int): ListIterator<`[`CodeInstruction`](../-code-instruction.md)`>`<br>Creates a [ListIterator](#) that iterates this [CodeSource](../-code-source/index.md) and starts at [index](list-iterator.md#com.github.jonathanxd.codeapi.ArrayCodeSource$listIterator(kotlin.Int)/index). |
| [minus](minus.md) | `operator fun minus(other: `[`CodeInstruction`](../-code-instruction.md)`): `[`CodeSource`](../-code-source/index.md)<br>Removes [other](minus.md#com.github.jonathanxd.codeapi.ArrayCodeSource$minus(com.github.jonathanxd.codeapi.CodeInstruction)/other) from this [CodeSource](../-code-source/index.md).`operator fun minus(other: Iterable<`[`CodeInstruction`](../-code-instruction.md)`>): `[`CodeSource`](../-code-source/index.md)<br>Removes all [CodeInstruction](../-code-instruction.md) of [other](minus.md#com.github.jonathanxd.codeapi.ArrayCodeSource$minus(kotlin.collections.Iterable((com.github.jonathanxd.codeapi.CodeInstruction)))/other) from this [CodeSource](../-code-source/index.md) |
| [parallelStream](parallel-stream.md) | `fun parallelStream(): `[`Stream`](http://docs.oracle.com/javase/6/docs/api/java/util/stream/Stream.html)`<`[`CodeInstruction`](../-code-instruction.md)`>`<br>Creates a parallel [Stream](http://docs.oracle.com/javase/6/docs/api/java/util/stream/Stream.html) of this [CodeSource](../-code-source/index.md) (which may or may not be parallel). |
| [plus](plus.md) | `operator fun plus(other: `[`CodeInstruction`](../-code-instruction.md)`): `[`CodeSource`](../-code-source/index.md)<br>Adds [other](plus.md#com.github.jonathanxd.codeapi.ArrayCodeSource$plus(com.github.jonathanxd.codeapi.CodeInstruction)/other) to this [CodeSource](../-code-source/index.md).`operator fun plus(other: Iterable<`[`CodeInstruction`](../-code-instruction.md)`>): `[`CodeSource`](../-code-source/index.md)<br>Adds all [CodeInstruction](../-code-instruction.md) of [other](plus.md#com.github.jonathanxd.codeapi.ArrayCodeSource$plus(kotlin.collections.Iterable((com.github.jonathanxd.codeapi.CodeInstruction)))/other) to this [CodeSource](../-code-source/index.md) |
| [spliterator](spliterator.md) | `fun spliterator(): `[`Spliterator`](http://docs.oracle.com/javase/6/docs/api/java/util/Spliterator.html)`<`[`CodeInstruction`](../-code-instruction.md)`>`<br>Creates a [Spliterator](http://docs.oracle.com/javase/6/docs/api/java/util/Spliterator.html) from elements of this [CodeSource](../-code-source/index.md). |
| [stream](stream.md) | `fun stream(): `[`Stream`](http://docs.oracle.com/javase/6/docs/api/java/util/stream/Stream.html)`<`[`CodeInstruction`](../-code-instruction.md)`>`<br>Creates a [Stream](http://docs.oracle.com/javase/6/docs/api/java/util/stream/Stream.html) of this [CodeSource](../-code-source/index.md). |
| [subSource](sub-source.md) | `fun subSource(fromIndex: Int, toIndex: Int): `[`CodeSource`](../-code-source/index.md)<br>Creates a view of this [CodeSource](../-code-source/index.md) from index [fromIndex](sub-source.md#com.github.jonathanxd.codeapi.ArrayCodeSource$subSource(kotlin.Int, kotlin.Int)/fromIndex) to index [toIndex](sub-source.md#com.github.jonathanxd.codeapi.ArrayCodeSource$subSource(kotlin.Int, kotlin.Int)/toIndex),
changes to this [CodeSource](../-code-source/index.md) is reflected in current [CodeSource](../-code-source/index.md). |
| [toArray](to-array.md) | `fun toArray(): Array<`[`CodeInstruction`](../-code-instruction.md)`>`<br>Creates an array of [CodeInstruction](../-code-instruction.md) of all elements of this [CodeSource](../-code-source/index.md). |
| [toString](to-string.md) | `fun toString(): String` |

### Inherited Functions

| Name | Summary |
|---|---|
| [containsAll](../-code-source/contains-all.md) | `open fun containsAll(c: Collection<*>): Boolean`<br>Returns true if this [CodeSource](../-code-source/index.md) contains all elements of [c](../-code-source/contains-all.md#com.github.jonathanxd.codeapi.CodeSource$containsAll(kotlin.collections.Collection((kotlin.Any)))/c). |
| [get](../-code-source/get.md) | `operator fun get(index: Int): `[`CodeInstruction`](../-code-instruction.md)<br>Gets element at index [index](../-code-source/get.md#com.github.jonathanxd.codeapi.CodeSource$get(kotlin.Int)/index). |
| [toImmutable](../-code-source/to-immutable.md) | `open fun toImmutable(): `[`CodeSource`](../-code-source/index.md)<br>Creates a immutable [CodeSource](../-code-source/index.md) with elements of this [CodeSource](../-code-source/index.md). |
| [toMutable](../-code-source/to-mutable.md) | `open fun toMutable(): `[`MutableCodeSource`](../-mutable-code-source/index.md)<br>Creates a mutable [CodeSource](../-code-source/index.md) with elements of this [CodeSource](../-code-source/index.md). |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../-code-part/index.md) |
| [getPartType](../../com.github.jonathanxd.codeapi.util/get-part-type.md) | `fun `[`CodePart`](../-code-part/index.md)`.getPartType(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../-code-part/index.md) or throws [IllegalStateException](http://docs.oracle.com/javase/6/docs/api/java/lang/IllegalStateException.html) if [CodePart](../-code-part/index.md) is not instance of [Typed](../../com.github.jonathanxd.codeapi.base/-typed/index.md) |
| [getPartTypeOrNull](../../com.github.jonathanxd.codeapi.util/get-part-type-or-null.md) | `fun `[`CodePart`](../-code-part/index.md)`.getPartTypeOrNull(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../-code-part/index.md) or `null` if [CodePart](../-code-part/index.md) is not instance of [Typed](../../com.github.jonathanxd.codeapi.base/-typed/index.md). |
| [isEqual](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.collections.-iterable/is-equal.md) | `fun <T : Any> Iterable<T>.isEqual(other: Iterable<*>): Boolean`<br>Checks if all elements of receiver [Iterable](#) is equal to elements of [other](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.collections.-iterable/is-equal.md#com.github.jonathanxd.codeapi.util.conversion$isEqual(kotlin.collections.Iterable((com.github.jonathanxd.codeapi.util.conversion.isEqual.T)), kotlin.collections.Iterable((kotlin.Any)))/other). |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
