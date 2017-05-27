[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [ModifiersHolder](../index.md) / [Builder](.)

# Builder

`interface Builder<out T : `[`ModifiersHolder`](../index.md)`, S : Builder<T, S>> : `[`Builder`](../../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<T, S>`

### Functions

| Name | Summary |
|---|---|
| [withModifiers](with-modifiers.md) | `abstract fun withModifiers(value: Set<`[`CodeModifier`](../../-code-modifier/index.md)`>): S`<br>`open fun withModifiers(vararg values: `[`CodeModifier`](../../-code-modifier/index.md)`): S`<br>See [ModifiersHolder.modifiers](../modifiers.md) |
| [withPublicModifier](with-public-modifier.md) | `open fun withPublicModifier(): S`<br>Sets modifiers to [CodeModifier.PUBLIC](../../-code-modifier/-p-u-b-l-i-c.md). Public modifier is optional, all
[ModifiersHolder](../index.md) which does not provide a modifier is public by default. |

### Inherited Functions

| Name | Summary |
|---|---|
| [build](../../../com.github.jonathanxd.codeapi.builder/-builder/build.md) | `abstract fun build(): T`<br>Build the object of type [T](#). |

### Inheritors

| Name | Summary |
|---|---|
| [Builder](../../-field-declaration/-builder/index.md) | `class Builder : `[`Builder`](../../-field-base/-builder/index.md)`<`[`FieldDeclaration`](../../-field-declaration/index.md)`, `[`Builder`](../../-field-declaration/-builder/index.md)`>, `[`Builder`](../../-named/-builder/index.md)`<`[`FieldDeclaration`](../../-field-declaration/index.md)`, `[`Builder`](../../-field-declaration/-builder/index.md)`>, `[`Builder`](../../-typed/-builder/index.md)`<`[`FieldDeclaration`](../../-field-declaration/index.md)`, `[`Builder`](../../-field-declaration/-builder/index.md)`>, `[`Builder`](../../-value-holder/-builder/index.md)`<`[`FieldDeclaration`](../../-field-declaration/index.md)`, `[`Builder`](../../-field-declaration/-builder/index.md)`>, Builder<`[`FieldDeclaration`](../../-field-declaration/index.md)`, `[`Builder`](../../-field-declaration/-builder/index.md)`>, `[`Builder`](../../-annotable/-builder/index.md)`<`[`FieldDeclaration`](../../-field-declaration/index.md)`, `[`Builder`](../../-field-declaration/-builder/index.md)`>, `[`Builder`](../../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/-builder/index.md)`<`[`FieldDeclaration`](../../-field-declaration/index.md)`, `[`Builder`](../../-field-declaration/-builder/index.md)`>, `[`Builder`](../../-inner-types-holder/-builder/index.md)`<`[`FieldDeclaration`](../../-field-declaration/index.md)`, `[`Builder`](../../-field-declaration/-builder/index.md)`>` |
| [Builder](../../-method-declaration-base/-builder/index.md) | `interface Builder<out T : `[`MethodDeclarationBase`](../../-method-declaration-base/index.md)`, S : `[`Builder`](../../-method-declaration-base/-builder/index.md)`<T, S>> : `[`Builder`](../../-body-holder/-builder/index.md)`<T, S>, Builder<T, S>, `[`Builder`](../../-return-type-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-parameters-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-generic-signature-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-annotable/-builder/index.md)`<T, S>, `[`Builder`](../../-named/-builder/index.md)`<T, S>, `[`Builder`](../../-typed/-builder/index.md)`<T, S>, `[`Builder`](../../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-inner-types-holder/-builder/index.md)`<T, S>` |
| [Builder](../../-variable-declaration/-builder/index.md) | `class Builder : `[`Builder`](../../-variable-base/-builder/index.md)`<`[`VariableDeclaration`](../../-variable-declaration/index.md)`, `[`Builder`](../../-variable-declaration/-builder/index.md)`>, `[`Builder`](../../-value-holder/-builder/index.md)`<`[`VariableDeclaration`](../../-variable-declaration/index.md)`, `[`Builder`](../../-variable-declaration/-builder/index.md)`>, Builder<`[`VariableDeclaration`](../../-variable-declaration/index.md)`, `[`Builder`](../../-variable-declaration/-builder/index.md)`>` |
| [Builder](../../-type-declaration/-builder/index.md) | `interface Builder<out T : `[`TypeDeclaration`](../../-type-declaration/index.md)`, S : `[`Builder`](../../-type-declaration/-builder/index.md)`<T, S>> : Builder<T, S>, `[`Builder`](../../-qualified-named/-builder/index.md)`<T, S>, `[`Builder`](../../-generic-signature-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-annotable/-builder/index.md)`<T, S>, `[`Builder`](../../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-inner-types-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-elements-holder/-builder/index.md)`<T, S>` |
| [Builder](../../-code-parameter/-builder/index.md) | `class Builder : `[`Builder`](../../-named/-builder/index.md)`<`[`CodeParameter`](../../-code-parameter/index.md)`, `[`Builder`](../../-code-parameter/-builder/index.md)`>, `[`Builder`](../../-typed/-builder/index.md)`<`[`CodeParameter`](../../-code-parameter/index.md)`, `[`Builder`](../../-code-parameter/-builder/index.md)`>, `[`Builder`](../../-annotable/-builder/index.md)`<`[`CodeParameter`](../../-code-parameter/index.md)`, `[`Builder`](../../-code-parameter/-builder/index.md)`>, Builder<`[`CodeParameter`](../../-code-parameter/index.md)`, `[`Builder`](../../-code-parameter/-builder/index.md)`>` |