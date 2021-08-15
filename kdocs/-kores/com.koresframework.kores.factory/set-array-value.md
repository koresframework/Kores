//[Kores](../../index.md)/[com.koresframework.kores.factory](index.md)/[setArrayValue](set-array-value.md)

# setArrayValue

[jvm]\
fun [setArrayValue](set-array-value.md)(arrayType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), target: [Instruction](../com.koresframework.kores/-instruction/index.md), index: [Instruction](../com.koresframework.kores/-instruction/index.md), valueType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), valueToStore: [Instruction](../com.koresframework.kores/-instruction/index.md)): [ArrayStore](../com.koresframework.kores.base/-array-store/index.md)

## See also

jvm

| | |
|---|---|
| [com.koresframework.kores.base.ArrayStore](../com.koresframework.kores.base/-array-store/index.md) |  |

[jvm]\
fun [Instruction](../com.koresframework.kores/-instruction/index.md).[setArrayValue](set-array-value.md)(arrayType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), index: [Instruction](../com.koresframework.kores/-instruction/index.md), valueType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), valueToStore: [Instruction](../com.koresframework.kores/-instruction/index.md)): [ArrayStore](../com.koresframework.kores.base/-array-store/index.md)

Sets value at [index](set-array-value.md) of [receiver array](../com.koresframework.kores/-instruction/index.md) of type [arrayType](set-array-value.md) to [valueToStore](set-array-value.md).

## See also

jvm

| | |
|---|---|
| [com.koresframework.kores.base.ArrayStore](../com.koresframework.kores.base/-array-store/index.md) |  |

[jvm]\
fun [TypedInstruction](../com.koresframework.kores.base/-typed-instruction/index.md).[setArrayValue](set-array-value.md)(index: [Instruction](../com.koresframework.kores/-instruction/index.md), valueType: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), valueToStore: [Instruction](../com.koresframework.kores/-instruction/index.md)): [ArrayStore](../com.koresframework.kores.base/-array-store/index.md)

Sets value at [index](set-array-value.md) of [receiver array](../com.koresframework.kores.base/-typed-instruction/index.md) of type [arrayType](../com.koresframework.kores.base/-typed-instruction/index.md#1068653893%2FProperties%2F-1216412040) to [valueToStore](set-array-value.md).

## See also

jvm

| | |
|---|---|
| [com.koresframework.kores.base.ArrayStore](../com.koresframework.kores.base/-array-store/index.md) |  |
