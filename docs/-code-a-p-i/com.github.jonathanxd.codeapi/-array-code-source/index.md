[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi](../index.md) / [ArrayCodeSource](.)

# ArrayCodeSource

`class ArrayCodeSource : `[`CodeSource`](../-code-source/index.md)

CodeSource is an iterable of [CodeInstructions](../-code-instruction.md).

This class is backed by an [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html) of [CodeInstruction](../-code-instruction.md).

**See Also**

[MutableCodeSource](../-mutable-code-source/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ArrayCodeSource()``ArrayCodeSource(parts: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`CodeInstruction`](../-code-instruction.md)`> = emptyArray())`<br>CodeSource is an iterable of [CodeInstructions](../-code-instruction.md). |

### Properties

| Name | Summary |
|---|---|
| [size](size.md) | `val size: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Size of source. |

### Inherited Properties

| Name | Summary |
|---|---|
| [isEmpty](../-code-source/is-empty.md) | `val isEmpty: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True if is empty, false otherwise. |
| [isNotEmpty](../-code-source/is-not-empty.md) | `val isNotEmpty: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True if is not empty, false otherwise. |

### Functions

| Name | Summary |
|---|---|
| [contains](contains.md) | `operator fun contains(o: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if this [CodeSource](../-code-source/index.md) contains [o](contains.md#com.github.jonathanxd.codeapi.ArrayCodeSource$contains(kotlin.Any)/o). |
| [forEach](for-each.md) | `fun forEach(action: Consumer<in `[`CodeInstruction`](../-code-instruction.md)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>For each all elements of this [CodeSource](../-code-source/index.md). |
| [getAtIndex](get-at-index.md) | `fun getAtIndex(index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`CodeInstruction`](../-code-instruction.md)<br>Gets element at index [index](get-at-index.md#com.github.jonathanxd.codeapi.ArrayCodeSource$getAtIndex(kotlin.Int)/index). This method should only be called if the index is in the bounds. |
| [indexOf](index-of.md) | `fun indexOf(o: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Returns the index of [o](index-of.md#com.github.jonathanxd.codeapi.ArrayCodeSource$indexOf(kotlin.Any)/o) in this [CodeSource](../-code-source/index.md). |
| [iterator](iterator.md) | `fun iterator(): `[`Iterator`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterator/index.html)`<`[`CodeInstruction`](../-code-instruction.md)`>`<br>Creates an [Iterator](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterator/index.html) that iterates elements of this [CodeSource](../-code-source/index.md). |
| [lastIndexOf](last-index-of.md) | `fun lastIndexOf(o: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Returns the last index of [o](last-index-of.md#com.github.jonathanxd.codeapi.ArrayCodeSource$lastIndexOf(kotlin.Any)/o) in this [CodeSource](../-code-source/index.md). |
| [listIterator](list-iterator.md) | `fun listIterator(): `[`ListIterator`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list-iterator/index.html)`<`[`CodeInstruction`](../-code-instruction.md)`>`<br>Creates a [ListIterator](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list-iterator/index.html) that iterates this [CodeSource](../-code-source/index.md).`fun listIterator(index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`ListIterator`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list-iterator/index.html)`<`[`CodeInstruction`](../-code-instruction.md)`>`<br>Creates a [ListIterator](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list-iterator/index.html) that iterates this [CodeSource](../-code-source/index.md) and starts at [index](list-iterator.md#com.github.jonathanxd.codeapi.ArrayCodeSource$listIterator(kotlin.Int)/index). |
| [minus](minus.md) | `operator fun minus(other: `[`CodeInstruction`](../-code-instruction.md)`): `[`CodeSource`](../-code-source/index.md)<br>Removes [other](minus.md#com.github.jonathanxd.codeapi.ArrayCodeSource$minus(com.github.jonathanxd.codeapi.CodeInstruction)/other) from this [CodeSource](../-code-source/index.md).`operator fun minus(other: `[`Iterable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)`<`[`CodeInstruction`](../-code-instruction.md)`>): `[`CodeSource`](../-code-source/index.md)<br>Removes all [CodeInstruction](../-code-instruction.md) of [other](minus.md#com.github.jonathanxd.codeapi.ArrayCodeSource$minus(kotlin.collections.Iterable((com.github.jonathanxd.codeapi.CodeInstruction)))/other) from this [CodeSource](../-code-source/index.md) |
| [parallelStream](parallel-stream.md) | `fun parallelStream(): Stream<`[`CodeInstruction`](../-code-instruction.md)`>`<br>Creates a parallel [Stream](#) of this [CodeSource](../-code-source/index.md) (which may or may not be parallel). |
| [plus](plus.md) | `operator fun plus(other: `[`CodeInstruction`](../-code-instruction.md)`): `[`CodeSource`](../-code-source/index.md)<br>Adds [other](plus.md#com.github.jonathanxd.codeapi.ArrayCodeSource$plus(com.github.jonathanxd.codeapi.CodeInstruction)/other) to this [CodeSource](../-code-source/index.md).`operator fun plus(other: `[`Iterable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)`<`[`CodeInstruction`](../-code-instruction.md)`>): `[`CodeSource`](../-code-source/index.md)<br>Adds all [CodeInstruction](../-code-instruction.md) of [other](plus.md#com.github.jonathanxd.codeapi.ArrayCodeSource$plus(kotlin.collections.Iterable((com.github.jonathanxd.codeapi.CodeInstruction)))/other) to this [CodeSource](../-code-source/index.md) |
| [spliterator](spliterator.md) | `fun spliterator(): Spliterator<`[`CodeInstruction`](../-code-instruction.md)`>`<br>Creates a [Spliterator](#) from elements of this [CodeSource](../-code-source/index.md). |
| [stream](stream.md) | `fun stream(): Stream<`[`CodeInstruction`](../-code-instruction.md)`>`<br>Creates a [Stream](#) of this [CodeSource](../-code-source/index.md). |
| [subSource](sub-source.md) | `fun subSource(fromIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, toIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`CodeSource`](../-code-source/index.md)<br>Creates a view of this [CodeSource](../-code-source/index.md) from index [fromIndex](sub-source.md#com.github.jonathanxd.codeapi.ArrayCodeSource$subSource(kotlin.Int, kotlin.Int)/fromIndex) to index [toIndex](sub-source.md#com.github.jonathanxd.codeapi.ArrayCodeSource$subSource(kotlin.Int, kotlin.Int)/toIndex), changes to this [CodeSource](../-code-source/index.md) is reflected in current [CodeSource](../-code-source/index.md). |
| [toArray](to-array.md) | `fun toArray(): `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`CodeInstruction`](../-code-instruction.md)`>`<br>Creates an array of [CodeInstruction](../-code-instruction.md) of all elements of this [CodeSource](../-code-source/index.md). |
| [toString](to-string.md) | `fun toString(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Inherited Functions

| Name | Summary |
|---|---|
| [containsAll](../-code-source/contains-all.md) | `open fun containsAll(c: `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<*>): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if this [CodeSource](../-code-source/index.md) contains all elements of [c](../-code-source/contains-all.md#com.github.jonathanxd.codeapi.CodeSource$containsAll(kotlin.collections.Collection((kotlin.Any)))/c). |
| [get](../-code-source/get.md) | `operator fun get(index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`CodeInstruction`](../-code-instruction.md)<br>Gets element at index [index](../-code-source/get.md#com.github.jonathanxd.codeapi.CodeSource$get(kotlin.Int)/index). |
| [toImmutable](../-code-source/to-immutable.md) | `open fun toImmutable(): `[`CodeSource`](../-code-source/index.md)<br>Creates a immutable [CodeSource](../-code-source/index.md) with elements of this [CodeSource](../-code-source/index.md). |
| [toMutable](../-code-source/to-mutable.md) | `open fun toMutable(): `[`MutableCodeSource`](../-mutable-code-source/index.md)<br>Creates a mutable [CodeSource](../-code-source/index.md) with elements of this [CodeSource](../-code-source/index.md). |

### Companion Object Functions

| Name | Summary |
|---|---|
| [ArrayCodeSource](-array-code-source.md) | `fun ArrayCodeSource(size: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, init: (index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`) -> `[`CodeInstruction`](../-code-instruction.md)`): `[`CodeSource`](../-code-source/index.md) |

### Extension Properties

| Name | Summary |
|---|---|
| [isPrimitive](../../com.github.jonathanxd.codeapi.util/is-primitive.md) | `val `[`CodePart`](../-code-part/index.md)`.isPrimitive: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if the type of this [CodePart](../-code-part/index.md) is primitive |
| [type](../../com.github.jonathanxd.codeapi.util/type.md) | `val `[`CodePart`](../-code-part/index.md)`.type: Type`<br>Gets the type of [CodePart](../-code-part/index.md) |
| [typeOrNull](../../com.github.jonathanxd.codeapi.util/type-or-null.md) | `val `[`CodePart`](../-code-part/index.md)`.typeOrNull: Type?`<br>Gets the type of [CodePart](../-code-part/index.md) or null if receiver is not a [Typed](../../com.github.jonathanxd.codeapi.base/-typed/index.md) instance. |

### Extension Functions

| Name | Summary |
|---|---|
| [annotationValue](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/annotation-value.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.annotationValue(rType: Class<*>): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) |
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?.asString(simple: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Create a String representation of the part of this [CodePart](../-code-part/index.md) |
| [isEqual](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.collections.-iterable/is-equal.md) | `fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`Iterable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)`<T>.isEqual(other: `[`Iterable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)`<*>): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Checks if all elements of receiver [Iterable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html) is equal to elements of [other](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.collections.-iterable/is-equal.md#com.github.jonathanxd.codeapi.util.conversion$isEqual(kotlin.collections.Iterable((com.github.jonathanxd.codeapi.util.conversion.isEqual.T)), kotlin.collections.Iterable((kotlin.Any)))/other). |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)<br>Convert this value to a literal |
| [toLiteralOrNull](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal-or-null.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteralOrNull(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
