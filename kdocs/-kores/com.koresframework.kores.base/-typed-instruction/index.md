//[Kores](../../../index.md)/[com.koresframework.kores.base](../index.md)/[TypedInstruction](index.md)

# TypedInstruction

[jvm]\
interface [TypedInstruction](index.md) : [Typed](../-typed/index.md), [Instruction](../../com.koresframework.kores/-instruction/index.md)

A part that implements both: [Instruction](../../com.koresframework.kores/-instruction/index.md) and [Typed](../-typed/index.md).

## Functions

| Name | Summary |
|---|---|
| [builder](../-typed/builder.md) | [jvm]<br>abstract override fun [builder](../-typed/builder.md)(): [Typed.Builder](../-typed/-builder/index.md)<[Typed](../-typed/index.md), *><br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [type](index.md#1068653893%2FProperties%2F-1216412040) | [jvm]<br>abstract val [type](index.md#1068653893%2FProperties%2F-1216412040): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Element type |

## Inheritors

| Name |
|---|
| [ArrayConstructor](../-array-constructor/index.md) |
| [ArrayLength](../-array-length/index.md) |
| [ArrayLoad](../-array-load/index.md) |
| [Cast](../-cast/index.md) |
| [Concat](../-concat/index.md) |
| [EnumValue](../-enum-value/index.md) |
| [FieldAccess](../-field-access/index.md) |
| [InvokeDynamicBase](../-invoke-dynamic-base/index.md) |
| [MethodInvocation](../-method-invocation/index.md) |
| [Operate](../-operate/index.md) |
| [Return](../-return/index.md) |
| [SwitchStatement](../-switch-statement/index.md) |
| [VariableAccess](../-variable-access/index.md) |
| [VariableDeclaration](../-variable-declaration/index.md) |
| [VariableDefinition](../-variable-definition/index.md) |
| [Nothing](../../com.koresframework.kores.common/-nothing/index.md) |
| [Void](../../com.koresframework.kores.common/-void/index.md) |
| [Literal](../../com.koresframework.kores.literal/-literal/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [accessArrayValue](../../com.koresframework.kores.factory/access-array-value.md) | [jvm]<br>fun [TypedInstruction](index.md).[accessArrayValue](../../com.koresframework.kores.factory/access-array-value.md)(index: [Instruction](../../com.koresframework.kores/-instruction/index.md), valueType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [ArrayLoad](../-array-load/index.md) |
| [accessField](../../com.koresframework.kores.factory/access-field.md) | [jvm]<br>fun [TypedInstruction](index.md).[accessField](../../com.koresframework.kores.factory/access-field.md)(localization: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [FieldAccess](../-field-access/index.md)<br>Access field with [name](../../com.koresframework.kores.factory/access-field.md) and [type](index.md#1068653893%2FProperties%2F-1216412040) of [receiver](../../com.koresframework.kores/-instruction/index.md) in [localization](../../com.koresframework.kores.factory/access-field.md). |
| [arrayLength](../../com.koresframework.kores.factory/array-length.md) | [jvm]<br>fun [TypedInstruction](index.md).[arrayLength](../../com.koresframework.kores.factory/array-length.md)(): [ArrayLength](../-array-length/index.md)<br>Accesses the length of [receiver array](../../com.koresframework.kores/-instruction/index.md) of type arrayType. |
| [cast](../../com.koresframework.kores.factory/cast.md) | [jvm]<br>fun [TypedInstruction](index.md).[cast](../../com.koresframework.kores.factory/cast.md)(to: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Cast](../-cast/index.md)<br>Creates a cast of receiver from type from to type [to](../../com.koresframework.kores.factory/cast.md). |
| [invokeFieldGetter](../../com.koresframework.kores.factory/invoke-field-getter.md) | [jvm]<br>fun [TypedInstruction](index.md).[invokeFieldGetter](../../com.koresframework.kores.factory/invoke-field-getter.md)(invokeType: [InvokeType](../-invoke-type/index.md), localization: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [MethodInvocation](../-method-invocation/index.md)<br>Invoke getter of a field (get+capitalize(fieldName)) of [receiver](index.md) and [receiver type](index.md#1068653893%2FProperties%2F-1216412040). |
| [invokeFieldSetter](../../com.koresframework.kores.factory/invoke-field-setter.md) | [jvm]<br>fun [TypedInstruction](index.md).[invokeFieldSetter](../../com.koresframework.kores.factory/invoke-field-setter.md)(invokeType: [InvokeType](../-invoke-type/index.md), localization: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), value: [Instruction](../../com.koresframework.kores/-instruction/index.md)): [MethodInvocation](../-method-invocation/index.md)<br>Invoke setter of a field (set+capitalize(fieldName)) of [receiver](../../com.koresframework.kores/-instruction/index.md) of [receiver type](../../com.koresframework.kores/type.md) with [value](../../com.koresframework.kores.factory/invoke-field-setter.md). |
| [returnSelfValue](../../com.koresframework.kores.factory/return-self-value.md) | [jvm]<br>fun [TypedInstruction](index.md).[returnSelfValue](../../com.koresframework.kores.factory/return-self-value.md)(): [Return](../-return/index.md)<br>Creates a [Return](../-return/index.md) of receiver instruction of type [type](../../com.koresframework.kores/type.md). |
| [setArrayValue](../../com.koresframework.kores.factory/set-array-value.md) | [jvm]<br>fun [TypedInstruction](index.md).[setArrayValue](../../com.koresframework.kores.factory/set-array-value.md)(index: [Instruction](../../com.koresframework.kores/-instruction/index.md), valueType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), valueToStore: [Instruction](../../com.koresframework.kores/-instruction/index.md)): [ArrayStore](../-array-store/index.md)<br>Sets value at [index](../../com.koresframework.kores.factory/set-array-value.md) of [receiver array](index.md) of type [arrayType](index.md#1068653893%2FProperties%2F-1216412040) to [valueToStore](../../com.koresframework.kores.factory/set-array-value.md). |
| [setFieldValue](../../com.koresframework.kores.factory/set-field-value.md) | [jvm]<br>fun [TypedInstruction](index.md).[setFieldValue](../../com.koresframework.kores.factory/set-field-value.md)(localization: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), value: [Instruction](../../com.koresframework.kores/-instruction/index.md)): [FieldDefinition](../-field-definition/index.md)<br>Sets field [name](../../com.koresframework.kores.factory/set-field-value.md) of [receiver type](index.md#1068653893%2FProperties%2F-1216412040) of [receiver](index.md) in [localization](../../com.koresframework.kores.factory/set-field-value.md). |
| [setToThisFieldValue](../../com.koresframework.kores.factory/set-to-this-field-value.md) | [jvm]<br>fun [TypedInstruction](index.md).[setToThisFieldValue](../../com.koresframework.kores.factory/set-to-this-field-value.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [FieldDefinition](../-field-definition/index.md) |
