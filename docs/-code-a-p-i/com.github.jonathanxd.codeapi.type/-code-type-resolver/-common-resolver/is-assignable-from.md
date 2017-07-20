[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.type](../../index.md) / [CodeTypeResolver](../index.md) / [CommonResolver](index.md) / [isAssignableFrom](.)

# isAssignableFrom

`open fun isAssignableFrom(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, from: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, resolverProvider: (`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`) -> `[`CodeTypeResolver`](../index.md)`<*>): Boolean`

Overrides [CodeTypeResolver.isAssignableFrom](../is-assignable-from.md)

Checks if [type](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.CommonResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/type) is assignable [from](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.CommonResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/from) using resolvers provided by [resolverProvider](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.CommonResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/resolverProvider)

**Return**
True if [type](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.CommonResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/type) is assignable from [from](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.CommonResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/from).

