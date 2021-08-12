//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[MethodDeclaration](index.md)

# MethodDeclaration

[jvm]\
data class [MethodDeclaration](index.md)(**comments**: [Comments](../../com.github.jonathanxd.kores.base.comment/-comments/index.md), **annotations**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Annotation](../-annotation/index.md)>, **modifiers**: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[KoresModifier](../-kores-modifier/index.md)>, **genericSignature**: [GenericSignature](../../com.github.jonathanxd.kores.generic/-generic-signature/index.md), **returnType**: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), **name**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), **parameters**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[KoresParameter](../-kores-parameter/index.md)>, **innerTypes**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[TypeDeclaration](../-type-declaration/index.md)>, **throwsClause**: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)>, **body**: [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)) : [MethodDeclarationBase](../-method-declaration-base/index.md)

Method declaration

## Constructors

| | |
|---|---|
| [MethodDeclaration](-method-declaration.md) | [jvm]<br>fun [MethodDeclaration](-method-declaration.md)(comments: [Comments](../../com.github.jonathanxd.kores.base.comment/-comments/index.md), annotations: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Annotation](../-annotation/index.md)>, modifiers: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[KoresModifier](../-kores-modifier/index.md)>, genericSignature: [GenericSignature](../../com.github.jonathanxd.kores.generic/-generic-signature/index.md), returnType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), parameters: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[KoresParameter](../-kores-parameter/index.md)>, innerTypes: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[TypeDeclaration](../-type-declaration/index.md)>, throwsClause: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)>, body: [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>class [Builder](-builder/index.md) : [MethodDeclarationBase.Builder](../-method-declaration-base/-builder/index.md)<[MethodDeclaration](index.md), [MethodDeclaration.Builder](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>open override fun [builder](builder.md)(): [MethodDeclaration.Builder](-builder/index.md)<br>This builder may or may not accept null values, it depends on implementation. |
| [getAnnotation](../-annotable/get-annotation.md) | [jvm]<br>open fun [getAnnotation](../-annotable/get-annotation.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Annotation](../-annotation/index.md)?<br>Gets the annotation of type [type](../-annotable/get-annotation.md) if present, or null otherwise. |
| [getDeclaredAnnotation](../-annotable/get-declared-annotation.md) | [jvm]<br>open fun [getDeclaredAnnotation](../-annotable/get-declared-annotation.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Annotation](../-annotation/index.md)?<br>Gets the annotation of type [type](../-annotable/get-declared-annotation.md) if present, or null otherwise. |
| [isAnnotationPresent](../-annotable/is-annotation-present.md) | [jvm]<br>open fun [isAnnotationPresent](../-annotable/is-annotation-present.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns whether this[Annotable](../-annotable/index.md) contains an annotation of specified [type](../-annotable/is-annotation-present.md). |

## Properties

| Name | Summary |
|---|---|
| [annotations](annotations.md) | [jvm]<br>open override val [annotations](annotations.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Annotation](../-annotation/index.md)><br>Annotations |
| [body](body.md) | [jvm]<br>open override val [body](body.md): [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)<br>Body. |
| [comments](comments.md) | [jvm]<br>open override val [comments](comments.md): [Comments](../../com.github.jonathanxd.kores.base.comment/-comments/index.md)<br>All comments of this element. |
| [genericSignature](generic-signature.md) | [jvm]<br>open override val [genericSignature](generic-signature.md): [GenericSignature](../../com.github.jonathanxd.kores.generic/-generic-signature/index.md)<br>Generic signature. |
| [innerTypes](inner-types.md) | [jvm]<br>open override val [innerTypes](inner-types.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[TypeDeclaration](../-type-declaration/index.md)><br>Inner types |
| [isPublic](index.md#-772413357%2FProperties%2F-1216412040) | [jvm]<br>open val [isPublic](index.md#-772413357%2FProperties%2F-1216412040): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if this part is public. |
| [modifiers](modifiers.md) | [jvm]<br>open override val [modifiers](modifiers.md): [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[KoresModifier](../-kores-modifier/index.md)><br>Modifiers. |
| [name](name.md) | [jvm]<br>open override val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Name |
| [parameters](parameters.md) | [jvm]<br>open override val [parameters](parameters.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[KoresParameter](../-kores-parameter/index.md)><br>Parameters |
| [returnType](return-type.md) | [jvm]<br>open override val [returnType](return-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Type of return |
| [throwsClause](throws-clause.md) | [jvm]<br>open override val [throwsClause](throws-clause.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)><br>Throws exception |
| [type](index.md#175685548%2FProperties%2F-1216412040) | [jvm]<br>open override val [type](index.md#175685548%2FProperties%2F-1216412040): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Element type |
| [typeSpec](index.md#1878802609%2FProperties%2F-1216412040) | [jvm]<br>open val [typeSpec](index.md#1878802609%2FProperties%2F-1216412040): [TypeSpec](../-type-spec/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [toRepresentation](../../com.github.jonathanxd.kores.util.conversion/to-representation.md) | [jvm]<br>fun [MethodDeclaration](index.md).[toRepresentation](../../com.github.jonathanxd.kores.util.conversion/to-representation.md)(): [MethodDeclaration](index.md) |
