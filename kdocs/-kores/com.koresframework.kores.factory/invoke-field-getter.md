//[Kores](../../index.md)/[com.koresframework.kores.factory](index.md)/[invokeFieldGetter](invoke-field-getter.md)

# invokeFieldGetter

[jvm]\
fun [invokeFieldGetter](invoke-field-getter.md)(invokeType: [InvokeType](../com.koresframework.kores.base/-invoke-type/index.md), localization: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), target: [Instruction](../com.koresframework.kores/-instruction/index.md), type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [MethodInvocation](../com.koresframework.kores.base/-method-invocation/index.md)

Invoke getter of a field (get+capitalize(fieldName)).

## Parameters

jvm

| | |
|---|---|
| invokeType | Type of invocation |
| localization | Localization of getter |
| target | Target of invocation |
| type | Type of field. |
| name | Name of field. |

[jvm]\
fun [Instruction](../com.koresframework.kores/-instruction/index.md).[invokeFieldGetter](invoke-field-getter.md)(invokeType: [InvokeType](../com.koresframework.kores.base/-invoke-type/index.md), localization: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [MethodInvocation](../com.koresframework.kores.base/-method-invocation/index.md)

Invoke getter of a field (get+capitalize(fieldName)) of [receiver](../com.koresframework.kores/-instruction/index.md).

## Parameters

jvm

| | |
|---|---|
| invokeType | Type of invocation |
| localization | Localization of getter |
| type | Type of field. |
| name | Name of field. |

[jvm]\
fun [TypedInstruction](../com.koresframework.kores.base/-typed-instruction/index.md).[invokeFieldGetter](invoke-field-getter.md)(invokeType: [InvokeType](../com.koresframework.kores.base/-invoke-type/index.md), localization: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [MethodInvocation](../com.koresframework.kores.base/-method-invocation/index.md)

Invoke getter of a field (get+capitalize(fieldName)) of [receiver](../com.koresframework.kores.base/-typed-instruction/index.md) and [receiver type](../com.koresframework.kores.base/-typed-instruction/index.md#1068653893%2FProperties%2F-1216412040).

## Parameters

jvm

| | |
|---|---|
| invokeType | Type of invocation |
| localization | Localization of getter |
| type | Type of field. |
| name | Name of field. |
