[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.util.conversion](../index.md) / [java.lang.reflect.Method](index.md) / [toMethodDeclaration](.)

# toMethodDeclaration

`fun `[`Method`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Method.html)`.toMethodDeclaration(nameProvider: (Int, `[`Parameter`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Parameter.html)`) -> String = { i, _ -> this.parameterNames[i] }): `[`MethodDeclaration`](../../com.github.jonathanxd.codeapi.base/-method-declaration/index.md)

Convert this [Method](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Method.html) to [MethodDeclaration](../../com.github.jonathanxd.codeapi.base/-method-declaration/index.md).

### Parameters

`nameProvider` - Provider of parameter names.

**Return**
[MethodDeclaration](../../com.github.jonathanxd.codeapi.base/-method-declaration/index.md).

`fun `[`Method`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Method.html)`.toMethodDeclaration(superClass: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, nameProvider: (Int, `[`Parameter`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Parameter.html)`) -> String = { i, _ -> this.parameterNames[i] }): `[`MethodDeclaration`](../../com.github.jonathanxd.codeapi.base/-method-declaration/index.md)

Convert this [Method](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Method.html) structure to [MethodDeclaration](../../com.github.jonathanxd.codeapi.base/-method-declaration/index.md) structure invoking the super class method.

### Parameters

`superClass` - super class to invoke

`nameProvider` - Provider of parameter names.

**Return**
[MethodDeclaration](../../com.github.jonathanxd.codeapi.base/-method-declaration/index.md) structure from [Method](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Method.html) invoking super class method.

