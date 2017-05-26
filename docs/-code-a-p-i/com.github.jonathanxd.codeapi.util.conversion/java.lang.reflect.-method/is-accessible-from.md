[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.util.conversion](../index.md) / [java.lang.reflect.Method](index.md) / [isAccessibleFrom](.)

# isAccessibleFrom

`fun `[`Method`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Method.html)`.isAccessibleFrom(typeDeclaration: `[`TypeDeclaration`](../../com.github.jonathanxd.codeapi.base/-type-declaration/index.md)`, override: Boolean = false): Boolean`

Returns true if receiver [Method](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Method.html) is accessible from [typeDeclaration](is-accessible-from.md#com.github.jonathanxd.codeapi.util.conversion$isAccessibleFrom(java.lang.reflect.Method, com.github.jonathanxd.codeapi.base.TypeDeclaration, kotlin.Boolean)/typeDeclaration) or accessible to be [overwritten](is-accessible-from.md#com.github.jonathanxd.codeapi.util.conversion$isAccessibleFrom(java.lang.reflect.Method, com.github.jonathanxd.codeapi.base.TypeDeclaration, kotlin.Boolean)/override)
from [typeDeclaration](is-accessible-from.md#com.github.jonathanxd.codeapi.util.conversion$isAccessibleFrom(java.lang.reflect.Method, com.github.jonathanxd.codeapi.base.TypeDeclaration, kotlin.Boolean)/typeDeclaration).

### Parameters

`override` - True to check if method is accessible to be overwritten by [typeDeclaration](is-accessible-from.md#com.github.jonathanxd.codeapi.util.conversion$isAccessibleFrom(java.lang.reflect.Method, com.github.jonathanxd.codeapi.base.TypeDeclaration, kotlin.Boolean)/typeDeclaration) method.