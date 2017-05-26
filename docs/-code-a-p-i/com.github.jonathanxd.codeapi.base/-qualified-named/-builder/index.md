[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [QualifiedNamed](../index.md) / [Builder](.)

# Builder

`interface Builder<out T : `[`QualifiedNamed`](../index.md)`, S : Builder<T, S>> : `[`Builder`](../../-named/-builder/index.md)`<T, S>`

### Functions

| Name | Summary |
|---|---|
| [withName](with-name.md) | `open fun withName(value: String): S` |
| [withQualifiedName](with-qualified-name.md) | `abstract fun withQualifiedName(value: String): S` |

### Inheritors

| Name | Summary |
|---|---|
| [Builder](../../-type-declaration/-builder/index.md) | `interface Builder<out T : `[`TypeDeclaration`](../../-type-declaration/index.md)`, S : `[`Builder`](../../-type-declaration/-builder/index.md)`<T, S>> : `[`Builder`](../../-modifiers-holder/-builder/index.md)`<T, S>, Builder<T, S>, `[`Builder`](../../-generic-signature-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-annotable/-builder/index.md)`<T, S>, `[`Builder`](../../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-inner-types-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-elements-holder/-builder/index.md)`<T, S>` |
