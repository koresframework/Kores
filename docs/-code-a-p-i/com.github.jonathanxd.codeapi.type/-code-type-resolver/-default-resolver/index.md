[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.type](../../index.md) / [CodeTypeResolver](../index.md) / [DefaultResolver](.)

# DefaultResolver

`object DefaultResolver : `[`CommonResolver`](../-common-resolver/index.md)`<`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`>`

Default resolver that returns the same instance for [resolve](resolve.md) method.

### Functions

| Name | Summary |
|---|---|
| [resolve](resolve.md) | `fun resolve(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Resolves [type](resolve.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.DefaultResolver$resolve(java.lang.reflect.Type)/type) to [T](#) |

### Inherited Functions

| Name | Summary |
|---|---|
| [getInterfaces](../-common-resolver/get-interfaces.md) | `open fun getInterfaces(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): List<`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`>`<br>Resolves super interfaces of [type](../-common-resolver/get-interfaces.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.CommonResolver$getInterfaces(java.lang.reflect.Type)/type). |
| [getSuperclass](../-common-resolver/get-superclass.md) | `open fun getSuperclass(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Resolves super class of [type](../-common-resolver/get-superclass.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.CommonResolver$getSuperclass(java.lang.reflect.Type)/type) |
| [isAssignableFrom](../-common-resolver/is-assignable-from.md) | `open fun isAssignableFrom(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, from: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, resolverProvider: (`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`) -> `[`CodeTypeResolver`](../index.md)`<*>): Boolean`<br>Checks if [type](../-common-resolver/is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.CommonResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/type) is assignable [from](../-common-resolver/is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.CommonResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/from) using resolvers provided by [resolverProvider](../-common-resolver/is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.CommonResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/resolverProvider) |
