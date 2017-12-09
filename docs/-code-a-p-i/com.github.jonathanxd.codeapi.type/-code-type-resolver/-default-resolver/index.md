[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.type](../../index.md) / [CodeTypeResolver](../index.md) / [DefaultResolver](.)

# DefaultResolver

`object DefaultResolver : `[`CommonResolver`](../-common-resolver/index.md)`<Type>`

Default resolver that returns the same instance for [resolve](resolve.md) method.

### Functions

| Name | Summary |
|---|---|
| [resolve](resolve.md) | `fun resolve(type: Type): Either<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`, Type>`<br>Resolves [type](resolve.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.DefaultResolver$resolve(java.lang.reflect.Type)/type) to [T](#) |

### Inherited Functions

| Name | Summary |
|---|---|
| [getInterfaces](../-common-resolver/get-interfaces.md) | `open fun getInterfaces(type: Type): Either<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Type>>`<br>Resolves super interfaces of [type](../-common-resolver/get-interfaces.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.CommonResolver$getInterfaces(java.lang.reflect.Type)/type). |
| [getSuperclass](../-common-resolver/get-superclass.md) | `open fun getSuperclass(type: Type): Either<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`, Type?>`<br>Resolves super class of [type](../-common-resolver/get-superclass.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.CommonResolver$getSuperclass(java.lang.reflect.Type)/type). |
| [isAssignableFrom](../-common-resolver/is-assignable-from.md) | `open fun isAssignableFrom(type: Type, from: Type, resolverProvider: (Type) -> `[`CodeTypeResolver`](../index.md)`<*>): EitherObjBoolean<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`>`<br>Checks if [type](../-common-resolver/is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.CommonResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/type) is assignable [from](../-common-resolver/is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.CommonResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/from) using resolvers provided by [resolverProvider](../-common-resolver/is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.CommonResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/resolverProvider) |
| [resolveTypeDeclaration](../-common-resolver/resolve-type-declaration.md) | `open fun resolveTypeDeclaration(type: Type): Either<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`, `[`TypeDeclaration`](../../../com.github.jonathanxd.codeapi.base/-type-declaration/index.md)`>`<br>Resolves or create [TypeDeclaration](../../../com.github.jonathanxd.codeapi.base/-type-declaration/index.md) from [type](../-common-resolver/resolve-type-declaration.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.CommonResolver$resolveTypeDeclaration(java.lang.reflect.Type)/type) structure and elements. |
