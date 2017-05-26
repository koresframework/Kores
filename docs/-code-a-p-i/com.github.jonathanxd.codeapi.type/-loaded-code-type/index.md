[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.type](../index.md) / [LoadedCodeType](.)

# LoadedCodeType

`interface LoadedCodeType<T> : `[`CodeType`](../-code-type/index.md)

A [CodeType](../-code-type/index.md) backing to a loaded [Class](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html) ([loadedType](loaded-type.md)).

### Parameters

`T` - Type of the Class.

### Properties

| Name | Summary |
|---|---|
| [canonicalName](canonical-name.md) | `open val canonicalName: String`<br>Canonical name |
| [defaultResolver](default-resolver.md) | `open val defaultResolver: `[`CodeTypeResolver`](../-code-type-resolver/index.md)`<`[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<*>>`<br>Default resolver. |
| [isArray](is-array.md) | `open val isArray: Boolean`<br>True if this [CodeType](../-code-type/index.md) is an array type. |
| [isInterface](is-interface.md) | `open val isInterface: Boolean`<br>True if this [CodeType](../-code-type/index.md) is a interface type. |
| [isPrimitive](is-primitive.md) | `open val isPrimitive: Boolean`<br>True if this [CodeType](../-code-type/index.md) is a primitive type. |
| [isVirtual](is-virtual.md) | `open val isVirtual: Boolean`<br>True if is a `Virtual Type` (Virtual Types = Types that were not loaded by JVM) |
| [loadedType](loaded-type.md) | `abstract val loadedType: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<T>`<br>Loaded class. |
| [primitiveType](primitive-type.md) | `open val primitiveType: `[`CodeType`](../-code-type/index.md)`?`<br>Primitive type. |
| [type](type.md) | `open val type: String`<br>Type name, examples: |
| [wrapperType](wrapper-type.md) | `open val wrapperType: `[`CodeType`](../-code-type/index.md)`?`<br>Wrapper type. |

### Inherited Properties

| Name | Summary |
|---|---|
| [arrayBaseComponent](../-code-type/array-base-component.md) | `open val arrayBaseComponent: `[`CodeType`](../-code-type/index.md)<br>Array base component. |
| [arrayComponent](../-code-type/array-component.md) | `open val arrayComponent: `[`CodeType`](../-code-type/index.md)<br>Array component. |
| [arrayDimension](../-code-type/array-dimension.md) | `open val arrayDimension: Int`<br>Array dimension, 0 if this type is not an array. |
| [binaryName](../-code-type/binary-name.md) | `open val binaryName: String`<br>Binary name of the class. |
| [identification](../-code-type/identification.md) | `open val identification: String`<br>Unique string identification, this property may be used for equality comparison, normal types,
array types and generic types have different identifications, if a generic type represent a single
[CodeType](../-code-type/index.md) without any bound, then the identification will be the same as the single [CodeType](../-code-type/index.md). |
| [javaSpecName](../-code-type/java-spec-name.md) | `open val javaSpecName: String`<br>JVM Spec class name. |
| [packageName](../-code-type/package-name.md) | `open val packageName: String`<br>Package name |
| [simpleName](../-code-type/simple-name.md) | `open val simpleName: String`<br>Simple name. |

### Functions

| Name | Summary |
|---|---|
| [toLoadedArray](to-loaded-array.md) | `open fun toLoadedArray(array: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<T>, dimensions: Int): LoadedCodeType<T>` |

### Inherited Functions

| Name | Summary |
|---|---|
| [compareTo](../-code-type/compare-to.md) | `open fun compareTo(other: `[`CodeType`](../-code-type/index.md)`): Int` |
| [equals](../-code-type/equals.md) | `abstract fun equals(other: Any?): Boolean` |
| [getTypeName](../-code-type/get-type-name.md) | `open fun getTypeName(): String` |
| [hashCode](../-code-type/hash-code.md) | `abstract fun hashCode(): Int` |
| [is](../-code-type/is.md) | `open fun is(another: `[`CodeType`](../-code-type/index.md)`?): Boolean`<br>Returns true if this [CodeType](../-code-type/index.md) is equals to another [CodeType](../-code-type/index.md). |
| [toArray](../-code-type/to-array.md) | `open fun toArray(dimensions: Int): `[`CodeType`](../-code-type/index.md)<br>Convert this [CodeType](../-code-type/index.md) to a [CodeTypeArray](#). |

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
| [eq](../../com.github.jonathanxd.codeapi.util/eq.md) | `fun <T> LoadedCodeType<T>.eq(obj: Any?): Boolean`<br>Default equality check for LoadedCodeType, this method checks if the loaded types are equal. |
| [getPartType](../../com.github.jonathanxd.codeapi.util/get-part-type.md) | `fun `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.getPartType(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or throws [IllegalStateException](http://docs.oracle.com/javase/6/docs/api/java/lang/IllegalStateException.html) if [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is not instance of [Typed](../../com.github.jonathanxd.codeapi.base/-typed/index.md) |
| [getPartTypeOrNull](../../com.github.jonathanxd.codeapi.util/get-part-type-or-null.md) | `fun `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.getPartTypeOrNull(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or `null` if [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is not instance of [Typed](../../com.github.jonathanxd.codeapi.base/-typed/index.md). |
| [getType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/get-type.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.getType(isParameterized: Boolean = false): `[`CodeType`](../-code-type/index.md) |
| [getType](../../com.github.jonathanxd.codeapi.util/get-type.md) | `fun `[`CodeType`](../-code-type/index.md)`.getType(name: String): `[`CodeType`](../-code-type/index.md)`?`<br>`fun `[`CodeType`](../-code-type/index.md)`.getType(name: String, inside: `[`CodeType`](../-code-type/index.md)`): `[`CodeType`](../-code-type/index.md)`?` |
| [hash](../../com.github.jonathanxd.codeapi.util/hash.md) | `fun `[`CodeType`](../-code-type/index.md)`.hash(): Int`<br>Default hash algorithm. |
| [is](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.is(another: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Boolean` |
| [nonStrictEq](../../com.github.jonathanxd.codeapi.util/non-strict-eq.md) | `fun `[`CodeType`](../-code-type/index.md)`.nonStrictEq(other: `[`CodeType`](../-code-type/index.md)`): Boolean`<br>Non-strict generic equality check, only works for generic types. |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
| [toStr](../../com.github.jonathanxd.codeapi.util/to-str.md) | `fun `[`CodeType`](../-code-type/index.md)`.toStr(): String`<br>Default to string conversion for [CodeType](../-code-type/index.md). |

### Inheritors

| Name | Summary |
|---|---|
| [JavaType](../-java-type/index.md) | `open class JavaType<T> : LoadedCodeType<T>`<br>Java class [CodeType](../-code-type/index.md). |
