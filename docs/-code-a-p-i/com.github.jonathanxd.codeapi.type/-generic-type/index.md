[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.type](../index.md) / [GenericType](.)

# GenericType

`interface GenericType : `[`CodeType`](../-code-type/index.md)

Generic type.

Default implementations of [equals](equals.md), [hashCode](hash-code.md) and [toString](to-string.md) is provided by [com.github.jonathanxd.codeapi.util](../../com.github.jonathanxd.codeapi.util/index.md) functions.

### Types

| Name | Summary |
|---|---|
| [Bound](-bound/index.md) | `abstract class Bound : Any`<br>Generic type bounds. |
| [Builder](-builder/index.md) | `interface Builder<out T : GenericType, S : `[`Builder`](-builder/index.md)`<T, S>> : `[`Builder`](../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<T, S>` |
| [Extends](-extends/index.md) | `class Extends : `[`WildcardBound`](-wildcard-bound/index.md)<br>Bound to extends. |
| [GenericBound](-generic-bound/index.md) | `class GenericBound : `[`Bound`](-bound/index.md)<br>Bound to type. |
| [Super](-super/index.md) | `class Super : `[`WildcardBound`](-wildcard-bound/index.md)<br>Bound to super type. |
| [WildcardBound](-wildcard-bound/index.md) | `abstract class WildcardBound : `[`Bound`](-bound/index.md)<br>Bound to wildcard. |

### Properties

| Name | Summary |
|---|---|
| [bounds](bounds.md) | `abstract val bounds: Array<`[`Bound`](-bound/index.md)`>`<br>Bounds of the generic type. |
| [canonicalName](canonical-name.md) | `open val canonicalName: String`<br>Canonical name |
| [codeType](code-type.md) | `abstract val codeType: `[`CodeType`](../-code-type/index.md)<br>Gets the resolved code type. |
| [identification](identification.md) | `open val identification: String`<br>Unique string identification, this property may be used for equality comparison, normal types,
array types and generic types have different identifications, if a generic type represent a single
[CodeType](../-code-type/index.md) without any bound, then the identification will be the same as the single [CodeType](../-code-type/index.md). |
| [isArray](is-array.md) | `open val isArray: Boolean`<br>True if this [CodeType](../-code-type/index.md) is an array type. |
| [isInterface](is-interface.md) | `open val isInterface: Boolean`<br>True if this [CodeType](../-code-type/index.md) is a interface type. |
| [isPrimitive](is-primitive.md) | `open val isPrimitive: Boolean`<br>True if this [CodeType](../-code-type/index.md) is a primitive type. |
| [isType](is-type.md) | `abstract val isType: Boolean`<br>Returns true if this is a Type generic type, false if is a Type Variable generic type. |
| [isVirtual](is-virtual.md) | `open val isVirtual: Boolean`<br>True if is a `Virtual Type` (Virtual Types = Types that were not loaded by JVM) |
| [isWildcard](is-wildcard.md) | `open val isWildcard: Boolean`<br>Returns true if this is a wildcard generic type. |
| [javaSpecName](java-spec-name.md) | `open val javaSpecName: String`<br>JVM Spec class name. |
| [name](name.md) | `abstract val name: String`<br>Name of the generic type. |
| [packageName](package-name.md) | `open val packageName: String`<br>Package name |
| [primitiveType](primitive-type.md) | `open val primitiveType: `[`CodeType`](../-code-type/index.md)`?`<br>Only determine the Primitive type if: |
| [simpleName](simple-name.md) | `open val simpleName: String`<br>Simple name. |
| [type](type.md) | `open val type: String`<br>Type name, examples: |
| [wrapperType](wrapper-type.md) | `open val wrapperType: `[`CodeType`](../-code-type/index.md)`?`<br>Only determine the Wrapper type if: |

### Inherited Properties

| Name | Summary |
|---|---|
| [arrayBaseComponent](../-code-type/array-base-component.md) | `open val arrayBaseComponent: `[`CodeType`](../-code-type/index.md)<br>Array base component. |
| [arrayComponent](../-code-type/array-component.md) | `open val arrayComponent: `[`CodeType`](../-code-type/index.md)<br>Array component. |
| [arrayDimension](../-code-type/array-dimension.md) | `open val arrayDimension: Int`<br>Array dimension, 0 if this type is not an array. |
| [binaryName](../-code-type/binary-name.md) | `open val binaryName: String`<br>Binary name of the class. |
| [defaultResolver](../-code-type/default-resolver.md) | `open val defaultResolver: `[`CodeTypeResolver`](../-code-type-resolver/index.md)`<*>`<br>Default resolver. |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `open fun builder(): `[`Builder`](-builder/index.md)`<GenericType, *>`<br>This builder may or may not accept null values, it depends on implementation. |
| [compareTo](compare-to.md) | `open fun compareTo(other: `[`CodeType`](../-code-type/index.md)`): Int` |
| [equals](equals.md) | `abstract fun equals(other: Any?): Boolean` |
| [hashCode](hash-code.md) | `abstract fun hashCode(): Int` |
| [is](is.md) | `open fun is(another: `[`CodeType`](../-code-type/index.md)`?): Boolean`<br>Returns true if this [CodeType](../-code-type/index.md) is equals to another [CodeType](../-code-type/index.md). |
| [toArray](to-array.md) | `abstract fun toArray(dimensions: Int): GenericType`<br>Convert this [CodeType](../-code-type/index.md) to a [CodeTypeArray](#). |
| [toString](to-string.md) | `abstract fun toString(): String` |

### Inherited Functions

| Name | Summary |
|---|---|
| [getTypeName](../-code-type/get-type-name.md) | `open fun getTypeName(): String` |

### Extension Properties

| Name | Summary |
|---|---|
| [codeType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/code-type.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.codeType: `[`CodeType`](../-code-type/index.md) |
| [concreteType](../../com.github.jonathanxd.codeapi.util/concrete-type.md) | `val `[`CodeType`](../-code-type/index.md)`.concreteType: `[`CodeType`](../-code-type/index.md)<br>Gets the concrete type of [CodeType](../-code-type/index.md), if this is a GenericType, the property getter will try to
infer the concrete type looping the [GenericType Inferred type](code-type.md). |
| [descName](../../com.github.jonathanxd.codeapi.util/desc-name.md) | `val `[`CodeType`](../-code-type/index.md)`.descName: String` |

### Extension Functions

| Name | Summary |
|---|---|
| [applyType](../../com.github.jonathanxd.codeapi.util/apply-type.md) | `fun GenericType.applyType(typeName: String, type: `[`CodeType`](../-code-type/index.md)`): GenericType` |
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [eq](../../com.github.jonathanxd.codeapi.util/eq.md) | `fun GenericType.eq(other: Any?): Boolean`<br>Default equals algorithm for GenericType |
| [getPartType](../../com.github.jonathanxd.codeapi.util/get-part-type.md) | `fun `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.getPartType(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or throws [IllegalStateException](http://docs.oracle.com/javase/6/docs/api/java/lang/IllegalStateException.html) if [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is not instance of [Typed](../../com.github.jonathanxd.codeapi.base/-typed/index.md) |
| [getPartTypeOrNull](../../com.github.jonathanxd.codeapi.util/get-part-type-or-null.md) | `fun `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.getPartTypeOrNull(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or `null` if [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is not instance of [Typed](../../com.github.jonathanxd.codeapi.base/-typed/index.md). |
| [getType](../../com.github.jonathanxd.codeapi.util/get-type.md) | `fun GenericType.getType(name: String): `[`CodeType`](../-code-type/index.md)`?`<br>`fun GenericType.getType(name: String, inside: `[`CodeType`](../-code-type/index.md)`): `[`CodeType`](../-code-type/index.md)`?` |
| [getType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/get-type.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.getType(isParameterized: Boolean = false): `[`CodeType`](../-code-type/index.md) |
| [hash](../../com.github.jonathanxd.codeapi.util/hash.md) | `fun GenericType.hash(): Int`<br>Default hashCode algorithm for GenericType |
| [is](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.is(another: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Boolean` |
| [nonStrictEq](../../com.github.jonathanxd.codeapi.util/non-strict-eq.md) | `fun GenericType.nonStrictEq(other: `[`CodeType`](../-code-type/index.md)`): Boolean`<br>Non-strict generic bound equality check, only works for generic types. |
| [toComponentString](../../com.github.jonathanxd.codeapi.util/to-component-string.md) | `fun GenericType.toComponentString(): String`<br>Creates string representation of components of GenericType. |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
| [toStr](../../com.github.jonathanxd.codeapi.util/to-str.md) | `fun GenericType.toStr(): String`<br>Default to string conversion for GenericType. |

### Inheritors

| Name | Summary |
|---|---|
| [Generic](../-generic/index.md) | `class Generic : GenericType`<br>A generic type. |
| [GenericTypeImpl](../-generic-type-impl/index.md) | `class GenericTypeImpl : GenericType`<br>Generic type implementation. |
