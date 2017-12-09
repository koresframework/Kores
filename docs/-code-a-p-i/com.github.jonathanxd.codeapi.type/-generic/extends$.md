[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.type](../index.md) / [Generic](index.md) / [extends$](.)

# extends$

`fun extends$(s: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Generic`](index.md)

Generic type that extends type variable `s`.

### Parameters

`s` - Type name.

**Return**
New instance of generic type.

`fun extends$(vararg ss: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Generic`](index.md)

Generic type that extends type variables `ss`.

### Parameters

`ss` - Types names.

**Return**
New instance of generic type.

`fun extends$(type: Type): `[`Generic`](index.md)

Generic type that extends type `type`.

### Parameters

`type` - Type.

**Return**
New instance of generic type.

`fun extends$(vararg types: Type): `[`Generic`](index.md)

Generic type that extends types `types`.

### Parameters

`types` - Types.

**Return**
New instance of generic type.

