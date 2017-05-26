[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.type](.)

## Package com.github.jonathanxd.codeapi.type

### Types

| Name | Summary |
|---|---|
| [CodeType](-code-type/index.md) | `interface CodeType : `[`CodePart`](../com.github.jonathanxd.codeapi/-code-part/index.md)`, Comparable<`[`CodeType`](-code-type/index.md)`>, `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>A type representation, like: |
| [CodeTypeResolver](-code-type-resolver/index.md) | `interface CodeTypeResolver<out T> : Any`<br>Type resolver |
| [Generic](-generic/index.md) | `class Generic : `[`GenericType`](-generic-type/index.md)<br>A generic type. |
| [GenericType](-generic-type/index.md) | `interface GenericType : `[`CodeType`](-code-type/index.md)<br>Generic type. |
| [GenericTypeBuilder](-generic-type-builder/index.md) | `class GenericTypeBuilder : `[`Builder`](-generic-type/-builder/index.md)`<`[`GenericType`](-generic-type/index.md)`, `[`GenericTypeBuilder`](-generic-type-builder/index.md)`>`<br>Builder of a [GenericType](-generic-type/index.md). |
| [GenericTypeImpl](-generic-type-impl/index.md) | `class GenericTypeImpl : `[`GenericType`](-generic-type/index.md)<br>Generic type implementation. |
| [InheritanceProvider](-inheritance-provider/index.md) | `interface InheritanceProvider : Any`<br>Mixin interface, marks the element as a provider of superclass and superinterfaces for [CodeTypeResolvers](-code-type-resolver/index.md). |
| [JavaType](-java-type/index.md) | `open class JavaType<T> : `[`LoadedCodeType`](-loaded-code-type/index.md)`<T>`<br>Java class [CodeType](-code-type/index.md). |
| [LoadedCodeType](-loaded-code-type/index.md) | `interface LoadedCodeType<T> : `[`CodeType`](-code-type/index.md)<br>A [CodeType](-code-type/index.md) backing to a loaded [Class](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html) ([loadedType](-loaded-code-type/loaded-type.md)). |
| [NullType](-null-type/index.md) | `object NullType : `[`CodeType`](-code-type/index.md)<br>Null code type. |
| [PlainCodeType](-plain-code-type/index.md) | `open class PlainCodeType : `[`CodeType`](-code-type/index.md)`, `[`InheritanceProvider`](-inheritance-provider/index.md)<br>Plain string code type. |
| [TypeRef](-type-ref/index.md) | `data class TypeRef : `[`CodeType`](-code-type/index.md)<br>Reference to a type, this is only intended to be used to inform outer types. |
