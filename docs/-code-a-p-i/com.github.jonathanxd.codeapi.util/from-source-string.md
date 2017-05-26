[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.util](index.md) / [fromSourceString](.)

# fromSourceString

`fun fromSourceString(sourceString: String): `[`GenericType`](../com.github.jonathanxd.codeapi.type/-generic-type/index.md)

Parse [generic source string](#) and construct [GenericType](../com.github.jonathanxd.codeapi.type/-generic-type/index.md).

### Parameters

`sourceString` - Source string.

**Return**
Construct a [GenericType](../com.github.jonathanxd.codeapi.type/-generic-type/index.md) from `generic source string`;

`fun fromSourceString(sourceString: String, typeResolver: (String) -> `[`CodeType`](../com.github.jonathanxd.codeapi.type/-code-type/index.md)`): `[`GenericType`](../com.github.jonathanxd.codeapi.type/-generic-type/index.md)
`fun fromSourceString(sourceString: String, typeResolver: `[`CodeTypeResolver`](-code-type-resolver/index.md)`): `[`GenericType`](../com.github.jonathanxd.codeapi.type/-generic-type/index.md)

Parse [generic source string](#) and construct [GenericType](../com.github.jonathanxd.codeapi.type/-generic-type/index.md).

### Parameters

`sourceString` - Source string.

`typeResolver` - Resolves [CodeType](../com.github.jonathanxd.codeapi.type/-code-type/index.md) from [string type](#).

**Return**
Construct a [GenericType](../com.github.jonathanxd.codeapi.type/-generic-type/index.md) from `generic source string`;

