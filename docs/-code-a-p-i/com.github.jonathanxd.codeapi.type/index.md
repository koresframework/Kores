[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.type](.)

## Package com.github.jonathanxd.codeapi.type

### Types

| Name | Summary |
|---|---|
| [BindedTypeResolver](-binded-type-resolver/index.md) | `class BindedTypeResolver<out T> : Any`<br>A type resolver 'binded' to a [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html). All functions delegates to [codeTypeResolver](-binded-type-resolver/code-type-resolver.md) and uses [bindType](-binded-type-resolver/bind-type.md)
as first argument of functions. |
| [CodeType](-code-type/index.md) | `interface CodeType : `[`CodePart`](../com.github.jonathanxd.codeapi/-code-part/index.md)`, Comparable<`[`CodeType`](-code-type/index.md)`>, `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>A type representation, like: |
| [CodeTypeResolver](-code-type-resolver/index.md) | `interface CodeTypeResolver<out T> : Any`<br>Type resolver. Type resolvers should never throws and error when it is unable to resolve
result of an operation. The operation should return `null` - in the cases which `null` is allowed -
return [CodeNothing](../com.github.jonathanxd.codeapi.common/-code-nothing.md), empty [List](#) or `false` when the resolver is unable to resolve the result of
operation. These semantics are required to [Multi](-code-type-resolver/-multi/index.md) work correctly with any resolver. |
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
