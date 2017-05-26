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

The implementation MUST implement [hashCode](hash-code.md) and [equals](equals.md).

### Properties

| Name | Summary |
|---|---|
| [arrayBaseComponent](array-base-component.md) | `open val arrayBaseComponent: CodeType`<br>Array base component. |
| [arrayComponent](array-component.md) | `open val arrayComponent: CodeType`<br>Array component. |
| [arrayDimension](array-dimension.md) | `open val arrayDimension: Int`<br>Array dimension, 0 if this type is not an array. |
| [binaryName](binary-name.md) | `open val binaryName: String`<br>Binary name of the class. |
| [canonicalName](canonical-name.md) | `abstract val canonicalName: String`<br>Canonical name |
| [defaultResolver](default-resolver.md) | `open val defaultResolver: `[`CodeTypeResolver`](../-code-type-resolver/index.md)`<*>`<br>Default resolver. |
| [identification](identification.md) | `open val identification: String`<br>Unique string identification, this property may be used for equality comparison, normal types,
array types and generic types have different identifications, if a generic type represent a single
CodeType without any bound, then the identification will be the same as the single CodeType. |
| [isArray](is-array.md) | `open val isArray: Boolean`<br>True if this CodeType is an array type. |
| [isInterface](is-interface.md) | `open val isInterface: Boolean`<br>True if this CodeType is a interface type. |
| [isPrimitive](is-primitive.md) | `open val isPrimitive: Boolean`<br>True if this CodeType is a primitive type. |
| [isVirtual](is-virtual.md) | `open val isVirtual: Boolean`<br>True if is a `Virtual Type` (Virtual Types = Types that were not loaded by JVM) |
| [javaSpecName](java-spec-name.md) | `open val javaSpecName: String`<br>JVM Spec class name. |
| [packageName](package-name.md) | `open val packageName: String`<br>Package name |
| [primitiveType](primitive-type.md) | `open val primitiveType: CodeType?`<br>Primitive type. |
| [simpleName](simple-name.md) | `open val simpleName: String`<br>Simple name. |
| [type](type.md) | `abstract val type: String`<br>Type name, examples: |
| [wrapperType](wrapper-type.md) | `open val wrapperType: CodeType?`<br>Wrapper type. |

### Functions

| Name | Summary |
|---|---|
| [compareTo](compare-to.md) | `open fun compareTo(other: CodeType): Int` |
| [equals](equals.md) | `abstract fun equals(other: Any?): Boolean` |
| [getTypeName](get-type-name.md) | `open fun getTypeName(): String` |
| [hashCode](hash-code.md) | `abstract fun hashCode(): Int` |
| [is](is.md) | `open fun is(another: CodeType?): Boolean`<br>Returns true if this CodeType is equals to another CodeType. |
| [toArray](to-array.md) | `open fun toArray(dimensions: Int): CodeType`<br>Convert this CodeType to a [CodeTypeArray](#). |

### Inherited Functions

| Name | Summary |
|---|---|
| [builder](../../com.github.jonathanxd.codeapi/-code-part/builder.md) | `open fun builder(): `[`Builder`](../../com.github.jonathanxd.codeapi.builder/-builder/index.md)`<`[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`, *>`<br>This builder may or may not accept null values, it depends on implementation. |

### Extension Properties

| Name | Summary |
|---|---|
| [codeType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/code-type.md) | `val `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.codeType: CodeType` |
| [concreteType](../../com.github.jonathanxd.codeapi.util/concrete-type.md) | `val CodeType.concreteType: CodeType`<br>Gets the concrete type of CodeType, if this is a [GenericType](../-generic-type/index.md), the property getter will try to
infer the concrete type looping the [GenericType Inferred type](../-generic-type/code-type.md). |
| [descName](../../com.github.jonathanxd.codeapi.util/desc-name.md) | `val CodeType.descName: String` |

### Extension Functions

| Name | Summary |
|---|---|
| [applyType](../../com.github.jonathanxd.codeapi.util/apply-type.md) | `fun CodeType.applyType(typeName: String, type: CodeType): CodeType` |
| [asString](../../com.github.jonathanxd.codeapi.util/kotlin.-any/as-string.md) | `fun Any?.asString(simple: Boolean = true): String`<br>Create a String representation of the part of this [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) |
| [eq](../../com.github.jonathanxd.codeapi.util/eq.md) | `fun CodeType.eq(obj: Any?): Boolean`<br>Default equals method. |
| [getPartType](../../com.github.jonathanxd.codeapi.util/get-part-type.md) | `fun `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.getPartType(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or throws [IllegalStateException](http://docs.oracle.com/javase/6/docs/api/java/lang/IllegalStateException.html) if [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is not instance of [Typed](../../com.github.jonathanxd.codeapi.base/-typed/index.md) |
| [getPartTypeOrNull](../../com.github.jonathanxd.codeapi.util/get-part-type-or-null.md) | `fun `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.getPartTypeOrNull(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or `null` if [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is not instance of [Typed](../../com.github.jonathanxd.codeapi.base/-typed/index.md). |
| [getType](../../com.github.jonathanxd.codeapi.util/get-type.md) | `fun CodeType.getType(name: String): CodeType?`<br>`fun CodeType.getType(name: String, inside: CodeType): CodeType?` |
| [getType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/get-type.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.getType(isParameterized: Boolean = false): CodeType` |
| [hash](../../com.github.jonathanxd.codeapi.util/hash.md) | `fun CodeType.hash(): Int`<br>Default hash algorithm. |
| [is](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.is(another: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Boolean` |
| [nonStrictEq](../../com.github.jonathanxd.codeapi.util/non-strict-eq.md) | `fun CodeType.nonStrictEq(other: CodeType): Boolean`<br>Non-strict generic equality check, only works for generic types. |
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
