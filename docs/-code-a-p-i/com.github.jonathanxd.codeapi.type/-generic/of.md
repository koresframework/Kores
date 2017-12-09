[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.type](../index.md) / [Generic](index.md) / [of](.)

# of

`fun of(bound: `[`Bound`](../-generic-type/-bound/index.md)`): `[`Generic`](index.md)

Add a bound.

### Parameters

`bound` - Bound.

**Return**
New instance of generic type.

`fun of(vararg bounds: `[`Bound`](../-generic-type/-bound/index.md)`): `[`Generic`](index.md)

Add all [bounds](of.md#com.github.jonathanxd.codeapi.type.Generic$of(kotlin.Array((com.github.jonathanxd.codeapi.type.GenericType.Bound)))/bounds).

### Parameters

`bounds` - Bounds.

**Return**
New instance of generic type.

`fun of(s: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Generic`](index.md)

Add a name bound.

### Parameters

`s` - Name.

**Return**
New instance of generic type.

`fun of(vararg ss: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Generic`](index.md)

Add name bounds.

### Parameters

`ss` - Names.

**Return**
New instance of generic type.

`fun of(type: Type): `[`Generic`](index.md)

Add a type bound.

### Parameters

`type` - Type.

**Return**
New instance of generic type.

`fun of(vararg types: Type): `[`Generic`](index.md)

Add type bounds.

### Parameters

`types` - Types.

**Return**
New instance of generic type.

