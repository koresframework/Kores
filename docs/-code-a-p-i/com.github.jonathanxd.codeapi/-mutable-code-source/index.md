[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi](../index.md) / [MutableCodeSource](.)

# MutableCodeSource

`abstract class MutableCodeSource : `[`CodeSource`](../-code-source/index.md)`, Cloneable`

A mutable [CodeSource](../-code-source/index.md) backing to a [ArrayList](http://docs.oracle.com/javase/6/docs/api/java/util/ArrayList.html) instead of to an [Array](#).

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MutableCodeSource()`<br>A mutable [CodeSource](../-code-source/index.md) backing to a [ArrayList](http://docs.oracle.com/javase/6/docs/api/java/util/ArrayList.html) instead of to an [Array](#). |

### Inherited Properties

| Name | Summary |
|---|---|
| [isEmpty](../-code-source/is-empty.md) | `val isEmpty: Boolean`<br>True if is empty, false otherwise. |
| [isNotEmpty](../-code-source/is-not-empty.md) | `val isNotEmpty: Boolean`<br>True if is not empty, false otherwise. |
| [size](../-code-source/size.md) | `abstract val size: Int`<br>Size of source. |

### Functions

| Name | Summary |
|---|---|
| [add](add.md) | `abstract fun add(instruction: `[`CodeInstruction`](../-code-instruction.md)`): Boolean`<br>Adds [instruction](add.md#com.github.jonathanxd.codeapi.MutableCodeSource$add(com.github.jonathanxd.codeapi.CodeInstruction)/instruction) to list.`abstract fun add(index: Int, element: `[`CodeInstruction`](../-code-instruction.md)`): Unit`<br>Adds [element](add.md#com.github.jonathanxd.codeapi.MutableCodeSource$add(kotlin.Int, com.github.jonathanxd.codeapi.CodeInstruction)/element) at [index](add.md#com.github.jonathanxd.codeapi.MutableCodeSource$add(kotlin.Int, com.github.jonathanxd.codeapi.CodeInstruction)/index). |
| [addAll](add-all.md) | `abstract fun addAll(c: Collection<`[`CodeInstruction`](../-code-instruction.md)`>): Boolean`<br>`fun addAll(c: Iterable<`[`CodeInstruction`](../-code-instruction.md)`>): Boolean`<br>Adds all [CodeInstruction](../-code-instruction.md) of [c](add-all.md#com.github.jonathanxd.codeapi.MutableCodeSource$addAll(kotlin.collections.Collection((com.github.jonathanxd.codeapi.CodeInstruction)))/c) into this list.`abstract fun addAll(index: Int, c: Collection<`[`CodeInstruction`](../-code-instruction.md)`>): Boolean`<br>`abstract fun addAll(index: Int, c: Iterable<`[`CodeInstruction`](../-code-instruction.md)`>): Boolean`<br>Adds all [CodeInstruction](../-code-instruction.md) of [c](add-all.md#com.github.jonathanxd.codeapi.MutableCodeSource$addAll(kotlin.Int, kotlin.collections.Collection((com.github.jonathanxd.codeapi.CodeInstruction)))/c) into this list at [index](add-all.md#com.github.jonathanxd.codeapi.MutableCodeSource$addAll(kotlin.Int, kotlin.collections.Collection((com.github.jonathanxd.codeapi.CodeInstruction)))/index). |
| [clear](clear.md) | `abstract fun clear(): Unit`<br>Clears this list. |
| [minusAssign](minus-assign.md) | `abstract operator fun minusAssign(other: Iterable<`[`CodeInstruction`](../-code-instruction.md)`>): Unit`<br>Removes all elements of [other](minus-assign.md#com.github.jonathanxd.codeapi.MutableCodeSource$minusAssign(kotlin.collections.Iterable((com.github.jonathanxd.codeapi.CodeInstruction)))/other) from this list.`abstract operator fun minusAssign(other: `[`CodeInstruction`](../-code-instruction.md)`): Unit`<br>Removes [other](minus-assign.md#com.github.jonathanxd.codeapi.MutableCodeSource$minusAssign(com.github.jonathanxd.codeapi.CodeInstruction)/other) from this list. |
| [plusAssign](plus-assign.md) | `abstract operator fun plusAssign(other: Iterable<`[`CodeInstruction`](../-code-instruction.md)`>): Unit`<br>Adds all elements of [other](plus-assign.md#com.github.jonathanxd.codeapi.MutableCodeSource$plusAssign(kotlin.collections.Iterable((com.github.jonathanxd.codeapi.CodeInstruction)))/other) to this list.`abstract operator fun plusAssign(other: `[`CodeInstruction`](../-code-instruction.md)`): Unit`<br>Adds [other](plus-assign.md#com.github.jonathanxd.codeapi.MutableCodeSource$plusAssign(com.github.jonathanxd.codeapi.CodeInstruction)/other) to this list. |
| [remove](remove.md) | `abstract fun remove(o: Any): Boolean`<br>Removes [o](remove.md#com.github.jonathanxd.codeapi.MutableCodeSource$remove(kotlin.Any)/o) from list.`abstract fun remove(index: Int): `[`CodeInstruction`](../-code-instruction.md)<br>Removes [CodeInstruction](../-code-instruction.md) which is at [index](remove.md#com.github.jonathanxd.codeapi.MutableCodeSource$remove(kotlin.Int)/index). And returns removed element. |
| [removeAll](remove-all.md) | `abstract fun removeAll(c: Collection<*>): Boolean`<br>`abstract fun removeAll(c: Iterable<`[`CodeInstruction`](../-code-instruction.md)`>): Boolean`<br>Removes all elements which is present in [c](remove-all.md#com.github.jonathanxd.codeapi.MutableCodeSource$removeAll(kotlin.collections.Collection((kotlin.Any)))/c) from this list. |
| [removeIf](remove-if.md) | `abstract fun removeIf(filter: `[`Predicate`](http://docs.oracle.com/javase/6/docs/api/java/util/function/Predicate.html)`<in `[`CodeInstruction`](../-code-instruction.md)`>): Boolean`<br>Removes all [CodeInstruction](../-code-instruction.md)s that matches [filter](remove-if.md#com.github.jonathanxd.codeapi.MutableCodeSource$removeIf(java.util.function.Predicate((com.github.jonathanxd.codeapi.CodeInstruction)))/filter). |
| [replaceAll](replace-all.md) | `abstract fun replaceAll(operator: `[`UnaryOperator`](http://docs.oracle.com/javase/6/docs/api/java/util/function/UnaryOperator.html)`<`[`CodeInstruction`](../-code-instruction.md)`>): Unit`<br>Replaces each element with element returned by [operator](replace-all.md#com.github.jonathanxd.codeapi.MutableCodeSource$replaceAll(java.util.function.UnaryOperator((com.github.jonathanxd.codeapi.CodeInstruction)))/operator). |
| [retainAll](retain-all.md) | `abstract fun retainAll(c: Collection<*>): Boolean`<br>`abstract fun retainAll(c: Iterable<`[`CodeInstruction`](../-code-instruction.md)`>): Boolean`<br>Retains all elements which is present in [c](retain-all.md#com.github.jonathanxd.codeapi.MutableCodeSource$retainAll(kotlin.collections.Collection((kotlin.Any)))/c) in this list. |
| [set](set.md) | `abstract operator fun set(index: Int, element: `[`CodeInstruction`](../-code-instruction.md)`): `[`CodeInstruction`](../-code-instruction.md)<br>Sets element at [index](set.md#com.github.jonathanxd.codeapi.MutableCodeSource$set(kotlin.Int, com.github.jonathanxd.codeapi.CodeInstruction)/index) to [element](set.md#com.github.jonathanxd.codeapi.MutableCodeSource$set(kotlin.Int, com.github.jonathanxd.codeapi.CodeInstruction)/element). |
| [sort](sort.md) | `abstract fun sort(c: `[`Comparator`](http://docs.oracle.com/javase/6/docs/api/java/util/Comparator.html)`<in `[`CodeInstruction`](../-code-instruction.md)`>): Unit`<br>Sorts this MutableCodeSource using [Comparator](sort.md#com.github.jonathanxd.codeapi.MutableCodeSource$sort(java.util.Comparator((com.github.jonathanxd.codeapi.CodeInstruction)))/c). |
| [toString](to-string.md) | `open fun toString(): String` |

### Inherited Functions

| Name | Summary |
|---|---|
| [contains](../-code-source/contains.md) | `abstract operator fun contains(o: Any): Boolean`<br>Returns true if this [CodeSource](../-code-source/index.md) contains [o](../-code-source/contains.md#com.github.jonathanxd.codeapi.CodeSource$contains(kotlin.Any)/o). |
| [containsAll](../-code-source/contains-all.md) | `open fun containsAll(c: Collection<*>): Boolean`<br>Returns true if this [CodeSource](../-code-source/index.md) contains all elements of [c](../-code-source/contains-all.md#com.github.jonathanxd.codeapi.CodeSource$containsAll(kotlin.collections.Collection((kotlin.Any)))/c). |
| [forEach](../-code-source/for-each.md) | `abstract fun forEach(action: `[`Consumer`](http://docs.oracle.com/javase/6/docs/api/java/util/function/Consumer.html)`<in `[`CodeInstruction`](../-code-instruction.md)`>): Unit`<br>For each all elements of this [CodeSource](../-code-source/index.md). |
| [get](../-code-source/get.md) | `operator fun get(index: Int): `[`CodeInstruction`](../-code-instruction.md)<br>Gets element at index [index](../-code-source/get.md#com.github.jonathanxd.codeapi.CodeSource$get(kotlin.Int)/index). |
| [getAtIndex](../-code-source/get-at-index.md) | `abstract fun getAtIndex(index: Int): `[`CodeInstruction`](../-code-instruction.md)<br>Gets element at index [index](../-code-source/get-at-index.md#com.github.jonathanxd.codeapi.CodeSource$getAtIndex(kotlin.Int)/index). This method should only be called if the index
is in the bounds. |
| [indexOf](../-code-source/index-of.md) | `abstract fun indexOf(o: Any): Int`<br>Returns the index of [o](../-code-source/index-of.md#com.github.jonathanxd.codeapi.CodeSource$indexOf(kotlin.Any)/o) in this [CodeSource](../-code-source/index.md). |
| [iterator](../-code-source/iterator.md) | `abstract fun iterator(): Iterator<`[`CodeInstruction`](../-code-instruction.md)`>`<br>Creates an [Iterator](#) that iterates elements of this [CodeSource](../-code-source/index.md). |
| [lastIndexOf](../-code-source/last-index-of.md) | `abstract fun lastIndexOf(o: Any): Int`<br>Returns the last index of [o](../-code-source/last-index-of.md#com.github.jonathanxd.codeapi.CodeSource$lastIndexOf(kotlin.Any)/o) in this [CodeSource](../-code-source/index.md). |
| [listIterator](../-code-source/list-iterator.md) | `abstract fun listIterator(): ListIterator<`[`CodeInstruction`](../-code-instruction.md)`>`<br>Creates a [ListIterator](#) that iterates this [CodeSource](../-code-source/index.md).`abstract fun listIterator(index: Int): ListIterator<`[`CodeInstruction`](../-code-instruction.md)`>`<br>Creates a [ListIterator](#) that iterates this [CodeSource](../-code-source/index.md) and starts at [index](../-code-source/list-iterator.md#com.github.jonathanxd.codeapi.CodeSource$listIterator(kotlin.Int)/index). |
| [minus](../-code-source/minus.md) | `abstract operator fun minus(other: `[`CodeInstruction`](../-code-instruction.md)`): `[`CodeSource`](../-code-source/index.md)<br>Removes [other](../-code-source/minus.md#com.github.jonathanxd.codeapi.CodeSource$minus(com.github.jonathanxd.codeapi.CodeInstruction)/other) from this [CodeSource](../-code-source/index.md).`abstract operator fun minus(other: Iterable<`[`CodeInstruction`](../-code-instruction.md)`>): `[`CodeSource`](../-code-source/index.md)<br>Removes all [CodeInstruction](../-code-instruction.md) of [other](../-code-source/minus.md#com.github.jonathanxd.codeapi.CodeSource$minus(kotlin.collections.Iterable((com.github.jonathanxd.codeapi.CodeInstruction)))/other) from this [CodeSource](../-code-source/index.md) |
| [parallelStream](../-code-source/parallel-stream.md) | `abstract fun parallelStream(): `[`Stream`](http://docs.oracle.com/javase/6/docs/api/java/util/stream/Stream.html)`<`[`CodeInstruction`](../-code-instruction.md)`>`<br>Creates a parallel [Stream](http://docs.oracle.com/javase/6/docs/api/java/util/stream/Stream.html) of this [CodeSource](../-code-source/index.md) (which may or may not be parallel). |
| [plus](../-code-source/plus.md) | `abstract operator fun plus(other: `[`CodeInstruction`](../-code-instruction.md)`): `[`CodeSource`](../-code-source/index.md)<br>Adds [other](../-code-source/plus.md#com.github.jonathanxd.codeapi.CodeSource$plus(com.github.jonathanxd.codeapi.CodeInstruction)/other) to this [CodeSource](../-code-source/index.md).`abstract operator fun plus(other: Iterable<`[`CodeInstruction`](../-code-instruction.md)`>): `[`CodeSource`](../-code-source/index.md)<br>Adds all [CodeInstruction](../-code-instruction.md) of [other](../-code-source/plus.md#com.github.jonathanxd.codeapi.CodeSource$plus(kotlin.collections.Iterable((com.github.jonathanxd.codeapi.CodeInstruction)))/other) to this [CodeSource](../-code-source/index.md) |
| [spliterator](../-code-source/spliterator.md) | `abstract fun spliterator(): `[`Spliterator`](http://docs.oracle.com/javase/6/docs/api/java/util/Spliterator.html)`<`[`CodeInstruction`](../-code-instruction.md)`>`<br>Creates a [Spliterator](http://docs.oracle.com/javase/6/docs/api/java/util/Spliterator.html) from elements of this [CodeSource](../-code-source/index.md). |
| [stream](../-code-source/stream.md) | `abstract fun stream(): `[`Stream`](http://docs.oracle.com/javase/6/docs/api/java/util/stream/Stream.html)`<`[`CodeInstruction`](../-code-instruction.md)`>`<br>Creates a [Stream](http://docs.oracle.com/javase/6/docs/api/java/util/stream/Stream.html) of this [CodeSource](../-code-source/index.md). |
| [subSource](../-code-source/sub-source.md) | `abstract fun subSource(fromIndex: Int, toIndex: Int): `[`CodeSource`](../-code-source/index.md)<br>Creates a view of this [CodeSource](../-code-source/index.md) from index [fromIndex](../-code-source/sub-source.md#com.github.jonathanxd.codeapi.CodeSource$subSource(kotlin.Int, kotlin.Int)/fromIndex) to index [toIndex](../-code-source/sub-source.md#com.github.jonathanxd.codeapi.CodeSource$subSource(kotlin.Int, kotlin.Int)/toIndex),
changes to this [CodeSource](../-code-source/index.md) is reflected in current [CodeSource](../-code-source/index.md). |
| [toArray](../-code-source/to-array.md) | `abstract fun toArray(): Array<`[`CodeInstruction`](../-code-instruction.md)`>`<br>Creates an array of [CodeInstruction](../-code-instruction.md) of all elements of this [CodeSource](../-code-source/index.md). |
| [toImmutable](../-code-source/to-immutable.md) | `open fun toImmutable(): `[`CodeSource`](../-code-source/index.md)<br>Creates a immutable [CodeSource](../-code-source/index.md) with elements of this [CodeSource](../-code-source/index.md). |
| [toMutable](../-code-source/to-mutable.md) | `open fun toMutable(): MutableCodeSource`<br>Creates a mutable [CodeSource](../-code-source/index.md) with elements of this [CodeSource](../-code-source/index.md). |

### Companion Object Functions

| Name | Summary |
|---|---|
| [create](create.md) | `fun create(): MutableCodeSource`<br>Create a MutableCodeSource.`fun create(list: List<`[`CodeInstruction`](../-code-instruction.md)`>): MutableCodeSource`<br>Create a MutableCodeSource from a copy of [list](create.md#com.github.jonathanxd.codeapi.MutableCodeSource.Companion$create(kotlin.collections.List((com.github.jonathanxd.codeapi.CodeInstruction)))/list). |
| [createFromOriginal](create-from-original.md) | `fun createFromOriginal(list: MutableList<`[`CodeInstruction`](../-code-instruction.md)`>): MutableCodeSource`<br>Create a MutableCodeSource delegating to [list](create-from-original.md#com.github.jonathanxd.codeapi.MutableCodeSource.Companion$createFromOriginal(kotlin.collections.MutableList((com.github.jonathanxd.codeapi.CodeInstruction)))/list). |

### Extension Properties

| Name | Summary |
|---|---|
| [isPrimitive](../../com.github.jonathanxd.codeapi.util/is-primitive.md) | `val `[`CodePart`](../-code-part/index.md)`.isPrimitive: Boolean`<br>Returns true if the type of this [CodePart](../-code-part/index.md) is primitive |
| [type](../../com.github.jonathanxd.codeapi.util/type.md) | `val `[`CodePart`](../-code-part/index.md)`.type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Gets the type of [CodePart](../-code-part/index.md) |
| [typeOrNull](../../com.github.jonathanxd.codeapi.util/type-or-null.md) | `val `[`CodePart`](../-code-part/index.md)`.typeOrNull: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Gets the type of [CodePart](../-code-part/index.md) or null if receiver is not a [Typed](../../com.github.jonathanxd.codeapi.base/-typed/index.md) instance. |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../-code-part/index.md) |
| [isEqual](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.collections.-iterable/is-equal.md) | `fun <T : Any> Iterable<T>.isEqual(other: Iterable<*>): Boolean`<br>Checks if all elements of receiver [Iterable](#) is equal to elements of [other](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.collections.-iterable/is-equal.md#com.github.jonathanxd.codeapi.util.conversion$isEqual(kotlin.collections.Iterable((com.github.jonathanxd.codeapi.util.conversion.isEqual.T)), kotlin.collections.Iterable((kotlin.Any)))/other). |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |

### Inheritors

| Name | Summary |
|---|---|
| [CodeSourceView](../-code-source-view/index.md) | `open class CodeSourceView : MutableCodeSource` |
| [ListCodeSource](../-list-code-source/index.md) | `class ListCodeSource : MutableCodeSource, Cloneable`<br>A MutableCodeSource backing to a [ArrayList](http://docs.oracle.com/javase/6/docs/api/java/util/ArrayList.html). |
