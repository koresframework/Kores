//[Kores](../../../index.md)/[com.koresframework.kores.base](../index.md)/[ArrayAccess](index.md)

# ArrayAccess

[jvm]\
interface [ArrayAccess](index.md) : [KoresPart](../../com.koresframework.kores/-kores-part/index.md)

Access to an array.

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>interface [Builder](-builder/index.md)<out [T](-builder/index.md) : [ArrayAccess](index.md), [S](-builder/index.md) : [ArrayAccess.Builder](-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>> : [Builder](../../com.koresframework.kores.builder/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [builder](builder.md) | [jvm]<br>abstract override fun [builder](builder.md)(): [ArrayAccess.Builder](-builder/index.md)<[ArrayAccess](index.md), *><br>This builder may or may not accept null values, it depends on implementation. |

## Properties

| Name | Summary |
|---|---|
| [arrayType](array-type.md) | [jvm]<br>abstract val [arrayType](array-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Array type |
| [target](target.md) | [jvm]<br>abstract val [target](target.md): [Instruction](../../com.koresframework.kores/-instruction/index.md)<br>Target array to access |

## Inheritors

| Name |
|---|
| [ArrayLength](../-array-length/index.md) |
| [ArrayLoad](../-array-load/index.md) |
| [ArrayStore](../-array-store/index.md) |
