[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.type](../../index.md) / [CodeTypeResolver](../index.md) / [CommonResolver](.)

# CommonResolver

`abstract class CommonResolver<out T> : `[`CodeTypeResolver`](../index.md)`<T>`

Common implementation of resolver.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CommonResolver()`<br>Common implementation of resolver. |

### Functions

| Name | Summary |
|---|---|
| [getInterfaces](get-interfaces.md) | `open fun getInterfaces(codeType: `[`CodeType`](../../-code-type/index.md)`): List<`[`CodeType`](../../-code-type/index.md)`>`<br>Gets super interfaces of [codeType](get-interfaces.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.CommonResolver$getInterfaces(com.github.jonathanxd.codeapi.type.CodeType)/codeType). |
| [getSuperclass](get-superclass.md) | `open fun getSuperclass(codeType: `[`CodeType`](../../-code-type/index.md)`): `[`CodeType`](../../-code-type/index.md)`?`<br>Gets super classes of [codeType](get-superclass.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.CommonResolver$getSuperclass(com.github.jonathanxd.codeapi.type.CodeType)/codeType) |
| [isAssignableFrom](is-assignable-from.md) | `open fun isAssignableFrom(codeType: `[`CodeType`](../../-code-type/index.md)`, from: `[`CodeType`](../../-code-type/index.md)`, resolverProvider: (`[`CodeType`](../../-code-type/index.md)`) -> `[`CodeTypeResolver`](../index.md)`<*>): Boolean`<br>Checks if [codeType](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.CommonResolver$isAssignableFrom(com.github.jonathanxd.codeapi.type.CodeType, com.github.jonathanxd.codeapi.type.CodeType, kotlin.Function1((com.github.jonathanxd.codeapi.type.CodeType, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/codeType) is assignable [from](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.CommonResolver$isAssignableFrom(com.github.jonathanxd.codeapi.type.CodeType, com.github.jonathanxd.codeapi.type.CodeType, kotlin.Function1((com.github.jonathanxd.codeapi.type.CodeType, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/from) using resolvers provided by [resolverProvider](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.CommonResolver$isAssignableFrom(com.github.jonathanxd.codeapi.type.CodeType, com.github.jonathanxd.codeapi.type.CodeType, kotlin.Function1((com.github.jonathanxd.codeapi.type.CodeType, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/resolverProvider) |

### Inherited Functions

| Name | Summary |
|---|---|
| [isAssignableFrom](../is-assignable-from.md) | `open fun isAssignableFrom(codeType: `[`CodeType`](../../-code-type/index.md)`, from: `[`CodeType`](../../-code-type/index.md)`): Boolean`<br>Checks if [codeType](../is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$isAssignableFrom(com.github.jonathanxd.codeapi.type.CodeType, com.github.jonathanxd.codeapi.type.CodeType)/codeType) is assignable from [from](../is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$isAssignableFrom(com.github.jonathanxd.codeapi.type.CodeType, com.github.jonathanxd.codeapi.type.CodeType)/from) using default resolvers. |
| [resolve](../resolve.md) | `abstract fun resolve(codeType: `[`CodeType`](../../-code-type/index.md)`): T`<br>Resolver [codeType](../resolve.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$resolve(com.github.jonathanxd.codeapi.type.CodeType)/codeType) to [T](#) |

### Inheritors

| Name | Summary |
|---|---|
| [DefaultResolver](../-default-resolver/index.md) | `object DefaultResolver : CommonResolver<`[`CodeType`](../../-code-type/index.md)`>`<br>Default resolver that returns the same instance for [resolve](../-default-resolver/resolve.md) method. |
| [Java](../-java/index.md) | `class Java : CommonResolver<`[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<*>>`<br>Resolver that resolves [CodeType](../../-code-type/index.md) to Java [Class](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html) |
| [Model](../-model/index.md) | `class Model : CommonResolver<`[`TypeElement`](http://docs.oracle.com/javase/6/docs/api/javax/lang/model/element/TypeElement.html)`>`<br>Resolver that resolves [CodeType](../../-code-type/index.md) to Javax Model [TypeElement](http://docs.oracle.com/javase/6/docs/api/javax/lang/model/element/TypeElement.html) |
