[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.type](../index.md) / [CodeType](index.md) / [isAssignableFrom](.)

# isAssignableFrom

`open fun isAssignableFrom(type: Type): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Returns true if `this` type is assignable from [type](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeType$isAssignableFrom(java.lang.reflect.Type)/type) (using default resolver of [type](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeType$isAssignableFrom(java.lang.reflect.Type)/type)).

`open fun isAssignableFrom(type: Type, resolverProvider: (Type) -> `[`CodeTypeResolver`](../-code-type-resolver/index.md)`<*>): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Returns true if `this` type is assignable from [type](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeType$isAssignableFrom(java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/type) (using resolver provided by [resolverProvider](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeType$isAssignableFrom(java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/resolverProvider)).

