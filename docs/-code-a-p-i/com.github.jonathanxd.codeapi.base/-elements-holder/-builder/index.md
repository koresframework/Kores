[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [ElementsHolder](../index.md) / [Builder](.)

# Builder

`interface Builder<out T : `[`ElementsHolder`](../index.md)`, S : Builder<T, S>> : `[`Builder`](../../-inner-types-holder/-builder/index.md)`<T, S>`

### Functions

| Name | Summary |
|---|---|
| [constructors](constructors.md) | `abstract fun constructors(value: List<`[`ConstructorDeclaration`](../../-constructor-declaration/index.md)`>): S`<br>`open fun constructors(vararg values: `[`ConstructorDeclaration`](../../-constructor-declaration/index.md)`): S`<br>`open fun constructors(value: `[`ConstructorDeclaration`](../../-constructor-declaration/index.md)`): S`<br>See [TypeDeclaration.constructors](../constructors.md) |
| [fields](fields.md) | `abstract fun fields(value: List<`[`FieldDeclaration`](../../-field-declaration/index.md)`>): S`<br>`open fun fields(vararg values: `[`FieldDeclaration`](../../-field-declaration/index.md)`): S`<br>`open fun fields(value: `[`FieldDeclaration`](../../-field-declaration/index.md)`): S`<br>See [TypeDeclaration.fields](../fields.md) |
| [methods](methods.md) | `abstract fun methods(value: List<`[`MethodDeclaration`](../../-method-declaration/index.md)`>): S`<br>`open fun methods(vararg values: `[`MethodDeclaration`](../../-method-declaration/index.md)`): S`<br>`open fun methods(value: `[`MethodDeclaration`](../../-method-declaration/index.md)`): S`<br>See [TypeDeclaration.methods](../methods.md) |
| [staticBlock](static-block.md) | `abstract fun staticBlock(value: `[`StaticBlock`](../../-static-block/index.md)`): S`<br>See [TypeDeclaration.staticBlock](../static-block.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [innerTypes](../../-inner-types-holder/-builder/inner-types.md) | `open fun innerTypes(vararg values: `[`TypeDeclaration`](../../-type-declaration/index.md)`): S`<br>`abstract fun innerTypes(value: List<`[`TypeDeclaration`](../../-type-declaration/index.md)`>): S`<br>See [T.innerTypes](../../-inner-types-holder/-builder/inner-types.md) |

### Inheritors

| Name | Summary |
|---|---|
| [Builder](../../-enum-entry/-builder/index.md) | `class Builder : `[`Builder`](../../-arguments-holder/-builder/index.md)`<`[`EnumEntry`](../../-enum-entry/index.md)`, `[`Builder`](../../-enum-entry/-builder/index.md)`>, `[`Builder`](../../-named/-builder/index.md)`<`[`EnumEntry`](../../-enum-entry/index.md)`, `[`Builder`](../../-enum-entry/-builder/index.md)`>, Builder<`[`EnumEntry`](../../-enum-entry/index.md)`, `[`Builder`](../../-enum-entry/-builder/index.md)`>` |
| [Builder](../../-type-declaration/-builder/index.md) | `interface Builder<out T : `[`TypeDeclaration`](../../-type-declaration/index.md)`, S : `[`Builder`](../../-type-declaration/-builder/index.md)`<T, S>> : `[`Builder`](../../-modifiers-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-qualified-named/-builder/index.md)`<T, S>, `[`Builder`](../../-generic-signature-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-annotable/-builder/index.md)`<T, S>, `[`Builder`](../../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-inner-types-holder/-builder/index.md)`<T, S>, Builder<T, S>` |
