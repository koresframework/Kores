//[Kores](../../index.md)/[com.github.jonathanxd.kores.factory](index.md)/[invokeFieldGetter](invoke-field-getter.md)

# invokeFieldGetter

[jvm]\
fun [invokeFieldGetter](invoke-field-getter.md)(invokeType: [InvokeType](../com.github.jonathanxd.kores.base/-invoke-type/index.md), localization: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), target: [Instruction](../com.github.jonathanxd.kores/-instruction/index.md), type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [MethodInvocation](../com.github.jonathanxd.kores.base/-method-invocation/index.md)

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
fun [Instruction](../com.github.jonathanxd.kores/-instruction/index.md).[invokeFieldGetter](invoke-field-getter.md)(invokeType: [InvokeType](../com.github.jonathanxd.kores.base/-invoke-type/index.md), localization: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [MethodInvocation](../com.github.jonathanxd.kores.base/-method-invocation/index.md)

Invoke getter of a field (get+capitalize(fieldName)) of [receiver](../com.github.jonathanxd.kores/-instruction/index.md).

## Parameters

jvm

| | |
|---|---|
| invokeType | Type of invocation |
| localization | Localization of getter |
| type | Type of field. |
| name | Name of field. |

[jvm]\
fun [TypedInstruction](../com.github.jonathanxd.kores.base/-typed-instruction/index.md).[invokeFieldGetter](invoke-field-getter.md)(invokeType: [InvokeType](../com.github.jonathanxd.kores.base/-invoke-type/index.md), localization: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [MethodInvocation](../com.github.jonathanxd.kores.base/-method-invocation/index.md)

Invoke getter of a field (get+capitalize(fieldName)) of [receiver](../com.github.jonathanxd.kores.base/-typed-instruction/index.md) and [receiver type](../com.github.jonathanxd.kores.base/-typed-instruction/index.md#1756091193%2FProperties%2F-1216412040).

## Parameters

jvm

| | |
|---|---|
| invokeType | Type of invocation |
| localization | Localization of getter |
| type | Type of field. |
| name | Name of field. |
