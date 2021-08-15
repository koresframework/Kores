//[Kores](../../../index.md)/[com.koresframework.kores.base](../index.md)/[KoresParameter](index.md)

# KoresParameter

[jvm]\
data class [KoresParameter](index.md)(**annotations**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Annotation](../-annotation/index.md)>, **modifiers**: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[KoresModifier](../-kores-modifier/index.md)>, **type**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), **name**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [Typed](../-typed/index.md), [Named](../-named/index.md), [Annotable](../-annotable/index.md), [ModifiersHolder](../-modifiers-holder/index.md)

Parameter part.

## Constructors

| | |
|---|---|
| [KoresParameter](-kores-parameter.md) | [jvm]<br>fun [KoresParameter](-kores-parameter.md)(annotations: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Annotation](../-annotation/index.md)>, modifiers: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[KoresModifier](../-kores-modifier/index.md)>, type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [Named.Builder](../-named/-builder/index.md)<[KoresParameter](index.md), [KoresParameter.Builder](-builder/index.md)> , [Typed.Builder](../-typed/-builder/index.md)<[KoresParameter](index.md), [KoresParameter.Builder](-builder/index.md)> , [Annotable.Builder](../-annotable/-builder/index.md)<[KoresParameter](index.md), [KoresParameter.Builder](-builder/index.md)> , [ModifiersHolder.Builder](../-modifiers-holder/-builder/index.md)<[KoresParameter](index.md), [KoresParameter.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [KoresParameter.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |
| [getAnnotation](../-annotable/get-annotation.md) | [jvm]<br>open fun [getAnnotation](../-annotable/get-annotation.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Annotation](../-annotation/index.md)?<br>Gets the annotation of type [type](../-annotable/get-annotation.md) if present, or null otherwise. |
| [getDeclaredAnnotation](../-annotable/get-declared-annotation.md) | [jvm]<br>open fun [getDeclaredAnnotation](../-annotable/get-declared-annotation.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Annotation](../-annotation/index.md)?<br>Gets the annotation of type [type](../-annotable/get-declared-annotation.md) if present, or null otherwise. |
| [isAnnotationPresent](../-annotable/is-annotation-present.md) | [jvm]<br>open fun [isAnnotationPresent](../-annotable/is-annotation-present.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns whether this[Annotable](../-annotable/index.md) contains an annotation of specified [type](../-annotable/is-annotation-present.md). |

## Properties

| Name | Summary |
|---|---|
| [annotations](annotations.md) | [jvm]<br>open override val [annotations](annotations.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Annotation](../-annotation/index.md)><br>Annotations |
| [isPublic](index.md#2002419445%2FProperties%2F-1216412040) | [jvm]<br>open val [isPublic](index.md#2002419445%2FProperties%2F-1216412040): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if this part is public. |
| [modifiers](modifiers.md) | [jvm]<br>open override val [modifiers](modifiers.md): [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[KoresModifier](../-kores-modifier/index.md)><br>Modifiers. |
| [name](name.md) | [jvm]<br>open override val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Name |
| [type](type.md) | [jvm]<br>open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Element type |

## Extensions

| Name | Summary |
|---|---|
| [access](../../com.koresframework.kores.util.conversion/access.md) | [jvm]<br>val [KoresParameter](index.md).[access](../../com.koresframework.kores.util.conversion/access.md): [Instruction](../../com.koresframework.kores/-instruction/index.md)<br>Convert [KoresParameter](index.md) to variable access |
| [toRepresentation](../../com.koresframework.kores.util.conversion/to-representation.md) | [jvm]<br>fun [KoresParameter](index.md).[toRepresentation](../../com.koresframework.kores.util.conversion/to-representation.md)(): [KoresParameter](index.md) |
| [toVariableAccess](../../com.koresframework.kores.util.conversion/to-variable-access.md) | [jvm]<br>fun [KoresParameter](index.md).[toVariableAccess](../../com.koresframework.kores.util.conversion/to-variable-access.md)(): [VariableAccess](../-variable-access/index.md) |
