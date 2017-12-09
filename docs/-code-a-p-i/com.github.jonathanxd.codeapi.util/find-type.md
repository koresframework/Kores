[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.util](index.md) / [findType](.)

# findType

`fun findType(typeVariables: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<out TypeVariable<*>>?, name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`CodeType`](../com.github.jonathanxd.codeapi.type/-code-type/index.md)`?`

Finds the [TypeVariable](#) that has name [name](find-type.md#com.github.jonathanxd.codeapi.util$findType(kotlin.Array((java.lang.reflect.TypeVariable((java.lang.reflect.GenericDeclaration)))), kotlin.String)/name) and return the [CodeType](../com.github.jonathanxd.codeapi.type/-code-type/index.md) of found [TypeVariable](#).

`fun findType(signature: `[`GenericSignature`](../com.github.jonathanxd.codeapi.generic/-generic-signature/index.md)`?, name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`CodeType`](../com.github.jonathanxd.codeapi.type/-code-type/index.md)`?`

Finds the [GenericType](../com.github.jonathanxd.codeapi.type/-generic-type/index.md) that has name [name](find-type.md#com.github.jonathanxd.codeapi.util$findType(com.github.jonathanxd.codeapi.generic.GenericSignature, kotlin.String)/name) and return the [CodeType](../com.github.jonathanxd.codeapi.type/-code-type/index.md) of found [GenericType](../com.github.jonathanxd.codeapi.type/-generic-type/index.md).

