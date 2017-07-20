[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [GenericSignatureHolder](.)

# GenericSignatureHolder

`interface GenericSignatureHolder : `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)

An element that supports [GenericSignature](../../com.github.jonathanxd.codeapi.generic/-generic-signature/index.md).

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `interface Builder<out T : GenericSignatureHolder, S : `[`Builder`](-builder/index.md)`<T, S>> : `[`Builder`](../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<T, S>` |

### Properties

| Name | Summary |
|---|---|
| [genericSignature](generic-signature.md) | `abstract val genericSignature: `[`GenericSignature`](../../com.github.jonathanxd.codeapi.generic/-generic-signature/index.md)<br>Generic signature. |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `abstract fun builder(): `[`Builder`](-builder/index.md)`<GenericSignatureHolder, *>`<br>This builder may or may not accept null values, it depends on implementation. |

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
| [MethodDeclarationBase](../-method-declaration-base/index.md) | `interface MethodDeclarationBase : `[`CodeElement`](../../com.github.jonathanxd.codeapi/-code-element.md)`, `[`ModifiersHolder`](../-modifiers-holder/index.md)`, `[`ReturnTypeHolder`](../-return-type-holder/index.md)`, `[`ParametersHolder`](../-parameters-holder/index.md)`, GenericSignatureHolder, `[`Annotable`](../-annotable/index.md)`, `[`Named`](../-named/index.md)`, `[`Typed`](../-typed/index.md)`, `[`CommentHolder`](../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/index.md)`, `[`BodyHolder`](../-body-holder/index.md)`, `[`InnerTypesHolder`](../-inner-types-holder/index.md)`, `[`ThrowsHolder`](../-throws-holder/index.md)<br>Method declaration |
| [TypeDeclaration](../-type-declaration/index.md) | `interface TypeDeclaration : `[`ModifiersHolder`](../-modifiers-holder/index.md)`, `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`, `[`QualifiedNamed`](../-qualified-named/index.md)`, GenericSignatureHolder, `[`Annotable`](../-annotable/index.md)`, `[`CommentHolder`](../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/index.md)`, `[`InnerTypesHolder`](../-inner-types-holder/index.md)`, `[`ElementsHolder`](../-elements-holder/index.md)<br>Base class of all [TypeDeclaration](../-type-declaration/index.md)s like classes, interfaces and enums, and inner classes. |
