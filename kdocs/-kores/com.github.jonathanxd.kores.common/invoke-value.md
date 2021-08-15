//[Kores](../../index.md)/[com.github.jonathanxd.kores.common](index.md)/[invokeValue](invoke-value.md)

# invokeValue

[jvm]\
fun [Instruction](../com.github.jonathanxd.kores/-instruction/index.md).[invokeValue](invoke-value.md)(type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [MethodInvocation](../com.github.jonathanxd.kores.base/-method-invocation/index.md)

Invokes X Y.nValue() virtual method of [type](invoke-value.md) with receiver [Instruction](../com.github.jonathanxd.kores/-instruction/index.md).

Where X is the primitive type of [type](invoke-value.md), Y is the wrapper type of [type](invoke-value.md) and n is the de-capitalized simple name of [type](invoke-value.md).

[jvm]\
fun [Instruction](../com.github.jonathanxd.kores/-instruction/index.md).[invokeValue](invoke-value.md)(base: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), type: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [MethodInvocation](../com.github.jonathanxd.kores.base/-method-invocation/index.md)

Invokes X Y.nValue() virtual method of [base type](invoke-value.md) with receiver [Instruction](../com.github.jonathanxd.kores/-instruction/index.md).

Where X is the primitive type of [type](invoke-value.md), Y is the wrapper type of [base](invoke-value.md) and n is the de-capitalized simple name of [type](invoke-value.md).

Used in cases like int Byte.intValue().
