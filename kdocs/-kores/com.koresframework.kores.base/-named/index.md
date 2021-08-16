//[Kores](../../../index.md)/[com.koresframework.kores.base](../index.md)/[Named](index.md)

# Named

[jvm]\
interface [Named](index.md) : [KoresPart](../../com.koresframework.kores/-kores-part/index.md)

A element that have a name.

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>interface [Builder](-builder/index.md)<out [T](-builder/index.md) : [Named](index.md), [S](-builder/index.md) : [Named.Builder](-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>> : [Builder](../../com.koresframework.kores.builder/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>abstract override fun [builder](builder.md)(): [Named.Builder](-builder/index.md)<[Named](index.md), *><br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [name](name.md) | [jvm]<br>abstract val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Name |

## Inheritors

| Name |
|---|
| [AnnotationProperty](../-annotation-property/index.md) |
| [EnumEntry](../-enum-entry/index.md) |
| [EnumValue](../-enum-value/index.md) |
| [FieldAccess](../-field-access/index.md) |
| [FieldBase](../-field-base/index.md) |
| [FieldDeclaration](../-field-declaration/index.md) |
| [KoresParameter](../-kores-parameter/index.md) |
| [Label](../-label/index.md) |
| [MethodDeclarationBase](../-method-declaration-base/index.md) |
| [ModuleReference](../-module-reference/index.md) |
| [ModuleDeclaration](../-module-declaration/index.md) |
| [QualifiedNamed](../-qualified-named/index.md) |
| [VariableBase](../-variable-base/index.md) |
| [VariableDefinition](../-variable-definition/index.md) |
| [DynamicDescriptor](../../com.koresframework.kores.common/-dynamic-descriptor/index.md) |
| [DynamicMethodSpec](../../com.koresframework.kores.common/-dynamic-method-spec/index.md) |
| [DynamicTypeSpec](../../com.koresframework.kores.common/-dynamic-type-spec/index.md) |
| [Literal](../../com.koresframework.kores.literal/-literal/index.md) |
| [Operator](../../com.koresframework.kores.operator/-operator/index.md) |
