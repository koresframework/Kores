[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [BodyHolder](.)

# BodyHolder

`interface BodyHolder : `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)

Holds a body. Example: method declarations, type declarations, static block, constructors...

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `interface Builder<out T : BodyHolder, S : `[`Builder`](-builder/index.md)`<T, S>> : `[`Builder`](../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<T, S>` |

### Properties

| Name | Summary |
|---|---|
| [body](body.md) | `abstract val body: `[`CodeSource`](../../com.github.jonathanxd.codeapi/-code-source/index.md)<br>Body. |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `abstract fun builder(): `[`Builder`](-builder/index.md)`<BodyHolder, *>`<br>This builder may or may not accept null values, it depends on implementation. |

### Companion Object Functions

| Name | Summary |
|---|---|
| [checkBody](check-body.md) | `fun checkBody(self: BodyHolder): Unit`<br>Validates the method body (avoid infinite recursion) |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [getPartType](../../com.github.jonathanxd.codeapi.util/get-part-type.md) | `fun `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.getPartType(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or throws [IllegalStateException](http://docs.oracle.com/javase/6/docs/api/java/lang/IllegalStateException.html) if [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is not instance of [Typed](../-typed/index.md) |
| [getPartTypeOrNull](../../com.github.jonathanxd.codeapi.util/get-part-type-or-null.md) | `fun `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.getPartTypeOrNull(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or `null` if [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is not instance of [Typed](../-typed/index.md). |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |

### Inheritors

| Name | Summary |
|---|---|
| [Case](../-case/index.md) | `data class Case : `[`ValueHolder`](../-value-holder/index.md)`, `[`Typed`](../-typed/index.md)`, BodyHolder`<br>Case statement of [SwitchStatement](../-switch-statement/index.md). |
| [CatchStatement](../-catch-statement/index.md) | `data class CatchStatement : BodyHolder, `[`Typed`](../-typed/index.md)<br>Catch statement of a try block. Catch [exceptionTypes](../-catch-statement/exception-types.md) and store caught exception in [variable](../-catch-statement/variable.md). |
| [ForEachStatement](../-for-each-statement/index.md) | `data class ForEachStatement : BodyHolder, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>For each statement. |
| [ForStatement](../-for-statement/index.md) | `data class ForStatement : `[`IfExpressionHolder`](../-if-expression-holder/index.md)`, BodyHolder, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>For statement. |
| [IfStatement](../-if-statement/index.md) | `data class IfStatement : `[`IfExpressionHolder`](../-if-expression-holder/index.md)`, BodyHolder, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>If statement. |
| [Label](../-label/index.md) | `data class Label : BodyHolder, `[`Named`](../-named/index.md)`, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Label. |
| [MethodDeclarationBase](../-method-declaration-base/index.md) | `interface MethodDeclarationBase : `[`CodeElement`](../../com.github.jonathanxd.codeapi/-code-element.md)`, `[`ModifiersHolder`](../-modifiers-holder/index.md)`, `[`ReturnTypeHolder`](../-return-type-holder/index.md)`, `[`ParametersHolder`](../-parameters-holder/index.md)`, `[`GenericSignatureHolder`](../-generic-signature-holder/index.md)`, `[`Annotable`](../-annotable/index.md)`, `[`Named`](../-named/index.md)`, `[`Typed`](../-typed/index.md)`, `[`CommentHolder`](../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/index.md)`, BodyHolder, `[`InnerTypesHolder`](../-inner-types-holder/index.md)<br>Method declaration |
| [Synchronized](../-synchronized/index.md) | `class Synchronized : BodyHolder, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>Synchronized statement. Locks resources to thread access. |
| [WhileStatement](../-while-statement/index.md) | `data class WhileStatement : `[`IfExpressionHolder`](../-if-expression-holder/index.md)`, BodyHolder, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)<br>While statement |
