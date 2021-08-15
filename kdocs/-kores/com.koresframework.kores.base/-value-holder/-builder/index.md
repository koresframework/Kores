//[Kores](../../../../index.md)/[com.koresframework.kores.base](../../index.md)/[ValueHolder](../index.md)/[Builder](index.md)

# Builder

[jvm]\
interface [Builder](index.md)<out [T](index.md) : [ValueHolder](../index.md), [S](index.md) : [ValueHolder.Builder](index.md)<[T](index.md), [S](index.md)>> : [Builder](../../../com.koresframework.kores.builder/-builder/index.md)<[T](index.md), [S](index.md)>

## Functions

| Name | Summary |
|---|---|
| [build](../../../com.koresframework.kores.builder/-builder/build.md) | [jvm]<br>abstract fun [build](../../../com.koresframework.kores.builder/-builder/build.md)(): [T](index.md)<br>Build the object of type [T](../../../com.koresframework.kores.builder/-builder/index.md). |
| [value](value.md) | [jvm]<br>abstract fun [value](value.md)(value: [Instruction](../../../com.koresframework.kores/-instruction/index.md)): [S](index.md)<br>See T. |

## Inheritors

| Name |
|---|
| [ArrayStore](../../-array-store/-builder/index.md) |
| [Case](../../-case/-builder/index.md) |
| [FieldDeclaration](../../-field-declaration/-builder/index.md) |
| [FieldDefinition](../../-field-definition/-builder/index.md) |
| [Line](../../-line/-builder/index.md) |
| [Operate](../../-operate/-builder/index.md) |
| [Return](../../-return/-builder/index.md) |
| [SwitchStatement](../../-switch-statement/-builder/index.md) |
| [ThrowException](../../-throw-exception/-builder/index.md) |
| [VariableDeclaration](../../-variable-declaration/-builder/index.md) |
| [VariableDefinition](../../-variable-definition/-builder/index.md) |
