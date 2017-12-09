[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.type](../../index.md) / [AnnotatedCodeType](../index.md) / [GenericAnnotatedCodeType](.)

# GenericAnnotatedCodeType

`class GenericAnnotatedCodeType : `[`Abstract`](../-abstract/index.md)`<GenericAnnotatedCodeType>, `[`GenericType`](../../-generic-type/index.md)

### Types

| Name | Summary |
|---|---|
| [GenericBuilder](-generic-builder/index.md) | `class GenericBuilder : `[`Builder`](../-builder/index.md)`<GenericAnnotatedCodeType, `[`GenericBuilder`](-generic-builder/index.md)`>, `[`Builder`](../../-generic-type/-builder/index.md)`<GenericAnnotatedCodeType, `[`GenericBuilder`](-generic-builder/index.md)`>` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `GenericAnnotatedCodeType(annotatedType: Type, annotations: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Annotation`](../../../com.github.jonathanxd.codeapi.base/-annotation/index.md)`>)` |

### Properties

| Name | Summary |
|---|---|
| [arrayBaseComponent](array-base-component.md) | `val arrayBaseComponent: `[`CodeType`](../../-code-type/index.md)<br>Array base component. |
| [arrayComponent](array-component.md) | `val arrayComponent: `[`CodeType`](../../-code-type/index.md)<br>Array component. |
| [arrayDimension](array-dimension.md) | `val arrayDimension: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Array dimension, 0 if this type is not an array. |
| [canonicalName](canonical-name.md) | `val canonicalName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Canonical name |
| [identification](identification.md) | `val identification: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Unique string identification, this property may be used for equality comparison, normal types, array types and generic types have different identifications, if a generic type represent a single [CodeType](../../-code-type/index.md) without any bound, then the identification will be the same as the single [CodeType](../../-code-type/index.md). |
| [isArray](is-array.md) | `val isArray: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True if this [CodeType](../../-code-type/index.md) is an array type. |
| [isInterface](is-interface.md) | `val isInterface: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True if this [CodeType](../../-code-type/index.md) is a interface type. |
| [isPrimitive](is-primitive.md) | `val isPrimitive: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True if this [CodeType](../../-code-type/index.md) is a primitive type. |
| [isVirtual](is-virtual.md) | `val isVirtual: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True if is a `Virtual Type` (Virtual Types = Types that were not loaded by JVM) |
| [javaSpecName](java-spec-name.md) | `val javaSpecName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>JVM Spec class name. |
| [packageName](package-name.md) | `val packageName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Package name |
| [primitiveType](primitive-type.md) | `val primitiveType: `[`CodeType`](../../-code-type/index.md)`?`<br>Primitive type. |
| [simpleName](simple-name.md) | `val simpleName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Simple name. |
| [type](type.md) | `val type: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Type name, examples: |
| [wrapped](wrapped.md) | `val wrapped: `[`CodeType`](../../-code-type/index.md)<br>Wrapped code type. |
| [wrapperType](wrapper-type.md) | `val wrapperType: `[`CodeType`](../../-code-type/index.md)`?`<br>Wrapper type. |

### Inherited Properties

| Name | Summary |
|---|---|
| [annotatedType](../-abstract/annotated-type.md) | `open val annotatedType: Type`<br>The type that is annotated with [annotations](../-abstract/annotations.md). (May be `this`). |
| [annotations](../-abstract/annotations.md) | `open val annotations: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Annotation`](../../../com.github.jonathanxd.codeapi.base/-annotation/index.md)`>`<br>Annotations of the type. |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): `[`GenericBuilder`](-generic-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |
| [compareTo](compare-to.md) | `fun compareTo(other: `[`CodeType`](../../-code-type/index.md)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Compare two identifications |
| [is](is.md) | `fun is(other: `[`CodeType`](../../-code-type/index.md)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if this [CodeType](../../-code-type/index.md) is equals to other [CodeType](../../-code-type/index.md). |
