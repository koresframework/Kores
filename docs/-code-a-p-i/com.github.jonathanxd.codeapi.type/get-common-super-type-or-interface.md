[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.type](index.md) / [getCommonSuperTypeOrInterface](.)

# getCommonSuperTypeOrInterface

`fun getCommonSuperTypeOrInterface(typeA: Type, typeB: Type): Type?`

Gets common super type of [typeA](get-common-super-type-or-interface.md#com.github.jonathanxd.codeapi.type$getCommonSuperTypeOrInterface(java.lang.reflect.Type, java.lang.reflect.Type)/typeA) and [typeB](get-common-super-type-or-interface.md#com.github.jonathanxd.codeapi.type$getCommonSuperTypeOrInterface(java.lang.reflect.Type, java.lang.reflect.Type)/typeB).

This function returns a class or an interface that both [typeA](get-common-super-type-or-interface.md#com.github.jonathanxd.codeapi.type$getCommonSuperTypeOrInterface(java.lang.reflect.Type, java.lang.reflect.Type)/typeA) and [typeB](get-common-super-type-or-interface.md#com.github.jonathanxd.codeapi.type$getCommonSuperTypeOrInterface(java.lang.reflect.Type, java.lang.reflect.Type)/typeB) extends from,
first the function tries to get a common *super class*, and then a common *interface*.

If [typeA](get-common-super-type-or-interface.md#com.github.jonathanxd.codeapi.type$getCommonSuperTypeOrInterface(java.lang.reflect.Type, java.lang.reflect.Type)/typeA), [typeB](get-common-super-type-or-interface.md#com.github.jonathanxd.codeapi.type$getCommonSuperTypeOrInterface(java.lang.reflect.Type, java.lang.reflect.Type)/typeB) or both are primitive but not equal, `null` is returned.

