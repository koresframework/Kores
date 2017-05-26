[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi](.)

## Package com.github.jonathanxd.codeapi

### Types

| Name | Summary |
|---|---|
| [ArrayCodeSource](-array-code-source/index.md) | `class ArrayCodeSource : `[`CodeSource`](-code-source/index.md)<br>CodeSource is an iterable of [CodeInstructions](-code-instruction.md). |
| [CodeAPI](-code-a-p-i/index.md) | `class CodeAPI : Any`<br>CodeAPI-Base is the base module of CodeAPI which contains base classes of CodeAPI. |
| [CodeElement](-code-element.md) | `interface CodeElement : `[`CodePart`](-code-part/index.md)<br>Code elements like Field, Methods and static block. |
| [CodeInstruction](-code-instruction.md) | `interface CodeInstruction : `[`CodePart`](-code-part/index.md)<br>A source instruction. |
| [CodePart](-code-part/index.md) | `interface CodePart : Any`<br>A CodePart is an element that can exists in the source code. |
| [CodeSource](-code-source/index.md) | `abstract class CodeSource : Iterable<`[`CodeInstruction`](-code-instruction.md)`>, `[`CodePart`](-code-part/index.md)<br>Abstract [CodeInstruction](-code-instruction.md) iterable. |
| [CodeSourceView](-code-source-view/index.md) | `open class CodeSourceView : `[`MutableCodeSource`](-mutable-code-source/index.md) |
| [Defaults](-defaults/index.md) | `object Defaults : Any`<br>Common default constant base values |
| [ListCodeSource](-list-code-source/index.md) | `class ListCodeSource : `[`MutableCodeSource`](-mutable-code-source/index.md)`, Cloneable`<br>A [MutableCodeSource](-mutable-code-source/index.md) backing to a [ArrayList](http://docs.oracle.com/javase/6/docs/api/java/util/ArrayList.html). |
| [MutableCodeSource](-mutable-code-source/index.md) | `abstract class MutableCodeSource : `[`CodeSource`](-code-source/index.md)`, Cloneable`<br>A mutable [CodeSource](-code-source/index.md) backing to a [ArrayList](http://docs.oracle.com/javase/6/docs/api/java/util/ArrayList.html) instead of to an [Array](#). |
| [Types](-types/index.md) | `object Types : Any` |
