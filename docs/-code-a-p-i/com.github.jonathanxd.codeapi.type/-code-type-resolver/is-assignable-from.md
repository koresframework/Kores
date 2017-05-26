[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.type](../index.md) / [CodeTypeResolver](index.md) / [isAssignableFrom](.)

# isAssignableFrom

`open fun isAssignableFrom(codeType: `[`CodeType`](../-code-type/index.md)`, from: `[`CodeType`](../-code-type/index.md)`): Boolean`

Checks if [codeType](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$isAssignableFrom(com.github.jonathanxd.codeapi.type.CodeType, com.github.jonathanxd.codeapi.type.CodeType)/codeType) is assignable from [from](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$isAssignableFrom(com.github.jonathanxd.codeapi.type.CodeType, com.github.jonathanxd.codeapi.type.CodeType)/from) using default resolvers.

**Return**
True if [codeType](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$isAssignableFrom(com.github.jonathanxd.codeapi.type.CodeType, com.github.jonathanxd.codeapi.type.CodeType)/codeType) is assignable from [from](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$isAssignableFrom(com.github.jonathanxd.codeapi.type.CodeType, com.github.jonathanxd.codeapi.type.CodeType)/from).

`abstract fun isAssignableFrom(codeType: `[`CodeType`](../-code-type/index.md)`, from: `[`CodeType`](../-code-type/index.md)`, resolverProvider: (`[`CodeType`](../-code-type/index.md)`) -> `[`CodeTypeResolver`](index.md)`<*>): Boolean`

Checks if [codeType](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$isAssignableFrom(com.github.jonathanxd.codeapi.type.CodeType, com.github.jonathanxd.codeapi.type.CodeType, kotlin.Function1((com.github.jonathanxd.codeapi.type.CodeType, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/codeType) is assignable [from](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$isAssignableFrom(com.github.jonathanxd.codeapi.type.CodeType, com.github.jonathanxd.codeapi.type.CodeType, kotlin.Function1((com.github.jonathanxd.codeapi.type.CodeType, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/from) using resolvers provided by [resolverProvider](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$isAssignableFrom(com.github.jonathanxd.codeapi.type.CodeType, com.github.jonathanxd.codeapi.type.CodeType, kotlin.Function1((com.github.jonathanxd.codeapi.type.CodeType, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/resolverProvider)

**Return**
True if [codeType](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$isAssignableFrom(com.github.jonathanxd.codeapi.type.CodeType, com.github.jonathanxd.codeapi.type.CodeType, kotlin.Function1((com.github.jonathanxd.codeapi.type.CodeType, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/codeType) is assignable from [from](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$isAssignableFrom(com.github.jonathanxd.codeapi.type.CodeType, com.github.jonathanxd.codeapi.type.CodeType, kotlin.Function1((com.github.jonathanxd.codeapi.type.CodeType, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/from).

