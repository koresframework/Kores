[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [TypeDeclaration](.)

# TypeDeclaration

`interface TypeDeclaration : `[`ModifiersHolder`](../-modifiers-holder/index.md)`, `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`, `[`QualifiedNamed`](../-qualified-named/index.md)`, `[`GenericSignatureHolder`](../-generic-signature-holder/index.md)`, `[`Annotable`](../-annotable/index.md)`, `[`CommentHolder`](../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/index.md)`, `[`InnerTypesHolder`](../-inner-types-holder/index.md)`, `[`ElementsHolder`](../-elements-holder/index.md)

Base class of all TypeDeclarations like classes, interfaces and enums, and inner classes.

The [qualifiedName](qualified-name.md) MUST return a qualifiedName even for the inner classes, the [qualifiedName](qualified-name.md) of
inner classes must be: '[outerClass qualifiedName](qualified-name.md) + simpleInnerName'.

For inner types, you should implement inner logic yourself, it is not hard, inner types are only
classes with constructors which receives outer type as parameter and fields which stores outer instance, example:

```
class A {
  class B(private val outer: A) {
    fun doSomething() {
      outer.doSomething()
    }
  }
  fun doSomething() {
  }
}
```

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `interface Builder<out T : TypeDeclaration, S : `[`Builder`](-builder/index.md)`<T, S>> : `[`Builder`](../-modifiers-holder/-builder/index.md)`<T, S>, `[`Builder`](../-qualified-named/-builder/index.md)`<T, S>, `[`Builder`](../-generic-signature-holder/-builder/index.md)`<T, S>, `[`Builder`](../-annotable/-builder/index.md)`<T, S>, `[`Builder`](../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/-builder/index.md)`<T, S>, `[`Builder`](../-inner-types-holder/-builder/index.md)`<T, S>, `[`Builder`](../-elements-holder/-builder/index.md)`<T, S>` |

### Properties

| Name | Summary |
|---|---|
| [canonicalName](canonical-name.md) | `open val canonicalName: String`<br>Canonical name |
| [innerTypes](inner-types.md) | `abstract val innerTypes: List<TypeDeclaration>`<br>Static inner types. CodeAPI 4 only supports static types, inner logic should be
manually implemented. |
| [outerClass](outer-class.md) | `abstract val outerClass: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Outer class (null if this type is not a inner class). |
| [qualifiedName](qualified-name.md) | `abstract val qualifiedName: String`<br>Defined qualified name |
| [specifiedName](specified-name.md) | `open val specifiedName: String`<br>The specified name (for inner classes this property is set to simple name of inner class) |
| [type](type.md) | `open val type: String`<br>Type name, examples: |

### Inherited Properties

| Name | Summary |
|---|---|
| [annotations](../-annotable/annotations.md) | `abstract val annotations: List<`[`Annotation`](../-annotation/index.md)`>`<br>Annotations |
| [arrayBaseComponent](../../com.github.jonathanxd.codeapi.type/-code-type/array-base-component.md) | `open val arrayBaseComponent: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)<br>Array base component. |
| [arrayComponent](../../com.github.jonathanxd.codeapi.type/-code-type/array-component.md) | `open val arrayComponent: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)<br>Array component. |
| [arrayDimension](../../com.github.jonathanxd.codeapi.type/-code-type/array-dimension.md) | `open val arrayDimension: Int`<br>Array dimension, 0 if this type is not an array. |
| [binaryName](../../com.github.jonathanxd.codeapi.type/-code-type/binary-name.md) | `open val binaryName: String`<br>Binary name of the class. |
| [comments](../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/comments.md) | `abstract val comments: `[`Comments`](../../com.github.jonathanxd.codeapi.base.comment/-comments/index.md)<br>All comments inside this holder. |
| [constructors](../-elements-holder/constructors.md) | `abstract val constructors: List<`[`ConstructorDeclaration`](../-constructor-declaration/index.md)`>`<br>Constructor declaration |
| [defaultResolver](../../com.github.jonathanxd.codeapi.type/-code-type/default-resolver.md) | `open val defaultResolver: `[`CodeTypeResolver`](../../com.github.jonathanxd.codeapi.type/-code-type-resolver/index.md)`<*>`<br>Default resolver. |
| [fields](../-elements-holder/fields.md) | `abstract val fields: List<`[`FieldDeclaration`](../-field-declaration/index.md)`>`<br>Fields of the type. |
| [genericSignature](../-generic-signature-holder/generic-signature.md) | `abstract val genericSignature: `[`GenericSignature`](../../com.github.jonathanxd.codeapi.generic/-generic-signature/index.md)<br>Generic signature. |
| [identification](../../com.github.jonathanxd.codeapi.type/-code-type/identification.md) | `open val identification: String`<br>Unique string identification, this property may be used for equality comparison, normal types,
array types and generic types have different identifications, if a generic type represent a single
[CodeType](../../com.github.jonathanxd.codeapi.type/-code-type/index.md) without any bound, then the identification will be the same as the single [CodeType](../../com.github.jonathanxd.codeapi.type/-code-type/index.md). |
| [isArray](../../com.github.jonathanxd.codeapi.type/-code-type/is-array.md) | `open val isArray: Boolean`<br>True if this [CodeType](../../com.github.jonathanxd.codeapi.type/-code-type/index.md) is an array type. |
| [isInterface](../../com.github.jonathanxd.codeapi.type/-code-type/is-interface.md) | `open val isInterface: Boolean`<br>True if this [CodeType](../../com.github.jonathanxd.codeapi.type/-code-type/index.md) is a interface type. |
| [isPrimitive](../../com.github.jonathanxd.codeapi.type/-code-type/is-primitive.md) | `open val isPrimitive: Boolean`<br>True if this [CodeType](../../com.github.jonathanxd.codeapi.type/-code-type/index.md) is a primitive type. |
| [isPublic](../-modifiers-holder/is-public.md) | `open val isPublic: Boolean`<br>Returns true if is public. |
| [isVirtual](../../com.github.jonathanxd.codeapi.type/-code-type/is-virtual.md) | `open val isVirtual: Boolean`<br>True if is a `Virtual Type` (Virtual Types = Types that were not loaded by JVM) |
| [javaSpecName](../../com.github.jonathanxd.codeapi.type/-code-type/java-spec-name.md) | `open val javaSpecName: String`<br>JVM Spec class name. |
| [methods](../-elements-holder/methods.md) | `abstract val methods: List<`[`MethodDeclaration`](../-method-declaration/index.md)`>`<br>Methods of type |
| [modifiers](../-modifiers-holder/modifiers.md) | `abstract val modifiers: Set<`[`CodeModifier`](../-code-modifier/index.md)`>`<br>Modifiers. Empty modifier set is the same as public. For package private, an explicit
[CodeModifier.PACKAGE_PRIVATE](../-code-modifier/-p-a-c-k-a-g-e_-p-r-i-v-a-t-e.md) is required. |
| [name](../-qualified-named/name.md) | `open val name: String`<br>Name |
| [packageName](../../com.github.jonathanxd.codeapi.type/-code-type/package-name.md) | `open val packageName: String`<br>Package name |
| [primitiveType](../../com.github.jonathanxd.codeapi.type/-code-type/primitive-type.md) | `open val primitiveType: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`?`<br>Primitive type. |
| [simpleName](../../com.github.jonathanxd.codeapi.type/-code-type/simple-name.md) | `open val simpleName: String`<br>Simple name. |
| [staticBlock](../-elements-holder/static-block.md) | `abstract val staticBlock: `[`StaticBlock`](../-static-block/index.md)<br>Static block |
| [wrapperType](../../com.github.jonathanxd.codeapi.type/-code-type/wrapper-type.md) | `open val wrapperType: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`?`<br>Wrapper type. |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `abstract fun builder(): `[`Builder`](-builder/index.md)`<TypeDeclaration, *>`<br>This builder may or may not accept null values, it depends on implementation. |

### Inherited Functions

| Name | Summary |
|---|---|
| [compareTo](../../com.github.jonathanxd.codeapi.type/-code-type/compare-to.md) | `open fun compareTo(other: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`): Int` |
| [getTypeName](../../com.github.jonathanxd.codeapi.type/-code-type/get-type-name.md) | `open fun getTypeName(): String` |
| [is](../../com.github.jonathanxd.codeapi.type/-code-type/is.md) | `open fun is(another: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`?): Boolean`<br>Returns true if this [CodeType](../../com.github.jonathanxd.codeapi.type/-code-type/index.md) is equals to another [CodeType](../../com.github.jonathanxd.codeapi.type/-code-type/index.md). |
| [toArray](../../com.github.jonathanxd.codeapi.type/-code-type/to-array.md) | `open fun toArray(dimensions: Int): `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)<br>Convert this [CodeType](../../com.github.jonathanxd.codeapi.type/-code-type/index.md) to a [CodeTypeArray](#). |

### Extension Properties

| Name | Summary |
|---|---|
| [codeType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/code-type.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.codeType: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md) |
| [concreteType](../../com.github.jonathanxd.codeapi.util/concrete-type.md) | `val `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`.concreteType: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)<br>Gets the concrete type of [CodeType](../../com.github.jonathanxd.codeapi.type/-code-type/index.md), if this is a [GenericType](../../com.github.jonathanxd.codeapi.type/-generic-type/index.md), the property getter will try to
infer the concrete type looping the [GenericType Inferred type](../../com.github.jonathanxd.codeapi.type/-generic-type/code-type.md). |
| [descName](../../com.github.jonathanxd.codeapi.util/desc-name.md) | `val `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`.descName: String` |

