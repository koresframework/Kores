[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.type](../index.md) / [GenericTypeImpl](.)

# GenericTypeImpl

`class GenericTypeImpl : `[`GenericType`](../-generic-type/index.md)

Generic type implementation.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `GenericTypeImpl(name: String?, codeType: `[`CodeType`](../-code-type/index.md)`?, bounds: Array<`[`Bound`](../-generic-type/-bound/index.md)`>)`<br>Generic type implementation. |

### Properties

| Name | Summary |
|---|---|
| [bounds](bounds.md) | `val bounds: Array<`[`Bound`](../-generic-type/-bound/index.md)`>`<br>Bounds of the generic type. |
| [codeType](code-type.md) | `val codeType: `[`CodeType`](../-code-type/index.md)<br>Gets the resolved code type. |
| [isType](is-type.md) | `val isType: Boolean`<br>Returns true if this is a Type generic type, false if is a Type Variable generic type. |
| [name](name.md) | `val name: String`<br>Name of the generic type. |

### Inherited Properties

| Name | Summary |
|---|---|
| [canonicalName](../-generic-type/canonical-name.md) | `open val canonicalName: String`<br>Canonical name |
| [identification](../-generic-type/identification.md) | `open val identification: String`<br>Unique string identification, this property may be used for equality comparison, normal types,
array types and generic types have different identifications, if a generic type represent a single
[CodeType](../-code-type/index.md) without any bound, then the identification will be the same as the single [CodeType](../-code-type/index.md). |
| [isArray](../-generic-type/is-array.md) | `open val isArray: Boolean`<br>True if this [CodeType](../-code-type/index.md) is an array type. |
| [isInterface](../-generic-type/is-interface.md) | `open val isInterface: Boolean`<br>True if this [CodeType](../-code-type/index.md) is a interface type. |
| [isPrimitive](../-generic-type/is-primitive.md) | `open val isPrimitive: Boolean`<br>True if this [CodeType](../-code-type/index.md) is a primitive type. |
| [isVirtual](../-generic-type/is-virtual.md) | `open val isVirtual: Boolean`<br>True if is a `Virtual Type` (Virtual Types = Types that were not loaded by JVM) |
| [isWildcard](../-generic-type/is-wildcard.md) | `open val isWildcard: Boolean`<br>Returns true if this is a wildcard generic type. |
| [javaSpecName](../-generic-type/java-spec-name.md) | `open val javaSpecName: String`<br>JVM Spec class name. |
| [packageName](../-generic-type/package-name.md) | `open val packageName: String`<br>Package name |
| [primitiveType](../-generic-type/primitive-type.md) | `open val primitiveType: `[`CodeType`](../-code-type/index.md)`?`<br>Only determine the Primitive type if: |
| [simpleName](../-generic-type/simple-name.md) | `open val simpleName: String`<br>Simple name. |
| [type](../-generic-type/type.md) | `open val type: String`<br>Type name, examples: |
| [wrapperType](../-generic-type/wrapper-type.md) | `open val wrapperType: `[`CodeType`](../-code-type/index.md)`?`<br>Only determine the Wrapper type if: |

### Functions

| Name | Summary |
|---|---|
| [equals](equals.md) | `fun equals(other: Any?): Boolean` |
| [hashCode](hash-code.md) | `fun hashCode(): Int` |
| [toArray](to-array.md) | `fun toArray(dimensions: Int): `[`GenericType`](../-generic-type/index.md)<br>Convert this [CodeType](../-code-type/index.md) to a [CodeTypeArray](#). |
| [toString](to-string.md) | `fun toString(): String` |

### Inherited Functions

| Name | Summary |
|---|---|
| [builder](../-generic-type/builder.md) | `open fun builder(): `[`Builder`](../-generic-type/-builder/index.md)`<`[`GenericType`](../-generic-type/index.md)`, *>`<br>This builder may or may not accept null values, it depends on implementation. |
| [compareTo](../-generic-type/compare-to.md) | `open fun compareTo(other: `[`CodeType`](../-code-type/index.md)`): Int` |
| [is](../-generic-type/is.md) | `open fun is(another: `[`CodeType`](../-code-type/index.md)`?): Boolean`<br>Returns true if this [CodeType](../-code-type/index.md) is equals to another [CodeType](../-code-type/index.md). |

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
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [getPartType](../../com.github.jonathanxd.codeapi.util/get-part-type.md) | `fun `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.getPartType(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or throws [IllegalStateException](http://docs.oracle.com/javase/6/docs/api/java/lang/IllegalStateException.html) if [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is not instance of [Typed](../../com.github.jonathanxd.codeapi.base/-typed/index.md) |
| [getPartTypeOrNull](../../com.github.jonathanxd.codeapi.util/get-part-type-or-null.md) | `fun `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.getPartTypeOrNull(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or `null` if [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is not instance of [Typed](../../com.github.jonathanxd.codeapi.base/-typed/index.md). |
| [getType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/get-type.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.getType(isParameterized: Boolean = false): `[`CodeType`](../-code-type/index.md) |
| [is](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.is(another: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Boolean` |
| [toComponentString](../../com.github.jonathanxd.codeapi.util/to-component-string.md) | `fun `[`GenericType`](../-generic-type/index.md)`.toComponentString(): String`<br>Creates string representation of components of [GenericType](../-generic-type/index.md). |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
