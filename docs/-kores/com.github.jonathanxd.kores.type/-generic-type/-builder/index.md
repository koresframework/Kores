//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.type](../../index.md)/[GenericType](../index.md)/[Builder](index.md)

# Builder

[jvm]\
interface [Builder](index.md)<out [T](index.md) : [GenericType](../index.md), [S](index.md) : [GenericType.Builder](index.md)<[T](index.md), [S](index.md)>> : [Builder](../../../com.github.jonathanxd.kores.builder/-builder/index.md)<[T](index.md), [S](index.md)>

## Functions

| Name | Summary |
|---|---|
| [addBound](add-bound.md) | [jvm]<br>abstract fun [addBound](add-bound.md)(bound: [GenericType.Bound](../-bound/index.md)): [GenericType.Builder](index.md)<[T](index.md), [S](index.md)><br>Adds a bound. |
| [addBounds](add-bounds.md) | [jvm]<br>abstract fun [addBounds](add-bounds.md)(bounds: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<[GenericType.Bound](../-bound/index.md)>): [GenericType.Builder](index.md)<[T](index.md), [S](index.md)><br>Adds all bounds of [bounds](add-bounds.md) array.<br>[jvm]<br>abstract fun [addBounds](add-bounds.md)(bounds: [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)<[GenericType.Bound](../-bound/index.md)>): [GenericType.Builder](index.md)<[T](index.md), [S](index.md)><br>Adds all bounds of [bounds](add-bounds.md) collection. |
| [addExtendsBound](add-extends-bound.md) | [jvm]<br>abstract fun [addExtendsBound](add-extends-bound.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [GenericType.Builder](index.md)<[T](index.md), [S](index.md)><br>open fun [addExtendsBound](add-extends-bound.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [GenericType.Builder](index.md)<[T](index.md), [S](index.md)><br>Adds a extends bound. |
| [addOfBound](add-of-bound.md) | [jvm]<br>abstract fun [addOfBound](add-of-bound.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [GenericType.Builder](index.md)<[T](index.md), [S](index.md)><br>open fun [addOfBound](add-of-bound.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [GenericType.Builder](index.md)<[T](index.md), [S](index.md)><br>Adds a of bound. |
| [addSuperBound](add-super-bound.md) | [jvm]<br>abstract fun [addSuperBound](add-super-bound.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [GenericType.Builder](index.md)<[T](index.md), [S](index.md)><br>open fun [addSuperBound](add-super-bound.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [GenericType.Builder](index.md)<[T](index.md), [S](index.md)><br>Adds a super bound. |
| [bounds](bounds.md) | [jvm]<br>abstract fun [bounds](bounds.md)(value: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<[GenericType.Bound](../-bound/index.md)>): [GenericType.Builder](index.md)<[T](index.md), [S](index.md)><br>See T. |
| [build](../../../com.github.jonathanxd.kores.builder/-builder/build.md) | [jvm]<br>abstract fun [build](../../../com.github.jonathanxd.kores.builder/-builder/build.md)(): [T](index.md)<br>Build the object of type [T](../../../com.github.jonathanxd.kores.builder/-builder/index.md). |
| [name](name.md) | [jvm]<br>abstract fun [name](name.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [GenericType.Builder](index.md)<[T](index.md), [S](index.md)><br>See T. |
| [type](type.md) | [jvm]<br>abstract fun [type](type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [GenericType.Builder](index.md)<[T](index.md), [S](index.md)><br>See T. |
| [wildcard](wildcard.md) | [jvm]<br>abstract fun [wildcard](wildcard.md)(): [GenericType.Builder](index.md)<[T](index.md), [S](index.md)><br>See T. |

## Inheritors

| Name |
|---|
| [AnnotatedKoresType.GenericAnnotatedKoresType](../../-annotated-kores-type/-generic-annotated-kores-type/-generic-builder/index.md) |
| [GenericTypeBuilder](../../-generic-type-builder/index.md) |
