[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.type](../index.md) / [CodeType](.)

# CodeType

`interface CodeType : `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`, Comparable<CodeType>, `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)

A type representation, like:

* Java Classes.
* CodeAPI Type Declarations.
* Plain class name.
* ALIAS type: [com.github.jonathanxd.codeapi.util.Alias.THIS](../../com.github.jonathanxd.codeapi.util/-alias/-t-h-i-s/index.md), [com.github.jonathanxd.codeapi.util.Alias.SUPER](../../com.github.jonathanxd.codeapi.util/-alias/-s-u-p-e-r/index.md), [com.github.jonathanxd.codeapi.util.Alias.INTERFACE](../../com.github.jonathanxd.codeapi.util/-alias/-i-n-t-e-r-f-a-c-e/index.md)

Make sure to handle [THIS](../../com.github.jonathanxd.codeapi.util/-alias/-t-h-i-s/index.md),
[SUPER](../../com.github.jonathanxd.codeapi.util/-alias/-s-u-p-e-r/index.md) and [INTERFACE(n)](../../com.github.jonathanxd.codeapi.util/-alias/-i-n-t-e-r-f-a-c-e/index.md) types.

The implementation of this interface must implement [hashCode](hash-code.md) and [equals](equals.md) reflecting equality to
[eq](../../com.github.jonathanxd.codeapi.util/eq.md) and hashing algorithm to [hash](../../com.github.jonathanxd.codeapi.util/hash.md). This does not means that you need to delegate the call, you still
free to check whatever you need, but comparison between two CodeTypes and hash calculation
of CodeType should be made through these methods.

### Properties

