[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi](.)

## Package com.github.jonathanxd.codeapi

### Types

| Name | Summary |
|---|---|
| [ArrayCodeSource](-array-code-source/index.md) | `class ArrayCodeSource : `[`CodeSource`](-code-source/index.md)<br>CodeSource is an iterable of [CodeInstructions](-code-instruction.md). |
| [CodeAPI](-code-a-p-i/index.md) | `class CodeAPI`<br>CodeAPI-Base is the base module of CodeAPI which contains base classes of CodeAPI. |
| [CodeElement](-code-element.md) | `interface CodeElement : `[`CodePart`](-code-part/index.md)<br>Code elements like Field, Methods and static block. |
| [CodeInstruction](-code-instruction.md) | `interface CodeInstruction : `[`CodePart`](-code-part/index.md)<br>A source instruction. |
| [CodePart](-code-part/index.md) | `interface CodePart`<br>A CodePart is an element that can exists in the source code. |
| [CodeSource](-code-source/index.md) | `abstract class CodeSource : `[`Iterable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)`<`[`CodeInstruction`](-code-instruction.md)`>, `[`CodePart`](-code-part/index.md)<br>Abstract [CodeInstruction](-code-instruction.md) iterable. |
| [CodeSourceView](-code-source-view/index.md) | `open class CodeSourceView : `[`MutableCodeSource`](-mutable-code-source/index.md) |
| [Defaults](-defaults/index.md) | `object Defaults`<br>Common default constant base values |
| [ListCodeSource](-list-code-source/index.md) | `class ListCodeSource : `[`MutableCodeSource`](-mutable-code-source/index.md)`, `[`Cloneable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-cloneable/index.html)<br>A [MutableCodeSource](-mutable-code-source/index.md) backing to a [ArrayList](#). |
| [Location](-location/index.md) | `enum class Location`<br>Location to insert element. |
| [MutableCodeSource](-mutable-code-source/index.md) | `abstract class MutableCodeSource : `[`CodeSource`](-code-source/index.md)`, `[`Cloneable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-cloneable/index.html)<br>A mutable [CodeSource](-code-source/index.md) backing to a [ArrayList](#) instead of to an [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html). |
| [Types](-types/index.md) | `object Types` |

### Properties

| Name | Summary |
|---|---|
| [isPrimitive](is-primitive.md) | `val `[`CodePart`](-code-part/index.md)`.isPrimitive: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if the type of this [CodePart](-code-part/index.md) is primitive |
| [safeForComparison](safe-for-comparison.md) | `val `[`CodeInstruction`](-code-instruction.md)`.safeForComparison: `[`CodeInstruction`](-code-instruction.md)<br>Gets comparison safe version of a [CodeInstruction](-code-instruction.md) |
| [type](type.md) | `val `[`CodePart`](-code-part/index.md)`.type: Type`<br>Gets the type of [CodePart](-code-part/index.md) |
| [typeOrNull](type-or-null.md) | `val `[`CodePart`](-code-part/index.md)`.typeOrNull: Type?`<br>Gets the type of [CodePart](-code-part/index.md) or null if receiver is not a [Typed](../com.github.jonathanxd.codeapi.base/-typed/index.md) instance. |

### Functions

| Name | Summary |
|---|---|
| [find](find.md) | `fun <U> `[`CodeSource`](-code-source/index.md)`.find(predicate: (`[`CodeInstruction`](-code-instruction.md)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, function: (`[`CodeInstruction`](-code-instruction.md)`) -> U): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<U>`<br>Find an element in a code source. (Highly recommended to use [SourceInspect](../com.github.jonathanxd.codeapi.inspect/-source-inspect/index.md) instead of this. |
| [getLeaveType](get-leave-type.md) | `fun `[`CodeSource`](-code-source/index.md)`.getLeaveType(): Type?`<br>Returns the type that this [CodeSource](-code-source/index.md) leaves on stack.`fun `[`CodeInstruction`](-code-instruction.md)`.getLeaveType(): Type?`<br>Returns the type leaved in stack by this [CodeInstruction](-code-instruction.md) |
| [insertAfter](insert-after.md) | `fun `[`CodeSource`](-code-source/index.md)`.insertAfter(predicate: (`[`CodeInstruction`](-code-instruction.md)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, toInsert: `[`CodeSource`](-code-source/index.md)`): `[`MutableCodeSource`](-mutable-code-source/index.md)<br>Insert element `toInsert` in `source` after element determined by `predicate` |
| [insertAfterOrEnd](insert-after-or-end.md) | `fun `[`CodeSource`](-code-source/index.md)`.insertAfterOrEnd(predicate: (`[`CodeInstruction`](-code-instruction.md)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, toInsert: `[`CodeSource`](-code-source/index.md)`): `[`MutableCodeSource`](-mutable-code-source/index.md)<br>Insert element `toInsert` in `source` after element determined by `predicate` or at end of source if not found. |
| [insertAfterOrStart](insert-after-or-start.md) | `fun `[`CodeSource`](-code-source/index.md)`.insertAfterOrStart(predicate: (`[`CodeInstruction`](-code-instruction.md)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, toInsert: `[`CodeSource`](-code-source/index.md)`): `[`MutableCodeSource`](-mutable-code-source/index.md)<br>Insert element `toInsert` in `source` after element determined by `predicate` or at start of source if not found. |
| [insertBefore](insert-before.md) | `fun `[`CodeSource`](-code-source/index.md)`.insertBefore(predicate: (`[`CodeInstruction`](-code-instruction.md)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, toInsert: `[`CodeSource`](-code-source/index.md)`): `[`MutableCodeSource`](-mutable-code-source/index.md)<br>Insert element `toInsert` in `source` before element determined by `predicate` |
| [insertBeforeOrEnd](insert-before-or-end.md) | `fun `[`CodeSource`](-code-source/index.md)`.insertBeforeOrEnd(predicate: (`[`CodeInstruction`](-code-instruction.md)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, toInsert: `[`CodeSource`](-code-source/index.md)`): `[`MutableCodeSource`](-mutable-code-source/index.md)<br>Insert element `toInsert` in `source` before element determined by `predicate` or at end of source if not found. |
| [insertBeforeOrStart](insert-before-or-start.md) | `fun `[`CodeSource`](-code-source/index.md)`.insertBeforeOrStart(predicate: (`[`CodeInstruction`](-code-instruction.md)`) -> `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, toInsert: `[`CodeSource`](-code-source/index.md)`): `[`MutableCodeSource`](-mutable-code-source/index.md)<br>Insert element `toInsert` in `source` before element determined by `predicate` or at start of source if not found. |
| [unwrap](unwrap.md) | `tailrec fun `[`CodeInstruction`](-code-instruction.md)`.unwrap(): `[`CodeInstruction`](-code-instruction.md)<br>Unwraps [CodeInstruction](-code-instruction.md) if is a [InstructionWrapper](#) or return receiver if not. |
| [visit](visit.md) | `fun `[`CodeSource`](-code-source/index.md)`.visit(consumer: (`[`CodeInstruction`](-code-instruction.md)`, `[`Location`](-location/index.md)`, `[`MutableCodeSource`](-mutable-code-source/index.md)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`MutableCodeSource`](-mutable-code-source/index.md)<br>Visit Code Source elements. |
