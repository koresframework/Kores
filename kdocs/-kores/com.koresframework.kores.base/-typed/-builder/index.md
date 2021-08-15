//[Kores](../../../../index.md)/[com.koresframework.kores.base](../../index.md)/[Typed](../index.md)/[Builder](index.md)

# Builder

[jvm]\
interface [Builder](index.md)<out [T](index.md) : [Typed](../index.md), [S](index.md) : [Typed.Builder](index.md)<[T](index.md), [S](index.md)>> : [Builder](../../../com.koresframework.kores.builder/-builder/index.md)<[T](index.md), [S](index.md)>

## Functions

| Name | Summary |
|---|---|
| [build](../../../com.koresframework.kores.builder/-builder/build.md) | [jvm]<br>abstract fun [build](../../../com.koresframework.kores.builder/-builder/build.md)(): [T](index.md)<br>Build the object of type [T](../../../com.koresframework.kores.builder/-builder/index.md). |
| [type](type.md) | [jvm]<br>abstract fun [type](type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [S](index.md)<br>See T. |

## Inheritors

| Name |
|---|
| [Annotation](../../-annotation/-builder/index.md) |
| [AnnotationProperty](../../-annotation-property/-builder/index.md) |
| [ArrayConstructor](../../-array-constructor/-builder/index.md) |
| [ArrayLength](../../-array-length/-builder/index.md) |
| [ArrayLoad](../../-array-load/-builder/index.md) |
| [Case](../../-case/-builder/index.md) |
| [Cast](../../-cast/-builder/index.md) |
| [CatchStatement](../../-catch-statement/-builder/index.md) |
| [Concat](../../-concat/-builder/index.md) |
| [EnumValue](../../-enum-value/-builder/index.md) |
| [FieldAccess](../../-field-access/-builder/index.md) |
| [FieldBase](../../-field-base/-builder/index.md) |
| [FieldDeclaration](../../-field-declaration/-builder/index.md) |
| [InstanceOfCheck](../../-instance-of-check/-builder/index.md) |
| [InvokeDynamicBase](../../-invoke-dynamic-base/-builder/index.md) |
| [KoresParameter](../../-kores-parameter/-builder/index.md) |
| [Line.TypedLine](../../-line/-typed-line/-builder/index.md) |
| [MethodDeclarationBase](../../-method-declaration-base/-builder/index.md) |
| [MethodInvocation](../../-method-invocation/-builder/index.md) |
| [Operate](../../-operate/-builder/index.md) |
| [Return](../../-return/-builder/index.md) |
| [SwitchStatement](../../-switch-statement/-builder/index.md) |
| [TypeSpec](../../-type-spec/-builder/index.md) |
| [VariableBase](../../-variable-base/-builder/index.md) |
| [VariableDefinition](../../-variable-definition/-builder/index.md) |
| [DynamicConstantSpec](../../../com.koresframework.kores.common/-dynamic-constant-spec/-builder/index.md) |
| [DynamicMethodSpec](../../../com.koresframework.kores.common/-dynamic-method-spec/-builder/index.md) |
| [FieldAccessHandleSpec](../../../com.koresframework.kores.common/-field-access-handle-spec/-builder/index.md) |
| [FieldSpec](../../../com.koresframework.kores.common/-field-spec/-builder/index.md) |
| [FieldTypeSpec](../../../com.koresframework.kores.common/-field-type-spec/-builder/index.md) |
| [MethodInvokeHandleSpec](../../../com.koresframework.kores.common/-method-invoke-handle-spec/-builder/index.md) |
| [MethodInvokeSpec](../../../com.koresframework.kores.common/-method-invoke-spec/-builder/index.md) |
| [MethodSpec](../../../com.koresframework.kores.common/-method-spec/-builder/index.md) |
| [MethodTypeSpec](../../../com.koresframework.kores.common/-method-type-spec/-builder/index.md) |
| [Nothing](../../../com.koresframework.kores.common/-nothing/-builder/index.md) |
| [Void](../../../com.koresframework.kores.common/-void/-builder/index.md) |
