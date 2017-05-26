[CodeAPI](../index.md) / [com.github.jonathanxd.codeapi.util.conversion](index.md) / [extend](.)

# extend

`fun <T : `[`TypeDeclaration`](../com.github.jonathanxd.codeapi.base/-type-declaration/index.md)`> T.extend(klass: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<*>): T`

Makes the declaration [T](#) extend the [Class](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html) overriding all public/protected methods
and invoking the super method.

### Parameters

`klass` - Class to extend

**Return**
The declaration extending the [klass](extend.md#com.github.jonathanxd.codeapi.util.conversion$extend(com.github.jonathanxd.codeapi.util.conversion.extend.T, java.lang.Class((kotlin.Any)))/klass) and overriding all public/protected methods.

