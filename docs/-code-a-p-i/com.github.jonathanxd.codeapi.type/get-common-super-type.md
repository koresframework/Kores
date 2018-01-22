[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.type](index.md) / [getCommonSuperType](.)

# getCommonSuperType

`fun getCommonSuperType(typeA: Type, typeB: Type): Type?`

Gets common super type of [typeA](get-common-super-type.md#com.github.jonathanxd.codeapi.type$getCommonSuperType(java.lang.reflect.Type, java.lang.reflect.Type)/typeA) and [typeB](get-common-super-type.md#com.github.jonathanxd.codeapi.type$getCommonSuperType(java.lang.reflect.Type, java.lang.reflect.Type)/typeB).

This function returns a super class that both [typeA](get-common-super-type.md#com.github.jonathanxd.codeapi.type$getCommonSuperType(java.lang.reflect.Type, java.lang.reflect.Type)/typeA) and [typeB](get-common-super-type.md#com.github.jonathanxd.codeapi.type$getCommonSuperType(java.lang.reflect.Type, java.lang.reflect.Type)/typeB) extends from.

If either [typeA](get-common-super-type.md#com.github.jonathanxd.codeapi.type$getCommonSuperType(java.lang.reflect.Type, java.lang.reflect.Type)/typeA) or [typeB](get-common-super-type.md#com.github.jonathanxd.codeapi.type$getCommonSuperType(java.lang.reflect.Type, java.lang.reflect.Type)/typeB) is primitive and are not equal, this function returns `null`.

