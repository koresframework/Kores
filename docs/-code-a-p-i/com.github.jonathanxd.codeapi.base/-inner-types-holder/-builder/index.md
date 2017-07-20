[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [InnerTypesHolder](../index.md) / [Builder](.)

# Builder

`interface Builder<out T : `[`InnerTypesHolder`](../index.md)`, S : Builder<T, S>> : `[`Builder`](../../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<T, S>`

### Functions

| Name | Summary |
|---|---|
| [innerTypes](inner-types.md) | `abstract fun innerTypes(value: List<`[`TypeDeclaration`](../../-type-declaration/index.md)`>): S`<br>`open fun innerTypes(vararg values: `[`TypeDeclaration`](../../-type-declaration/index.md)`): S`<br>See [T.innerTypes](inner-types.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [build](../../../com.github.jonathanxd.codeapi.builder/-builder/build.md) | `abstract fun build(): T`<br>Build the object of type [T](#). |

### Inheritors

| Name | Summary |
|---|---|
| [Builder](../../-field-declaration/-builder/index.md) | `class Builder : `[`Builder`](../../-field-base/-builder/index.md)`<`[`FieldDeclaration`](../../-field-declaration/index.md)`, `[`Builder`](../../-field-declaration/-builder/index.md)`>, `[`Builder`](../../-named/-builder/index.md)`<`[`FieldDeclaration`](../../-field-declaration/index.md)`, `[`Builder`](../../-field-declaration/-builder/index.md)`>, `[`Builder`](../../-typed/-builder/index.md)`<`[`FieldDeclaration`](../../-field-declaration/index.md)`, `[`Builder`](../../-field-declaration/-builder/index.md)`>, `[`Builder`](../../-value-holder/-builder/index.md)`<`[`FieldDeclaration`](../../-field-declaration/index.md)`, `[`Builder`](../../-field-declaration/-builder/index.md)`>, `[`Builder`](../../-modifiers-holder/-builder/index.md)`<`[`FieldDeclaration`](../../-field-declaration/index.md)`, `[`Builder`](../../-field-declaration/-builder/index.md)`>, `[`Builder`](../../-annotable/-builder/index.md)`<`[`FieldDeclaration`](../../-field-declaration/index.md)`, `[`Builder`](../../-field-declaration/-builder/index.md)`>, `[`Builder`](../../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/-builder/index.md)`<`[`FieldDeclaration`](../../-field-declaration/index.md)`, `[`Builder`](../../-field-declaration/-builder/index.md)`>, Builder<`[`FieldDeclaration`](../../-field-declaration/index.md)`, `[`Builder`](../../-field-declaration/-builder/index.md)`>` |
| [Builder](../../-local-code/-builder/index.md) | `class Builder : `[`Builder`](../../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<`[`LocalCode`](../../-local-code/index.md)`, `[`Builder`](../../-local-code/-builder/index.md)`>, Builder<`[`LocalCode`](../../-local-code/index.md)`, `[`Builder`](../../-local-code/-builder/index.md)`>` |
| [Builder](../../-method-declaration-base/-builder/index.md) | `interface Builder<out T : `[`MethodDeclarationBase`](../../-method-declaration-base/index.md)`, S : `[`Builder`](../../-method-declaration-base/-builder/index.md)`<T, S>> : `[`Builder`](../../-body-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-modifiers-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-return-type-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-parameters-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-generic-signature-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-annotable/-builder/index.md)`<T, S>, `[`Builder`](../../-named/-builder/index.md)`<T, S>, `[`Builder`](../../-typed/-builder/index.md)`<T, S>, `[`Builder`](../../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/-builder/index.md)`<T, S>, Builder<T, S>, `[`Builder`](../../-throws-holder/-builder/index.md)`<T, S>` |
| [Builder](../../-elements-holder/-builder/index.md) | `interface Builder<out T : `[`ElementsHolder`](../../-elements-holder/index.md)`, S : `[`Builder`](../../-elements-holder/-builder/index.md)`<T, S>> : Builder<T, S>` |
| [Builder](../../-type-declaration/-builder/index.md) | `interface Builder<out T : `[`TypeDeclaration`](../../-type-declaration/index.md)`, S : `[`Builder`](../../-type-declaration/-builder/index.md)`<T, S>> : `[`Builder`](../../-modifiers-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-qualified-named/-builder/index.md)`<T, S>, `[`Builder`](../../-generic-signature-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-annotable/-builder/index.md)`<T, S>, `[`Builder`](../../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/-builder/index.md)`<T, S>, Builder<T, S>, `[`Builder`](../../-elements-holder/-builder/index.md)`<T, S>` |
