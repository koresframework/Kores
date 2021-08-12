//[Kores](../../../../../index.md)/[com.github.jonathanxd.kores.base](../../../index.md)/[Line](../../index.md)/[TypedLine](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [Line.Builder](../../-builder/index.md)<[Line.TypedLine](../index.md), [Line.TypedLine.Builder](index.md)> , [Typed.Builder](../../../-typed/-builder/index.md)<[Line.TypedLine](../index.md), [Line.TypedLine.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [Line.TypedLine](../index.md)) |

## Functions

| Name | Summary |
|---|---|
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [Line.TypedLine](../index.md)<br>Build the object of type T. |
| [line](line.md) | [jvm]<br>open override fun [line](line.md)(value: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Line.TypedLine.Builder](index.md)<br>See [Line.line](../../line.md) |
| [type](type.md) | [jvm]<br>open override fun [type](type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [Line.TypedLine.Builder](index.md)<br>See T. |
| [value](value.md) | [jvm]<br>open override fun [value](value.md)(value: [Instruction](../../../../com.github.jonathanxd.kores/-instruction/index.md)): [Line.TypedLine.Builder](index.md)<br>See T. |

## Properties

| Name | Summary |
|---|---|
| [line](line.md) | [jvm]<br>var [line](line.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [type](type.md) | [jvm]<br>lateinit var [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html) |
| [value](value.md) | [jvm]<br>lateinit var [value](value.md): [Instruction](../../../../com.github.jonathanxd.kores/-instruction/index.md) |
