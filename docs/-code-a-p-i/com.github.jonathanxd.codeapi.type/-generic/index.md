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

**Attention:All calls of the methods ofGenericclass creates a copy of the`bound`array(except the first call),if you mind performance use the[GenericTypeBuilder](../-generic-type-builder/index.md)**

### Properties

| Name | Summary |
|---|---|
| [bounds](bounds.md) | `val bounds: Array<`[`Bound`](../-generic-type/-bound/index.md)`>`<br>Generic bounds. |
| [canonicalName](canonical-name.md) | `val canonicalName: String`<br>Canonical name |
| [isArray](is-array.md) | `val isArray: Boolean`<br>True if this [CodeType](../-code-type/index.md) is an array type. |
| [isInterface](is-interface.md) | `val isInterface: Boolean`<br>True if this [CodeType](../-code-type/index.md) is a interface type. |
| [isPrimitive](is-primitive.md) | `val isPrimitive: Boolean`<br>True if this [CodeType](../-code-type/index.md) is a primitive type. |
| [isType](is-type.md) | `val isType: Boolean`<br>True if this is a Type generic type, false if is a Type Variable generic type. |
| [isVirtual](is-virtual.md) | `val isVirtual: Boolean`<br>True if is a `Virtual Type` (Virtual Types = Types that were not loaded by JVM) |
| [javaSpecName](java-spec-name.md) | `val javaSpecName: String`<br>JVM Spec class name. |
| [name](name.md) | `val name: String`<br>Name of the generic type. |
| [packageName](package-name.md) | `val packageName: String`<br>Package name |
| [primitiveType](primitive-type.md) | `val primitiveType: `[`CodeType`](../-code-type/index.md)`?`<br>Only determine the Primitive type if: |
| [resolvedType](resolved-type.md) | `val resolvedType: `[`CodeType`](../-code-type/index.md)<br>Type. |
| [simpleName](simple-name.md) | `val simpleName: String`<br>Simple name. |
| [type](type.md) | `val type: String`<br>Type name, examples: |
| [wrapperType](wrapper-type.md) | `val wrapperType: `[`CodeType`](../-code-type/index.md)`?`<br>Only determine the Wrapper type if: |

### Inherited Properties

| Name | Summary |
|---|---|
| [arrayBaseComponent](../-generic-type/array-base-component.md) | `open val arrayBaseComponent: `[`CodeType`](../-code-type/index.md)<br>Array base component. |
| [arrayComponent](../-generic-type/array-component.md) | `open val arrayComponent: `[`CodeType`](../-code-type/index.md)<br>Array component. |
| [arrayDimension](../-generic-type/array-dimension.md) | `open val arrayDimension: Int`<br>Array dimension, 0 if this type is not an array. |
| [codeType](../-generic-type/code-type.md) | `open val ~~codeType~~: `[`CodeType`](../-code-type/index.md)<br>Resolved code type. |
| [identification](../-generic-type/identification.md) | `open val identification: String`<br>Unique string identification, this property may be used for equality comparison, normal types,
array types and generic types have different identifications, if a generic type represent a single
[CodeType](../-code-type/index.md) without any bound, then the identification will be the same as the single [CodeType](../-code-type/index.md). |
| [isWildcard](../-generic-type/is-wildcard.md) | `open val isWildcard: Boolean`<br>True if this is a wildcard generic type. |

### Functions

