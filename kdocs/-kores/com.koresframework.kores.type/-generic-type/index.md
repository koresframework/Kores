//[Kores](../../../index.md)/[com.koresframework.kores.type](../index.md)/[GenericType](index.md)

# GenericType

[jvm]\
interface [GenericType](index.md) : [KoresType](../-kores-type/index.md), [WrapperKoresType](../-wrapper-kores-type/index.md)

Generic type.

Default implementations of [equals](equals.md), [hashCode](hash-code.md) and [toString](to-string.md) is provided by com.koresframework.kores.util functions.

## Types

| Name | Summary |
|---|---|
| [Bound](-bound/index.md) | [jvm]<br>abstract class [Bound](-bound/index.md)(**type**: [KoresType](../-kores-type/index.md))<br>Generic type bounds. |
| [Builder](-builder/index.md) | [jvm]<br>interface [Builder](-builder/index.md)<out [T](-builder/index.md) : [GenericType](index.md), [S](-builder/index.md) : [GenericType.Builder](-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>> : [Builder](../../com.koresframework.kores.builder/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> |
| [Extends](-extends/index.md) | [jvm]<br>class [Extends](-extends/index.md)(**type**: [KoresType](../-kores-type/index.md)) : [GenericType.WildcardBound](-wildcard-bound/index.md)<br>Bound to extends. |
| [GenericBound](-generic-bound/index.md) | [jvm]<br>class [GenericBound](-generic-bound/index.md)(**type**: [KoresType](../-kores-type/index.md)) : [GenericType.Bound](-bound/index.md)<br>Bound to type. |
| [Super](-super/index.md) | [jvm]<br>class [Super](-super/index.md)(**type**: [KoresType](../-kores-type/index.md)) : [GenericType.WildcardBound](-wildcard-bound/index.md)<br>Bound to super type. |
| [WildcardBound](-wildcard-bound/index.md) | [jvm]<br>abstract class [WildcardBound](-wildcard-bound/index.md)(**type**: [KoresType](../-kores-type/index.md)) : [GenericType.Bound](-bound/index.md)<br>Bound to wildcard. |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [GenericType.Builder](-builder/index.md)<[GenericType](index.md), *><br>This builder may or may not accept null values, it depends on implementation. |
| [compareTo](compare-to.md) | [jvm]<br>open operator override fun [compareTo](compare-to.md)(other: [KoresType](../-kores-type/index.md)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Compare two identifications |
| [equals](equals.md) | [jvm]<br>abstract operator override fun [equals](equals.md)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [getTypeName](../-kores-type/get-type-name.md) | [jvm]<br>open override fun [getTypeName](../-kores-type/get-type-name.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [hashCode](hash-code.md) | [jvm]<br>abstract override fun [hashCode](hash-code.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [is](is.md) | [jvm]<br>open override fun [is](is.md)(other: [KoresType](../-kores-type/index.md)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if this [KoresType](../-kores-type/index.md) is equals to other [KoresType](../-kores-type/index.md). |
| [isAssignableFrom](../-kores-type/is-assignable-from.md) | [jvm]<br>open fun [isAssignableFrom](../-kores-type/is-assignable-from.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if this type is assignable from [type](../-kores-type/is-assignable-from.md) (using default resolver of [type](../-kores-type/is-assignable-from.md)).<br>[jvm]<br>open fun [isAssignableFrom](../-kores-type/is-assignable-from.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), resolverProvider: ([Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)) -> [KoresTypeResolver](../-kores-type-resolver/index.md)<*>): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if this type is assignable from [type](../-kores-type/is-assignable-from.md) (using resolver provided by [resolverProvider](../-kores-type/is-assignable-from.md)). |
| [isConcreteIdEq](../-kores-type/is-concrete-id-eq.md) | [jvm]<br>open fun [isConcreteIdEq](../-kores-type/is-concrete-id-eq.md)(other: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if identification of [concreteType](../concrete-type.md) of this [KoresType](../-kores-type/index.md) is equals to [concreteType](../concrete-type.md) of other [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) according to [is](../-kores-type/is.md). |
| [isIdEq](../-kores-type/is-id-eq.md) | [jvm]<br>open fun [isIdEq](../-kores-type/is-id-eq.md)(other: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if this [KoresType](../-kores-type/index.md) identification is equals to other [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) according to [is](../-kores-type/is.md). |
| [safeIsAssignableFrom](../-kores-type/safe-is-assignable-from.md) | [jvm]<br>open fun [safeIsAssignableFrom](../-kores-type/safe-is-assignable-from.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): EitherObjBoolean<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)><br>open fun [safeIsAssignableFrom](../-kores-type/safe-is-assignable-from.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), resolverProvider: ([Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)) -> [KoresTypeResolver](../-kores-type-resolver/index.md)<*>): EitherObjBoolean<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)><br>Returns Either that holds either failure exception or whether this type is assignable from [type](../-kores-type/safe-is-assignable-from.md). |
| [toArray](to-array.md) | [jvm]<br>abstract override fun [toArray](to-array.md)(dimensions: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [GenericType](index.md)<br>Convert this [KoresType](../-kores-type/index.md) to a ArrayKoresType. |
| [toString](to-string.md) | [jvm]<br>abstract override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Properties

| Name | Summary |
|---|---|
| [arrayBaseComponent](array-base-component.md) | [jvm]<br>open override val [arrayBaseComponent](array-base-component.md): [KoresType](../-kores-type/index.md)<br>Array base component. |
| [arrayComponent](array-component.md) | [jvm]<br>open override val [arrayComponent](array-component.md): [KoresType](../-kores-type/index.md)<br>Array component. |
| [arrayDimension](array-dimension.md) | [jvm]<br>open override val [arrayDimension](array-dimension.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Array dimension, 0 if this type is not an array. |
| [binaryName](index.md#-772623569%2FProperties%2F-1216412040) | [jvm]<br>open val [binaryName](index.md#-772623569%2FProperties%2F-1216412040): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Binary name of the class. |
| [bindedDefaultResolver](index.md#-1841592556%2FProperties%2F-1216412040) | [jvm]<br>open val [bindedDefaultResolver](index.md#-1841592556%2FProperties%2F-1216412040): [BindedTypeResolver](../-binded-type-resolver/index.md)<*><br>Creates a new binded default resolver instance. |
| [bounds](bounds.md) | [jvm]<br>abstract val [bounds](bounds.md): [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<[GenericType.Bound](-bound/index.md)><br>Bounds of the generic type. |
| [canonicalName](canonical-name.md) | [jvm]<br>open override val [canonicalName](canonical-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Canonical nameQualified name:[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = java.lang.String. |
| [defaultResolver](default-resolver.md) | [jvm]<br>open override val [defaultResolver](default-resolver.md): [KoresTypeResolver](../-kores-type-resolver/index.md)<*><br>Default resolver. |
| [identification](identification.md) | [jvm]<br>open override val [identification](identification.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Unique string identification, this property may be used for equality comparison, normal types, array types and generic types have different identifications, if a generic type represent a single [KoresType](../-kores-type/index.md) without any bound, then the identification will be the same as the single [KoresType](../-kores-type/index.md). |
| [interfaces](index.md#476543681%2FProperties%2F-1216412040) | [jvm]<br>open val [interfaces](index.md#476543681%2FProperties%2F-1216412040): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)><br>Gets the super interfaces of this[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) using default resolver. |
| [internalName](index.md#2093199987%2FProperties%2F-1216412040) | [jvm]<br>open val [internalName](index.md#2093199987%2FProperties%2F-1216412040): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Internal class name. |
| [isArray](is-array.md) | [jvm]<br>open override val [isArray](is-array.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True if this [KoresType](../-kores-type/index.md) is an array type. |
| [isInterface](is-interface.md) | [jvm]<br>open override val [isInterface](is-interface.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True if this [KoresType](../-kores-type/index.md) is a interface type. |
| [isPrimitive](is-primitive.md) | [jvm]<br>open override val [isPrimitive](is-primitive.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True if this [KoresType](../-kores-type/index.md) is a primitive type. |
| [isType](is-type.md) | [jvm]<br>abstract val [isType](is-type.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True if this is a Type generic type, false if is a Type Variable generic type. |
| [isVirtual](is-virtual.md) | [jvm]<br>open override val [isVirtual](is-virtual.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True if is a Virtual Type (Virtual Types = Types that were not loaded by JVM) |
| [isWildcard](is-wildcard.md) | [jvm]<br>open val [isWildcard](is-wildcard.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True if this is a wildcard generic type. |
| [javaSpecName](java-spec-name.md) | [jvm]<br>open override val [javaSpecName](java-spec-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>JVM Spec class name. |
| [name](name.md) | [jvm]<br>abstract val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Name of the generic type. |
| [packageName](package-name.md) | [jvm]<br>open override val [packageName](package-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Package name |
| [primitiveType](primitive-type.md) | [jvm]<br>open override val [primitiveType](primitive-type.md): [KoresType](../-kores-type/index.md)?<br>Only determine the Primitive type if:isKoresType && bounds.isEmptyBecauseInteger<T> is invalid and List<T> has no primitive types because List is not a wrapper type. |
| [resolvedType](resolved-type.md) | [jvm]<br>abstract val [resolvedType](resolved-type.md): [KoresType](../-kores-type/index.md)<br>Resolved code type. |
| [simpleName](simple-name.md) | [jvm]<br>open override val [simpleName](simple-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Simple name. |
| [superType](index.md#-1728607190%2FProperties%2F-1216412040) | [jvm]<br>open val [superType](index.md#-1728607190%2FProperties%2F-1216412040): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)?<br>Gets the super type of this[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) using default resolver. |
| [type](type.md) | [jvm]<br>open override val [type](type.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Type name, examples:[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = java.lang.String. |
| [wrapped](wrapped.md) | [jvm]<br>open override val [wrapped](wrapped.md): [KoresType](../-kores-type/index.md)<br>Wrapped code type. |
| [wrapperType](wrapper-type.md) | [jvm]<br>open override val [wrapperType](wrapper-type.md): [KoresType](../-kores-type/index.md)?<br>Only determine the Wrapper type if:isKoresType && bounds.isEmptyBecause int<T> is invalid. |

## Inheritors

| Name |
|---|
| [AnnotatedKoresType](../-annotated-kores-type/-generic-annotated-kores-type/index.md) |
| [Generic](../-generic/index.md) |
| [GenericTypeImpl](../-generic-type-impl/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [applyType](../apply-type.md) | [jvm]<br>fun [GenericType](index.md).[applyType](../apply-type.md)(typeName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), type: [KoresType](../-kores-type/index.md)): [GenericType](index.md) |
| [eq](../../com.koresframework.kores.util/eq.md) | [jvm]<br>fun [GenericType](index.md).[eq](../../com.koresframework.kores.util/eq.md)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Default equals algorithm for [GenericType](index.md) |
| [genericTypeToDescriptor](../../com.koresframework.kores.util/generic-type-to-descriptor.md) | [jvm]<br>fun [GenericType](index.md).[genericTypeToDescriptor](../../com.koresframework.kores.util/generic-type-to-descriptor.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Create a type descriptor from receiver type. |
| [getType](../get-type.md) | [jvm]<br>fun [GenericType](index.md).[getType](../get-type.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [KoresType](../-kores-type/index.md)?<br>fun [GenericType](index.md).[getType](../get-type.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), inside: [KoresType](../-kores-type/index.md)): [KoresType](../-kores-type/index.md)? |
| [hash](../../com.koresframework.kores.util/hash.md) | [jvm]<br>fun [GenericType](index.md).[hash](../../com.koresframework.kores.util/hash.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Default hashCode algorithm for [GenericType](index.md) |
| [isGenericAssignableFrom](../is-generic-assignable-from.md) | [jvm]<br>fun [GenericType](index.md).[isGenericAssignableFrom](../is-generic-assignable-from.md)(other: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [nonStrictEq](../../com.koresframework.kores.util/non-strict-eq.md) | [jvm]<br>fun [GenericType](index.md).[nonStrictEq](../../com.koresframework.kores.util/non-strict-eq.md)(other: [KoresType](../-kores-type/index.md)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Non-strict generic bound equality check, only works for generic types. |
| [toComponentString](../../com.koresframework.kores.util/to-component-string.md) | [jvm]<br>fun [GenericType](index.md).[toComponentString](../../com.koresframework.kores.util/to-component-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Creates string representation of components of [GenericType](index.md). |
| [toInstruction](../../com.koresframework.kores.util.conversion/to-instruction.md) | [jvm]<br>fun [GenericType](index.md).[toInstruction](../../com.koresframework.kores.util.conversion/to-instruction.md)(): [Instruction](../../com.koresframework.kores/-instruction/index.md)<br>Creates [Instruction](../../com.koresframework.kores/-instruction/index.md) from [receiver generic type representation](index.md). |
| [toSourceString](../../com.koresframework.kores.util/to-source-string.md) | [jvm]<br>fun [GenericType](index.md).[toSourceString](../../com.koresframework.kores.util/to-source-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Convert generic type to string. |
| [toStr](../../com.koresframework.kores.util/to-str.md) | [jvm]<br>fun [GenericType](index.md).[toStr](../../com.koresframework.kores.util/to-str.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Default to string conversion for [GenericType](index.md). |
| [toTypeInfo](../../com.koresframework.kores.util/to-type-info.md) | [jvm]<br>fun [GenericType](index.md).[toTypeInfo](../../com.koresframework.kores.util/to-type-info.md)(): TypeInfo<*> |
