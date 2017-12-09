[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.type](../../index.md) / [AnnotatedCodeType](../index.md) / [Builder](.)

# Builder

`interface Builder<out T : `[`AnnotatedCodeType`](../index.md)`, S : Builder<T, S>> : `[`Builder`](../../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<T, S>`

### Functions

| Name | Summary |
|---|---|
| [addAnnotation](add-annotation.md) | `abstract fun addAnnotation(annotation: `[`Annotation`](../../../com.github.jonathanxd.codeapi.base/-annotation/index.md)`): Builder<T, S>`<br>Adds an [Annotation](../../../com.github.jonathanxd.codeapi.base/-annotation/index.md) to [AnnotatedCodeType.annotations](../annotations.md). |
| [annotatedType](annotated-type.md) | `abstract fun annotatedType(type: Type): Builder<T, S>`<br>The [type](annotated-type.md#com.github.jonathanxd.codeapi.type.AnnotatedCodeType.Builder$annotatedType(java.lang.reflect.Type)/type) that is annotated with [annotations](annotations.md). |
| [annotations](annotations.md) | `abstract fun annotations(annotations: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Annotation`](../../../com.github.jonathanxd.codeapi.base/-annotation/index.md)`>): Builder<T, S>`<br>`open fun annotations(vararg annotations: `[`Annotation`](../../../com.github.jonathanxd.codeapi.base/-annotation/index.md)`): Builder<T, S>`<br>Defines [AnnotatedCodeType.annotations](../annotations.md). |

### Inherited Functions

| Name | Summary |
|---|---|
| [build](../../../com.github.jonathanxd.codeapi.builder/-builder/build.md) | `abstract fun build(): T`<br>Build the object of type [T](#). |

### Inheritors

| Name | Summary |
|---|---|
| [BuilderImpl](../-abstract/-builder-impl/index.md) | `class BuilderImpl<T : `[`Abstract`](../-abstract/index.md)`<T>> : Builder<T, `[`BuilderImpl`](../-abstract/-builder-impl/index.md)`<T>>` |
| [GenericBuilder](../-generic-annotated-code-type/-generic-builder/index.md) | `class GenericBuilder : Builder<`[`GenericAnnotatedCodeType`](../-generic-annotated-code-type/index.md)`, `[`GenericBuilder`](../-generic-annotated-code-type/-generic-builder/index.md)`>, `[`Builder`](../../-generic-type/-builder/index.md)`<`[`GenericAnnotatedCodeType`](../-generic-annotated-code-type/index.md)`, `[`GenericBuilder`](../-generic-annotated-code-type/-generic-builder/index.md)`>` |
