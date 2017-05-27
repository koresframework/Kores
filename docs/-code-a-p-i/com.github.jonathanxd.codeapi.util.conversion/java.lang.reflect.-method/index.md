[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.util.conversion](../index.md) / [java.lang.reflect.Method](.)

### Extensions for java.lang.reflect.Method

| Name | Summary |
|---|---|
| [codeParameters](code-parameters.md) | `val `[`Method`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Method.html)`.codeParameters: List<`[`CodeParameter`](../../com.github.jonathanxd.codeapi.base/-code-parameter/index.md)`>`<br>Gets code parameters of receiver [Method](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Method.html). |
| [isAccessibleFrom](is-accessible-from.md) | `fun `[`Method`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Method.html)`.isAccessibleFrom(typeDeclaration: `[`TypeDeclaration`](../../com.github.jonathanxd.codeapi.base/-type-declaration/index.md)`, override: Boolean = false): Boolean`<br>Returns true if receiver [Method](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Method.html) is accessible from [typeDeclaration](is-accessible-from.md#com.github.jonathanxd.codeapi.util.conversion$isAccessibleFrom(java.lang.reflect.Method, com.github.jonathanxd.codeapi.base.TypeDeclaration, kotlin.Boolean)/typeDeclaration) or accessible to be [overwritten](is-accessible-from.md#com.github.jonathanxd.codeapi.util.conversion$isAccessibleFrom(java.lang.reflect.Method, com.github.jonathanxd.codeapi.base.TypeDeclaration, kotlin.Boolean)/override)
from [typeDeclaration](is-accessible-from.md#com.github.jonathanxd.codeapi.util.conversion$isAccessibleFrom(java.lang.reflect.Method, com.github.jonathanxd.codeapi.base.TypeDeclaration, kotlin.Boolean)/typeDeclaration). |
| [kotlinParameters](kotlin-parameters.md) | `val `[`Method`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Method.html)`.kotlinParameters: List<KParameter>?`<br>Gets kotlin parameters from receiver [Method](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Method.html). |
| [parameterNames](parameter-names.md) | `val `[`Method`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Method.html)`.parameterNames: List<String>`<br>Gets parameter names of receiver [Method](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Method.html). |
| [toMethodDeclaration](to-method-declaration.md) | `fun `[`Method`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Method.html)`.toMethodDeclaration(nameProvider: (Int, `[`Parameter`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Parameter.html)`) -> String = { i, _ -> this.parameterNames[i] }): `[`MethodDeclaration`](../../com.github.jonathanxd.codeapi.base/-method-declaration/index.md)<br>Convert this [Method](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Method.html) to [MethodDeclaration](../../com.github.jonathanxd.codeapi.base/-method-declaration/index.md).`fun `[`Method`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Method.html)`.toMethodDeclaration(superClass: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, nameProvider: (Int, `[`Parameter`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Parameter.html)`) -> String = { i, _ -> this.parameterNames[i] }): `[`MethodDeclaration`](../../com.github.jonathanxd.codeapi.base/-method-declaration/index.md)<br>Convert this [Method](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Method.html) structure to [MethodDeclaration](../../com.github.jonathanxd.codeapi.base/-method-declaration/index.md) structure invoking the super class method. |