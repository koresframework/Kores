[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.type](../../index.md) / [CodeTypeResolver](../index.md) / [Java](.)

# Java

`class Java : `[`CommonResolver`](../-common-resolver/index.md)`<`[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<*>>`

Resolver that resolves [CodeType](../../-code-type/index.md) to Java [Class](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html). This may resolve to [CodeNothing.type](#)
is class loader fails to find class.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Java(classLoader: `[`ClassLoader`](http://docs.oracle.com/javase/6/docs/api/java/lang/ClassLoader.html)`)`<br>Resolver that resolves [CodeType](../../-code-type/index.md) to Java [Class](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html). This may resolve to [CodeNothing.type](#)
is class loader fails to find class. |

### Properties

| Name | Summary |
|---|---|
| [classLoader](class-loader.md) | `val classLoader: `[`ClassLoader`](http://docs.oracle.com/javase/6/docs/api/java/lang/ClassLoader.html) |

### Functions

| Name | Summary |
|---|---|
| [resolve](resolve.md) | `fun resolve(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<*>`<br>Resolves [type](resolve.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.Java$resolve(java.lang.reflect.Type)/type) to [T](#) |

### Inherited Functions

| Name | Summary |
|---|---|
| [getInterfaces](../-common-resolver/get-interfaces.md) | `open fun getInterfaces(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): List<`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`>`<br>Resolves super interfaces of [type](../-common-resolver/get-interfaces.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.CommonResolver$getInterfaces(java.lang.reflect.Type)/type). |
| [getSuperclass](../-common-resolver/get-superclass.md) | `open fun getSuperclass(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Resolves super class of [type](../-common-resolver/get-superclass.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.CommonResolver$getSuperclass(java.lang.reflect.Type)/type) |
| [isAssignableFrom](../-common-resolver/is-assignable-from.md) | `open fun isAssignableFrom(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, from: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, resolverProvider: (`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`) -> `[`CodeTypeResolver`](../index.md)`<*>): Boolean`<br>Checks if [type](../-common-resolver/is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.CommonResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/type) is assignable [from](../-common-resolver/is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.CommonResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/from) using resolvers provided by [resolverProvider](../-common-resolver/is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.CommonResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/resolverProvider) |
