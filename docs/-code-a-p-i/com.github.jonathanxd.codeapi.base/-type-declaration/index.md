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
| [defaultResolver](default-resolver.md) | `open val defaultResolver: `[`CodeTypeResolver`](../../com.github.jonathanxd.codeapi.type/-code-type-resolver/index.md)`<*>`<br>Default resolver. |
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
| [bindedDefaultResolver](../../com.github.jonathanxd.codeapi.type/-code-type/binded-default-resolver.md) | `open val bindedDefaultResolver: `[`BindedTypeResolver`](../../com.github.jonathanxd.codeapi.type/-binded-type-resolver/index.md)`<*>`<br>Creates a new binded default resolver instance. |
| [comments](../../com.github.jonathanxd.codeapi.base.comment/-comment-holder/comments.md) | `abstract val comments: `[`Comments`](../../com.github.jonathanxd.codeapi.base.comment/-comments/index.md)<br>All comments inside this holder. |
| [constructors](../-elements-holder/constructors.md) | `abstract val constructors: List<`[`ConstructorDeclaration`](../-constructor-declaration/index.md)`>`<br>Constructor declaration |
| [fields](../-elements-holder/fields.md) | `abstract val fields: List<`[`FieldDeclaration`](../-field-declaration/index.md)`>`<br>Fields of the type. |
| [genericSignature](../-generic-signature-holder/generic-signature.md) | `abstract val genericSignature: `[`GenericSignature`](../../com.github.jonathanxd.codeapi.generic/-generic-signature/index.md)<br>Generic signature. |
| [identification](../../com.github.jonathanxd.codeapi.type/-code-type/identification.md) | `open val identification: String`<br>Unique string identification, this property may be used for equality comparison, normal types,
array types and generic types have different identifications, if a generic type represent a single
[CodeType](../../com.github.jonathanxd.codeapi.type/-code-type/index.md) without any bound, then the identification will be the same as the single [CodeType](../../com.github.jonathanxd.codeapi.type/-code-type/index.md). |
| [interfaces](../../com.github.jonathanxd.codeapi.type/-code-type/interfaces.md) | `open val interfaces: List<`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`>`<br>Gets the super interfaces of `this` [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) using default resolver. |
| [internalName](../../com.github.jonathanxd.codeapi.type/-code-type/internal-name.md) | `open val internalName: String`<br>Internal class name. |
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
| [superType](../../com.github.jonathanxd.codeapi.type/-code-type/super-type.md) | `open val superType: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Gets the super type of `this` [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) using default resolver. |
| [wrapperType](../../com.github.jonathanxd.codeapi.type/-code-type/wrapper-type.md) | `open val wrapperType: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`?`<br>Wrapper type. |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `abstract fun builder(): `[`Builder`](-builder/index.md)`<TypeDeclaration, *>`<br>This builder may or may not accept null values, it depends on implementation. |

### Inherited Functions

