//[Kores](../../../../index.md)/[com.koresframework.kores.base](../../index.md)/[AnonymousClass](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [TypeDeclaration.Builder](../../-type-declaration/-builder/index.md)<[AnonymousClass](../index.md), [AnonymousClass.Builder](index.md)> , [SuperClassHolder.Builder](../../-super-class-holder/-builder/index.md)<[AnonymousClass](../index.md), [AnonymousClass.Builder](index.md)> , [ArgumentsHolder.Builder](../../-arguments-holder/-builder/index.md)<[AnonymousClass](../index.md), [AnonymousClass.Builder](index.md)> , [ImplementationHolder.Builder](../../-implementation-holder/-builder/index.md)<[AnonymousClass](../index.md), [AnonymousClass.Builder](index.md)> , [ConstructorsHolder.Builder](../../-constructors-holder/-builder/index.md)<[AnonymousClass](../index.md), [AnonymousClass.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [AnonymousClass](../index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [annotations](../../-annotable/-builder/annotations.md) | [jvm]<br>open fun [annotations](../../-annotable/-builder/annotations.md)(vararg values: [Annotation](../../-annotation/index.md)): [AnonymousClass.Builder](index.md)<br>open override fun [annotations](annotations.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Annotation](../../-annotation/index.md)>): [AnonymousClass.Builder](index.md)<br>See T. |
| [arguments](arguments.md) | [jvm]<br>open override fun [arguments](arguments.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../../com.koresframework.kores/-instruction/index.md)>): [AnonymousClass.Builder](index.md)<br>open fun [arguments](../../-arguments-holder/-builder/arguments.md)(vararg values: [Instruction](../../../com.koresframework.kores/-instruction/index.md)): [AnonymousClass.Builder](index.md)<br>See T. |
| [array](array.md) | [jvm]<br>open override fun [array](array.md)(value: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [AnonymousClass.Builder](index.md)<br>See T. |
| [base](../../-type-declaration/-builder/base.md) | [jvm]<br>open fun [base](../../-type-declaration/-builder/base.md)(typeRef: [TypeRef](../../../com.koresframework.kores.type/-type-ref/index.md)): [AnonymousClass.Builder](index.md)<br>Sets the name and outer type to values specified in [typeRef](../../-type-declaration/-builder/base.md) |
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [AnonymousClass](../index.md)<br>Build the object of type T. |
| [comments](comments.md) | [jvm]<br>open override fun [comments](comments.md)(value: [Comments](../../../com.koresframework.kores.base.comment/-comments/index.md)): [AnonymousClass.Builder](index.md)<br>See CommentHolder. |
| [constructorBody](constructor-body.md) | [jvm]<br>fun [constructorBody](constructor-body.md)(value: [Instructions](../../../com.koresframework.kores/-instructions/index.md)): [AnonymousClass.Builder](index.md)<br>See [AnonymousClass.constructorBody](../constructor-body.md) |
| [constructors](constructors.md) | [jvm]<br>open override fun [constructors](constructors.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[ConstructorDeclaration](../../-constructor-declaration/index.md)>): [AnonymousClass.Builder](index.md)<br>open fun [constructors](../../-constructors-holder/-builder/constructors.md)(value: [ConstructorDeclaration](../../-constructor-declaration/index.md)): [AnonymousClass.Builder](index.md)<br>open fun [constructors](../../-constructors-holder/-builder/constructors.md)(vararg values: [ConstructorDeclaration](../../-constructor-declaration/index.md)): [AnonymousClass.Builder](index.md)<br>See [ConstructorsHolder.constructors](../../-constructors-holder/constructors.md) |
| [constructorSpec](constructor-spec.md) | [jvm]<br>fun [constructorSpec](constructor-spec.md)(value: [TypeSpec](../../-type-spec/index.md)): [AnonymousClass.Builder](index.md)<br>See [AnonymousClass.constructorSpec](../constructor-spec.md) |
| [fields](fields.md) | [jvm]<br>open override fun [fields](fields.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[FieldDeclaration](../../-field-declaration/index.md)>): [AnonymousClass.Builder](index.md)<br>open fun [fields](../../-elements-holder/-builder/fields.md)(value: [FieldDeclaration](../../-field-declaration/index.md)): [AnonymousClass.Builder](index.md)<br>open fun [fields](../../-elements-holder/-builder/fields.md)(vararg values: [FieldDeclaration](../../-field-declaration/index.md)): [AnonymousClass.Builder](index.md)<br>See [ElementsHolder.fields](../../-elements-holder/fields.md) |
| [genericSignature](generic-signature.md) | [jvm]<br>open override fun [genericSignature](generic-signature.md)(value: [GenericSignature](../../../com.koresframework.kores.generic/-generic-signature/index.md)): [AnonymousClass.Builder](index.md)<br>See T. |
| [implementations](implementations.md) | [jvm]<br>open override fun [implementations](implementations.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)>): [AnonymousClass.Builder](index.md)<br>open fun [implementations](../../-implementation-holder/-builder/implementations.md)(vararg values: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [AnonymousClass.Builder](index.md)<br>See T. |
| [innerTypes](inner-types.md) | [jvm]<br>open override fun [innerTypes](inner-types.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[TypeDeclaration](../../-type-declaration/index.md)>): [AnonymousClass.Builder](index.md)<br>open fun [innerTypes](../../-inner-types-holder/-builder/inner-types.md)(vararg values: [TypeDeclaration](../../-type-declaration/index.md)): [AnonymousClass.Builder](index.md)<br>See [InnerTypesHolder.innerTypes](../../-inner-types-holder/inner-types.md) |
| [methods](methods.md) | [jvm]<br>open override fun [methods](methods.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[MethodDeclaration](../../-method-declaration/index.md)>): [AnonymousClass.Builder](index.md)<br>open fun [methods](../../-elements-holder/-builder/methods.md)(value: [MethodDeclaration](../../-method-declaration/index.md)): [AnonymousClass.Builder](index.md)<br>open fun [methods](../../-elements-holder/-builder/methods.md)(vararg values: [MethodDeclaration](../../-method-declaration/index.md)): [AnonymousClass.Builder](index.md)<br>See [ElementsHolder.methods](../../-elements-holder/methods.md) |
| [modifiers](modifiers.md) | [jvm]<br>open override fun [modifiers](modifiers.md)(vararg values: [KoresModifier](../../-kores-modifier/index.md)): [AnonymousClass.Builder](index.md)<br>open override fun [modifiers](modifiers.md)(value: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[KoresModifier](../../-kores-modifier/index.md)>): [AnonymousClass.Builder](index.md)<br>See [ModifiersHolder.modifiers](../../-modifiers-holder/modifiers.md) |
| [name](../../-qualified-named/-builder/name.md) | [jvm]<br>open override fun [name](../../-qualified-named/-builder/name.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [AnonymousClass.Builder](index.md) |
| [outerType](outer-type.md) | [jvm]<br>open override fun [outerType](outer-type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)?): [AnonymousClass.Builder](index.md)<br>See [TypeDeclaration.outerType](../../-type-declaration/outer-type.md) |
| [publicModifier](../../-modifiers-holder/-builder/public-modifier.md) | [jvm]<br>open fun [publicModifier](../../-modifiers-holder/-builder/public-modifier.md)(): [AnonymousClass.Builder](index.md)<br>Sets modifiers to [KoresModifier.PUBLIC](../../-kores-modifier/-p-u-b-l-i-c/index.md). |
| [qualifiedName](../../-type-declaration/-builder/qualified-name.md) | [jvm]<br>open override fun [qualifiedName](../../-type-declaration/-builder/qualified-name.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [AnonymousClass.Builder](index.md) |
| [specifiedName](specified-name.md) | [jvm]<br>open override fun [specifiedName](specified-name.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [AnonymousClass.Builder](index.md)<br>See [TypeDeclaration.specifiedName](../../-type-declaration/specified-name.md) |
| [staticBlock](static-block.md) | [jvm]<br>open override fun [staticBlock](static-block.md)(value: [StaticBlock](../../-static-block/index.md)): [AnonymousClass.Builder](index.md)<br>See [ElementsHolder.staticBlock](../../-elements-holder/static-block.md) |
| [superClass](super-class.md) | [jvm]<br>open override fun [superClass](super-class.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)?): [AnonymousClass.Builder](index.md)<br>See T. |

## Properties

| Name | Summary |
|---|---|
| [annotations](annotations.md) | [jvm]<br>var [annotations](annotations.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Annotation](../../-annotation/index.md)> |
| [arguments](arguments.md) | [jvm]<br>var [arguments](arguments.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../../com.koresframework.kores/-instruction/index.md)> |
| [comments](comments.md) | [jvm]<br>var [comments](comments.md): [Comments](../../../com.koresframework.kores.base.comment/-comments/index.md) |
| [constructorBody](constructor-body.md) | [jvm]<br>lateinit var [constructorBody](constructor-body.md): [Instructions](../../../com.koresframework.kores/-instructions/index.md) |
| [constructors](constructors.md) | [jvm]<br>var [constructors](constructors.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[ConstructorDeclaration](../../-constructor-declaration/index.md)> |
| [constructorSpec](constructor-spec.md) | [jvm]<br>lateinit var [constructorSpec](constructor-spec.md): [TypeSpec](../../-type-spec/index.md) |
| [fields](fields.md) | [jvm]<br>var [fields](fields.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[FieldDeclaration](../../-field-declaration/index.md)> |
| [implementations](implementations.md) | [jvm]<br>var [implementations](implementations.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)> |
| [innerTypes](inner-types.md) | [jvm]<br>var [innerTypes](inner-types.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[TypeDeclaration](../../-type-declaration/index.md)> |
| [methods](methods.md) | [jvm]<br>var [methods](methods.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[MethodDeclaration](../../-method-declaration/index.md)> |
| [outerClass](outer-class.md) | [jvm]<br>var [outerClass](outer-class.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)? = null |
| [specifiedName](specified-name.md) | [jvm]<br>lateinit var [specifiedName](specified-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [staticBlock](static-block.md) | [jvm]<br>var [staticBlock](static-block.md): [StaticBlock](../../-static-block/index.md) |
| [superClass](super-class.md) | [jvm]<br>var [superClass](super-class.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) |
