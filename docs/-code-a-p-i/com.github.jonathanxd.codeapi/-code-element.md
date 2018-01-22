[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi](index.md) / [CodeElement](.)

# CodeElement

`interface CodeElement : `[`CodePart`](-code-part/index.md)

Code elements like Field, Methods and static block.

### Inherited Functions

| Name | Summary |
|---|---|
| [builder](-code-part/builder.md) | `open fun builder(): `[`Builder`](../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<`[`CodePart`](-code-part/index.md)`, *>`<br>This builder may or may not accept null values, it depends on implementation. |

### Extension Properties

| Name | Summary |
|---|---|
| [isPrimitive](is-primitive.md) | `val `[`CodePart`](-code-part/index.md)`.isPrimitive: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if the type of this [CodePart](-code-part/index.md) is primitive |
| [type](type.md) | `val `[`CodePart`](-code-part/index.md)`.type: Type`<br>Gets the type of [CodePart](-code-part/index.md) |
| [typeOrNull](type-or-null.md) | `val `[`CodePart`](-code-part/index.md)`.typeOrNull: Type?`<br>Gets the type of [CodePart](-code-part/index.md) or null if receiver is not a [Typed](../com.github.jonathanxd.codeapi.base/-typed/index.md) instance. |

### Extension Functions

| Name | Summary |
|---|---|
| [annotationValue](../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/annotation-value.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.annotationValue(rType: Class<*>): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) |
| [asString](../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?.asString(simple: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Create a String representation of the part of this [CodePart](-code-part/index.md) |
| [toLiteral](../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteral(): `[`Literal`](../com.github.jonathanxd.codeapi.literal/-literal/index.md)<br>Convert this value to a literal |
| [toLiteralOrNull](../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal-or-null.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteralOrNull(): `[`Literal`](../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |

### Inheritors

| Name | Summary |
|---|---|
| [FieldDeclaration](../com.github.jonathanxd.codeapi.base/-field-declaration/index.md) | `data class FieldDeclaration : CodeElement, `[`FieldBase`](../com.github.jonathanxd.codeapi.base/-field-base/index.md)`, `[`Named`](../com.github.jonathanxd.codeapi.base/-named/index.md)`, `[`Typed`](../com.github.jonathanxd.codeapi.base/-typed/index.md)`, `[`ValueHolder`](../com.github.jonathanxd.codeapi.base/-value-holder/index.md)`, `[`ModifiersHolder`](../com.github.jonathanxd.codeapi.base/-modifiers-holder/index.md)`, `[`Annotable`](../com.github.jonathanxd.codeapi.base/-annotable/index.md)`, `[`CommentHolder`](../com.github.jonathanxd.codeapi.base.comment/-comment-holder/index.md)`, `[`InnerTypesHolder`](../com.github.jonathanxd.codeapi.base/-inner-types-holder/index.md)<br>Declaration of a field. |
| [LocalCode](../com.github.jonathanxd.codeapi.base/-local-code/index.md) | `data class LocalCode : CodeElement, `[`CodePart`](-code-part/index.md)`, `[`CodeInstruction`](-code-instruction.md)`, `[`InnerTypesHolder`](../com.github.jonathanxd.codeapi.base/-inner-types-holder/index.md)<br>A local code (or local method). This code may be inlined or declared as method of current type or translated to a lambda (for [InvokeDynamic.LambdaLocalCode](../com.github.jonathanxd.codeapi.base/-invoke-dynamic/-lambda-local-code/index.md)). |
| [MethodDeclarationBase](../com.github.jonathanxd.codeapi.base/-method-declaration-base/index.md) | `interface MethodDeclarationBase : CodeElement, `[`ModifiersHolder`](../com.github.jonathanxd.codeapi.base/-modifiers-holder/index.md)`, `[`ReturnTypeHolder`](../com.github.jonathanxd.codeapi.base/-return-type-holder/index.md)`, `[`ParametersHolder`](../com.github.jonathanxd.codeapi.base/-parameters-holder/index.md)`, `[`GenericSignatureHolder`](../com.github.jonathanxd.codeapi.base/-generic-signature-holder/index.md)`, `[`Annotable`](../com.github.jonathanxd.codeapi.base/-annotable/index.md)`, `[`Named`](../com.github.jonathanxd.codeapi.base/-named/index.md)`, `[`Typed`](../com.github.jonathanxd.codeapi.base/-typed/index.md)`, `[`CommentHolder`](../com.github.jonathanxd.codeapi.base.comment/-comment-holder/index.md)`, `[`BodyHolder`](../com.github.jonathanxd.codeapi.base/-body-holder/index.md)`, `[`InnerTypesHolder`](../com.github.jonathanxd.codeapi.base/-inner-types-holder/index.md)`, `[`ThrowsHolder`](../com.github.jonathanxd.codeapi.base/-throws-holder/index.md)<br>Method declaration |
