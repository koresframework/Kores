[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [ReturnTypeHolder](../index.md) / [Builder](.)

# Builder

`interface Builder<out T : `[`ReturnTypeHolder`](../index.md)`, S : Builder<T, S>> : `[`Builder`](../../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<T, S>`

### Functions

| Name | Summary |
|---|---|
| [returnType](return-type.md) | `abstract fun returnType(value: Type): S`<br>See [T.returnType](return-type.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [build](../../../com.github.jonathanxd.codeapi.builder/-builder/build.md) | `abstract fun build(): T`<br>Build the object of type [T](#). |

### Inheritors

| Name | Summary |
|---|---|
| [Builder](../../-annotation-property/-builder/index.md) | `class Builder : `[`Builder`](../../-named/-builder/index.md)`<`[`AnnotationProperty`](../../-annotation-property/index.md)`, `[`Builder`](../../-annotation-property/-builder/index.md)`>, `[`Builder`](../../-typed/-builder/index.md)`<`[`AnnotationProperty`](../../-annotation-property/index.md)`, `[`Builder`](../../-annotation-property/-builder/index.md)`>, `[`Builder`](../../-annotable/-builder/index.md)`<`[`AnnotationProperty`](../../-annotation-property/index.md)`, `[`Builder`](../../-annotation-property/-builder/index.md)`>, Builder<`[`AnnotationProperty`](../../-annotation-property/index.md)`, `[`Builder`](../../-annotation-property/-builder/index.md)`>, `[`Builder`](../../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/-builder/index.md)`<`[`AnnotationProperty`](../../-annotation-property/index.md)`, `[`Builder`](../../-annotation-property/-builder/index.md)`>` |
| [Builder](../../-method-declaration-base/-builder/index.md) | `interface Builder<out T : `[`MethodDeclarationBase`](../../-method-declaration-base/index.md)`, S : `[`Builder`](../../-method-declaration-base/-builder/index.md)`<T, S>> : `[`Builder`](../../-body-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-modifiers-holder/-builder/index.md)`<T, S>, Builder<T, S>, `[`Builder`](../../-parameters-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-generic-signature-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-annotable/-builder/index.md)`<T, S>, `[`Builder`](../../-named/-builder/index.md)`<T, S>, `[`Builder`](../../-typed/-builder/index.md)`<T, S>, `[`Builder`](../../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-inner-types-holder/-builder/index.md)`<T, S>, `[`Builder`](../../-throws-holder/-builder/index.md)`<T, S>` |