| Name | Summary |
|---|---|
| [compareTo](compare-to.md) | `fun compareTo(other: `[`CodeType`](../-code-type/index.md)`): Int`<br>Compare two identifications |
| [equals](equals.md) | `fun equals(other: Any?): Boolean` |
| [extends$](extends$.md) | `fun extends$(s: String): Generic`<br>Generic type that extends type variable `s`.`fun extends$(vararg ss: String): Generic`<br>Generic type that extends type variables `ss`.`fun extends$(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Generic`<br>Generic type that extends type `type`.`fun extends$(vararg types: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Generic`<br>Generic type that extends types `types`. |
| [hashCode](hash-code.md) | `fun hashCode(): Int` |
| [of](of.md) | `fun of(bound: `[`Bound`](../-generic-type/-bound/index.md)`): Generic`<br>Add a bound.`fun of(vararg bounds: `[`Bound`](../-generic-type/-bound/index.md)`): Generic`<br>Add all [bounds](of.md#com.github.jonathanxd.codeapi.type.Generic$of(kotlin.Array((com.github.jonathanxd.codeapi.type.GenericType.Bound)))/bounds).`fun of(s: String): Generic`<br>Add a name bound.`fun of(vararg ss: String): Generic`<br>Add name bounds.`fun of(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Generic`<br>Add a type bound.`fun of(vararg types: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Generic`<br>Add type bounds. |
| [super$](super$.md) | `fun super$(s: String): Generic`<br>Generic type that have a super type variable `s`.`fun super$(vararg ss: String): Generic`<br>Generic type that have a super type variables `ss`.`fun super$(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Generic`<br>Generic type that have a super type `type`.`fun super$(vararg types: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Generic`<br>Generic type that have a super types `types`. |
| [toArray](to-array.md) | `fun toArray(dimensions: Int): `[`GenericType`](../-generic-type/index.md)<br>Convert this [CodeType](../-code-type/index.md) to a [CodeTypeArray](#). |
| [toString](to-string.md) | `fun toString(): String` |

### Inherited Functions

| Name | Summary |
|---|---|
| [builder](../-generic-type/builder.md) | `open fun builder(): `[`Builder`](../-generic-type/-builder/index.md)`<`[`GenericType`](../-generic-type/index.md)`, *>`<br>This builder may or may not accept null values, it depends on implementation. |
| [is](../-generic-type/is.md) | `open fun is(other: `[`CodeType`](../-code-type/index.md)`?): Boolean`<br>Returns true if this [CodeType](../-code-type/index.md) is equals to other [CodeType](../-code-type/index.md). |

### Companion Object Functions

| Name | Summary |
|---|---|
| [type](type.md) | `fun type(s: String): Generic`<br>Create a generic type from a name (ex: T, E, R).`fun type(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Generic`<br>Create a generic type from a type. |
| [wildcard](wildcard.md) | `fun wildcard(): Generic`<br>Create a generic wildcard (? in Java Language, * in JVM). |

### Extension Properties

| Name | Summary |
|---|---|
| [arrayBaseComponent](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/array-base-component.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.arrayBaseComponent: `[`CodeType`](../-code-type/index.md)<br>See [CodeType.arrayBaseComponent](../-code-type/array-base-component.md) |
| [arrayComponent](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/array-component.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.arrayComponent: `[`CodeType`](../-code-type/index.md)<br>See [CodeType.arrayComponent](../-code-type/array-component.md) |
| [arrayDimension](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/array-dimension.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.arrayDimension: Int`<br>See [CodeType.arrayDimension](../-code-type/array-dimension.md) |
| [asGeneric](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/as-generic.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.asGeneric: `[`GenericType`](../-generic-type/index.md) |
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
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [compareTo](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/compare-to.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.compareTo(other: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Int`<br>See [CodeType.compareTo](../-code-type/compare-to.md) |
| [createCodeTypeDescriptor](../../com.github.jonathanxd.codeapi.util/create-code-type-descriptor.md) | `fun `[`CodeType`](../-code-type/index.md)`.createCodeTypeDescriptor(): String`<br>Creates [CodeType](../-code-type/index.md) type descriptor |
| [genericTypeToDescriptor](../../com.github.jonathanxd.codeapi.util/generic-type-to-descriptor.md) | `fun `[`GenericType`](../-generic-type/index.md)`.genericTypeToDescriptor(): String`<br>Create a type descriptor from receiver type. |
| [getType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/get-type.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.getType(isParameterized: Boolean = false): `[`CodeType`](../-code-type/index.md)<br>Gets the [CodeType](../-code-type/index.md) from a [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html). This method only works for Java Reflection Types and [CodeType](../-code-type/index.md). |
| [getTypeDesc](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/get-type-desc.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.getTypeDesc(typeStr: String = this.codeType.type): String`<br>Convert `this` [name](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/get-type-desc.md#com.github.jonathanxd.codeapi.util$getTypeDesc(java.lang.reflect.Type, kotlin.String)/typeStr) to type description. |
| [inferType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/infer-type.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.inferType(variables: Array<out `[`TypeVariable`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/TypeVariable.html)`<*>>, classVariables: Array<out `[`TypeVariable`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/TypeVariable.html)`<*>>, generic: Generic): `[`CodeType`](../-code-type/index.md)<br>Infers code type. |
| [invokeConstructor](../../com.github.jonathanxd.codeapi.factory/java.lang.reflect.-type/invoke-constructor.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.invokeConstructor(): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>`fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.invokeConstructor(spec: `[`TypeSpec`](../../com.github.jonathanxd.codeapi.base/-type-spec/index.md)`, arguments: List<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Invokes constructor of [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) |
| [invokeStatic](../../com.github.jonathanxd.codeapi.factory/java.lang.reflect.-type/invoke-static.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.invokeStatic(name: String, spec: `[`TypeSpec`](../../com.github.jonathanxd.codeapi.base/-type-spec/index.md)`, arguments: List<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>`fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.invokeStatic(name: String): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Invokes static method [name](../../com.github.jonathanxd.codeapi.factory/java.lang.reflect.-type/invoke-static.md#com.github.jonathanxd.codeapi.factory$invokeStatic(java.lang.reflect.Type, kotlin.String, com.github.jonathanxd.codeapi.base.TypeSpec, kotlin.collections.List((com.github.jonathanxd.codeapi.CodeInstruction)))/name) of [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) |
| [is](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.is(another: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?): Boolean`<br>See [CodeType.is](../-code-type/index.md) |
| [isAssignableFrom](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is-assignable-from.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.isAssignableFrom(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Boolean`<br>`fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.isAssignableFrom(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, resolverProvider: (`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`) -> `[`CodeTypeResolver`](../-code-type-resolver/index.md)`<*>): Boolean`<br>See [CodeType.isAssignableFrom](../-code-type/is-assignable-from.md) |
| [isConcreteIdEq](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is-concrete-id-eq.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.isConcreteIdEq(another: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Boolean`<br>See [CodeType.isConcreteIdEq](../-code-type/is-concrete-id-eq.md) |
| [isNonReifiedType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is-non-reified-type.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.isNonReifiedType(): <ERROR CLASS>` |
| [toArray](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/to-array.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.toArray(dimensions: Int): `[`CodeType`](../-code-type/index.md)<br>See [CodeType.toArray](../-code-type/to-array.md) |
| [toComponentString](../../com.github.jonathanxd.codeapi.util/to-component-string.md) | `fun `[`GenericType`](../-generic-type/index.md)`.toComponentString(): String`<br>Creates string representation of components of [GenericType](../-generic-type/index.md). |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
| [toSourceString](../../com.github.jonathanxd.codeapi.util/to-source-string.md) | `fun `[`GenericType`](../-generic-type/index.md)`.toSourceString(): String`<br>Convert generic type to string. |
