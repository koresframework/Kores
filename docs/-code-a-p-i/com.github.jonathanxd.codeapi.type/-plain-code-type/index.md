[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.type](../index.md) / [PlainCodeType](.)

# PlainCodeType

`open class PlainCodeType : `[`CodeType`](../-code-type/index.md)`, `[`InheritanceProvider`](../-inheritance-provider/index.md)

Plain string code type.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `PlainCodeType(type: String, isInterface: Boolean = false, superclass_: () -> `[`CodeType`](../-code-type/index.md)`? = { throw IllegalStateException("No super class provider") }, superinterfaces_: () -> List<`[`CodeType`](../-code-type/index.md)`> = {throw IllegalStateException("No super interfaces provider")})`<br>Plain string code type. |

### Properties

| Name | Summary |
|---|---|
| [canonicalName](canonical-name.md) | `open val canonicalName: String`<br>Canonical name |
| [isInterface](is-interface.md) | `open val isInterface: Boolean`<br>True if this [CodeType](../-code-type/index.md) is a interface type. |
| [superclass](superclass.md) | `open val superclass: `[`CodeType`](../-code-type/index.md)`?`<br>Super class |
| [superclass_](superclass_.md) | `val superclass_: () -> `[`CodeType`](../-code-type/index.md)`?` |
| [superinterfaces](superinterfaces.md) | `open val superinterfaces: List<`[`CodeType`](../-code-type/index.md)`>`<br>Super interfaces |
| [superinterfaces_](superinterfaces_.md) | `val superinterfaces_: () -> List<`[`CodeType`](../-code-type/index.md)`>` |
| [type](type.md) | `open val type: String`<br>Type name, examples: |

### Inherited Properties

| Name | Summary |
|---|---|
| [arrayBaseComponent](../-code-type/array-base-component.md) | `open val arrayBaseComponent: `[`CodeType`](../-code-type/index.md)<br>Array base component. |
| [arrayComponent](../-code-type/array-component.md) | `open val arrayComponent: `[`CodeType`](../-code-type/index.md)<br>Array component. |
| [arrayDimension](../-code-type/array-dimension.md) | `open val arrayDimension: Int`<br>Array dimension, 0 if this type is not an array. |
| [binaryName](../-code-type/binary-name.md) | `open val binaryName: String`<br>Binary name of the class. |
| [defaultResolver](../-code-type/default-resolver.md) | `open val defaultResolver: `[`CodeTypeResolver`](../-code-type-resolver/index.md)`<*>`<br>Default resolver. |
| [identification](../-code-type/identification.md) | `open val identification: String`<br>Unique string identification, this property may be used for equality comparison, normal types,
array types and generic types have different identifications, if a generic type represent a single
[CodeType](../-code-type/index.md) without any bound, then the identification will be the same as the single [CodeType](../-code-type/index.md). |
| [isArray](../-code-type/is-array.md) | `open val isArray: Boolean`<br>True if this [CodeType](../-code-type/index.md) is an array type. |
| [isPrimitive](../-code-type/is-primitive.md) | `open val isPrimitive: Boolean`<br>True if this [CodeType](../-code-type/index.md) is a primitive type. |
| [isVirtual](../-code-type/is-virtual.md) | `open val isVirtual: Boolean`<br>True if is a `Virtual Type` (Virtual Types = Types that were not loaded by JVM) |
| [javaSpecName](../-code-type/java-spec-name.md) | `open val javaSpecName: String`<br>JVM Spec class name. |
| [packageName](../-code-type/package-name.md) | `open val packageName: String`<br>Package name |
| [primitiveType](../-code-type/primitive-type.md) | `open val primitiveType: `[`CodeType`](../-code-type/index.md)`?`<br>Primitive type. |
| [simpleName](../-code-type/simple-name.md) | `open val simpleName: String`<br>Simple name. |
| [wrapperType](../-code-type/wrapper-type.md) | `open val wrapperType: `[`CodeType`](../-code-type/index.md)`?`<br>Wrapper type. |

### Functions

| Name | Summary |
|---|---|
| [equals](equals.md) | `open fun equals(other: Any?): Boolean` |
| [hashCode](hash-code.md) | `open fun hashCode(): Int` |
| [toString](to-string.md) | `open fun toString(): String` |

### Inherited Functions

| Name | Summary |
|---|---|
| [compareTo](../-code-type/compare-to.md) | `open fun compareTo(other: `[`CodeType`](../-code-type/index.md)`): Int` |
| [getTypeName](../-code-type/get-type-name.md) | `open fun getTypeName(): String` |
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
| [eq](../../com.github.jonathanxd.codeapi.util/eq.md) | `fun `[`CodeType`](../-code-type/index.md)`.eq(obj: Any?): Boolean`<br>Default equals method. |
| [getPartType](../../com.github.jonathanxd.codeapi.util/get-part-type.md) | `fun `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.getPartType(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or throws [IllegalStateException](http://docs.oracle.com/javase/6/docs/api/java/lang/IllegalStateException.html) if [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is not instance of [Typed](../../com.github.jonathanxd.codeapi.base/-typed/index.md) |
| [getPartTypeOrNull](../../com.github.jonathanxd.codeapi.util/get-part-type-or-null.md) | `fun `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.getPartTypeOrNull(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or `null` if [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is not instance of [Typed](../../com.github.jonathanxd.codeapi.base/-typed/index.md). |
| [getType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/get-type.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.getType(isParameterized: Boolean = false): `[`CodeType`](../-code-type/index.md) |
| [getType](../../com.github.jonathanxd.codeapi.util/get-type.md) | `fun `[`CodeType`](../-code-type/index.md)`.getType(name: String): `[`CodeType`](../-code-type/index.md)`?`<br>`fun `[`CodeType`](../-code-type/index.md)`.getType(name: String, inside: `[`CodeType`](../-code-type/index.md)`): `[`CodeType`](../-code-type/index.md)`?` |
| [hash](../../com.github.jonathanxd.codeapi.util/hash.md) | `fun `[`CodeType`](../-code-type/index.md)`.hash(): Int`<br>Default hash algorithm. |
| [is](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.is(another: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Boolean` |
| [nonStrictEq](../../com.github.jonathanxd.codeapi.util/non-strict-eq.md) | `fun `[`CodeType`](../-code-type/index.md)`.nonStrictEq(other: `[`CodeType`](../-code-type/index.md)`): Boolean`<br>Non-strict generic equality check, only works for generic types. |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
| [toStr](../../com.github.jonathanxd.codeapi.util/to-str.md) | `fun `[`CodeType`](../-code-type/index.md)`.toStr(): String`<br>Default to string conversion for [CodeType](../-code-type/index.md). |
