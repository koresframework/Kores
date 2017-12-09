[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.type](../../index.md) / [CodeTypeResolver](../index.md) / [Multi](.)

# Multi

`class Multi<T> : `[`CodeTypeResolver`](../index.md)`<T?>`

This is a resolver which support multiple resolvers. This resolver
always returns first **valid resolved value** for each operation.

A valid resolved value depends on operations, see documentation.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Multi()`<br>This is a resolver which support multiple resolvers. This resolver always returns first **valid resolved value** for each operation. |

### Functions

| Name | Summary |
|---|---|
| [addResolver](add-resolver.md) | `fun addResolver(resolver: `[`CodeTypeResolver`](../index.md)`<T?>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Adds a resolver |
| [getInterfaces](get-interfaces.md) | `fun getInterfaces(type: Type): Either<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Type>>`<br>First bigger list is returned. |
| [getSuperclass](get-superclass.md) | `fun getSuperclass(type: Type): Either<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`, Type?>`<br>First non-null and [non-nothing](../../../com.github.jonathanxd.codeapi.common/-code-nothing.md) value is returned, or `null` if no valid value was found. |
| [isAssignableFrom](is-assignable-from.md) | `fun isAssignableFrom(type: Type, from: Type, resolverProvider: (Type) -> `[`CodeTypeResolver`](../index.md)`<*>): EitherObjBoolean<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`>`<br>Returns true if any resolver returns true for this operation. |
| [minusAssign](minus-assign.md) | `operator fun minusAssign(resolver: `[`CodeTypeResolver`](../index.md)`<T?>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Removes a resolver |
| [plusAssign](plus-assign.md) | `operator fun plusAssign(resolver: `[`CodeTypeResolver`](../index.md)`<T?>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Adds a resolver |
| [removeResolver](remove-resolver.md) | `fun removeResolver(resolver: `[`CodeTypeResolver`](../index.md)`<T?>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Removes a resolver |
| [resolve](resolve.md) | `fun resolve(type: Type): Either<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`, out T?>`<br>First non-null and [non-nothing](../../../com.github.jonathanxd.codeapi.common/-code-nothing.md) value is returned, or `null` if no valid value was found. |
| [resolveTypeDeclaration](resolve-type-declaration.md) | `fun resolveTypeDeclaration(type: Type): Either<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`, `[`TypeDeclaration`](../../../com.github.jonathanxd.codeapi.base/-type-declaration/index.md)`>`<br>Resolves or create [TypeDeclaration](../../../com.github.jonathanxd.codeapi.base/-type-declaration/index.md) from [type](resolve-type-declaration.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver.Multi$resolveTypeDeclaration(java.lang.reflect.Type)/type) structure and elements. |

### Inherited Functions

| Name | Summary |
|---|---|
| [isAssignableFrom](../is-assignable-from.md) | `open fun isAssignableFrom(type: Type, from: Type): EitherObjBoolean<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`>`<br>Checks if [type](../is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type)/type) is assignable from [from](../is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type)/from) using default resolvers. |
| [resolveConstructors](../resolve-constructors.md) | `open fun resolveConstructors(type: Type): Either<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`ConstructorDeclaration`](../../../com.github.jonathanxd.codeapi.base/-constructor-declaration/index.md)`>>`<br>Resolves or create a list of all [ConstructorDeclaration](../../../com.github.jonathanxd.codeapi.base/-constructor-declaration/index.md) present in [type](../resolve-constructors.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$resolveConstructors(java.lang.reflect.Type)/type). |
| [resolveFields](../resolve-fields.md) | `open fun resolveFields(type: Type): Either<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`FieldDeclaration`](../../../com.github.jonathanxd.codeapi.base/-field-declaration/index.md)`>>`<br>Resolves or create a list of all [FieldDeclaration](../../../com.github.jonathanxd.codeapi.base/-field-declaration/index.md) present in [type](../resolve-fields.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$resolveFields(java.lang.reflect.Type)/type). |
| [resolveMethods](../resolve-methods.md) | `open fun resolveMethods(type: Type): Either<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MethodDeclaration`](../../../com.github.jonathanxd.codeapi.base/-method-declaration/index.md)`>>`<br>Resolves or create a list of all [MethodDeclaration](../../../com.github.jonathanxd.codeapi.base/-method-declaration/index.md) present in [type](../resolve-methods.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$resolveMethods(java.lang.reflect.Type)/type). |
