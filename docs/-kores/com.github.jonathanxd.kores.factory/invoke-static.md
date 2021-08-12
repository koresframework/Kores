//[Kores](../../index.md)/[com.github.jonathanxd.kores.factory](index.md)/[invokeStatic](invoke-static.md)

# invokeStatic

[jvm]\
fun [invokeStatic](invoke-static.md)(localization: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), target: [Instruction](../com.github.jonathanxd.kores/-instruction/index.md), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), spec: [TypeSpec](../com.github.jonathanxd.kores.base/-type-spec/index.md), arguments: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../com.github.jonathanxd.kores/-instruction/index.md)>): [MethodInvocation](../com.github.jonathanxd.kores.base/-method-invocation/index.md)

## See also

jvm

| | |
|---|---|
| [com.github.jonathanxd.kores.base.MethodInvocation](../com.github.jonathanxd.kores.base/-method-invocation/index.md) |  |

[jvm]\
fun [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html).[invokeStatic](invoke-static.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), spec: [TypeSpec](../com.github.jonathanxd.kores.base/-type-spec/index.md), arguments: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)<[Instruction](../com.github.jonathanxd.kores/-instruction/index.md)>): [MethodInvocation](../com.github.jonathanxd.kores.base/-method-invocation/index.md)

fun [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html).[invokeStatic](invoke-static.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [MethodInvocation](../com.github.jonathanxd.kores.base/-method-invocation/index.md)

Invokes static method [name](invoke-static.md) of [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)
