[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [ElementsHolder](../index.md) / [Builder](.)

# Builder

`interface Builder<out T : `[`ElementsHolder`](../index.md)`, S : Builder<T, S>> : `[`Builder`](../../-inner-types-holder/-builder/index.md)`<T, S>`

### Functions

| Name | Summary |
|---|---|
| [fields](fields.md) | `abstract fun fields(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`FieldDeclaration`](../../-field-declaration/index.md)`>): S`<br>`open fun fields(vararg values: `[`FieldDeclaration`](../../-field-declaration/index.md)`): S`<br>`open fun fields(value: `[`FieldDeclaration`](../../-field-declaration/index.md)`): S`<br>See [ElementsHolder.fields](../fields.md) |
| [methods](methods.md) | `abstract fun methods(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MethodDeclaration`](../../-method-declaration/index.md)`>): S`<br>`open fun methods(vararg values: `[`MethodDeclaration`](../../-method-declaration/index.md)`): S`<br>`open fun methods(value: `[`MethodDeclaration`](../../-method-declaration/index.md)`): S`<br>See [ElementsHolder.methods](../methods.md) |
| [staticBlock](static-block.md) | `abstract fun staticBlock(value: `[`StaticBlock`](../../-static-block/index.md)`): S`<br>See [ElementsHolder.staticBlock](../static-block.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [innerTypes](../../-inner-types-holder/-builder/inner-types.md) | `abstract fun innerTypes(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`TypeDeclaration`](../../-type-declaration/index.md)`>): S`<br>`open fun innerTypes(vararg values: `[`TypeDeclaration`](../../-type-declaration/index.md)`): S`<br>See [InnerTypesHolder.innerTypes](../../-inner-types-holder/inner-types.md) |

### Inheritors

| Name | Summary |
|---|---|
| [Builder](../../-enum-entry/-builder/index.md) | `class Builder : `[`Builder`](../../-annotable/-builder/index.md)`<`[`EnumEntry`](../../-enum-entry/index.md)`, `[`Builder`](../../-enum-entry/-builder/index.md)`>, `[`Builder`](../../-arguments-holder/-builder/index.md)`<`[`EnumEntry`](../../-enum-entry/index.md)`, `[`Builder`](../../-enum-entry/-builder/index.md)`>, `[`Builder`](../../-named/-builder/index.md)`<`[`EnumEntry`](../../-enum-entry/index.md)`, `[`Builder`](../../-enum-entry/-builder/index.md)`>, Builder<`[`EnumEntry`](../../-enum-entry/index.md)`, `[`Builder`](../../-enum-entry/-builder/index.md)`>` |
| [Builder](../../-type-declaration/-builder/index.md) | `interface Builder<out T : `[`TypeDeclaration`](../../-type-declaration/index.md)`, S : `[`Builder`](../../-type-declaration/-builder/index.md)`<T, S>> : `[`Builder`](../../-modifiers-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-qualified-named/-builder/index.md)`<T, S>, `[`Builder`](../../-generic-signature-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-annotable/-builder/index.md)`<T, S>, `[`Builder`](../../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-inner-types-holder/-builder/index.md)`<T, S>, Builder<T, S>` |
