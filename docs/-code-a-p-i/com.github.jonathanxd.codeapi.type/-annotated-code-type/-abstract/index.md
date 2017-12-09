[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.type](../../index.md) / [AnnotatedCodeType](../index.md) / [Abstract](.)

# Abstract

`abstract class Abstract<out T : Abstract<T>> : `[`AnnotatedCodeType`](../index.md)`, `[`CodeType`](../../-code-type/index.md)

### Types

| Name | Summary |
|---|---|
| [BuilderImpl](-builder-impl/index.md) | `class BuilderImpl<T : Abstract<T>> : `[`Builder`](../-builder/index.md)`<T, `[`BuilderImpl`](-builder-impl/index.md)`<T>>` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Abstract(annotatedType: Type, annotations: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Annotation`](../../../com.github.jonathanxd.codeapi.base/-annotation/index.md)`>, factory: (type: Type, annotations: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Annotation`](../../../com.github.jonathanxd.codeapi.base/-annotation/index.md)`>) -> T)` |

### Properties

| Name | Summary |
|---|---|
| [annotatedType](annotated-type.md) | `open val annotatedType: Type`<br>The type that is annotated with [annotations](annotations.md). (May be `this`). |
| [annotations](annotations.md) | `open val annotations: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Annotation`](../../../com.github.jonathanxd.codeapi.base/-annotation/index.md)`>`<br>Annotations of the type. |

### Inherited Properties

| Name | Summary |
|---|---|
| [wrapped](../wrapped.md) | `open val wrapped: `[`CodeType`](../../-code-type/index.md)<br>Wrapped code type. |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `open fun builder(): `[`Builder`](../-builder/index.md)`<T, *>`<br>This builder may or may not accept null values, it depends on implementation. |
| [equals](equals.md) | `open fun equals(other: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hashCode](hash-code.md) | `open fun hashCode(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [toString](to-string.md) | `open fun toString(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [GenericAnnotatedCodeType](../-generic-annotated-code-type/index.md) | `class GenericAnnotatedCodeType : Abstract<`[`GenericAnnotatedCodeType`](../-generic-annotated-code-type/index.md)`>, `[`GenericType`](../../-generic-type/index.md) |
| [SimpleAnnotatedCodeType](../-simple-annotated-code-type/index.md) | `class SimpleAnnotatedCodeType : Abstract<`[`SimpleAnnotatedCodeType`](../-simple-annotated-code-type/index.md)`>` |
| [SimpleAnnotatedLoadedCodeType](../-simple-annotated-loaded-code-type/index.md) | `class SimpleAnnotatedLoadedCodeType<T> : Abstract<`[`SimpleAnnotatedLoadedCodeType`](../-simple-annotated-loaded-code-type/index.md)`<T>>, `[`LoadedCodeType`](../../-loaded-code-type/index.md)`<T>` |
| [SimpleAnnotatedUnknownCodeType](../-simple-annotated-unknown-code-type/index.md) | `class SimpleAnnotatedUnknownCodeType : Abstract<`[`SimpleAnnotatedUnknownCodeType`](../-simple-annotated-unknown-code-type/index.md)`>, `[`UnknownCodeType`](../../-unknown-code-type.md) |
| [SimpleAnnotatedWrapperCodeType](../-simple-annotated-wrapper-code-type/index.md) | `class SimpleAnnotatedWrapperCodeType : Abstract<`[`SimpleAnnotatedCodeType`](../-simple-annotated-code-type/index.md)`>` |
