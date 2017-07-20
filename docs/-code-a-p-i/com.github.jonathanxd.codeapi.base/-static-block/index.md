[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [StaticBlock](.)

# StaticBlock

`data class StaticBlock : `[`MethodDeclarationBase`](../-method-declaration-base/index.md)

Static block (aka class constructors/class initializers).

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `class Builder : `[`Builder`](../-method-declaration-base/-builder/index.md)`<StaticBlock, `[`Builder`](-builder/index.md)`>` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `StaticBlock(comments: `[`Comments`](../../com.github.jonathanxd.codeapi.base.comment/-comments/index.md)`, innerTypes: List<`[`TypeDeclaration`](../-type-declaration/index.md)`>, body: `[`CodeSource`](../../com.github.jonathanxd.codeapi/-code-source/index.md)`)`<br>Static block (aka class constructors/class initializers). |

### Properties

| Name | Summary |
|---|---|
| [annotations](annotations.md) | `val annotations: List<`[`Annotation`](../-annotation/index.md)`>`<br>Annotations |
| [body](body.md) | `val body: `[`CodeSource`](../../com.github.jonathanxd.codeapi/-code-source/index.md)<br>Body. |
| [comments](comments.md) | `val comments: `[`Comments`](../../com.github.jonathanxd.codeapi.base.comment/-comments/index.md)<br>All comments inside this holder. |
| [genericSignature](generic-signature.md) | `val genericSignature: `[`GenericSignature`](../../com.github.jonathanxd.codeapi.generic/-generic-signature/index.md)<br>Generic signature. |
| [innerTypes](inner-types.md) | `val innerTypes: List<`[`TypeDeclaration`](../-type-declaration/index.md)`>`<br>Inner types |
| [modifiers](modifiers.md) | `val modifiers: Set<`[`CodeModifier`](../-code-modifier/index.md)`>`<br>Modifiers. Empty modifier set is the same as public. For package private, an explicit
[CodeModifier.PACKAGE_PRIVATE](../-code-modifier/-p-a-c-k-a-g-e_-p-r-i-v-a-t-e.md) is required. |
| [name](name.md) | `val name: String`<br>Name |
| [parameters](parameters.md) | `val parameters: List<`[`CodeParameter`](../-code-parameter/index.md)`>`<br>Parameters |
| [returnType](return-type.md) | `val returnType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Type of return |
| [throwsClause](throws-clause.md) | `val throwsClause: List<`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`>`<br>Throws exception |

### Inherited Properties

| Name | Summary |
|---|---|
| [type](../-method-declaration-base/type.md) | `open val type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Element type |
| [typeSpec](../-method-declaration-base/type-spec.md) | `open val typeSpec: `[`TypeSpec`](../-type-spec/index.md) |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): `[`Builder`](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |

### Companion Object Properties

| Name | Summary |
|---|---|
| [MODIFIERS](-m-o-d-i-f-i-e-r-s.md) | `val MODIFIERS: <ERROR CLASS>` |
| [NAME](-n-a-m-e.md) | `val NAME: String` |
| [RETURN_TYPE](-r-e-t-u-r-n_-t-y-p-e.md) | `val RETURN_TYPE: `[`LoadedCodeType`](../../com.github.jonathanxd.codeapi.type/-loaded-code-type/index.md)`<`[`Void`](http://docs.oracle.com/javase/6/docs/api/java/lang/Void.html)`>` |

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
| [methodGenericSignature](../../com.github.jonathanxd.codeapi.util/method-generic-signature.md) | `fun `[`MethodDeclarationBase`](../-method-declaration-base/index.md)`.methodGenericSignature(): String?`<br>Creates method descriptor from receiver. |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
