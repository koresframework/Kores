[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi](../index.md) / [CodePart](.)

# CodePart

`interface CodePart : Any`

A CodePart is an element that can exists in the source code.

All interfaces that have a concrete implementation and extends CodePart must provide a
`builder` method that return a builder instance with defined default values.

### Types

| Name | Summary |
|---|---|
| [SelfBuilder](-self-builder/index.md) | `class SelfBuilder : `[`Builder`](../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<CodePart, `[`SelfBuilder`](-self-builder/index.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `open fun builder(): `[`Builder`](../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<CodePart, *>`<br>This builder may or may not accept null values, it depends on implementation. |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this CodePart |
| [getPartType](../../com.github.jonathanxd.codeapi.util/get-part-type.md) | `fun CodePart.getPartType(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of CodePart or throws [IllegalStateException](http://docs.oracle.com/javase/6/docs/api/java/lang/IllegalStateException.html) if CodePart is not instance of [Typed](../../com.github.jonathanxd.codeapi.base/-typed/index.md) |
| [getPartTypeOrNull](../../com.github.jonathanxd.codeapi.util/get-part-type-or-null.md) | `fun CodePart.getPartTypeOrNull(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of CodePart or `null` if CodePart is not instance of [Typed](../../com.github.jonathanxd.codeapi.base/-typed/index.md). |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |

### Inheritors

| Name | Summary |
|---|---|
| [Access](../../com.github.jonathanxd.codeapi.base/-access/index.md) | `enum class Access : Enum<`[`Access`](../../com.github.jonathanxd.codeapi.base/-access/index.md)`>, CodePart`<br>Access to a scope. Example, access to static scope of [String](#). |
| [Accessor](../../com.github.jonathanxd.codeapi.base/-accessor/index.md) | `interface Accessor : CodePart`<br>Accessor of an element. Example: field access/definition, method invocation
and executable code. |
| [Annotable](../../com.github.jonathanxd.codeapi.base/-annotable/index.md) | `interface Annotable : CodePart`<br>An part that hold annotations. |
| [ArgumentHolder](../../com.github.jonathanxd.codeapi.base/-argument-holder/index.md) | `interface ArgumentHolder : CodePart`<br>Hold arguments. |
| [ArrayAccess](../../com.github.jonathanxd.codeapi.base/-array-access/index.md) | `interface ArrayAccess : CodePart`<br>Access to an array. |
| [BodyHolder](../../com.github.jonathanxd.codeapi.base/-body-holder/index.md) | `interface BodyHolder : CodePart`<br>Holds a body. Example: method declarations, type declarations, static block, constructors... |
| [CodeElement](../-code-element.md) | `interface CodeElement : CodePart`<br>Code elements like Field, Methods and static block. |
| [CodeInstruction](../-code-instruction.md) | `interface CodeInstruction : CodePart`<br>A source instruction. |
| [CodeModifier](../../com.github.jonathanxd.codeapi.base/-code-modifier/index.md) | `enum class CodeModifier : Enum<`[`CodeModifier`](../../com.github.jonathanxd.codeapi.base/-code-modifier/index.md)`>, CodePart`<br>Modifiers enum. |
| [CodeSource](../-code-source/index.md) | `abstract class CodeSource : Iterable<`[`CodeInstruction`](../-code-instruction.md)`>, CodePart`<br>Abstract [CodeInstruction](../-code-instruction.md) iterable. |
| [CodeType](../../com.github.jonathanxd.codeapi.type/-code-type/index.md) | `interface CodeType : CodePart, Comparable<`[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`>, `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>A type representation, like: |
| [Comment](../../com.github.jonathanxd.codeapi.base.comment/-comment/index.md) | `interface Comment : CodePart`<br>Comment |
| [CommentHolder](../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/index.md) | `interface CommentHolder : CodePart`<br>Hold comments and documentation. |
| [Comments](../../com.github.jonathanxd.codeapi.base.comment/-comments/index.md) | `data class Comments : CodePart, `[`CodeInstruction`](../-code-instruction.md)<br>Hold a list of comments. |
| [Concat](../../com.github.jonathanxd.codeapi.base/-concat/index.md) | `data class Concat : CodePart, `[`Typed`](../../com.github.jonathanxd.codeapi.base/-typed/index.md)`, `[`CodeInstruction`](../-code-instruction.md)<br>String concatenation. The result depends on generator, in official BytecodeGenerator a [StringBuilder](http://docs.oracle.com/javase/6/docs/api/java/lang/StringBuilder.html) will be
used to concat values (in a future patch it will be changed to use Java 9 dynamic concatenation), in official
JavaSourceGenerator this will be translated into string concatenation. |
| [ControlFlow](../../com.github.jonathanxd.codeapi.base/-control-flow/index.md) | `data class ControlFlow : CodePart, `[`CodeInstruction`](../-code-instruction.md)<br>Control the flow of a statement. |
| [EntryHolder](../../com.github.jonathanxd.codeapi.base/-entry-holder/index.md) | `interface EntryHolder : CodePart`<br>Enum entry holder |
| [GenericSignatureHolder](../../com.github.jonathanxd.codeapi.base/-generic-signature-holder/index.md) | `interface GenericSignatureHolder : CodePart`<br>An element that supports [GenericSignature](../../com.github.jonathanxd.codeapi.generic/-generic-signature/index.md). |
| [IfExpr](../../com.github.jonathanxd.codeapi.base/-if-expr/index.md) | `data class IfExpr : CodePart, `[`CodeInstruction`](../-code-instruction.md)<br>Condition evaluation. |
| [IfExpressionHolder](../../com.github.jonathanxd.codeapi.base/-if-expression-holder/index.md) | `interface IfExpressionHolder : CodePart`<br>A element that holds [IfExpressions](../../com.github.jonathanxd.codeapi.base/-if-expr/index.md) and [Operations](../../com.github.jonathanxd.codeapi.operator/-operators/index.md). |
| [IfGroup](../../com.github.jonathanxd.codeapi.base/-if-group/index.md) | `data class IfGroup : CodePart, `[`IfExpressionHolder`](../../com.github.jonathanxd.codeapi.base/-if-expression-holder/index.md)`, `[`CodeInstruction`](../-code-instruction.md)<br>Group of if expressions. |
| [ImplementationHolder](../../com.github.jonathanxd.codeapi.base/-implementation-holder/index.md) | `interface ImplementationHolder : CodePart`<br>An implementation holder |
| [InnerTypesHolder](../../com.github.jonathanxd.codeapi.base/-inner-types-holder/index.md) | `interface InnerTypesHolder : CodePart`<br>A holder of inner types |
| [LocalCode](../../com.github.jonathanxd.codeapi.base/-local-code/index.md) | `data class LocalCode : `[`CodeElement`](../-code-element.md)`, CodePart, `[`CodeInstruction`](../-code-instruction.md)`, `[`InnerTypesHolder`](../../com.github.jonathanxd.codeapi.base/-inner-types-holder/index.md)<br>A local code (or local method). This code may be inlined or declared as method of current
type or translated to a lambda (for [InvokeDynamic.LambdaLocalCode](../../com.github.jonathanxd.codeapi.base/-invoke-dynamic/-lambda-local-code/index.md)). |
| [ModifiersHolder](../../com.github.jonathanxd.codeapi.base/-modifiers-holder/index.md) | `interface ModifiersHolder : CodePart`<br>A element that have modifiers. |
| [Named](../../com.github.jonathanxd.codeapi.base/-named/index.md) | `interface Named : CodePart`<br>A element that have a name. |
| [New](../../com.github.jonathanxd.codeapi.base/-new/index.md) | `data class New : CodePart, `[`CodeInstruction`](../-code-instruction.md)<br>Represents the construction of type, used to invoke constructor methods. (not `super` constructor or `this` constructor). |
| [Operator](../../com.github.jonathanxd.codeapi.operator/-operator/index.md) | `sealed class Operator : CodePart, `[`Named`](../../com.github.jonathanxd.codeapi.base/-named/index.md)<br>Operator. |
| [ParametersHolder](../../com.github.jonathanxd.codeapi.base/-parameters-holder/index.md) | `interface ParametersHolder : CodePart`<br>Parameter holder |
| [ReturnTypeHolder](../../com.github.jonathanxd.codeapi.base/-return-type-holder/index.md) | `interface ReturnTypeHolder : CodePart`<br>Return type holder part |
| [SuperClassHolder](../../com.github.jonathanxd.codeapi.base/-super-class-holder/index.md) | `interface SuperClassHolder : CodePart`<br>Super class holder |
| [ThrowException](../../com.github.jonathanxd.codeapi.base/-throw-exception/index.md) | `data class ThrowException : CodePart, `[`CodeInstruction`](../-code-instruction.md)<br>Throws [partToThrow](../../com.github.jonathanxd.codeapi.base/-throw-exception/part-to-throw.md). |
| [Typed](../../com.github.jonathanxd.codeapi.base/-typed/index.md) | `interface Typed : CodePart`<br>A element that can have a type. |
| [ValueHolder](../../com.github.jonathanxd.codeapi.base/-value-holder/index.md) | `interface ValueHolder : CodePart`<br>Value holder part |
