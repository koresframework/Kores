//[Kores](../../../index.md)/[com.koresframework.kores.type](../index.md)/[Generic](index.md)

# Generic

[jvm]\
class [Generic](index.md) : [GenericType](../-generic-type/index.md)

A generic type.

Examples:

A generic type T that extends String:

Generic.type("T").extends$(String.class);

A generic type T that extends V:

Generic.type("T").extends$("V");

A List of Type T:

Generic.type(List.class).of("T")

**Attention: All calls of the methods of** [**Generic**](index.md) **class creates a copy of the** **bound** **array (except the first call), if you mind performance use the** [**GenericTypeBuilder**](../-generic-type-builder/index.md)

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [builder](../-generic-type/builder.md) | [jvm]<br>open override fun [builder](../-generic-type/builder.md)(): [GenericType.Builder](../-generic-type/-builder/index.md)<[GenericType](../-generic-type/index.md), *><br>This builder may or may not accept null values, it depends on implementation. |
| [compareTo](compare-to.md) | [jvm]<br>open operator override fun [compareTo](compare-to.md)(other: [KoresType](../-kores-type/index.md)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Compare two identifications |
| [equals](equals.md) | [jvm]<br>open operator override fun [equals](equals.md)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [extends$](extends$.md) | [jvm]<br>fun [extends$](extends$.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Generic](index.md)<br>Generic type that extends type type.<br>[jvm]<br>fun [extends$](extends$.md)(vararg types: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Generic](index.md)<br>Generic type that extends types types.<br>[jvm]<br>fun [extends$](extends$.md)(vararg ss: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Generic](index.md)<br>Generic type that extends type variables ss.<br>[jvm]<br>fun [extends$](extends$.md)(s: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Generic](index.md)<br>Generic type that extends type variable s. |
| [getTypeName](../-kores-type/get-type-name.md) | [jvm]<br>open override fun [getTypeName](../-kores-type/get-type-name.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [hashCode](hash-code.md) | [jvm]<br>open override fun [hashCode](hash-code.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [is](../-generic-type/is.md) | [jvm]<br>open override fun [is](../-generic-type/is.md)(other: [KoresType](../-kores-type/index.md)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if this [KoresType](../-kores-type/index.md) is equals to other [KoresType](../-kores-type/index.md). |
| [isAssignableFrom](../-kores-type/is-assignable-from.md) | [jvm]<br>open fun [isAssignableFrom](../-kores-type/is-assignable-from.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if this type is assignable from [type](../-kores-type/is-assignable-from.md) (using default resolver of [type](../-kores-type/is-assignable-from.md)).<br>[jvm]<br>open fun [isAssignableFrom](../-kores-type/is-assignable-from.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), resolverProvider: ([Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)) -> [KoresTypeResolver](../-kores-type-resolver/index.md)<*>): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if this type is assignable from [type](../-kores-type/is-assignable-from.md) (using resolver provided by [resolverProvider](../-kores-type/is-assignable-from.md)). |
| [isConcreteIdEq](../-kores-type/is-concrete-id-eq.md) | [jvm]<br>open fun [isConcreteIdEq](../-kores-type/is-concrete-id-eq.md)(other: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if identification of [concreteType](../concrete-type.md) of this [KoresType](../-kores-type/index.md) is equals to [concreteType](../concrete-type.md) of other [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) according to [is](../-kores-type/is.md). |
| [isIdEq](../-kores-type/is-id-eq.md) | [jvm]<br>open fun [isIdEq](../-kores-type/is-id-eq.md)(other: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if this [KoresType](../-kores-type/index.md) identification is equals to other [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) according to [is](../-kores-type/is.md). |
| [of](of.md) | [jvm]<br>fun [of](of.md)(bound: [GenericType.Bound](../-generic-type/-bound/index.md)): [Generic](index.md)<br>Add a bound.<br>[jvm]<br>fun [of](of.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Generic](index.md)<br>Add a type bound.<br>[jvm]<br>fun [of](of.md)(vararg bounds: [GenericType.Bound](../-generic-type/-bound/index.md)): [Generic](index.md)<br>Add all [bounds](of.md).<br>[jvm]<br>fun [of](of.md)(vararg types: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Generic](index.md)<br>Add type bounds.<br>[jvm]<br>fun [of](of.md)(vararg ss: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Generic](index.md)<br>Add name bounds.<br>[jvm]<br>fun [of](of.md)(s: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Generic](index.md)<br>Add a name bound. |
| [safeIsAssignableFrom](../-kores-type/safe-is-assignable-from.md) | [jvm]<br>open fun [safeIsAssignableFrom](../-kores-type/safe-is-assignable-from.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): EitherObjBoolean<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)><br>open fun [safeIsAssignableFrom](../-kores-type/safe-is-assignable-from.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), resolverProvider: ([Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)) -> [KoresTypeResolver](../-kores-type-resolver/index.md)<*>): EitherObjBoolean<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)><br>Returns Either that holds either failure exception or whether this type is assignable from [type](../-kores-type/safe-is-assignable-from.md). |
| [super$](super$.md) | [jvm]<br>fun [super$](super$.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Generic](index.md)<br>Generic type that have a super type type.<br>[jvm]<br>fun [super$](super$.md)(vararg types: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Generic](index.md)<br>Generic type that have a super types types.<br>[jvm]<br>fun [super$](super$.md)(vararg ss: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Generic](index.md)<br>Generic type that have a super type variables ss.<br>[jvm]<br>fun [super$](super$.md)(s: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Generic](index.md)<br>Generic type that have a super type variable s. |
| [toArray](to-array.md) | [jvm]<br>open override fun [toArray](to-array.md)(dimensions: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [GenericType](../-generic-type/index.md)<br>Convert this [KoresType](../-kores-type/index.md) to a ArrayKoresType. |
| [toString](to-string.md) | [jvm]<br>open override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Properties

| Name | Summary |
|---|---|
| [arrayBaseComponent](index.md#401565454%2FProperties%2F-1216412040) | [jvm]<br>open override val [arrayBaseComponent](index.md#401565454%2FProperties%2F-1216412040): [KoresType](../-kores-type/index.md)<br>Array base component. |
| [arrayComponent](index.md#-173678883%2FProperties%2F-1216412040) | [jvm]<br>open override val [arrayComponent](index.md#-173678883%2FProperties%2F-1216412040): [KoresType](../-kores-type/index.md)<br>Array component. |
| [arrayDimension](index.md#420914836%2FProperties%2F-1216412040) | [jvm]<br>open override val [arrayDimension](index.md#420914836%2FProperties%2F-1216412040): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Array dimension, 0 if this type is not an array. |
| [binaryName](index.md#735770197%2FProperties%2F-1216412040) | [jvm]<br>open val [binaryName](index.md#735770197%2FProperties%2F-1216412040): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Binary name of the class. |
| [bindedDefaultResolver](index.md#435810350%2FProperties%2F-1216412040) | [jvm]<br>open val [bindedDefaultResolver](index.md#435810350%2FProperties%2F-1216412040): [BindedTypeResolver](../-binded-type-resolver/index.md)<*><br>Creates a new binded default resolver instance. |
| [bounds](bounds.md) | [jvm]<br>open override val [bounds](bounds.md): [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<[GenericType.Bound](../-generic-type/-bound/index.md)><br>Generic bounds. |
| [canonicalName](canonical-name.md) | [jvm]<br>open override val [canonicalName](canonical-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Canonical nameQualified name:[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = java.lang.String. |
| [defaultResolver](index.md#-1261297806%2FProperties%2F-1216412040) | [jvm]<br>open override val [defaultResolver](index.md#-1261297806%2FProperties%2F-1216412040): [KoresTypeResolver](../-kores-type-resolver/index.md)<*><br>Default resolver. |
| [identification](index.md#639038035%2FProperties%2F-1216412040) | [jvm]<br>open override val [identification](index.md#639038035%2FProperties%2F-1216412040): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Unique string identification, this property may be used for equality comparison, normal types, array types and generic types have different identifications, if a generic type represent a single [KoresType](../-kores-type/index.md) without any bound, then the identification will be the same as the single [KoresType](../-kores-type/index.md). |
| [interfaces](index.md#1984937447%2FProperties%2F-1216412040) | [jvm]<br>open val [interfaces](index.md#1984937447%2FProperties%2F-1216412040): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)><br>Gets the super interfaces of this[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) using default resolver. |
| [internalName](index.md#-39336935%2FProperties%2F-1216412040) | [jvm]<br>open val [internalName](index.md#-39336935%2FProperties%2F-1216412040): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Internal class name. |
| [isArray](is-array.md) | [jvm]<br>open override val [isArray](is-array.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True if this [KoresType](../-kores-type/index.md) is an array type. |
| [isInterface](is-interface.md) | [jvm]<br>open override val [isInterface](is-interface.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True if this [KoresType](../-kores-type/index.md) is a interface type. |
| [isPrimitive](is-primitive.md) | [jvm]<br>open override val [isPrimitive](is-primitive.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True if this [KoresType](../-kores-type/index.md) is a primitive type. |
| [isType](is-type.md) | [jvm]<br>open override val [isType](is-type.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True if this is a Type generic type, false if is a Type Variable generic type. |
| [isVirtual](is-virtual.md) | [jvm]<br>open override val [isVirtual](is-virtual.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True if is a Virtual Type (Virtual Types = Types that were not loaded by JVM) |
| [isWildcard](index.md#1188098653%2FProperties%2F-1216412040) | [jvm]<br>open val [isWildcard](index.md#1188098653%2FProperties%2F-1216412040): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True if this is a wildcard generic type. |
| [javaSpecName](java-spec-name.md) | [jvm]<br>open override val [javaSpecName](java-spec-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>JVM Spec class name. |
| [name](name.md) | [jvm]<br>open override val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Name of the generic type. |
| [packageName](package-name.md) | [jvm]<br>open override val [packageName](package-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Package name |
| [primitiveType](primitive-type.md) | [jvm]<br>open override val [primitiveType](primitive-type.md): [KoresType](../-kores-type/index.md)?<br>Only determine the Primitive type if:isKoresType && bounds.isEmptyBecauseInteger<T> is invalid and List<T> has no primitive types because List is not a wrapper type. |
| [resolvedType](resolved-type.md) | [jvm]<br>open override val [resolvedType](resolved-type.md): [KoresType](../-kores-type/index.md)<br>Type. |
| [simpleName](simple-name.md) | [jvm]<br>open override val [simpleName](simple-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Simple name. |
| [superType](index.md#1090997316%2FProperties%2F-1216412040) | [jvm]<br>open val [superType](index.md#1090997316%2FProperties%2F-1216412040): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)?<br>Gets the super type of this[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) using default resolver. |
| [type](type.md) | [jvm]<br>open override val [type](type.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Type name, examples:[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = java.lang.String. |
| [wrapped](index.md#-90547692%2FProperties%2F-1216412040) | [jvm]<br>open override val [wrapped](index.md#-90547692%2FProperties%2F-1216412040): [KoresType](../-kores-type/index.md)<br>Wrapped code type. |
| [wrapperType](wrapper-type.md) | [jvm]<br>open override val [wrapperType](wrapper-type.md): [KoresType](../-kores-type/index.md)?<br>Only determine the Wrapper type if:isKoresType && bounds.isEmptyBecause int<T> is invalid. |
