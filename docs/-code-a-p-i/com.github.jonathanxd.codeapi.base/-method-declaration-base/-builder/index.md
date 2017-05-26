[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [MethodDeclarationBase](../index.md) / [Builder](.)

# Builder

`interface Builder<out T : `[`MethodDeclarationBase`](../index.md)`, S : Builder<T, S>> : `[`Builder`](../../-body-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-modifiers-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-return-type-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-parameters-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-generic-signature-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-annotable/-builder/index.md)`<T, S>, `[`Builder`](../../-named/-builder/index.md)`<T, S>, `[`Builder`](../../-typed/-builder/index.md)`<T, S>, `[`Builder`](../../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-inner-types-holder/-builder/index.md)`<T, S>`

### Functions

| Name | Summary |
|---|---|
| [withType](with-type.md) | `open fun withType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): S`<br>See [T.type](../type.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [withAnnotations](../../-annotable/-builder/with-annotations.md) | `abstract fun withAnnotations(value: List<`[`Annotation`](../../-annotation/index.md)`>): S`<br>`open fun withAnnotations(vararg values: `[`Annotation`](../../-annotation/index.md)`): S`<br>See [T.annotations](../../-annotable/annotations.md) |
| [withBody](../../-body-holder/-builder/with-body.md) | `abstract fun withBody(value: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md)`): S`<br>See [T.body](../../-body-holder/body.md) |
| [withComments](../../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/-builder/with-comments.md) | `abstract fun withComments(value: `[`Comments`](../../../com.github.jonathanxd.codeapi.base.comment/-comments/index.md)`): S`<br>See [T.comments](../../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/comments.md) |
| [withGenericSignature](../../-generic-signature-holder/-builder/with-generic-signature.md) | `abstract fun withGenericSignature(value: `[`GenericSignature`](../../../com.github.jonathanxd.codeapi.generic/-generic-signature/index.md)`): S`<br>See [T.genericSignature](../../-generic-signature-holder/generic-signature.md) |
| [withInnerTypes](../../-inner-types-holder/-builder/with-inner-types.md) | `abstract fun withInnerTypes(value: List<`[`TypeDeclaration`](../../-type-declaration/index.md)`>): S`<br>`open fun withInnerTypes(vararg values: `[`TypeDeclaration`](../../-type-declaration/index.md)`): S`<br>See [T.innerTypes](../../-inner-types-holder/inner-types.md) |
| [withModifiers](../../-modifiers-holder/-builder/with-modifiers.md) | `abstract fun withModifiers(value: Set<`[`CodeModifier`](../../-code-modifier/index.md)`>): S`<br>`open fun withModifiers(vararg values: `[`CodeModifier`](../../-code-modifier/index.md)`): S`<br>See [ModifiersHolder.modifiers](../../-modifiers-holder/modifiers.md) |
| [withName](../../-named/-builder/with-name.md) | `abstract fun withName(value: String): S` |
| [withParameters](../../-parameters-holder/-builder/with-parameters.md) | `open fun withParameters(vararg values: `[`CodeParameter`](../../-code-parameter/index.md)`): S`<br>`abstract fun withParameters(value: List<`[`CodeParameter`](../../-code-parameter/index.md)`>): S`<br>See [T.parameters](../../-parameters-holder/parameters.md) |
| [withPublicModifier](../../-modifiers-holder/-builder/with-public-modifier.md) | `open fun withPublicModifier(): S`<br>Sets modifiers to [CodeModifier.PUBLIC](../../-code-modifier/-p-u-b-l-i-c.md). Public modifier is optional, all
[ModifiersHolder](../../-modifiers-holder/index.md) which does not provide a modifier is public by default. |
| [withReturnType](../../-return-type-holder/-builder/with-return-type.md) | `abstract fun withReturnType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): S`<br>See [T.returnType](../../-return-type-holder/return-type.md) |

### Inheritors

| Name | Summary |
|---|---|
| [Builder](../../-constructor-declaration/-builder/index.md) | `class Builder : Builder<`[`ConstructorDeclaration`](../../-constructor-declaration/index.md)`, `[`Builder`](../../-constructor-declaration/-builder/index.md)`>` |
| [Builder](../../-static-block/-builder/index.md) | `class Builder : Builder<`[`StaticBlock`](../../-static-block/index.md)`, `[`Builder`](../../-static-block/-builder/index.md)`>` |
| [Builder](../../-method-declaration/-builder/index.md) | `class Builder : Builder<`[`MethodDeclaration`](../../-method-declaration/index.md)`, `[`Builder`](../../-method-declaration/-builder/index.md)`>` |
