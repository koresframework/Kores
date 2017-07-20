[CodeAPI](../../../index.md) / [com.github.jonathanxd.codeapi.base](../../index.md) / [InterfaceDeclaration](../index.md) / [Builder](.)

# Builder

`class Builder : `[`Builder`](../../-type-declaration/-builder/index.md)`<`[`InterfaceDeclaration`](../index.md)`, Builder>, `[`Builder`](../../-implementation-holder/-builder/index.md)`<`[`InterfaceDeclaration`](../index.md)`, Builder>`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(defaults: `[`InterfaceDeclaration`](../index.md)`)`<br>`Builder()` |

### Properties

| Name | Summary |
|---|---|
| [annotations](annotations.md) | `var annotations: List<`[`Annotation`](../../-annotation/index.md)`>` |
| [comments](comments.md) | `var comments: `[`Comments`](../../../com.github.jonathanxd.codeapi.base.comment/-comments/index.md) |
| [fields](fields.md) | `var fields: List<`[`FieldDeclaration`](../../-field-declaration/index.md)`>` |
| [genericSignature](generic-signature.md) | `var genericSignature: `[`GenericSignature`](../../../com.github.jonathanxd.codeapi.generic/-generic-signature/index.md) |
| [implementations](implementations.md) | `var implementations: List<`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`>` |
| [innerTypes](inner-types.md) | `var innerTypes: List<`[`TypeDeclaration`](../../-type-declaration/index.md)`>` |
| [methods](methods.md) | `var methods: List<`[`MethodDeclaration`](../../-method-declaration/index.md)`>` |
| [modifiers](modifiers.md) | `var modifiers: Set<`[`CodeModifier`](../../-code-modifier/index.md)`>` |
| [outerClass](outer-class.md) | `var outerClass: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?` |
| [specifiedName](specified-name.md) | `lateinit var specifiedName: String` |

### Functions

| Name | Summary |
|---|---|
| [annotations](annotations.md) | `fun annotations(value: List<`[`Annotation`](../../-annotation/index.md)`>): Builder`<br>See [T.annotations](#) |
| [build](build.md) | `fun build(): `[`InterfaceDeclaration`](../index.md)<br>Build the object of type [T](#). |
| [comments](comments.md) | `fun comments(value: `[`Comments`](../../../com.github.jonathanxd.codeapi.base.comment/-comments/index.md)`): Builder`<br>See [T.comments](#) |
| [constructors](constructors.md) | `fun constructors(value: List<`[`ConstructorDeclaration`](../../-constructor-declaration/index.md)`>): Builder`<br>See [TypeDeclaration.constructors](../../-elements-holder/constructors.md) |
| [fields](fields.md) | `fun fields(value: List<`[`FieldDeclaration`](../../-field-declaration/index.md)`>): Builder`<br>See [TypeDeclaration.fields](../../-elements-holder/fields.md) |
| [genericSignature](generic-signature.md) | `fun genericSignature(value: `[`GenericSignature`](../../../com.github.jonathanxd.codeapi.generic/-generic-signature/index.md)`): Builder`<br>See [T.genericSignature](#) |
| [implementations](implementations.md) | `fun implementations(value: List<`[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`>): Builder`<br>See [T.implementations](#) |
| [innerTypes](inner-types.md) | `fun innerTypes(value: List<`[`TypeDeclaration`](../../-type-declaration/index.md)`>): Builder`<br>See [T.innerTypes](#) |
| [methods](methods.md) | `fun methods(value: List<`[`MethodDeclaration`](../../-method-declaration/index.md)`>): Builder`<br>See [TypeDeclaration.methods](../../-elements-holder/methods.md) |
| [modifiers](modifiers.md) | `fun modifiers(value: Set<`[`CodeModifier`](../../-code-modifier/index.md)`>): Builder`<br>See [ModifiersHolder.modifiers](../../-modifiers-holder/modifiers.md) |
| [outerClass](outer-class.md) | `fun outerClass(value: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`?): Builder`<br>See [TypeDeclaration.outerClass](../../-type-declaration/outer-class.md) |
| [specifiedName](specified-name.md) | `fun specifiedName(value: String): Builder`<br>See [TypeDeclaration.specifiedName](../../-type-declaration/specified-name.md) |
| [staticBlock](static-block.md) | `fun staticBlock(value: `[`StaticBlock`](../../-static-block/index.md)`): Builder`<br>See [TypeDeclaration.staticBlock](../../-elements-holder/static-block.md) |

### Inherited Functions

| Name | Summary |
|---|---|
| [base](../../-type-declaration/-builder/base.md) | `open fun base(typeRef: `[`TypeRef`](../../../com.github.jonathanxd.codeapi.type/-type-ref/index.md)`): S`<br>Sets the name and outer type to values specified in [typeRef](../../-type-declaration/-builder/base.md#com.github.jonathanxd.codeapi.base.TypeDeclaration.Builder$base(com.github.jonathanxd.codeapi.type.TypeRef)/typeRef) |
| [implementations](../../-implementation-holder/-builder/implementations.md) | `open fun implementations(vararg values: `[`Type`](http://docs.oracle.com/javase/6/docs/api/java/lang/reflect/Type.html)`): S`<br>See [T.implementations](../../-implementation-holder/-builder/implementations.md) |
| [qualifiedName](../../-type-declaration/-builder/qualified-name.md) | `open fun qualifiedName(value: String): S` |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`InterfaceDeclaration`](../index.md)`): Builder` |
