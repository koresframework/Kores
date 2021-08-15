//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.base](../../index.md)/[FieldDeclaration](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [FieldBase.Builder](../../-field-base/-builder/index.md)<[FieldDeclaration](../index.md), [FieldDeclaration.Builder](index.md)> , [Named.Builder](../../-named/-builder/index.md)<[FieldDeclaration](../index.md), [FieldDeclaration.Builder](index.md)> , [Typed.Builder](../../-typed/-builder/index.md)<[FieldDeclaration](../index.md), [FieldDeclaration.Builder](index.md)> , [ValueHolder.Builder](../../-value-holder/-builder/index.md)<[FieldDeclaration](../index.md), [FieldDeclaration.Builder](index.md)> , [ModifiersHolder.Builder](../../-modifiers-holder/-builder/index.md)<[FieldDeclaration](../index.md), [FieldDeclaration.Builder](index.md)> , [Annotable.Builder](../../-annotable/-builder/index.md)<[FieldDeclaration](../index.md), [FieldDeclaration.Builder](index.md)> , [CommentHolder.Builder](../../../com.github.jonathanxd.kores.base.comment/-comment-holder/-builder/index.md)<[FieldDeclaration](../index.md), [FieldDeclaration.Builder](index.md)> , [InnerTypesHolder.Builder](../../-inner-types-holder/-builder/index.md)<[FieldDeclaration](../index.md), [FieldDeclaration.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [FieldDeclaration](../index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [annotations](../../-annotable/-builder/annotations.md) | [jvm]<br>open fun [annotations](../../-annotable/-builder/annotations.md)(vararg values: [Annotation](../../-annotation/index.md)): [FieldDeclaration.Builder](index.md)<br>open override fun [annotations](annotations.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Annotation](../../-annotation/index.md)>): [FieldDeclaration.Builder](index.md)<br>See T. |
| [base](../../-field-base/-builder/base.md) | [jvm]<br>open fun [base](../../-field-base/-builder/base.md)(fieldRef: [FieldRef](../../../com.github.jonathanxd.kores.common/-field-ref/index.md)): [FieldDeclaration.Builder](index.md)<br>Base this builder on [fieldRef](../../-field-base/-builder/base.md).<br>[jvm]<br>open fun [base](../../-field-base/-builder/base.md)(variableRef: [VariableRef](../../../com.github.jonathanxd.kores.common/-variable-ref/index.md)): [FieldDeclaration.Builder](index.md)<br>Base this builder on [variableRef](../../-field-base/-builder/base.md). |
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [FieldDeclaration](../index.md)<br>Build the object of type T. |
| [comments](comments.md) | [jvm]<br>open override fun [comments](comments.md)(value: [Comments](../../../com.github.jonathanxd.kores.base.comment/-comments/index.md)): [FieldDeclaration.Builder](index.md)<br>See [CommentHolder.comments](../../../com.github.jonathanxd.kores.base.comment/-comment-holder/comments.md) |
| [innerTypes](inner-types.md) | [jvm]<br>open override fun [innerTypes](inner-types.md)(value: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[TypeDeclaration](../../-type-declaration/index.md)>): [FieldDeclaration.Builder](index.md)<br>open fun [innerTypes](../../-inner-types-holder/-builder/inner-types.md)(vararg values: [TypeDeclaration](../../-type-declaration/index.md)): [FieldDeclaration.Builder](index.md)<br>See [InnerTypesHolder.innerTypes](../../-inner-types-holder/inner-types.md) |
| [localization](localization.md) | [jvm]<br>open override fun [localization](localization.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [FieldDeclaration.Builder](index.md)<br>See T. |
| [modifiers](modifiers.md) | [jvm]<br>open override fun [modifiers](modifiers.md)(value: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[KoresModifier](../../-kores-modifier/index.md)>): [FieldDeclaration.Builder](index.md)<br>open fun [modifiers](../../-modifiers-holder/-builder/modifiers.md)(vararg values: [KoresModifier](../../-kores-modifier/index.md)): [FieldDeclaration.Builder](index.md)<br>See [ModifiersHolder.modifiers](../../-modifiers-holder/modifiers.md) |
| [name](name.md) | [jvm]<br>open override fun [name](name.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [FieldDeclaration.Builder](index.md) |
| [publicModifier](../../-modifiers-holder/-builder/public-modifier.md) | [jvm]<br>open fun [publicModifier](../../-modifiers-holder/-builder/public-modifier.md)(): [FieldDeclaration.Builder](index.md)<br>Sets modifiers to [KoresModifier.PUBLIC](../../-kores-modifier/-p-u-b-l-i-c/index.md). |
| [target](target.md) | [jvm]<br>open override fun [target](target.md)(value: [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)): [FieldDeclaration.Builder](index.md)<br>See T. |
| [type](type.md) | [jvm]<br>open override fun [type](type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [FieldDeclaration.Builder](index.md)<br>See T. |
| [value](value.md) | [jvm]<br>open override fun [value](value.md)(value: [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)): [FieldDeclaration.Builder](index.md)<br>See T. |
| [withoutValue](without-value.md) | [jvm]<br>fun [withoutValue](without-value.md)(): [FieldDeclaration.Builder](index.md)<br>Removes value definition |

## Properties

| Name | Summary |
|---|---|
| [annotations](annotations.md) | [jvm]<br>var [annotations](annotations.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Annotation](../../-annotation/index.md)> |
| [comments](comments.md) | [jvm]<br>var [comments](comments.md): [Comments](../../../com.github.jonathanxd.kores.base.comment/-comments/index.md) |
| [innerTypes](inner-types.md) | [jvm]<br>var [innerTypes](inner-types.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[TypeDeclaration](../../-type-declaration/index.md)> |
| [modifiers](modifiers.md) | [jvm]<br>var [modifiers](modifiers.md): [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[KoresModifier](../../-kores-modifier/index.md)> |
| [name](name.md) | [jvm]<br>lateinit var [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [type](type.md) | [jvm]<br>lateinit var [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) |
| [value](value.md) | [jvm]<br>var [value](value.md): [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md) |
