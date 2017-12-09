[CodeAPI](../../../../index.md) / [com.github.jonathanxd.codeapi.type](../../../index.md) / [AnnotatedCodeType](../../index.md) / [GenericAnnotatedCodeType](../index.md) / [GenericBuilder](.)

# GenericBuilder

`class GenericBuilder : `[`Builder`](../../-builder/index.md)`<`[`GenericAnnotatedCodeType`](../index.md)`, GenericBuilder>, `[`Builder`](../../../-generic-type/-builder/index.md)`<`[`GenericAnnotatedCodeType`](../index.md)`, GenericBuilder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `GenericBuilder(origin: `[`GenericType`](../../../-generic-type/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [annotations](annotations.md) | `var annotations: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Annotation`](../../../../com.github.jonathanxd.codeapi.base/-annotation/index.md)`>` |
| [backingGeneric](backing-generic.md) | `var backingGeneric: `[`Builder`](../../../-generic-type/-builder/index.md)`<`[`GenericType`](../../../-generic-type/index.md)`, *>` |

### Functions

| Name | Summary |
|---|---|
| [addAnnotation](add-annotation.md) | `fun addAnnotation(annotation: `[`Annotation`](../../../../com.github.jonathanxd.codeapi.base/-annotation/index.md)`): `[`Builder`](../../-builder/index.md)`<`[`GenericAnnotatedCodeType`](../index.md)`, GenericBuilder>`<br>Adds an [Annotation](../../../../com.github.jonathanxd.codeapi.base/-annotation/index.md) to [AnnotatedCodeType.annotations](../../annotations.md). |
| [addBound](add-bound.md) | `fun addBound(bound: `[`Bound`](../../../-generic-type/-bound/index.md)`): `[`Builder`](../../../-generic-type/-builder/index.md)`<`[`GenericAnnotatedCodeType`](../index.md)`, GenericBuilder>`<br>Adds a bound. |
| [addBounds](add-bounds.md) | `fun addBounds(bounds: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`Bound`](../../../-generic-type/-bound/index.md)`>): `[`Builder`](../../../-generic-type/-builder/index.md)`<`[`GenericAnnotatedCodeType`](../index.md)`, GenericBuilder>`<br>Adds all bounds of [bounds](add-bounds.md#com.github.jonathanxd.codeapi.type.AnnotatedCodeType.GenericAnnotatedCodeType.GenericBuilder$addBounds(kotlin.Array((com.github.jonathanxd.codeapi.type.GenericType.Bound)))/bounds) array.`fun addBounds(bounds: `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`Bound`](../../../-generic-type/-bound/index.md)`>): `[`Builder`](../../../-generic-type/-builder/index.md)`<`[`GenericAnnotatedCodeType`](../index.md)`, GenericBuilder>`<br>Adds all bounds of [bounds](add-bounds.md#com.github.jonathanxd.codeapi.type.AnnotatedCodeType.GenericAnnotatedCodeType.GenericBuilder$addBounds(kotlin.collections.Collection((com.github.jonathanxd.codeapi.type.GenericType.Bound)))/bounds) collection. |
| [addExtendsBound](add-extends-bound.md) | `fun addExtendsBound(value: Type): `[`Builder`](../../../-generic-type/-builder/index.md)`<`[`GenericAnnotatedCodeType`](../index.md)`, GenericBuilder>`<br>Adds a extends bound. |
| [addOfBound](add-of-bound.md) | `fun addOfBound(value: Type): `[`Builder`](../../../-generic-type/-builder/index.md)`<`[`GenericAnnotatedCodeType`](../index.md)`, GenericBuilder>`<br>Adds a `of` bound. Example: A `List of String`. |
| [addSuperBound](add-super-bound.md) | `fun addSuperBound(value: Type): `[`Builder`](../../../-generic-type/-builder/index.md)`<`[`GenericAnnotatedCodeType`](../index.md)`, GenericBuilder>`<br>Adds a super bound. |
| [annotatedType](annotated-type.md) | `fun annotatedType(type: Type): `[`Builder`](../../-builder/index.md)`<`[`GenericAnnotatedCodeType`](../index.md)`, GenericBuilder>`<br>The [type](annotated-type.md#com.github.jonathanxd.codeapi.type.AnnotatedCodeType.GenericAnnotatedCodeType.GenericBuilder$annotatedType(java.lang.reflect.Type)/type) that is annotated with [annotations](annotations.md). |
| [annotations](annotations.md) | `fun annotations(annotations: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Annotation`](../../../../com.github.jonathanxd.codeapi.base/-annotation/index.md)`>): `[`Builder`](../../-builder/index.md)`<`[`GenericAnnotatedCodeType`](../index.md)`, GenericBuilder>`<br>Defines [AnnotatedCodeType.annotations](../../annotations.md). |
| [bounds](bounds.md) | `fun bounds(value: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`Bound`](../../../-generic-type/-bound/index.md)`>): `[`Builder`](../../../-generic-type/-builder/index.md)`<`[`GenericAnnotatedCodeType`](../index.md)`, GenericBuilder>`<br>See [T.bounds](#) |
| [build](build.md) | `fun build(): `[`GenericAnnotatedCodeType`](../index.md)<br>Build the object of type [T](#). |
| [name](name.md) | `fun name(value: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Builder`](../../../-generic-type/-builder/index.md)`<`[`GenericAnnotatedCodeType`](../index.md)`, GenericBuilder>`<br>See [T.name](#). |
| [type](type.md) | `fun type(value: Type): `[`Builder`](../../../-generic-type/-builder/index.md)`<`[`GenericAnnotatedCodeType`](../index.md)`, GenericBuilder>`<br>See [T.codeType](#) |
| [wildcard](wildcard.md) | `fun wildcard(): `[`Builder`](../../../-generic-type/-builder/index.md)`<`[`GenericAnnotatedCodeType`](../index.md)`, GenericBuilder>`<br>See [T.isWildcard](#) |

### Inherited Functions

| Name | Summary |
|---|---|
| [addExtendsBound](../../../-generic-type/-builder/add-extends-bound.md) | `open fun addExtendsBound(value: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Builder`](../../../-generic-type/-builder/index.md)`<T, S>`<br>Adds a extends bound. |
| [addOfBound](../../../-generic-type/-builder/add-of-bound.md) | `open fun addOfBound(value: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Builder`](../../../-generic-type/-builder/index.md)`<T, S>`<br>Adds a `of` bound. Example: A `List of E`. |
| [addSuperBound](../../../-generic-type/-builder/add-super-bound.md) | `open fun addSuperBound(value: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Builder`](../../../-generic-type/-builder/index.md)`<T, S>`<br>Adds a super bound. |
| [annotations](../../-builder/annotations.md) | `open fun annotations(vararg annotations: `[`Annotation`](../../../../com.github.jonathanxd.codeapi.base/-annotation/index.md)`): `[`Builder`](../../-builder/index.md)`<T, S>`<br>Defines [AnnotatedCodeType.annotations](../../annotations.md). |
