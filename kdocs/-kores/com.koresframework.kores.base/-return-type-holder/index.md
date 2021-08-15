//[Kores](../../../index.md)/[com.koresframework.kores.base](../index.md)/[ReturnTypeHolder](index.md)

# ReturnTypeHolder

[jvm]\
interface [ReturnTypeHolder](index.md) : [KoresPart](../../com.koresframework.kores/-kores-part/index.md)

Return type holder part

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>interface [Builder](-builder/index.md)<out [T](-builder/index.md) : [ReturnTypeHolder](index.md), [S](-builder/index.md) : [ReturnTypeHolder.Builder](-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>> : [Builder](../../com.koresframework.kores.builder/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>abstract override fun [builder](builder.md)(): [ReturnTypeHolder.Builder](-builder/index.md)<[ReturnTypeHolder](index.md), *><br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [returnType](return-type.md) | [jvm]<br>abstract val [returnType](return-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Type of return |

## Inheritors

| Name |
|---|
| [AnnotationProperty](../-annotation-property/index.md) |
| [MethodDeclarationBase](../-method-declaration-base/index.md) |
