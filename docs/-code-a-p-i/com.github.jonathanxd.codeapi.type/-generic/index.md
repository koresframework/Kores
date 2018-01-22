[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.type](../index.md) / [Generic](.)

# Generic

`class Generic : `[`GenericType`](../-generic-type/index.md)

A generic type.

Examples:

A generic type T that extends String:

`Generic.type("T").extends$(String.class);`

A generic type T that extends V:

`Generic.type("T").extends$("V");`

A List of Type T:

`Generic.type(List.class).of("T")`

**Attention: All calls of the methods of Generic class creates a copy of the `bound` array (except the first call), if you mind performance use the [GenericTypeBuilder](../-generic-type-builder/index.md)**

### Properties

| Name | Summary |
|---|---|
| [bounds](bounds.md) | `val bounds: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`Bound`](../-generic-type/-bound/index.md)`>`<br>Generic bounds. |
| [canonicalName](canonical-name.md) | `val canonicalName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Canonical name |
| [isArray](is-array.md) | `val isArray: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True if this [CodeType](../-code-type/index.md) is an array type. |
| [isInterface](is-interface.md) | `val isInterface: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True if this [CodeType](../-code-type/index.md) is a interface type. |
| [isPrimitive](is-primitive.md) | `val isPrimitive: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True if this [CodeType](../-code-type/index.md) is a primitive type. |
| [isType](is-type.md) | `val isType: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True if this is a Type generic type, false if is a Type Variable generic type. |
| [isVirtual](is-virtual.md) | `val isVirtual: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True if is a `Virtual Type` (Virtual Types = Types that were not loaded by JVM) |
| [javaSpecName](java-spec-name.md) | `val javaSpecName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>JVM Spec class name. |
| [name](name.md) | `val name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Name of the generic type. |
| [packageName](package-name.md) | `val packageName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Package name |
| [primitiveType](primitive-type.md) | `val primitiveType: `[`CodeType`](../-code-type/index.md)`?`<br>Only determine the Primitive type if: |
| [resolvedType](resolved-type.md) | `val resolvedType: `[`CodeType`](../-code-type/index.md)<br>Type. |
| [simpleName](simple-name.md) | `val simpleName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Simple name. |
| [type](type.md) | `val type: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Type name, examples: |
| [wrapperType](wrapper-type.md) | `val wrapperType: `[`CodeType`](../-code-type/index.md)`?`<br>Only determine the Wrapper type if: |

### Inherited Properties

