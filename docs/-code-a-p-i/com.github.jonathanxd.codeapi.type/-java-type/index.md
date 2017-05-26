[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.type](../index.md) / [JavaType](.)

# JavaType

`open class JavaType<T> : `[`LoadedCodeType`](../-loaded-code-type/index.md)`<T>`

Java class [CodeType](../-code-type/index.md).

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `JavaType(loadedType: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<T>)`<br>Java class [CodeType](../-code-type/index.md). |

### Properties

| Name | Summary |
|---|---|
| [loadedType](loaded-type.md) | `open val loadedType: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<T>`<br>Loaded class. |

### Inherited Properties

| Name | Summary |
|---|---|
| [canonicalName](../-loaded-code-type/canonical-name.md) | `open val canonicalName: String`<br>Canonical name |
| [defaultResolver](../-loaded-code-type/default-resolver.md) | `open val defaultResolver: `[`CodeTypeResolver`](../-code-type-resolver/index.md)`<`[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<*>>`<br>Default resolver. |
| [isArray](../-loaded-code-type/is-array.md) | `open val isArray: Boolean`<br>True if this [CodeType](../-code-type/index.md) is an array type. |
| [isInterface](../-loaded-code-type/is-interface.md) | `open val isInterface: Boolean`<br>True if this [CodeType](../-code-type/index.md) is a interface type. |
| [isPrimitive](../-loaded-code-type/is-primitive.md) | `open val isPrimitive: Boolean`<br>True if this [CodeType](../-code-type/index.md) is a primitive type. |
| [isVirtual](../-loaded-code-type/is-virtual.md) | `open val isVirtual: Boolean`<br>True if is a `Virtual Type` (Virtual Types = Types that were not loaded by JVM) |
| [primitiveType](../-loaded-code-type/primitive-type.md) | `open val primitiveType: `[`CodeType`](../-code-type/index.md)`?`<br>Primitive type. |
| [type](../-loaded-code-type/type.md) | `open val type: String`<br>Type name, examples: |
| [wrapperType](../-loaded-code-type/wrapper-type.md) | `open val wrapperType: `[`CodeType`](../-code-type/index.md)`?`<br>Wrapper type. |

### Functions

| Name | Summary |
|---|---|
| [equals](equals.md) | `open fun equals(other: Any?): Boolean` |
| [hashCode](hash-code.md) | `open fun hashCode(): Int` |
| [toString](to-string.md) | `open fun toString(): String` |

### Extension Properties

| Name | Summary |
|---|---|
| [codeType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/code-type.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.codeType: `[`CodeType`](../-code-type/index.md) |
| [concreteType](../../com.github.jonathanxd.codeapi.util/concrete-type.md) | `val `[`CodeType`](../-code-type/index.md)`.concreteType: `[`CodeType`](../-code-type/index.md)<br>Gets the concrete type of [CodeType](../-code-type/index.md), if this is a [GenericType](../-generic-type/index.md), the property getter will try to
infer the concrete type looping the [GenericType Inferred type](../-generic-type/code-type.md). |
| [descName](../../com.github.jonathanxd.codeapi.util/desc-name.md) | `val `[`CodeType`](../-code-type/index.md)`.descName: String` |

### Extension Functions

| Name | Summary |
|---|---|
| [applyType](../../com.github.jonathanxd.codeapi.util/apply-type.md) | `fun `[`CodeType`](../-code-type/index.md)`.applyType(typeName: String, type: `[`CodeType`](../-code-type/index.md)`): `[`CodeType`](../-code-type/index.md) |
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [getPartType](../../com.github.jonathanxd.codeapi.util/get-part-type.md) | `fun `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.getPartType(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or throws [IllegalStateException](http://docs.oracle.com/javase/6/docs/api/java/lang/IllegalStateException.html) if [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is not instance of [Typed](../../com.github.jonathanxd.codeapi.base/-typed/index.md) |
| [getPartTypeOrNull](../../com.github.jonathanxd.codeapi.util/get-part-type-or-null.md) | `fun `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.getPartTypeOrNull(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or `null` if [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is not instance of [Typed](../../com.github.jonathanxd.codeapi.base/-typed/index.md). |
| [getType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/get-type.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.getType(isParameterized: Boolean = false): `[`CodeType`](../-code-type/index.md) |
| [getType](../../com.github.jonathanxd.codeapi.util/get-type.md) | `fun `[`CodeType`](../-code-type/index.md)`.getType(name: String): `[`CodeType`](../-code-type/index.md)`?`<br>`fun `[`CodeType`](../-code-type/index.md)`.getType(name: String, inside: `[`CodeType`](../-code-type/index.md)`): `[`CodeType`](../-code-type/index.md)`?` |
| [hash](../../com.github.jonathanxd.codeapi.util/hash.md) | `fun `[`CodeType`](../-code-type/index.md)`.hash(): Int`<br>Default hash algorithm. |
| [is](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.is(another: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Boolean` |
| [nonStrictEq](../../com.github.jonathanxd.codeapi.util/non-strict-eq.md) | `fun `[`CodeType`](../-code-type/index.md)`.nonStrictEq(other: `[`CodeType`](../-code-type/index.md)`): Boolean`<br>Non-strict generic equality check, only works for generic types. |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
| [toStr](../../com.github.jonathanxd.codeapi.util/to-str.md) | `fun `[`CodeType`](../-code-type/index.md)`.toStr(): String`<br>Default to string conversion for [CodeType](../-code-type/index.md). |
