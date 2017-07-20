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
| [getInterfaces](get-interfaces.md) | `open fun getInterfaces(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): List<`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`>`<br>Resolves super interfaces of [type](get-interfaces.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.CommonResolver$getInterfaces(java.lang.reflect.Type)/type). |
| [getSuperclass](get-superclass.md) | `open fun getSuperclass(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Resolves super class of [type](get-superclass.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.CommonResolver$getSuperclass(java.lang.reflect.Type)/type) |
| [isAssignableFrom](is-assignable-from.md) | `open fun isAssignableFrom(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, from: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, resolverProvider: (`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`) -> `[`CodeTypeResolver`](../index.md)`<*>): Boolean`<br>Checks if [type](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.CommonResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/type) is assignable [from](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.CommonResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/from) using resolvers provided by [resolverProvider](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.CommonResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/resolverProvider) |

### Inherited Functions

| Name | Summary |
|---|---|
| [isAssignableFrom](../is-assignable-from.md) | `open fun isAssignableFrom(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, from: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Boolean`<br>Checks if [type](../is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type)/type) is assignable from [from](../is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type)/from) using default resolvers. |
| [resolve](../resolve.md) | `abstract fun resolve(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): T`<br>Resolves [type](../resolve.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$resolve(java.lang.reflect.Type)/type) to [T](#) |

### Inheritors

| Name | Summary |
|---|---|
| [CodeAPI](../-code-a-p-i/index.md) | `class CodeAPI : CommonResolver<`[`TypeDeclaration`](../../../com.github.jonathanxd.codeapi.base/-type-declaration/index.md)`?>`<br>CodeAPI Resolver. |
| [DefaultResolver](../-default-resolver/index.md) | `object DefaultResolver : CommonResolver<`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`>`<br>Default resolver that returns the same instance for [resolve](../-default-resolver/resolve.md) method. |
| [Java](../-java/index.md) | `class Java : CommonResolver<`[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<*>>`<br>Resolver that resolves [CodeType](../../-code-type/index.md) to Java [Class](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html). This may resolve to [CodeNothing.type](#)
is class loader fails to find class. |
| [Model](../-model/index.md) | `class Model : CommonResolver<`[`TypeElement`](http://docs.oracle.com/javase/6/docs/api/javax/lang/model/element/TypeElement.html)`?>`<br>Resolver that resolves [CodeType](../../-code-type/index.md) to Javax Model [TypeElement](http://docs.oracle.com/javase/6/docs/api/javax/lang/model/element/TypeElement.html), or to `null`
if type cannot be found. |
