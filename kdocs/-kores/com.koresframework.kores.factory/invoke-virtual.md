//[Kores](../../index.md)/[com.koresframework.kores.factory](index.md)/[invokeVirtual](invoke-virtual.md)

# invokeVirtual

[jvm]\
fun [invokeVirtual](invoke-virtual.md)(localization: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), target: [Instruction](../com.koresframework.kores/-instruction/index.md), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), spec: [TypeSpec](../com.koresframework.kores.base/-type-spec/index.md), arguments: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../com.koresframework.kores/-instruction/index.md)>): [MethodInvocation](../com.koresframework.kores.base/-method-invocation/index.md)

## See also

jvm

| | |
|---|---|
| [com.koresframework.kores.base.MethodInvocation](../com.koresframework.kores.base/-method-invocation/index.md) |  |

[jvm]\
fun [Instruction](../com.koresframework.kores/-instruction/index.md).[invokeVirtual](invoke-virtual.md)(localization: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), spec: [TypeSpec](../com.koresframework.kores.base/-type-spec/index.md), arguments: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../com.koresframework.kores/-instruction/index.md)>): [MethodInvocation](../com.koresframework.kores.base/-method-invocation/index.md)

Invokes method on [receiver](../com.koresframework.kores/-instruction/index.md).
