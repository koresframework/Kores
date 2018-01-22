[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.type](../index.md) / [BindedTypeResolver](.)

# BindedTypeResolver

`class BindedTypeResolver<out T>`

A type resolver 'binded' to a [Type](#). All functions delegates to [codeTypeResolver](code-type-resolver.md) and uses [bindType](bind-type.md)
as first argument of functions.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `BindedTypeResolver(bindType: Type, codeTypeResolver: `[`CodeTypeResolver`](../-code-type-resolver/index.md)`<T>)`<br>A type resolver 'binded' to a [Type](#). All functions delegates to [codeTypeResolver](-init-.md#com.github.jonathanxd.codeapi.type.BindedTypeResolver$<init>(java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((com.github.jonathanxd.codeapi.type.BindedTypeResolver.T)))/codeTypeResolver) and uses [bindType](-init-.md#com.github.jonathanxd.codeapi.type.BindedTypeResolver$<init>(java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((com.github.jonathanxd.codeapi.type.BindedTypeResolver.T)))/bindType) as first argument of functions. |

### Properties

| Name | Summary |
|---|---|
| [bindType](bind-type.md) | `val bindType: Type` |
| [codeTypeResolver](code-type-resolver.md) | `val codeTypeResolver: `[`CodeTypeResolver`](../-code-type-resolver/index.md)`<T>` |

### Functions

| Name | Summary |
|---|---|
| [bindTo](bind-to.md) | `fun bindTo(bindedType: Type): BindedTypeResolver<T>`<br>Creates a new BindedTypeResolver instance 'binded' to [bindType](bind-type.md). |
| [bindToResolver](bind-to-resolver.md) | `fun <T> bindToResolver(codeTypeResolver: `[`CodeTypeResolver`](../-code-type-resolver/index.md)`<T>): BindedTypeResolver<T>`<br>Creates a new BindedTypeResolver instance which delegate calls to [codeTypeResolver](bind-to-resolver.md#com.github.jonathanxd.codeapi.type.BindedTypeResolver$bindToResolver(com.github.jonathanxd.codeapi.type.CodeTypeResolver((com.github.jonathanxd.codeapi.type.BindedTypeResolver.bindToResolver.T)))/codeTypeResolver). |
| [getInterfaces](get-interfaces.md) | `fun getInterfaces(): Either<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Type>>`<br>Resolves super interfaces of [bindType](bind-type.md). |
| [getSuperclass](get-superclass.md) | `fun getSuperclass(): Either<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`, Type?>`<br>Resolves super class of [bindType](bind-type.md) |
| [isAssignableFrom](is-assignable-from.md) | `fun isAssignableFrom(from: Type): EitherObjBoolean<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`>`<br>Checks if [bindType](bind-type.md) is assignable from [from](is-assignable-from.md#com.github.jonathanxd.codeapi.type.BindedTypeResolver$isAssignableFrom(java.lang.reflect.Type)/from) using default resolvers.`fun isAssignableFrom(from: Type, resolverProvider: (Type) -> `[`CodeTypeResolver`](../-code-type-resolver/index.md)`<*>): EitherObjBoolean<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`>`<br>Checks if [bindType](bind-type.md) is assignable [from](is-assignable-from.md#com.github.jonathanxd.codeapi.type.BindedTypeResolver$isAssignableFrom(java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/from) using resolvers provided by [resolverProvider](is-assignable-from.md#com.github.jonathanxd.codeapi.type.BindedTypeResolver$isAssignableFrom(java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/resolverProvider) |
| [resolve](resolve.md) | `fun resolve(): Either<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`, out T>`<br>Resolves [bindType](bind-type.md) to [T](#) |
| [resolveConstructors](resolve-constructors.md) | `fun resolveConstructors(): Either<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`ConstructorDeclaration`](../../com.github.jonathanxd.codeapi.base/-constructor-declaration/index.md)`>>`<br>Resolves or create a list of all [ConstructorDeclaration](../../com.github.jonathanxd.codeapi.base/-constructor-declaration/index.md) present in [bindedType](#)  (back call to [codeTypeResolver](code-type-resolver.md)). |
| [resolveFields](resolve-fields.md) | `fun resolveFields(): Either<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`FieldDeclaration`](../../com.github.jonathanxd.codeapi.base/-field-declaration/index.md)`>>`<br>Resolves or create a list of all [FieldDeclaration](../../com.github.jonathanxd.codeapi.base/-field-declaration/index.md) present in [bindedType](#) (back call to [codeTypeResolver](code-type-resolver.md)). |
| [resolveMethods](resolve-methods.md) | `fun resolveMethods(): Either<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`, `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MethodDeclaration`](../../com.github.jonathanxd.codeapi.base/-method-declaration/index.md)`>>`<br>Resolves or create a list of all [MethodDeclaration](../../com.github.jonathanxd.codeapi.base/-method-declaration/index.md) present in [bindedType](#) (back call to [codeTypeResolver](code-type-resolver.md)). |
| [resolveTypeDeclaration](resolve-type-declaration.md) | `fun resolveTypeDeclaration(): Either<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`, `[`TypeDeclaration`](../../com.github.jonathanxd.codeapi.base/-type-declaration/index.md)`>`<br>Resolves or create [TypeDeclaration](../../com.github.jonathanxd.codeapi.base/-type-declaration/index.md) from [bindedType](#) structure and elements (back call to [codeTypeResolver](code-type-resolver.md)). |

### Extension Functions

| Name | Summary |
|---|---|
| [annotationValue](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/annotation-value.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.annotationValue(rType: Class<*>): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) |
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?.asString(simple: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)<br>Convert this value to a literal |
| [toLiteralOrNull](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal-or-null.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteralOrNull(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
