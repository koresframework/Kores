[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [MethodDeclarationBase](../index.md) / [Builder](.)

# Builder

`interface Builder<out T : `[`MethodDeclarationBase`](../index.md)`, S : Builder<T, S>> : `[`Builder`](../../-body-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-modifiers-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-return-type-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-parameters-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-generic-signature-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-annotable/-builder/index.md)`<T, S>, `[`Builder`](../../-named/-builder/index.md)`<T, S>, `[`Builder`](../../-typed/-builder/index.md)`<T, S>, `[`Builder`](../../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-inner-types-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-throws-holder/-builder/index.md)`<T, S>`

### Functions

| Name | Summary |
|---|---|
| [type](type.md) | `open fun type(value: Type): S`<br>See [T.type](type.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [annotations](../../-annotable/-builder/annotations.md) | `abstract fun annotations(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Annotation`](../../-annotation/index.md)`>): S`<br>`open fun annotations(vararg values: `[`Annotation`](../../-annotation/index.md)`): S`<br>See [T.annotations](../../-annotable/-builder/annotations.md) |
| [body](../../-body-holder/-builder/body.md) | `abstract fun body(value: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md)`): S`<br>See [T.body](../../-body-holder/-builder/body.md) |
| [comments](../../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/-builder/comments.md) | `abstract fun comments(value: `[`Comments`](../../../com.github.jonathanxd.codeapi.base.comment/-comments/index.md)`): S`<br>See [T.comments](../../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/-builder/comments.md) |
| [genericSignature](../../-generic-signature-holder/-builder/generic-signature.md) | `abstract fun genericSignature(value: `[`GenericSignature`](../../../com.github.jonathanxd.codeapi.generic/-generic-signature/index.md)`): S`<br>See [T.genericSignature](../../-generic-signature-holder/-builder/generic-signature.md) |
| [innerTypes](../../-inner-types-holder/-builder/inner-types.md) | `abstract fun innerTypes(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`TypeDeclaration`](../../-type-declaration/index.md)`>): S`<br>`open fun innerTypes(vararg values: `[`TypeDeclaration`](../../-type-declaration/index.md)`): S`<br>See [InnerTypesHolder.innerTypes](../../-inner-types-holder/inner-types.md) |
| [modifiers](../../-modifiers-holder/-builder/modifiers.md) | `open fun modifiers(vararg values: `[`CodeModifier`](../../-code-modifier/index.md)`): S`<br>`abstract fun modifiers(value: `[`Set`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)`<`[`CodeModifier`](../../-code-modifier/index.md)`>): S`<br>See [ModifiersHolder.modifiers](../../-modifiers-holder/modifiers.md) |
| [name](../../-named/-builder/name.md) | `abstract fun name(value: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): S` |
| [parameters](../../-parameters-holder/-builder/parameters.md) | `abstract fun parameters(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeParameter`](../../-code-parameter/index.md)`>): S`<br>`open fun parameters(vararg values: `[`CodeParameter`](../../-code-parameter/index.md)`): S`<br>See [T.parameters](../../-parameters-holder/-builder/parameters.md) |
| [publicModifier](../../-modifiers-holder/-builder/public-modifier.md) | `open fun publicModifier(): S`<br>Sets modifiers to [CodeModifier.PUBLIC](../../-code-modifier/-p-u-b-l-i-c.md). Public modifier is optional, all [ModifiersHolder](../../-modifiers-holder/index.md) which does not provide a modifier is public by default. |
| [returnType](../../-return-type-holder/-builder/return-type.md) | `abstract fun returnType(value: Type): S`<br>See [T.returnType](../../-return-type-holder/-builder/return-type.md) |
| [throwsClause](../../-throws-holder/-builder/throws-clause.md) | `abstract fun throwsClause(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Type>): S`<br>`open fun throwsClause(vararg values: Type): S`<br>See [ThrowsHolder.throwsClause](../../-throws-holder/throws-clause.md) |

### Inheritors

| Name | Summary |
|---|---|
| [Builder](../../-constructor-declaration/-builder/index.md) | `class Builder : Builder<`[`ConstructorDeclaration`](../../-constructor-declaration/index.md)`, `[`Builder`](../../-constructor-declaration/-builder/index.md)`>` |
| [Builder](../../-method-declaration/-builder/index.md) | `class Builder : Builder<`[`MethodDeclaration`](../../-method-declaration/index.md)`, `[`Builder`](../../-method-declaration/-builder/index.md)`>` |
| [Builder](../../-static-block/-builder/index.md) | `class Builder : Builder<`[`StaticBlock`](../../-static-block/index.md)`, `[`Builder`](../../-static-block/-builder/index.md)`>` |
