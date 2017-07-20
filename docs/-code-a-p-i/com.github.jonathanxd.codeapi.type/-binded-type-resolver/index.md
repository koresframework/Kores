[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.type](../index.md) / [BindedTypeResolver](.)

# BindedTypeResolver

`class BindedTypeResolver<out T> : Any`

A type resolver 'binded' to a [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html). All functions delegates to [codeTypeResolver](code-type-resolver.md) and uses [bindType](bind-type.md)
as first argument of functions.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `BindedTypeResolver(bindType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, codeTypeResolver: `[`CodeTypeResolver`](../-code-type-resolver/index.md)`<T>)`<br>A type resolver 'binded' to a [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html). All functions delegates to [codeTypeResolver](-init-.md#com.github.jonathanxd.codeapi.type.BindedTypeResolver$<init>(java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((com.github.jonathanxd.codeapi.type.BindedTypeResolver.T)))/codeTypeResolver) and uses [bindType](-init-.md#com.github.jonathanxd.codeapi.type.BindedTypeResolver$<init>(java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((com.github.jonathanxd.codeapi.type.BindedTypeResolver.T)))/bindType)
as first argument of functions. |

### Properties

| Name | Summary |
|---|---|
| [bindType](bind-type.md) | `val bindType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) |
| [codeTypeResolver](code-type-resolver.md) | `val codeTypeResolver: `[`CodeTypeResolver`](../-code-type-resolver/index.md)`<T>` |

### Functions

| Name | Summary |
|---|---|
| [bindTo](bind-to.md) | `fun bindTo(bindedType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): BindedTypeResolver<T>`<br>Creates a new BindedTypeResolver instance 'binded' to [bindType](bind-type.md). |
| [bindToResolver](bind-to-resolver.md) | `fun <T> bindToResolver(codeTypeResolver: `[`CodeTypeResolver`](../-code-type-resolver/index.md)`<T>): BindedTypeResolver<T>`<br>Creates a new BindedTypeResolver instance which delegate calls to [codeTypeResolver](bind-to-resolver.md#com.github.jonathanxd.codeapi.type.BindedTypeResolver$bindToResolver(com.github.jonathanxd.codeapi.type.CodeTypeResolver((com.github.jonathanxd.codeapi.type.BindedTypeResolver.bindToResolver.T)))/codeTypeResolver). |
| [getInterfaces](get-interfaces.md) | `fun getInterfaces(): List<`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`>`<br>Resolves super interfaces of [bindType](bind-type.md). |
| [getSuperclass](get-superclass.md) | `fun getSuperclass(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Resolves super class of [bindType](bind-type.md) |
| [isAssignableFrom](is-assignable-from.md) | `fun isAssignableFrom(from: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Boolean`<br>Checks if [bindType](bind-type.md) is assignable from [from](is-assignable-from.md#com.github.jonathanxd.codeapi.type.BindedTypeResolver$isAssignableFrom(java.lang.reflect.Type)/from) using default resolvers.`fun isAssignableFrom(from: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, resolverProvider: (`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`) -> `[`CodeTypeResolver`](../-code-type-resolver/index.md)`<*>): Boolean`<br>Checks if [bindType](bind-type.md) is assignable [from](is-assignable-from.md#com.github.jonathanxd.codeapi.type.BindedTypeResolver$isAssignableFrom(java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/from) using resolvers provided by [resolverProvider](is-assignable-from.md#com.github.jonathanxd.codeapi.type.BindedTypeResolver$isAssignableFrom(java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/resolverProvider) |
| [resolve](resolve.md) | `fun resolve(): T`<br>Resolves [bindType](bind-type.md) to [T](#) |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
