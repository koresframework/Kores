[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.type](../index.md) / [CodeTypeResolver](index.md) / [isAssignableFrom](.)

# isAssignableFrom

`open fun isAssignableFrom(type: Type, from: Type): EitherObjBoolean<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`>`

Checks if [type](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type)/type) is assignable from [from](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type)/from) using default resolvers.

**Return**
True if [type](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type)/type) is assignable from [from](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type)/from).

`abstract fun isAssignableFrom(type: Type, from: Type, resolverProvider: (Type) -> `[`CodeTypeResolver`](index.md)`<*>): EitherObjBoolean<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`>`

Checks if [type](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/type) is assignable [from](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/from) using resolvers provided by [resolverProvider](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/resolverProvider)

**Return**
True if [type](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/type) is assignable from [from](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/from).

