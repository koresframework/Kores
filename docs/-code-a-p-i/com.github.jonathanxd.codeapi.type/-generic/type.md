[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.type](../index.md) / [Generic](index.md) / [type](.)

# type

`val type: String`

Overrides [GenericType.type](../-generic-type/type.md)

Type name, examples:

[String](#) = `java.lang.String`.
[Int](#) = `int`.
`path.to.A.B` = `path.to.A$B`.
`path.to.A.B[][]` = `path.to.A$B[][]`.

**Getter**

Type name, examples:

[String](#) = `java.lang.String`.
[Int](#) = `int`.
`path.to.A.B` = `path.to.A$B`.
`path.to.A.B[][]` = `path.to.A$B[][]`.

`fun type(s: String): `[`Generic`](index.md)

Create a generic type from a name (ex: T, E, R).

### Parameters

`s` - Name.

**Return**
Generic of name.

`fun type(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): `[`Generic`](index.md)

Create a generic type from a type.

### Parameters

`type` - Type.

**Return**
Generic of type.

