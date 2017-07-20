[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [InnerTypesHolder](.)

# InnerTypesHolder

`interface InnerTypesHolder : `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)

A holder of inner types

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `interface Builder<out T : InnerTypesHolder, S : `[`Builder`](-builder/index.md)`<T, S>> : `[`Builder`](../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<T, S>` |

### Properties

| Name | Summary |
|---|---|
| [innerTypes](inner-types.md) | `abstract val innerTypes: List<`[`TypeDeclaration`](../-type-declaration/index.md)`>`<br>Inner types |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `abstract fun builder(): `[`Builder`](-builder/index.md)`<InnerTypesHolder, *>`<br>This builder may or may not accept null values, it depends on implementation. |

### Extension Properties

| Name | Summary |
|---|---|
| [isPrimitive](../../com.github.jonathanxd.codeapi.util/is-primitive.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.isPrimitive: Boolean`<br>Returns true if the type of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is primitive |
| [type](../../com.github.jonathanxd.codeapi.util/type.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Gets the type of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [typeOrNull](../../com.github.jonathanxd.codeapi.util/type-or-null.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.typeOrNull: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Gets the type of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or null if receiver is not a [Typed](../-typed/index.md) instance. |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |

### Inheritors

| Name | Summary |
|---|---|
| [ElementsHolder](../-elements-holder/index.md) | `interface ElementsHolder : InnerTypesHolder` |
| [FieldDeclaration](../-field-declaration/index.md) | `data class FieldDeclaration : `[`CodeElement`](../../com.github.jonathanxd.codeapi/-code-element.md)`, `[`FieldBase`](../-field-base/index.md)`, `[`Named`](../-named/index.md)`, `[`Typed`](../-typed/index.md)`, `[`ValueHolder`](../-value-holder/index.md)`, `[`ModifiersHolder`](../-modifiers-holder/index.md)`, `[`Annotable`](../-annotable/index.md)`, `[`CommentHolder`](../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/index.md)`, InnerTypesHolder`<br>Declaration of a field. |
| [LocalCode](../-local-code/index.md) | `data class LocalCode : `[`CodeElement`](../../com.github.jonathanxd.codeapi/-code-element.md)`, `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`, `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`, InnerTypesHolder`<br>A local code (or local method). This code may be inlined or declared as method of current
type or translated to a lambda (for [InvokeDynamic.LambdaLocalCode](../-invoke-dynamic/-lambda-local-code/index.md)). |
| [MethodDeclarationBase](../-method-declaration-base/index.md) | `interface MethodDeclarationBase : `[`CodeElement`](../../com.github.jonathanxd.codeapi/-code-element.md)`, `[`ModifiersHolder`](../-modifiers-holder/index.md)`, `[`ReturnTypeHolder`](../-return-type-holder/index.md)`, `[`ParametersHolder`](../-parameters-holder/index.md)`, `[`GenericSignatureHolder`](../-generic-signature-holder/index.md)`, `[`Annotable`](../-annotable/index.md)`, `[`Named`](../-named/index.md)`, `[`Typed`](../-typed/index.md)`, `[`CommentHolder`](../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/index.md)`, `[`BodyHolder`](../-body-holder/index.md)`, InnerTypesHolder, `[`ThrowsHolder`](../-throws-holder/index.md)<br>Method declaration |
| [TypeDeclaration](../-type-declaration/index.md) | `interface TypeDeclaration : `[`ModifiersHolder`](../-modifiers-holder/index.md)`, `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`, `[`QualifiedNamed`](../-qualified-named/index.md)`, `[`GenericSignatureHolder`](../-generic-signature-holder/index.md)`, `[`Annotable`](../-annotable/index.md)`, `[`CommentHolder`](../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/index.md)`, InnerTypesHolder, `[`ElementsHolder`](../-elements-holder/index.md)<br>Base class of all [TypeDeclaration](../-type-declaration/index.md)s like classes, interfaces and enums, and inner classes. |
