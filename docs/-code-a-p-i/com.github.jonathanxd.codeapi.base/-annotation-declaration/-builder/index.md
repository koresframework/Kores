[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [AnnotationDeclaration](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-type-declaration/-builder/index.md)`<`[`AnnotationDeclaration`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`AnnotationDeclaration`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [annotations](annotations.md) | `var annotations: List<`[`Annotation`](../../-annotation/index.md)`>` |
| [comments](comments.md) | `var comments: `[`Comments`](../../../com.github.jonathanxd.codeapi.base.comment/-comments/index.md) |
| [constructors](constructors.md) | `var constructors: List<`[`ConstructorDeclaration`](../../-constructor-declaration/index.md)`>` |
| [fields](fields.md) | `var fields: List<`[`FieldDeclaration`](../../-field-declaration/index.md)`>` |
| [genericSignature](generic-signature.md) | `var genericSignature: `[`GenericSignature`](../../../com.github.jonathanxd.codeapi.generic/-generic-signature/index.md) |
| [innerTypes](inner-types.md) | `var innerTypes: List<`[`TypeDeclaration`](../../-type-declaration/index.md)`>` |
| [methods](methods.md) | `var methods: List<`[`MethodDeclaration`](../../-method-declaration/index.md)`>` |
| [modifiers](modifiers.md) | `var modifiers: Set<`[`CodeModifier`](../../-code-modifier/index.md)`>` |
| [outerClass](outer-class.md) | `var outerClass: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?` |
| [properties](properties.md) | `var properties: List<`[`AnnotationProperty`](../../-annotation-property/index.md)`>` |
| [specifiedName](specified-name.md) | `lateinit var specifiedName: String` |
| [staticBlock](static-block.md) | `var staticBlock: `[`StaticBlock`](../../-static-block/index.md) |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`AnnotationDeclaration`](../index.md)<br>Build the object of type [T](#). |
| [withAnnotations](with-annotations.md) | `fun withAnnotations(value: List<`[`Annotation`](../../-annotation/index.md)`>): Builder`<br>See [T.annotations](#) |
| [withComments](with-comments.md) | `fun withComments(value: `[`Comments`](../../../com.github.jonathanxd.codeapi.base.comment/-comments/index.md)`): Builder`<br>See [T.comments](#) |
| [withConstructors](with-constructors.md) | `fun withConstructors(value: List<`[`ConstructorDeclaration`](../../-constructor-declaration/index.md)`>): Builder`<br>See [TypeDeclaration.constructors](../../-elements-holder/constructors.md) |
| [withFields](with-fields.md) | `fun withFields(value: List<`[`FieldDeclaration`](../../-field-declaration/index.md)`>): Builder`<br>See [TypeDeclaration.fields](../../-elements-holder/fields.md) |
| [withGenericSignature](with-generic-signature.md) | `fun withGenericSignature(value: `[`GenericSignature`](../../../com.github.jonathanxd.codeapi.generic/-generic-signature/index.md)`): Builder`<br>See [T.genericSignature](#) |
| [withInnerTypes](with-inner-types.md) | `fun withInnerTypes(value: List<`[`TypeDeclaration`](../../-type-declaration/index.md)`>): Builder`<br>See [T.innerTypes](#) |
| [withMethods](with-methods.md) | `fun withMethods(value: List<`[`MethodDeclaration`](../../-method-declaration/index.md)`>): Builder`<br>See [TypeDeclaration.methods](../../-elements-holder/methods.md) |
| [withModifiers](with-modifiers.md) | `fun withModifiers(value: Set<`[`CodeModifier`](../../-code-modifier/index.md)`>): Builder`<br>See [ModifiersHolder.modifiers](../../-modifiers-holder/modifiers.md) |
| [withOuterClass](with-outer-class.md) | `fun withOuterClass(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?): Builder`<br>See [TypeDeclaration.outerClass](../../-type-declaration/outer-class.md) |
| [withProperties](with-properties.md) | `fun withProperties(value: List<`[`AnnotationProperty`](../../-annotation-property/index.md)`>): Builder`<br>`fun withProperties(vararg values: `[`AnnotationProperty`](../../-annotation-property/index.md)`): Builder`<br>See [AnnotationDeclaration.properties](../properties.md) |
| [withSpecifiedName](with-specified-name.md) | `fun withSpecifiedName(value: String): Builder`<br>See [TypeDeclaration.specifiedName](../../-type-declaration/specified-name.md) |
| [withStaticBlock](with-static-block.md) | `fun withStaticBlock(value: `[`StaticBlock`](../../-static-block/index.md)`): Builder`<br>See [TypeDeclaration.staticBlock](../../-elements-holder/static-block.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [base](../../-type-declaration/-builder/base.md) | `open fun base(typeRef: `[`TypeRef`](../../../com.github.jonathanxd.codeapi.type/-type-ref/index.md)`): S`<br>Sets the name and outer type to values specified in [typeRef](../../-type-declaration/-builder/base.md#com.github.jonathanxd.codeapi.base.TypeDeclaration.Builder$base(com.github.jonathanxd.codeapi.type.TypeRef)/typeRef) |
| [withQualifiedName](../../-type-declaration/-builder/with-qualified-name.md) | `open fun withQualifiedName(value: String): S` |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`AnnotationDeclaration`](../index.md)`): Builder` |
