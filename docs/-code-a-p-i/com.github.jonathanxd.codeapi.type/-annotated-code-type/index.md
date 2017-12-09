[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.type](../index.md) / [AnnotatedCodeType](.)

# AnnotatedCodeType

`interface AnnotatedCodeType : `[`WrapperCodeType`](../-wrapper-code-type/index.md)

A [CodeType](../-code-type/index.md) with annotations, to be used where `TYPE_USE Annotations` are allowed, but there is no
limitation of where you can use.

This interface have various implementations, each implementation backing to variants of [CodeType](../-code-type/index.md). But not all,
there is no special implementation for `TypeDeclaration` for example, but only a generic implementation.

### Types

| Name | Summary |
|---|---|
| [Abstract](-abstract/index.md) | `abstract class Abstract<out T : `[`Abstract`](-abstract/index.md)`<T>> : AnnotatedCodeType, `[`CodeType`](../-code-type/index.md) |
| [Builder](-builder/index.md) | `interface Builder<out T : AnnotatedCodeType, S : `[`Builder`](-builder/index.md)`<T, S>> : `[`Builder`](../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<T, S>` |
| [GenericAnnotatedCodeType](-generic-annotated-code-type/index.md) | `class GenericAnnotatedCodeType : `[`Abstract`](-abstract/index.md)`<`[`GenericAnnotatedCodeType`](-generic-annotated-code-type/index.md)`>, `[`GenericType`](../-generic-type/index.md) |
| [SimpleAnnotatedCodeType](-simple-annotated-code-type/index.md) | `class SimpleAnnotatedCodeType : `[`Abstract`](-abstract/index.md)`<`[`SimpleAnnotatedCodeType`](-simple-annotated-code-type/index.md)`>` |
| [SimpleAnnotatedLoadedCodeType](-simple-annotated-loaded-code-type/index.md) | `class SimpleAnnotatedLoadedCodeType<T> : `[`Abstract`](-abstract/index.md)`<`[`SimpleAnnotatedLoadedCodeType`](-simple-annotated-loaded-code-type/index.md)`<T>>, `[`LoadedCodeType`](../-loaded-code-type/index.md)`<T>` |
| [SimpleAnnotatedUnknownCodeType](-simple-annotated-unknown-code-type/index.md) | `class SimpleAnnotatedUnknownCodeType : `[`Abstract`](-abstract/index.md)`<`[`SimpleAnnotatedUnknownCodeType`](-simple-annotated-unknown-code-type/index.md)`>, `[`UnknownCodeType`](../-unknown-code-type.md) |
| [SimpleAnnotatedWrapperCodeType](-simple-annotated-wrapper-code-type/index.md) | `class SimpleAnnotatedWrapperCodeType : `[`Abstract`](-abstract/index.md)`<`[`SimpleAnnotatedCodeType`](-simple-annotated-code-type/index.md)`>` |

### Properties

| Name | Summary |
|---|---|
| [annotatedType](annotated-type.md) | `abstract val annotatedType: Type`<br>The type that is annotated with [annotations](annotations.md). (May be `this`). |
| [annotations](annotations.md) | `abstract val annotations: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Annotation`](../../com.github.jonathanxd.codeapi.base/-annotation/index.md)`>`<br>Annotations of the type. |
| [wrapped](wrapped.md) | `open val wrapped: `[`CodeType`](../-code-type/index.md)<br>Wrapped code type. |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `abstract fun builder(): `[`Builder`](-builder/index.md)`<AnnotatedCodeType, *>`<br>This builder may or may not accept null values, it depends on implementation. |

### Companion Object Functions

| Name | Summary |
|---|---|
| [annotatedType](annotated-type.md) | `fun annotatedType(type: Type, annotations: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Annotation`](../../com.github.jonathanxd.codeapi.base/-annotation/index.md)`>): AnnotatedCodeType` |
| [builder](builder.md) | `fun builder(type: Type): `[`Builder`](-builder/index.md)`<AnnotatedCodeType, *>` |

### Extension Properties

| Name | Summary |
|---|---|
| [arrayBaseComponent](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/array-base-component.md) | `val Type.arrayBaseComponent: `[`CodeType`](../-code-type/index.md)<br>See [CodeType.arrayBaseComponent](../-code-type/array-base-component.md) |
| [arrayComponent](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/array-component.md) | `val Type.arrayComponent: `[`CodeType`](../-code-type/index.md)<br>See [CodeType.arrayComponent](../-code-type/array-component.md) |
| [arrayDimension](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/array-dimension.md) | `val Type.arrayDimension: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>See [CodeType.arrayDimension](../-code-type/array-dimension.md) |
| [asGeneric](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/as-generic.md) | `val Type.asGeneric: `[`GenericType`](../-generic-type/index.md) |
| [binaryName](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/binary-name.md) | `val Type.binaryName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Returns binary name of [Type](#). See [CodeType.binaryName](../-code-type/binary-name.md) |
| [canonicalName](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/canonical-name.md) | `val Type.canonicalName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>See [CodeType.canonicalName](../-code-type/canonical-name.md) |
| [codeType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/code-type.md) | `val Type.codeType: `[`CodeType`](../-code-type/index.md) |
| [defaultResolver](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/default-resolver.md) | `val Type.defaultResolver: `[`CodeTypeResolver`](../-code-type-resolver/index.md)`<*>`<br>See [CodeType.defaultResolver](../-code-type/default-resolver.md) |
| [descName](../../com.github.jonathanxd.codeapi.util/desc-name.md) | `val `[`CodeType`](../-code-type/index.md)`.descName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [descriptor](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/descriptor.md) | `val Type.descriptor: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Converts `this` type to type descriptor. |
| [identification](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/identification.md) | `val Type.identification: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>See [CodeType.identification](../-code-type/identification.md) |
| [interfaces](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/interfaces.md) | `val Type.interfaces: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<Type>`<br>See [CodeType.interfaces](../-code-type/interfaces.md) |
| [internalName](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/internal-name.md) | `val Type.internalName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Returns internal name of [Type](#). See [CodeType.binaryName](../-code-type/binary-name.md) |
| [isArray](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is-array.md) | `val Type.isArray: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>See [CodeType.isArray](../-code-type/is-array.md) |
| [isInterface](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is-interface.md) | `val Type.isInterface: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>See [CodeType.isInterface](../-code-type/is-interface.md) |
| [isVirtual](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is-virtual.md) | `val Type.isVirtual: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>See [CodeType.isVirtual](../-code-type/is-virtual.md) |
| [javaSpecName](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/java-spec-name.md) | `val Type.javaSpecName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Returns java spec name of [Type](#). See [CodeType.javaSpecName](../-code-type/java-spec-name.md) |
| [packageName](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/package-name.md) | `val Type.packageName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>See [CodeType.packageName](../-code-type/package-name.md) |
| [primitiveType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/primitive-type.md) | `val Type.primitiveType: `[`CodeType`](../-code-type/index.md)`?`<br>See [CodeType.primitiveType](../-code-type/primitive-type.md) |
| [simpleName](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/simple-name.md) | `val Type.simpleName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>See [CodeType.simpleName](../-code-type/simple-name.md) |
| [superType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/super-type.md) | `val Type.superType: Type?`<br>See [CodeType.superType](../-code-type/super-type.md) |
| [typeDesc](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/type-desc.md) | `val Type.typeDesc: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [typeOrNull](../../com.github.jonathanxd.codeapi.util/type-or-null.md) | `val `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.typeOrNull: Type?`<br>Gets the type of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or null if receiver is not a [Typed](../../com.github.jonathanxd.codeapi.base/-typed/index.md) instance. |
| [wrapperType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/wrapper-type.md) | `val Type.wrapperType: `[`CodeType`](../-code-type/index.md)`?`<br>See [CodeType.wrapperType](../-code-type/wrapper-type.md) |

### Extension Functions

| Name | Summary |
|---|---|
| [annotationValue](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/annotation-value.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.annotationValue(rType: Class<*>): `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) |
| [applyType](../../com.github.jonathanxd.codeapi.util/apply-type.md) | `fun `[`CodeType`](../-code-type/index.md)`.applyType(typeName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, type: `[`CodeType`](../-code-type/index.md)`): `[`CodeType`](../-code-type/index.md) |
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?.asString(simple: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [compareTo](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/compare-to.md) | `fun Type.compareTo(other: Type): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>See [CodeType.compareTo](../-code-type/compare-to.md) |
| [createCodeTypeDescriptor](../../com.github.jonathanxd.codeapi.util/create-code-type-descriptor.md) | `fun `[`CodeType`](../-code-type/index.md)`.createCodeTypeDescriptor(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Creates [CodeType](../-code-type/index.md) type descriptor |
| [getType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/get-type.md) | `fun Type.getType(isParameterized: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false): `[`CodeType`](../-code-type/index.md)<br>Gets the [CodeType](../-code-type/index.md) from a [Type](#). This method only works for Java Reflection Types and [CodeType](../-code-type/index.md). |
| [getType](../../com.github.jonathanxd.codeapi.util/get-type.md) | `fun `[`CodeType`](../-code-type/index.md)`.getType(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`CodeType`](../-code-type/index.md)`?`<br>`fun `[`CodeType`](../-code-type/index.md)`.getType(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, inside: `[`CodeType`](../-code-type/index.md)`): `[`CodeType`](../-code-type/index.md)`?` |
| [getTypeDesc](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/get-type-desc.md) | `fun Type.getTypeDesc(typeStr: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = this.codeType.type): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Convert `this` [name](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/get-type-desc.md#com.github.jonathanxd.codeapi.util$getTypeDesc(java.lang.reflect.Type, kotlin.String)/typeStr) to type description. |
| [inferType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/infer-type.md) | `fun Type.inferType(variables: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<out TypeVariable<*>>, classVariables: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<out TypeVariable<*>>, generic: `[`Generic`](../-generic/index.md)`): `[`CodeType`](../-code-type/index.md)<br>Infers code type. |
| [invokeConstructor](../../com.github.jonathanxd.codeapi.factory/java.lang.reflect.-type/invoke-constructor.md) | `fun Type.invokeConstructor(): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>`fun Type.invokeConstructor(spec: `[`TypeSpec`](../../com.github.jonathanxd.codeapi.base/-type-spec/index.md)`, arguments: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Invokes constructor of [Type](#) |
| [invokeStatic](../../com.github.jonathanxd.codeapi.factory/java.lang.reflect.-type/invoke-static.md) | `fun Type.invokeStatic(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, spec: `[`TypeSpec`](../../com.github.jonathanxd.codeapi.base/-type-spec/index.md)`, arguments: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CodeInstruction`](../../com.github.jonathanxd.codeapi/-code-instruction.md)`>): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>`fun Type.invokeStatic(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`MethodInvocation`](../../com.github.jonathanxd.codeapi.base/-method-invocation/index.md)<br>Invokes static method [name](../../com.github.jonathanxd.codeapi.factory/java.lang.reflect.-type/invoke-static.md#com.github.jonathanxd.codeapi.factory$invokeStatic(java.lang.reflect.Type, kotlin.String, com.github.jonathanxd.codeapi.base.TypeSpec, kotlin.collections.List((com.github.jonathanxd.codeapi.CodeInstruction)))/name) of [Type](#) |
| [is](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is.md) | `fun Type.is(another: Type?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>See [CodeType.is](../-code-type/index.md) |
| [isAssignableFrom](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is-assignable-from.md) | `fun Type.isAssignableFrom(type: Type): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>`fun Type.isAssignableFrom(type: Type, resolverProvider: (Type) -> `[`CodeTypeResolver`](../-code-type-resolver/index.md)`<*>): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>See [CodeType.isAssignableFrom](../-code-type/is-assignable-from.md) |
| [isConcreteIdEq](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is-concrete-id-eq.md) | `fun Type.isConcreteIdEq(another: Type): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>See [CodeType.isConcreteIdEq](../-code-type/is-concrete-id-eq.md) |
| [isNonReifiedType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is-non-reified-type.md) | `fun Type.isNonReifiedType(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [nonStrictEq](../../com.github.jonathanxd.codeapi.util/non-strict-eq.md) | `fun `[`CodeType`](../-code-type/index.md)`.nonStrictEq(other: `[`CodeType`](../-code-type/index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Non-strict generic equality check, only works for generic types. |
| [toArray](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/to-array.md) | `fun Type.toArray(dimensions: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`CodeType`](../-code-type/index.md)<br>See [CodeType.toArray](../-code-type/to-array.md) |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)<br>Convert this value to a literal |
| [toLiteralOrNull](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal-or-null.md) | `fun `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`.toLiteralOrNull(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
| [toStr](../../com.github.jonathanxd.codeapi.util/to-str.md) | `fun `[`CodeType`](../-code-type/index.md)`.toStr(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Default to string conversion for [CodeType](../-code-type/index.md). |

### Inheritors

| Name | Summary |
|---|---|
| [Abstract](-abstract/index.md) | `abstract class Abstract<out T : `[`Abstract`](-abstract/index.md)`<T>> : AnnotatedCodeType, `[`CodeType`](../-code-type/index.md) |
