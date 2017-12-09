[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.util](index.md) / [fromSourceString](.)

# fromSourceString

`fun fromSourceString(sourceString: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`GenericType`](../com.github.jonathanxd.codeapi.type/-generic-type/index.md)

Parse [generic source string](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) and construct [GenericType](../com.github.jonathanxd.codeapi.type/-generic-type/index.md).

### Parameters

`sourceString` - Source string.

**Return**
Construct a [GenericType](../com.github.jonathanxd.codeapi.type/-generic-type/index.md) from `generic source string`;

`fun fromSourceString(sourceString: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, typeResolver: (`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`) -> `[`CodeType`](../com.github.jonathanxd.codeapi.type/-code-type/index.md)`): `[`GenericType`](../com.github.jonathanxd.codeapi.type/-generic-type/index.md)
`fun fromSourceString(sourceString: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, typeResolver: `[`CodeTypeResolverFunc`](-code-type-resolver-func/index.md)`): `[`GenericType`](../com.github.jonathanxd.codeapi.type/-generic-type/index.md)

Parse [generic source string](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) and construct [GenericType](../com.github.jonathanxd.codeapi.type/-generic-type/index.md).

### Parameters

`sourceString` - Source string.

`typeResolver` - Resolves [CodeType](../com.github.jonathanxd.codeapi.type/-code-type/index.md) from [string type](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html).

**Return**
Construct a [GenericType](../com.github.jonathanxd.codeapi.type/-generic-type/index.md) from `generic source string`;

