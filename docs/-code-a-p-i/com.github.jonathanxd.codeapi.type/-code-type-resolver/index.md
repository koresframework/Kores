[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.type](../index.md) / [CodeTypeResolver](.)

# CodeTypeResolver

`interface CodeTypeResolver<out T>`

Type resolver. Type resolvers should never throws an error when it is unable to resolve
result of an operation. The operation should return an [Either](#) instance which contains
either the exception describing fail of resolution or the result of resolution.

### Types

| Name | Summary |
|---|---|
| [CodeAPI](-code-a-p-i/index.md) | `class CodeAPI : `[`CommonResolver`](-common-resolver/index.md)`<`[`TypeDeclaration`](../../com.github.jonathanxd.codeapi.base/-type-declaration/index.md)`?>`<br>CodeAPI Resolver. |
| [CommonResolver](-common-resolver/index.md) | `abstract class CommonResolver<out T> : CodeTypeResolver<T>`<br>Common implementation of resolver. |
| [DefaultResolver](-default-resolver/index.md) | `object DefaultResolver : `[`CommonResolver`](-common-resolver/index.md)`<Type>`<br>Default resolver that returns the same instance for [resolve](-default-resolver/resolve.md) method. |
| [Java](-java/index.md) | `class Java : `[`CommonResolver`](-common-resolver/index.md)`<Class<*>>`<br>Resolver that resolves [CodeType](../-code-type/index.md) to Java [Class](#). This may resolve to [CodeNothing.type](#) is class loader fails to find class. |
| [Model](-model/index.md) | `class Model : `[`CommonResolver`](-common-resolver/index.md)`<TypeElement?>`<br>Resolver that resolves [CodeType](../-code-type/index.md) to Javax Model [TypeElement](#), or to `null` if type cannot be found. |
| [Multi](-multi/index.md) | `class Multi<T> : CodeTypeResolver<T?>`<br>This is a resolver which support multiple resolvers. This resolver always returns first **valid resolved value** for each operation. |

### Functions

| Name | Summary |
|---|---|
| [getInterfaces](get-interfaces.md) | `abstract fun getInterfaces(type: Type): Either<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Type>>`<br>Resolves super interfaces of [type](get-interfaces.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$getInterfaces(java.lang.reflect.Type)/type). |
| [getSuperclass](get-superclass.md) | `abstract fun getSuperclass(type: Type): Either<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`, Type?>`<br>Resolves super class of [type](get-superclass.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$getSuperclass(java.lang.reflect.Type)/type). |
| [isAssignableFrom](is-assignable-from.md) | `open fun isAssignableFrom(type: Type, from: Type): EitherObjBoolean<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`>`<br>Checks if [type](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type)/type) is assignable from [from](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type)/from) using default resolvers.`abstract fun isAssignableFrom(type: Type, from: Type, resolverProvider: (Type) -> CodeTypeResolver<*>): EitherObjBoolean<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`>`<br>Checks if [type](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/type) is assignable [from](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/from) using resolvers provided by [resolverProvider](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/resolverProvider) |
| [resolve](resolve.md) | `abstract fun resolve(type: Type): Either<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`, out T>`<br>Resolves [type](resolve.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$resolve(java.lang.reflect.Type)/type) to [T](#) |
| [resolveConstructors](resolve-constructors.md) | `open fun resolveConstructors(type: Type): Either<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`ConstructorDeclaration`](../../com.github.jonathanxd.codeapi.base/-constructor-declaration/index.md)`>>`<br>Resolves or create a list of all [ConstructorDeclaration](../../com.github.jonathanxd.codeapi.base/-constructor-declaration/index.md) present in [type](resolve-constructors.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$resolveConstructors(java.lang.reflect.Type)/type). |
| [resolveFields](resolve-fields.md) | `open fun resolveFields(type: Type): Either<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`FieldDeclaration`](../../com.github.jonathanxd.codeapi.base/-field-declaration/index.md)`>>`<br>Resolves or create a list of all [FieldDeclaration](../../com.github.jonathanxd.codeapi.base/-field-declaration/index.md) present in [type](resolve-fields.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$resolveFields(java.lang.reflect.Type)/type). |
| [resolveMethods](resolve-methods.md) | `open fun resolveMethods(type: Type): Either<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MethodDeclaration`](../../com.github.jonathanxd.codeapi.base/-method-declaration/index.md)`>>`<br>Resolves or create a list of all [MethodDeclaration](../../com.github.jonathanxd.codeapi.base/-method-declaration/index.md) present in [type](resolve-methods.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$resolveMethods(java.lang.reflect.Type)/type). |
| [resolveTypeDeclaration](resolve-type-declaration.md) | `abstract fun resolveTypeDeclaration(type: Type): Either<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`, `[`TypeDeclaration`](../../com.github.jonathanxd.codeapi.base/-type-declaration/index.md)`>`<br>Resolves or create [TypeDeclaration](../../com.github.jonathanxd.codeapi.base/-type-declaration/index.md) from [type](resolve-type-declaration.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$resolveTypeDeclaration(java.lang.reflect.Type)/type) structure and elements. |

### Extension Functions

| Name | Summary |
|---|---|
| [annotationValue](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/annotation-value.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.annotationValue(rType: Class<*>): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) |
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?.asString(simple: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)<br>Convert this value to a literal |
| [toLiteralOrNull](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal-or-null.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteralOrNull(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |

### Inheritors

| Name | Summary |
|---|---|
| [CommonResolver](-common-resolver/index.md) | `abstract class CommonResolver<out T> : CodeTypeResolver<T>`<br>Common implementation of resolver. |
| [Multi](-multi/index.md) | `class Multi<T> : CodeTypeResolver<T?>`<br>This is a resolver which support multiple resolvers. This resolver always returns first **valid resolved value** for each operation. |
