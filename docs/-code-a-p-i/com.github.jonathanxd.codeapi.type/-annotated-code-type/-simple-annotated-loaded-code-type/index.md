[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.type](../../index.md) / [AnnotatedCodeType](../index.md) / [SimpleAnnotatedLoadedCodeType](.)

# SimpleAnnotatedLoadedCodeType

`class SimpleAnnotatedLoadedCodeType<T> : `[`Abstract`](../-abstract/index.md)`<SimpleAnnotatedLoadedCodeType<T>>, `[`LoadedCodeType`](../../-loaded-code-type/index.md)`<T>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `SimpleAnnotatedLoadedCodeType(annotatedType: Type, annotations: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Annotation`](../../../com.github.jonathanxd.codeapi.base/-annotation/index.md)`>)` |

### Properties

| Name | Summary |
|---|---|
| [canonicalName](canonical-name.md) | `val canonicalName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Canonical name |
| [defaultResolver](default-resolver.md) | `val defaultResolver: `[`CodeTypeResolver`](../../-code-type-resolver/index.md)`<Class<*>>`<br>Default resolver. |
| [isArray](is-array.md) | `val isArray: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True if this [CodeType](../../-code-type/index.md) is an array type. |
| [isInterface](is-interface.md) | `val isInterface: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True if this [CodeType](../../-code-type/index.md) is a interface type. |
| [isPrimitive](is-primitive.md) | `val isPrimitive: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True if this [CodeType](../../-code-type/index.md) is a primitive type. |
| [isVirtual](is-virtual.md) | `val isVirtual: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True if is a `Virtual Type` (Virtual Types = Types that were not loaded by JVM) |
| [primitiveType](primitive-type.md) | `val primitiveType: `[`CodeType`](../../-code-type/index.md)`?`<br>Primitive type. |
| [type](type.md) | `val type: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Type name, examples: |
| [wrapperType](wrapper-type.md) | `val wrapperType: `[`CodeType`](../../-code-type/index.md)`?`<br>Wrapper type. |

### Inherited Properties

| Name | Summary |
|---|---|
| [annotatedType](../-abstract/annotated-type.md) | `open val annotatedType: Type`<br>The type that is annotated with [annotations](../-abstract/annotations.md). (May be `this`). |
| [annotations](../-abstract/annotations.md) | `open val annotations: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Annotation`](../../../com.github.jonathanxd.codeapi.base/-annotation/index.md)`>`<br>Annotations of the type. |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): `[`Builder`](../-builder/index.md)`<SimpleAnnotatedLoadedCodeType<T>, *>`<br>This builder may or may not accept null values, it depends on implementation. |

### Inherited Functions

| Name | Summary |
|---|---|
| [toString](../-abstract/to-string.md) | `open fun toString(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
