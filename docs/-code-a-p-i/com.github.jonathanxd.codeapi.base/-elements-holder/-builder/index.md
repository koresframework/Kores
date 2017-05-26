[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [ElementsHolder](../index.md) / [Builder](.)

# Builder

`interface Builder<out T : `[`ElementsHolder`](../index.md)`, S : Builder<T, S>> : `[`Builder`](../../-inner-types-holder/-builder/index.md)`<T, S>`

### Functions

| Name | Summary |
|---|---|
| [withConstructors](with-constructors.md) | `abstract fun withConstructors(value: List<`[`ConstructorDeclaration`](../../-constructor-declaration/index.md)`>): S`<br>`open fun withConstructors(vararg values: `[`ConstructorDeclaration`](../../-constructor-declaration/index.md)`): S`<br>`open fun withConstructors(value: `[`ConstructorDeclaration`](../../-constructor-declaration/index.md)`): S`<br>See [TypeDeclaration.constructors](../constructors.md) |
| [withFields](with-fields.md) | `abstract fun withFields(value: List<`[`FieldDeclaration`](../../-field-declaration/index.md)`>): S`<br>`open fun withFields(vararg values: `[`FieldDeclaration`](../../-field-declaration/index.md)`): S`<br>`open fun withFields(value: `[`FieldDeclaration`](../../-field-declaration/index.md)`): S`<br>See [TypeDeclaration.fields](../fields.md) |
| [withMethods](with-methods.md) | `abstract fun withMethods(value: List<`[`MethodDeclaration`](../../-method-declaration/index.md)`>): S`<br>`open fun withMethods(vararg values: `[`MethodDeclaration`](../../-method-declaration/index.md)`): S`<br>`open fun withMethods(value: `[`MethodDeclaration`](../../-method-declaration/index.md)`): S`<br>See [TypeDeclaration.methods](../methods.md) |
| [withStaticBlock](with-static-block.md) | `abstract fun withStaticBlock(value: `[`StaticBlock`](../../-static-block/index.md)`): S`<br>See [TypeDeclaration.staticBlock](../static-block.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [withInnerTypes](../../-inner-types-holder/-builder/with-inner-types.md) | `open fun withInnerTypes(vararg values: `[`TypeDeclaration`](../../-type-declaration/index.md)`): S`<br>`abstract fun withInnerTypes(value: List<`[`TypeDeclaration`](../../-type-declaration/index.md)`>): S`<br>See [T.innerTypes](../../-inner-types-holder/inner-types.md) |

### Inheritors

| Name | Summary |
|---|---|
| [Builder](../../-enum-entry/-builder/index.md) | `class Builder : `[`Builder`](../../-argument-holder/-builder/index.md)`<`[`EnumEntry`](../../-enum-entry/index.md)`, `[`Builder`](../../-enum-entry/-builder/index.md)`>, `[`Builder`](../../-named/-builder/index.md)`<`[`EnumEntry`](../../-enum-entry/index.md)`, `[`Builder`](../../-enum-entry/-builder/index.md)`>, Builder<`[`EnumEntry`](../../-enum-entry/index.md)`, `[`Builder`](../../-enum-entry/-builder/index.md)`>` |
| [Builder](../../-type-declaration/-builder/index.md) | `interface Builder<out T : `[`TypeDeclaration`](../../-type-declaration/index.md)`, S : `[`Builder`](../../-type-declaration/-builder/index.md)`<T, S>> : `[`Builder`](../../-modifiers-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-qualified-named/-builder/index.md)`<T, S>, `[`Builder`](../../-generic-signature-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-annotable/-builder/index.md)`<T, S>, `[`Builder`](../../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-inner-types-holder/-builder/index.md)`<T, S>, Builder<T, S>` |
