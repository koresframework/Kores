[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.type](../../index.md) / [AnnotatedCodeType](../index.md) / [SimpleAnnotatedUnknownCodeType](.)

# SimpleAnnotatedUnknownCodeType

`class SimpleAnnotatedUnknownCodeType : `[`Abstract`](../-abstract/index.md)`<SimpleAnnotatedUnknownCodeType>, `[`UnknownCodeType`](../../-unknown-code-type.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `SimpleAnnotatedUnknownCodeType(annotatedType: Type, annotations: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Annotation`](../../../com.github.jonathanxd.codeapi.base/-annotation/index.md)`>)` |

### Inherited Properties

| Name | Summary |
|---|---|
| [annotatedType](../-abstract/annotated-type.md) | `open val annotatedType: Type`<br>The type that is annotated with [annotations](../-abstract/annotations.md). (May be `this`). |
| [annotations](../-abstract/annotations.md) | `open val annotations: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Annotation`](../../../com.github.jonathanxd.codeapi.base/-annotation/index.md)`>`<br>Annotations of the type. |

### Inherited Functions

| Name | Summary |
|---|---|
| [builder](../-abstract/builder.md) | `open fun builder(): `[`Builder`](../-builder/index.md)`<T, *>`<br>This builder may or may not accept null values, it depends on implementation. |
| [equals](../-abstract/equals.md) | `open fun equals(other: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hashCode](../-abstract/hash-code.md) | `open fun hashCode(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [toString](../-abstract/to-string.md) | `open fun toString(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
