[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.type](../index.md) / [BindedTypeResolver](index.md) / [isAssignableFrom](.)

# isAssignableFrom

`fun isAssignableFrom(from: Type): EitherObjBoolean<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`>`

Checks if [bindType](bind-type.md) is assignable from [from](is-assignable-from.md#com.github.jonathanxd.codeapi.type.BindedTypeResolver$isAssignableFrom(java.lang.reflect.Type)/from) using default resolvers.

**Return**
True if [bindType](bind-type.md) is assignable from [from](is-assignable-from.md#com.github.jonathanxd.codeapi.type.BindedTypeResolver$isAssignableFrom(java.lang.reflect.Type)/from).

`fun isAssignableFrom(from: Type, resolverProvider: (Type) -> `[`CodeTypeResolver`](../-code-type-resolver/index.md)`<*>): EitherObjBoolean<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`>`

Checks if [bindType](bind-type.md) is assignable [from](is-assignable-from.md#com.github.jonathanxd.codeapi.type.BindedTypeResolver$isAssignableFrom(java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/from) using resolvers provided by [resolverProvider](is-assignable-from.md#com.github.jonathanxd.codeapi.type.BindedTypeResolver$isAssignableFrom(java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/resolverProvider)

**Return**
True if [bindType](bind-type.md) is assignable from [from](is-assignable-from.md#com.github.jonathanxd.codeapi.type.BindedTypeResolver$isAssignableFrom(java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/from).

