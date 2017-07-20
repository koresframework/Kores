[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi](../index.md) / [CodeSource](.)

# CodeSource

`abstract class CodeSource : Iterable<`[`CodeInstruction`](../-code-instruction.md)`>, `[`CodePart`](../-code-part/index.md)

Abstract [CodeInstruction](../-code-instruction.md) iterable.

**See Also**

[ArrayCodeSource](../-array-code-source/index.md)

[MutableCodeSource](../-mutable-code-source/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CodeSource()`<br>Abstract [CodeInstruction](../-code-instruction.md) iterable. |

### Properties

| Name | Summary |
|---|---|
| [isEmpty](is-empty.md) | `val isEmpty: Boolean`<br>True if is empty, false otherwise. |
| [isNotEmpty](is-not-empty.md) | `val isNotEmpty: Boolean`<br>True if is not empty, false otherwise. |
| [size](size.md) | `abstract val size: Int`<br>Size of source. |

### Functions

| Name | Summary |
|---|---|
| [contains](contains.md) | `abstract operator fun contains(o: Any): Boolean`<br>Returns true if this CodeSource contains [o](contains.md#com.github.jonathanxd.codeapi.CodeSource$contains(kotlin.Any)/o). |
| [containsAll](contains-all.md) | `open fun containsAll(c: Collection<*>): Boolean`<br>Returns true if this CodeSource contains all elements of [c](contains-all.md#com.github.jonathanxd.codeapi.CodeSource$containsAll(kotlin.collections.Collection((kotlin.Any)))/c). |
| [forEach](for-each.md) | `abstract fun forEach(action: `[`Consumer`](http://docs.oracle.com/javase/6/docs/api/java/util/function/Consumer.html)`<in `[`CodeInstruction`](../-code-instruction.md)`>): Unit`<br>For each all elements of this CodeSource. |
| [get](get.md) | `operator fun get(index: Int): `[`CodeInstruction`](../-code-instruction.md)<br>Gets element at index [index](get.md#com.github.jonathanxd.codeapi.CodeSource$get(kotlin.Int)/index). |
| [getAtIndex](get-at-index.md) | `abstract fun getAtIndex(index: Int): `[`CodeInstruction`](../-code-instruction.md)<br>Gets element at index [index](get-at-index.md#com.github.jonathanxd.codeapi.CodeSource$getAtIndex(kotlin.Int)/index). This method should only be called if the index
is in the bounds. |
| [indexOf](index-of.md) | `abstract fun indexOf(o: Any): Int`<br>Returns the index of [o](index-of.md#com.github.jonathanxd.codeapi.CodeSource$indexOf(kotlin.Any)/o) in this CodeSource. |
| [iterator](iterator.md) | `abstract fun iterator(): Iterator<`[`CodeInstruction`](../-code-instruction.md)`>`<br>Creates an [Iterator](#) that iterates elements of this CodeSource. |
| [lastIndexOf](last-index-of.md) | `abstract fun lastIndexOf(o: Any): Int`<br>Returns the last index of [o](last-index-of.md#com.github.jonathanxd.codeapi.CodeSource$lastIndexOf(kotlin.Any)/o) in this CodeSource. |
| [listIterator](list-iterator.md) | `abstract fun listIterator(): ListIterator<`[`CodeInstruction`](../-code-instruction.md)`>`<br>Creates a [ListIterator](#) that iterates this CodeSource.`abstract fun listIterator(index: Int): ListIterator<`[`CodeInstruction`](../-code-instruction.md)`>`<br>Creates a [ListIterator](#) that iterates this CodeSource and starts at [index](list-iterator.md#com.github.jonathanxd.codeapi.CodeSource$listIterator(kotlin.Int)/index). |
| [minus](minus.md) | `abstract operator fun minus(other: `[`CodeInstruction`](../-code-instruction.md)`): CodeSource`<br>Removes [other](minus.md#com.github.jonathanxd.codeapi.CodeSource$minus(com.github.jonathanxd.codeapi.CodeInstruction)/other) from this CodeSource.`abstract operator fun minus(other: Iterable<`[`CodeInstruction`](../-code-instruction.md)`>): CodeSource`<br>Removes all [CodeInstruction](../-code-instruction.md) of [other](minus.md#com.github.jonathanxd.codeapi.CodeSource$minus(kotlin.collections.Iterable((com.github.jonathanxd.codeapi.CodeInstruction)))/other) from this CodeSource |
| [parallelStream](parallel-stream.md) | `abstract fun parallelStream(): `[`Stream`](http://docs.oracle.com/javase/6/docs/api/java/util/stream/Stream.html)`<`[`CodeInstruction`](../-code-instruction.md)`>`<br>Creates a parallel [Stream](http://docs.oracle.com/javase/6/docs/api/java/util/stream/Stream.html) of this CodeSource (which may or may not be parallel). |
| [plus](plus.md) | `abstract operator fun plus(other: `[`CodeInstruction`](../-code-instruction.md)`): CodeSource`<br>Adds [other](plus.md#com.github.jonathanxd.codeapi.CodeSource$plus(com.github.jonathanxd.codeapi.CodeInstruction)/other) to this CodeSource.`abstract operator fun plus(other: Iterable<`[`CodeInstruction`](../-code-instruction.md)`>): CodeSource`<br>Adds all [CodeInstruction](../-code-instruction.md) of [other](plus.md#com.github.jonathanxd.codeapi.CodeSource$plus(kotlin.collections.Iterable((com.github.jonathanxd.codeapi.CodeInstruction)))/other) to this CodeSource |
| [spliterator](spliterator.md) | `abstract fun spliterator(): `[`Spliterator`](http://docs.oracle.com/javase/6/docs/api/java/util/Spliterator.html)`<`[`CodeInstruction`](../-code-instruction.md)`>`<br>Creates a [Spliterator](http://docs.oracle.com/javase/6/docs/api/java/util/Spliterator.html) from elements of this CodeSource. |
| [stream](stream.md) | `abstract fun stream(): `[`Stream`](http://docs.oracle.com/javase/6/docs/api/java/util/stream/Stream.html)`<`[`CodeInstruction`](../-code-instruction.md)`>`<br>Creates a [Stream](http://docs.oracle.com/javase/6/docs/api/java/util/stream/Stream.html) of this CodeSource. |
| [subSource](sub-source.md) | `abstract fun subSource(fromIndex: Int, toIndex: Int): CodeSource`<br>Creates a view of this CodeSource from index [fromIndex](sub-source.md#com.github.jonathanxd.codeapi.CodeSource$subSource(kotlin.Int, kotlin.Int)/fromIndex) to index [toIndex](sub-source.md#com.github.jonathanxd.codeapi.CodeSource$subSource(kotlin.Int, kotlin.Int)/toIndex),
changes to this CodeSource is reflected in current CodeSource. |
| [toArray](to-array.md) | `abstract fun toArray(): Array<`[`CodeInstruction`](../-code-instruction.md)`>`<br>Creates an array of [CodeInstruction](../-code-instruction.md) of all elements of this CodeSource. |
| [toImmutable](to-immutable.md) | `open fun toImmutable(): CodeSource`<br>Creates a immutable CodeSource with elements of this CodeSource. |
| [toMutable](to-mutable.md) | `open fun toMutable(): `[`MutableCodeSource`](../-mutable-code-source/index.md)<br>Creates a mutable CodeSource with elements of this CodeSource. |
| [toString](to-string.md) | `open fun toString(): String` |

### Inherited Functions

| Name | Summary |
|---|---|
| [builder](../-code-part/builder.md) | `open fun builder(): `[`Builder`](../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<`[`CodePart`](../-code-part/index.md)`, *>`<br>This builder may or may not accept null values, it depends on implementation. |

### Companion Object Functions

| Name | Summary |
|---|---|
| [empty](empty.md) | `fun empty(): CodeSource`<br>Returns a empty immutable CodeSource. |
| [fromArray](from-array.md) | `fun fromArray(parts: Array<`[`CodeInstruction`](../-code-instruction.md)`>): CodeSource`<br>Creates a immutable CodeSource with all elements of [parts](from-array.md#com.github.jonathanxd.codeapi.CodeSource.Companion$fromArray(kotlin.Array((com.github.jonathanxd.codeapi.CodeInstruction)))/parts). |
| [fromCodeSourceIterable](from-code-source-iterable.md) | `fun fromCodeSourceIterable(iterable: Iterable<CodeSource>): CodeSource`<br>Creates a immutable CodeSource with all elements of CodeSources of [iterable](from-code-source-iterable.md#com.github.jonathanxd.codeapi.CodeSource.Companion$fromCodeSourceIterable(kotlin.collections.Iterable((com.github.jonathanxd.codeapi.CodeSource)))/iterable). |
| [fromGenericIterable](from-generic-iterable.md) | `fun fromGenericIterable(iterable: Iterable<*>): CodeSource`<br>Creates a immutable CodeSource from elements of generic [iterable](from-generic-iterable.md#com.github.jonathanxd.codeapi.CodeSource.Companion$fromGenericIterable(kotlin.collections.Iterable((kotlin.Any)))/iterable). |
| [fromIterable](from-iterable.md) | `fun fromIterable(iterable: Iterable<`[`CodeInstruction`](../-code-instruction.md)`>): CodeSource`<br>Creates a immutable CodeSource from elements of [iterable](from-iterable.md#com.github.jonathanxd.codeapi.CodeSource.Companion$fromIterable(kotlin.collections.Iterable((com.github.jonathanxd.codeapi.CodeInstruction)))/iterable). |
| [fromPart](from-part.md) | `fun fromPart(part: `[`CodeInstruction`](../-code-instruction.md)`): CodeSource`<br>Creates a immutable CodeSource with a single [part](from-part.md#com.github.jonathanxd.codeapi.CodeSource.Companion$fromPart(com.github.jonathanxd.codeapi.CodeInstruction)/part). |
| [fromVarArgs](from-var-args.md) | `fun fromVarArgs(vararg parts: `[`CodeInstruction`](../-code-instruction.md)`): CodeSource`<br>Creates a immutable CodeSource with all elements of vararg [parts](from-var-args.md#com.github.jonathanxd.codeapi.CodeSource.Companion$fromVarArgs(kotlin.Array((com.github.jonathanxd.codeapi.CodeInstruction)))/parts). |

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
| [ArrayCodeSource](../-array-code-source/index.md) | `class ArrayCodeSource : CodeSource`<br>CodeSource is an iterable of [CodeInstructions](../-code-instruction.md). |
| [MutableCodeSource](../-mutable-code-source/index.md) | `abstract class MutableCodeSource : CodeSource, Cloneable`<br>A mutable CodeSource backing to a [ArrayList](http://docs.oracle.com/javase/6/docs/api/java/util/ArrayList.html) instead of to an [Array](#). |
