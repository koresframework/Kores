//[Kores](../../index.md)/[com.github.jonathanxd.kores.factory](index.md)/[cast](cast.md)

# cast

[jvm]\
fun [cast](cast.md)(from: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)?, to: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), part: [Instruction](../com.github.jonathanxd.kores/-instruction/index.md)): [Cast](../com.github.jonathanxd.kores.base/-cast/index.md)

fun [cast](cast.md)(to: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html), part: [TypedInstruction](../com.github.jonathanxd.kores.base/-typed-instruction/index.md)): [Cast](../com.github.jonathanxd.kores.base/-cast/index.md)

## See also

jvm

| | |
|---|---|
| [com.github.jonathanxd.kores.base.Cast](../com.github.jonathanxd.kores.base/-cast/index.md) |  |

[jvm]\
fun [Instruction](../com.github.jonathanxd.kores/-instruction/index.md).[cast](cast.md)(from: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)?, to: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Cast](../com.github.jonathanxd.kores.base/-cast/index.md)

Creates a cast of receiver from type [from](cast.md) to type [to](cast.md).

[jvm]\
fun [TypedInstruction](../com.github.jonathanxd.kores.base/-typed-instruction/index.md).[cast](cast.md)(to: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Cast](../com.github.jonathanxd.kores.base/-cast/index.md)

Creates a cast of receiver from type from to type [to](cast.md).

[jvm]\
fun [cast](cast.md)(): [Cast.Builder](../com.github.jonathanxd.kores.base/-cast/-builder/index.md)
