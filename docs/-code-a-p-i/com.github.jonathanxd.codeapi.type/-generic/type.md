[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.type](../index.md) / [Generic](index.md) / [type](.)

# type

`val type: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)

Overrides [GenericType.type](../-generic-type/type.md)

Type name, examples:

[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = `java.lang.String`.
[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = `int`.
`path.to.A.B` = `path.to.A$B`.
`path.to.A.B[][]` = `path.to.A$B[][]`.

**Getter**

Type name, examples:

[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = `java.lang.String`.
[Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = `int`.
`path.to.A.B` = `path.to.A$B`.
`path.to.A.B[][]` = `path.to.A$B[][]`.

`@JvmStatic fun type(s: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Generic`](index.md)

Create a generic type from a name (ex: T, E, R).

### Parameters

`s` - Name.

**Return**
Generic of name.

`@JvmStatic fun type(type: Type): `[`Generic`](index.md)

Create a generic type from a type.

### Parameters

`type` - Type.

**Return**
Generic of type.

