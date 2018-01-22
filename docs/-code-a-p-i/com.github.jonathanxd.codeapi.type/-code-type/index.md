[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.type](../index.md) / [CodeType](.)

# CodeType

`interface CodeType : `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`, `[`Comparable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-comparable/index.html)`<CodeType>, Type`

A type representation, like:

* Java Classes (reflection and apt types).

* CodeAPI Type Declarations.

* Plain class name.

* ALIAS type: [com.github.jonathanxd.codeapi.util.Alias.THIS](#), [com.github.jonathanxd.codeapi.util.Alias.SUPER](#), [com.github.jonathanxd.codeapi.util.Alias.INTERFACE](#)

Make sure to handle [THIS](#),
[SUPER](#) and [INTERFACE(n)](#) types.

The implementation of this interface must implement [hashCode](hash-code.md) and [equals](equals.md) reflecting equality to
[eq](../../com.github.jonathanxd.codeapi.util/eq.md) and hashing algorithm to [hash](../../com.github.jonathanxd.codeapi.util/hash.md). This does not means that you need to delegate the call, you still
free to check whatever you need, but comparison between two CodeTypes and hash calculation
of CodeType should be made through these methods.

### Properties

| Name | Summary |
|---|---|
| [arrayBaseComponent](array-base-component.md) | `open val arrayBaseComponent: CodeType`<br>Array base component. |
| [arrayComponent](array-component.md) | `open val arrayComponent: CodeType`<br>Array component. |
| [arrayDimension](array-dimension.md) | `open val arrayDimension: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Array dimension, 0 if this type is not an array. |
| [binaryName](binary-name.md) | `open val binaryName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Binary name of the class. |
| [bindedDefaultResolver](binded-default-resolver.md) | `open val bindedDefaultResolver: `[`BindedTypeResolver`](../-binded-type-resolver/index.md)`<*>`<br>Creates a new binded default resolver instance. |
| [canonicalName](canonical-name.md) | `abstract val canonicalName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Canonical name |
| [defaultResolver](default-resolver.md) | `open val defaultResolver: `[`CodeTypeResolver`](../-code-type-resolver/index.md)`<*>`<br>Default resolver. |
| [identification](identification.md) | `open val identification: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Unique string identification, this property may be used for equality comparison, normal types, array types and generic types have different identifications, if a generic type represent a single CodeType without any bound, then the identification will be the same as the single CodeType. |
| [interfaces](interfaces.md) | `open val interfaces: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Type>`<br>Gets the super interfaces of `this` [Type](#) using default resolver. |
| [internalName](internal-name.md) | `open val internalName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Internal class name. |
| [isArray](is-array.md) | `open val isArray: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True if this CodeType is an array type. |
| [isInterface](is-interface.md) | `open val isInterface: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True if this CodeType is a interface type. |
| [isPrimitive](is-primitive.md) | `open val isPrimitive: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True if this CodeType is a primitive type. |
| [isVirtual](is-virtual.md) | `open val isVirtual: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True if is a `Virtual Type` (Virtual Types = Types that were not loaded by JVM) |
| [javaSpecName](java-spec-name.md) | `open val javaSpecName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>JVM Spec class name. |
| [packageName](package-name.md) | `open val packageName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Package name |
| [primitiveType](primitive-type.md) | `open val primitiveType: CodeType?`<br>Primitive type. |
| [simpleName](simple-name.md) | `open val simpleName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Simple name. |
| [superType](super-type.md) | `open val superType: Type?`<br>Gets the super type of `this` [Type](#) using default resolver. |
| [type](type.md) | `abstract val type: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Type name, examples: |
| [wrapperType](wrapper-type.md) | `open val wrapperType: CodeType?`<br>Wrapper type. |

### Functions

| Name | Summary |
|---|---|
| [compareTo](compare-to.md) | `open fun compareTo(other: CodeType): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Compare two identifications |
| [equals](equals.md) | `abstract fun equals(other: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [getTypeName](get-type-name.md) | `open fun getTypeName(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [hashCode](hash-code.md) | `abstract fun hashCode(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [is](is.md) | `open fun is(other: CodeType?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if this CodeType is equals to other CodeType. |
| [isAssignableFrom](is-assignable-from.md) | `open fun isAssignableFrom(type: Type): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if `this` type is assignable from [type](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeType$isAssignableFrom(java.lang.reflect.Type)/type) (using default resolver of [type](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeType$isAssignableFrom(java.lang.reflect.Type)/type)).`open fun isAssignableFrom(type: Type, resolverProvider: (Type) -> `[`CodeTypeResolver`](../-code-type-resolver/index.md)`<*>): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if `this` type is assignable from [type](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeType$isAssignableFrom(java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/type) (using resolver provided by [resolverProvider](is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeType$isAssignableFrom(java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/resolverProvider)). |
| [isConcreteIdEq](is-concrete-id-eq.md) | `open fun isConcreteIdEq(other: Type): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if identification of [concreteType](../concrete-type.md) of this CodeType is equals to [concreteType](../concrete-type.md) of other [Type](#) according to [is](is.md). |
| [isIdEq](is-id-eq.md) | `open fun isIdEq(other: Type): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if this CodeType identification is equals to other [Type](#) according to [is](is.md). |
| [safeIsAssignableFrom](safe-is-assignable-from.md) | `open fun safeIsAssignableFrom(type: Type): EitherObjBoolean<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`>`<br>`open fun safeIsAssignableFrom(type: Type, resolverProvider: (Type) -> `[`CodeTypeResolver`](../-code-type-resolver/index.md)`<*>): EitherObjBoolean<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`>`<br>Returns `Either` that holds either failure exception or whether `this type` is assignable from [type](safe-is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeType$safeIsAssignableFrom(java.lang.reflect.Type)/type). |
| [toArray](to-array.md) | `open fun toArray(dimensions: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): CodeType`<br>Convert this CodeType to a [CodeTypeArray](#). |

### Inherited Functions

| Name | Summary |
|---|---|
| [builder](../../com.github.jonathanxd.codeapi/-code-part/builder.md) | `open fun builder(): `[`Builder`](../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<`[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`, *>`<br>This builder may or may not accept null values, it depends on implementation. |

### Extension Properties

| Name | Summary |
|---|---|
| [arrayBaseComponent](../java.lang.reflect.-type/array-base-component.md) | `val Type.arrayBaseComponent: CodeType`<br>See [CodeType.arrayBaseComponent](array-base-component.md) |
| [arrayComponent](../java.lang.reflect.-type/array-component.md) | `val Type.arrayComponent: CodeType`<br>See [CodeType.arrayComponent](array-component.md) |
| [arrayDimension](../java.lang.reflect.-type/array-dimension.md) | `val Type.arrayDimension: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>See [CodeType.arrayDimension](array-dimension.md) |
| [asGeneric](../java.lang.reflect.-type/as-generic.md) | `val Type.asGeneric: `[`GenericType`](../-generic-type/index.md) |
| [binaryName](../java.lang.reflect.-type/binary-name.md) | `val Type.binaryName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Returns binary name of [Type](#). See [CodeType.binaryName](binary-name.md) |
| [bindedDefaultResolver](../java.lang.reflect.-type/binded-default-resolver.md) | `val Type.bindedDefaultResolver: `[`BindedTypeResolver`](../-binded-type-resolver/index.md)`<*>`<br>See [CodeType.bindedDefaultResolver](binded-default-resolver.md) |
| [canonicalName](../java.lang.reflect.-type/canonical-name.md) | `val Type.canonicalName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>See [CodeType.canonicalName](canonical-name.md) |
| [codeType](../java.lang.reflect.-type/code-type.md) | `val Type.codeType: CodeType` |
| [concreteType](../concrete-type.md) | `val CodeType.concreteType: CodeType`<br>Gets the concrete type of CodeType, if this is a [GenericType](../-generic-type/index.md), the property getter will try to infer the concrete type looping the [GenericType Inferred type](../-generic-type/resolved-type.md). |
| [defaultResolver](../java.lang.reflect.-type/default-resolver.md) | `val Type.defaultResolver: `[`CodeTypeResolver`](../-code-type-resolver/index.md)`<*>`<br>See [CodeType.defaultResolver](default-resolver.md) |
| [descName](../desc-name.md) | `val CodeType.descName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [descriptor](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/descriptor.md) | `val Type.descriptor: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Converts `this` type to type descriptor. |
| [identification](../java.lang.reflect.-type/identification.md) | `val Type.identification: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>See [CodeType.identification](identification.md) |
| [interfaces](../java.lang.reflect.-type/interfaces.md) | `val Type.interfaces: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Type>`<br>See [CodeType.interfaces](interfaces.md) |
| [internalName](../java.lang.reflect.-type/internal-name.md) | `val Type.internalName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Returns internal name of [Type](#). See [CodeType.binaryName](binary-name.md) |
| [isArray](../java.lang.reflect.-type/is-array.md) | `val Type.isArray: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>See [CodeType.isArray](is-array.md) |
| [isInterface](../java.lang.reflect.-type/is-interface.md) | `val Type.isInterface: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>See [CodeType.isInterface](is-interface.md) |
| [isVirtual](../java.lang.reflect.-type/is-virtual.md) | `val Type.isVirtual: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>See [CodeType.isVirtual](is-virtual.md) |
| [javaSpecName](../java.lang.reflect.-type/java-spec-name.md) | `val Type.javaSpecName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Returns java spec name of [Type](#). See [CodeType.javaSpecName](java-spec-name.md) |
| [packageName](../java.lang.reflect.-type/package-name.md) | `val Type.packageName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>See [CodeType.packageName](package-name.md) |
| [primitiveType](../java.lang.reflect.-type/primitive-type.md) | `val Type.primitiveType: CodeType?`<br>See [CodeType.primitiveType](primitive-type.md) |
| [simpleName](../java.lang.reflect.-type/simple-name.md) | `val Type.simpleName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>See [CodeType.simpleName](simple-name.md) |
| [superType](../java.lang.reflect.-type/super-type.md) | `val Type.superType: Type?`<br>See [CodeType.superType](super-type.md) |
| [toGeneric](../java.lang.reflect.-type/to-generic.md) | `val Type.toGeneric: `[`GenericType`](../-generic-type/index.md) |
| [typeDesc](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/type-desc.md) | `val Type.typeDesc: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [typeOrNull](../../com.github.jonathanxd.codeapi/type-or-null.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.typeOrNull: Type?`<br>Gets the type of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or null if receiver is not a [Typed](../../com.github.jonathanxd.codeapi.base/-typed/index.md) instance. |
| [wrapperType](../java.lang.reflect.-type/wrapper-type.md) | `val Type.wrapperType: CodeType?`<br>See [CodeType.wrapperType](wrapper-type.md) |

### Extension Functions

| Name | Summary |
|---|---|
| [annotationValue](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/annotation-value.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.annotationValue(rType: Class<*>): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) |
| [applyType](../apply-type.md) | `fun CodeType.applyType(typeName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, type: CodeType): CodeType` |
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?.asString(simple: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [compareTo](../java.lang.reflect.-type/compare-to.md) | `fun Type.compareTo(other: Type): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>See [CodeType.compareTo](compare-to.md) |
| [createCodeTypeDescriptor](../../com.github.jonathanxd.codeapi.util/create-code-type-descriptor.md) | `fun CodeType.createCodeTypeDescriptor(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Creates CodeType type descriptor |
| [eq](../../com.github.jonathanxd.codeapi.util/eq.md) | `fun CodeType.eq(obj: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Default equals method. |
| [getType](../get-type.md) | `fun CodeType.getType(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): CodeType?`<br>`fun CodeType.getType(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, inside: CodeType): CodeType?` |
| [getType](../java.lang.reflect.-type/get-type.md) | `fun Type.getType(isParameterized: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false): CodeType`<br>Gets the CodeType from a [Type](#). This method only works for Java Reflection Types and CodeType. |
| [getTypeDesc](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/get-type-desc.md) | `fun Type.getTypeDesc(typeStr: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = this.codeType.type): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Convert `this` [name](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/get-type-desc.md#com.github.jonathanxd.codeapi.util$getTypeDesc(java.lang.reflect.Type, kotlin.String)/typeStr) to type description. |
| [hash](../../com.github.jonathanxd.codeapi.util/hash.md) | `fun CodeType.hash(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Default hash algorithm. |
| [identityEq](../../com.github.jonathanxd.codeapi.util/identity-eq.md) | `fun CodeType.identityEq(obj: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Default equals method. |
| [identityHash](../../com.github.jonathanxd.codeapi.util/identity-hash.md) | `fun CodeType.identityHash(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Default hash algorithm. |
| [inferType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/infer-type.md) | `fun Type.inferType(variables: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<out TypeVariable<*>>, classVariables: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<out TypeVariable<*>>, genericType: `[`GenericType`](../-generic-type/index.md)`): CodeType`<br>Infers code type. |
| [invokeConstructor](../../com.github.jonathanxd.codeapi.factory/java.lang.reflect.-type/invoke-constructor.md) | `fun Type.invokeConstructor(): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>`fun Type.invokeConstructor(spec: `[`TypeSpec`](../../com.github.jonathanxd.codeapi.base/-type-spec/index.md)`, arguments: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Invokes constructor of [Type](#) |
| [invokeParse](../../com.github.jonathanxd.codeapi.common/java.lang.reflect.-type/invoke-parse.md) | `fun Type.invokeParse(arg: `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Invokes `X Y.parseN(String)` static method of receiver [Type](#). |
| [invokeStatic](../../com.github.jonathanxd.codeapi.factory/java.lang.reflect.-type/invoke-static.md) | `fun Type.invokeStatic(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, spec: `[`TypeSpec`](../../com.github.jonathanxd.codeapi.base/-type-spec/index.md)`, arguments: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>`fun Type.invokeStatic(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Invokes static method [name](../../com.github.jonathanxd.codeapi.factory/java.lang.reflect.-type/invoke-static.md#com.github.jonathanxd.codeapi.factory$invokeStatic(java.lang.reflect.Type, kotlin.String, com.github.jonathanxd.codeapi.base.TypeSpec, kotlin.collections.List((com.github.jonathanxd.codeapi.CodeInstruction)))/name) of [Type](#) |
| [invokeValueOf](../../com.github.jonathanxd.codeapi.common/java.lang.reflect.-type/invoke-value-of.md) | `fun Type.invokeValueOf(arg: `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Invokes `Y Y.valueOf(X)` static method of receiver [Type](#) that accepts the primitive variant of [Type](#). |
| [is](../java.lang.reflect.-type/is.md) | `fun Type.is(another: Type?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>See CodeType.is |
| [isAssignableFrom](../java.lang.reflect.-type/is-assignable-from.md) | `fun Type.isAssignableFrom(type: Type): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>`fun Type.isAssignableFrom(type: Type, resolverProvider: (Type) -> `[`CodeTypeResolver`](../-code-type-resolver/index.md)`<*>): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>See [CodeType.isAssignableFrom](is-assignable-from.md) |
| [isConcreteIdEq](../java.lang.reflect.-type/is-concrete-id-eq.md) | `fun Type.isConcreteIdEq(another: Type): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>See [CodeType.isConcreteIdEq](is-concrete-id-eq.md) |
| [isNonReifiedType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is-non-reified-type.md) | `fun Type.isNonReifiedType(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [nonStrictEq](../../com.github.jonathanxd.codeapi.util/non-strict-eq.md) | `fun CodeType.nonStrictEq(other: CodeType): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Non-strict generic equality check, only works for generic types. |
| [safeIsAssignableFrom](../java.lang.reflect.-type/safe-is-assignable-from.md) | `fun Type.safeIsAssignableFrom(type: Type): EitherObjBoolean<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`>`<br>`fun Type.safeIsAssignableFrom(type: Type, resolverProvider: (Type) -> `[`CodeTypeResolver`](../-code-type-resolver/index.md)`<*>): EitherObjBoolean<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`>`<br>See [CodeType.safeIsAssignableFrom](safe-is-assignable-from.md) |
| [toArray](../java.lang.reflect.-type/to-array.md) | `fun Type.toArray(dimensions: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): CodeType`<br>See [CodeType.toArray](to-array.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)<br>Convert this value to a literal |
| [toLiteralOrNull](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal-or-null.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteralOrNull(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
| [toStr](../../com.github.jonathanxd.codeapi.util/to-str.md) | `fun CodeType.toStr(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Default to string conversion for CodeType. |

### Inheritors

| Name | Summary |
|---|---|
| [Abstract](../-annotated-code-type/-abstract/index.md) | `abstract class Abstract<out T : `[`Abstract`](../-annotated-code-type/-abstract/index.md)`<T>> : `[`AnnotatedCodeType`](../-annotated-code-type/index.md)`, CodeType` |
| [GenericType](../-generic-type/index.md) | `interface GenericType : CodeType, `[`WrapperCodeType`](../-wrapper-code-type/index.md)<br>Generic type. |
| [INTERFACE](../../com.github.jonathanxd.codeapi.base/-alias/-i-n-t-e-r-f-a-c-e/index.md) | `data class INTERFACE : `[`Alias`](../../com.github.jonathanxd.codeapi.base/-alias/index.md)`, CodeType`<br>Interface extension localization. |
| [LoadedCodeType](../-loaded-code-type/index.md) | `interface LoadedCodeType<T> : CodeType`<br>A CodeType backing to a loaded [Class](#) ([loadedType](../-loaded-code-type/loaded-type.md)). |
| [NullType](../-null-type/index.md) | `object NullType : CodeType`<br>Null code type. |
| [SUPER](../../com.github.jonathanxd.codeapi.base/-alias/-s-u-p-e-r/index.md) | `object SUPER : `[`Alias`](../../com.github.jonathanxd.codeapi.base/-alias/index.md)`, CodeType`<br>Super class localization |
| [THIS](../../com.github.jonathanxd.codeapi.base/-alias/-t-h-i-s/index.md) | `object THIS : `[`Alias`](../../com.github.jonathanxd.codeapi.base/-alias/index.md)`, CodeType`<br>Current class localization. |
| [TypeDeclaration](../../com.github.jonathanxd.codeapi.base/-type-declaration/index.md) | `interface TypeDeclaration : `[`ModifiersHolder`](../../com.github.jonathanxd.codeapi.base/-modifiers-holder/index.md)`, CodeType, `[`QualifiedNamed`](../../com.github.jonathanxd.codeapi.base/-qualified-named/index.md)`, `[`GenericSignatureHolder`](../../com.github.jonathanxd.codeapi.base/-generic-signature-holder/index.md)`, `[`Annotable`](../../com.github.jonathanxd.codeapi.base/-annotable/index.md)`, `[`CommentHolder`](../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/index.md)`, `[`InnerTypesHolder`](../../com.github.jonathanxd.codeapi.base/-inner-types-holder/index.md)`, `[`ElementsHolder`](../../com.github.jonathanxd.codeapi.base/-elements-holder/index.md)<br>Base class of all [TypeDeclaration](../../com.github.jonathanxd.codeapi.base/-type-declaration/index.md)s like classes, interfaces and enums, and inner classes. |
| [TypeRef](../-type-ref/index.md) | `data class TypeRef : CodeType`<br>Reference to a type, this is only intended to be used to inform outer types. |
| [UnknownCodeType](../-unknown-code-type.md) | `interface UnknownCodeType : CodeType`<br>A Code Type that is not known by CodeAPI. These types are commonly those defined by the user to refer to classes that are not loaded by the JVM and isn't defined by CodeAPI, or will be defined later. [UnknownCodeType](../-unknown-code-type.md) is not the same as [TypeRef](../-type-ref/index.md). The [TypeRef](../-type-ref/index.md) is intended to reference CodeAPI type declarations before them is created. [UnknownCodeType](../-unknown-code-type.md) is intended to reference a type that is unknown to either JVM and CodeAPI. |
| [WrapperCodeType](../-wrapper-code-type/index.md) | `interface WrapperCodeType : CodeType`<br>Denotes a CodeType that wraps another type. |
