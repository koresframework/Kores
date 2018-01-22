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
| [annotations](annotations.md) | `var annotations: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Annotation`](../../-annotation/index.md)`>` |
| [comments](comments.md) | `var comments: `[`Comments`](../../../com.github.jonathanxd.codeapi.base.comment/-comments/index.md) |
| [fields](fields.md) | `var fields: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`FieldDeclaration`](../../-field-declaration/index.md)`>` |
| [genericSignature](generic-signature.md) | `var genericSignature: `[`GenericSignature`](../../../com.github.jonathanxd.codeapi.generic/-generic-signature/index.md) |
| [innerTypes](inner-types.md) | `var innerTypes: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`TypeDeclaration`](../../-type-declaration/index.md)`>` |
| [modifiers](modifiers.md) | `var modifiers: `[`Set`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)`<`[`CodeModifier`](../../-code-modifier/index.md)`>` |
| [outerClass](outer-class.md) | `var outerClass: Type?` |
| [properties](properties.md) | `var properties: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`AnnotationProperty`](../../-annotation-property/index.md)`>` |
| [specifiedName](specified-name.md) | `lateinit var specifiedName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| Name | Summary |
|---|---|
| [annotations](annotations.md) | `fun annotations(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Annotation`](../../-annotation/index.md)`>): Builder`<br>See [T.annotations](#) |
| [build](build.md) | `fun build(): `[`AnnotationDeclaration`](../index.md)<br>Build the object of type [T](#). |
| [comments](comments.md) | `fun comments(value: `[`Comments`](../../../com.github.jonathanxd.codeapi.base.comment/-comments/index.md)`): Builder`<br>See [CommentHolder.comments](#) |
| [fields](fields.md) | `fun fields(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`FieldDeclaration`](../../-field-declaration/index.md)`>): Builder`<br>See [ElementsHolder.fields](../../-elements-holder/fields.md) |
| [genericSignature](generic-signature.md) | `fun genericSignature(value: `[`GenericSignature`](../../../com.github.jonathanxd.codeapi.generic/-generic-signature/index.md)`): Builder`<br>See [T.genericSignature](#) |
| [innerTypes](inner-types.md) | `fun innerTypes(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`TypeDeclaration`](../../-type-declaration/index.md)`>): Builder`<br>See [InnerTypesHolder.innerTypes](../../-inner-types-holder/inner-types.md) |
| [methods](methods.md) | `fun methods(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`MethodDeclaration`](../../-method-declaration/index.md)`>): Builder`<br>See [ElementsHolder.methods](../../-elements-holder/methods.md) |
| [modifiers](modifiers.md) | `fun modifiers(value: `[`Set`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)`<`[`CodeModifier`](../../-code-modifier/index.md)`>): Builder`<br>See [ModifiersHolder.modifiers](../../-modifiers-holder/modifiers.md) |
| [outerType](outer-type.md) | `fun outerType(value: Type?): Builder`<br>See [TypeDeclaration.outerType](../../-type-declaration/outer-type.md) |
| [properties](properties.md) | `fun properties(value: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`AnnotationProperty`](../../-annotation-property/index.md)`>): Builder`<br>`fun properties(vararg values: `[`AnnotationProperty`](../../-annotation-property/index.md)`): Builder`<br>See [AnnotationDeclaration.properties](../properties.md) |
| [retention](retention.md) | `fun retention(retention: RetentionPolicy): Builder`<br>Adds retention annotation to annotation declaration (remove old retention annotation if it is already defined) |
| [specifiedName](specified-name.md) | `fun specifiedName(value: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Builder`<br>See [TypeDeclaration.specifiedName](../../-type-declaration/specified-name.md) |
| [staticBlock](static-block.md) | `fun staticBlock(value: `[`StaticBlock`](../../-static-block/index.md)`): Builder`<br>See [ElementsHolder.staticBlock](../../-elements-holder/static-block.md) |
| [target](target.md) | `fun target(targets: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<ElementType>): Builder`<br>Adds target annotation to annotation declaration (remove old target annotation if it is already defined) |

### Inherited Functions

| Name | Summary |
|---|---|
| [base](../../-type-declaration/-builder/base.md) | `open fun base(typeRef: `[`TypeRef`](../../../com.github.jonathanxd.codeapi.type/-type-ref/index.md)`): S`<br>Sets the name and outer type to values specified in [typeRef](../../-type-declaration/-builder/base.md#com.github.jonathanxd.codeapi.base.TypeDeclaration.Builder$base(com.github.jonathanxd.codeapi.type.TypeRef)/typeRef) |
| [qualifiedName](../../-type-declaration/-builder/qualified-name.md) | `open fun qualifiedName(value: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): S` |

### Companion Object Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | `fun builder(): Builder`<br>`fun builder(defaults: `[`AnnotationDeclaration`](../index.md)`): Builder` |
