//[Kores](../../../../index.md)/[com.koresframework.kores.type](../../index.md)/[GenericType](../index.md)/[Builder](index.md)/[addOfBound](add-of-bound.md)

# addOfBound

[jvm]\
abstract fun [addOfBound](add-of-bound.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [GenericType.Builder](index.md)<[T](index.md), [S](index.md)>

Adds a of bound. Example: A List of String.

**Note: This method is used to denote a bound of a concrete type, not of a type variable.**

[jvm]\
open fun [addOfBound](add-of-bound.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [GenericType.Builder](index.md)<[T](index.md), [S](index.md)>

Adds a of bound. Example: A List of E.

**Note: This method is used to denote a bound to a type variable.**
