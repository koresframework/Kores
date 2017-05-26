[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.type](../index.md) / [CodeTypeResolver](.)

# CodeTypeResolver

`interface CodeTypeResolver<out T> : Any`

Type resolver

### Types

| Name | Summary |
|---|---|
| [CommonResolver](-common-resolver/index.md) | `abstract class CommonResolver<out T> : CodeTypeResolver<T>`<br>Common implementation of resolver. |
| [DefaultResolver](-default-resolver/index.md) | `object DefaultResolver : `[`CommonResolver`](-common-resolver/index.md)`<`[`CodeType`](../-code-type/index.md)`>`<br>Default resolver that returns the same instance for [resolve](-default-resolver/resolve.md) method. |
| [Java](-java/index.md) | `class Java : `[`CommonResolver`](-common-resolver/index.md)`<`[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<*>>`<br>Resolver that resolves [CodeType](../-code-type/index.md) to Java [Class](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html) |
| [Model](-model/index.md) | `class Model : `[`CommonResolver`](-common-resolver/index.md)`<`[`TypeElement`](http://docs.oracle.com/javase/6/docs/api/javax/lang/model/element/TypeElement.html)`>`<br>Resolver that resolves [CodeType](../-code-type/index.md) to Javax Model [TypeElement](http://docs.oracle.com/javase/6/docs/api/javax/lang/model/element/TypeElement.html) |

### Functions

| Name | Summary |
|---|---|
| [getInterfaces](get-interfaces.md) | `abstract fun getInterfaces(codeType: `[`CodeType`](../-code-type/index.md)`): List<`[`CodeType`](../-code-type/index.md)`>`<br>Gets super interfaces of [codeType](get-interfaces.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$getInterfaces(com.github.jonathanxd.codeapi.type.CodeType)/codeType). |
| [getSuperclass](get-superclass.md) | `abstract fun getSuperclass(codeType: `[`CodeType`](../-code-type/index.md)`): `[`CodeType`](../-code-type/index.md)`?`<br>Gets super classes of [codeType](get-superclass.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$getSuperclass(com.github.jonathanxd.codeapi.type.CodeType)/codeType) |
| [isAssignableFrom](is-assignable-from.md) | `open fun isAssignableFrom(codeType: `[`CodeType`](../-code-type/index.md)`, from: `[`CodeType`](../-code-type/index.md)`): Boolean`<br>Checks if [codeType](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$isAssignableFrom(com.github.jonathanxd.codeapi.type.CodeType, com.github.jonathanxd.codeapi.type.CodeType)/codeType) is assignable from [from](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$isAssignableFrom(com.github.jonathanxd.codeapi.type.CodeType, com.github.jonathanxd.codeapi.type.CodeType)/from) using default resolvers.`abstract fun isAssignableFrom(codeType: `[`CodeType`](../-code-type/index.md)`, from: `[`CodeType`](../-code-type/index.md)`, resolverProvider: (`[`CodeType`](../-code-type/index.md)`) -> CodeTypeResolver<*>): Boolean`<br>Checks if [codeType](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$isAssignableFrom(com.github.jonathanxd.codeapi.type.CodeType, com.github.jonathanxd.codeapi.type.CodeType, kotlin.Function1((com.github.jonathanxd.codeapi.type.CodeType, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/codeType) is assignable [from](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$isAssignableFrom(com.github.jonathanxd.codeapi.type.CodeType, com.github.jonathanxd.codeapi.type.CodeType, kotlin.Function1((com.github.jonathanxd.codeapi.type.CodeType, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/from) using resolvers provided by [resolverProvider](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$isAssignableFrom(com.github.jonathanxd.codeapi.type.CodeType, com.github.jonathanxd.codeapi.type.CodeType, kotlin.Function1((com.github.jonathanxd.codeapi.type.CodeType, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/resolverProvider) |
| [resolve](resolve.md) | `abstract fun resolve(codeType: `[`CodeType`](../-code-type/index.md)`): T`<br>Resolver [codeType](resolve.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$resolve(com.github.jonathanxd.codeapi.type.CodeType)/codeType) to [T](#) |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |

### Inheritors

| Name | Summary |
|---|---|
| [CommonResolver](-common-resolver/index.md) | `abstract class CommonResolver<out T> : CodeTypeResolver<T>`<br>Common implementation of resolver. |
