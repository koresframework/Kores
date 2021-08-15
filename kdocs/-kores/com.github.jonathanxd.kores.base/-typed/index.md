//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[Typed](index.md)

# Typed

[jvm]\
interface [Typed](index.md) : [KoresPart](../../com.github.jonathanxd.kores/-kores-part/index.md)

A element that can have a type.

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>interface [Builder](-builder/index.md)<out [T](-builder/index.md) : [Typed](index.md), [S](-builder/index.md) : [Typed.Builder](-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>> : [Builder](../../com.github.jonathanxd.kores.builder/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>abstract override fun [builder](builder.md)(): [Typed.Builder](-builder/index.md)<[Typed](index.md), *><br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [type](type.md) | [jvm]<br>abstract val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Element type |

## Inheritors

| Name |
|---|
| [Annotation](../-annotation/index.md) |
| [AnnotationProperty](../-annotation-property/index.md) |
| [Case](../-case/index.md) |
| [CatchStatement](../-catch-statement/index.md) |
| [FieldBase](../-field-base/index.md) |
| [FieldDeclaration](../-field-declaration/index.md) |
| [InstanceOfCheck](../-instance-of-check/index.md) |
| [KoresParameter](../-kores-parameter/index.md) |
| [Line](../-line/-typed-line/index.md) |
| [MethodDeclarationBase](../-method-declaration-base/index.md) |
| [TypeSpec](../-type-spec/index.md) |
| [TypedInstruction](../-typed-instruction/index.md) |
| [VariableBase](../-variable-base/index.md) |
| [DynamicConstantSpec](../../com.github.jonathanxd.kores.common/-dynamic-constant-spec/index.md) |
| [DynamicMethodSpec](../../com.github.jonathanxd.kores.common/-dynamic-method-spec/index.md) |
| [FieldAccessHandleSpec](../../com.github.jonathanxd.kores.common/-field-access-handle-spec/index.md) |
| [FieldSpec](../../com.github.jonathanxd.kores.common/-field-spec/index.md) |
| [FieldTypeSpec](../../com.github.jonathanxd.kores.common/-field-type-spec/index.md) |
| [MethodInvokeHandleSpec](../../com.github.jonathanxd.kores.common/-method-invoke-handle-spec/index.md) |
| [MethodInvokeSpec](../../com.github.jonathanxd.kores.common/-method-invoke-spec/index.md) |
| [MethodSpec](../../com.github.jonathanxd.kores.common/-method-spec/index.md) |
| [MethodTypeSpec](../../com.github.jonathanxd.kores.common/-method-type-spec/index.md) |
