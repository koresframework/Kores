[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.util](../index.md) / [GenericTypeVariable](.)

# GenericTypeVariable

`class GenericTypeVariable : `[`TypeVariable`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/TypeVariable.html)`<`[`GenericDeclaration`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/GenericDeclaration.html)`>`

Wrapper of [CodeType](../../com.github.jonathanxd.codeapi.type/-code-type/index.md) to [TypeVariable](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/TypeVariable.html). This class is a little complex and is not intended to be used by
external sources.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `GenericTypeVariable(type: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`?, wrapped: `[`TypeVariable`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/TypeVariable.html)`<out `[`GenericDeclaration`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/GenericDeclaration.html)`>?, bounds: Array<`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`>)`<br>`GenericTypeVariable(type: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`?, wrapped: `[`TypeVariable`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/TypeVariable.html)`<out `[`GenericDeclaration`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/GenericDeclaration.html)`>?, name: String?, bounds: Array<`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`>)`<br>`GenericTypeVariable(type: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`?, wrappedType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?, bounds: Array<`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`>)` |

### Properties

| Name | Summary |
|---|---|
| [type](type.md) | `val type: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`?` |

### Functions

| Name | Summary |
|---|---|
| [getAnnotatedBounds](get-annotated-bounds.md) | `fun getAnnotatedBounds(): Array<`[`AnnotatedType`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/AnnotatedType.html)`>` |
| [getAnnotation](get-annotation.md) | `fun <T : Annotation> getAnnotation(annotationClass: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<T>): T?` |
| [getAnnotations](get-annotations.md) | `fun getAnnotations(): Array<Annotation>` |
| [getBounds](get-bounds.md) | `fun getBounds(): Array<`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`>` |
| [getDeclaredAnnotations](get-declared-annotations.md) | `fun getDeclaredAnnotations(): Array<Annotation>` |
| [getGenericDeclaration](get-generic-declaration.md) | `fun getGenericDeclaration(): `[`GenericDeclaration`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/GenericDeclaration.html)`?` |
| [getName](get-name.md) | `fun getName(): String` |

### Extension Properties

| Name | Summary |
|---|---|
| [codeType](../java.lang.reflect.-type/code-type.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.codeType: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md) |

### Extension Functions

| Name | Summary |
|---|---|
| [asString](../kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [getType](../java.lang.reflect.-type/get-type.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.getType(isParameterized: Boolean = false): `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md) |
| [is](../java.lang.reflect.-type/is.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.is(another: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Boolean` |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
