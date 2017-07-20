[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.util](../index.md) / [java.lang.reflect.Type](index.md) / [descriptor](.)

# descriptor

`val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.descriptor: String`

Converts `this` type to type descriptor.

A type descriptor is formatted as:

* `TYPE_JAVA_SPEC` (specified by [CodeType.javaSpecName](../../com.github.jonathanxd.codeapi.type/-code-type/java-spec-name.md)) when receiver [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) is not a [GenericType](../../com.github.jonathanxd.codeapi.type/-generic-type/index.md)
* `TYPE_NAME` when receiver is a [GenericType](../../com.github.jonathanxd.codeapi.type/-generic-type/index.md), does not have bounds and is a wildcard (and not a type).
* `(T)(TYPE_NAME);` when receiver is a [GenericType](../../com.github.jonathanxd.codeapi.type/-generic-type/index.md), does not have bounds and is neither a wildcard nor a type.
* `TYPE_NAME;` when receiver is a [GenericType](../../com.github.jonathanxd.codeapi.type/-generic-type/index.md), and is a type.
* `TYPE_NAME<BOUNDS>;` when receiver is a [GenericType](../../com.github.jonathanxd.codeapi.type/-generic-type/index.md), have bounds and the receiver is not a wildcard.

Note: `()` is only used to make the format more readable and will not be generated in descriptors.

