[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.type](../../index.md) / [CodeTypeResolver](../index.md) / [Multi](.)

# Multi

`class Multi<T> : `[`CodeTypeResolver`](../index.md)`<T?>`

This is a resolver which support multiple resolvers. This resolver
always returns first **valid resolved value** for each operation.

A valid resolved value depends on operations, see documentation.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Multi()`<br>This is a resolver which support multiple resolvers. This resolver
always returns first **valid resolved value** for each operation. |

### Functions

| Name | Summary |
|---|---|
| [addResolver](add-resolver.md) | `fun addResolver(resolver: `[`CodeTypeResolver`](../index.md)`<T?>): Unit`<br>Adds a resolver |
| [getInterfaces](get-interfaces.md) | `fun getInterfaces(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): List<`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`>`<br>First bigger list is returned. |
| [getSuperclass](get-superclass.md) | `fun getSuperclass(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>First non-null and [non-nothing](../../../com.github.jonathanxd.codeapi.common/-code-nothing.md) value is returned, or `null` if no
valid value was found. |
| [isAssignableFrom](is-assignable-from.md) | `fun isAssignableFrom(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, from: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, resolverProvider: (`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`) -> `[`CodeTypeResolver`](../index.md)`<*>): Boolean`<br>Returns true if any resolver returns true for this operation. |
| [minusAssign](minus-assign.md) | `operator fun minusAssign(resolver: `[`CodeTypeResolver`](../index.md)`<T?>): Unit`<br>Removes a resolver |
| [plusAssign](plus-assign.md) | `operator fun plusAssign(resolver: `[`CodeTypeResolver`](../index.md)`<T?>): Unit`<br>Adds a resolver |
| [removeResolver](remove-resolver.md) | `fun removeResolver(resolver: `[`CodeTypeResolver`](../index.md)`<T?>): Unit`<br>Removes a resolver |
| [resolve](resolve.md) | `fun resolve(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): T?`<br>First non-null and [non-nothing](../../../com.github.jonathanxd.codeapi.common/-code-nothing.md) value is returned, or `null` if no
valid value was found. |

### Inherited Functions

| Name | Summary |
|---|---|
| [isAssignableFrom](../is-assignable-from.md) | `open fun isAssignableFrom(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, from: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Boolean`<br>Checks if [type](../is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type)/type) is assignable from [from](../is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeTypeResolver$isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.Type)/from) using default resolvers. |