| Name | Summary |
|---|---|
| [arrayBaseComponent](array-base-component.md) | `open val arrayBaseComponent: CodeType`<br>Array base component. |
| [arrayComponent](array-component.md) | `open val arrayComponent: CodeType`<br>Array component. |
| [arrayDimension](array-dimension.md) | `open val arrayDimension: Int`<br>Array dimension, 0 if this type is not an array. |
| [binaryName](binary-name.md) | `open val binaryName: String`<br>Binary name of the class. |
| [bindedDefaultResolver](binded-default-resolver.md) | `open val bindedDefaultResolver: `[`BindedTypeResolver`](../-binded-type-resolver/index.md)`<*>`<br>Creates a new binded default resolver instance. |
| [canonicalName](canonical-name.md) | `abstract val canonicalName: String`<br>Canonical name |
| [defaultResolver](default-resolver.md) | `open val defaultResolver: `[`CodeTypeResolver`](../-code-type-resolver/index.md)`<*>`<br>Default resolver. |
| [identification](identification.md) | `open val identification: String`<br>Unique string identification, this property may be used for equality comparison, normal types,
array types and generic types have different identifications, if a generic type represent a single
CodeType without any bound, then the identification will be the same as the single CodeType. |
| [interfaces](interfaces.md) | `open val interfaces: List<`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`>`<br>Gets the super interfaces of `this` [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) using default resolver. |
| [internalName](internal-name.md) | `open val internalName: String`<br>Internal class name. |
| [isArray](is-array.md) | `open val isArray: Boolean`<br>True if this CodeType is an array type. |
| [isInterface](is-interface.md) | `open val isInterface: Boolean`<br>True if this CodeType is a interface type. |
| [isPrimitive](is-primitive.md) | `open val isPrimitive: Boolean`<br>True if this CodeType is a primitive type. |
| [isVirtual](is-virtual.md) | `open val isVirtual: Boolean`<br>True if is a `Virtual Type` (Virtual Types = Types that were not loaded by JVM) |
| [javaSpecName](java-spec-name.md) | `open val javaSpecName: String`<br>JVM Spec class name. |
| [packageName](package-name.md) | `open val packageName: String`<br>Package name |
| [primitiveType](primitive-type.md) | `open val primitiveType: CodeType?`<br>Primitive type. |
| [simpleName](simple-name.md) | `open val simpleName: String`<br>Simple name. |
| [superType](super-type.md) | `open val superType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Gets the super type of `this` [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) using default resolver. |
| [type](type.md) | `abstract val type: String`<br>Type name, examples: |
| [wrapperType](wrapper-type.md) | `open val wrapperType: CodeType?`<br>Wrapper type. |

### Functions

| Name | Summary |
|---|---|
| [compareTo](compare-to.md) | `open fun compareTo(other: CodeType): Int`<br>Compare two identifications |
| [equals](equals.md) | `abstract fun equals(other: Any?): Boolean` |
| [getTypeName](get-type-name.md) | `open fun getTypeName(): String` |
| [hashCode](hash-code.md) | `abstract fun hashCode(): Int` |
| [is](is.md) | `open fun is(other: CodeType?): Boolean`<br>Returns true if this CodeType is equals to other CodeType. |
| [isAssignableFrom](is-assignable-from.md) | `open fun isAssignableFrom(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Boolean`<br>Returns true if `this` type is assignable from [type](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeType$isAssignableFrom(java.lang.reflect.Type)/type) (using default resolver of [type](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeType$isAssignableFrom(java.lang.reflect.Type)/type)).`open fun isAssignableFrom(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, resolverProvider: (`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`) -> `[`CodeTypeResolver`](../-code-type-resolver/index.md)`<*>): Boolean`<br>Returns true if `this` type is assignable from [type](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeType$isAssignableFrom(java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/type) (using resolver provided by [resolverProvider](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeType$isAssignableFrom(java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/resolverProvider)). |
| [isConcreteIdEq](is-concrete-id-eq.md) | `open fun isConcreteIdEq(other: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Boolean`<br>Returns true if identification of [concreteType](../../com.github.jonathanxd.codeapi.util/concrete-type.md) of this CodeType is equals to
[concreteType](../../com.github.jonathanxd.codeapi.util/concrete-type.md) of other [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) according to [is](is.md). |
| [isIdEq](is-id-eq.md) | `open fun isIdEq(other: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Boolean`<br>Returns true if this CodeType identification is equals to other [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) according to [is](is.md). |
| [toArray](to-array.md) | `open fun toArray(dimensions: Int): CodeType`<br>Convert this CodeType to a [CodeTypeArray](#). |

### Inherited Functions

| Name | Summary |
|---|---|
| [builder](../../com.github.jonathanxd.codeapi/-code-part/builder.md) | `open fun builder(): `[`Builder`](../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<`[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`, *>`<br>This builder may or may not accept null values, it depends on implementation. |

### Extension Properties

| Name | Summary |
|---|---|
| [arrayBaseComponent](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/array-base-component.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.arrayBaseComponent: CodeType`<br>See [CodeType.arrayBaseComponent](array-base-component.md) |
| [arrayComponent](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/array-component.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.arrayComponent: CodeType`<br>See [CodeType.arrayComponent](array-component.md) |
| [arrayDimension](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/array-dimension.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.arrayDimension: Int`<br>See [CodeType.arrayDimension](array-dimension.md) |
| [asGeneric](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/as-generic.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.asGeneric: `[`GenericType`](../-generic-type/index.md) |
| [binaryName](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/binary-name.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.binaryName: String`<br>Returns binary name of [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html). See [CodeType.binaryName](binary-name.md) |
| [canonicalName](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/canonical-name.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.canonicalName: String`<br>See [CodeType.canonicalName](canonical-name.md) |
| [codeType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/code-type.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.codeType: CodeType` |
| [concreteType](../../com.github.jonathanxd.codeapi.util/concrete-type.md) | `val CodeType.concreteType: CodeType`<br>Gets the concrete type of CodeType, if this is a [GenericType](../-generic-type/index.md), the property getter will try to
infer the concrete type looping the [GenericType Inferred type](../-generic-type/resolved-type.md). |
| [defaultResolver](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/default-resolver.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.defaultResolver: `[`CodeTypeResolver`](../-code-type-resolver/index.md)`<*>`<br>See [CodeType.defaultResolver](default-resolver.md) |
| [descName](../../com.github.jonathanxd.codeapi.util/desc-name.md) | `val CodeType.descName: String` |
| [descriptor](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/descriptor.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.descriptor: String`<br>Converts `this` type to type descriptor. |
| [identification](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/identification.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.identification: String`<br>See [CodeType.identification](identification.md) |
| [interfaces](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/interfaces.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.interfaces: List<`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`>`<br>See [CodeType.interfaces](interfaces.md) |
| [internalName](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/internal-name.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.internalName: String`<br>Returns internal name of [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html). See [CodeType.binaryName](binary-name.md) |
| [isArray](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is-array.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.isArray: Boolean`<br>See [CodeType.isArray](is-array.md) |
| [isInterface](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is-interface.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.isInterface: Boolean`<br>See [CodeType.isInterface](is-interface.md) |
| [isVirtual](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is-virtual.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.isVirtual: Boolean`<br>See [CodeType.isVirtual](is-virtual.md) |
| [javaSpecName](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/java-spec-name.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.javaSpecName: String`<br>Returns java spec name of [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html). See [CodeType.javaSpecName](java-spec-name.md) |
| [packageName](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/package-name.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.packageName: String`<br>See [CodeType.packageName](package-name.md) |
| [primitiveType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/primitive-type.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.primitiveType: CodeType?`<br>See [CodeType.primitiveType](primitive-type.md) |
| [simpleName](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/simple-name.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.simpleName: String`<br>See [CodeType.simpleName](simple-name.md) |
| [superType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/super-type.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.superType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>See [CodeType.superType](super-type.md) |
| [typeDesc](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/type-desc.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.typeDesc: String` |
| [typeOrNull](../../com.github.jonathanxd.codeapi.util/type-or-null.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.typeOrNull: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Gets the type of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or null if receiver is not a [Typed](../../com.github.jonathanxd.codeapi.base/-typed/index.md) instance. |
| [wrapperType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/wrapper-type.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.wrapperType: CodeType?`<br>See [CodeType.wrapperType](wrapper-type.md) |

### Extension Functions

| Name | Summary |
|---|---|
| [applyType](../../com.github.jonathanxd.codeapi.util/apply-type.md) | `fun CodeType.applyType(typeName: String, type: CodeType): CodeType` |
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [compareTo](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/compare-to.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.compareTo(other: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Int`<br>See [CodeType.compareTo](compare-to.md) |
| [createCodeTypeDescriptor](../../com.github.jonathanxd.codeapi.util/create-code-type-descriptor.md) | `fun CodeType.createCodeTypeDescriptor(): String`<br>Creates CodeType type descriptor |
| [eq](../../com.github.jonathanxd.codeapi.util/eq.md) | `fun CodeType.eq(obj: Any?): Boolean`<br>Default equals method. |
| [getType](../../com.github.jonathanxd.codeapi.util/get-type.md) | `fun CodeType.getType(name: String): CodeType?`<br>`fun CodeType.getType(name: String, inside: CodeType): CodeType?` |
| [getType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/get-type.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.getType(isParameterized: Boolean = false): CodeType`<br>Gets the CodeType from a [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html). This method only works for Java Reflection Types and CodeType. |
| [getTypeDesc](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/get-type-desc.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.getTypeDesc(typeStr: String = this.codeType.type): String`<br>Convert `this` [name](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/get-type-desc.md#com.github.jonathanxd.codeapi.util$getTypeDesc(java.lang.reflect.Type, kotlin.String)/typeStr) to type description. |
| [hash](../../com.github.jonathanxd.codeapi.util/hash.md) | `fun CodeType.hash(): Int`<br>Default hash algorithm. |
| [inferType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/infer-type.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.inferType(variables: Array<out `[`TypeVariable`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/TypeVariable.html)`<*>>, classVariables: Array<out `[`TypeVariable`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/TypeVariable.html)`<*>>, generic: `[`Generic`](../-generic/index.md)`): CodeType`<br>Infers code type. |
| [invokeConstructor](../../com.github.jonathanxd.codeapi.factory/java.lang.reflect.-type/invoke-constructor.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.invokeConstructor(): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>`fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.invokeConstructor(spec: `[`TypeSpec`](../../com.github.jonathanxd.codeapi.base/-type-spec/index.md)`, arguments: List<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Invokes constructor of [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) |
| [invokeStatic](../../com.github.jonathanxd.codeapi.factory/java.lang.reflect.-type/invoke-static.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.invokeStatic(name: String, spec: `[`TypeSpec`](../../com.github.jonathanxd.codeapi.base/-type-spec/index.md)`, arguments: List<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>`fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.invokeStatic(name: String): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Invokes static method [name](../../com.github.jonathanxd.codeapi.factory/java.lang.reflect.-type/invoke-static.md#com.github.jonathanxd.codeapi.factory$invokeStatic(java.lang.reflect.Type, kotlin.String, com.github.jonathanxd.codeapi.base.TypeSpec, kotlin.collections.List((com.github.jonathanxd.codeapi.CodeInstruction)))/name) of [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) |
| [is](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.is(another: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?): Boolean`<br>See CodeType.is |
| [isAssignableFrom](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is-assignable-from.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.isAssignableFrom(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Boolean`<br>`fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.isAssignableFrom(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, resolverProvider: (`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`) -> `[`CodeTypeResolver`](../-code-type-resolver/index.md)`<*>): Boolean`<br>See [CodeType.isAssignableFrom](is-assignable-from.md) |
| [isConcreteIdEq](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is-concrete-id-eq.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.isConcreteIdEq(another: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Boolean`<br>See [CodeType.isConcreteIdEq](is-concrete-id-eq.md) |
| [isNonReifiedType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is-non-reified-type.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.isNonReifiedType(): <ERROR CLASS>` |
| [nonStrictEq](../../com.github.jonathanxd.codeapi.util/non-strict-eq.md) | `fun CodeType.nonStrictEq(other: CodeType): Boolean`<br>Non-strict generic equality check, only works for generic types. |
| [toArray](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/to-array.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.toArray(dimensions: Int): CodeType`<br>See [CodeType.toArray](to-array.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
| [toStr](../../com.github.jonathanxd.codeapi.util/to-str.md) | `fun CodeType.toStr(): String`<br>Default to string conversion for CodeType. |

### Inheritors

| Name | Summary |
|---|---|
| [GenericType](../-generic-type/index.md) | `interface GenericType : CodeType`<br>Generic type. |
| [INTERFACE](../../com.github.jonathanxd.codeapi.util/-alias/-i-n-t-e-r-f-a-c-e/index.md) | `data class INTERFACE : `[`Alias`](../../com.github.jonathanxd.codeapi.util/-alias/index.md)`, CodeType`<br>Interface extension localization. |
| [LoadedCodeType](../-loaded-code-type/index.md) | `interface LoadedCodeType<T> : CodeType`<br>A CodeType backing to a loaded [Class](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html) ([loadedType](../-loaded-code-type/loaded-type.md)). |
| [NullType](../-null-type/index.md) | `object NullType : CodeType`<br>Null code type. |
| [PlainCodeType](../-plain-code-type/index.md) | `open class PlainCodeType : CodeType, `[`InheritanceProvider`](../-inheritance-provider/index.md)<br>Plain string code type. |
| [SUPER](../../com.github.jonathanxd.codeapi.util/-alias/-s-u-p-e-r/index.md) | `object SUPER : `[`Alias`](../../com.github.jonathanxd.codeapi.util/-alias/index.md)`, CodeType`<br>Super class localization |
| [THIS](../../com.github.jonathanxd.codeapi.util/-alias/-t-h-i-s/index.md) | `object THIS : `[`Alias`](../../com.github.jonathanxd.codeapi.util/-alias/index.md)`, CodeType`<br>Current class localization. |
| [TypeDeclaration](../../com.github.jonathanxd.codeapi.base/-type-declaration/index.md) | `interface TypeDeclaration : `[`ModifiersHolder`](../../com.github.jonathanxd.codeapi.base/-modifiers-holder/index.md)`, CodeType, `[`QualifiedNamed`](../../com.github.jonathanxd.codeapi.base/-qualified-named/index.md)`, `[`GenericSignatureHolder`](../../com.github.jonathanxd.codeapi.base/-generic-signature-holder/index.md)`, `[`Annotable`](../../com.github.jonathanxd.codeapi.base/-annotable/index.md)`, `[`CommentHolder`](../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/index.md)`, `[`InnerTypesHolder`](../../com.github.jonathanxd.codeapi.base/-inner-types-holder/index.md)`, `[`ElementsHolder`](../../com.github.jonathanxd.codeapi.base/-elements-holder/index.md)<br>Base class of all [TypeDeclaration](../../com.github.jonathanxd.codeapi.base/-type-declaration/index.md)s like classes, interfaces and enums, and inner classes. |
| [TypeRef](../-type-ref/index.md) | `data class TypeRef : CodeType`<br>Reference to a type, this is only intended to be used to inform outer types. |