| Name | Summary |
|---|---|
| [arrayBaseComponent](../-generic-type/array-base-component.md) | `open val arrayBaseComponent: `[`CodeType`](../-code-type/index.md)<br>Array base component. |
| [arrayComponent](../-generic-type/array-component.md) | `open val arrayComponent: `[`CodeType`](../-code-type/index.md)<br>Array component. |
| [arrayDimension](../-generic-type/array-dimension.md) | `open val arrayDimension: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Array dimension, 0 if this type is not an array. |
| [codeType](../-generic-type/code-type.md) | `open val ~~codeType~~: `[`CodeType`](../-code-type/index.md)<br>Resolved code type. |
| [identification](../-generic-type/identification.md) | `open val identification: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Unique string identification, this property may be used for equality comparison, normal types, array types and generic types have different identifications, if a generic type represent a single [CodeType](../-code-type/index.md) without any bound, then the identification will be the same as the single [CodeType](../-code-type/index.md). |
| [isWildcard](../-generic-type/is-wildcard.md) | `open val isWildcard: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True if this is a wildcard generic type. |
| [wrapped](../-generic-type/wrapped.md) | `open val wrapped: `[`CodeType`](../-code-type/index.md)<br>Wrapped code type. |

### Functions

| Name | Summary |
|---|---|
| [compareTo](compare-to.md) | `fun compareTo(other: `[`CodeType`](../-code-type/index.md)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Compare two identifications |
| [equals](equals.md) | `fun equals(other: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [extends$](extends$.md) | `fun extends$(s: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Generic`<br>Generic type that extends type variable `s`.`fun extends$(vararg ss: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Generic`<br>Generic type that extends type variables `ss`.`fun extends$(type: Type): Generic`<br>Generic type that extends type `type`.`fun extends$(vararg types: Type): Generic`<br>Generic type that extends types `types`. |
| [hashCode](hash-code.md) | `fun hashCode(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [of](of.md) | `fun of(bound: `[`Bound`](../-generic-type/-bound/index.md)`): Generic`<br>Add a bound.`fun of(vararg bounds: `[`Bound`](../-generic-type/-bound/index.md)`): Generic`<br>Add all [bounds](of.md#com.github.jonathanxd.codeapi.type.Generic$of(kotlin.Array((com.github.jonathanxd.codeapi.type.GenericType.Bound)))/bounds).`fun of(s: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Generic`<br>Add a name bound.`fun of(vararg ss: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Generic`<br>Add name bounds.`fun of(type: Type): Generic`<br>Add a type bound.`fun of(vararg types: Type): Generic`<br>Add type bounds. |
| [super$](super$.md) | `fun super$(s: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Generic`<br>Generic type that have a super type variable `s`.`fun super$(vararg ss: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Generic`<br>Generic type that have a super type variables `ss`.`fun super$(type: Type): Generic`<br>Generic type that have a super type `type`.`fun super$(vararg types: Type): Generic`<br>Generic type that have a super types `types`. |
| [toArray](to-array.md) | `fun toArray(dimensions: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`GenericType`](../-generic-type/index.md)<br>Convert this [CodeType](../-code-type/index.md) to a [CodeTypeArray](#). |
| [toString](to-string.md) | `fun toString(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Inherited Functions

| Name | Summary |
|---|---|
| [builder](../-generic-type/builder.md) | `open fun builder(): `[`Builder`](../-generic-type/-builder/index.md)`<`[`GenericType`](../-generic-type/index.md)`, *>`<br>This builder may or may not accept null values, it depends on implementation. |
| [is](../-generic-type/is.md) | `open fun is(other: `[`CodeType`](../-code-type/index.md)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if this [CodeType](../-code-type/index.md) is equals to other [CodeType](../-code-type/index.md). |

### Companion Object Functions

| Name | Summary |
|---|---|
| [type](type.md) | `fun type(s: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Generic`<br>Create a generic type from a name (ex: T, E, R).`fun type(type: Type): Generic`<br>Create a generic type from a type. |
| [wildcard](wildcard.md) | `fun wildcard(): Generic`<br>Create a generic wildcard (? in Java Language, * in JVM). |

### Extension Properties

| Name | Summary |
|---|---|
| [arrayBaseComponent](../java.lang.reflect.-type/array-base-component.md) | `val Type.arrayBaseComponent: `[`CodeType`](../-code-type/index.md)<br>See [CodeType.arrayBaseComponent](../-code-type/array-base-component.md) |
| [arrayComponent](../java.lang.reflect.-type/array-component.md) | `val Type.arrayComponent: `[`CodeType`](../-code-type/index.md)<br>See [CodeType.arrayComponent](../-code-type/array-component.md) |
| [arrayDimension](../java.lang.reflect.-type/array-dimension.md) | `val Type.arrayDimension: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>See [CodeType.arrayDimension](../-code-type/array-dimension.md) |
| [asGeneric](../java.lang.reflect.-type/as-generic.md) | `val Type.asGeneric: `[`GenericType`](../-generic-type/index.md) |
| [binaryName](../java.lang.reflect.-type/binary-name.md) | `val Type.binaryName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Returns binary name of [Type](#). See [CodeType.binaryName](../-code-type/binary-name.md) |
| [bindedDefaultResolver](../java.lang.reflect.-type/binded-default-resolver.md) | `val Type.bindedDefaultResolver: `[`BindedTypeResolver`](../-binded-type-resolver/index.md)`<*>`<br>See [CodeType.bindedDefaultResolver](../-code-type/binded-default-resolver.md) |
| [canonicalName](../java.lang.reflect.-type/canonical-name.md) | `val Type.canonicalName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>See [CodeType.canonicalName](../-code-type/canonical-name.md) |
| [codeType](../java.lang.reflect.-type/code-type.md) | `val Type.codeType: `[`CodeType`](../-code-type/index.md) |
| [defaultResolver](../java.lang.reflect.-type/default-resolver.md) | `val Type.defaultResolver: `[`CodeTypeResolver`](../-code-type-resolver/index.md)`<*>`<br>See [CodeType.defaultResolver](../-code-type/default-resolver.md) |
| [descName](../desc-name.md) | `val `[`CodeType`](../-code-type/index.md)`.descName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [descriptor](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/descriptor.md) | `val Type.descriptor: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Converts `this` type to type descriptor. |
| [identification](../java.lang.reflect.-type/identification.md) | `val Type.identification: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>See [CodeType.identification](../-code-type/identification.md) |
| [interfaces](../java.lang.reflect.-type/interfaces.md) | `val Type.interfaces: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Type>`<br>See [CodeType.interfaces](../-code-type/interfaces.md) |
| [internalName](../java.lang.reflect.-type/internal-name.md) | `val Type.internalName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Returns internal name of [Type](#). See [CodeType.binaryName](../-code-type/binary-name.md) |
| [isArray](../java.lang.reflect.-type/is-array.md) | `val Type.isArray: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>See [CodeType.isArray](../-code-type/is-array.md) |
| [isInterface](../java.lang.reflect.-type/is-interface.md) | `val Type.isInterface: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>See [CodeType.isInterface](../-code-type/is-interface.md) |
| [isVirtual](../java.lang.reflect.-type/is-virtual.md) | `val Type.isVirtual: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>See [CodeType.isVirtual](../-code-type/is-virtual.md) |
| [javaSpecName](../java.lang.reflect.-type/java-spec-name.md) | `val Type.javaSpecName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Returns java spec name of [Type](#). See [CodeType.javaSpecName](../-code-type/java-spec-name.md) |
| [packageName](../java.lang.reflect.-type/package-name.md) | `val Type.packageName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>See [CodeType.packageName](../-code-type/package-name.md) |
| [primitiveType](../java.lang.reflect.-type/primitive-type.md) | `val Type.primitiveType: `[`CodeType`](../-code-type/index.md)`?`<br>See [CodeType.primitiveType](../-code-type/primitive-type.md) |
| [simpleName](../java.lang.reflect.-type/simple-name.md) | `val Type.simpleName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>See [CodeType.simpleName](../-code-type/simple-name.md) |
| [superType](../java.lang.reflect.-type/super-type.md) | `val Type.superType: Type?`<br>See [CodeType.superType](../-code-type/super-type.md) |
| [toGeneric](../java.lang.reflect.-type/to-generic.md) | `val Type.toGeneric: `[`GenericType`](../-generic-type/index.md) |
| [typeDesc](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/type-desc.md) | `val Type.typeDesc: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [typeOrNull](../../com.github.jonathanxd.codeapi/type-or-null.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.typeOrNull: Type?`<br>Gets the type of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or null if receiver is not a [Typed](../../com.github.jonathanxd.codeapi.base/-typed/index.md) instance. |
| [wrapperType](../java.lang.reflect.-type/wrapper-type.md) | `val Type.wrapperType: `[`CodeType`](../-code-type/index.md)`?`<br>See [CodeType.wrapperType](../-code-type/wrapper-type.md) |

### Extension Functions

| Name | Summary |
|---|---|
| [annotationValue](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/annotation-value.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.annotationValue(rType: Class<*>): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) |
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?.asString(simple: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [compareTo](../java.lang.reflect.-type/compare-to.md) | `fun Type.compareTo(other: Type): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>See [CodeType.compareTo](../-code-type/compare-to.md) |
| [createCodeTypeDescriptor](../../com.github.jonathanxd.codeapi.util/create-code-type-descriptor.md) | `fun `[`CodeType`](../-code-type/index.md)`.createCodeTypeDescriptor(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Creates [CodeType](../-code-type/index.md) type descriptor |
| [genericTypeToDescriptor](../../com.github.jonathanxd.codeapi.util/generic-type-to-descriptor.md) | `fun `[`GenericType`](../-generic-type/index.md)`.genericTypeToDescriptor(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Create a type descriptor from receiver type. |
| [getType](../java.lang.reflect.-type/get-type.md) | `fun Type.getType(isParameterized: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false): `[`CodeType`](../-code-type/index.md)<br>Gets the [CodeType](../-code-type/index.md) from a [Type](#). This method only works for Java Reflection Types and [CodeType](../-code-type/index.md). |
| [getTypeDesc](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/get-type-desc.md) | `fun Type.getTypeDesc(typeStr: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = this.codeType.type): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Convert `this` [name](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/get-type-desc.md#com.github.jonathanxd.codeapi.util$getTypeDesc(java.lang.reflect.Type, kotlin.String)/typeStr) to type description. |
| [identityEq](../../com.github.jonathanxd.codeapi.util/identity-eq.md) | `fun `[`CodeType`](../-code-type/index.md)`.identityEq(obj: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Default equals method. |
| [identityHash](../../com.github.jonathanxd.codeapi.util/identity-hash.md) | `fun `[`CodeType`](../-code-type/index.md)`.identityHash(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Default hash algorithm. |
| [inferType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/infer-type.md) | `fun Type.inferType(variables: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<out TypeVariable<*>>, classVariables: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<out TypeVariable<*>>, genericType: `[`GenericType`](../-generic-type/index.md)`): `[`CodeType`](../-code-type/index.md)<br>Infers code type. |
| [invokeConstructor](../../com.github.jonathanxd.codeapi.factory/java.lang.reflect.-type/invoke-constructor.md) | `fun Type.invokeConstructor(): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>`fun Type.invokeConstructor(spec: `[`TypeSpec`](../../com.github.jonathanxd.codeapi.base/-type-spec/index.md)`, arguments: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Invokes constructor of [Type](#) |
| [invokeParse](../../com.github.jonathanxd.codeapi.common/java.lang.reflect.-type/invoke-parse.md) | `fun Type.invokeParse(arg: `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Invokes `X Y.parseN(String)` static method of receiver [Type](#). |
| [invokeStatic](../../com.github.jonathanxd.codeapi.factory/java.lang.reflect.-type/invoke-static.md) | `fun Type.invokeStatic(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, spec: `[`TypeSpec`](../../com.github.jonathanxd.codeapi.base/-type-spec/index.md)`, arguments: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>`fun Type.invokeStatic(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Invokes static method [name](../../com.github.jonathanxd.codeapi.factory/java.lang.reflect.-type/invoke-static.md#com.github.jonathanxd.codeapi.factory$invokeStatic(java.lang.reflect.Type, kotlin.String, com.github.jonathanxd.codeapi.base.TypeSpec, kotlin.collections.List((com.github.jonathanxd.codeapi.CodeInstruction)))/name) of [Type](#) |
| [invokeValueOf](../../com.github.jonathanxd.codeapi.common/java.lang.reflect.-type/invoke-value-of.md) | `fun Type.invokeValueOf(arg: `[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Invokes `Y Y.valueOf(X)` static method of receiver [Type](#) that accepts the primitive variant of [Type](#). |
| [is](../java.lang.reflect.-type/is.md) | `fun Type.is(another: Type?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>See [CodeType.is](../-code-type/index.md) |
| [isAssignableFrom](../java.lang.reflect.-type/is-assignable-from.md) | `fun Type.isAssignableFrom(type: Type): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>`fun Type.isAssignableFrom(type: Type, resolverProvider: (Type) -> `[`CodeTypeResolver`](../-code-type-resolver/index.md)`<*>): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>See [CodeType.isAssignableFrom](../-code-type/is-assignable-from.md) |
| [isConcreteIdEq](../java.lang.reflect.-type/is-concrete-id-eq.md) | `fun Type.isConcreteIdEq(another: Type): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>See [CodeType.isConcreteIdEq](../-code-type/is-concrete-id-eq.md) |
| [isNonReifiedType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is-non-reified-type.md) | `fun Type.isNonReifiedType(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [safeIsAssignableFrom](../java.lang.reflect.-type/safe-is-assignable-from.md) | `fun Type.safeIsAssignableFrom(type: Type): EitherObjBoolean<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`>`<br>`fun Type.safeIsAssignableFrom(type: Type, resolverProvider: (Type) -> `[`CodeTypeResolver`](../-code-type-resolver/index.md)`<*>): EitherObjBoolean<`[`Exception`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html)`>`<br>See [CodeType.safeIsAssignableFrom](../-code-type/safe-is-assignable-from.md) |
| [toArray](../java.lang.reflect.-type/to-array.md) | `fun Type.toArray(dimensions: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`CodeType`](../-code-type/index.md)<br>See [CodeType.toArray](../-code-type/to-array.md) |
| [toComponentString](../../com.github.jonathanxd.codeapi.util/to-component-string.md) | `fun `[`GenericType`](../-generic-type/index.md)`.toComponentString(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Creates string representation of components of [GenericType](../-generic-type/index.md). |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)<br>Convert this value to a literal |
| [toLiteralOrNull](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal-or-null.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteralOrNull(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
| [toSourceString](../../com.github.jonathanxd.codeapi.util/to-source-string.md) | `fun `[`GenericType`](../-generic-type/index.md)`.toSourceString(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Convert generic type to string. |
