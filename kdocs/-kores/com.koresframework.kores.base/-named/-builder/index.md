//[Kores](../../../../index.md)/[com.koresframework.kores.base](../../index.md)/[Named](../index.md)/[Builder](index.md)

# Builder

[jvm]\
interface [Builder](index.md)<out [T](index.md) : [Named](../index.md), [S](index.md) : [Named.Builder](index.md)<[T](index.md), [S](index.md)>> : [Builder](../../../com.koresframework.kores.builder/-builder/index.md)<[T](index.md), [S](index.md)>

## Functions

| Name | Summary |
|---|---|
| [build](../../../com.koresframework.kores.builder/-builder/build.md) | [jvm]<br>abstract fun [build](../../../com.koresframework.kores.builder/-builder/build.md)(): [T](index.md)<br>Build the object of type [T](../../../com.koresframework.kores.builder/-builder/index.md). |
| [name](name.md) | [jvm]<br>abstract fun [name](name.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [S](index.md) |

## Inheritors

| Name |
|---|
| [AnnotationProperty](../../-annotation-property/-builder/index.md) |
| [EnumEntry](../../-enum-entry/-builder/index.md) |
| [EnumValue](../../-enum-value/-builder/index.md) |
| [FieldAccess](../../-field-access/-builder/index.md) |
| [FieldBase](../../-field-base/-builder/index.md) |
| [FieldDeclaration](../../-field-declaration/-builder/index.md) |
| [KoresParameter](../../-kores-parameter/-builder/index.md) |
| [Label](../../-label/-builder/index.md) |
| [MethodDeclarationBase](../../-method-declaration-base/-builder/index.md) |
| [ModuleReference](../../-module-reference/-builder/index.md) |
| [ModuleDeclaration](../../-module-declaration/-builder/index.md) |
| [QualifiedNamed](../../-qualified-named/-builder/index.md) |
| [VariableBase](../../-variable-base/-builder/index.md) |
| [VariableDefinition](../../-variable-definition/-builder/index.md) |
| [DynamicMethodSpec](../../../com.koresframework.kores.common/-dynamic-method-spec/-builder/index.md) |
| [Operator](../../../com.koresframework.kores.operator/-operator/-builder/index.md) |
