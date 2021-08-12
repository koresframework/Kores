//[Kores](../../../index.md)/[com.github.jonathanxd.kores.type](../index.md)/[LoadedKoresType](index.md)

# LoadedKoresType

[jvm]\
interface [LoadedKoresType](index.md)<[T](index.md)> : [KoresType](../-kores-type/index.md)

A [KoresType](../-kores-type/index.md) backing to a loaded [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html) ([loadedType](loaded-type.md)).

## Parameters

jvm

| | |
|---|---|
| T | Type of the Class. |

## Functions

| Name | Summary |
|---|---|
| [builder](../../com.github.jonathanxd.kores/-kores-part/builder.md) | [jvm]<br>open fun [builder](../../com.github.jonathanxd.kores/-kores-part/builder.md)(): [Builder](../../com.github.jonathanxd.kores.builder/-builder/index.md)<[KoresPart](../../com.github.jonathanxd.kores/-kores-part/index.md), *><br>This builder may or may not accept null values, it depends on implementation. |
| [compareTo](../-kores-type/compare-to.md) | [jvm]<br>open operator override fun [compareTo](../-kores-type/compare-to.md)(other: [KoresType](../-kores-type/index.md)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Compare two identifications |
| [equals](../-kores-type/equals.md) | [jvm]<br>abstract operator override fun [equals](../-kores-type/equals.md)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [getTypeName](../-kores-type/get-type-name.md) | [jvm]<br>open override fun [getTypeName](../-kores-type/get-type-name.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [hashCode](../-kores-type/hash-code.md) | [jvm]<br>abstract override fun [hashCode](../-kores-type/hash-code.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [is](../-kores-type/is.md) | [jvm]<br>open fun [is](../-kores-type/is.md)(other: [KoresType](../-kores-type/index.md)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if this [KoresType](../-kores-type/index.md) is equals to other [KoresType](../-kores-type/index.md). |
| [isAssignableFrom](../-kores-type/is-assignable-from.md) | [jvm]<br>open fun [isAssignableFrom](../-kores-type/is-assignable-from.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if this type is assignable from [type](../-kores-type/is-assignable-from.md) (using default resolver of [type](../-kores-type/is-assignable-from.md)).<br>[jvm]<br>open fun [isAssignableFrom](../-kores-type/is-assignable-from.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), resolverProvider: ([Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)) -> [KoresTypeResolver](../-kores-type-resolver/index.md)<*>): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if this type is assignable from [type](../-kores-type/is-assignable-from.md) (using resolver provided by [resolverProvider](../-kores-type/is-assignable-from.md)). |
| [isConcreteIdEq](../-kores-type/is-concrete-id-eq.md) | [jvm]<br>open fun [isConcreteIdEq](../-kores-type/is-concrete-id-eq.md)(other: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if identification of [concreteType](../concrete-type.md) of this [KoresType](../-kores-type/index.md) is equals to [concreteType](../concrete-type.md) of other [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) according to [is](../-kores-type/is.md). |
| [isIdEq](../-kores-type/is-id-eq.md) | [jvm]<br>open fun [isIdEq](../-kores-type/is-id-eq.md)(other: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if this [KoresType](../-kores-type/index.md) identification is equals to other [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) according to [is](../-kores-type/is.md). |
| [safeIsAssignableFrom](../-kores-type/safe-is-assignable-from.md) | [jvm]<br>open fun [safeIsAssignableFrom](../-kores-type/safe-is-assignable-from.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): EitherObjBoolean<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)><br>open fun [safeIsAssignableFrom](../-kores-type/safe-is-assignable-from.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), resolverProvider: ([Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)) -> [KoresTypeResolver](../-kores-type-resolver/index.md)<*>): EitherObjBoolean<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)><br>Returns Either that holds either failure exception or whether this type is assignable from [type](../-kores-type/safe-is-assignable-from.md). |
| [toArray](../-kores-type/to-array.md) | [jvm]<br>open fun [toArray](../-kores-type/to-array.md)(dimensions: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [KoresType](../-kores-type/index.md)<br>Convert this [KoresType](../-kores-type/index.md) to a ArrayKoresType. |
| [toLoadedArray](to-loaded-array.md) | [jvm]<br>open fun [toLoadedArray](to-loaded-array.md)(array: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<[T](index.md)>, dimensions: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [LoadedKoresType](index.md)<[T](index.md)> |

## Properties

| Name | Summary |
|---|---|
| [arrayBaseComponent](index.md#150811732%2FProperties%2F-1216412040) | [jvm]<br>open val [arrayBaseComponent](index.md#150811732%2FProperties%2F-1216412040): [KoresType](../-kores-type/index.md)<br>Array base component. |
| [arrayComponent](index.md#1133068067%2FProperties%2F-1216412040) | [jvm]<br>open val [arrayComponent](index.md#1133068067%2FProperties%2F-1216412040): [KoresType](../-kores-type/index.md)<br>Array component. |
| [arrayDimension](index.md#1727661786%2FProperties%2F-1216412040) | [jvm]<br>open val [arrayDimension](index.md#1727661786%2FProperties%2F-1216412040): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Array dimension, 0 if this type is not an array. |
| [binaryName](index.md#-296392293%2FProperties%2F-1216412040) | [jvm]<br>open val [binaryName](index.md#-296392293%2FProperties%2F-1216412040): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Binary name of the class. |
| [bindedDefaultResolver](index.md#-820194008%2FProperties%2F-1216412040) | [jvm]<br>open val [bindedDefaultResolver](index.md#-820194008%2FProperties%2F-1216412040): [BindedTypeResolver](../-binded-type-resolver/index.md)<*><br>Creates a new binded default resolver instance. |
| [canonicalName](canonical-name.md) | [jvm]<br>open override val [canonicalName](canonical-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Canonical nameQualified name:[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = java.lang.String. |
| [defaultResolver](default-resolver.md) | [jvm]<br>open override val [defaultResolver](default-resolver.md): [KoresTypeResolver](../-kores-type-resolver/index.md)<[Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<*>><br>Default resolver. |
| [identification](index.md#1945784985%2FProperties%2F-1216412040) | [jvm]<br>open val [identification](index.md#1945784985%2FProperties%2F-1216412040): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Unique string identification, this property may be used for equality comparison, normal types, array types and generic types have different identifications, if a generic type represent a single [KoresType](../-kores-type/index.md) without any bound, then the identification will be the same as the single [KoresType](../-kores-type/index.md). |
| [interfaces](index.md#952774957%2FProperties%2F-1216412040) | [jvm]<br>open val [interfaces](index.md#952774957%2FProperties%2F-1216412040): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)><br>Gets the super interfaces of this[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) using default resolver. |
| [internalName](index.md#189955551%2FProperties%2F-1216412040) | [jvm]<br>open val [internalName](index.md#189955551%2FProperties%2F-1216412040): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Internal class name. |
| [isArray](is-array.md) | [jvm]<br>open override val [isArray](is-array.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True if this [KoresType](../-kores-type/index.md) is an array type. |
| [isInterface](is-interface.md) | [jvm]<br>open override val [isInterface](is-interface.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True if this [KoresType](../-kores-type/index.md) is a interface type. |
| [isPrimitive](is-primitive.md) | [jvm]<br>open override val [isPrimitive](is-primitive.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True if this [KoresType](../-kores-type/index.md) is a primitive type. |
| [isVirtual](is-virtual.md) | [jvm]<br>open override val [isVirtual](is-virtual.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True if is a Virtual Type (Virtual Types = Types that were not loaded by JVM) |
| [javaSpecName](index.md#835237791%2FProperties%2F-1216412040) | [jvm]<br>open val [javaSpecName](index.md#835237791%2FProperties%2F-1216412040): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>JVM Spec class name. |
| [loadedType](loaded-type.md) | [jvm]<br>abstract val [loadedType](loaded-type.md): [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)<[T](index.md)><br>Loaded class. |
| [packageName](index.md#-1974552670%2FProperties%2F-1216412040) | [jvm]<br>open val [packageName](index.md#-1974552670%2FProperties%2F-1216412040): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Package name |
| [primitiveType](primitive-type.md) | [jvm]<br>open override val [primitiveType](primitive-type.md): [KoresType](../-kores-type/index.md)?<br>Primitive type. |
| [simpleName](index.md#-1262219894%2FProperties%2F-1216412040) | [jvm]<br>open val [simpleName](index.md#-1262219894%2FProperties%2F-1216412040): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Simple name. |
| [superType](index.md#-881960898%2FProperties%2F-1216412040) | [jvm]<br>open val [superType](index.md#-881960898%2FProperties%2F-1216412040): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)?<br>Gets the super type of this[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) using default resolver. |
| [type](type.md) | [jvm]<br>open override val [type](type.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Type name, examples:[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = java.lang.String. |
| [wrapperType](wrapper-type.md) | [jvm]<br>open override val [wrapperType](wrapper-type.md): [KoresType](../-kores-type/index.md)?<br>Wrapper type. |

## Inheritors

| Name |
|---|
| [AnnotatedKoresType](../-annotated-kores-type/-simple-annotated-loaded-kores-type/index.md) |
| [JavaType](../-java-type/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [eq](../../com.github.jonathanxd.kores.util/eq.md) | [jvm]<br>fun <[T](../../com.github.jonathanxd.kores.util/eq.md)> [LoadedKoresType](index.md)<[T](../../com.github.jonathanxd.kores.util/eq.md)>.[eq](../../com.github.jonathanxd.kores.util/eq.md)(obj: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Default equality check for [LoadedKoresType](index.md), this method checks if the loaded types are equal. |
