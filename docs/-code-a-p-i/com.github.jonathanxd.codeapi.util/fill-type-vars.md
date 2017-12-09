[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.util](index.md) / [fillTypeVars](.)

# fillTypeVars

`fun fillTypeVars(theClass: Class<*>, generic: `[`GenericType`](../com.github.jonathanxd.codeapi.type/-generic-type/index.md)`): `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<out TypeVariable<*>>`

Fill type variables of [theClass](fill-type-vars.md#com.github.jonathanxd.codeapi.util$fillTypeVars(java.lang.Class((kotlin.Any)), com.github.jonathanxd.codeapi.type.GenericType)/theClass) using types provided by [generic](fill-type-vars.md#com.github.jonathanxd.codeapi.util$fillTypeVars(java.lang.Class((kotlin.Any)), com.github.jonathanxd.codeapi.type.GenericType)/generic)

`fun fillTypeVars(typeParameters: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<out TypeVariable<*>>, generic: `[`GenericType`](../com.github.jonathanxd.codeapi.type/-generic-type/index.md)`): `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<TypeVariable<*>>`

Fill [typeParameters](fill-type-vars.md#com.github.jonathanxd.codeapi.util$fillTypeVars(kotlin.Array((java.lang.reflect.TypeVariable((java.lang.reflect.GenericDeclaration)))), com.github.jonathanxd.codeapi.type.GenericType)/typeParameters) using types provided by [generic](fill-type-vars.md#com.github.jonathanxd.codeapi.util$fillTypeVars(kotlin.Array((java.lang.reflect.TypeVariable((java.lang.reflect.GenericDeclaration)))), com.github.jonathanxd.codeapi.type.GenericType)/generic).

