//[Kores](../../../index.md)/[com.koresframework.kores.type](../index.md)/[KoresType](index.md)

# KoresType

[jvm]\
interface [KoresType](index.md) : [KoresPart](../../com.koresframework.kores/-kores-part/index.md), [Comparable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-comparable/index.html)<[KoresType](index.md)> , [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)

A type representation, like:

<ul><li>Java Classes (reflection and apt types).</li><li>Kores Type Declarations.</li><li>Plain class name.</li><li>ALIAS type: com.koresframework.kores.util.Alias.THIS, com.koresframework.kores.util.Alias.SUPER, com.koresframework.kores.util.Alias.INTERFACE</li></ul>

Make sure to handle com.koresframework.kores.util.Alias.THIS, com.koresframework.kores.util.Alias.SUPER and com.koresframework.kores.util.Alias.INTERFACE types.

The implementation of this interface must implement [hashCode](hash-code.md) and [equals](equals.md) reflecting equality to [eq](../../com.koresframework.kores.util/eq.md) and hashing algorithm to [hash](../../com.koresframework.kores.util/hash.md). This does not means that you need to delegate the call, you still free to check whatever you need, but comparison between two [CodeTypes](index.md) and hash calculation of [KoresType](index.md) should be made through these methods.

## Functions

| Name | Summary |
|---|---|
| [builder](../../com.koresframework.kores/-kores-part/builder.md) | [jvm]<br>open fun [builder](../../com.koresframework.kores/-kores-part/builder.md)(): [Builder](../../com.koresframework.kores.builder/-builder/index.md)<[KoresPart](../../com.koresframework.kores/-kores-part/index.md), *><br>This builder may or may not accept null values, it depends on implementation. |
| [compareTo](compare-to.md) | [jvm]<br>open operator override fun [compareTo](compare-to.md)(other: [KoresType](index.md)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Compare two identifications |
| [equals](equals.md) | [jvm]<br>abstract operator override fun [equals](equals.md)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [getTypeName](get-type-name.md) | [jvm]<br>open override fun [getTypeName](get-type-name.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [hashCode](hash-code.md) | [jvm]<br>abstract override fun [hashCode](hash-code.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [is](is.md) | [jvm]<br>open fun [is](is.md)(other: [KoresType](index.md)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if this [KoresType](index.md) is equals to other [KoresType](index.md). |
| [isAssignableFrom](is-assignable-from.md) | [jvm]<br>open fun [isAssignableFrom](is-assignable-from.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if this type is assignable from [type](is-assignable-from.md) (using default resolver of [type](is-assignable-from.md)).<br>[jvm]<br>open fun [isAssignableFrom](is-assignable-from.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), resolverProvider: ([Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)) -> [KoresTypeResolver](../-kores-type-resolver/index.md)<*>): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if this type is assignable from [type](is-assignable-from.md) (using resolver provided by [resolverProvider](is-assignable-from.md)). |
| [isConcreteIdEq](is-concrete-id-eq.md) | [jvm]<br>open fun [isConcreteIdEq](is-concrete-id-eq.md)(other: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if identification of [concreteType](../concrete-type.md) of this [KoresType](index.md) is equals to [concreteType](../concrete-type.md) of other [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) according to [is](is.md). |
| [isIdEq](is-id-eq.md) | [jvm]<br>open fun [isIdEq](is-id-eq.md)(other: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if this [KoresType](index.md) identification is equals to other [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) according to [is](is.md). |
| [safeIsAssignableFrom](safe-is-assignable-from.md) | [jvm]<br>open fun [safeIsAssignableFrom](safe-is-assignable-from.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): EitherObjBoolean<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)><br>open fun [safeIsAssignableFrom](safe-is-assignable-from.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), resolverProvider: ([Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)) -> [KoresTypeResolver](../-kores-type-resolver/index.md)<*>): EitherObjBoolean<[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)><br>Returns Either that holds either failure exception or whether this type is assignable from [type](safe-is-assignable-from.md). |
| [toArray](to-array.md) | [jvm]<br>open fun [toArray](to-array.md)(dimensions: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [KoresType](index.md)<br>Convert this [KoresType](index.md) to a ArrayKoresType. |

## Properties

| Name | Summary |
|---|---|
| [arrayBaseComponent](array-base-component.md) | [jvm]<br>open val [arrayBaseComponent](array-base-component.md): [KoresType](index.md)<br>Array base component. |
| [arrayComponent](array-component.md) | [jvm]<br>open val [arrayComponent](array-component.md): [KoresType](index.md)<br>Array component. |
| [arrayDimension](array-dimension.md) | [jvm]<br>open val [arrayDimension](array-dimension.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Array dimension, 0 if this type is not an array. |
| [binaryName](binary-name.md) | [jvm]<br>open val [binaryName](binary-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Binary name of the class. |
| [bindedDefaultResolver](binded-default-resolver.md) | [jvm]<br>open val [bindedDefaultResolver](binded-default-resolver.md): [BindedTypeResolver](../-binded-type-resolver/index.md)<*><br>Creates a new binded default resolver instance. |
| [canonicalName](canonical-name.md) | [jvm]<br>abstract val [canonicalName](canonical-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Canonical nameQualified name:[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = java.lang.String. |
| [defaultResolver](default-resolver.md) | [jvm]<br>open val [defaultResolver](default-resolver.md): [KoresTypeResolver](../-kores-type-resolver/index.md)<*><br>Default resolver. |
| [identification](identification.md) | [jvm]<br>open val [identification](identification.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Unique string identification, this property may be used for equality comparison, normal types, array types and generic types have different identifications, if a generic type represent a single [KoresType](index.md) without any bound, then the identification will be the same as the single [KoresType](index.md). |
| [interfaces](interfaces.md) | [jvm]<br>open val [interfaces](interfaces.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)><br>Gets the super interfaces of this[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) using default resolver. |
| [internalName](internal-name.md) | [jvm]<br>open val [internalName](internal-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Internal class name. |
| [isArray](is-array.md) | [jvm]<br>open val [isArray](is-array.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True if this [KoresType](index.md) is an array type. |
| [isInterface](is-interface.md) | [jvm]<br>open val [isInterface](is-interface.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True if this [KoresType](index.md) is a interface type. |
| [isPrimitive](is-primitive.md) | [jvm]<br>open val [isPrimitive](is-primitive.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True if this [KoresType](index.md) is a primitive type. |
| [isVirtual](is-virtual.md) | [jvm]<br>open val [isVirtual](is-virtual.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True if is a Virtual Type (Virtual Types = Types that were not loaded by JVM) |
| [javaSpecName](java-spec-name.md) | [jvm]<br>open val [javaSpecName](java-spec-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>JVM Spec class name. |
| [packageName](package-name.md) | [jvm]<br>open val [packageName](package-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Package name |
| [primitiveType](primitive-type.md) | [jvm]<br>open val [primitiveType](primitive-type.md): [KoresType](index.md)?<br>Primitive type. |
| [simpleName](simple-name.md) | [jvm]<br>open val [simpleName](simple-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Simple name. |
| [superType](super-type.md) | [jvm]<br>open val [superType](super-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)?<br>Gets the super type of this[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) using default resolver. |
| [type](type.md) | [jvm]<br>abstract val [type](type.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Type name, examples:[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = java.lang.String. |
| [wrapperType](wrapper-type.md) | [jvm]<br>open val [wrapperType](wrapper-type.md): [KoresType](index.md)?<br>Wrapper type. |

## Inheritors

| Name |
|---|
| [Alias](../../com.koresframework.kores.base/-alias/-t-h-i-s/index.md) |
| [Alias](../../com.koresframework.kores.base/-alias/-s-u-p-e-r/index.md) |
| [Alias](../../com.koresframework.kores.base/-alias/-i-n-t-e-r-f-a-c-e/index.md) |
| [TypeDeclaration](../../com.koresframework.kores.base/-type-declaration/index.md) |
| [AnnotatedKoresType](../-annotated-kores-type/-abstract/index.md) |
| [GenericType](../-generic-type/index.md) |
| [LoadedKoresType](../-loaded-kores-type/index.md) |
| [NullType](../-null-type/index.md) |
| [TypeRef](../-type-ref/index.md) |
| [UnknownKoresType](../-unknown-kores-type/index.md) |
| [WrapperKoresType](../-wrapper-kores-type/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [applyType](../apply-type.md) | [jvm]<br>fun [KoresType](index.md).[applyType](../apply-type.md)(typeName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), type: [KoresType](index.md)): [KoresType](index.md) |
| [concreteType](../concrete-type.md) | [jvm]<br>val [KoresType](index.md).[concreteType](../concrete-type.md): [KoresType](index.md)<br>Gets the concrete type of [KoresType](index.md), if this is a [GenericType](../-generic-type/index.md), the property getter will try to infer the concrete type looping the [GenericType Inferred type](../-generic-type/resolved-type.md). |
| [createKoresTypeDescriptor](../../com.koresframework.kores.util/create-kores-type-descriptor.md) | [jvm]<br>fun [KoresType](index.md).[createKoresTypeDescriptor](../../com.koresframework.kores.util/create-kores-type-descriptor.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Creates [KoresType](index.md) type descriptor |
| [descName](../desc-name.md) | [jvm]<br>val [KoresType](index.md).[descName](../desc-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [eq](../../com.koresframework.kores.util/eq.md) | [jvm]<br>fun [KoresType](index.md).[eq](../../com.koresframework.kores.util/eq.md)(obj: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Default equals method. |
| [getType](../get-type.md) | [jvm]<br>fun [KoresType](index.md).[getType](../get-type.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [KoresType](index.md)?<br>fun [KoresType](index.md).[getType](../get-type.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), inside: [KoresType](index.md)): [KoresType](index.md)? |
| [hash](../../com.koresframework.kores.util/hash.md) | [jvm]<br>fun [KoresType](index.md).[hash](../../com.koresframework.kores.util/hash.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Default hash algorithm. |
| [identityEq](../../com.koresframework.kores.util/identity-eq.md) | [jvm]<br>fun [KoresType](index.md).[identityEq](../../com.koresframework.kores.util/identity-eq.md)(obj: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Default equals method. |
| [identityHash](../../com.koresframework.kores.util/identity-hash.md) | [jvm]<br>fun [KoresType](index.md).[identityHash](../../com.koresframework.kores.util/identity-hash.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Default hash algorithm. |
| [nonStrictEq](../../com.koresframework.kores.util/non-strict-eq.md) | [jvm]<br>fun [KoresType](index.md).[nonStrictEq](../../com.koresframework.kores.util/non-strict-eq.md)(other: [KoresType](index.md)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Non-strict generic equality check, only works for generic types. |
| [toStr](../../com.koresframework.kores.util/to-str.md) | [jvm]<br>fun [KoresType](index.md).[toStr](../../com.koresframework.kores.util/to-str.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Default to string conversion for [KoresType](index.md). |
