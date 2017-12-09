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
| [MutableCodeSource](-mutable-code-source/index.md) | `abstract class MutableCodeSource : `[`CodeSource`](-code-source/index.md)`, `[`Cloneable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-cloneable/index.html)<br>A mutable [CodeSource](-code-source/index.md) backing to a [ArrayList](#) instead of to an [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html). |
| [Types](-types/index.md) | `object Types` |
