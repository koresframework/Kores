[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [GenericSignatureHolder](../index.md) / [Builder](.)

# Builder

`interface Builder<out T : `[`GenericSignatureHolder`](../index.md)`, S : Builder<T, S>> : `[`Builder`](../../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<T, S>`

### Functions

| Name | Summary |
|---|---|
| [genericSignature](generic-signature.md) | `abstract fun genericSignature(value: `[`GenericSignature`](../../../com.github.jonathanxd.codeapi.generic/-generic-signature/index.md)`): S`<br>See [T.genericSignature](generic-signature.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [build](../../../com.github.jonathanxd.codeapi.builder/-builder/build.md) | `abstract fun build(): T`<br>Build the object of type [T](#). |

### Inheritors

| Name | Summary |
|---|---|
| [Builder](../../-method-declaration-base/-builder/index.md) | `interface Builder<out T : `[`MethodDeclarationBase`](../../-method-declaration-base/index.md)`, S : `[`Builder`](../../-method-declaration-base/-builder/index.md)`<T, S>> : `[`Builder`](../../-body-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-modifiers-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-return-type-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-parameters-holder/-builder/index.md)`<T, S>, Builder<T, S>, `[`Builder`](../../-annotable/-builder/index.md)`<T, S>, `[`Builder`](../../-named/-builder/index.md)`<T, S>, `[`Builder`](../../-typed/-builder/index.md)`<T, S>, `[`Builder`](../../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-inner-types-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-throws-holder/-builder/index.md)`<T, S>` |
| [Builder](../../-type-declaration/-builder/index.md) | `interface Builder<out T : `[`TypeDeclaration`](../../-type-declaration/index.md)`, S : `[`Builder`](../../-type-declaration/-builder/index.md)`<T, S>> : `[`Builder`](../../-modifiers-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-qualified-named/-builder/index.md)`<T, S>, Builder<T, S>, `[`Builder`](../../-annotable/-builder/index.md)`<T, S>, `[`Builder`](../../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-inner-types-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-elements-holder/-builder/index.md)`<T, S>` |
