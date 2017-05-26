[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.type](../index.md) / [GenericTypeBuilder](.)

# GenericTypeBuilder

`class GenericTypeBuilder : `[`Builder`](../-generic-type/-builder/index.md)`<`[`GenericType`](../-generic-type/index.md)`, GenericTypeBuilder>`

Builder of a [GenericType](../-generic-type/index.md).

Examples:

List of String:
`GenericTypeBuilder().withType(List::class.codeType).addOfBound(String::class.codeType).build()`

T extends List of wildcard extends CharSequence: `<T: List<out CharSequence>>` or `<T extends List<? extends CharSequence>>`

```
GenericTypeBuilder().withName("T").withExtendsBound(
  GenericTypeBuilder().withType(List::class.codeType).withExtendsBound(
    GenericTypeBuilder().wildcard().withExtendsBound(CharSequence::class.codeType).build()
  ).build()
)
```

You may also prefer the [Generic](../-generic/index.md) style:

```
Generic.type("T").extends_(
  Generic.type(List::class.codeType).extends_(
    Generic.wildcard().extends_(CharSequence::class.codeType)
  )
)
```

**Attention:All calls of the methods of[Generic](../-generic/index.md)class creates a copy of the`bound`array(except the first call),if you mind performance use theGenericTypeBuilder**

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `GenericTypeBuilder(defaults: `[`GenericType`](../-generic-type/index.md)`)``GenericTypeBuilder()`<br>Builder of a [GenericType](../-generic-type/index.md). |

### Properties

| Name | Summary |
|---|---|
| [bounds](bounds.md) | `var bounds: MutableList<`[`Bound`](../-generic-type/-bound/index.md)`>` |
| [name](name.md) | `var name: String?` |
| [type](type.md) | `var type: `[`CodeType`](../-code-type/index.md)`?` |

### Functions

| Name | Summary |
|---|---|
| [addBound](add-bound.md) | `fun addBound(bound: `[`Bound`](../-generic-type/-bound/index.md)`): `[`Builder`](../-generic-type/-builder/index.md)`<`[`GenericType`](../-generic-type/index.md)`, GenericTypeBuilder>`<br>Adds a bound. |
| [addBounds](add-bounds.md) | `fun addBounds(bounds: Array<`[`Bound`](../-generic-type/-bound/index.md)`>): `[`Builder`](../-generic-type/-builder/index.md)`<`[`GenericType`](../-generic-type/index.md)`, GenericTypeBuilder>`<br>Adds all bounds of [bounds](add-bounds.md#com.github.jonathanxd.codeapi.type.GenericTypeBuilder$addBounds(kotlin.Array((com.github.jonathanxd.codeapi.type.GenericType.Bound)))/bounds) array.`fun addBounds(bounds: Collection<`[`Bound`](../-generic-type/-bound/index.md)`>): `[`Builder`](../-generic-type/-builder/index.md)`<`[`GenericType`](../-generic-type/index.md)`, GenericTypeBuilder>`<br>Adds all bounds of [bounds](add-bounds.md#com.github.jonathanxd.codeapi.type.GenericTypeBuilder$addBounds(kotlin.collections.Collection((com.github.jonathanxd.codeapi.type.GenericType.Bound)))/bounds) collection. |
| [addExtendsBound](add-extends-bound.md) | `fun addExtendsBound(value: `[`CodeType`](../-code-type/index.md)`): `[`Builder`](../-generic-type/-builder/index.md)`<`[`GenericType`](../-generic-type/index.md)`, GenericTypeBuilder>`<br>Adds a extends bound. |
| [addOfBound](add-of-bound.md) | `fun addOfBound(value: `[`CodeType`](../-code-type/index.md)`): `[`Builder`](../-generic-type/-builder/index.md)`<`[`GenericType`](../-generic-type/index.md)`, GenericTypeBuilder>`<br>Adds a `of` bound. Example: A `List of String`. |
| [addSuperBound](add-super-bound.md) | `fun addSuperBound(value: `[`CodeType`](../-code-type/index.md)`): `[`Builder`](../-generic-type/-builder/index.md)`<`[`GenericType`](../-generic-type/index.md)`, GenericTypeBuilder>`<br>Adds a super bound. |
| [build](build.md) | `fun build(): `[`GenericType`](../-generic-type/index.md)<br>Build the object of type [T](#). |
| [wildcard](wildcard.md) | `fun wildcard(): `[`Builder`](../-generic-type/-builder/index.md)`<`[`GenericType`](../-generic-type/index.md)`, GenericTypeBuilder>`<br>See [T.isWildcard](#) |
| [withBounds](with-bounds.md) | `fun withBounds(value: Array<`[`Bound`](../-generic-type/-bound/index.md)`>): `[`Builder`](../-generic-type/-builder/index.md)`<`[`GenericType`](../-generic-type/index.md)`, GenericTypeBuilder>`<br>See [T.bounds](#) |
| [withName](with-name.md) | `fun withName(value: String): `[`Builder`](../-generic-type/-builder/index.md)`<`[`GenericType`](../-generic-type/index.md)`, GenericTypeBuilder>`<br>See [T.name](#). |
| [withType](with-type.md) | `fun withType(value: `[`CodeType`](../-code-type/index.md)`): `[`Builder`](../-generic-type/-builder/index.md)`<`[`GenericType`](../-generic-type/index.md)`, GenericTypeBuilder>`<br>See [T.codeType](#) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): GenericTypeBuilder` |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [self](../../com.github.jonathanxd.codeapi.util/self.md) | `fun <T, S : `[`Builder`](../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<T, S>> `[`Builder`](../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<T, S>.self(): S`<br>Cast from [Builder](../../com.github.jonathanxd.codeapi.builder/-builder/index.md) of [T](#) of implicit type [S](#). |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
