[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.util.conversion](../index.md) / [java.lang.Class](index.md) / [toStructure](.)

# toStructure

`fun <T : Any> `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<T>.toStructure(includeFields: Boolean = true, includeMethods: Boolean = true, includeSubClasses: Boolean = true): List<`[`TypeDeclaration`](../../com.github.jonathanxd.codeapi.base/-type-declaration/index.md)`>`

Convert this [Class](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html) structure to [TypeDeclaration](../../com.github.jonathanxd.codeapi.base/-type-declaration/index.md)s (first element is the
input class, other elements is inner-classes).

### Parameters

`includeFields` - True to include fields.

`includeMethods` - True to include methods.

`includeSubClasses` - True to include sub classes.

**Return**
[TypeDeclaration](../../com.github.jonathanxd.codeapi.base/-type-declaration/index.md) structure from [Class](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html).

