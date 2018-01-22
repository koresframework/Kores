[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.type](../index.md) / [CachedCodeTypeResolver](.)

# CachedCodeTypeResolver

`class CachedCodeTypeResolver<T> : `[`CodeTypeResolver`](../-code-type-resolver/index.md)`<T>`

Caches resolutions, this class is not thread-safe and does not caches [isAssignableFrom](is-assignable-from.md) resolution.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CachedCodeTypeResolver(originalResolver: `[`CodeTypeResolver`](../-code-type-resolver/index.md)`<T>)`<br>Caches resolutions, this class is not thread-safe and does not caches [isAssignableFrom](is-assignable-from.md) resolution. |

### Functions

| Name | Summary |
|---|---|
| [getInterfaces](get-interfaces.md) | `fun getInterfaces(type: Type): Either<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Type>>`<br>Resolves super interfaces of [type](get-interfaces.md#com.github.jonathanxd.codeapi.type.CachedCodeTypeResolver$getInterfaces(java.lang.reflect.Type)/type). |
| [getSuperclass](get-superclass.md) | `fun getSuperclass(type: Type): Either<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`, Type?>`<br>Resolves super class of [type](get-superclass.md#com.github.jonathanxd.codeapi.type.CachedCodeTypeResolver$getSuperclass(java.lang.reflect.Type)/type). |
| [isAssignableFrom](is-assignable-from.md) | `fun isAssignableFrom(type: Type, from: Type, resolverProvider: (Type) -> `[`CodeTypeResolver`](../-code-type-resolver/index.md)`<*>): EitherObjBoolean<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`>`<br>Checks if [type](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CachedCodeTypeResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/type) is assignable [from](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CachedCodeTypeResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/from) using resolvers provided by [resolverProvider](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CachedCodeTypeResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/resolverProvider) |
| [resolve](resolve.md) | `fun resolve(type: Type): Either<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`, out T>`<br>Resolves [type](resolve.md#com.github.jonathanxd.codeapi.type.CachedCodeTypeResolver$resolve(java.lang.reflect.Type)/type) to [T](#) |
| [resolveTypeDeclaration](resolve-type-declaration.md) | `fun resolveTypeDeclaration(type: Type): Either<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`, `[`TypeDeclaration`](../../com.github.jonathanxd.codeapi.base/-type-declaration/index.md)`>`<br>Resolves or create [TypeDeclaration](../../com.github.jonathanxd.codeapi.base/-type-declaration/index.md) from [type](resolve-type-declaration.md#com.github.jonathanxd.codeapi.type.CachedCodeTypeResolver$resolveTypeDeclaration(java.lang.reflect.Type)/type) structure and elements. |

### Inherited Functions

| Name | Summary |
|---|---|
| [isAssignableFrom](../-code-type-resolver/is-assignable-from.md) | `open fun isAssignableFrom(type: Type, from: Type): EitherObjBoolean<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`>`<br>Checks if [type](../-code-type-resolver/is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type)/type) is assignable from [from](../-code-type-resolver/is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type)/from) using default resolvers. |
| [resolveConstructors](../-code-type-resolver/resolve-constructors.md) | `open fun resolveConstructors(type: Type): Either<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`ConstructorDeclaration`](../../com.github.jonathanxd.codeapi.base/-constructor-declaration/index.md)`>>`<br>Resolves or create a list of all [ConstructorDeclaration](../../com.github.jonathanxd.codeapi.base/-constructor-declaration/index.md) present in [type](../-code-type-resolver/resolve-constructors.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$resolveConstructors(java.lang.reflect.Type)/type). |
| [resolveFields](../-code-type-resolver/resolve-fields.md) | `open fun resolveFields(type: Type): Either<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`FieldDeclaration`](../../com.github.jonathanxd.codeapi.base/-field-declaration/index.md)`>>`<br>Resolves or create a list of all [FieldDeclaration](../../com.github.jonathanxd.codeapi.base/-field-declaration/index.md) present in [type](../-code-type-resolver/resolve-fields.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$resolveFields(java.lang.reflect.Type)/type). |
| [resolveMethods](../-code-type-resolver/resolve-methods.md) | `open fun resolveMethods(type: Type): Either<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MethodDeclaration`](../../com.github.jonathanxd.codeapi.base/-method-declaration/index.md)`>>`<br>Resolves or create a list of all [MethodDeclaration](../../com.github.jonathanxd.codeapi.base/-method-declaration/index.md) present in [type](../-code-type-resolver/resolve-methods.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$resolveMethods(java.lang.reflect.Type)/type). |

### Extension Functions

| Name | Summary |
|---|---|
| [annotationValue](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/annotation-value.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.annotationValue(rType: Class<*>): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) |
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?.asString(simple: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)<br>Convert this value to a literal |
| [toLiteralOrNull](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal-or-null.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteralOrNull(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
