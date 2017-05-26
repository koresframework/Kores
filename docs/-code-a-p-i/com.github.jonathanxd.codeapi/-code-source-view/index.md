[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi](../index.md) / [CodeSourceView](.)

# CodeSourceView

`open class CodeSourceView : `[`MutableCodeSource`](../-mutable-code-source/index.md)

### Types

| Name | Summary |
|---|---|
| [SubIterator](-sub-iterator/index.md) | `inner class SubIterator : MutableListIterator<`[`CodeInstruction`](../-code-instruction.md)`>` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CodeSourceView(original: `[`CodeSource`](../-code-source/index.md)`, start: Int, end: Int)` |

### Properties

| Name | Summary |
|---|---|
| [end](end.md) | `var end: Int` |
| [original](original.md) | `val original: `[`CodeSource`](../-code-source/index.md) |
| [size](size.md) | `open val size: Int`<br>Size of source. |
| [start](start.md) | `val start: Int` |

### Functions

| Name | Summary |
|---|---|
| [add](add.md) | `open fun add(instruction: `[`CodeInstruction`](../-code-instruction.md)`): Boolean`<br>Adds [instruction](add.md#com.github.jonathanxd.codeapi.CodeSourceView$add(com.github.jonathanxd.codeapi.CodeInstruction)/instruction) to list.`open fun add(index: Int, element: `[`CodeInstruction`](../-code-instruction.md)`): Unit`<br>Adds [element](add.md#com.github.jonathanxd.codeapi.CodeSourceView$add(kotlin.Int, com.github.jonathanxd.codeapi.CodeInstruction)/element) at [index](add.md#com.github.jonathanxd.codeapi.CodeSourceView$add(kotlin.Int, com.github.jonathanxd.codeapi.CodeInstruction)/index). |
| [addAll](add-all.md) | `open fun addAll(c: Collection<`[`CodeInstruction`](../-code-instruction.md)`>): Boolean`<br>Adds all [CodeInstruction](../-code-instruction.md) of [c](add-all.md#com.github.jonathanxd.codeapi.CodeSourceView$addAll(kotlin.collections.Collection((com.github.jonathanxd.codeapi.CodeInstruction)))/c) into this list.`open fun addAll(index: Int, c: Collection<`[`CodeInstruction`](../-code-instruction.md)`>): Boolean`<br>`open fun addAll(index: Int, c: Iterable<`[`CodeInstruction`](../-code-instruction.md)`>): Boolean`<br>Adds all [CodeInstruction](../-code-instruction.md) of [c](add-all.md#com.github.jonathanxd.codeapi.CodeSourceView$addAll(kotlin.Int, kotlin.collections.Collection((com.github.jonathanxd.codeapi.CodeInstruction)))/c) into this list at [index](add-all.md#com.github.jonathanxd.codeapi.CodeSourceView$addAll(kotlin.Int, kotlin.collections.Collection((com.github.jonathanxd.codeapi.CodeInstruction)))/index). |
| [clear](clear.md) | `open fun clear(): Unit`<br>Clears this list. |
| [contains](contains.md) | `open fun contains(o: Any): Boolean`<br>Returns true if this [CodeSource](../-code-source/index.md) contains [o](contains.md#com.github.jonathanxd.codeapi.CodeSourceView$contains(kotlin.Any)/o). |
| [containsAll](contains-all.md) | `open fun containsAll(c: Collection<*>): Boolean`<br>Returns true if this [CodeSource](../-code-source/index.md) contains all elements of [c](contains-all.md#com.github.jonathanxd.codeapi.CodeSourceView$containsAll(kotlin.collections.Collection((kotlin.Any)))/c). |
| [forEach](for-each.md) | `open fun forEach(action: `[`Consumer`](http://docs.oracle.com/javase/6/docs/api/java/util/function/Consumer.html)`<in `[`CodeInstruction`](../-code-instruction.md)`>): Unit`<br>For each all elements of this [CodeSource](../-code-source/index.md). |
| [getAtIndex](get-at-index.md) | `open fun getAtIndex(index: Int): `[`CodeInstruction`](../-code-instruction.md)<br>Gets element at index [index](get-at-index.md#com.github.jonathanxd.codeapi.CodeSourceView$getAtIndex(kotlin.Int)/index). This method should only be called if the index
is in the bounds. |
| [indexOf](index-of.md) | `open fun indexOf(o: Any): Int`<br>Returns the index of [o](index-of.md#com.github.jonathanxd.codeapi.CodeSourceView$indexOf(kotlin.Any)/o) in this [CodeSource](../-code-source/index.md). |
| [iterator](iterator.md) | `open fun iterator(): Iterator<`[`CodeInstruction`](../-code-instruction.md)`>`<br>Creates an [Iterator](#) that iterates elements of this [CodeSource](../-code-source/index.md). |
| [lastIndexOf](last-index-of.md) | `open fun lastIndexOf(o: Any): Int`<br>Returns the last index of [o](last-index-of.md#com.github.jonathanxd.codeapi.CodeSourceView$lastIndexOf(kotlin.Any)/o) in this [CodeSource](../-code-source/index.md). |
| [listIterator](list-iterator.md) | `open fun listIterator(): MutableListIterator<`[`CodeInstruction`](../-code-instruction.md)`>`<br>Creates a [ListIterator](#) that iterates this [CodeSource](../-code-source/index.md).`open fun listIterator(index: Int): MutableListIterator<`[`CodeInstruction`](../-code-instruction.md)`>`<br>Creates a [ListIterator](#) that iterates this [CodeSource](../-code-source/index.md) and starts at [index](list-iterator.md#com.github.jonathanxd.codeapi.CodeSourceView$listIterator(kotlin.Int)/index). |
| [minus](minus.md) | `open fun minus(other: `[`CodeInstruction`](../-code-instruction.md)`): `[`CodeSource`](../-code-source/index.md)<br>Removes [other](minus.md#com.github.jonathanxd.codeapi.CodeSourceView$minus(com.github.jonathanxd.codeapi.CodeInstruction)/other) from this [CodeSource](../-code-source/index.md).`open fun minus(other: Iterable<`[`CodeInstruction`](../-code-instruction.md)`>): `[`CodeSource`](../-code-source/index.md)<br>Removes all [CodeInstruction](../-code-instruction.md) of [other](minus.md#com.github.jonathanxd.codeapi.CodeSourceView$minus(kotlin.collections.Iterable((com.github.jonathanxd.codeapi.CodeInstruction)))/other) from this [CodeSource](../-code-source/index.md) |
| [minusAssign](minus-assign.md) | `open fun minusAssign(other: Iterable<`[`CodeInstruction`](../-code-instruction.md)`>): Unit`<br>Removes all elements of [other](minus-assign.md#com.github.jonathanxd.codeapi.CodeSourceView$minusAssign(kotlin.collections.Iterable((com.github.jonathanxd.codeapi.CodeInstruction)))/other) from this list.`open fun minusAssign(other: `[`CodeInstruction`](../-code-instruction.md)`): Unit`<br>Removes [other](minus-assign.md#com.github.jonathanxd.codeapi.CodeSourceView$minusAssign(com.github.jonathanxd.codeapi.CodeInstruction)/other) from this list. |
| [parallelStream](parallel-stream.md) | `open fun parallelStream(): `[`Stream`](http://docs.oracle.com/javase/6/docs/api/java/util/stream/Stream.html)`<`[`CodeInstruction`](../-code-instruction.md)`>`<br>Creates a parallel [Stream](http://docs.oracle.com/javase/6/docs/api/java/util/stream/Stream.html) of this [CodeSource](../-code-source/index.md) (which may or may not be parallel). |
| [plus](plus.md) | `open fun plus(other: `[`CodeInstruction`](../-code-instruction.md)`): `[`CodeSource`](../-code-source/index.md)<br>Adds [other](plus.md#com.github.jonathanxd.codeapi.CodeSourceView$plus(com.github.jonathanxd.codeapi.CodeInstruction)/other) to this [CodeSource](../-code-source/index.md).`open fun plus(other: Iterable<`[`CodeInstruction`](../-code-instruction.md)`>): `[`CodeSource`](../-code-source/index.md)<br>Adds all [CodeInstruction](../-code-instruction.md) of [other](plus.md#com.github.jonathanxd.codeapi.CodeSourceView$plus(kotlin.collections.Iterable((com.github.jonathanxd.codeapi.CodeInstruction)))/other) to this [CodeSource](../-code-source/index.md) |
| [plusAssign](plus-assign.md) | `open fun plusAssign(other: Iterable<`[`CodeInstruction`](../-code-instruction.md)`>): Unit`<br>Adds all elements of [other](plus-assign.md#com.github.jonathanxd.codeapi.CodeSourceView$plusAssign(kotlin.collections.Iterable((com.github.jonathanxd.codeapi.CodeInstruction)))/other) to this list.`open fun plusAssign(other: `[`CodeInstruction`](../-code-instruction.md)`): Unit`<br>Adds [other](plus-assign.md#com.github.jonathanxd.codeapi.CodeSourceView$plusAssign(com.github.jonathanxd.codeapi.CodeInstruction)/other) to this list. |
| [remove](remove.md) | `open fun remove(o: Any): Boolean`<br>Removes [o](remove.md#com.github.jonathanxd.codeapi.CodeSourceView$remove(kotlin.Any)/o) from list.`open fun remove(index: Int): `[`CodeInstruction`](../-code-instruction.md)<br>Removes [CodeInstruction](../-code-instruction.md) which is at [index](remove.md#com.github.jonathanxd.codeapi.CodeSourceView$remove(kotlin.Int)/index). And returns removed element. |
| [removeAll](remove-all.md) | `open fun removeAll(c: Collection<*>): Boolean`<br>`open fun removeAll(c: Iterable<`[`CodeInstruction`](../-code-instruction.md)`>): Boolean`<br>Removes all elements which is present in [c](remove-all.md#com.github.jonathanxd.codeapi.CodeSourceView$removeAll(kotlin.collections.Collection((kotlin.Any)))/c) from this list. |
| [removeIf](remove-if.md) | `open fun removeIf(filter: `[`Predicate`](http://docs.oracle.com/javase/6/docs/api/java/util/function/Predicate.html)`<in `[`CodeInstruction`](../-code-instruction.md)`>): Boolean`<br>Removes all [CodeInstruction](../-code-instruction.md)s that matches [filter](remove-if.md#com.github.jonathanxd.codeapi.CodeSourceView$removeIf(java.util.function.Predicate((com.github.jonathanxd.codeapi.CodeInstruction)))/filter). |
| [replaceAll](replace-all.md) | `open fun replaceAll(operator: `[`UnaryOperator`](http://docs.oracle.com/javase/6/docs/api/java/util/function/UnaryOperator.html)`<`[`CodeInstruction`](../-code-instruction.md)`>): Unit`<br>Replaces each element with element returned by [operator](replace-all.md#com.github.jonathanxd.codeapi.CodeSourceView$replaceAll(java.util.function.UnaryOperator((com.github.jonathanxd.codeapi.CodeInstruction)))/operator). |
| [retainAll](retain-all.md) | `open fun retainAll(c: Collection<*>): Boolean`<br>`open fun retainAll(c: Iterable<`[`CodeInstruction`](../-code-instruction.md)`>): Boolean`<br>Retains all elements which is present in [c](retain-all.md#com.github.jonathanxd.codeapi.CodeSourceView$retainAll(kotlin.collections.Collection((kotlin.Any)))/c) in this list. |
| [set](set.md) | `open operator fun set(index: Int, element: `[`CodeInstruction`](../-code-instruction.md)`): `[`CodeInstruction`](../-code-instruction.md)<br>Sets element at [index](set.md#com.github.jonathanxd.codeapi.CodeSourceView$set(kotlin.Int, com.github.jonathanxd.codeapi.CodeInstruction)/index) to [element](set.md#com.github.jonathanxd.codeapi.CodeSourceView$set(kotlin.Int, com.github.jonathanxd.codeapi.CodeInstruction)/element). |
| [sort](sort.md) | `open fun sort(c: `[`Comparator`](http://docs.oracle.com/javase/6/docs/api/java/util/Comparator.html)`<in `[`CodeInstruction`](../-code-instruction.md)`>): Unit`<br>Sorts this [MutableCodeSource](../-mutable-code-source/index.md) using [Comparator](sort.md#com.github.jonathanxd.codeapi.CodeSourceView$sort(java.util.Comparator((com.github.jonathanxd.codeapi.CodeInstruction)))/c). |
| [spliterator](spliterator.md) | `open fun spliterator(): `[`Spliterator`](http://docs.oracle.com/javase/6/docs/api/java/util/Spliterator.html)`<`[`CodeInstruction`](../-code-instruction.md)`>`<br>Creates a [Spliterator](http://docs.oracle.com/javase/6/docs/api/java/util/Spliterator.html) from elements of this [CodeSource](../-code-source/index.md). |
| [stream](stream.md) | `open fun stream(): `[`Stream`](http://docs.oracle.com/javase/6/docs/api/java/util/stream/Stream.html)`<`[`CodeInstruction`](../-code-instruction.md)`>`<br>Creates a [Stream](http://docs.oracle.com/javase/6/docs/api/java/util/stream/Stream.html) of this [CodeSource](../-code-source/index.md). |
| [subSource](sub-source.md) | `open fun subSource(fromIndex: Int, toIndex: Int): `[`CodeSource`](../-code-source/index.md)<br>Creates a view of this [CodeSource](../-code-source/index.md) from index [fromIndex](sub-source.md#com.github.jonathanxd.codeapi.CodeSourceView$subSource(kotlin.Int, kotlin.Int)/fromIndex) to index [toIndex](sub-source.md#com.github.jonathanxd.codeapi.CodeSourceView$subSource(kotlin.Int, kotlin.Int)/toIndex),
changes to this [CodeSource](../-code-source/index.md) is reflected in current [CodeSource](../-code-source/index.md). |
| [toArray](to-array.md) | `open fun toArray(): Array<`[`CodeInstruction`](../-code-instruction.md)`>`<br>Creates an array of [CodeInstruction](../-code-instruction.md) of all elements of this [CodeSource](../-code-source/index.md). |
| [toImmutable](to-immutable.md) | `open fun toImmutable(): `[`CodeSource`](../-code-source/index.md)<br>Creates a immutable [CodeSource](../-code-source/index.md) with elements of this [CodeSource](../-code-source/index.md). |
| [toMutable](to-mutable.md) | `open fun toMutable(): `[`MutableCodeSource`](../-mutable-code-source/index.md)<br>Creates a mutable [CodeSource](../-code-source/index.md) with elements of this [CodeSource](../-code-source/index.md). |
| [toString](to-string.md) | `open fun toString(): String` |

### Inherited Functions

| Name | Summary |
|---|---|
| [addAll](../-mutable-code-source/add-all.md) | `fun addAll(c: Iterable<`[`CodeInstruction`](../-code-instruction.md)`>): Boolean`<br>Adds all [CodeInstruction](../-code-instruction.md) of [c](../-mutable-code-source/add-all.md#com.github.jonathanxd.codeapi.MutableCodeSource$addAll(kotlin.collections.Iterable((com.github.jonathanxd.codeapi.CodeInstruction)))/c) into this list. |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../-code-part/index.md) |
| [getPartType](../../com.github.jonathanxd.codeapi.util/get-part-type.md) | `fun `[`CodePart`](../-code-part/index.md)`.getPartType(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../-code-part/index.md) or throws [IllegalStateException](http://docs.oracle.com/javase/6/docs/api/java/lang/IllegalStateException.html) if [CodePart](../-code-part/index.md) is not instance of [Typed](../../com.github.jonathanxd.codeapi.base/-typed/index.md) |
| [getPartTypeOrNull](../../com.github.jonathanxd.codeapi.util/get-part-type-or-null.md) | `fun `[`CodePart`](../-code-part/index.md)`.getPartTypeOrNull(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../-code-part/index.md) or `null` if [CodePart](../-code-part/index.md) is not instance of [Typed](../../com.github.jonathanxd.codeapi.base/-typed/index.md). |
| [isEqual](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.collections.-iterable/is-equal.md) | `fun <T : Any> Iterable<T>.isEqual(other: Iterable<*>): Boolean`<br>Checks if all elements of receiver [Iterable](#) is equal to elements of [other](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.collections.-iterable/is-equal.md#com.github.jonathanxd.codeapi.util.conversion$isEqual(kotlin.collections.Iterable((com.github.jonathanxd.codeapi.util.conversion.isEqual.T)), kotlin.collections.Iterable((kotlin.Any)))/other). |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
