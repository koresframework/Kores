//[Kores](../../../index.md)/[com.github.jonathanxd.kores.base](../index.md)/[TypedInstruction](index.md)

# TypedInstruction

[jvm]\
interface [TypedInstruction](index.md) : [Typed](../-typed/index.md), [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)

A part that implements both: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md) and [Typed](../-typed/index.md).

## Functions

| Name | Summary |
|---|---|
| [builder](../-typed/builder.md) | [jvm]<br>abstract override fun [builder](../-typed/builder.md)(): [Typed.Builder](../-typed/-builder/index.md)<[Typed](../-typed/index.md), *><br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [type](index.md#1756091193%2FProperties%2F-1216412040) | [jvm]<br>abstract val [type](index.md#1756091193%2FProperties%2F-1216412040): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Element type |

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
| [Nothing](../../com.github.jonathanxd.kores.common/-nothing/index.md) |
| [Void](../../com.github.jonathanxd.kores.common/-void/index.md) |
| [Literal](../../com.github.jonathanxd.kores.literal/-literal/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [accessArrayValue](../../com.github.jonathanxd.kores.factory/access-array-value.md) | [jvm]<br>fun [TypedInstruction](index.md).[accessArrayValue](../../com.github.jonathanxd.kores.factory/access-array-value.md)(index: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), valueType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [ArrayLoad](../-array-load/index.md) |
| [accessField](../../com.github.jonathanxd.kores.factory/access-field.md) | [jvm]<br>fun [TypedInstruction](index.md).[accessField](../../com.github.jonathanxd.kores.factory/access-field.md)(localization: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [FieldAccess](../-field-access/index.md)<br>Access field with [name](../../com.github.jonathanxd.kores.factory/access-field.md) and [type](index.md#1756091193%2FProperties%2F-1216412040) of [receiver](../../com.github.jonathanxd.kores/-instruction/index.md) in [localization](../../com.github.jonathanxd.kores.factory/access-field.md). |
| [arrayLength](../../com.github.jonathanxd.kores.factory/array-length.md) | [jvm]<br>fun [TypedInstruction](index.md).[arrayLength](../../com.github.jonathanxd.kores.factory/array-length.md)(): [ArrayLength](../-array-length/index.md)<br>Accesses the length of [receiver array](../../com.github.jonathanxd.kores/-instruction/index.md) of type arrayType. |
| [cast](../../com.github.jonathanxd.kores.factory/cast.md) | [jvm]<br>fun [TypedInstruction](index.md).[cast](../../com.github.jonathanxd.kores.factory/cast.md)(to: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Cast](../-cast/index.md)<br>Creates a cast of receiver from type from to type [to](../../com.github.jonathanxd.kores.factory/cast.md). |
| [invokeFieldGetter](../../com.github.jonathanxd.kores.factory/invoke-field-getter.md) | [jvm]<br>fun [TypedInstruction](index.md).[invokeFieldGetter](../../com.github.jonathanxd.kores.factory/invoke-field-getter.md)(invokeType: [InvokeType](../-invoke-type/index.md), localization: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [MethodInvocation](../-method-invocation/index.md)<br>Invoke getter of a field (get+capitalize(fieldName)) of [receiver](index.md) and [receiver type](index.md#1756091193%2FProperties%2F-1216412040). |
| [invokeFieldSetter](../../com.github.jonathanxd.kores.factory/invoke-field-setter.md) | [jvm]<br>fun [TypedInstruction](index.md).[invokeFieldSetter](../../com.github.jonathanxd.kores.factory/invoke-field-setter.md)(invokeType: [InvokeType](../-invoke-type/index.md), localization: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), value: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)): [MethodInvocation](../-method-invocation/index.md)<br>Invoke setter of a field (set+capitalize(fieldName)) of [receiver](../../com.github.jonathanxd.kores/-instruction/index.md) of [receiver type](../../com.github.jonathanxd.kores/type.md) with [value](../../com.github.jonathanxd.kores.factory/invoke-field-setter.md). |
| [returnSelfValue](../../com.github.jonathanxd.kores.factory/return-self-value.md) | [jvm]<br>fun [TypedInstruction](index.md).[returnSelfValue](../../com.github.jonathanxd.kores.factory/return-self-value.md)(): [Return](../-return/index.md)<br>Creates a [Return](../-return/index.md) of receiver instruction of type [type](../../com.github.jonathanxd.kores/type.md). |
| [setArrayValue](../../com.github.jonathanxd.kores.factory/set-array-value.md) | [jvm]<br>fun [TypedInstruction](index.md).[setArrayValue](../../com.github.jonathanxd.kores.factory/set-array-value.md)(index: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md), valueType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), valueToStore: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)): [ArrayStore](../-array-store/index.md)<br>Sets value at [index](../../com.github.jonathanxd.kores.factory/set-array-value.md) of [receiver array](index.md) of type [arrayType](index.md#1756091193%2FProperties%2F-1216412040) to [valueToStore](../../com.github.jonathanxd.kores.factory/set-array-value.md). |
| [setFieldValue](../../com.github.jonathanxd.kores.factory/set-field-value.md) | [jvm]<br>fun [TypedInstruction](index.md).[setFieldValue](../../com.github.jonathanxd.kores.factory/set-field-value.md)(localization: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), value: [Instruction](../../com.github.jonathanxd.kores/-instruction/index.md)): [FieldDefinition](../-field-definition/index.md)<br>Sets field [name](../../com.github.jonathanxd.kores.factory/set-field-value.md) of [receiver type](index.md#1756091193%2FProperties%2F-1216412040) of [receiver](index.md) in [localization](../../com.github.jonathanxd.kores.factory/set-field-value.md). |
| [setToThisFieldValue](../../com.github.jonathanxd.kores.factory/set-to-this-field-value.md) | [jvm]<br>fun [TypedInstruction](index.md).[setToThisFieldValue](../../com.github.jonathanxd.kores.factory/set-to-this-field-value.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [FieldDefinition](../-field-definition/index.md) |
