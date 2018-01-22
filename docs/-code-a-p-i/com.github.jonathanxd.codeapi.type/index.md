[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.type](.)

## Package com.github.jonathanxd.codeapi.type

### Types

| Name | Summary |
|---|---|
| [AnnotatedCodeType](-annotated-code-type/index.md) | `interface AnnotatedCodeType : `[`WrapperCodeType`](-wrapper-code-type/index.md)<br>A [CodeType](-code-type/index.md) with annotations, to be used where `TYPE_USE Annotations` are allowed, but there is no limitation of where you can use. |
| [BindedTypeResolver](-binded-type-resolver/index.md) | `class BindedTypeResolver<out T>`<br>A type resolver 'binded' to a [Type](#). All functions delegates to [codeTypeResolver](-binded-type-resolver/code-type-resolver.md) and uses [bindType](-binded-type-resolver/bind-type.md) as first argument of functions. |
| [CachedCodeTypeResolver](-cached-code-type-resolver/index.md) | `class CachedCodeTypeResolver<T> : `[`CodeTypeResolver`](-code-type-resolver/index.md)`<T>`<br>Caches resolutions, this class is not thread-safe and does not caches [isAssignableFrom](-cached-code-type-resolver/is-assignable-from.md) resolution. |
| [CodeType](-code-type/index.md) | `interface CodeType : `[`CodePart`](../com.github.jonathanxd.codeapi/-code-part/index.md)`, `[`Comparable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-comparable/index.html)`<`[`CodeType`](-code-type/index.md)`>, Type`<br>A type representation, like: |
| [CodeTypeResolver](-code-type-resolver/index.md) | `interface CodeTypeResolver<out T>`<br>Type resolver. Type resolvers should never throws an error when it is unable to resolve result of an operation. The operation should return an [Either](#) instance which contains either the exception describing fail of resolution or the result of resolution. |
| [Generic](-generic/index.md) | `class Generic : `[`GenericType`](-generic-type/index.md)<br>A generic type. |
| [GenericType](-generic-type/index.md) | `interface GenericType : `[`CodeType`](-code-type/index.md)`, `[`WrapperCodeType`](-wrapper-code-type/index.md)<br>Generic type. |
| [GenericTypeBuilder](-generic-type-builder/index.md) | `class GenericTypeBuilder : `[`Builder`](-generic-type/-builder/index.md)`<`[`GenericType`](-generic-type/index.md)`, `[`GenericTypeBuilder`](-generic-type-builder/index.md)`>`<br>Builder of a [GenericType](-generic-type/index.md). |
| [GenericTypeImpl](-generic-type-impl/index.md) | `class GenericTypeImpl : `[`GenericType`](-generic-type/index.md)<br>Generic type implementation. |
| [InheritanceProvider](-inheritance-provider/index.md) | `interface InheritanceProvider`<br>Mixin interface, marks the element as a provider of superclass and superinterfaces for [CodeTypeResolvers](-code-type-resolver/index.md). |
| [JavaType](-java-type/index.md) | `open class JavaType<T> : `[`LoadedCodeType`](-loaded-code-type/index.md)`<T>`<br>Java class [CodeType](-code-type/index.md). |
| [LoadedCodeType](-loaded-code-type/index.md) | `interface LoadedCodeType<T> : `[`CodeType`](-code-type/index.md)<br>A [CodeType](-code-type/index.md) backing to a loaded [Class](#) ([loadedType](-loaded-code-type/loaded-type.md)). |
| [ModelResolver](-model-resolver/index.md) | `class ModelResolver : `[`GenericResolver`](../com.github.jonathanxd.codeapi.util/-generic-resolver/index.md) |
| [NullType](-null-type/index.md) | `object NullType : `[`CodeType`](-code-type/index.md)<br>Null code type. |
| [PlainCodeType](-plain-code-type/index.md) | `open class PlainCodeType : `[`UnknownCodeType`](-unknown-code-type.md)`, `[`InheritanceProvider`](-inheritance-provider/index.md)<br>Plain string code type. |
| [TypeRef](-type-ref/index.md) | `data class TypeRef : `[`CodeType`](-code-type/index.md)<br>Reference to a type, this is only intended to be used to inform outer types. |
| [UnknownCodeType](-unknown-code-type.md) | `interface UnknownCodeType : `[`CodeType`](-code-type/index.md)<br>A Code Type that is not known by CodeAPI. These types are commonly those defined by the user to refer to classes that are not loaded by the JVM and isn't defined by CodeAPI, or will be defined later. [UnknownCodeType](-unknown-code-type.md) is not the same as [TypeRef](-type-ref/index.md). The [TypeRef](-type-ref/index.md) is intended to reference CodeAPI type declarations before them is created. [UnknownCodeType](-unknown-code-type.md) is intended to reference a type that is unknown to either JVM and CodeAPI. |
| [WrapperCodeType](-wrapper-code-type/index.md) | `interface WrapperCodeType : `[`CodeType`](-code-type/index.md)<br>Denotes a CodeType that wraps another type. |

### Extensions for External Classes

| Name | Summary |
|---|---|
| [java.lang.Class](java.lang.-class/index.md) |  |
| [java.lang.reflect.Type](java.lang.reflect.-type/index.md) |  |
| [javax.lang.model.element.TypeElement](javax.lang.model.element.-type-element/index.md) |  |
| [javax.lang.model.type.TypeMirror](javax.lang.model.type.-type-mirror/index.md) |  |
| [kotlin.Array](kotlin.-array/index.md) |  |
| [kotlin.collections.List](kotlin.collections.-list/index.md) |  |
| [kotlin.reflect.KClass](kotlin.reflect.-k-class/index.md) |  |

### Properties

| Name | Summary |
|---|---|
| [concreteType](concrete-type.md) | `val `[`CodeType`](-code-type/index.md)`.concreteType: `[`CodeType`](-code-type/index.md)<br>Gets the concrete type of [CodeType](-code-type/index.md), if this is a [GenericType](-generic-type/index.md), the property getter will try to infer the concrete type looping the [GenericType Inferred type](-generic-type/resolved-type.md). |
| [descName](desc-name.md) | `val `[`CodeType`](-code-type/index.md)`.descName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| Name | Summary |
|---|---|
| [applyType](apply-type.md) | `fun `[`CodeType`](-code-type/index.md)`.applyType(typeName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, type: `[`CodeType`](-code-type/index.md)`): `[`CodeType`](-code-type/index.md)<br>`fun `[`GenericType`](-generic-type/index.md)`.applyType(typeName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, type: `[`CodeType`](-code-type/index.md)`): `[`GenericType`](-generic-type/index.md) |
| [getCommonSuperType](get-common-super-type.md) | `fun getCommonSuperType(typeA: Type, typeB: Type): Type?`<br>Gets common super type of [typeA](get-common-super-type.md#com.github.jonathanxd.codeapi.type$getCommonSuperType(java.lang.reflect.Type, java.lang.reflect.Type)/typeA) and [typeB](get-common-super-type.md#com.github.jonathanxd.codeapi.type$getCommonSuperType(java.lang.reflect.Type, java.lang.reflect.Type)/typeB). |
| [getCommonSuperTypeOrInterface](get-common-super-type-or-interface.md) | `fun getCommonSuperTypeOrInterface(typeA: Type, typeB: Type): Type?`<br>Gets common super type of [typeA](get-common-super-type-or-interface.md#com.github.jonathanxd.codeapi.type$getCommonSuperTypeOrInterface(java.lang.reflect.Type, java.lang.reflect.Type)/typeA) and [typeB](get-common-super-type-or-interface.md#com.github.jonathanxd.codeapi.type$getCommonSuperTypeOrInterface(java.lang.reflect.Type, java.lang.reflect.Type)/typeB). |
| [getType](get-type.md) | `fun `[`CodeType`](-code-type/index.md)`.getType(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`CodeType`](-code-type/index.md)`?`<br>`fun `[`CodeType`](-code-type/index.md)`.getType(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, inside: `[`CodeType`](-code-type/index.md)`): `[`CodeType`](-code-type/index.md)`?`<br>`fun `[`GenericType`](-generic-type/index.md)`.getType(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`CodeType`](-code-type/index.md)`?`<br>`fun `[`GenericType`](-generic-type/index.md)`.getType(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, inside: `[`CodeType`](-code-type/index.md)`): `[`CodeType`](-code-type/index.md)`?` |
