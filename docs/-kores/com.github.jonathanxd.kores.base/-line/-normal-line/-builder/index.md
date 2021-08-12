//[Kores](../../../../../index.md)/[com.github.jonathanxd.kores.base](../../../index.md)/[Line](../../index.md)/[NormalLine](../index.md)/[Builder](index.md)

# Builder

[jvm]\
class [Builder](index.md) : [Line.Builder](../../-builder/index.md)<[Line.NormalLine](../index.md), [Line.NormalLine.Builder](index.md)>

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [jvm]<br>fun [Builder](-builder.md)(defaults: [Line.NormalLine](../index.md)) |

## Functions

| Name | Summary |
|---|---|
| [build](build.md) | [jvm]<br>open override fun [build](build.md)(): [Line.NormalLine](../index.md)<br>Build the object of type T. |
| [line](line.md) | [jvm]<br>open override fun [line](line.md)(value: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Line.NormalLine.Builder](index.md)<br>See [Line.line](../../line.md) |
| [value](value.md) | [jvm]<br>open override fun [value](value.md)(value: [Instruction](../../../../com.github.jonathanxd.kores/-instruction/index.md)): [Line.NormalLine.Builder](index.md)<br>See T. |

## Properties

| Name | Summary |
|---|---|
| [line](line.md) | [jvm]<br>var [line](line.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [value](value.md) | [jvm]<br>lateinit var [value](value.md): [Instruction](../../../../com.github.jonathanxd.kores/-instruction/index.md) |
