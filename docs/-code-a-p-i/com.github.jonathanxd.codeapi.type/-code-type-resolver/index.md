[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.type](../index.md) / [CodeTypeResolver](.)

# CodeTypeResolver

`interface CodeTypeResolver<out T> : Any`

Type resolver. Type resolvers should never throws and error when it is unable to resolve
result of an operation. The operation should return `null` - in the cases which `null` is allowed -
return [CodeNothing](../../com.github.jonathanxd.codeapi.common/-code-nothing.md), empty [List](#) or `false` when the resolver is unable to resolve the result of
operation. These semantics are required to [Multi](-multi/index.md) work correctly with any resolver.

### Types

| Name | Summary |
|---|---|
| [CodeAPI](-code-a-p-i/index.md) | `class CodeAPI : `[`CommonResolver`](-common-resolver/index.md)`<`[`TypeDeclaration`](../../com.github.jonathanxd.codeapi.base/-type-declaration/index.md)`?>`<br>CodeAPI Resolver. |
| [CommonResolver](-common-resolver/index.md) | `abstract class CommonResolver<out T> : CodeTypeResolver<T>`<br>Common implementation of resolver. |
| [DefaultResolver](-default-resolver/index.md) | `object DefaultResolver : `[`CommonResolver`](-common-resolver/index.md)`<`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`>`<br>Default resolver that returns the same instance for [resolve](-default-resolver/resolve.md) method. |
| [Java](-java/index.md) | `class Java : `[`CommonResolver`](-common-resolver/index.md)`<`[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<*>>`<br>Resolver that resolves [CodeType](../-code-type/index.md) to Java [Class](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html). This may resolve to [CodeNothing.type](#)
is class loader fails to find class. |
| [Model](-model/index.md) | `class Model : `[`CommonResolver`](-common-resolver/index.md)`<`[`TypeElement`](http://docs.oracle.com/javase/6/docs/api/javax/lang/model/element/TypeElement.html)`?>`<br>Resolver that resolves [CodeType](../-code-type/index.md) to Javax Model [TypeElement](http://docs.oracle.com/javase/6/docs/api/javax/lang/model/element/TypeElement.html), or to `null`
if type cannot be found. |
| [Multi](-multi/index.md) | `class Multi<T> : CodeTypeResolver<T?>`<br>This is a resolver which support multiple resolvers. This resolver
always returns first **valid resolved value** for each operation. |

### Functions

| Name | Summary |
|---|---|
| [getInterfaces](get-interfaces.md) | `abstract fun getInterfaces(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): List<`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`>`<br>Resolves super interfaces of [type](get-interfaces.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$getInterfaces(java.lang.reflect.Type)/type). |
| [getSuperclass](get-superclass.md) | `abstract fun getSuperclass(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Resolves super class of [type](get-superclass.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$getSuperclass(java.lang.reflect.Type)/type) |
| [isAssignableFrom](is-assignable-from.md) | `open fun isAssignableFrom(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, from: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Boolean`<br>Checks if [type](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type)/type) is assignable from [from](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type)/from) using default resolvers.`abstract fun isAssignableFrom(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, from: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, resolverProvider: (`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`) -> CodeTypeResolver<*>): Boolean`<br>Checks if [type](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/type) is assignable [from](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/from) using resolvers provided by [resolverProvider](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/resolverProvider) |
| [resolve](resolve.md) | `abstract fun resolve(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): T`<br>Resolves [type](resolve.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$resolve(java.lang.reflect.Type)/type) to [T](#) |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |

### Inheritors

| Name | Summary |
|---|---|
| [CommonResolver](-common-resolver/index.md) | `abstract class CommonResolver<out T> : CodeTypeResolver<T>`<br>Common implementation of resolver. |
| [Multi](-multi/index.md) | `class Multi<T> : CodeTypeResolver<T?>`<br>This is a resolver which support multiple resolvers. This resolver
always returns first **valid resolved value** for each operation. |
