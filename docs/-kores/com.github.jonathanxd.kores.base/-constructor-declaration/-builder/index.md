//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.base](../../index.md)/[ConstructorDeclaration](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [MethodDeclarationBase.Builder](../../-method-declaration-base/-builder/index.md)<[ConstructorDeclaration](../index.md), [ConstructorDeclaration.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [ConstructorDeclaration](../index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [annotations](../../-annotable/-builder/annotations.md) | [jvm]<br>open fun [annotations](../../-annotable/-builder/annotations.md)(vararg values: [Annotation](../../-annotation/index.md)): [ConstructorDeclaration.Builder](index.md)<br>open override fun [annotations](annotations.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Annotation](../../-annotation/index.md)>): [ConstructorDeclaration.Builder](index.md)<br>See T. |
| [body](body.md) | [jvm]<br>open override fun [body](body.md)(value: [Instructions](../../../com.github.jonathanxd.kores/-instructions/index.md)): [ConstructorDeclaration.Builder](index.md)<br>See T. |
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [ConstructorDeclaration](../index.md)<br>Build the object of type [T](../../../com.github.jonathanxd.kores.builder/-builder/index.md). |
| [comments](comments.md) | [jvm]<br>open override fun [comments](comments.md)(value: [Comments](../../../com.github.jonathanxd.kores.base.comment/-comments/index.md)): [ConstructorDeclaration.Builder](index.md)<br>See CommentHolder. |
| [genericSignature](generic-signature.md) | [jvm]<br>open override fun [genericSignature](generic-signature.md)(value: [GenericSignature](../../../com.github.jonathanxd.kores.generic/-generic-signature/index.md)): [ConstructorDeclaration.Builder](index.md)<br>See T. |
| [innerTypes](inner-types.md) | [jvm]<br>open override fun [innerTypes](inner-types.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[TypeDeclaration](../../-type-declaration/index.md)>): [ConstructorDeclaration.Builder](index.md)<br>open fun [innerTypes](../../-inner-types-holder/-builder/inner-types.md)(vararg values: [TypeDeclaration](../../-type-declaration/index.md)): [ConstructorDeclaration.Builder](index.md)<br>See [InnerTypesHolder.innerTypes](../../-inner-types-holder/inner-types.md) |
| [modifiers](modifiers.md) | [jvm]<br>open override fun [modifiers](modifiers.md)(value: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[KoresModifier](../../-kores-modifier/index.md)>): [ConstructorDeclaration.Builder](index.md)<br>open fun [modifiers](../../-modifiers-holder/-builder/modifiers.md)(vararg values: [KoresModifier](../../-kores-modifier/index.md)): [ConstructorDeclaration.Builder](index.md)<br>See [ModifiersHolder.modifiers](../../-modifiers-holder/modifiers.md) |
| [name](name.md) | [jvm]<br>open override fun [name](name.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ConstructorDeclaration.Builder](index.md) |
| [parameters](parameters.md) | [jvm]<br>open override fun [parameters](parameters.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[KoresParameter](../../-kores-parameter/index.md)>): [ConstructorDeclaration.Builder](index.md)<br>open fun [parameters](../../-parameters-holder/-builder/parameters.md)(vararg values: [KoresParameter](../../-kores-parameter/index.md)): [ConstructorDeclaration.Builder](index.md)<br>See T. |
| [publicModifier](../../-modifiers-holder/-builder/public-modifier.md) | [jvm]<br>open fun [publicModifier](../../-modifiers-holder/-builder/public-modifier.md)(): [ConstructorDeclaration.Builder](index.md)<br>Sets modifiers to [KoresModifier.PUBLIC](../../-kores-modifier/-p-u-b-l-i-c/index.md). |
| [returnType](return-type.md) | [jvm]<br>open override fun [returnType](return-type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [ConstructorDeclaration.Builder](index.md)<br>See T. |
| [throwsClause](throws-clause.md) | [jvm]<br>open override fun [throwsClause](throws-clause.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)>): [ConstructorDeclaration.Builder](index.md)<br>open fun [throwsClause](../../-throws-holder/-builder/throws-clause.md)(vararg values: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [ConstructorDeclaration.Builder](index.md)<br>See [ThrowsHolder.throwsClause](../../-throws-holder/throws-clause.md) |
| [type](../../-method-declaration-base/-builder/type.md) | [jvm]<br>open override fun [type](../../-method-declaration-base/-builder/type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [ConstructorDeclaration.Builder](index.md)<br>See T. |

## Properties

| Name | Summary |
|---|---|
| [annotations](annotations.md) | [jvm]<br>var [annotations](annotations.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Annotation](../../-annotation/index.md)> |
| [body](body.md) | [jvm]<br>var [body](body.md): [Instructions](../../../com.github.jonathanxd.kores/-instructions/index.md) |
| [comments](comments.md) | [jvm]<br>var [comments](comments.md): [Comments](../../../com.github.jonathanxd.kores.base.comment/-comments/index.md) |
| [genericSignature](generic-signature.md) | [jvm]<br>var [genericSignature](generic-signature.md): [GenericSignature](../../../com.github.jonathanxd.kores.generic/-generic-signature/index.md) |
| [innerTypes](inner-types.md) | [jvm]<br>var [innerTypes](inner-types.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[TypeDeclaration](../../-type-declaration/index.md)> |
| [modifiers](modifiers.md) | [jvm]<br>var [modifiers](modifiers.md): [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[KoresModifier](../../-kores-modifier/index.md)> |
| [parameters](parameters.md) | [jvm]<br>var [parameters](parameters.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[KoresParameter](../../-kores-parameter/index.md)> |
| [throws](throws.md) | [jvm]<br>var [throws](throws.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)> |
