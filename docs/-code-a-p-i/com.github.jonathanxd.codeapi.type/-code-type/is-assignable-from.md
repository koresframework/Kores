[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.type](../index.md) / [CodeType](index.md) / [isAssignableFrom](.)

# isAssignableFrom

`open fun isAssignableFrom(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Boolean`

Returns true if `this` type is assignable from [type](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeType$isAssignableFrom(java.lang.reflect.Type)/type) (using default resolver of [type](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeType$isAssignableFrom(java.lang.reflect.Type)/type)).

`open fun isAssignableFrom(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, resolverProvider: (`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`) -> `[`CodeTypeResolver`](../-code-type-resolver/index.md)`<*>): Boolean`

Returns true if `this` type is assignable from [type](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeType$isAssignableFrom(java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/type) (using resolver provided by [resolverProvider](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeType$isAssignableFrom(java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/resolverProvider)).

