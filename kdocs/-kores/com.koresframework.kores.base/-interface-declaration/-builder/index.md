//[Kores](../../../../index.md)/[com.koresframework.kores.base](../../index.md)/[InterfaceDeclaration](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [TypeDeclaration.Builder](../../-type-declaration/-builder/index.md)<[InterfaceDeclaration](../index.md), [InterfaceDeclaration.Builder](index.md)> , [ImplementationHolder.Builder](../../-implementation-holder/-builder/index.md)<[InterfaceDeclaration](../index.md), [InterfaceDeclaration.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [InterfaceDeclaration](../index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [annotations](../../-annotable/-builder/annotations.md) | [jvm]<br>open fun [annotations](../../-annotable/-builder/annotations.md)(vararg values: [Annotation](../../-annotation/index.md)): [InterfaceDeclaration.Builder](index.md)<br>open override fun [annotations](annotations.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Annotation](../../-annotation/index.md)>): [InterfaceDeclaration.Builder](index.md)<br>See T. |
| [base](../../-type-declaration/-builder/base.md) | [jvm]<br>open fun [base](../../-type-declaration/-builder/base.md)(typeRef: [TypeRef](../../../com.koresframework.kores.type/-type-ref/index.md)): [InterfaceDeclaration.Builder](index.md)<br>Sets the name and outer type to values specified in [typeRef](../../-type-declaration/-builder/base.md) |
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [InterfaceDeclaration](../index.md)<br>Build the object of type T. |
| [comments](comments.md) | [jvm]<br>open override fun [comments](comments.md)(value: [Comments](../../../com.koresframework.kores.base.comment/-comments/index.md)): [InterfaceDeclaration.Builder](index.md)<br>See CommentHolder. |
| [fields](../../-elements-holder/-builder/fields.md) | [jvm]<br>open fun [fields](../../-elements-holder/-builder/fields.md)(value: [FieldDeclaration](../../-field-declaration/index.md)): [InterfaceDeclaration.Builder](index.md)<br>open fun [fields](../../-elements-holder/-builder/fields.md)(vararg values: [FieldDeclaration](../../-field-declaration/index.md)): [InterfaceDeclaration.Builder](index.md)<br>open override fun [fields](fields.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[FieldDeclaration](../../-field-declaration/index.md)>): [InterfaceDeclaration.Builder](index.md)<br>See [ElementsHolder.fields](../../-elements-holder/fields.md) |
| [genericSignature](generic-signature.md) | [jvm]<br>open override fun [genericSignature](generic-signature.md)(value: [GenericSignature](../../../com.koresframework.kores.generic/-generic-signature/index.md)): [InterfaceDeclaration.Builder](index.md)<br>See T. |
| [implementations](../../-implementation-holder/-builder/implementations.md) | [jvm]<br>open fun [implementations](../../-implementation-holder/-builder/implementations.md)(vararg values: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [InterfaceDeclaration.Builder](index.md)<br>open override fun [implementations](implementations.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)>): [InterfaceDeclaration.Builder](index.md)<br>See T. |
| [innerTypes](../../-inner-types-holder/-builder/inner-types.md) | [jvm]<br>open fun [innerTypes](../../-inner-types-holder/-builder/inner-types.md)(vararg values: [TypeDeclaration](../../-type-declaration/index.md)): [InterfaceDeclaration.Builder](index.md)<br>open override fun [innerTypes](inner-types.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[TypeDeclaration](../../-type-declaration/index.md)>): [InterfaceDeclaration.Builder](index.md)<br>See [InnerTypesHolder.innerTypes](../../-inner-types-holder/inner-types.md) |
| [methods](../../-elements-holder/-builder/methods.md) | [jvm]<br>open fun [methods](../../-elements-holder/-builder/methods.md)(value: [MethodDeclaration](../../-method-declaration/index.md)): [InterfaceDeclaration.Builder](index.md)<br>open fun [methods](../../-elements-holder/-builder/methods.md)(vararg values: [MethodDeclaration](../../-method-declaration/index.md)): [InterfaceDeclaration.Builder](index.md)<br>open override fun [methods](methods.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[MethodDeclaration](../../-method-declaration/index.md)>): [InterfaceDeclaration.Builder](index.md)<br>See [ElementsHolder.methods](../../-elements-holder/methods.md) |
| [modifiers](modifiers.md) | [jvm]<br>open override fun [modifiers](modifiers.md)(value: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[KoresModifier](../../-kores-modifier/index.md)>): [InterfaceDeclaration.Builder](index.md)<br>open fun [modifiers](../../-modifiers-holder/-builder/modifiers.md)(vararg values: [KoresModifier](../../-kores-modifier/index.md)): [InterfaceDeclaration.Builder](index.md)<br>See [ModifiersHolder.modifiers](../../-modifiers-holder/modifiers.md) |
| [name](../../-qualified-named/-builder/name.md) | [jvm]<br>open override fun [name](../../-qualified-named/-builder/name.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [InterfaceDeclaration.Builder](index.md) |
| [outerType](outer-type.md) | [jvm]<br>open override fun [outerType](outer-type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)?): [InterfaceDeclaration.Builder](index.md)<br>See [TypeDeclaration.outerType](../../-type-declaration/outer-type.md) |
| [publicModifier](../../-modifiers-holder/-builder/public-modifier.md) | [jvm]<br>open fun [publicModifier](../../-modifiers-holder/-builder/public-modifier.md)(): [InterfaceDeclaration.Builder](index.md)<br>Sets modifiers to [KoresModifier.PUBLIC](../../-kores-modifier/-p-u-b-l-i-c/index.md). |
| [qualifiedName](../../-type-declaration/-builder/qualified-name.md) | [jvm]<br>open override fun [qualifiedName](../../-type-declaration/-builder/qualified-name.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [InterfaceDeclaration.Builder](index.md) |
| [specifiedName](specified-name.md) | [jvm]<br>open override fun [specifiedName](specified-name.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [InterfaceDeclaration.Builder](index.md)<br>See [TypeDeclaration.specifiedName](../../-type-declaration/specified-name.md) |
| [staticBlock](static-block.md) | [jvm]<br>open override fun [staticBlock](static-block.md)(value: [StaticBlock](../../-static-block/index.md)): [InterfaceDeclaration.Builder](index.md)<br>See [ElementsHolder.staticBlock](../../-elements-holder/static-block.md) |

## Properties

| Name | Summary |
|---|---|
| [annotations](annotations.md) | [jvm]<br>var [annotations](annotations.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Annotation](../../-annotation/index.md)> |
| [comments](comments.md) | [jvm]<br>var [comments](comments.md): [Comments](../../../com.koresframework.kores.base.comment/-comments/index.md) |
| [fields](fields.md) | [jvm]<br>var [fields](fields.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[FieldDeclaration](../../-field-declaration/index.md)> |
| [genericSignature](generic-signature.md) | [jvm]<br>var [genericSignature](generic-signature.md): [GenericSignature](../../../com.koresframework.kores.generic/-generic-signature/index.md) |
| [implementations](implementations.md) | [jvm]<br>var [implementations](implementations.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)> |
| [innerTypes](inner-types.md) | [jvm]<br>var [innerTypes](inner-types.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[TypeDeclaration](../../-type-declaration/index.md)> |
| [methods](methods.md) | [jvm]<br>var [methods](methods.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[MethodDeclaration](../../-method-declaration/index.md)> |
| [modifiers](modifiers.md) | [jvm]<br>var [modifiers](modifiers.md): [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[KoresModifier](../../-kores-modifier/index.md)> |
| [outerClass](outer-class.md) | [jvm]<br>var [outerClass](outer-class.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)? = null |
| [specifiedName](specified-name.md) | [jvm]<br>lateinit var [specifiedName](specified-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
