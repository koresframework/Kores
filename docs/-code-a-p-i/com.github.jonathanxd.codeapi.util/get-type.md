[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.util](index.md) / [getType](.)

# getType

`fun getType(typeVariables: Array<out `[`TypeVariable`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/TypeVariable.html)`<*>>, variable: `[`TypeVariable`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/TypeVariable.html)`<*>, generic: `[`GenericType`](../com.github.jonathanxd.codeapi.type/-generic-type/index.md)`): `[`CodeType`](../com.github.jonathanxd.codeapi.type/-code-type/index.md)`?`

Resolves the [CodeType](../com.github.jonathanxd.codeapi.type/-code-type/index.md) of [variable](get-type.md#com.github.jonathanxd.codeapi.util$getType(kotlin.Array((java.lang.reflect.TypeVariable((java.lang.reflect.GenericDeclaration)))), java.lang.reflect.TypeVariable((java.lang.reflect.GenericDeclaration)), com.github.jonathanxd.codeapi.type.GenericType)/variable) of [typeVariables](get-type.md#com.github.jonathanxd.codeapi.util$getType(kotlin.Array((java.lang.reflect.TypeVariable((java.lang.reflect.GenericDeclaration)))), java.lang.reflect.TypeVariable((java.lang.reflect.GenericDeclaration)), com.github.jonathanxd.codeapi.type.GenericType)/typeVariables) using types provided by [generic](get-type.md#com.github.jonathanxd.codeapi.util$getType(kotlin.Array((java.lang.reflect.TypeVariable((java.lang.reflect.GenericDeclaration)))), java.lang.reflect.TypeVariable((java.lang.reflect.GenericDeclaration)), com.github.jonathanxd.codeapi.type.GenericType)/generic).

`fun getType(typeVariables: Array<out `[`TypeVariable`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/TypeVariable.html)`<*>>, variable: String, generic: `[`GenericType`](../com.github.jonathanxd.codeapi.type/-generic-type/index.md)`): `[`CodeType`](../com.github.jonathanxd.codeapi.type/-code-type/index.md)`?`

Resolves the [CodeType](../com.github.jonathanxd.codeapi.type/-code-type/index.md) of variable with name [variable](get-type.md#com.github.jonathanxd.codeapi.util$getType(kotlin.Array((java.lang.reflect.TypeVariable((java.lang.reflect.GenericDeclaration)))), kotlin.String, com.github.jonathanxd.codeapi.type.GenericType)/variable) of [typeVariables](get-type.md#com.github.jonathanxd.codeapi.util$getType(kotlin.Array((java.lang.reflect.TypeVariable((java.lang.reflect.GenericDeclaration)))), kotlin.String, com.github.jonathanxd.codeapi.type.GenericType)/typeVariables) using types provided by [generic](get-type.md#com.github.jonathanxd.codeapi.util$getType(kotlin.Array((java.lang.reflect.TypeVariable((java.lang.reflect.GenericDeclaration)))), kotlin.String, com.github.jonathanxd.codeapi.type.GenericType)/generic).

### Parameters

`typeVariables` - Class Type variables

`variable` - Variable name to find type

`generic` - Generic type with types of [typeVariables](get-type.md#com.github.jonathanxd.codeapi.util$getType(kotlin.Array((java.lang.reflect.TypeVariable((java.lang.reflect.GenericDeclaration)))), kotlin.String, com.github.jonathanxd.codeapi.type.GenericType)/typeVariables)

`fun `[`CodeType`](../com.github.jonathanxd.codeapi.type/-code-type/index.md)`.getType(name: String): `[`CodeType`](../com.github.jonathanxd.codeapi.type/-code-type/index.md)`?`
`fun `[`CodeType`](../com.github.jonathanxd.codeapi.type/-code-type/index.md)`.getType(name: String, inside: `[`CodeType`](../com.github.jonathanxd.codeapi.type/-code-type/index.md)`): `[`CodeType`](../com.github.jonathanxd.codeapi.type/-code-type/index.md)`?`
`fun `[`GenericType`](../com.github.jonathanxd.codeapi.type/-generic-type/index.md)`.getType(name: String): `[`CodeType`](../com.github.jonathanxd.codeapi.type/-code-type/index.md)`?`
`fun `[`GenericType`](../com.github.jonathanxd.codeapi.type/-generic-type/index.md)`.getType(name: String, inside: `[`CodeType`](../com.github.jonathanxd.codeapi.type/-code-type/index.md)`): `[`CodeType`](../com.github.jonathanxd.codeapi.type/-code-type/index.md)`?`