//[Kores](../../../../index.md)/[com.koresframework.kores.base](../../index.md)/[ArrayAccess](../index.md)/[Builder](index.md)

# Builder

[jvm]\
interface [Builder](index.md)<out [T](index.md) : [ArrayAccess](../index.md), [S](index.md) : [ArrayAccess.Builder](index.md)<[T](index.md), [S](index.md)>> : [Builder](../../../com.koresframework.kores.builder/-builder/index.md)<[T](index.md), [S](index.md)>

## Functions

| Name | Summary |
|---|---|
| [arrayType](array-type.md) | [jvm]<br>abstract fun [arrayType](array-type.md)(value: [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)): [S](index.md)<br>See T. |
| [build](../../../com.koresframework.kores.builder/-builder/build.md) | [jvm]<br>abstract fun [build](../../../com.koresframework.kores.builder/-builder/build.md)(): [T](index.md)<br>Build the object of type [T](../../../com.koresframework.kores.builder/-builder/index.md). |
| [target](target.md) | [jvm]<br>abstract fun [target](target.md)(value: [Instruction](../../../com.koresframework.kores/-instruction/index.md)): [S](index.md)<br>See T. |

## Inheritors

| Name |
|---|
| [ArrayLength](../../-array-length/-builder/index.md) |
| [ArrayLoad](../../-array-load/-builder/index.md) |
| [ArrayStore](../../-array-store/-builder/index.md) |
