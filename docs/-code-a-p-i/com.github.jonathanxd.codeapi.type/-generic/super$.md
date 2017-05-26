[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.type](../index.md) / [Generic](index.md) / [super$](.)

# super$

`fun super$(s: String): `[`Generic`](index.md)

Generic type that have a super type variable `s`.

### Parameters

`s` - Type variable.

**Return**
New instance of generic type.

`fun super$(vararg ss: String): `[`Generic`](index.md)

Generic type that have a super type variables `ss`.

### Parameters

`ss` - Type variables.

**Return**
New instance of generic type.

`fun super$(type: `[`CodeType`](../-code-type/index.md)`): `[`Generic`](index.md)
`fun super$(type: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<*>): `[`Generic`](index.md)

Generic type that have a super type `type`.

### Parameters

`type` - Type.

**Return**
New instance of generic type.

`fun super$(vararg types: `[`CodeType`](../-code-type/index.md)`): `[`Generic`](index.md)
`fun super$(vararg types: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<*>): `[`Generic`](index.md)

Generic type that have a super types `types`.

### Parameters

`types` - Types.

**Return**
New instance of generic type.

