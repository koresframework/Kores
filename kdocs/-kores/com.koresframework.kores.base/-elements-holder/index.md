//[Kores](../../../index.md)/[com.koresframework.kores.base](../index.md)/[ElementsHolder](index.md)

# ElementsHolder

[jvm]\
interface [ElementsHolder](index.md) : [InnerTypesHolder](../-inner-types-holder/index.md)

Holder of some elements.

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>interface [Builder](-builder/index.md)<out [T](-builder/index.md) : [ElementsHolder](index.md), [S](-builder/index.md) : [ElementsHolder.Builder](-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>> : [InnerTypesHolder.Builder](../-inner-types-holder/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>abstract override fun [builder](builder.md)(): [ElementsHolder.Builder](-builder/index.md)<[ElementsHolder](index.md), *><br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [fields](fields.md) | [jvm]<br>abstract val [fields](fields.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[FieldDeclaration](../-field-declaration/index.md)><br>Fields of the type. |
| [innerTypes](index.md#1232382683%2FProperties%2F-1216412040) | [jvm]<br>abstract val [innerTypes](index.md#1232382683%2FProperties%2F-1216412040): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[TypeDeclaration](../-type-declaration/index.md)><br>Inner types |
| [methods](methods.md) | [jvm]<br>abstract val [methods](methods.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[MethodDeclaration](../-method-declaration/index.md)><br>Methods of type |
| [staticBlock](static-block.md) | [jvm]<br>abstract val [staticBlock](static-block.md): [StaticBlock](../-static-block/index.md)<br>Static block |

## Inheritors

| Name |
|---|
| [EnumEntry](../-enum-entry/index.md) |
| [TypeDeclaration](../-type-declaration/index.md) |
