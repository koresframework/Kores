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
| [arrayBaseComponent](array-base-component.md) | `open val arrayBaseComponent: `[`CodeType`](../-code-type/index.md)<br>Array base component. |
| [arrayComponent](array-component.md) | `open val arrayComponent: `[`CodeType`](../-code-type/index.md)<br>Array component. |
| [arrayDimension](array-dimension.md) | `open val arrayDimension: Int`<br>Array dimension, 0 if this type is not an array. |
| [bounds](bounds.md) | `abstract val bounds: Array<`[`Bound`](-bound/index.md)`>`<br>Bounds of the generic type. |
| [canonicalName](canonical-name.md) | `open val canonicalName: String`<br>Canonical name |
| [codeType](code-type.md) | `open val ~~codeType~~: `[`CodeType`](../-code-type/index.md)<br>Resolved code type. |
| [identification](identification.md) | `open val identification: String`<br>Unique string identification, this property may be used for equality comparison, normal types,
array types and generic types have different identifications, if a generic type represent a single
[CodeType](../-code-type/index.md) without any bound, then the identification will be the same as the single [CodeType](../-code-type/index.md). |
| [isArray](is-array.md) | `open val isArray: Boolean`<br>True if this [CodeType](../-code-type/index.md) is an array type. |
| [isInterface](is-interface.md) | `open val isInterface: Boolean`<br>True if this [CodeType](../-code-type/index.md) is a interface type. |
| [isPrimitive](is-primitive.md) | `open val isPrimitive: Boolean`<br>True if this [CodeType](../-code-type/index.md) is a primitive type. |
| [isType](is-type.md) | `abstract val isType: Boolean`<br>True if this is a Type generic type, false if is a Type Variable generic type. |
| [isVirtual](is-virtual.md) | `open val isVirtual: Boolean`<br>True if is a `Virtual Type` (Virtual Types = Types that were not loaded by JVM) |
| [isWildcard](is-wildcard.md) | `open val isWildcard: Boolean`<br>True if this is a wildcard generic type. |
| [javaSpecName](java-spec-name.md) | `open val javaSpecName: String`<br>JVM Spec class name. |
| [name](name.md) | `abstract val name: String`<br>Name of the generic type. |
| [packageName](package-name.md) | `open val packageName: String`<br>Package name |
| [primitiveType](primitive-type.md) | `open val primitiveType: `[`CodeType`](../-code-type/index.md)`?`<br>Only determine the Primitive type if: |
| [resolvedType](resolved-type.md) | `abstract val resolvedType: `[`CodeType`](../-code-type/index.md)<br>Resolved code type. |
| [simpleName](simple-name.md) | `open val simpleName: String`<br>Simple name. |
| [type](type.md) | `open val type: String`<br>Type name, examples: |
| [wrapperType](wrapper-type.md) | `open val wrapperType: `[`CodeType`](../-code-type/index.md)`?`<br>Only determine the Wrapper type if: |

### Inherited Properties

