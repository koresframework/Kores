//[Kores](../../../../index.md)/[com.github.jonathanxd.kores.base](../../index.md)/[Cast](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [Typed.Builder](../../-typed/-builder/index.md)<[Cast](../index.md), [Cast.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [Cast](../index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [Cast](../index.md)<br>Build the object of type T. |
| [instruction](instruction.md) | [jvm]<br>fun [instruction](instruction.md)(value: [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md)): [Cast.Builder](index.md)<br>See [Cast.instruction](../instruction.md) |
| [originalType](original-type.md) | [jvm]<br>fun [originalType](original-type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)?): [Cast.Builder](index.md)<br>See [Cast.originalType](../original-type.md) |
| [targetType](target-type.md) | [jvm]<br>fun [targetType](target-type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Cast.Builder](index.md)<br>See [Cast.targetType](../target-type.md) |
| [type](type.md) | [jvm]<br>open override fun [type](type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Cast.Builder](index.md)<br>See T. |

## Properties

| Name | Summary |
|---|---|
| [castedPart](casted-part.md) | [jvm]<br>lateinit var [castedPart](casted-part.md): [Instruction](../../../com.github.jonathanxd.kores/-instruction/index.md) |
| [originalType](original-type.md) | [jvm]<br>var [originalType](original-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)? = null |
| [targetType](target-type.md) | [jvm]<br>lateinit var [targetType](target-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) |
