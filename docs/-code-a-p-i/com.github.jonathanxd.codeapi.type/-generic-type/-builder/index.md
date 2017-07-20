[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.type](../../index.md) / [GenericType](../index.md) / [Builder](.)

# Builder

`interface Builder<out T : `[`GenericType`](../index.md)`, S : Builder<T, S>> : `[`Builder`](../../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<T, S>`

### Functions

| Name | Summary |
|---|---|
| [addBound](add-bound.md) | `abstract fun addBound(bound: `[`Bound`](../-bound/index.md)`): Builder<T, S>`<br>Adds a bound. |
| [addBounds](add-bounds.md) | `abstract fun addBounds(bounds: Array<`[`Bound`](../-bound/index.md)`>): Builder<T, S>`<br>Adds all bounds of [bounds](add-bounds.md#com.github.jonathanxd.codeapi.type.GenericType.Builder$addBounds(kotlin.Array((com.github.jonathanxd.codeapi.type.GenericType.Bound)))/bounds) array.`abstract fun addBounds(bounds: Collection<`[`Bound`](../-bound/index.md)`>): Builder<T, S>`<br>Adds all bounds of [bounds](add-bounds.md#com.github.jonathanxd.codeapi.type.GenericType.Builder$addBounds(kotlin.collections.Collection((com.github.jonathanxd.codeapi.type.GenericType.Bound)))/bounds) collection. |
| [addExtendsBound](add-extends-bound.md) | `abstract fun addExtendsBound(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder<T, S>`<br>`open fun addExtendsBound(value: String): Builder<T, S>`<br>Adds a extends bound. |
| [addOfBound](add-of-bound.md) | `abstract fun addOfBound(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder<T, S>`<br>Adds a `of` bound. Example: A `List of String`.`open fun addOfBound(value: String): Builder<T, S>`<br>Adds a `of` bound. Example: A `List of E`. |
| [addSuperBound](add-super-bound.md) | `abstract fun addSuperBound(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder<T, S>`<br>`open fun addSuperBound(value: String): Builder<T, S>`<br>Adds a super bound. |
| [bounds](bounds.md) | `abstract fun bounds(value: Array<`[`Bound`](../-bound/index.md)`>): Builder<T, S>`<br>See [T.bounds](bounds.md) |
| [name](name.md) | `abstract fun name(value: String): Builder<T, S>`<br>See [T.name](name.md). |
| [type](type.md) | `abstract fun type(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Builder<T, S>`<br>See [T.codeType](../code-type.md) |
| [wildcard](wildcard.md) | `abstract fun wildcard(): Builder<T, S>`<br>See [T.isWildcard](../is-wildcard.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [build](../../../com.github.jonathanxd.codeapi.builder/-builder/build.md) | `abstract fun build(): T`<br>Build the object of type [T](#). |

### Inheritors

| Name | Summary |
|---|---|
| [GenericTypeBuilder](../../-generic-type-builder/index.md) | `class GenericTypeBuilder : Builder<`[`GenericType`](../index.md)`, `[`GenericTypeBuilder`](../../-generic-type-builder/index.md)`>`<br>Builder of a [GenericType](../index.md). |
