//[Kores](../../../index.md)/[com.koresframework.kores.base](../index.md)/[VariableBase](index.md)

# VariableBase

[jvm]\
interface [VariableBase](index.md) : [Named](../-named/index.md), [Typed](../-typed/index.md)

Base variable manipulation.

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [jvm]<br>interface [Builder](-builder/index.md)<out [T](-builder/index.md) : [VariableBase](index.md), [S](-builder/index.md) : [VariableBase.Builder](-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)>> : [Named.Builder](../-named/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> , [Typed.Builder](../-typed/-builder/index.md)<[T](-builder/index.md), [S](-builder/index.md)> |

## Functions

| Name | Summary |
|---|---|
| [access](access.md) | [jvm]<br>open fun [access](access.md)(): [VariableAccess](../-variable-access/index.md)<br>Creates access to the variable that this instance represents. |
| [builder](builder.md) | [jvm]<br>abstract override fun [builder](builder.md)(): [VariableBase.Builder](-builder/index.md)<[VariableBase](index.md), *><br>This builder may or may not accept null values, it depends on implementation. |
| [set](set.md) | [jvm]<br>open fun [set](set.md)(value: [Instruction](../../com.koresframework.kores/-instruction/index.md)): [VariableDefinition](../-variable-definition/index.md)<br>Creates a definition of the value of the variable that this instance represents. |

## Properties

| Name | Summary |
|---|---|
| [name](name.md) | [jvm]<br>abstract override val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Variable name |
| [type](type.md) | [jvm]<br>open override val [type](type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Element type |
| [variableType](variable-type.md) | [jvm]<br>abstract val [variableType](variable-type.md): [Type](https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html)<br>Variable type |

## Inheritors

| Name |
|---|
| [VariableAccess](../-variable-access/index.md) |
| [VariableDeclaration](../-variable-declaration/index.md) |
| [VariableRef](../../com.koresframework.kores.common/-variable-ref/index.md) |
