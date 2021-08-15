//[Kores](../../index.md)/[com.github.jonathanxd.kores.factory](index.md)/[invoke](invoke.md)

# invoke

[jvm]\
fun [invoke](invoke.md)(invokeType: [InvokeType](../com.github.jonathanxd.kores.base/-invoke-type/index.md), localization: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), target: [Instruction](../com.github.jonathanxd.kores/-instruction/index.md), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), spec: [TypeSpec](../com.github.jonathanxd.kores.base/-type-spec/index.md), arguments: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../com.github.jonathanxd.kores/-instruction/index.md)>): [MethodInvocation](../com.github.jonathanxd.kores.base/-method-invocation/index.md)

Invoke a method with signature [spec](invoke.md) and [name](invoke.md) of class [localization](invoke.md) using instance [target](invoke.md) with [arguments](invoke.md).

## See also

jvm

| | |
|---|---|
| [com.github.jonathanxd.kores.base.InvokeType](../com.github.jonathanxd.kores.base/-invoke-type/index.md) |  |
| [com.github.jonathanxd.kores.base.MethodInvocation](../com.github.jonathanxd.kores.base/-method-invocation/index.md) |  |

[jvm]\
fun [Instruction](../com.github.jonathanxd.kores/-instruction/index.md).[invoke](invoke.md)(invokeType: [InvokeType](../com.github.jonathanxd.kores.base/-invoke-type/index.md), localization: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), spec: [TypeSpec](../com.github.jonathanxd.kores.base/-type-spec/index.md), arguments: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../com.github.jonathanxd.kores/-instruction/index.md)>): [MethodInvocation](../com.github.jonathanxd.kores.base/-method-invocation/index.md)

Invokes method on [receiver](../com.github.jonathanxd.kores/-instruction/index.md).
