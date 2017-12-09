[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.type](../../index.md) / [CodeTypeResolver](../index.md) / [CommonResolver](.)

# CommonResolver

`abstract class CommonResolver<out T> : `[`CodeTypeResolver`](../index.md)`<T>`

Common implementation of resolver.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CommonResolver()`<br>Common implementation of resolver. |

### Functions

| Name | Summary |
|---|---|
| [getInterfaces](get-interfaces.md) | `open fun getInterfaces(type: Type): Either<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Type>>`<br>Resolves super interfaces of [type](get-interfaces.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.CommonResolver$getInterfaces(java.lang.reflect.Type)/type). |
| [getSuperclass](get-superclass.md) | `open fun getSuperclass(type: Type): Either<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`, Type?>`<br>Resolves super class of [type](get-superclass.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.CommonResolver$getSuperclass(java.lang.reflect.Type)/type). |
| [isAssignableFrom](is-assignable-from.md) | `open fun isAssignableFrom(type: Type, from: Type, resolverProvider: (Type) -> `[`CodeTypeResolver`](../index.md)`<*>): EitherObjBoolean<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`>`<br>Checks if [type](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.CommonResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/type) is assignable [from](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.CommonResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/from) using resolvers provided by [resolverProvider](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.CommonResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/resolverProvider) |
| [resolveTypeDeclaration](resolve-type-declaration.md) | `open fun resolveTypeDeclaration(type: Type): Either<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`, `[`TypeDeclaration`](../../../com.github.jonathanxd.codeapi.base/-type-declaration/index.md)`>`<br>Resolves or create [TypeDeclaration](../../../com.github.jonathanxd.codeapi.base/-type-declaration/index.md) from [type](resolve-type-declaration.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.CommonResolver$resolveTypeDeclaration(java.lang.reflect.Type)/type) structure and elements. |

### Inherited Functions

| Name | Summary |
|---|---|
| [isAssignableFrom](../is-assignable-from.md) | `open fun isAssignableFrom(type: Type, from: Type): EitherObjBoolean<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`>`<br>Checks if [type](../is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type)/type) is assignable from [from](../is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type)/from) using default resolvers. |
| [resolve](../resolve.md) | `abstract fun resolve(type: Type): Either<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`, out T>`<br>Resolves [type](../resolve.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$resolve(java.lang.reflect.Type)/type) to [T](#) |
| [resolveConstructors](../resolve-constructors.md) | `open fun resolveConstructors(type: Type): Either<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`ConstructorDeclaration`](../../../com.github.jonathanxd.codeapi.base/-constructor-declaration/index.md)`>>`<br>Resolves or create a list of all [ConstructorDeclaration](../../../com.github.jonathanxd.codeapi.base/-constructor-declaration/index.md) present in [type](../resolve-constructors.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$resolveConstructors(java.lang.reflect.Type)/type). |
| [resolveFields](../resolve-fields.md) | `open fun resolveFields(type: Type): Either<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`FieldDeclaration`](../../../com.github.jonathanxd.codeapi.base/-field-declaration/index.md)`>>`<br>Resolves or create a list of all [FieldDeclaration](../../../com.github.jonathanxd.codeapi.base/-field-declaration/index.md) present in [type](../resolve-fields.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$resolveFields(java.lang.reflect.Type)/type). |
| [resolveMethods](../resolve-methods.md) | `open fun resolveMethods(type: Type): Either<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MethodDeclaration`](../../../com.github.jonathanxd.codeapi.base/-method-declaration/index.md)`>>`<br>Resolves or create a list of all [MethodDeclaration](../../../com.github.jonathanxd.codeapi.base/-method-declaration/index.md) present in [type](../resolve-methods.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$resolveMethods(java.lang.reflect.Type)/type). |

### Inheritors

| Name | Summary |
|---|---|
| [CodeAPI](../-code-a-p-i/index.md) | `class CodeAPI : CommonResolver<`[`TypeDeclaration`](../../../com.github.jonathanxd.codeapi.base/-type-declaration/index.md)`?>`<br>CodeAPI Resolver. |
| [DefaultResolver](../-default-resolver/index.md) | `object DefaultResolver : CommonResolver<Type>`<br>Default resolver that returns the same instance for [resolve](../-default-resolver/resolve.md) method. |
| [Java](../-java/index.md) | `class Java : CommonResolver<Class<*>>`<br>Resolver that resolves [CodeType](../../-code-type/index.md) to Java [Class](#). This may resolve to [CodeNothing.type](#) is class loader fails to find class. |
| [Model](../-model/index.md) | `class Model : CommonResolver<TypeElement?>`<br>Resolver that resolves [CodeType](../../-code-type/index.md) to Javax Model [TypeElement](#), or to `null` if type cannot be found. |
