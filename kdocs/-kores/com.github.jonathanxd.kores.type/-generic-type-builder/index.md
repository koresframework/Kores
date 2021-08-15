//[Kores](../../../index.md)/[com.github.jonathanxd.kores.type](../index.md)/[GenericTypeBuilder](index.md)

# GenericTypeBuilder

[jvm]\
class [GenericTypeBuilder](index.md) : [GenericType.Builder](../-generic-type/-builder/index.md)<[GenericType](../-generic-type/index.md), [GenericTypeBuilder](index.md)> 

Builder of a [GenericType](../-generic-type/index.md).

Examples:

List of String: GenericTypeBuilder().withType(List::class.codeType).addOfBound(String::class.codeType).build()

T extends List of wildcard extends CharSequence: <T: List<out CharSequence>> or <T extends List<? extends CharSequence>>

GenericTypeBuilder().withName("T").withExtendsBound(\
  GenericTypeBuilder().withType(List::class.codeType).withExtendsBound(\
    GenericTypeBuilder().wildcard().withExtendsBound(CharSequence::class.codeType).build()\
  ).build()\
)

You may also prefer the [Generic](../-generic/index.md) style:

Generic.type("T").extends_(\
  Generic.type(List::class.codeType).extends_(\
    Generic.wildcard().extends_(CharSequence::class.codeType)\
  )\
)

**Attention: All calls of the methods of** [**Generic**](../-generic/index.md) **class creates a copy of the** **bound** **array (except the first call), if you mind performance use the** [**GenericTypeBuilder**](index.md)

## Constructors

| | |
|---|---|
| [GenericTypeBuilder](-generic-type-builder.md) | [jvm]<br>fun [GenericTypeBuilder](-generic-type-builder.md)(defaults: [GenericType](../-generic-type/index.md)) |
| [GenericTypeBuilder](-generic-type-builder.md) | [jvm]<br>fun [GenericTypeBuilder](-generic-type-builder.md)() |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [addBound](add-bound.md) | [jvm]<br>open override fun [addBound](add-bound.md)(bound: [GenericType.Bound](../-generic-type/-bound/index.md)): [GenericType.Builder](../-generic-type/-builder/index.md)<[GenericType](../-generic-type/index.md), [GenericTypeBuilder](index.md)><br>Adds a bound. |
| [addBounds](add-bounds.md) | [jvm]<br>open override fun [addBounds](add-bounds.md)(bounds: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<[GenericType.Bound](../-generic-type/-bound/index.md)>): [GenericType.Builder](../-generic-type/-builder/index.md)<[GenericType](../-generic-type/index.md), [GenericTypeBuilder](index.md)><br>Adds all bounds of [bounds](add-bounds.md) array.<br>[jvm]<br>open override fun [addBounds](add-bounds.md)(bounds: [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)<[GenericType.Bound](../-generic-type/-bound/index.md)>): [GenericType.Builder](../-generic-type/-builder/index.md)<[GenericType](../-generic-type/index.md), [GenericTypeBuilder](index.md)><br>Adds all bounds of [bounds](add-bounds.md) collection. |
| [addExtendsBound](../-generic-type/-builder/add-extends-bound.md) | [jvm]<br>open fun [addExtendsBound](../-generic-type/-builder/add-extends-bound.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [GenericType.Builder](../-generic-type/-builder/index.md)<[GenericType](../-generic-type/index.md), [GenericTypeBuilder](index.md)><br>open override fun [addExtendsBound](add-extends-bound.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [GenericType.Builder](../-generic-type/-builder/index.md)<[GenericType](../-generic-type/index.md), [GenericTypeBuilder](index.md)><br>Adds a extends bound. |
| [addOfBound](../-generic-type/-builder/add-of-bound.md) | [jvm]<br>open fun [addOfBound](../-generic-type/-builder/add-of-bound.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [GenericType.Builder](../-generic-type/-builder/index.md)<[GenericType](../-generic-type/index.md), [GenericTypeBuilder](index.md)><br>open override fun [addOfBound](add-of-bound.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [GenericType.Builder](../-generic-type/-builder/index.md)<[GenericType](../-generic-type/index.md), [GenericTypeBuilder](index.md)><br>Adds a of bound. |
| [addSuperBound](../-generic-type/-builder/add-super-bound.md) | [jvm]<br>open fun [addSuperBound](../-generic-type/-builder/add-super-bound.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [GenericType.Builder](../-generic-type/-builder/index.md)<[GenericType](../-generic-type/index.md), [GenericTypeBuilder](index.md)><br>open override fun [addSuperBound](add-super-bound.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [GenericType.Builder](../-generic-type/-builder/index.md)<[GenericType](../-generic-type/index.md), [GenericTypeBuilder](index.md)><br>Adds a super bound. |
| [bounds](bounds.md) | [jvm]<br>open override fun [bounds](bounds.md)(value: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<[GenericType.Bound](../-generic-type/-bound/index.md)>): [GenericType.Builder](../-generic-type/-builder/index.md)<[GenericType](../-generic-type/index.md), [GenericTypeBuilder](index.md)><br>See T. |
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [GenericType](../-generic-type/index.md)<br>Build the object of type T. |
| [name](name.md) | [jvm]<br>open override fun [name](name.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [GenericType.Builder](../-generic-type/-builder/index.md)<[GenericType](../-generic-type/index.md), [GenericTypeBuilder](index.md)><br>See T. |
| [type](type.md) | [jvm]<br>open override fun [type](type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [GenericType.Builder](../-generic-type/-builder/index.md)<[GenericType](../-generic-type/index.md), [GenericTypeBuilder](index.md)><br>See T. |
| [wildcard](wildcard.md) | [jvm]<br>open override fun [wildcard](wildcard.md)(): [GenericType.Builder](../-generic-type/-builder/index.md)<[GenericType](../-generic-type/index.md), [GenericTypeBuilder](index.md)><br>See T. |

## Properties

| Name | Summary |
|---|---|
| [bounds](bounds.md) | [jvm]<br>var [bounds](bounds.md): [MutableList](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)<[GenericType.Bound](../-generic-type/-bound/index.md)> |
| [name](name.md) | [jvm]<br>var [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null |
| [type](type.md) | [jvm]<br>var [type](type.md): [KoresType](../-kores-type/index.md)? = null |
