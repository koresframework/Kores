[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi](index.md) / [CodeElement](.)

# CodeElement

`interface CodeElement : `[`CodePart`](-code-part/index.md)

Code elements like Field, Methods and static block.

### Inherited Functions

| Name | Summary |
|---|---|
| [builder](-code-part/builder.md) | `open fun builder(): `[`Builder`](../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<`[`CodePart`](-code-part/index.md)`, *>`<br>This builder may or may not accept null values, it depends on implementation. |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](-code-part/index.md) |
| [getPartType](../com.github.jonathanxd.codeapi.util/get-part-type.md) | `fun `[`CodePart`](-code-part/index.md)`.getPartType(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](-code-part/index.md) or throws [IllegalStateException](http://docs.oracle.com/javase/6/docs/api/java/lang/IllegalStateException.html) if [CodePart](-code-part/index.md) is not instance of [Typed](../com.github.jonathanxd.codeapi.base/-typed/index.md) |
| [getPartTypeOrNull](../com.github.jonathanxd.codeapi.util/get-part-type-or-null.md) | `fun `[`CodePart`](-code-part/index.md)`.getPartTypeOrNull(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](-code-part/index.md) or `null` if [CodePart](-code-part/index.md) is not instance of [Typed](../com.github.jonathanxd.codeapi.base/-typed/index.md). |
| [toLiteral](../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |

### Inheritors

| Name | Summary |
|---|---|
| [FieldDeclaration](../com.github.jonathanxd.codeapi.base/-field-declaration/index.md) | `data class FieldDeclaration : CodeElement, `[`FieldBase`](../com.github.jonathanxd.codeapi.base/-field-base/index.md)`, `[`Named`](../com.github.jonathanxd.codeapi.base/-named/index.md)`, `[`Typed`](../com.github.jonathanxd.codeapi.base/-typed/index.md)`, `[`ValueHolder`](../com.github.jonathanxd.codeapi.base/-value-holder/index.md)`, `[`ModifiersHolder`](../com.github.jonathanxd.codeapi.base/-modifiers-holder/index.md)`, `[`Annotable`](../com.github.jonathanxd.codeapi.base/-annotable/index.md)`, `[`CommentHolder`](../com.github.jonathanxd.codeapi.base.comment/-comment-holder/index.md)`, `[`CodeInstruction`](-code-instruction.md)`, `[`InnerTypesHolder`](../com.github.jonathanxd.codeapi.base/-inner-types-holder/index.md)<br>Declaration of a field. |
| [LocalCode](../com.github.jonathanxd.codeapi.base/-local-code/index.md) | `data class LocalCode : CodeElement, `[`CodePart`](-code-part/index.md)`, `[`CodeInstruction`](-code-instruction.md)`, `[`InnerTypesHolder`](../com.github.jonathanxd.codeapi.base/-inner-types-holder/index.md)<br>A local code (or local method). This code may be inlined or declared as method of current
type or translated to a lambda (for [InvokeDynamic.LambdaLocalCode](../com.github.jonathanxd.codeapi.base/-invoke-dynamic/-lambda-local-code/index.md)). |
| [MethodDeclarationBase](../com.github.jonathanxd.codeapi.base/-method-declaration-base/index.md) | `interface MethodDeclarationBase : CodeElement, `[`ModifiersHolder`](../com.github.jonathanxd.codeapi.base/-modifiers-holder/index.md)`, `[`ReturnTypeHolder`](../com.github.jonathanxd.codeapi.base/-return-type-holder/index.md)`, `[`ParametersHolder`](../com.github.jonathanxd.codeapi.base/-parameters-holder/index.md)`, `[`GenericSignatureHolder`](../com.github.jonathanxd.codeapi.base/-generic-signature-holder/index.md)`, `[`Annotable`](../com.github.jonathanxd.codeapi.base/-annotable/index.md)`, `[`Named`](../com.github.jonathanxd.codeapi.base/-named/index.md)`, `[`Typed`](../com.github.jonathanxd.codeapi.base/-typed/index.md)`, `[`CommentHolder`](../com.github.jonathanxd.codeapi.base.comment/-comment-holder/index.md)`, `[`BodyHolder`](../com.github.jonathanxd.codeapi.base/-body-holder/index.md)`, `[`InnerTypesHolder`](../com.github.jonathanxd.codeapi.base/-inner-types-holder/index.md)<br>Method declaration |
