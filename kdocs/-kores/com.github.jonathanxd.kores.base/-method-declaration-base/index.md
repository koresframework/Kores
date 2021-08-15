//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[MethodDeclarationBase](index.md)

# MethodDeclarationBase

[jvm]\
interface [MethodDeclarationBase](index.md) : [KoresElement](../../com.github.jonathanxd.kores/-kores-element/index.md), [ModifiersHolder](../-modifiers-holder/index.md), [ReturnTypeHolder](../-return-type-holder/index.md), [ParametersHolder](../-parameters-holder/index.md), [GenericSignatureHolder](../-generic-signature-holder/index.md), [Annotable](../-annotable/index.md), [Named](../-named/index.md), [Typed](../-typed/index.md), [CommentHolder](../../com.github.jonathanxd.kores.base.comment/-comment-holder/index.md), [BodyHolder](../-body-holder/index.md), [InnerTypesHolder](../-inner-types-holder/index.md), [ThrowsHolder](../-throws-holder/index.md)

Method declaration

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>interface [Builder](-builder/index.md)<out [T](-builder/index.md) : [MethodDeclarationBase](index.md), [S](-builder/index.md) : [MethodDeclarationBase.Builder](-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>> : [BodyHolder.Builder](../-body-holder/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> , [ModifiersHolder.Builder](../-modifiers-holder/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> , [ReturnTypeHolder.Builder](../-return-type-holder/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> , [ParametersHolder.Builder](../-parameters-holder/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> , [GenericSignatureHolder.Builder](../-generic-signature-holder/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> , [Annotable.Builder](../-annotable/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> , [Named.Builder](../-named/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> , [Typed.Builder](../-typed/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> , [CommentHolder.Builder](../../com.github.jonathanxd.kores.base.comment/-comment-holder/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> , [InnerTypesHolder.Builder](../-inner-types-holder/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> , [ThrowsHolder.Builder](../-throws-holder/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>abstract override fun [builder](builder.md)(): [MethodDeclarationBase.Builder](-builder/index.md)<[MethodDeclarationBase](index.md), *><br>This builder may or may not accept null values, it depends on implementation. |
| [getAnnotation](../-annotable/get-annotation.md) | [jvm]<br>open fun [getAnnotation](../-annotable/get-annotation.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Annotation](../-annotation/index.md)?<br>Gets the annotation of type [type](../-annotable/get-annotation.md) if present, or null otherwise. |
| [getDeclaredAnnotation](../-annotable/get-declared-annotation.md) | [jvm]<br>open fun [getDeclaredAnnotation](../-annotable/get-declared-annotation.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Annotation](../-annotation/index.md)?<br>Gets the annotation of type [type](../-annotable/get-declared-annotation.md) if present, or null otherwise. |
| [isAnnotationPresent](../-annotable/is-annotation-present.md) | [jvm]<br>open fun [isAnnotationPresent](../-annotable/is-annotation-present.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns whether this[Annotable](../-annotable/index.md) contains an annotation of specified [type](../-annotable/is-annotation-present.md). |

## Properties

| Name | Summary |
|---|---|
| [annotations](index.md#1745145535%2FProperties%2F-1216412040) | [jvm]<br>abstract val [annotations](index.md#1745145535%2FProperties%2F-1216412040): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Annotation](../-annotation/index.md)><br>Annotations |
| [body](index.md#-788529803%2FProperties%2F-1216412040) | [jvm]<br>abstract val [body](index.md#-788529803%2FProperties%2F-1216412040): [Instructions](../../com.github.jonathanxd.kores/-instructions/index.md)<br>Body. |
| [comments](index.md#-1293067165%2FProperties%2F-1216412040) | [jvm]<br>abstract val [comments](index.md#-1293067165%2FProperties%2F-1216412040): [Comments](../../com.github.jonathanxd.kores.base.comment/-comments/index.md)<br>All comments of this element. |
| [genericSignature](index.md#-1666245546%2FProperties%2F-1216412040) | [jvm]<br>abstract val [genericSignature](index.md#-1666245546%2FProperties%2F-1216412040): [GenericSignature](../../com.github.jonathanxd.kores.generic/-generic-signature/index.md)<br>Generic signature. |
| [innerTypes](index.md#-1733471500%2FProperties%2F-1216412040) | [jvm]<br>abstract val [innerTypes](index.md#-1733471500%2FProperties%2F-1216412040): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[TypeDeclaration](../-type-declaration/index.md)><br>Inner types |
| [isPublic](index.md#2082523908%2FProperties%2F-1216412040) | [jvm]<br>open val [isPublic](index.md#2082523908%2FProperties%2F-1216412040): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if this part is public. |
| [modifiers](index.md#713971175%2FProperties%2F-1216412040) | [jvm]<br>abstract val [modifiers](index.md#713971175%2FProperties%2F-1216412040): [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)<[KoresModifier](../-kores-modifier/index.md)><br>Modifiers. |
| [name](index.md#1949263020%2FProperties%2F-1216412040) | [jvm]<br>abstract val [name](index.md#1949263020%2FProperties%2F-1216412040): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Name |
| [parameters](index.md#-1994777939%2FProperties%2F-1216412040) | [jvm]<br>abstract val [parameters](index.md#-1994777939%2FProperties%2F-1216412040): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[KoresParameter](../-kores-parameter/index.md)><br>Parameters |
| [returnType](return-type.md) | [jvm]<br>abstract override val [returnType](return-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Type of return |
| [throwsClause](index.md#-1792665541%2FProperties%2F-1216412040) | [jvm]<br>abstract val [throwsClause](index.md#-1792665541%2FProperties%2F-1216412040): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)><br>Throws exception |
| [type](type.md) | [jvm]<br>open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Element type |
| [typeSpec](type-spec.md) | [jvm]<br>open val [typeSpec](type-spec.md): [TypeSpec](../-type-spec/index.md) |

## Inheritors

| Name |
|---|
| [ConstructorDeclaration](../-constructor-declaration/index.md) |
| [MethodDeclaration](../-method-declaration/index.md) |
| [StaticBlock](../-static-block/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [methodGenericSignature](../../com.github.jonathanxd.kores.util/method-generic-signature.md) | [jvm]<br>fun [MethodDeclarationBase](index.md).[methodGenericSignature](../../com.github.jonathanxd.kores.util/method-generic-signature.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>Creates method descriptor from receiver. |
