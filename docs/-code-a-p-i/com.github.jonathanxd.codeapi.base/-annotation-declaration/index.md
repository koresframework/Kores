[CodeAPI](../../index.md) / [com.github.jonathanxd.codeapi.base](../index.md) / [AnnotationDeclaration](.)

# AnnotationDeclaration

`data class AnnotationDeclaration : `[`TypeDeclaration`](../-type-declaration/index.md)

Annotation declaration.

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `class Builder : `[`Builder`](../-type-declaration/-builder/index.md)`<AnnotationDeclaration, `[`Builder`](-builder/index.md)`>` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `AnnotationDeclaration(comments: `[`Comments`](../../com.github.jonathanxd.codeapi.base.comment/-comments/index.md)`, outerClass: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?, annotations: List<`[`Annotation`](../-annotation/index.md)`>, modifiers: Set<`[`CodeModifier`](../-code-modifier/index.md)`>, specifiedName: String, genericSignature: `[`GenericSignature`](../../com.github.jonathanxd.codeapi.generic/-generic-signature/index.md)`, properties: List<`[`AnnotationProperty`](../-annotation-property/index.md)`>, staticBlock: `[`StaticBlock`](../-static-block/index.md)`, fields: List<`[`FieldDeclaration`](../-field-declaration/index.md)`>, constructors: List<`[`ConstructorDeclaration`](../-constructor-declaration/index.md)`>, methods: List<`[`MethodDeclaration`](../-method-declaration/index.md)`>, innerTypes: List<`[`TypeDeclaration`](../-type-declaration/index.md)`>)`<br>Annotation declaration. |

### Properties

| Name | Summary |
|---|---|
| [annotations](annotations.md) | `val annotations: List<`[`Annotation`](../-annotation/index.md)`>`<br>Annotations |
| [comments](comments.md) | `val comments: `[`Comments`](../../com.github.jonathanxd.codeapi.base.comment/-comments/index.md)<br>All comments inside this holder. |
| [constructors](constructors.md) | `val constructors: List<`[`ConstructorDeclaration`](../-constructor-declaration/index.md)`>`<br>Constructor declaration |
| [fields](fields.md) | `val fields: List<`[`FieldDeclaration`](../-field-declaration/index.md)`>`<br>Fields of the type. |
| [genericSignature](generic-signature.md) | `val genericSignature: `[`GenericSignature`](../../com.github.jonathanxd.codeapi.generic/-generic-signature/index.md)<br>Generic signature. |
| [innerTypes](inner-types.md) | `val innerTypes: List<`[`TypeDeclaration`](../-type-declaration/index.md)`>`<br>Static inner types. CodeAPI 4 only supports static types, inner logic should be
manually implemented. |
| [isInterface](is-interface.md) | `val isInterface: Boolean`<br>True if this [CodeType](#) is a interface type. |
| [methods](methods.md) | `val methods: List<`[`MethodDeclaration`](../-method-declaration/index.md)`>`<br>Methods of type |
| [modifiers](modifiers.md) | `val modifiers: Set<`[`CodeModifier`](../-code-modifier/index.md)`>`<br>Modifiers. Empty modifier set is the same as public. For package private, an explicit
[CodeModifier.PACKAGE_PRIVATE](../-code-modifier/-p-a-c-k-a-g-e_-p-r-i-v-a-t-e.md) is required. |
| [outerClass](outer-class.md) | `val outerClass: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Outer class (null if this type is not a inner class). |
| [properties](properties.md) | `val properties: List<`[`AnnotationProperty`](../-annotation-property/index.md)`>`<br>Properties of annotation declaration. |
| [qualifiedName](qualified-name.md) | `val qualifiedName: String`<br>Defined qualified name |
| [specifiedName](specified-name.md) | `val specifiedName: String`<br>The specified name (for inner classes this property is set to simple name of inner class) |
| [staticBlock](static-block.md) | `val staticBlock: `[`StaticBlock`](../-static-block/index.md)<br>Static block |
| [type](type.md) | `val type: String`<br>Type name, examples: |

### Inherited Properties

| Name | Summary |
|---|---|
| [canonicalName](../-type-declaration/canonical-name.md) | `open val canonicalName: String`<br>Canonical name |

### Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): `[`Builder`](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |
| [equals](equals.md) | `fun equals(other: Any?): Boolean` |
| [hashCode](hash-code.md) | `fun hashCode(): Int` |

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
| [getPartType](../../com.github.jonathanxd.codeapi.util/get-part-type.md) | `fun `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.getPartType(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or throws [IllegalStateException](http://docs.oracle.com/javase/6/docs/api/java/lang/IllegalStateException.html) if [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is not instance of [Typed](../-typed/index.md) |
| [getPartTypeOrNull](../../com.github.jonathanxd.codeapi.util/get-part-type-or-null.md) | `fun `[`CodePart`](../../com.github.jonathanxd.codeapi/-code-part/index.md)`.getPartTypeOrNull(): `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?`<br>Returns the [Type](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) of [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) or `null` if [CodePart](../../com.github.jonathanxd.codeapi/-code-part/index.md) is not instance of [Typed](../-typed/index.md). |
| [getType](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/get-type.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.getType(isParameterized: Boolean = false): `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md) |
| [getType](../../com.github.jonathanxd.codeapi.util/get-type.md) | `fun `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`.getType(name: String): `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`?`<br>`fun `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`.getType(name: String, inside: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`): `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`?` |
| [hash](../../com.github.jonathanxd.codeapi.util/hash.md) | `fun `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`.hash(): Int`<br>Default hash algorithm. |
| [is](../../com.github.jonathanxd.codeapi.util/java.lang.reflect.-type/is.md) | `fun `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`.is(another: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): Boolean` |
| [nonStrictEq](../../com.github.jonathanxd.codeapi.util/non-strict-eq.md) | `fun `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`.nonStrictEq(other: `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`): Boolean`<br>Non-strict generic equality check, only works for generic types. |
| [toLiteral](../../com.github.jonathanxd.codeapi.util.conversion/kotlin.-any/to-literal.md) | `fun Any.toLiteral(): `[`Literal`](../../com.github.jonathanxd.codeapi.literal/-literal/index.md)`?`<br>Convert this value to a literal |
| [toStr](../../com.github.jonathanxd.codeapi.util/to-str.md) | `fun `[`CodeType`](../../com.github.jonathanxd.codeapi.type/-code-type/index.md)`.toStr(): String`<br>Default to string conversion for [CodeType](../../com.github.jonathanxd.codeapi.type/-code-type/index.md). |
