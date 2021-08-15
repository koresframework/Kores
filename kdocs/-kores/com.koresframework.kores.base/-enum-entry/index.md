//[Kores](../../../index.md)/[com.koresframework.kores.base](../index.md)/[EnumEntry](index.md)

# EnumEntry

[jvm]\
data class [EnumEntry](index.md)(**annotations**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Annotation](../-annotation/index.md)>, **name**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **constructorSpec**: [TypeSpec](../-type-spec/index.md)?, **arguments**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.koresframework.kores/-instruction/index.md)>, **staticBlock**: [StaticBlock](../-static-block/index.md), **fields**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[FieldDeclaration](../-field-declaration/index.md)>, **methods**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[MethodDeclaration](../-method-declaration/index.md)>, **innerTypes**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[TypeDeclaration](../-type-declaration/index.md)>) : [Annotable](../-annotable/index.md), [ArgumentsHolder](../-arguments-holder/index.md), [Named](../-named/index.md), [ElementsHolder](../-elements-holder/index.md)

Enumeration entry.

## Constructors

| | |
|---|---|
| [EnumEntry](-enum-entry.md) | [jvm]<br>fun [EnumEntry](-enum-entry.md)(annotations: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Annotation](../-annotation/index.md)>, name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), constructorSpec: [TypeSpec](../-type-spec/index.md)?, arguments: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.koresframework.kores/-instruction/index.md)>, staticBlock: [StaticBlock](../-static-block/index.md), fields: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[FieldDeclaration](../-field-declaration/index.md)>, methods: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[MethodDeclaration](../-method-declaration/index.md)>, innerTypes: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[TypeDeclaration](../-type-declaration/index.md)>) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [Annotable.Builder](../-annotable/-builder/index.md)<[EnumEntry](index.md), [EnumEntry.Builder](-builder/index.md)> , [ArgumentsHolder.Builder](../-arguments-holder/-builder/index.md)<[EnumEntry](index.md), [EnumEntry.Builder](-builder/index.md)> , [Named.Builder](../-named/-builder/index.md)<[EnumEntry](index.md), [EnumEntry.Builder](-builder/index.md)> , [ElementsHolder.Builder](../-elements-holder/-builder/index.md)<[EnumEntry](index.md), [EnumEntry.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [EnumEntry.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |
| [getAnnotation](../-annotable/get-annotation.md) | [jvm]<br>open fun [getAnnotation](../-annotable/get-annotation.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Annotation](../-annotation/index.md)?<br>Gets the annotation of type [type](../-annotable/get-annotation.md) if present, or null otherwise. |
| [getDeclaredAnnotation](../-annotable/get-declared-annotation.md) | [jvm]<br>open fun [getDeclaredAnnotation](../-annotable/get-declared-annotation.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Annotation](../-annotation/index.md)?<br>Gets the annotation of type [type](../-annotable/get-declared-annotation.md) if present, or null otherwise. |
| [isAnnotationPresent](../-annotable/is-annotation-present.md) | [jvm]<br>open fun [isAnnotationPresent](../-annotable/is-annotation-present.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns whether this[Annotable](../-annotable/index.md) contains an annotation of specified [type](../-annotable/is-annotation-present.md). |

## Properties

| Name | Summary |
|---|---|
| [annotations](annotations.md) | [jvm]<br>open override val [annotations](annotations.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Annotation](../-annotation/index.md)><br>Annotations |
| [arguments](arguments.md) | [jvm]<br>open override val [arguments](arguments.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../../com.koresframework.kores/-instruction/index.md)><br>Enum constructor arguments |
| [array](array.md) | [jvm]<br>open override val [array](array.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Array arguments |
| [constructorSpec](constructor-spec.md) | [jvm]<br>val [constructorSpec](constructor-spec.md): [TypeSpec](../-type-spec/index.md)?<br>Enum constructor specification. |
| [fields](fields.md) | [jvm]<br>open override val [fields](fields.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[FieldDeclaration](../-field-declaration/index.md)><br>Fields of the type. |
| [innerTypes](inner-types.md) | [jvm]<br>open override val [innerTypes](inner-types.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[TypeDeclaration](../-type-declaration/index.md)><br>Inner types |
| [methods](methods.md) | [jvm]<br>open override val [methods](methods.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[MethodDeclaration](../-method-declaration/index.md)><br>Methods of type |
| [name](name.md) | [jvm]<br>open override val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Name |
| [staticBlock](static-block.md) | [jvm]<br>open override val [staticBlock](static-block.md): [StaticBlock](../-static-block/index.md)<br>Static block |
| [types](types.md) | [jvm]<br>open override val [types](types.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)><br>Expected types of each argument |

## Extensions

| Name | Summary |
|---|---|
| [hasDeclarations](../has-declarations.md) | [jvm]<br>val [EnumEntry](index.md).[hasDeclarations](../has-declarations.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns whether the [EnumEntry](index.md) has any declaration inside (requires a new type to be created or a body). |
| [toRepresentation](../../com.koresframework.kores.util.conversion/to-representation.md) | [jvm]<br>fun [EnumEntry](index.md).[toRepresentation](../../com.koresframework.kores.util.conversion/to-representation.md)(): [EnumEntry](index.md) |
