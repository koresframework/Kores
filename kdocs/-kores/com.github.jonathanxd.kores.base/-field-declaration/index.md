//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[FieldDeclaration](index.md)

# FieldDeclaration

[jvm]\
data class [FieldDeclaration](index.md)(**comments**: [Comments](../../com.github.jonathanxd.kores.base.comment/-comments/index.md), **annotations**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Annotation](../-annotation/index.md)>, **modifiers**: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[KoresModifier](../-kores-modifier/index.md)>, **type**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), **name**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **innerTypes**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[TypeDeclaration](../-type-declaration/index.md)>, **value**: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)) : [KoresElement](../../com.github.jonathanxd.kores/-kores-element/index.md), [FieldBase](../-field-base/index.md), [Named](../-named/index.md), [Typed](../-typed/index.md), [ValueHolder](../-value-holder/index.md), [ModifiersHolder](../-modifiers-holder/index.md), [Annotable](../-annotable/index.md), [CommentHolder](../../com.github.jonathanxd.kores.base.comment/-comment-holder/index.md), [InnerTypesHolder](../-inner-types-holder/index.md)

Declaration of a field.

## Constructors

| | |
|---|---|
| [FieldDeclaration](-field-declaration.md) | [jvm]<br>fun [FieldDeclaration](-field-declaration.md)(comments: [Comments](../../com.github.jonathanxd.kores.base.comment/-comments/index.md), annotations: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Annotation](../-annotation/index.md)>, modifiers: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[KoresModifier](../-kores-modifier/index.md)>, type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), innerTypes: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[TypeDeclaration](../-type-declaration/index.md)>, value: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [FieldBase.Builder](../-field-base/-builder/index.md)<[FieldDeclaration](index.md), [FieldDeclaration.Builder](-builder/index.md)> , [Named.Builder](../-named/-builder/index.md)<[FieldDeclaration](index.md), [FieldDeclaration.Builder](-builder/index.md)> , [Typed.Builder](../-typed/-builder/index.md)<[FieldDeclaration](index.md), [FieldDeclaration.Builder](-builder/index.md)> , [ValueHolder.Builder](../-value-holder/-builder/index.md)<[FieldDeclaration](index.md), [FieldDeclaration.Builder](-builder/index.md)> , [ModifiersHolder.Builder](../-modifiers-holder/-builder/index.md)<[FieldDeclaration](index.md), [FieldDeclaration.Builder](-builder/index.md)> , [Annotable.Builder](../-annotable/-builder/index.md)<[FieldDeclaration](index.md), [FieldDeclaration.Builder](-builder/index.md)> , [CommentHolder.Builder](../../com.github.jonathanxd.kores.base.comment/-comment-holder/-builder/index.md)<[FieldDeclaration](index.md), [FieldDeclaration.Builder](-builder/index.md)> , [InnerTypesHolder.Builder](../-inner-types-holder/-builder/index.md)<[FieldDeclaration](index.md), [FieldDeclaration.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [access](../-field-base/access.md) | [jvm]<br>open fun [access](../-field-base/access.md)(): [FieldAccess](../-field-access/index.md)<br>Creates access to the field that this instance represents. |
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [FieldDeclaration.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |
| [getAnnotation](../-annotable/get-annotation.md) | [jvm]<br>open fun [getAnnotation](../-annotable/get-annotation.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Annotation](../-annotation/index.md)?<br>Gets the annotation of type [type](../-annotable/get-annotation.md) if present, or null otherwise. |
| [getDeclaredAnnotation](../-annotable/get-declared-annotation.md) | [jvm]<br>open fun [getDeclaredAnnotation](../-annotable/get-declared-annotation.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Annotation](../-annotation/index.md)?<br>Gets the annotation of type [type](../-annotable/get-declared-annotation.md) if present, or null otherwise. |
| [isAnnotationPresent](../-annotable/is-annotation-present.md) | [jvm]<br>open fun [isAnnotationPresent](../-annotable/is-annotation-present.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns whether this[Annotable](../-annotable/index.md) contains an annotation of specified [type](../-annotable/is-annotation-present.md). |
| [set](../-field-base/set.md) | [jvm]<br>open fun [set](../-field-base/set.md)(value: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)): [FieldDefinition](../-field-definition/index.md)<br>Creates a definition of the value of the field that this instance represents. |

## Properties

| Name | Summary |
|---|---|
| [annotations](annotations.md) | [jvm]<br>open override val [annotations](annotations.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Annotation](../-annotation/index.md)><br>Annotations |
| [comments](comments.md) | [jvm]<br>open override val [comments](comments.md): [Comments](../../com.github.jonathanxd.kores.base.comment/-comments/index.md)<br>All comments of this element. |
| [innerTypes](inner-types.md) | [jvm]<br>open override val [innerTypes](inner-types.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[TypeDeclaration](../-type-declaration/index.md)><br>Inner types |
| [isPublic](index.md#540613820%2FProperties%2F-1216412040) | [jvm]<br>open val [isPublic](index.md#540613820%2FProperties%2F-1216412040): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if this part is public. |
| [localization](localization.md) | [jvm]<br>open override val [localization](localization.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Field localization. |
| [modifiers](modifiers.md) | [jvm]<br>open override val [modifiers](modifiers.md): [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[KoresModifier](../-kores-modifier/index.md)><br>Modifiers. |
| [name](name.md) | [jvm]<br>open override val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Name |
| [target](target.md) | [jvm]<br>open override val [target](target.md): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)<br>Target of the access |
| [type](type.md) | [jvm]<br>open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Element type |
| [value](value.md) | [jvm]<br>open override val [value](value.md): [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)<br>Value |

## Extensions

| Name | Summary |
|---|---|
| [toRepresentation](../../com.github.jonathanxd.kores.util.conversion/to-representation.md) | [jvm]<br>fun [FieldDeclaration](index.md).[toRepresentation](../../com.github.jonathanxd.kores.util.conversion/to-representation.md)(): [FieldDeclaration](index.md) |
