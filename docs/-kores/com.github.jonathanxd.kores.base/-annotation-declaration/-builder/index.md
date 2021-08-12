//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.base](../../index.md)/[AnnotationDeclaration](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [TypeDeclaration.Builder](../../-type-declaration/-builder/index.md)<[AnnotationDeclaration](../index.md), [AnnotationDeclaration.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [AnnotationDeclaration](../index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [annotations](../../-annotable/-builder/annotations.md) | [jvm]<br>open fun [annotations](../../-annotable/-builder/annotations.md)(vararg values: [Annotation](../../-annotation/index.md)): [AnnotationDeclaration.Builder](index.md)<br>open override fun [annotations](annotations.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Annotation](../../-annotation/index.md)>): [AnnotationDeclaration.Builder](index.md)<br>See T. |
| [base](../../-type-declaration/-builder/base.md) | [jvm]<br>open fun [base](../../-type-declaration/-builder/base.md)(typeRef: [TypeRef](../../../com.github.jonathanxd.kores.type/-type-ref/index.md)): [AnnotationDeclaration.Builder](index.md)<br>Sets the name and outer type to values specified in [typeRef](../../-type-declaration/-builder/base.md) |
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [AnnotationDeclaration](../index.md)<br>Build the object of type [T](../../../com.github.jonathanxd.kores.builder/-builder/index.md). |
| [comments](comments.md) | [jvm]<br>open override fun [comments](comments.md)(value: [Comments](../../../com.github.jonathanxd.kores.base.comment/-comments/index.md)): [AnnotationDeclaration.Builder](index.md)<br>See CommentHolder. |
| [fields](fields.md) | [jvm]<br>open override fun [fields](fields.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[FieldDeclaration](../../-field-declaration/index.md)>): [AnnotationDeclaration.Builder](index.md)<br>open fun [fields](../../-elements-holder/-builder/fields.md)(value: [FieldDeclaration](../../-field-declaration/index.md)): [AnnotationDeclaration.Builder](index.md)<br>open fun [fields](../../-elements-holder/-builder/fields.md)(vararg values: [FieldDeclaration](../../-field-declaration/index.md)): [AnnotationDeclaration.Builder](index.md)<br>See [ElementsHolder.fields](../../-elements-holder/fields.md) |
| [genericSignature](generic-signature.md) | [jvm]<br>open override fun [genericSignature](generic-signature.md)(value: [GenericSignature](../../../com.github.jonathanxd.kores.generic/-generic-signature/index.md)): [AnnotationDeclaration.Builder](index.md)<br>See T. |
| [innerTypes](inner-types.md) | [jvm]<br>open override fun [innerTypes](inner-types.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[TypeDeclaration](../../-type-declaration/index.md)>): [AnnotationDeclaration.Builder](index.md)<br>open fun [innerTypes](../../-inner-types-holder/-builder/inner-types.md)(vararg values: [TypeDeclaration](../../-type-declaration/index.md)): [AnnotationDeclaration.Builder](index.md)<br>See [InnerTypesHolder.innerTypes](../../-inner-types-holder/inner-types.md) |
| [methods](methods.md) | [jvm]<br>open override fun [methods](methods.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[MethodDeclaration](../../-method-declaration/index.md)>): [AnnotationDeclaration.Builder](index.md)<br>open fun [methods](../../-elements-holder/-builder/methods.md)(value: [MethodDeclaration](../../-method-declaration/index.md)): [AnnotationDeclaration.Builder](index.md)<br>open fun [methods](../../-elements-holder/-builder/methods.md)(vararg values: [MethodDeclaration](../../-method-declaration/index.md)): [AnnotationDeclaration.Builder](index.md)<br>See [ElementsHolder.methods](../../-elements-holder/methods.md) |
| [modifiers](modifiers.md) | [jvm]<br>open override fun [modifiers](modifiers.md)(value: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[KoresModifier](../../-kores-modifier/index.md)>): [AnnotationDeclaration.Builder](index.md)<br>open fun [modifiers](../../-modifiers-holder/-builder/modifiers.md)(vararg values: [KoresModifier](../../-kores-modifier/index.md)): [AnnotationDeclaration.Builder](index.md)<br>See [ModifiersHolder.modifiers](../../-modifiers-holder/modifiers.md) |
| [name](../../-qualified-named/-builder/name.md) | [jvm]<br>open override fun [name](../../-qualified-named/-builder/name.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [AnnotationDeclaration.Builder](index.md) |
| [outerType](outer-type.md) | [jvm]<br>open override fun [outerType](outer-type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)?): [AnnotationDeclaration.Builder](index.md)<br>See [TypeDeclaration.outerType](../../-type-declaration/outer-type.md) |
| [properties](properties.md) | [jvm]<br>fun [properties](properties.md)(vararg values: [AnnotationProperty](../../-annotation-property/index.md)): [AnnotationDeclaration.Builder](index.md)<br>fun [properties](properties.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[AnnotationProperty](../../-annotation-property/index.md)>): [AnnotationDeclaration.Builder](index.md)<br>See [AnnotationDeclaration.properties](../properties.md) |
| [publicModifier](../../-modifiers-holder/-builder/public-modifier.md) | [jvm]<br>open fun [publicModifier](../../-modifiers-holder/-builder/public-modifier.md)(): [AnnotationDeclaration.Builder](index.md)<br>Sets modifiers to [KoresModifier.PUBLIC](../../-kores-modifier/-p-u-b-l-i-c/index.md). |
| [qualifiedName](../../-type-declaration/-builder/qualified-name.md) | [jvm]<br>open override fun [qualifiedName](../../-type-declaration/-builder/qualified-name.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [AnnotationDeclaration.Builder](index.md) |
| [retention](retention.md) | [jvm]<br>fun [retention](retention.md)(retention: [RetentionPolicy](https://docs.oracle.com/javase/8/docs/api/java/lang/annotation/RetentionPolicy.html)): [AnnotationDeclaration.Builder](index.md)<br>Adds retention annotation to annotation declaration (remove old retention annotation if it is already defined) |
| [specifiedName](specified-name.md) | [jvm]<br>open override fun [specifiedName](specified-name.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [AnnotationDeclaration.Builder](index.md)<br>See [TypeDeclaration.specifiedName](../../-type-declaration/specified-name.md) |
| [staticBlock](static-block.md) | [jvm]<br>open override fun [staticBlock](static-block.md)(value: [StaticBlock](../../-static-block/index.md)): [AnnotationDeclaration.Builder](index.md)<br>See [ElementsHolder.staticBlock](../../-elements-holder/static-block.md) |
| [target](target.md) | [jvm]<br>fun [target](target.md)(targets: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<[ElementType](https://docs.oracle.com/javase/8/docs/api/java/lang/annotation/ElementType.html)>): [AnnotationDeclaration.Builder](index.md)<br>Adds target annotation to annotation declaration (remove old target annotation if it is already defined) |

## Properties

| Name | Summary |
|---|---|
| [annotations](annotations.md) | [jvm]<br>var [annotations](annotations.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Annotation](../../-annotation/index.md)> |
| [comments](comments.md) | [jvm]<br>var [comments](comments.md): [Comments](../../../com.github.jonathanxd.kores.base.comment/-comments/index.md) |
| [fields](fields.md) | [jvm]<br>var [fields](fields.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[FieldDeclaration](../../-field-declaration/index.md)> |
| [genericSignature](generic-signature.md) | [jvm]<br>var [genericSignature](generic-signature.md): [GenericSignature](../../../com.github.jonathanxd.kores.generic/-generic-signature/index.md) |
| [innerTypes](inner-types.md) | [jvm]<br>var [innerTypes](inner-types.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[TypeDeclaration](../../-type-declaration/index.md)> |
| [modifiers](modifiers.md) | [jvm]<br>var [modifiers](modifiers.md): [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[KoresModifier](../../-kores-modifier/index.md)> |
| [outerClass](outer-class.md) | [jvm]<br>var [outerClass](outer-class.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)? = null |
| [properties](properties.md) | [jvm]<br>var [properties](properties.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[AnnotationProperty](../../-annotation-property/index.md)> |
| [specifiedName](specified-name.md) | [jvm]<br>lateinit var [specifiedName](specified-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