| Name | Summary |
|---|---|
| [compareTo](../../com.github.jonathanxd.codeapi.type/-code-type/compare-to.md) | `open fun compareTo(other: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`): Int`<br>Compare two identifications |
| [getTypeName](../../com.github.jonathanxd.codeapi.type/-code-type/get-type-name.md) | `open fun getTypeName(): String` |
| [is](../../com.github.jonathanxd.codeapi.type/-code-type/is.md) | `open fun is(other: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`?): Boolean`<br>Returns true if this [CodeType](../../com.github.jonathanxd.codeapi.type/-code-type/index.md) is equals to other [CodeType](../../com.github.jonathanxd.codeapi.type/-code-type/index.md). |
| [isAssignableFrom](../../com.github.jonathanxd.codeapi.type/-code-type/is-assignable-from.md) | `open fun isAssignableFrom(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Boolean`<br>Returns true if `this` type is assignable from [type](../../com.github.jonathanxd.codeapi.type/-code-type/is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeType$isAssignableFrom(java.lang.reflect.Type)/type) (using default resolver of [type](../../com.github.jonathanxd.codeapi.type/-code-type/is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeType$isAssignableFrom(java.lang.reflect.Type)/type)).`open fun isAssignableFrom(type: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`, resolverProvider: (`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`) -> `[`CodeTypeResolver`](../../com.github.jonathanxd.codeapi.type/-code-type-resolver/index.md)`<*>): Boolean`<br>Returns true if `this` type is assignable from [type](../../com.github.jonathanxd.codeapi.type/-code-type/is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeType$isAssignableFrom(java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/type) (using resolver provided by [resolverProvider](../../com.github.jonathanxd.codeapi.type/-code-type/is-assignable-from.md#com.github.jonathanxd.codeapi.type.CodeType$isAssignableFrom(java.lang.reflect.Type, kotlin.Function1((java.lang.reflect.Type, com.github.jonathanxd.codeapi.type.CodeTypeResolver((kotlin.Any)))))/resolverProvider)). |
| [isConcreteIdEq](../../com.github.jonathanxd.codeapi.type/-code-type/is-concrete-id-eq.md) | `open fun isConcreteIdEq(other: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Boolean`<br>Returns true if identification of [concreteType](../../com.github.jonathanxd.codeapi.util/concrete-type.md) of this [CodeType](../../com.github.jonathanxd.codeapi.type/-code-type/index.md) is equals to
[concreteType](../../com.github.jonathanxd.codeapi.util/concrete-type.md) of other [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) according to [is](../../com.github.jonathanxd.codeapi.type/-code-type/is.md). |
| [isIdEq](../../com.github.jonathanxd.codeapi.type/-code-type/is-id-eq.md) | `open fun isIdEq(other: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Boolean`<br>Returns true if this [CodeType](../../com.github.jonathanxd.codeapi.type/-code-type/index.md) identification is equals to other [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) according to [is](../../com.github.jonathanxd.codeapi.type/-code-type/is.md). |
| [toArray](../../com.github.jonathanxd.codeapi.type/-code-type/to-array.md) | `open fun toArray(dimensions: Int): `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)<br>Convert this [CodeType](../../com.github.jonathanxd.codeapi.type/-code-type/index.md) to a [CodeTypeArray](#). |

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
| [extend](../../com.github.jonathanxd.codeapi.util.conversion/extend.md) | `fun <T : TypeDeclaration> T.extend(klass: `[`Class`](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html)`<*>): T`<br>Makes the declaration [T](#) extend the [Class](http://docs.oracle.com/javase/6/docs/api/java/lang/Class.html) overriding all public/protected methods
and invoking the super method. |
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

### Inheritors

| Name | Summary |
|---|---|
| [AnnotationDeclaration](../-annotation-declaration/index.md) | `data class AnnotationDeclaration : TypeDeclaration`<br>Annotation declaration. |
| [AnonymousClass](../-anonymous-class/index.md) | `data class AnonymousClass : TypeDeclaration, `[`SuperClassHolder`](../-super-class-holder/index.md)`, `[`ArgumentsHolder`](../-arguments-holder/index.md)`, `[`ImplementationHolder`](../-implementation-holder/index.md)<br>Anonymous class, in Bytecode, anonymous class can have implementations,
in other languages it depends on specification. (Official Java generator may comment implementations). |
| [ClassDeclaration](../-class-declaration/index.md) | `data class ClassDeclaration : TypeDeclaration, `[`SuperClassHolder`](../-super-class-holder/index.md)`, `[`ImplementationHolder`](../-implementation-holder/index.md)<br>Declaration of a class. |
| [EnumDeclaration](../-enum-declaration/index.md) | `data class EnumDeclaration : TypeDeclaration, `[`ImplementationHolder`](../-implementation-holder/index.md)`, `[`EntryHolder`](../-entry-holder/index.md)<br>Enum declaration. |
| [InterfaceDeclaration](../-interface-declaration/index.md) | `data class InterfaceDeclaration : TypeDeclaration, `[`ImplementationHolder`](../-implementation-holder/index.md)<br>Interface declaration. |
