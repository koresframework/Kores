//[Kores](../../../../index.md)/[com.koresframework.kores.base](../../index.md)/[TypeDeclaration](../index.md)/[Builder](index.md)

# Builder

[jvm]\
interface [Builder](index.md)<out [T](index.md) : [TypeDeclaration](../index.md), [S](index.md) : [TypeDeclaration.Builder](index.md)<[T](index.md), [S](index.md)>> : [ModifiersHolder.Builder](../../-modifiers-holder/-builder/index.md)<[T](index.md), [S](index.md)> , [QualifiedNamed.Builder](../../-qualified-named/-builder/index.md)<[T](index.md), [S](index.md)> , [GenericSignatureHolder.Builder](../../-generic-signature-holder/-builder/index.md)<[T](index.md), [S](index.md)> , [Annotable.Builder](../../-annotable/-builder/index.md)<[T](index.md), [S](index.md)> , [CommentHolder.Builder](../../../com.koresframework.kores.base.comment/-comment-holder/-builder/index.md)<[T](index.md), [S](index.md)> , [InnerTypesHolder.Builder](../../-inner-types-holder/-builder/index.md)<[T](index.md), [S](index.md)> , [ElementsHolder.Builder](../../-elements-holder/-builder/index.md)<[T](index.md), [S](index.md)>

## Functions

| Name | Summary |
|---|---|
| [annotations](../../-annotable/-builder/annotations.md) | [jvm]<br>open fun [annotations](../../-annotable/-builder/annotations.md)(vararg values: [Annotation](../../-annotation/index.md)): [S](index.md)<br>abstract fun [annotations](../../-annotable/-builder/annotations.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Annotation](../../-annotation/index.md)>): [S](index.md)<br>See T. |
| [base](base.md) | [jvm]<br>open fun [base](base.md)(typeRef: [TypeRef](../../../com.koresframework.kores.type/-type-ref/index.md)): [S](index.md)<br>Sets the name and outer type to values specified in [typeRef](base.md) |
| [build](../../../com.koresframework.kores.builder/-builder/build.md) | [jvm]<br>abstract fun [build](../../../com.koresframework.kores.builder/-builder/build.md)(): [T](index.md)<br>Build the object of type [T](../../../com.koresframework.kores.builder/-builder/index.md). |
| [comments](../../../com.koresframework.kores.base.comment/-comment-holder/-builder/comments.md) | [jvm]<br>abstract fun [comments](../../../com.koresframework.kores.base.comment/-comment-holder/-builder/comments.md)(value: [Comments](../../../com.koresframework.kores.base.comment/-comments/index.md)): [S](index.md)<br>See [CommentHolder.comments](../../../com.koresframework.kores.base.comment/-comment-holder/comments.md) |
| [fields](../../-elements-holder/-builder/fields.md) | [jvm]<br>open fun [fields](../../-elements-holder/-builder/fields.md)(value: [FieldDeclaration](../../-field-declaration/index.md)): [S](index.md)<br>open fun [fields](../../-elements-holder/-builder/fields.md)(vararg values: [FieldDeclaration](../../-field-declaration/index.md)): [S](index.md)<br>abstract fun [fields](../../-elements-holder/-builder/fields.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[FieldDeclaration](../../-field-declaration/index.md)>): [S](index.md)<br>See [ElementsHolder.fields](../../-elements-holder/fields.md) |
| [genericSignature](../../-generic-signature-holder/-builder/generic-signature.md) | [jvm]<br>abstract fun [genericSignature](../../-generic-signature-holder/-builder/generic-signature.md)(value: [GenericSignature](../../../com.koresframework.kores.generic/-generic-signature/index.md)): [S](index.md)<br>See T. |
| [innerTypes](../../-inner-types-holder/-builder/inner-types.md) | [jvm]<br>open fun [innerTypes](../../-inner-types-holder/-builder/inner-types.md)(vararg values: [TypeDeclaration](../index.md)): [S](index.md)<br>abstract fun [innerTypes](../../-inner-types-holder/-builder/inner-types.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[TypeDeclaration](../index.md)>): [S](index.md)<br>See [InnerTypesHolder.innerTypes](../../-inner-types-holder/inner-types.md) |
| [methods](../../-elements-holder/-builder/methods.md) | [jvm]<br>open fun [methods](../../-elements-holder/-builder/methods.md)(value: [MethodDeclaration](../../-method-declaration/index.md)): [S](index.md)<br>open fun [methods](../../-elements-holder/-builder/methods.md)(vararg values: [MethodDeclaration](../../-method-declaration/index.md)): [S](index.md)<br>abstract fun [methods](../../-elements-holder/-builder/methods.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[MethodDeclaration](../../-method-declaration/index.md)>): [S](index.md)<br>See [ElementsHolder.methods](../../-elements-holder/methods.md) |
| [modifiers](../../-modifiers-holder/-builder/modifiers.md) | [jvm]<br>open fun [modifiers](../../-modifiers-holder/-builder/modifiers.md)(vararg values: [KoresModifier](../../-kores-modifier/index.md)): [S](index.md)<br>abstract fun [modifiers](../../-modifiers-holder/-builder/modifiers.md)(value: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[KoresModifier](../../-kores-modifier/index.md)>): [S](index.md)<br>See [ModifiersHolder.modifiers](../../-modifiers-holder/modifiers.md) |
| [name](../../-qualified-named/-builder/name.md) | [jvm]<br>open override fun [name](../../-qualified-named/-builder/name.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [S](index.md) |
| [outerType](outer-type.md) | [jvm]<br>abstract fun [outerType](outer-type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)?): [S](index.md)<br>See [TypeDeclaration.outerType](../outer-type.md) |
| [publicModifier](../../-modifiers-holder/-builder/public-modifier.md) | [jvm]<br>open fun [publicModifier](../../-modifiers-holder/-builder/public-modifier.md)(): [S](index.md)<br>Sets modifiers to [KoresModifier.PUBLIC](../../-kores-modifier/-p-u-b-l-i-c/index.md). |
| [qualifiedName](qualified-name.md) | [jvm]<br>open override fun [qualifiedName](qualified-name.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [S](index.md) |
| [specifiedName](specified-name.md) | [jvm]<br>abstract fun [specifiedName](specified-name.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [S](index.md)<br>See [TypeDeclaration.specifiedName](../specified-name.md) |
| [staticBlock](../../-elements-holder/-builder/static-block.md) | [jvm]<br>abstract fun [staticBlock](../../-elements-holder/-builder/static-block.md)(value: [StaticBlock](../../-static-block/index.md)): [S](index.md)<br>See [ElementsHolder.staticBlock](../../-elements-holder/static-block.md) |

## Inheritors

| Name |
|---|
| [AnnotationDeclaration](../../-annotation-declaration/-builder/index.md) |
| [AnonymousClass](../../-anonymous-class/-builder/index.md) |
| [ClassDeclaration](../../-class-declaration/-builder/index.md) |
| [EnumDeclaration](../../-enum-declaration/-builder/index.md) |
| [InterfaceDeclaration](../../-interface-declaration/-builder/index.md) |