### Extension Functions

| Name | Summary |
|---|---|
| [applyType](../../com.github.jonathanxd.codeapi.util/apply-type.md) | `fun `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`.applyType(typeName: String, type: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`): `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md) |
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [eq](../../com.github.jonathanxd.codeapi.util/eq.md) | `fun `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`.eq(obj: Any?): Boolean`<br>Default equals method. |
| [extend](../../com.github.jonathanxd.codeapi.util.conversion/extend.md) | `fun <T : TypeDeclaration> T.extend(klass: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<*>): T`<br>Makes the declaration [T](#) extend the [Class](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html) overriding all public/protected methods
and invoking the super method. |
| [getPartType](../../com.github.jonathanxd.codeapi.util/get-part-type.md) | `fun `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.getPartType(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or throws [IllegalStateException](http://docs.oracle.com/javase/6/docs/api/java/lang/IllegalStateException.html) if [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is not instance of [Typed](../-typed/index.md) |
| [getPartTypeOrNull](../../com.github.jonathanxd.codeapi.util/get-part-type-or-null.md) | `fun `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.getPartTypeOrNull(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or `null` if [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is not instance of [Typed](../-typed/index.md). |
| [getType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/get-type.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.getType(isParameterized: Boolean = false): `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md) |
| [getType](../../com.github.jonathanxd.codeapi.util/get-type.md) | `fun `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`.getType(name: String): `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`?`<br>`fun `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`.getType(name: String, inside: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`): `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`?` |
| [hash](../../com.github.jonathanxd.codeapi.util/hash.md) | `fun `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`.hash(): Int`<br>Default hash algorithm. |
| [is](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.is(another: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Boolean` |
| [nonStrictEq](../../com.github.jonathanxd.codeapi.util/non-strict-eq.md) | `fun `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`.nonStrictEq(other: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`): Boolean`<br>Non-strict generic equality check, only works for generic types. |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
| [toStr](../../com.github.jonathanxd.codeapi.util/to-str.md) | `fun `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`.toStr(): String`<br>Default to string conversion for [CodeType](../../com.github.jonathanxd.codeapi.type/-code-type/index.md). |

### Inheritors

| Name | Summary |
|---|---|
| [AnnotationDeclaration](../-annotation-declaration/index.md) | `data class AnnotationDeclaration : TypeDeclaration`<br>Annotation declaration. |
| [AnonymousClass](../-anonymous-class/index.md) | `data class AnonymousClass : TypeDeclaration, `[`SuperClassHolder`](../-super-class-holder/index.md)`, `[`ArgumentHolder`](../-argument-holder/index.md)`, `[`ImplementationHolder`](../-implementation-holder/index.md)<br>Anonymous class, in Bytecode, anonymous class can have implementations,
in other languages it depends on specification. (Official Java generator may comment implementations). |
| [ClassDeclaration](../-class-declaration/index.md) | `data class ClassDeclaration : TypeDeclaration, `[`SuperClassHolder`](../-super-class-holder/index.md)`, `[`ImplementationHolder`](../-implementation-holder/index.md)<br>Declaration of a class. |
| [EnumDeclaration](../-enum-declaration/index.md) | `data class EnumDeclaration : TypeDeclaration, `[`ImplementationHolder`](../-implementation-holder/index.md)`, `[`EntryHolder`](../-entry-holder/index.md)<br>Enum declaration. |
| [InterfaceDeclaration](../-interface-declaration/index.md) | `data class InterfaceDeclaration : TypeDeclaration, `[`ImplementationHolder`](../-implementation-holder/index.md)<br>Interface declaration. |
