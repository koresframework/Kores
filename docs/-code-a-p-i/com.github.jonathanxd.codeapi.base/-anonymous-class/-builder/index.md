[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [AnonymousClass](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-type-declaration/-builder/index.md)`<`[`AnonymousClass`](../index.md)`, Builder>, `[`Builder`](../../-super-class-holder/-builder/index.md)`<`[`AnonymousClass`](../index.md)`, Builder>, `[`Builder`](../../-argument-holder/-builder/index.md)`<`[`AnonymousClass`](../index.md)`, Builder>, `[`Builder`](../../-implementation-holder/-builder/index.md)`<`[`AnonymousClass`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`AnonymousClass`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [annotations](annotations.md) | `var annotations: List<`[`Annotation`](../../-annotation/index.md)`>` |
| [arguments](arguments.md) | `var arguments: List<`[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`>` |
| [comments](comments.md) | `var comments: `[`Comments`](../../../com.github.jonathanxd.codeapi.base.comment/-comments/index.md) |
| [constructorBody](constructor-body.md) | `lateinit var constructorBody: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md) |
| [constructorSpec](constructor-spec.md) | `lateinit var constructorSpec: `[`TypeSpec`](../../-type-spec/index.md) |
| [constructors](constructors.md) | `var constructors: List<`[`ConstructorDeclaration`](../../-constructor-declaration/index.md)`>` |
| [fields](fields.md) | `var fields: List<`[`FieldDeclaration`](../../-field-declaration/index.md)`>` |
| [implementations](implementations.md) | `var implementations: List<`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`>` |
| [innerTypes](inner-types.md) | `var innerTypes: List<`[`TypeDeclaration`](../../-type-declaration/index.md)`>` |
| [methods](methods.md) | `var methods: List<`[`MethodDeclaration`](../../-method-declaration/index.md)`>` |
| [outerClass](outer-class.md) | `var outerClass: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?` |
| [specifiedName](specified-name.md) | `lateinit var specifiedName: String` |
| [staticBlock](static-block.md) | `var staticBlock: `[`StaticBlock`](../../-static-block/index.md) |
| [superClass](super-class.md) | `var superClass: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html) |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`AnonymousClass`](../index.md)<br>Build the object of type [T](#). |
| [withAnnotations](with-annotations.md) | `fun withAnnotations(value: List<`[`Annotation`](../../-annotation/index.md)`>): Builder`<br>See [T.annotations](#) |
| [withArguments](with-arguments.md) | `fun withArguments(value: List<`[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`>): Builder`<br>See [T.arguments](#) |
| [withArray](with-array.md) | `fun withArray(value: Boolean): Builder`<br>See [T.array](#) |
| [withComments](with-comments.md) | `fun withComments(value: `[`Comments`](../../../com.github.jonathanxd.codeapi.base.comment/-comments/index.md)`): Builder`<br>See [T.comments](#) |
| [withConstructorBody](with-constructor-body.md) | `fun withConstructorBody(value: `[`CodeSource`](../../../com.github.jonathanxd.codeapi/-code-source/index.md)`): Builder`<br>See [AnonymousClass.constructorBody](../constructor-body.md) |
| [withConstructorSpec](with-constructor-spec.md) | `fun withConstructorSpec(value: `[`TypeSpec`](../../-type-spec/index.md)`): Builder`<br>See [AnonymousClass.constructorSpec](../constructor-spec.md) |
| [withConstructors](with-constructors.md) | `fun withConstructors(value: List<`[`ConstructorDeclaration`](../../-constructor-declaration/index.md)`>): Builder`<br>See [TypeDeclaration.constructors](../../-elements-holder/constructors.md) |
| [withFields](with-fields.md) | `fun withFields(value: List<`[`FieldDeclaration`](../../-field-declaration/index.md)`>): Builder`<br>See [TypeDeclaration.fields](../../-elements-holder/fields.md) |
| [withGenericSignature](with-generic-signature.md) | `fun withGenericSignature(value: `[`GenericSignature`](../../../com.github.jonathanxd.codeapi.generic/-generic-signature/index.md)`): Builder`<br>See [T.genericSignature](#) |
| [withImplementations](with-implementations.md) | `fun withImplementations(value: List<`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`>): Builder`<br>See [T.implementations](#) |
| [withInnerTypes](with-inner-types.md) | `fun withInnerTypes(value: List<`[`TypeDeclaration`](../../-type-declaration/index.md)`>): Builder`<br>See [T.innerTypes](#) |
| [withMethods](with-methods.md) | `fun withMethods(value: List<`[`MethodDeclaration`](../../-method-declaration/index.md)`>): Builder`<br>See [TypeDeclaration.methods](../../-elements-holder/methods.md) |
| [withModifiers](with-modifiers.md) | `fun withModifiers(value: Set<`[`CodeModifier`](../../-code-modifier/index.md)`>): Builder`<br>`fun withModifiers(vararg values: `[`CodeModifier`](../../-code-modifier/index.md)`): Builder`<br>See [ModifiersHolder.modifiers](../../-modifiers-holder/modifiers.md) |
| [withOuterClass](with-outer-class.md) | `fun withOuterClass(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?): Builder`<br>See [TypeDeclaration.outerClass](../../-type-declaration/outer-class.md) |
| [withSpecifiedName](with-specified-name.md) | `fun withSpecifiedName(value: String): Builder`<br>See [TypeDeclaration.specifiedName](../../-type-declaration/specified-name.md) |
| [withStaticBlock](with-static-block.md) | `fun withStaticBlock(value: `[`StaticBlock`](../../-static-block/index.md)`): Builder`<br>See [TypeDeclaration.staticBlock](../../-elements-holder/static-block.md) |
| [withSuperClass](with-super-class.md) | `fun withSuperClass(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?): Builder`<br>See [T.superClass](#) |

### Inherited Functions

| Name | Summary |
|---|---|
| [base](../../-type-declaration/-builder/base.md) | `open fun base(typeRef: `[`TypeRef`](../../../com.github.jonathanxd.codeapi.type/-type-ref/index.md)`): S`<br>Sets the name and outer type to values specified in [typeRef](../../-type-declaration/-builder/base.md#com.github.jonathanxd.codeapi.base.TypeDeclaration.Builder$base(com.github.jonathanxd.codeapi.type.TypeRef)/typeRef) |
| [withArguments](../../-argument-holder/-builder/with-arguments.md) | `open fun withArguments(vararg values: `[`CodePart`](../../../com.github.jonathanxd.codeapi/-code-part/index.md)`): S`<br>See [T.arguments](../../-argument-holder/arguments.md) |
| [withImplementations](../../-implementation-holder/-builder/with-implementations.md) | `open fun withImplementations(vararg values: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): S`<br>See [T.implementations](../../-implementation-holder/implementations.md) |
| [withQualifiedName](../../-type-declaration/-builder/with-qualified-name.md) | `open fun withQualifiedName(value: String): S` |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`AnonymousClass`](../index.md)`): Builder` |
