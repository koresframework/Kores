//[Kores](../../index.md)/[com.github.jonathanxd.kores.util.conversion](index.md)/[toAccess](to-access.md)

# toAccess

[jvm]\
fun [Field](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Field.html).[toAccess](to-access.md)(target: [Instruction](../com.github.jonathanxd.kores/-instruction/index.md)?): [FieldAccess](../com.github.jonathanxd.kores.base/-field-access/index.md)

Create [FieldAccess](../com.github.jonathanxd.kores.base/-field-access/index.md) from [Field](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Field.html).

## Parameters

jvm

| | |
|---|---|
| target | Target of the field access, null (or static access) for static access. |

[jvm]\
fun [VariableElement](https://docs.oracle.com/javase/8/docs/api/javax/lang/model/element/VariableElement.html).[toAccess](to-access.md)(target: [Instruction](../com.github.jonathanxd.kores/-instruction/index.md)?, elements: [Elements](https://docs.oracle.com/javase/8/docs/api/javax/lang/model/util/Elements.html)): [FieldAccess](../com.github.jonathanxd.kores.base/-field-access/index.md)

Create [FieldAccess](../com.github.jonathanxd.kores.base/-field-access/index.md) from [VariableElement](https://docs.oracle.com/javase/8/docs/api/javax/lang/model/element/VariableElement.html).

## Parameters

jvm

| | |
|---|---|
| target | Target of the field access, null (or static access) for static access. |
