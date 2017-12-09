[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [MethodDeclarationBase](.)

# MethodDeclarationBase

`interface MethodDeclarationBase : `[`CodeElement`](../../com.github.jonathanxd.codeapi/-code-element.md)`, `[`ModifiersHolder`](../-modifiers-holder/index.md)`, `[`ReturnTypeHolder`](../-return-type-holder/index.md)`, `[`ParametersHolder`](../-parameters-holder/index.md)`, `[`GenericSignatureHolder`](../-generic-signature-holder/index.md)`, `[`Annotable`](../-annotable/index.md)`, `[`Named`](../-named/index.md)`, `[`Typed`](../-typed/index.md)`, `[`CommentHolder`](../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/index.md)`, `[`BodyHolder`](../-body-holder/index.md)`, `[`InnerTypesHolder`](../-inner-types-holder/index.md)`, `[`ThrowsHolder`](../-throws-holder/index.md)

Method declaration

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `interface Builder<out T : MethodDeclarationBase, S : `[`Builder`](-builder/index.md)`<T, S>> : `[`Builder`](../-body-holder/-builder/index.md)`<T, S>, `[`Builder`](../-modifiers-holder/-builder/index.md)`<T, S>, `[`Builder`](../-return-type-holder/-builder/index.md)`<T, S>, `[`Builder`](../-parameters-holder/-builder/index.md)`<T, S>, `[`Builder`](../-generic-signature-holder/-builder/index.md)`<T, S>, `[`Builder`](../-annotable/-builder/index.md)`<T, S>, `[`Builder`](../-named/-builder/index.md)`<T, S>, `[`Builder`](../-typed/-builder/index.md)`<T, S>, `[`Builder`](../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/-builder/index.md)`<T, S>, `[`Builder`](../-inner-types-holder/-builder/index.md)`<T, S>, `[`Builder`](../-throws-holder/-builder/index.md)`<T, S>` |

### Properties

| Name | Summary |
|---|---|
| [returnType](return-type.md) | `abstract val returnType: Type`<br>Type of return |
| [type](type.md) | `open val type: Type`<br>Element type |
| [typeSpec](type-spec.md) | `open val typeSpec: `[`TypeSpec`](../-type-spec/index.md) |

### Inherited Properties

| Name | Summary |
|---|---|
| [annotations](../-annotable/annotations.md) | `abstract val annotations: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Annotation`](../-annotation/index.md)`>`<br>Annotations |
| [body](../-body-holder/body.md) | `abstract val body: `[`CodeSource`](../../com.github.jonathanxd.codeapi/-code-source/index.md)<br>Body. |
| [comments](../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/comments.md) | `abstract val comments: `[`Comments`](../../com.github.jonathanxd.codeapi.base.comment/-comments/index.md)<br>All comments inside this holder. |
| [genericSignature](../-generic-signature-holder/generic-signature.md) | `abstract val genericSignature: `[`GenericSignature`](../../com.github.jonathanxd.codeapi.generic/-generic-signature/index.md)<br>Generic signature. |
| [innerTypes](../-inner-types-holder/inner-types.md) | `abstract val innerTypes: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`TypeDeclaration`](../-type-declaration/index.md)`>`<br>Inner types |
| [isPublic](../-modifiers-holder/is-public.md) | `open val isPublic: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if this part is public. |
| [modifiers](../-modifiers-holder/modifiers.md) | `abstract val modifiers: `[`Set`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)`<`[`CodeModifier`](../-code-modifier/index.md)`>`<br>Modifiers. Empty modifier set is the same as public. For package private, an explicit [CodeModifier.PACKAGE_PRIVATE](../-code-modifier/-p-a-c-k-a-g-e_-p-r-i-v-a-t-e.md) is required. |
| [name](../-named/name.md) | `abstract val name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Name |
| [parameters](../-parameters-holder/parameters.md) | `abstract val parameters: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeParameter`](../-code-parameter/index.md)`>`<br>Parameters |
| [throwsClause](../-throws-holder/throws-clause.md) | `abstract val throwsClause: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Type>`<br>Throws exception |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `abstract fun builder(): `[`Builder`](-builder/index.md)`<MethodDeclarationBase, *>`<br>This builder may or may not accept null values, it depends on implementation. |

### Extension Properties

| Name | Summary |
|---|---|
| [isPrimitive](../../com.github.jonathanxd.codeapi.util/is-primitive.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.isPrimitive: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if the type of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is primitive |
| [type](../../com.github.jonathanxd.codeapi.util/type.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.type: Type`<br>Gets the type of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [typeOrNull](../../com.github.jonathanxd.codeapi.util/type-or-null.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.typeOrNull: Type?`<br>Gets the type of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or null if receiver is not a [Typed](../-typed/index.md) instance. |

### Extension Functions

| Name | Summary |
|---|---|
| [annotationValue](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/annotation-value.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.annotationValue(rType: Class<*>): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) |
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?.asString(simple: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [methodGenericSignature](../../com.github.jonathanxd.codeapi.util/method-generic-signature.md) | `fun MethodDeclarationBase.methodGenericSignature(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`<br>Creates method descriptor from receiver. |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)<br>Convert this value to a literal |
| [toLiteralOrNull](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal-or-null.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteralOrNull(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |

### Inheritors

| Name | Summary |
|---|---|
| [ConstructorDeclaration](../-constructor-declaration/index.md) | `data class ConstructorDeclaration : MethodDeclarationBase`<br>Instance constructor declaration. |
| [MethodDeclaration](../-method-declaration/index.md) | `data class MethodDeclaration : MethodDeclarationBase`<br>Method declaration |
| [StaticBlock](../-static-block/index.md) | `data class StaticBlock : MethodDeclarationBase`<br>Static block (aka class constructors/class initializers). |
