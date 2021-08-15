//[Kores](../../../index.md)/[com.koresframework.kores.base](../index.md)/[ValueHolder](index.md)

# ValueHolder

[jvm]\
interface [ValueHolder](index.md) : [KoresPart](../../com.koresframework.kores/-kores-part/index.md)

Value holder part

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>interface [Builder](-builder/index.md)<out [T](-builder/index.md) : [ValueHolder](index.md), [S](-builder/index.md) : [ValueHolder.Builder](-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>> : [Builder](../../com.koresframework.kores.builder/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>abstract override fun [builder](builder.md)(): [ValueHolder.Builder](-builder/index.md)<[ValueHolder](index.md), *><br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [value](value.md) | [jvm]<br>abstract val [value](value.md): [Instruction](../../com.koresframework.kores/-instruction/index.md)<br>Value |

## Inheritors

| Name |
|---|
| [ArrayStore](../-array-store/index.md) |
| [Case](../-case/index.md) |
| [FieldDeclaration](../-field-declaration/index.md) |
| [FieldDefinition](../-field-definition/index.md) |
| [Line](../-line/index.md) |
| [Operate](../-operate/index.md) |
| [Return](../-return/index.md) |
| [SwitchStatement](../-switch-statement/index.md) |
| [ThrowException](../-throw-exception/index.md) |
| [VariableDeclaration](../-variable-declaration/index.md) |
| [VariableDefinition](../-variable-definition/index.md) |
