//[Kores](../../index.md)/[com.koresframework.kores.factory](index.md)/[invokeFieldSetter](invoke-field-setter.md)

# invokeFieldSetter

[jvm]\
fun [invokeFieldSetter](invoke-field-setter.md)(invokeType: [InvokeType](../com.koresframework.kores.base/-invoke-type/index.md), localization: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), target: [Instruction](../com.koresframework.kores/-instruction/index.md), type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), value: [Instruction](../com.koresframework.kores/-instruction/index.md)): [MethodInvocation](../com.koresframework.kores.base/-method-invocation/index.md)

Invoke setter of a field (set+capitalize(fieldName)) with [value](invoke-field-setter.md).

## Parameters

jvm

| | |
|---|---|
| invokeType | Type of invocation |
| localization | Localization of setter |
| target | Target of invocation |
| type | Type of field. |
| name | Name of field. |
| value | Value to pass to setter |

[jvm]\
fun [Instruction](../com.koresframework.kores/-instruction/index.md).[invokeFieldSetter](invoke-field-setter.md)(invokeType: [InvokeType](../com.koresframework.kores.base/-invoke-type/index.md), localization: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), value: [Instruction](../com.koresframework.kores/-instruction/index.md)): [MethodInvocation](../com.koresframework.kores.base/-method-invocation/index.md)

Invoke setter of a field (set+capitalize(fieldName)) of [receiver](../com.koresframework.kores/-instruction/index.md) with [value](invoke-field-setter.md).

## Parameters

jvm

| | |
|---|---|
| invokeType | Type of invocation |
| localization | Localization of setter |
| type | Type of field. |
| name | Name of field. |
| value | Value to pass to setter |

[jvm]\
fun [TypedInstruction](../com.koresframework.kores.base/-typed-instruction/index.md).[invokeFieldSetter](invoke-field-setter.md)(invokeType: [InvokeType](../com.koresframework.kores.base/-invoke-type/index.md), localization: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), value: [Instruction](../com.koresframework.kores/-instruction/index.md)): [MethodInvocation](../com.koresframework.kores.base/-method-invocation/index.md)

Invoke setter of a field (set+capitalize(fieldName)) of [receiver](../com.koresframework.kores/-instruction/index.md) of [receiver type](../com.koresframework.kores/type.md) with [value](invoke-field-setter.md).

## Parameters

jvm

| | |
|---|---|
| invokeType | Type of invocation |
| localization | Localization of setter |
| type | Type of field. |
| name | Name of field. |
| value | Value to pass to setter |