| Name | Summary |
|---|---|
| [binaryName](../-code-type/binary-name.md) | `open val binaryName: String`<br>Binary name of the class. |
| [bindedDefaultResolver](../-code-type/binded-default-resolver.md) | `open val bindedDefaultResolver: `[`BindedTypeResolver`](../-binded-type-resolver/index.md)`<*>`<br>Creates a new binded default resolver instance. |
| [defaultResolver](../-code-type/default-resolver.md) | `open val defaultResolver: `[`CodeTypeResolver`](../-code-type-resolver/index.md)`<*>`<br>Default resolver. |
| [interfaces](../-code-type/interfaces.md) | `open val interfaces: List<`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`>`<br>Gets the super interfaces of `this` [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) using default resolver. |
| [internalName](../-code-type/internal-name.md) | `open val internalName: String`<br>Internal class name. |
| [superType](../-code-type/super-type.md) | `open val superType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Gets the super type of `this` [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) using default resolver. |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `open fun builder(): `[`Builder`](-builder/index.md)`<GenericType, *>`<br>This builder may or may not accept null values, it depends on implementation. |
| [compareTo](compare-to.md) | `open fun compareTo(other: `[`CodeType`](../-code-type/index.md)`): Int`<br>Compare two identifications |
| [equals](equals.md) | `abstract fun equals(other: Any?): Boolean` |
| [hashCode](hash-code.md) | `abstract fun hashCode(): Int` |
| [is](is.md) | `open fun is(other: `[`CodeType`](../-code-type/index.md)`?): Boolean`<br>Returns true if this [CodeType](../-code-type/index.md) is equals to other [CodeType](../-code-type/index.md). |
| [toArray](to-array.md) | `abstract fun toArray(dimensions: Int): GenericType`<br>Convert this [CodeType](../-code-type/index.md) to a [CodeTypeArray](#). |
| [toString](to-string.md) | `abstract fun toString(): String` |

### Inherited Functions

| Name | Summary |
|---|---|
| [getTypeName](../-code-type/get-type-name.md) | `open fun getTypeName(): String` |
| [isAssignableFrom](../-code-type/is-assignable-from.md) | `open fun isAssignableFrom(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Boolean`<br>Returns true if `this` type is assignable from [type](../-code-type/is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeType$isAssignableFrom(java.lang.reflect.Type)/type) (using default resolver of [type](../-code-type/is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeType$isAssignableFrom(java.lang.reflect.Type)/type)).`open fun isAssignableFrom(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, resolverProvider: (`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`) -> `[`CodeTypeResolver`](../-code-type-resolver/index.md)`<*>): Boolean`<br>Returns true if `this` type is assignable from [type](../-code-type/is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeType$isAssignableFrom(java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/type) (using resolver provided by [resolverProvider](../-code-type/is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeType$isAssignableFrom(java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/resolverProvider)). |
| [isConcreteIdEq](../-code-type/is-concrete-id-eq.md) | `open fun isConcreteIdEq(other: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Boolean`<br>Returns true if identification of [concreteType](../../com.github.jonathanxd.codeapi.util/concrete-type.md) of this [CodeType](../-code-type/index.md) is equals to
[concreteType](../../com.github.jonathanxd.codeapi.util/concrete-type.md) of other [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) according to [is](../-code-type/is.md). |
| [isIdEq](../-code-type/is-id-eq.md) | `open fun isIdEq(other: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Boolean`<br>Returns true if this [CodeType](../-code-type/index.md) identification is equals to other [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) according to [is](../-code-type/is.md). |

### Extension Properties

| Name | Summary |
|---|---|
| [arrayBaseComponent](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/array-base-component.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.arrayBaseComponent: `[`CodeType`](../-code-type/index.md)<br>See [CodeType.arrayBaseComponent](../-code-type/array-base-component.md) |
| [arrayComponent](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/array-component.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.arrayComponent: `[`CodeType`](../-code-type/index.md)<br>See [CodeType.arrayComponent](../-code-type/array-component.md) |
| [arrayDimension](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/array-dimension.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.arrayDimension: Int`<br>See [CodeType.arrayDimension](../-code-type/array-dimension.md) |
| [asGeneric](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/as-generic.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.asGeneric: GenericType` |
| [binaryName](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/binary-name.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.binaryName: String`<br>Returns binary name of [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html). See [CodeType.binaryName](../-code-type/binary-name.md) |
| [canonicalName](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/canonical-name.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.canonicalName: String`<br>See [CodeType.canonicalName](../-code-type/canonical-name.md) |
| [codeType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/code-type.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.codeType: `[`CodeType`](../-code-type/index.md) |
| [defaultResolver](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/default-resolver.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.defaultResolver: `[`CodeTypeResolver`](../-code-type-resolver/index.md)`<*>`<br>See [CodeType.defaultResolver](../-code-type/default-resolver.md) |
| [descName](../../com.github.jonathanxd.codeapi.util/desc-name.md) | `val `[`CodeType`](../-code-type/index.md)`.descName: String` |
| [descriptor](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/descriptor.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.descriptor: String`<br>Converts `this` type to type descriptor. |
| [identification](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/identification.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.identification: String`<br>See [CodeType.identification](../-code-type/identification.md) |
| [interfaces](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/interfaces.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.interfaces: List<`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`>`<br>See [CodeType.interfaces](../-code-type/interfaces.md) |
| [internalName](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/internal-name.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.internalName: String`<br>Returns internal name of [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html). See [CodeType.binaryName](../-code-type/binary-name.md) |
| [isArray](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is-array.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.isArray: Boolean`<br>See [CodeType.isArray](../-code-type/is-array.md) |
| [isInterface](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is-interface.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.isInterface: Boolean`<br>See [CodeType.isInterface](../-code-type/is-interface.md) |
| [isVirtual](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is-virtual.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.isVirtual: Boolean`<br>See [CodeType.isVirtual](../-code-type/is-virtual.md) |
| [javaSpecName](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/java-spec-name.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.javaSpecName: String`<br>Returns java spec name of [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html). See [CodeType.javaSpecName](../-code-type/java-spec-name.md) |
| [packageName](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/package-name.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.packageName: String`<br>See [CodeType.packageName](../-code-type/package-name.md) |
| [primitiveType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/primitive-type.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.primitiveType: `[`CodeType`](../-code-type/index.md)`?`<br>See [CodeType.primitiveType](../-code-type/primitive-type.md) |
| [simpleName](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/simple-name.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.simpleName: String`<br>See [CodeType.simpleName](../-code-type/simple-name.md) |
| [superType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/super-type.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.superType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>See [CodeType.superType](../-code-type/super-type.md) |
| [typeDesc](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/type-desc.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.typeDesc: String` |
| [typeOrNull](../../com.github.jonathanxd.codeapi.util/type-or-null.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.typeOrNull: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Gets the type of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or null if receiver is not a [Typed](../../com.github.jonathanxd.codeapi.base/-typed/index.md) instance. |
| [wrapperType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/wrapper-type.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.wrapperType: `[`CodeType`](../-code-type/index.md)`?`<br>See [CodeType.wrapperType](../-code-type/wrapper-type.md) |

### Extension Functions

| Name | Summary |
|---|---|
| [applyType](../../com.github.jonathanxd.codeapi.util/apply-type.md) | `fun GenericType.applyType(typeName: String, type: `[`CodeType`](../-code-type/index.md)`): GenericType` |
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [compareTo](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/compare-to.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.compareTo(other: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Int`<br>See [CodeType.compareTo](../-code-type/compare-to.md) |
| [createCodeTypeDescriptor](../../com.github.jonathanxd.codeapi.util/create-code-type-descriptor.md) | `fun `[`CodeType`](../-code-type/index.md)`.createCodeTypeDescriptor(): String`<br>Creates [CodeType](../-code-type/index.md) type descriptor |
| [eq](../../com.github.jonathanxd.codeapi.util/eq.md) | `fun GenericType.eq(other: Any?): Boolean`<br>Default equals algorithm for GenericType |
| [genericTypeToDescriptor](../../com.github.jonathanxd.codeapi.util/generic-type-to-descriptor.md) | `fun GenericType.genericTypeToDescriptor(): String`<br>Create a type descriptor from receiver type. |
| [getType](../../com.github.jonathanxd.codeapi.util/get-type.md) | `fun GenericType.getType(name: String): `[`CodeType`](../-code-type/index.md)`?`<br>`fun GenericType.getType(name: String, inside: `[`CodeType`](../-code-type/index.md)`): `[`CodeType`](../-code-type/index.md)`?` |
| [getType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/get-type.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.getType(isParameterized: Boolean = false): `[`CodeType`](../-code-type/index.md)<br>Gets the [CodeType](../-code-type/index.md) from a [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html). This method only works for Java Reflection Types and [CodeType](../-code-type/index.md). |
| [getTypeDesc](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/get-type-desc.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.getTypeDesc(typeStr: String = this.codeType.type): String`<br>Convert `this` [name](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/get-type-desc.md#com.github.jonathanxd.codeapi.util$getTypeDesc(java.lang.reflect.Type, kotlin.String)/typeStr) to type description. |
| [hash](../../com.github.jonathanxd.codeapi.util/hash.md) | `fun GenericType.hash(): Int`<br>Default hashCode algorithm for GenericType |
| [inferType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/infer-type.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.inferType(variables: Array<out `[`TypeVariable`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/TypeVariable.html)`<*>>, classVariables: Array<out `[`TypeVariable`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/TypeVariable.html)`<*>>, generic: `[`Generic`](../-generic/index.md)`): `[`CodeType`](../-code-type/index.md)<br>Infers code type. |
| [invokeConstructor](../../com.github.jonathanxd.codeapi.factory/java.lang.reflect.-type/invoke-constructor.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.invokeConstructor(): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>`fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.invokeConstructor(spec: `[`TypeSpec`](../../com.github.jonathanxd.codeapi.base/-type-spec/index.md)`, arguments: List<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Invokes constructor of [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) |
| [invokeStatic](../../com.github.jonathanxd.codeapi.factory/java.lang.reflect.-type/invoke-static.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.invokeStatic(name: String, spec: `[`TypeSpec`](../../com.github.jonathanxd.codeapi.base/-type-spec/index.md)`, arguments: List<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>`fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.invokeStatic(name: String): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Invokes static method [name](../../com.github.jonathanxd.codeapi.factory/java.lang.reflect.-type/invoke-static.md#com.github.jonathanxd.codeapi.factory$invokeStatic(java.lang.reflect.Type, kotlin.String, com.github.jonathanxd.codeapi.base.TypeSpec, kotlin.collections.List((com.github.jonathanxd.codeapi.CodeInstruction)))/name) of [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) |
| [is](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.is(another: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?): Boolean`<br>See [CodeType.is](../-code-type/index.md) |
| [isAssignableFrom](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is-assignable-from.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.isAssignableFrom(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Boolean`<br>`fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.isAssignableFrom(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, resolverProvider: (`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`) -> `[`CodeTypeResolver`](../-code-type-resolver/index.md)`<*>): Boolean`<br>See [CodeType.isAssignableFrom](../-code-type/is-assignable-from.md) |
| [isConcreteIdEq](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is-concrete-id-eq.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.isConcreteIdEq(another: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Boolean`<br>See [CodeType.isConcreteIdEq](../-code-type/is-concrete-id-eq.md) |
| [isNonReifiedType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is-non-reified-type.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.isNonReifiedType(): <ERROR CLASS>` |
| [nonStrictEq](../../com.github.jonathanxd.codeapi.util/non-strict-eq.md) | `fun GenericType.nonStrictEq(other: `[`CodeType`](../-code-type/index.md)`): Boolean`<br>Non-strict generic bound equality check, only works for generic types. |
| [toArray](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/to-array.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.toArray(dimensions: Int): `[`CodeType`](../-code-type/index.md)<br>See [CodeType.toArray](../-code-type/to-array.md) |
| [toComponentString](../../com.github.jonathanxd.codeapi.util/to-component-string.md) | `fun GenericType.toComponentString(): String`<br>Creates string representation of components of GenericType. |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
| [toSourceString](../../com.github.jonathanxd.codeapi.util/to-source-string.md) | `fun GenericType.toSourceString(): String`<br>Convert generic type to string. |
| [toStr](../../com.github.jonathanxd.codeapi.util/to-str.md) | `fun GenericType.toStr(): String`<br>Default to string conversion for GenericType. |

### Inheritors

| Name | Summary |
|---|---|
| [Generic](../-generic/index.md) | `class Generic : GenericType`<br>A generic type. |
| [GenericTypeImpl](../-generic-type-impl/index.md) | `class GenericTypeImpl : GenericType`<br>Generic type implementation. |
