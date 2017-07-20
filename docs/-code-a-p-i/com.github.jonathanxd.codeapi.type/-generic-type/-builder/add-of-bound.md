[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.type](../../index.md) / [GenericType](../index.md) / [Builder](index.md) / [addOfBound](.)

# addOfBound

`abstract fun addOfBound(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): `[`Builder`](index.md)`<T, S>`

Adds a `of` bound. Example: A `List of String`.

**Note:This method is used to denote a bound of a concrete type,not of a type variable.**

`open fun addOfBound(value: String): `[`Builder`](index.md)`<T, S>`

Adds a `of` bound. Example: A `List of E`.

**Note:This method is used to denote a bound to a type variable.**

