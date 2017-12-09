[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.util.conversion](../index.md) / [java.lang.reflect.Method](index.md) / [isAccessibleFrom](.)

# isAccessibleFrom

`@JvmOverloads fun Method.isAccessibleFrom(typeDeclaration: `[`TypeDeclaration`](../../com.github.jonathanxd.codeapi.base/-type-declaration/index.md)`, override: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Returns true if receiver [Method](#) is accessible from [typeDeclaration](is-accessible-from.md#com.github.jonathanxd.codeapi.util.conversion$isAccessibleFrom(java.lang.reflect.Method, com.github.jonathanxd.codeapi.base.TypeDeclaration, kotlin.Boolean)/typeDeclaration) or accessible to be [overwritten](is-accessible-from.md#com.github.jonathanxd.codeapi.util.conversion$isAccessibleFrom(java.lang.reflect.Method, com.github.jonathanxd.codeapi.base.TypeDeclaration, kotlin.Boolean)/override)
from [typeDeclaration](is-accessible-from.md#com.github.jonathanxd.codeapi.util.conversion$isAccessibleFrom(java.lang.reflect.Method, com.github.jonathanxd.codeapi.base.TypeDeclaration, kotlin.Boolean)/typeDeclaration).

### Parameters

`override` - True to check if method is accessible to be overwritten by [typeDeclaration](is-accessible-from.md#com.github.jonathanxd.codeapi.util.conversion$isAccessibleFrom(java.lang.reflect.Method, com.github.jonathanxd.codeapi.base.TypeDeclaration, kotlin.Boolean)/typeDeclaration) method.