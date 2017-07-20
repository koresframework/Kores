[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [AnonymousClass](.)

# AnonymousClass

`data class AnonymousClass : `[`TypeDeclaration`](../-type-declaration/index.md)`, `[`SuperClassHolder`](../-super-class-holder/index.md)`, `[`ArgumentsHolder`](../-arguments-holder/index.md)`, `[`ImplementationHolder`](../-implementation-holder/index.md)

Anonymous class, in Bytecode, anonymous class can have implementations,
in other languages it depends on specification. (Official Java generator may comment implementations).

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `class Builder : `[`Builder`](../-type-declaration/-builder/index.md)`<AnonymousClass, `[`Builder`](-builder/index.md)`>, `[`Builder`](../-super-class-holder/-builder/index.md)`<AnonymousClass, `[`Builder`](-builder/index.md)`>, `[`Builder`](../-arguments-holder/-builder/index.md)`<AnonymousClass, `[`Builder`](-builder/index.md)`>, `[`Builder`](../-implementation-holder/-builder/index.md)`<AnonymousClass, `[`Builder`](-builder/index.md)`>` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `AnonymousClass(comments: `[`Comments`](../../com.github.jonathanxd.codeapi.base.comment/-comments/index.md)`, outerClass: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?, annotations: List<`[`Annotation`](../-annotation/index.md)`>, specifiedName: String, superClass: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, implementations: List<`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`>, constructorSpec: `[`TypeSpec`](../-type-spec/index.md)`, arguments: List<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>, constructorBody: `[`CodeSource`](../../com.github.jonathanxd.codeapi/-code-source/index.md)`, staticBlock: `[`StaticBlock`](../-static-block/index.md)`, fields: List<`[`FieldDeclaration`](../-field-declaration/index.md)`>, constructors: List<`[`ConstructorDeclaration`](../-constructor-declaration/index.md)`>, methods: List<`[`MethodDeclaration`](../-method-declaration/index.md)`>, innerTypes: List<`[`TypeDeclaration`](../-type-declaration/index.md)`>)`<br>Anonymous class, in Bytecode, anonymous class can have implementations,
in other languages it depends on specification. (Official Java generator may comment implementations). |

### Properties

| Name | Summary |
|---|---|
| [annotations](annotations.md) | `val annotations: List<`[`Annotation`](../-annotation/index.md)`>`<br>Annotations |
| [arguments](arguments.md) | `val arguments: List<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>`<br>Argument list |
| [array](array.md) | `val array: Boolean`<br>Array arguments |
| [comments](comments.md) | `val comments: `[`Comments`](../../com.github.jonathanxd.codeapi.base.comment/-comments/index.md)<br>All comments inside this holder. |
| [constructorBody](constructor-body.md) | `val constructorBody: `[`CodeSource`](../../com.github.jonathanxd.codeapi/-code-source/index.md) |
| [constructorSpec](constructor-spec.md) | `val constructorSpec: `[`TypeSpec`](../-type-spec/index.md) |
| [constructors](constructors.md) | `val constructors: List<`[`ConstructorDeclaration`](../-constructor-declaration/index.md)`>`<br>Constructor declaration |
| [fields](fields.md) | `val fields: List<`[`FieldDeclaration`](../-field-declaration/index.md)`>`<br>Fields of the type. |
| [genericSignature](generic-signature.md) | `val genericSignature: `[`GenericSignature`](../../com.github.jonathanxd.codeapi.generic/-generic-signature/index.md)<br>Generic signature. |
| [implementations](implementations.md) | `val implementations: List<`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`>`<br>Implementations |
| [innerTypes](inner-types.md) | `val innerTypes: List<`[`TypeDeclaration`](../-type-declaration/index.md)`>`<br>Static inner types. CodeAPI 4 only supports static types, inner logic should be
manually implemented. |
| [methods](methods.md) | `val methods: List<`[`MethodDeclaration`](../-method-declaration/index.md)`>`<br>Methods of type |
| [modifiers](modifiers.md) | `val modifiers: Set<`[`CodeModifier`](../-code-modifier/index.md)`>`<br>Modifiers. Empty modifier set is the same as public. For package private, an explicit
[CodeModifier.PACKAGE_PRIVATE](../-code-modifier/-p-a-c-k-a-g-e_-p-r-i-v-a-t-e.md) is required. |
| [outerClass](outer-class.md) | `val outerClass: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Outer class (null if this type is not a inner class). |
| [qualifiedName](qualified-name.md) | `val qualifiedName: String`<br>Defined qualified name |
| [specifiedName](specified-name.md) | `val specifiedName: String`<br>The specified name (for inner classes this property is set to simple name of inner class) |
| [staticBlock](static-block.md) | `val staticBlock: `[`StaticBlock`](../-static-block/index.md)<br>Static block |
| [superClass](super-class.md) | `val superClass: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Super type |
| [type](type.md) | `val type: String`<br>Type name, examples: |
| [types](types.md) | `val types: List<`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`>`<br>Expected types of each argument |

### Inherited Properties

| Name | Summary |
|---|---|
| [canonicalName](../-type-declaration/canonical-name.md) | `open val canonicalName: String`<br>Canonical name |
| [defaultResolver](../-type-declaration/default-resolver.md) | `open val defaultResolver: `[`CodeTypeResolver`](../../com.github.jonathanxd.codeapi.type/-code-type-resolver/index.md)`<*>`<br>Default resolver. |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): `[`Builder`](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |
| [equals](equals.md) | `fun equals(other: Any?): Boolean` |
| [hashCode](hash-code.md) | `fun hashCode(): Int` |

### Extension Properties

| Name | Summary |
|---|---|
| [arrayBaseComponent](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/array-base-component.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.arrayBaseComponent: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)<br>See [CodeType.arrayBaseComponent](../../com.github.jonathanxd.codeapi.type/-code-type/array-base-component.md) |
| [arrayComponent](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/array-component.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.arrayComponent: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)<br>See [CodeType.arrayComponent](../../com.github.jonathanxd.codeapi.type/-code-type/array-component.md) |
| [arrayDimension](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/array-dimension.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.arrayDimension: Int`<br>See [CodeType.arrayDimension](../../com.github.jonathanxd.codeapi.type/-code-type/array-dimension.md) |
| [asGeneric](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/as-generic.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.asGeneric: `[`GenericType`](../../com.github.jonathanxd.codeapi.type/-generic-type/index.md) |
| [binaryName](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/binary-name.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.binaryName: String`<br>Returns binary name of [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html). See [CodeType.binaryName](../../com.github.jonathanxd.codeapi.type/-code-type/binary-name.md) |
| [canonicalName](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/canonical-name.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.canonicalName: String`<br>See [CodeType.canonicalName](../../com.github.jonathanxd.codeapi.type/-code-type/canonical-name.md) |
| [codeType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/code-type.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.codeType: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md) |
| [defaultResolver](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/default-resolver.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.defaultResolver: `[`CodeTypeResolver`](../../com.github.jonathanxd.codeapi.type/-code-type-resolver/index.md)`<*>`<br>See [CodeType.defaultResolver](../../com.github.jonathanxd.codeapi.type/-code-type/default-resolver.md) |
| [descName](../../com.github.jonathanxd.codeapi.util/desc-name.md) | `val `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`.descName: String` |
| [descriptor](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/descriptor.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.descriptor: String`<br>Converts `this` type to type descriptor. |
| [identification](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/identification.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.identification: String`<br>See [CodeType.identification](../../com.github.jonathanxd.codeapi.type/-code-type/identification.md) |
| [interfaces](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/interfaces.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.interfaces: List<`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`>`<br>See [CodeType.interfaces](../../com.github.jonathanxd.codeapi.type/-code-type/interfaces.md) |
| [internalName](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/internal-name.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.internalName: String`<br>Returns internal name of [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html). See [CodeType.binaryName](../../com.github.jonathanxd.codeapi.type/-code-type/binary-name.md) |
| [isArray](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is-array.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.isArray: Boolean`<br>See [CodeType.isArray](../../com.github.jonathanxd.codeapi.type/-code-type/is-array.md) |
| [isInterface](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is-interface.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.isInterface: Boolean`<br>See [CodeType.isInterface](../../com.github.jonathanxd.codeapi.type/-code-type/is-interface.md) |
| [isVirtual](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is-virtual.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.isVirtual: Boolean`<br>See [CodeType.isVirtual](../../com.github.jonathanxd.codeapi.type/-code-type/is-virtual.md) |
| [javaSpecName](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/java-spec-name.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.javaSpecName: String`<br>Returns java spec name of [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html). See [CodeType.javaSpecName](../../com.github.jonathanxd.codeapi.type/-code-type/java-spec-name.md) |
| [packageName](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/package-name.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.packageName: String`<br>See [CodeType.packageName](../../com.github.jonathanxd.codeapi.type/-code-type/package-name.md) |
| [primitiveType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/primitive-type.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.primitiveType: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`?`<br>See [CodeType.primitiveType](../../com.github.jonathanxd.codeapi.type/-code-type/primitive-type.md) |
| [simpleName](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/simple-name.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.simpleName: String`<br>See [CodeType.simpleName](../../com.github.jonathanxd.codeapi.type/-code-type/simple-name.md) |
| [superType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/super-type.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.superType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>See [CodeType.superType](../../com.github.jonathanxd.codeapi.type/-code-type/super-type.md) |
| [typeDesc](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/type-desc.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.typeDesc: String` |
| [typeOrNull](../../com.github.jonathanxd.codeapi.util/type-or-null.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.typeOrNull: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Gets the type of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or null if receiver is not a [Typed](../-typed/index.md) instance. |
| [wrapperType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/wrapper-type.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.wrapperType: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`?`<br>See [CodeType.wrapperType](../../com.github.jonathanxd.codeapi.type/-code-type/wrapper-type.md) |

### Extension Functions

| Name | Summary |
|---|---|
| [applyType](../../com.github.jonathanxd.codeapi.util/apply-type.md) | `fun `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`.applyType(typeName: String, type: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`): `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md) |
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [compareTo](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/compare-to.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.compareTo(other: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Int`<br>See [CodeType.compareTo](../../com.github.jonathanxd.codeapi.type/-code-type/compare-to.md) |
| [createCodeTypeDescriptor](../../com.github.jonathanxd.codeapi.util/create-code-type-descriptor.md) | `fun `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`.createCodeTypeDescriptor(): String`<br>Creates [CodeType](../../com.github.jonathanxd.codeapi.type/-code-type/index.md) type descriptor |
| [getType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/get-type.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.getType(isParameterized: Boolean = false): `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)<br>Gets the [CodeType](../../com.github.jonathanxd.codeapi.type/-code-type/index.md) from a [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html). This method only works for Java Reflection Types and [CodeType](../../com.github.jonathanxd.codeapi.type/-code-type/index.md). |
| [getType](../../com.github.jonathanxd.codeapi.util/get-type.md) | `fun `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`.getType(name: String): `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`?`<br>`fun `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`.getType(name: String, inside: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`): `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`?` |
| [getTypeDesc](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/get-type-desc.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.getTypeDesc(typeStr: String = this.codeType.type): String`<br>Convert `this` [name](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/get-type-desc.md#com.github.jonathanxd.codeapi.util$getTypeDesc(java.lang.reflect.Type, kotlin.String)/typeStr) to type description. |
| [inferType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/infer-type.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.inferType(variables: Array<out `[`TypeVariable`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/TypeVariable.html)`<*>>, classVariables: Array<out `[`TypeVariable`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/TypeVariable.html)`<*>>, generic: `[`Generic`](../../com.github.jonathanxd.codeapi.type/-generic/index.md)`): `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)<br>Infers code type. |
| [invokeConstructor](../../com.github.jonathanxd.codeapi.factory/java.lang.reflect.-type/invoke-constructor.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.invokeConstructor(): `[`MethodInvocation`](../-method-invocation/index.md)<br>`fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.invokeConstructor(spec: `[`TypeSpec`](../-type-spec/index.md)`, arguments: List<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): `[`MethodInvocation`](../-method-invocation/index.md)<br>Invokes constructor of [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) |
| [invokeStatic](../../com.github.jonathanxd.codeapi.factory/java.lang.reflect.-type/invoke-static.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.invokeStatic(name: String, spec: `[`TypeSpec`](../-type-spec/index.md)`, arguments: List<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): `[`MethodInvocation`](../-method-invocation/index.md)<br>`fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.invokeStatic(name: String): `[`MethodInvocation`](../-method-invocation/index.md)<br>Invokes static method [name](../../com.github.jonathanxd.codeapi.factory/java.lang.reflect.-type/invoke-static.md#com.github.jonathanxd.codeapi.factory$invokeStatic(java.lang.reflect.Type, kotlin.String, com.github.jonathanxd.codeapi.base.TypeSpec, kotlin.collections.List((com.github.jonathanxd.codeapi.CodeInstruction)))/name) of [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) |
| [is](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.is(another: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?): Boolean`<br>See [CodeType.is](../../com.github.jonathanxd.codeapi.type/-code-type/index.md) |
| [isAssignableFrom](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is-assignable-from.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.isAssignableFrom(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Boolean`<br>`fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.isAssignableFrom(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, resolverProvider: (`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`) -> `[`CodeTypeResolver`](../../com.github.jonathanxd.codeapi.type/-code-type-resolver/index.md)`<*>): Boolean`<br>See [CodeType.isAssignableFrom](../../com.github.jonathanxd.codeapi.type/-code-type/is-assignable-from.md) |
| [isConcreteIdEq](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is-concrete-id-eq.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.isConcreteIdEq(another: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Boolean`<br>See [CodeType.isConcreteIdEq](../../com.github.jonathanxd.codeapi.type/-code-type/is-concrete-id-eq.md) |
| [isNonReifiedType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is-non-reified-type.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.isNonReifiedType(): <ERROR CLASS>` |
| [nonStrictEq](../../com.github.jonathanxd.codeapi.util/non-strict-eq.md) | `fun `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`.nonStrictEq(other: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`): Boolean`<br>Non-strict generic equality check, only works for generic types. |
| [toArray](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/to-array.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.toArray(dimensions: Int): `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)<br>See [CodeType.toArray](../../com.github.jonathanxd.codeapi.type/-code-type/to-array.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
| [toStr](../../com.github.jonathanxd.codeapi.util/to-str.md) | `fun `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`.toStr(): String`<br>Default to string conversion for [CodeType](../../com.github.jonathanxd.codeapi.type/-code-type/index.md). |
