[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [MethodDeclarationBase](../index.md) / [Builder](.)

# Builder

`interface Builder<out T : `[`MethodDeclarationBase`](../index.md)`, S : Builder<T, S>> : `[`Builder`](../../-body-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-modifiers-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-return-type-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-parameters-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-generic-signature-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-annotable/-builder/index.md)`<T, S>, `[`Builder`](../../-named/-builder/index.md)`<T, S>, `[`Builder`](../../-typed/-builder/index.md)`<T, S>, `[`Builder`](../../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-inner-types-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-throws-holder/-builder/index.md)`<T, S>`

### Functions

| Name | Summary |
|---|---|
| [type](type.md) | `open fun type(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): S`<br>See [T.type](type.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [annotations](../../-annotable/-builder/annotations.md) | `open fun annotations(vararg values: `[`Annotation`](../../-annotation/index.md)`): S`<br>`abstract fun annotations(value: List<`[`Annotation`](../../-annotation/index.md)`>): S`<br>See [T.annotations](../../-annotable/-builder/annotations.md) |
| [body](../../-body-holder/-builder/body.md) | `abstract fun body(value: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md)`): S`<br>See [T.body](../../-body-holder/-builder/body.md) |
| [comments](../../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/-builder/comments.md) | `abstract fun comments(value: `[`Comments`](../../../com.github.jonathanxd.codeapi.base.comment/-comments/index.md)`): S`<br>See [T.comments](../../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/-builder/comments.md) |
| [genericSignature](../../-generic-signature-holder/-builder/generic-signature.md) | `abstract fun genericSignature(value: `[`GenericSignature`](../../../com.github.jonathanxd.codeapi.generic/-generic-signature/index.md)`): S`<br>See [T.genericSignature](../../-generic-signature-holder/-builder/generic-signature.md) |
| [innerTypes](../../-inner-types-holder/-builder/inner-types.md) | `open fun innerTypes(vararg values: `[`TypeDeclaration`](../../-type-declaration/index.md)`): S`<br>`abstract fun innerTypes(value: List<`[`TypeDeclaration`](../../-type-declaration/index.md)`>): S`<br>See [T.innerTypes](../../-inner-types-holder/-builder/inner-types.md) |
| [modifiers](../../-modifiers-holder/-builder/modifiers.md) | `open fun modifiers(vararg values: `[`CodeModifier`](../../-code-modifier/index.md)`): S`<br>`abstract fun modifiers(value: Set<`[`CodeModifier`](../../-code-modifier/index.md)`>): S`<br>See [ModifiersHolder.modifiers](../../-modifiers-holder/modifiers.md) |
| [name](../../-named/-builder/name.md) | `abstract fun name(value: String): S` |
| [parameters](../../-parameters-holder/-builder/parameters.md) | `open fun parameters(vararg values: `[`CodeParameter`](../../-code-parameter/index.md)`): S`<br>`abstract fun parameters(value: List<`[`CodeParameter`](../../-code-parameter/index.md)`>): S`<br>See [T.parameters](../../-parameters-holder/-builder/parameters.md) |
| [publicModifier](../../-modifiers-holder/-builder/public-modifier.md) | `open fun publicModifier(): S`<br>Sets modifiers to [CodeModifier.PUBLIC](../../-code-modifier/-p-u-b-l-i-c.md). Public modifier is optional, all
[ModifiersHolder](../../-modifiers-holder/index.md) which does not provide a modifier is public by default. |
| [returnType](../../-return-type-holder/-builder/return-type.md) | `abstract fun returnType(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): S`<br>See [T.returnType](../../-return-type-holder/-builder/return-type.md) |
| [throwsClause](../../-throws-holder/-builder/throws-clause.md) | `open fun throwsClause(vararg values: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): <ERROR CLASS>`<br>`abstract fun throwsClause(value: List<`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`>): S`<br>See [ThrowsHolder.throwsClause](../../-throws-holder/throws-clause.md) |

### Inheritors

| Name | Summary |
|---|---|
| [Builder](../../-constructor-declaration/-builder/index.md) | `class Builder : Builder<`[`ConstructorDeclaration`](../../-constructor-declaration/index.md)`, `[`Builder`](../../-constructor-declaration/-builder/index.md)`>` |
| [Builder](../../-static-block/-builder/index.md) | `class Builder : Builder<`[`StaticBlock`](../../-static-block/index.md)`, `[`Builder`](../../-static-block/-builder/index.md)`>` |
| [Builder](../../-method-declaration/-builder/index.md) | `class Builder : Builder<`[`MethodDeclaration`](../../-method-declaration/index.md)`, `[`Builder`](../../-method-declaration/-builder/index.md)`>` |
